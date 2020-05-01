package view.controller;

import banco.entity.Jogador;
import controller.Controle;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jfxtras.labs.scene.control.CalendarTextField;
import jfxtras.labs.scene.control.CalendarTimeTextField;

public class InicialController extends Application implements Initializable {

    private static Controle controle = new Controle();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instanciarBotaoMenu();
        pane1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (controle.getQtdClique() == 0) {
                    controle.setQtdClique(controle.getQtdClique() + 1);
                    controle.criarAnimacaoRet2(2000, pos2, pane2);
                    controle.playRet2();
                    controle.criarAnimacaoRet3(2000, pos3, pane3);
                    controle.playRet3();
                    controle.criarScaleRet1(pane1);
                    controle.playScaleRet1();
                    isPane1 = true;
                    isPane2 = false;
                    isPane3 = false;
                    aguardeExecute("pane1");
                }
            }
        });
        pane2.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                if (controle.getQtdClique() == 0) {
                    controle.setQtdClique(controle.getQtdClique() + 1);
                    controle.criarAnimacaoRet1(-2000, pos1, pane1);
                    controle.playRet1();
                    controle.criarAnimacaoRet3(2000, pos3, pane3);
                    controle.playRet3();
                    controle.criarScaleRet2(pane2);
                    controle.playScaleRet2();
                    isPane1 = false;
                    isPane2 = true;
                    isPane3 = false;
                    aguardeExecute("pane2");
                }
            }
        });

        pane3.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                if (controle.getQtdClique() == 0) {
                    controle.setQtdClique(controle.getQtdClique() + 1);
                    controle.criarAnimacaoRet1(-2000, pos1, pane1);
                    controle.playRet1();
                    controle.criarAnimacaoRet2(-2000, pos2, pane2);
                    controle.playRet2();
                    controle.criarScaleRet3(pane3);
                    controle.playScaleRet3();
                    isPane1 = false;
                    isPane2 = false;
                    isPane3 = true;
                    aguardeExecute("pane3");
                }
            }
        });

        resetarPanesEscolherJogador();
        System.out.println("finaliza initialize");
    }

    @FXML
    private AnchorPane mainIncial;
    @FXML
    private static Label lbl1;
    @FXML
    private static Label lbl2;
    @FXML
    private static Label lbl3;
    @FXML
    private static ImageView img;
    @FXML
    private static Rectangle rectAlterarJogador;
    @FXML
    private static Rectangle rectIniciar;
    @FXML
    private static Rectangle rectEscolherFase;
    @FXML
    private static Rectangle rectNovoJogador;
    @FXML
    private static Button btnNovJogadorOK;
    @FXML
    private static TextField txtNovoJogadorNome;
    @FXML
    private static Text lblNovoJogadorNome;
    @FXML
    private static Text lblNovoJogadorTitulo;
    @FXML
    private static Button btn1;
    @FXML
    private static Button btn2;
    @FXML
    private static Button btn3;
    @FXML
    private static Pane pane1;
    @FXML
    private static Pane pane2;
    @FXML
    private static Pane pane3;
    @FXML
    private static Pane paneNovoJogador;
    @FXML
    private static Pane paneMenu;
    @FXML
    private static Pane paneIniciar;
    @FXML
    private static Pane paneDataHora;
    @FXML
    private static TextArea txtAreaCupom;
    @FXML
    private static Button btnLigaDesliga;
    @FXML
    private static Label lblStatus;
    @FXML
    private static Circle btnIntervencao;
    @FXML
    private static ImageView imgVECF;
    @FXML
    private static HBox hbDataECF;
    @FXML
    private static HBox hbData;
    @FXML
    private static Button btnDHSalvar;
    @FXML
    private static Rectangle servidor;
    @FXML
    private static Pane paneTest;

    private String salvoEm; // contém o nome do painel ou ordem do painel
    private static Stage stage;
    private static int pos1, pos2, pos3, qtdCaracteresPane = 10;
//    private static int qtdClique = 0;
    private static Jogador jogadorSelecionado, jogador1, jogador2, jogador3;
    private static boolean isPane1 = false, isPane2 = false, isPane3 = false;
    private static boolean isLigado = false;
    private static boolean isIntervencao = false;
    public static boolean isServidorLigado = true;
    private static Image imgECFLigado = new Image("/img/ECFLigado.png");
    private static Image imgECFDesligado = new Image("/img/ECFDesligado.png");
    private static Image imgECFLigado2 = new Image("/img/ECFLigado2.png");
    private static Image imgECFDesligado2 = new Image("/img/ECFDesligado2.png");
    private static CalendarTextField data = new CalendarTextField();
    private static CalendarTimeTextField hora = new CalendarTimeTextField();
    private static CalendarTextField dataECF = new CalendarTextField();
    private static CalendarTimeTextField horaECF = new CalendarTimeTextField();
    private static Calendar c = Calendar.getInstance();

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        mainIncial = FXMLLoader.load(InicialController.class.getResource("/view/Inicial.fxml"));
        Group g = new Group(mainIncial);
        Scene s = new Scene(g);
        s.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent k) {
                if (k.getCode() == k.getCode().ESCAPE) {
                    Platform.exit();
                    stage.close();
                }
            }
        });
        stage.setScene(s);
        stage.setTitle("Simulador SG - PAF-ECF");
        stage.setResizable(false);
//        stage.titleProperty().bind(
//                s.widthProperty().asString().
//                concat(" : ").
//                concat(s.heightProperty().asString()
//                )
//        );
//        stage.minWidthProperty().bind(s.heightProperty().multiply(4));
//        stage.minHeightProperty().bind(s.widthProperty().multiply(3));
        imgVECF.setImage(imgECFLigado);
        stage.show();
//        stage.initStyle(StageStyle.UNDECORATED);
//        stage.setFullScreen(true);
        img.setFitHeight(stage.getHeight());
        img.setFitWidth(stage.getWidth());
        img.setLayoutX(0);
        img.setLayoutY(0);
        System.out.println("largura " + stage.getWidth());
        System.out.println("altura " + stage.getHeight());
//            stage.toFront();
//        stage.getIcons().add(new Image("/Imagem/iconePAFECF.png"));
        stage.setOnHidden(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                stage.close();
                Platform.exit();
            }
        });
        setButtonVisible();
        setLayoutPanes();
        iniciarAnimacaoEscolhaJogador();
        controle.criarAnimacaoTest(1000, 0, paneTest);
        
        System.out.println("finaliza start");
    }

    /**
     * Verifica cada jogador, se não for nulo, mostra o botão de exclusão
     */
    private void setButtonVisible() {
//        System.out.println("j1 " + jogador1.getNome());
//        System.out.println("j2 " + jogador2.getNome());
//        System.out.println("j3 " + jogador3.getNome());
        if (jogador1 != null) {
            btn1.setVisible(true);
        }
        if (jogador2 != null) {
            btn2.setVisible(true);
        }
        if (jogador3 != null) {
            btn3.setVisible(true);
        }
    }

    /**
     * Ação do botão excluir do Pane1, se a exclusão for bem sucedida, não
     * mostrar o botão excluir, alterar o conteudo do label para Novo jogador
     * (vazio) e atribuir falso no isPane1. Essa ação remete no mesmo para o
     * btn2 e btn3
     */
    @FXML
    private void setOnActionBtn1() {
        if (controle.removerJogador(jogador1, "Erro: ao tentar remover um jogador. Metodo: setOnActionBtn1. Classe: InicialController")) {
            btn1.setVisible(false);
            lbl1.setText("Novo Jogador");
            isPane1 = false;
        }
    }

    @FXML
    private void setOnActionBtn2() {
        if (controle.removerJogador(jogador2, "Erro: ao tentar remover um jogador. Metodo: setOnActionBtn2. Classe: InicialController")) {
            btn2.setVisible(false);
            lbl2.setText("Novo Jogador");
            isPane2 = false;
        }
    }

    @FXML
    private void setOnActionBtn3() {
        if (controle.removerJogador(jogador3, "Erro: ao tentar remover um jogador. Metodo: setOnActionBtn3. Classe: InicialController")) {
            btn3.setVisible(false);
            lbl3.setText("Novo Jogador");
            isPane3 = false;
        }
    }

    /**
     * Chama o metodo opacityPane para dar transparencia nos panes e ativa as
     * animações para cada pane (pane1, pane2 e pane3)
     */
    private void iniciarAnimacaoEscolhaJogador() {
        opacityPane(0.95);
        controle.criarAnimacaoRet1(pos1, 0, pane1);
        controle.playRet1();
        controle.criarAnimacaoRet2(pos2, 0, pane2);
        controle.playRet2();
        controle.criarAnimacaoRet3(pos3, 0, pane3);
        controle.playRet3();
    }

    /**
     * setar transparencia nos panes
     */
    private void opacityPane(double n) {
        pane1.setOpacity(n);
        pane2.setOpacity(n);
        pane3.setOpacity(n);
    }

    /**
     * Seta a posição dos panes e atribui o valor em que deve ficar os pane
     * diferente valor para cada pos
     */
    private void setLayoutPanes() {
        System.out.println("Centro da tela " + (stage.getHeight() - (pane1.getHeight() + (pane1.getHeight() * 0.5))) * 0.5);
        double posicaoY = (stage.getHeight() - (pane1.getHeight() + (pane1.getHeight() * 0.5))) * 0.5;
        pane1.setLayoutY(posicaoY);
        pane2.setLayoutY(posicaoY);
        pane3.setLayoutY(posicaoY);
        pos1 = (int) ((stage.getWidth() * 0.3) - (pane1.getWidth() * 0.15));
        pos2 = (int) ((stage.getWidth() * 0.6) - (pane2.getWidth() * 0.15));
        pos3 = (int) ((stage.getWidth() * 0.9) - (pane3.getWidth() * 0.15));
        System.out.println("posi 1 " + pos1);
        System.out.println("posi 2 " + pos2);
        System.out.println("posi 3 " + pos3);
    }

    /**
     * Verifica qual painel foi selecionado e logo em seguida verifica se o
     * conteudo do label é igual a Novo Jogador caso seja retorna verdadeiro
     *
     * @return true se antender pelo menos duas condições sequencial se não
     * false.
     */
    private boolean isNovoUsuario() {
        if (isPane1) {
            if (lbl1.getText().equals("Novo Jogador")) {
                return true;
            }
        } else if (isPane2) {
            if (lbl2.getText().equals("Novo Jogador")) {
                return true;
            }
        } else if (isPane3) {
            if (lbl3.getText().equals("Novo Jogador")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Seta um Action para cada botão do menu
     */
    private void instanciarBotaoMenu() {
        rectAlterarJogador.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
//                System.out.println("qtd clique " + qtdClique);
                if (controle.getQtdClique() == 0) {
                    controle.setQtdClique(controle.getQtdClique() + 1);
                    iniciarTelaMenu((int) (stage.getHeight() * 0.5), -318);
                    iniciarAnimacaoEscolhaJogador();
                }
            }
        });

        rectEscolherFase.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (controle.getQtdClique() == 0) {
                    controle.setQtdClique(controle.getQtdClique() + 1);
                }
            }
        });

        rectIniciar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                if (controle.getQtdClique() == 0) {
                    controle.setQtdClique(controle.getQtdClique() + 1);
                    iniciarTelaMenu((int) (stage.getHeight() * 0.5), -318);
                    iniciarTelaInicial(-570, 570);

                }
            }
        });
    }

    public static void setStylesTelaInicial() {
        System.out.println("setando a ECF");
        lblStatus.setText("Normal");
        isLigado = createEffectInnerShadowBtnLidaDesliga(Color.GREEN);
        txtAreaCupom.setStyle("    -fx-font-family: Courier New;\n"
                //                + "    -fx-highlight-text-fill: #FFFFCC;\n"
                + "    -fx-background-color: #FFFFCC;");

    }

    /**
     * Seta uma action para o botão que salva um novo jogador
     */
    @FXML
    private void setOnActionBtnNovoJogadorOK() {
        try {
            Jogador j = new Jogador();
            j.setNome(txtNovoJogadorNome.getText());
            txtNovoJogadorNome.setText(null);
            j.setSalvoEm(salvoEm);
            controle.saveJogador(j, "Erro: ao tentar salvar um novo jogador. Metodo: setOnActionBtnNovoJogadorOK. classe: InicialController");
            setLabelSeNovoJogador();
            resetarPanesEscolherJogador();
            controle.criarAnimacaoPaneNovoJogador((int) (stage.getHeight() * 0.5), -318, paneNovoJogador);
            controle.playNovoJogador();
            iniciarAnimacaoEscolhaJogador();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica qual painel selecionado e exibi o botão de excluir caso e
     * atribui false para o panel para voltar ao padrão
     */
    private void setLabelSeNovoJogador() {
        if (isPane1) {
            btn1.setVisible(true);
            isPane1 = false;
        } else if (isPane2) {
            btn2.setVisible(true);
            isPane2 = false;
        } else if (isPane3) {
            btn3.setVisible(true);
            isPane3 = false;
        }
    }

    private void iniciarTelaNovoJogador() {
        paneNovoJogador.setLayoutX((stage.getWidth() * 0.5) - (paneNovoJogador.getWidth() * 0.5));
        controle.criarAnimacaoPaneNovoJogador(-318, (int) (stage.getHeight() * 0.5), paneNovoJogador);
        controle.playNovoJogador();
    }

    /**
     * @param fromY posição inicial do menu
     * @param toY posição final da transição do menu
     */
    private void iniciarTelaMenu(int fromY, int toY) {
        paneMenu.setLayoutX((stage.getWidth() * 0.5) - (paneMenu.getWidth() * 0.5));
        controle.criarAnimacaoPaneMenu(fromY, toY, paneMenu);
        controle.playMenu();
    }

    private void iniciarTelaInicial(int fromY, int toY) {
//        if (isServidorLigado) {
//            Controle.criarPopUp("Conectar");
//        } else {
//            Controle.criarPopUp("Desconectar");
//        }
        controle.criarAnimacaoPaneIniciar(fromY, toY, paneIniciar);
        controle.playIniciar();
    }

    private void iniciarTelaDataHora(int fromY, int toY) {
        controle.criarAnimacaoPaneDataHora(fromY, toY, paneDataHora);
        controle.playDataHora();
    }

    /**
     * @param lbl painel que será salvo no jogador caso seja jogador novo.
     */
    private void aguardeExecute(final String lbl) {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        //aki começa uma nova aplicação para não ocorrer conflito entre as threads
                        //executa dpois de executar o timer
                        Platform.runLater(new Runnable() {
                            public void run() {
                                if (isNovoUsuario()) {
                                    iniciarTelaNovoJogador();
                                    salvoEm = lbl;
                                } else {
                                    iniciarTelaMenu(-318, (int) (stage.getHeight() * 0.5));
                                }
                            }
                        });
                    }
                },
                1000
        );
    }

    /**
     * Busca do banco todos os jogadores e verifica cada um em que painel ele
     * foi registrado para setar o label e obter o jogador selecionado
     */
    private void resetarPanesEscolherJogador() {
        for (Jogador jogador : Controle.getJogadores()) {
            if (jogador.getSalvoEm().equals("pane1")) {
                if (jogador.getNome().length() > qtdCaracteresPane) {
                    lbl1.setText(jogador.getNome().substring(0, qtdCaracteresPane));
                } else {
                    lbl1.setText(jogador.getNome());
                }
                jogadorSelecionado = jogador;
                jogador1 = jogador;
            } else if (jogador.getSalvoEm().equals("pane2")) {
                if (jogador.getNome().length() > qtdCaracteresPane) {
                    lbl2.setText(jogador.getNome().substring(0, qtdCaracteresPane));
                } else {
                    lbl2.setText(jogador.getNome());
                }
                jogadorSelecionado = jogador;
                jogador2 = jogador;
            } else if (jogador.getSalvoEm().equals("pane3")) {
                if (jogador.getNome().length() > qtdCaracteresPane) {
                    lbl3.setText(jogador.getNome().substring(0, qtdCaracteresPane));
                } else {
                    lbl3.setText(jogador.getNome());
                }
                jogadorSelecionado = jogador;
                jogador3 = jogador;
            }
        }
    }

    private static boolean createEffectInnerShadowBtnLidaDesliga(Color c) {
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setHeight(21);
        innerShadow.setWidth(21);
        innerShadow.setRadius(10);
        innerShadow.setColor(c);
        btnLigaDesliga.setEffect(innerShadow);
        if (isLigado) {
            return false;
        } else {
            return true;
        }
    }

    @FXML
    private void setOnActionBtnLigaDesliga() {
        if (isLigado) {
            isLigado = createEffectInnerShadowBtnLidaDesliga(Color.RED);
            lblStatus.setText("");
//            txtAreaCupom.setText(txtAreaCupom.getText());
        } else {
            isLigado = createEffectInnerShadowBtnLidaDesliga(Color.GREEN);
            if (isIntervencao) {
                lblStatus.setText("Em intervenção técnica");
                btnLigaDesliga.setDisable(true);
                iniciarTelaDataHora(-500, 500);
                txtAreaCupom.setText(txtAreaCupom.getText() + "Em intervenção\n");
            } else {
                lblStatus.setText("Normal");
                txtAreaCupom.setText(txtAreaCupom.getText() + "saida de intervenção\n");
            }
        }
    }

    @FXML
    private void setOnMouseClickedBtnIntervencao() {
        if (!isLigado) {
            if (isIntervencao) {
                isIntervencao = false;
                setImgPanieInicial();
            } else {
                isIntervencao = true;
                setImgPanieInicial();
            }
        }
    }

    public static void setDataHora() {
        if (controle.getQtdClique() == 0) {
            controle.setQtdClique(controle.getQtdClique() + 1);
            hbDataECF.getChildren().clear();
            dataECF.setPrefWidth(200);
            dataECF.valueProperty().set(c);
            horaECF.setValue(c);
            horaECF.setShowLabels(false);
            hbDataECF.getChildren().addAll(dataECF, horaECF);
            dataECF.setDisable(true);
            horaECF.setDisable(true);
            hbData.getChildren().clear();
            data.setPrefWidth(200);
            data.valueProperty().set(c);
            hora.setValue(c);
            hora.setShowLabels(false);
            hbData.getChildren().addAll(data, hora);
        }
    }

    @FXML
    private void setOnActionBtnDHSalvar() {
        System.out.println("compara data e hora com a da ECF");
        btnLigaDesliga.setDisable(false);
        iniciarTelaDataHora(570, -500);
        System.out.println("data " + data.getValue());
        System.out.println("data ecfg " + dataECF.getValue());
        if (dataECF.getValue().before(data.getValue())) {
            dataECF.setValue(data.getValue());
            horaECF.setValue(hora.getValue());
        }
    }

    @FXML
    private void setOnMouseClikedServidor(MouseEvent m) {
        System.out.println("X " + m.getScreenX());
        System.out.println("Y " + m.getScreenY());
        Controle.popUp = new ContextMenu();
        if (isServidorLigado) {
            Controle.criarPopUp("Desconectar");
        } else {
            Controle.criarPopUp("Conectar");
        }
        Controle.popUp.show(servidor, m.getScreenX(), m.getScreenY());
    }

    @FXML
    private void setOnMouseClickedPaneInicial(MouseEvent m) {
//        Controle.popUp.hide();
    }

    public static void setImgPanieInicial() {
        if (!isIntervencao) {
            if (isServidorLigado) {
                // verde sem X
                imgVECF.setImage(imgECFLigado);
            } else {
                // verde com X
                imgVECF.setImage(imgECFLigado2);
            }
        } else {
            if (isServidorLigado) {
                // vermelho sem X
                imgVECF.setImage(imgECFDesligado);
            } else {
                //vermelho com X
                imgVECF.setImage(imgECFDesligado2);
            }
        }
    }

    @FXML
    private void setOnActionBtnRetornar() {
        iniciarTelaInicial(570, -570);
        iniciarTelaMenu(-318, (int) (stage.getHeight() * 0.5));
    }
}
