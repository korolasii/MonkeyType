package org.monkeytype.monkeytype;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.monkeytype.monkeytype.Controllers.Controller;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        ((Controller) fxmlLoader.getController()).setScene(scene);
        ((Controller) fxmlLoader.getController()).setupUI();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}