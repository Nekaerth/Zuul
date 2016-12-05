/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author niklasbruun
 */
public class AlertBox {

    public static void isCode() {
        Stage window = new Stage();
        window.initModality(Modality.NONE);
        window.setTitle("Test");
        window.setMinWidth(400);
        window.setMinHeight(400);

        Label label = new Label();
        label.setText("test Label");
        Button enterButton = new Button("Enter");
        enterButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.close();
            }
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, enterButton);
        layout.setAlignment(Pos.CENTER);

        Scene alertBox = new Scene(layout);
        window.setScene(alertBox);
        window.showAndWait();
    }

}
