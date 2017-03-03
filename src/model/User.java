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
        
    private final ObjectProperty<IMsn> server = new SimpleObjectProperty<IMsn>();
        public IMsn getMsn() { return server.get();}
        public void setMsn(IMsn value) { server.set(value); }
        public ObjectProperty<IMsn> MsnProperty() { return server; }
        
    private final ObjectProperty<ICallback> ref = new SimpleObjectProperty<ICallback>();
        public ICallback getCallback() { return ref.get();}
        public void setCallback(ICallback value) { ref.set(value); }
        public ObjectProperty<ICallback> CallbackProperty() { return ref; }    

    public User(String name, IMsn server, ICallback ref) {
        setName(name);
        setMsn(server);
        setCallback(ref);
    }

    public void enregistreServeur ()
    {
        try {
            getMsn().addUser(getName(),getCallback());
        } catch (RemoteException e) {
            e.getMessage();
        }
    }
    
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
