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
 *
 * @author maxime
 */
public class MsnImpl extends UnicastRemoteObject implements IMsn{
    
    private Map<String, ICallback> map = new HashMap<>();
    
    
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
        for (Map.Entry<String,ICallback> entry : map.entrySet()) {
            if (entry.getKey().equals(name)) {
                return true;
            }
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
         for (Map.Entry<String,ICallback> entry : map.entrySet()) {
            if (entry.getKey().equals(name)) {
                map.remove(entry.getKey());
            }
        }
    }

    @Override
    public Map<String, ICallback> getMap() throws RemoteException {
        return map;
    }
    
}
