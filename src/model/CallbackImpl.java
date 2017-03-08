/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * callback implementation, allow user to receive message from other users
 * @author maxime
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 * Implementation of Remote Interface {@link ICallback}
 * @author benoit
 *
 */
public class CallbackImpl extends UnicastRemoteObject implements ICallback
{
	/**
	 * Constructor
	 * @throws RemoteException
	 */
    public CallbackImpl() throws RemoteException
    {
            super();
    }
    
    /**
     * Print message on CLI
     */
    @Override
    public void dispMsg(String message)
    {
        System.out.println(message);
    }
              

    
}
