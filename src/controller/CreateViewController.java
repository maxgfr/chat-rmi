/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.CallbackImpl;
import model.ICallback;
import model.IMsn;
import model.User;

/**
 * FXML Controller class
 *
 * @author maxime
 */
public class CreateViewController extends ClientViewController implements Initializable {

    @FXML
    Button bouton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    protected void onValidateButton (ActionEvent event) {
        String name = txt.getText();
        IMsn mn = null;
        ICallback cb = null;
	try {
            Registry rg =LocateRegistry.getRegistry("localhost",6767);
            mn = (IMsn) rg.lookup("Manager");
	} catch (NotBoundException | RemoteException e) {
            showMessage(Alert.AlertType.ERROR, null, "Erreur a l'accès du serveur:" + e);
	}   
        try {
	      cb = new CallbackImpl(chat);
	} catch (RemoteException e) {
	     System.out.println("Erreur de création " + " : " + e);
	}
	try {
            utilisateur = new User(name,mn,cb,"");
            utilisateur.enregistreServeur();
            launch();
	} catch (Exception e) {
            showMessage(Alert.AlertType.WARNING, null, "Erreur lors de la deconnexion " + " : " + e);
	}
    }
    
    private void launch() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ClientView.fxml"));
        Scene scene = new Scene(root);
        Stage st = new Stage();
        st.setScene(scene);
        st.show();
        Stage stage = (Stage) bouton.getScene().getWindow();
        stage.close();
    }

    
}
