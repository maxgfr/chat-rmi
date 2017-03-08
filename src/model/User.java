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
 * Represents a User
 * @author maxime
 */
public class User {
	
    /**
     * JavaFx property : User's name
     */
    private final StringProperty name = new SimpleStringProperty();
        /**
         * Getter
         * @return User's name
         */
        public String getName() { return name.get();}
        /**
         * Setter for User's name
         * @param value
         */
        public void setName(String value) { name.set(value); }
        /**
         * Getter
         * @return StringProperty name
         */
        public StringProperty nameProperty() { return name; }
        
    /**
     * JavaFx property : User's server
     */
    private final ObjectProperty<IMsn> server = new SimpleObjectProperty<IMsn>();
        /**
         * Getter
         * @return IMsn's instance
         */
        public IMsn getMsn() { return server.get();}
        /**
         * Setter
         * @param value new IMsn's instance
         */
        public void setMsn(IMsn value) { server.set(value); }
        /**
         * @return ObjectProperty IMsn
         */
        public ObjectProperty<IMsn> MsnProperty() { return server; }
        
    /**
     * JavaFx property : User's ICallback reference
     */
    private final ObjectProperty<ICallback> ref = new SimpleObjectProperty<ICallback>();
        /**
         * Getter
         * @return User's ref
         */
        public ICallback getCallback() { return ref.get();}
        /**
         * Setter of User's ref
         * @param value
         */
        public void setCallback(ICallback value) { ref.set(value); }
        /**
         * Getter
         * @return ObjectProperty ICallback
         */
        public ObjectProperty<ICallback> CallbackProperty() { return ref; }    

    /**
     * Constructor
     * @param name of User
     * @param server to connect to
     * @param ref ICallback reference
     */
    public User(String name, IMsn server, ICallback ref) {
        setName(name);
        setMsn(server);
        setCallback(ref);
    }

    /**
     * register this user to Server
     */
    public void enregistreServeur ()
    {
        try {
            getMsn().addUser(getName(),getCallback());
        } catch (RemoteException e) {
            e.getMessage();
        }
    }
    
    /**
     * Send Message to user identified by name
     * @param msg the message to send
     * @param name the user to send
     */
    public void envoiMessage (String msg, String name)
    {
        try {
            if (getMsn().isConnected(name))
            {
                ICallback referenceOther = getMsn().obtainRef(name);
                referenceOther.dispMsg(msg);
            } else {
                System.out.println("Utilisateur non connecté");
            }
        } catch (RemoteException e) {
            e.getMessage();
        }
    }
    /**
     * Log out from server this user
     */
    public void seDeconnecte ()
    {
        try {
            getMsn().logOut(getName());
        } catch (RemoteException e) {
            e.getMessage();
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        User other = (User) obj;
        if (getName() == null) return  other.getName() == null;
        return getName().equals(other.getName());
    }

	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        return result;
    }
}
