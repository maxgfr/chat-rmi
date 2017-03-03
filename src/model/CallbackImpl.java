/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author maxime
 */

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CallbackImpl extends UnicastRemoteObject implements ICallback
{

    public CallbackImpl() throws RemoteException
    {
            super();
    }

    @Override
    public void dispMsg(String message)
    {
        System.out.println(message);
    }
              

}
