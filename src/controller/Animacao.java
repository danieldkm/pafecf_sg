package controller;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.FadeTransitionBuilder;
import javafx.animation.ScaleTransition;
import javafx.animation.ScaleTransitionBuilder;
import javafx.animation.SequentialTransitionBuilder;
import javafx.animation.TranslateTransitionBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.controller.InicialController;

public class Animacao extends Application {

    protected static Animation animation1;
    protected static Animation animation2;
    protected static Animation animation3;
    protected static Animation animationNovoJogador;
    protected static Animation animationMenu;
    protected static Animation animationIniciar;
    protected static Animation animationDataHora;

    protected static int qtdClique = 0;

    public void criarAnimacaoRet1(int toX, int fromX, Pane pane) {
        animation1 = SequentialTransitionBuilder.create()
                .node(pane)
                .children(
                        TranslateTransitionBuilder.create()
                        .duration(Duration.seconds(1))
                        .fromX(fromX)
                        .toX(toX)
                        .onFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                stop1();
                            }
                        })
                        .build()
                /*,
                        
                 PauseTransitionBuilder.create()
                 .duration(Duration.seconds(2))
                 .build(),
                 TranslateTransitionBuilder.create()
                 .duration(Duration.seconds(2))
                 .fromX(200)
                 .toX(350)
                 .build()*/
                )
                //                .cycleCount(Timeline.INDEFINITE)
                //                .autoReverse(true)
                .build();
    }

    public void criarAnimacaoRet2(int toX, int fromX, Pane pane) {
        animation2 = SequentialTransitionBuilder.create()
                .node(pane)
                .children(
                        TranslateTransitionBuilder.create()
                        .duration(Duration.seconds(1))
                        .fromX(fromX)
                        .toX(toX)
                        .onFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                stop2();
                            }
                        })
                        .build()
                )
                .build();
    }

    public void criarAnimacaoRet3(int toX, int fromX, Pane pane) {
        animation3 = SequentialTransitionBuilder.create()
                .node(pane)
                .children(
                        TranslateTransitionBuilder.create()
                        .duration(Duration.seconds(1))
                        .fromX(fromX)
                        .toX(toX)
                        .onFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                stop3();
                            }
                        })
                        .build()
                )
                //                .cycleCount(Timeline.INDEFINITE)
                //                .autoReverse(true)
                .build();
    }

    @Override
    public void start(Stage stage) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void playRet1() {
        animation1.play();
    }

    public void stop1() {
        animation1.stop();
    }

    public void playRet2() {
        animation2.play();
    }

    public void stop2() {
        animation2.stop();
    }

    public void playRet3() {
        animation3.play();
    }

    public void stop3() {
        animation3.stop();
    }

    /**
     * TODO --- Inicio Scale Transition
     */
    protected ScaleTransition scaleTransition1;
    protected ScaleTransition scaleTransition2;
    protected ScaleTransition scaleTransition3;

    public void criarScaleRet1(final Pane pane) {
        scaleTransition1 = ScaleTransitionBuilder.create()
                .node(pane)
                .duration(Duration.seconds(0.5))
                .toX(1.2)
                .toY(1.2)
                .autoReverse(true)
                .cycleCount(2)
                .onFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
//                        System.out.println("stop scale");
                        stopScaleRet1();
                        criarFadeRet1(pane);
                        playFadeRet1();
                    }
                })
                .build();
    }

    public void criarScaleRet2(final Pane pane) {
        scaleTransition2 = ScaleTransitionBuilder.create()
                .node(pane)
                .duration(Duration.seconds(0.5))
                .toX(1.2)
                .toY(1.2)
                .autoReverse(true)
                .cycleCount(2)
                .onFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        stopScaleRet2();
                        criarFadeRet2(pane);
                        playFadeRet2();
                    }
                })
                .build();
    }

    public void criarScaleRet3(final Pane pane) {
        scaleTransition3 = ScaleTransitionBuilder.create()
                .node(pane)
                .duration(Duration.seconds(0.5))
                .toX(1.2)
                .toY(1.2)
                .autoReverse(true)
                .cycleCount(2)
                .onFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        stopScaleRet3();
                        criarFadeRet3(pane);
                        playFadeRet3();
                    }
                })
                .build();
    }

    public void playScaleRet1() {
        scaleTransition1.play();
    }

    public void stopScaleRet1() {
        scaleTransition1.stop();
    }

    public void playScaleRet2() {
        scaleTransition2.play();
    }

    public void stopScaleRet2() {
        scaleTransition2.stop();
    }

    public void playScaleRet3() {
        scaleTransition3.play();
    }

    public void stopScaleRet3() {
        scaleTransition3.stop();
    }

    /**
     * TODO --- Inicio Fade Transition
     */
    protected FadeTransition fadeTransition1;
    protected FadeTransition fadeTransition2;
    protected FadeTransition fadeTransition3;

    protected void criarFadeRet1(final Pane pane) {
        fadeTransition1 = FadeTransitionBuilder.create()
                .duration(Duration.seconds(0.5))
                .node(pane)
                .fromValue(1)
                .toValue(0.2)
                .onFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
//                        System.out.println("stop fade");
                        stopFadeRet1();
                        pane.setOpacity(0);
                        criarAnimacaoRet1(-200, 0, pane);
                        playRet1();
                    }
                })
                .build();
    }

    public void criarFadeRet2(final Pane pane) {
        fadeTransition2 = FadeTransitionBuilder.create()
                .duration(Duration.seconds(1))
                .node(pane)
                .fromValue(1)
                .toValue(0.2)
                .onFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        stopFadeRet2();
                        pane.setOpacity(0);
                        criarAnimacaoRet2(200, 0, pane);
                        playRet2();
                    }
                })
                .build();
    }

    public void criarFadeRet3(final Pane pane) {
        fadeTransition3 = FadeTransitionBuilder.create()
                .duration(Duration.seconds(1))
                .node(pane)
                .fromValue(1)
                .toValue(0.2)
                .onFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        stopFadeRet3();
                        pane.setOpacity(0);
                        criarAnimacaoRet3(200, 0, pane);
                        playRet3();
                    }
                })
                .build();
    }

    public void playFadeRet1() {
        fadeTransition1.play();
    }

    public void stopFadeRet1() {
        fadeTransition1.stop();
    }

    public void playFadeRet2() {
        fadeTransition2.play();
    }

    public void stopFadeRet2() {
        fadeTransition2.stop();
    }

    public void playFadeRet3() {
        fadeTransition3.play();
    }

    public void stopFadeRet3() {
        fadeTransition3.stop();
    }

    public void criarAnimacaoPaneNovoJogador(int fromY, int toY, Pane pane) {
        animationNovoJogador = SequentialTransitionBuilder.create()
                .node(pane)
                .children(
                        TranslateTransitionBuilder.create()
                        .duration(Duration.seconds(2))
                        .fromY(fromY)
                        .toY(toY)
                        .onFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                stopNovoJogador();
                                qtdClique = 0;
                            }
                        })
                        .build()
                )
                //                .cycleCount(Timeline.INDEFINITE)
                //                .autoReverse(true)
                .build();
    }

    public void playNovoJogador() {
        animationNovoJogador.play();
    }

    public void stopNovoJogador() {
        animationNovoJogador.stop();
    }

    public void criarAnimacaoPaneMenu(int fromY, int toY, Pane pane) {
        animationMenu = SequentialTransitionBuilder.create()
                .node(pane)
                .children(
                        TranslateTransitionBuilder.create()
                        .duration(Duration.seconds(2))
                        .fromY(fromY)
                        .toY(toY)
                        //                        .build(),
                        //                        TranslateTransitionBuilder.create()
                        //                        .duration(Duration.seconds(2))
                        //                        .fromY(toY)
                        //                        .toY(toY - 25)
                        .onFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                stopMenu();
                                qtdClique = 0;
                            }
                        })
                        .build()
                )
                .build();
    }

    public void playMenu() {
        animationMenu.play();
    }

    public void stopMenu() {
        animationMenu.stop();
    }

    public void criarAnimacaoPaneIniciar(int fromY, int toY, Pane pane) {
        animationIniciar = SequentialTransitionBuilder.create()
                .node(pane)
                .children(
                        TranslateTransitionBuilder.create()
                        .duration(Duration.seconds(3))
                        .fromY(fromY)
                        .toY(toY)
                        .onFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                stopIniciar();
                                qtdClique = 0;
                                System.out.println("finalizando efeito inicial da tela inicial");
                                InicialController.setStylesTelaInicial();
                            }
                        })
                        .build()
                )
                .build();
    }

    public void playIniciar() {
        animationIniciar.play();
    }

    public void stopIniciar() {
        animationIniciar.stop();
    }

    public void criarAnimacaoPaneDataHora(int fromY, int toY, Pane pane) {
        animationDataHora = SequentialTransitionBuilder.create()
                .node(pane)
                .children(
                        TranslateTransitionBuilder.create()
                        .duration(Duration.seconds(2))
                        .fromY(fromY)
                        .toY(toY)
                        .onFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                stopDataHora();
                                // ---------
                                InicialController.setDataHora();
                            }
                        })
                        .build()
                )
                .build();
    }

    public void playDataHora() {
        animationDataHora.play();
    }

    public void stopDataHora() {
        animationDataHora.stop();
    }

    protected static Animation animationTest;

    public void criarAnimacaoTest(int toX, int fromX, Pane pane) {
        animationTest = SequentialTransitionBuilder.create()
                .node(pane)
                .children(
                        TranslateTransitionBuilder.create()
                        .duration(Duration.seconds(2))
                        .fromX(fromX)
                        .toX(toX)
                        .onFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent t) {
                                stop2();
                            }
                        })
                        .build()
                )
                .build();
    }
    
       public void playTest() {
        animationTest.play();
    }

    public void stopTest() {
        animationTest.stop();
    }
    

    public static Animation getAnimation1() {
        return animation1;
    }

    public static void setAnimation1(Animation animation1) {
        Animacao.animation1 = animation1;
    }

    public static Animation getAnimation2() {
        return animation2;
    }

    public static void setAnimation2(Animation animation2) {
        Animacao.animation2 = animation2;
    }

    public static Animation getAnimation3() {
        return animation3;
    }

    public static void setAnimation3(Animation animation3) {
        Animacao.animation3 = animation3;
    }

    public static Animation getAnimationNovoJogador() {
        return animationNovoJogador;
    }

    public static void setAnimationNovoJogador(Animation animationNovoJogador) {
        Animacao.animationNovoJogador = animationNovoJogador;
    }

    public static Animation getAnimationMenu() {
        return animationMenu;
    }

    public static void setAnimationMenu(Animation animationMenu) {
        Animacao.animationMenu = animationMenu;
    }

    public static int getQtdClique() {
        return qtdClique;
    }

    public static void setQtdClique(int qtdClique) {
        Animacao.qtdClique = qtdClique;
    }

    public ScaleTransition getScaleTransition1() {
        return scaleTransition1;
    }

    public void setScaleTransition1(ScaleTransition scaleTransition1) {
        this.scaleTransition1 = scaleTransition1;
    }

    public ScaleTransition getScaleTransition2() {
        return scaleTransition2;
    }

    public void setScaleTransition2(ScaleTransition scaleTransition2) {
        this.scaleTransition2 = scaleTransition2;
    }

    public ScaleTransition getScaleTransition3() {
        return scaleTransition3;
    }

    public void setScaleTransition3(ScaleTransition scaleTransition3) {
        this.scaleTransition3 = scaleTransition3;
    }

    public FadeTransition getFadeTransition1() {
        return fadeTransition1;
    }

    public void setFadeTransition1(FadeTransition fadeTransition1) {
        this.fadeTransition1 = fadeTransition1;
    }

    public FadeTransition getFadeTransition2() {
        return fadeTransition2;
    }

    public void setFadeTransition2(FadeTransition fadeTransition2) {
        this.fadeTransition2 = fadeTransition2;
    }

    public FadeTransition getFadeTransition3() {
        return fadeTransition3;
    }

    public void setFadeTransition3(FadeTransition fadeTransition3) {
        this.fadeTransition3 = fadeTransition3;
    }

}
