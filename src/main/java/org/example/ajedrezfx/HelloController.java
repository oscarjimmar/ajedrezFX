package org.example.ajedrezfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private GridPane mainGrid;
    @FXML
    private Label welcomeText;
    public void pintarTablero() {
        Pane pane;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                pane=new Pane();
                if (j % 2 == 0 && i % 2 == 0 || j % 2 != 0 && i % 2 != 0) {
                    pane.setStyle("-fx-background-color: #684714;");
                    //pane.getChildren().add(new ImageView(new Image(getClass().getResourceAsStream("imagenes/CaballoBlanco.png"))));
                } else {
                    pane.setStyle("-fx-background-color: #ffe68e");

                }



                mainGrid.add(pane, j, i);
                String message = "Click on cell ["+i+", "+j+"]";
                int fila = i;
                int columna = j;
                pane.setOnMouseClicked(e -> {
                    System.out.println(message);
                    //accion(envio);

                });
            }
            System.out.println();
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pintarTablero();
    }
}