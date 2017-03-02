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
import javafx.scene.control.TextArea;

public class CallbackImpl extends UnicastRemoteObject implements ICallback
{
	private TextArea ta;

	public CallbackImpl(TextArea ihm) throws RemoteException
	{
		super();
		this.ta = ihm;
	}

	@Override
	public void dispMsg(String message)
	{
            this.ta.appendText(message+"\n\n");
	}

}
