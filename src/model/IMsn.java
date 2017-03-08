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
 * A remote interface for server
 * @author maxime
 */
public interface IMsn extends Remote {
    
    /**
     * Allow a client to register by sending his name and his ICallBack instance
     * @param name
     * @param client
     * @throws RemoteException
     */
    void addUser(String name, ICallback client) throws RemoteException;
    
    /**
     * Allow a client to know if another client is online (registered) thanks to his name.
     * @param name
     * @return true if the client is registered
     * @throws RemoteException
     */
    boolean isConnected (String name) throws RemoteException;
    
    /**
     * Get the ICallback Object whose name is given by parameter
     * @param name
     * @return ICallback of the client
     * @throws RemoteException
     */
    ICallback obtainRef (String name) throws RemoteException;
    
    /**
     * Allow a client to logout from this server
     * @param name : client's name
     * @throws RemoteException
     */
    void logOut (String name) throws RemoteException;
    
    /**
     * Get the Hashmap which contains all the users
     * @return HashMap
     * @throws RemoteException
     */
    Map<String, ICallback> getMap () throws RemoteException;
    
}
