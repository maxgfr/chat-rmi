/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import model.*;

/**
 * Controller for JavaFX view of Server
 * @author maxime
 * 
 */
public class ServeurViewController implements Initializable {
   /**
    * start Button
    */
    @FXML
    private Button start;
    
    /**
     * stop Button
     */
    @FXML
    private Button stop;
    
    /**
     * TextArea
     */
    @FXML
    private TextArea message;
    
    /**
     * MSN Mannages
     */
    MsnImpl msn;
    
    /*
     * Registry
     */
    Registry rg;
    
    /**
     * Crate a new MSN Manager and a registry
     */
    @FXML
    protected void start() {
        start.setDisable(true); //eviter la création d'un nouveau thread
        stop.setDisable(false);
        try {
            if(msn==null) {
                msn = new MsnImpl();      
            }
            if(rg==null) {
                rg = LocateRegistry.createRegistry(6767);      
            } 
            rg.bind("Manager", msn);
            message.appendText("Serveur en attente \n\n");
        } catch (AlreadyBoundException | RemoteException e) {
            message.appendText(e.getMessage()+"\n\n");
        }
    }
    
    /**
     * Remove the registry
     */
    @FXML
    protected void stop() {
        start.setDisable(false);
        stop.setDisable(true);
        try {        	  
            rg.unbind("Manager");
            message.appendText("Serveur non fonctionnel \n\n");
        } catch (NotBoundException | RemoteException e) {
            message.appendText(e.getMessage()+"\n\n");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stop.setDisable(true);
    }    
    
}
