package org.monkeytype.monkeytype.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Controller{
    private static String str = "";

    @FXML
    public TextFlow text;

    @FXML
    public javafx.scene.layout.VBox VBox;

    private Scene scene;

    private int i = -1;

    public Controller(){
        str = WordSelector.mainWordSelector();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setupUI(){
        for (char c:str.toCharArray()) {
            Text newText = new Text(String.valueOf(c));
            newText.setFill(Color.GRAY);
            text.getChildren().add(newText);
        }
        scene.addEventFilter(KeyEvent.KEY_PRESSED, this::onKeyTyped);
    }

    public void onKeyTyped(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.BACK_SPACE) {
            if (i >= 0) {
                char previousChar = str.charAt(i);
                ((Text) text.getChildren().get(i)).setFill(Color.GRAY);
                ((Text) text.getChildren().get(i)).setText(String.valueOf(previousChar));
                i--;
            }
            return;
        }

        String input = keyEvent.getText();

        if (!input.isEmpty()) {
            i++;

            if (i < str.length()) {
                String currentChar = ((Text) text.getChildren().get(i)).getText();

                boolean isShiftPressed = keyEvent.isShiftDown();

                if (isShiftPressed && Character.isLetter(input.charAt(0))) {
                    input = input.toUpperCase();
                }

                if (input.equals(currentChar)) {
                    ((Text) text.getChildren().get(i)).setFill(Color.BLACK);
                } else {
                    ((Text) text.getChildren().get(i)).setFill(Color.RED);
                }
                ((Text) text.getChildren().get(i)).setText(input);
            }
        }
    }

}