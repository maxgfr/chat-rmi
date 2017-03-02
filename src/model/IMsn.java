/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

/**
 *
 * @author maxime
 */
public interface IMsn extends Remote {
    
    //Une méthode permettant à un client de s’enregistrer en envoyant son nom ainsi que la référence de son objet callback.
    void addUser(String name, ICallback client) throws RemoteException;
    
    //Une méthode permettant à un client de savoir si un autre client est en ligne (déjà enregistrer) grâce à un nom.
    boolean isConnected (String name) throws RemoteException;
    
    //Une méthode permettant d’obtenir la référence d’un objet callback d’un client en ligne grâce à son nom.
    ICallback obtainRef (String name) throws RemoteException;
    
    //Une méthode permettant à un client de se déconnecter en envoyant son nom.
    void logOut (String name) throws RemoteException;
    
    //Une méthode permettant à un client d'avoir la map retournant tous les utilisateurs
    Map<String, ICallback> getMap () throws RemoteException;
    
}
