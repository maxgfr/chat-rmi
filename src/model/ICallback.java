/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author maxime
 */
public interface ICallback extends Remote {
    
	// show a message from user
	void receiveMessage(String Message) throws RemoteException;
        
        String DEFAULT_NAME = "ChatClient";

	void sendUserList(String[] userList) throws RemoteException;
}

