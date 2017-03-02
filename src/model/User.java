/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.RemoteException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author maxime
 */
public class User {
	
    private final StringProperty name = new SimpleStringProperty();
        public String getName() { return name.get();}
        public void setName(String value) { name.set(value); }
        public StringProperty nameProperty() { return name; }
        
    private final StringProperty historique = new SimpleStringProperty();
        public String getHistorique() { return historique.get();}
        public void setHistorique(String value) { historique.set(value); }
        public StringProperty historiqueProperty() { return historique; }
        
    private final ObjectProperty<IMsn> server = new SimpleObjectProperty<IMsn>();
        public IMsn getMsn() { return server.get();}
        public void setMsn(IMsn value) { server.set(value); }
        public ObjectProperty<IMsn> MsnProperty() { return server; }
        
    private final ObjectProperty<ICallback> ref = new SimpleObjectProperty<ICallback>();
        public ICallback getCallback() { return ref.get();}
        public void setCallback(ICallback value) { ref.set(value); }
        public ObjectProperty<ICallback> CallbackProperty() { return ref; }    

    public User(String name, IMsn server, ICallback ref, String hq) {
            setName(name);
            setMsn(server);
            setCallback(ref);
            setHistorique(hq);
    }

    public void enregistreServeur ()
    {
        try {
            getMsn().addUser(getName(),getCallback());
        } catch (RemoteException e) {
            e.getMessage();
        }
    }
    
    public void envoiMessage (String msg, String user)
    {
        try {
            if (getMsn().isConnected(user))
            {
                ICallback referenceOther = getMsn().obtainRef(user);
                referenceOther.dispMsg(msg);
            } else {
                System.out.println("Utilisateur non connecté");
            }
        } catch (RemoteException e) {
            e.getMessage();
        }
    }
    
    public void seDeconnecte ()
    {
        try {
            getMsn().logOut(getName());
        } catch (RemoteException e) {
            e.getMessage();
        }
    }
}
