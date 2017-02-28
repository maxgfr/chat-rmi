/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author maxime
 */
public class ServeurViewController implements Initializable {
   
    @FXML
    private Button start;
    @FXML
    private Button stop;
    
    @FXML
    protected void start() {
        start.setDisable(true); //eviter la création d'un nouveau thread
        stop.setDisable(false);
    }
    
    
    @FXML
    protected void stop() {
        start.setDisable(false);
        stop.setDisable(true);
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
