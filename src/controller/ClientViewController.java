/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author maxime
 */
public class ClientViewController implements Initializable {
    
    
    
    @FXML
    TextArea contentText;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    protected void onCreateButton (ActionEvent event) {
        //this.createNote();
    }
    
    @FXML
    protected void onDeletedButton (ActionEvent event) {
        //this.clicDelete();
    }
    
    @FXML
    protected void exitApp(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    protected void cut(ActionEvent event) {
        this.contentText.cut();
    }

    @FXML
    protected void copy(ActionEvent event) {
        this.contentText.copy();
    }

    @FXML
    protected void paste(ActionEvent event) {
        this.contentText.paste();
    }

    @FXML
    protected void delete(ActionEvent event) {
        this.contentText.deleteNextChar();
    }

    @FXML
    protected void selectAll(ActionEvent event) {
        this.contentText.selectAll();
    }

    @FXML
    protected void fullscreen(ActionEvent event) {
            Stage stage = (Stage) this.contentText.getScene().getWindow();
            stage.setFullScreen(true);
    }
    
    
    
}
