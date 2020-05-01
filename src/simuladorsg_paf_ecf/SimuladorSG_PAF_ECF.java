/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorsg_paf_ecf;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author npi
 */
public class SimuladorSG_PAF_ECF extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();

        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(4);
        innerShadow.setOffsetY(4);
        innerShadow.setColor(Color.web("0x3b596d"));

        Text text = new Text();
        text.setEffect(innerShadow);
        text.setX(20);
        text.setY(100);
        text.setText("InnerShadow");
        text.setFill(Color.ALICEBLUE);
        text.setFont(Font.font(null, FontWeight.BOLD, 50));

        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: null;");
        root.setPadding(new javafx.geometry.Insets(1));

        DoubleProperty doubleProperty = new SimpleDoubleProperty(0);

        Region region = new Region();
        region.styleProperty().bind(Bindings
                .concat("-fx-background-radius:20; -fx-background-color: rgba(56, 176, 209, ")
                .concat(doubleProperty)
                .concat(");"));
        region.setEffect(new DropShadow(10, Color.GREY));

        Slider slider = new Slider(0, 1, .3);
        doubleProperty.bind(slider.valueProperty());

        root.getChildren().addAll(region, slider, text);

        stage.initStyle(StageStyle.TRANSPARENT);
        Scene scene = new Scene(root, 300, 250);
        scene.setFill(Color.TRANSPARENT);

        stage.setTitle("Hello World!");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
