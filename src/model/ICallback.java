/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * ICallBack Interface, must be implemented 
 * @author maxime
 */
public interface ICallback extends Remote {

    /**
     * Whoever use this method display a message to the one instance this object
     * @param message the message to display
     * @throws RemoteException
     */
    void dispMsg(String message) throws RemoteException;

}

