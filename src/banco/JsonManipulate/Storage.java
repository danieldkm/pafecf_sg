package JsonManipulate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Field;
import org.json.JSONArray;
import org.json.JSONObject;

public class Storage<Type> {

    Class<Type> type;
    private static final String path = "dbJson/";

    public Storage(Class type) {
        this.type = type;
    }

    /**
     * Salva as informacoes de um objeto any em um arquivo json
     *
     * @param any objeto com as informacoes a ser salva
     * @param nomeWrapper nome do objeto que sera salvo na arquivo
     * @throws Exception
     */
    public void writeJson(Object any, String nomeWrapper) throws Exception {
        JSONArray a = readJson(nomeWrapper);
        Field[] f = type.getDeclaredFields();
        JSONObject o = new JSONObject();
        for (int i = 0; i < f.length; i++) {
            f[i].setAccessible(true);
            if (f[i].getType().equals(int.class)) {
                o.put(f[i].getName(), f[i].getInt(any));
            } else {
                o.put(f[i].getName(), f[i].get(any));
            }
            f[i].setAccessible(false);
        }
        a.put(o);
        o = new JSONObject();
        o.put(nomeWrapper, a);
        BufferedWriter buf = new BufferedWriter(new FileWriter(path + type.getSimpleName() + ".json", false));
        buf.write(o.toString());
        buf.flush();
        buf.close();
    }

    public void saveArrayInJson(JSONArray a, String nomeWrapper) throws Exception {
        JSONObject o = new JSONObject();
        o.put(nomeWrapper, a);
        BufferedWriter buf = new BufferedWriter(new FileWriter(path + type.getSimpleName() + ".json", false));
        buf.write(o.toString());
        buf.flush();
        buf.close();
    }

    /**
     * Le um arquivo json
     *
     * @param nomeWrapper tipo do objeto a ser buscado no arquivo
     *
     * @return uma lista dos itens em JSONArray
     * @throws Exception
     */
    public JSONArray readJson(String nomeWrapper) throws Exception {
        BufferedReader buf = new BufferedReader(new FileReader(path + type.getSimpleName() + ".json"));
        String s = "";
        String linha = "";
        while ((linha = buf.readLine()) != null) {
            s += linha + "\n";
        }
        JSONArray abc = new JSONArray();
        if (!s.equals("")) {

            JSONObject json = new JSONObject(s);
            abc = (JSONArray) json.get(nomeWrapper);
        }
        return abc;
    }

    public int readAutoIncrement(String nomeWrapper) throws Exception {
        BufferedReader buf = new BufferedReader(new FileReader(path + "auto_increment.txt"));
        String linha = "";
        while ((linha = buf.readLine()) != null) {
            if (linha.startsWith(nomeWrapper)) {
                break;
            }
        }
        String[] linhas = linha.split(":");
        int r = Integer.parseInt(linhas[1]);
        return r;
    }

    public String readContentAutoIncrement() throws Exception {
        BufferedReader buf = new BufferedReader(new FileReader(path + "auto_increment.txt"));
        String s = "";
        String linha = "";
        while ((linha = buf.readLine()) != null) {
            s += linha + "\n";
        }
        return s;
    }

    public void writeAutoIncrement(String nomeWrapper, int newValue) throws Exception {
        String c = readContentAutoIncrement();
        BufferedWriter buf = new BufferedWriter(new FileWriter(path + "auto_increment.txt", false));
        String result = "";
        int i = c.indexOf(nomeWrapper);
        String nV = String.valueOf(newValue);
        int tam = nV.length();
        System.out.println("newValue: " + newValue);
        if ((newValue == 10) || (newValue == 100) || (newValue == 1000) || (newValue == 10000)) {
            result = c.substring(0, i + nomeWrapper.length() + 1) + nV + "\r\n"
                    + c.substring(i + nomeWrapper.length() + tam, c.length() - 1);
        } else {
            result = c.substring(0, i + nomeWrapper.length() + 1) + nV + "\r\n"
                    + c.substring(i + nomeWrapper.length() + tam + 1, c.length() - 1);
        }
        buf.write(result);
        buf.flush();
        buf.close();
    }
}
