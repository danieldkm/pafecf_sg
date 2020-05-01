package teste;

/**
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates. All rights reserved.
 * Use is subject to license terms.
 */
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * A sample in which a node pauses over a given time.
 *
 * @related animation/transitions/FadeTransition
 * @related animation/transitions/FillTransition
 * @related animation/transitions/ParallelTransition
 * @related animation/transitions/PathTransition
 * @related animation/transitions/RotateTransition
 * @related animation/transitions/ScaleTransition
 * @related animation/transitions/SequentialTransition
 * @related animation/transitions/StrokeTransition
 * @related animation/transitions/TranslateTransition
 * @see javafx.animation.PauseTransition
 * @see javafx.animation.PauseTransitionBuilder
 * @see javafx.animation.Transition
 */
public class PauseTransitionSample extends Application {

    private Animation animation;

    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 400, 150));
        // create rectangle
        Rectangle rect = new Rectangle(-25, -25, 50, 50);
        rect.setArcHeight(15);
        rect.setArcWidth(15);
        rect.setFill(Color.CRIMSON);
        rect.setTranslateX(50);
        rect.setTranslateY(75);
        root.getChildren().add(rect);

        animation = SequentialTransitionBuilder.create()
                .node(rect)
                .children(
                        TranslateTransitionBuilder.create()
                        .duration(Duration.seconds(2))
                        .fromX(50)
                        .toX(200)
                        .build(),
                        PauseTransitionBuilder.create()
                        .duration(Duration.seconds(2))
                        .build(),
                        TranslateTransitionBuilder.create()
                        .duration(Duration.seconds(2))
                        .fromX(200)
                        .toX(350)
                        .build()
                )
                .cycleCount(Timeline.INDEFINITE)
                .autoReverse(true)
                .build();
    }

    public void play() {
        animation.play();
    }

    @Override
    public void stop() {
        animation.stop();
    }

    public double getSampleWidth() {
        return 400;
    }

    public double getSampleHeight() {
        return 150;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
        play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
