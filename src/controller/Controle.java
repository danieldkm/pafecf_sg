package controller;

import JsonManipulate.Storage;
import banco.entity.Jogador;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItemBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import view.controller.InicialController;

public class Controle extends Animacao {

    private static String nomeWrapper = "???";

    public static void salvarArquivo(String documento, String file) {
        File exeFile = new File("");
        File path = new File(exeFile.getAbsolutePath() + file);
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.println(
                    "<?xml version=\"1.0\" encoding=\"windows-1252\"?>"
            );
            writer.println(documento);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retorna uma lista com todos os jogadores do BD
     */
    public static ObservableList<Jogador> getJogadores() {
        ObservableList<Jogador> list = FXCollections.observableArrayList();
        try {
            Storage cs = new Storage(Jogador.class);
            nomeWrapper = "jogador";
            JSONArray a = cs.readJson(nomeWrapper);
            JSONObject o = null;
            for (int i = 0; i < a.length(); i++) {
                o = a.getJSONObject(i);
                Jogador j = new Jogador();
                j.setIdJogador(o.getInt("idJogador"));
                j.setNome(o.getString("nome"));
                j.setSalvoEm(o.getString("salvoEm"));
                list.add(j);
//                System.out.println("nome " + j.getNome());
//                System.out.println("salvoEm " + j.getSalvoEm());
//                System.out.println("id " + j.getIdJogador());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;

//        JogadorDAO jogadorDAO = new JogadorDAOImpl();
//        List<Jogador> listaJogadoresCadastrados = jogadorDAO.getAll(Jogador.class);
//        ObservableList<Jogador> list = FXCollections.observableArrayList();;
//        for (Jogador j : listaJogadoresCadastrados) {
//            list.add(j);
//        }
//        return list;
    }

    /**
     * Remover um jogador
     *
     * @param jogador jogador que será removido, deve ter um ID
     * @param message printa na saído do console a mensagem de erro, caso ter.
     */
    public static boolean removerJogador(Jogador jogador, String message) {
        try {
            Storage cs = new Storage(Jogador.class);
            nomeWrapper = "jogador";
            JSONArray a = cs.readJson(nomeWrapper);
            JSONArray temp = new JSONArray();
            JSONObject o = null;
            for (int i = 0; i < a.length(); i++) {
                o = a.getJSONObject(i);
                if (!o.get("nome").equals(jogador.getNome())) {
                    temp.put(o);
                }
            }
            cs.saveArrayInJson(temp, nomeWrapper);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        
        return true;
        
        
//        try {
//            JogadorDAO jogadorDAO = new JogadorDAOImpl();
//            Jogador jo = jogadorDAO.getEntityManager().find(Jogador.class, jogador.getIdJogador());
//            jogadorDAO.remove(jo);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(message);
//            return false;
//        }
//        return true;
    }

    /**
     * Salva um jogador
     *
     * @param jogador que será salvo no BD
     * @param message mensagem que será exibido caso tiver um erro
     */
    public static boolean saveJogador(Jogador jogador, String message) {
        Storage s = new Storage(Jogador.class);
        nomeWrapper = "jogador";
        try {

            int r = s.readAutoIncrement(nomeWrapper);
            jogador.setIdJogador(r);
            s.writeJson(jogador, nomeWrapper);
            s.writeAutoIncrement(nomeWrapper, ++r);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;

//        try {
//            JogadorDAO jogadorDAO = new JogadorDAOImpl();
//            jogadorDAO.save(jogador);
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(message);
//            return false;
//        }
//        return true;
    }

    public static ContextMenu popUp;

    public static void criarPopUp(String texto) {
        try {
            popUp.getItems().addAll(
                    MenuItemBuilder.create()
                    .text(texto)
                    //                .graphic(createIcon(...))
                    .onAction(new EventHandler() {
                        @Override
                        public void handle(Event t) {
                            if (InicialController.isServidorLigado) {
                                InicialController.isServidorLigado = false;
                                InicialController.setImgPanieInicial();
                            } else {
                                InicialController.isServidorLigado = true;
                                InicialController.setImgPanieInicial();
                            }

                            popUp.hide();
                        }
                    })
                    //                    build(),
                    //                    SeparatorMenuItemBuilder.create().build(),
                    //                    MenuItemBuilder.create()
                    //                    .text("Reagendar")
                    //                    .onAction(new EventHandler() {
                    //                        @Override
                    //                        public void handle(Event t) {
                    //                        }
                    //                    })
                    //                    .build(),
                    //                    /*.graphic(createIcon())*/
                    //                    SeparatorMenuItemBuilder.create().build(),
                    //                    MenuItemBuilder.create()
                    //                    .text("Atualizar Agenda")
                    //                    .onAction(new EventHandler() {
                    //
                    //                        @Override
                    //                        public void handle(Event t) {
                    //                        }
                    //                    }).build(),
                    //                    SeparatorMenuItemBuilder.create().build(),
                    //                    MenuItemBuilder.create()
                    //                    .text("Cancelar Agendamento")
                    //                    .onAction(new EventHandler() {
                    //                        @Override
                    //                        public void handle(Event t) {
                    //                        }
                    //                    })
                    .build()
            );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro!! Classe: Controle.class  Metodo: criarPopUp");
        }
    }
}
