/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launch;

import controller.ServeurViewController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Launch JavaFX windows for server
 * @author maxime
 * @see ServeurViewController
 * 
 */
public class MainServeur extends Application {
	
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ServeurView.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @Override
    public void stop() throws Exception 
    {
        super.stop();
        Platform.exit();
        System.exit(0);
    }

    /**
     * Launch the window
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
