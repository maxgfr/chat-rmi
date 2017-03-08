/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of IMsn
 * @author maxime
 * @see IMsn
 * 
 */
public class MsnImpl extends UnicastRemoteObject implements IMsn{
    /**
     * HashMap of ICallback implemented Object by name of Cient
     * Map String name_of_user, ICallback implemented_object
     */
    private Map<String, ICallback> map = new HashMap<>();
    
    /**
     * Constructors
     * @throws RemoteException
     */
    public MsnImpl () throws RemoteException
    {
        super();
    }
    
    @Override
    public void addUser(String name, ICallback client) throws RemoteException {
         if (!map.containsKey(name)){
            map.put(name,client);
        }
        else {
            System.out.println("Contient déjà l'élement");
        }
    }

    @Override
    public boolean isConnected(String name) throws RemoteException {
        if (map.entrySet().stream().anyMatch((entry) -> (entry.getKey().equals(name)))) {
            return true;
        }
        return false;   
    }

    @Override
    public ICallback obtainRef(String name) throws RemoteException {
        for (Map.Entry<String,ICallback> entry : map.entrySet()) {
            if (entry.getKey().equals(name)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void logOut(String name) throws RemoteException {
        map.entrySet().stream().filter((entry) -> (entry.getKey().equals(name))).forEachOrdered((entry) -> {
            map.remove(entry.getKey());
        });
    }

    @Override
    public Map<String, ICallback> getMap() throws RemoteException {
        return map;
    }
    
    
}
