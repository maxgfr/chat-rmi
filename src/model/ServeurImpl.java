/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author maxime
 */

public class ServeurImpl extends UnicastRemoteObject implements IServeur
{

	private static final long serialVersionUID = 1L;
	private Map<String, ICallback> chatter = new HashMap<String, ICallback>();

	public ServeurImpl() throws RemoteException
	{
		super();
	}

	@Override
	public synchronized boolean logInPossible(String name)
	{
		return !this.chatter.containsKey(name);
	}

	@Override
	public synchronized void addUser(String name, ICallback client)
	{
		this.chatter.put(name, client);
		this.sendUserListToClients();
	}

	@Override
	public synchronized void logOut(String name)
	{
		this.chatter.remove(name);
		this.sendUserListToClients();
	}

	public synchronized void sendUserListToClients()
	{
		while (!this.iterateForUserList())
			;
	}

	private boolean iterateForUserList()
	{
		for (Iterator<Map.Entry<String, ICallback>> it = this.chatter.entrySet().iterator(); it.hasNext();)
		{
			try
			{
				it.next().getValue().sendUserList(this.chatter.keySet().toArray(new String[0]));
			} catch (RemoteException e)
			{
				it.remove();
				return false;
			}
		}
		return true;
	}

	@Override
	public synchronized void postMessage(String name, String message)
	{
		String finalMessage = name + ": " + message;
		boolean b = false;
		for (Iterator<Map.Entry<String, ICallback>> it = this.chatter.entrySet().iterator(); it.hasNext();)
		{
			try
			{
                            it.next().getValue().receiveMessage(finalMessage);
			} catch (RemoteException e)
			{
				it.remove();
				b = true;
			}
		}
		if (b)
		{
			this.sendUserListToClients();
		}
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException,
			InterruptedException, NotBoundException
	{
		LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		Naming.bind(IServeur.DEFAULT_NAME, new ServeurImpl());

		Thread.sleep(100);

		// Application.launch(GUI.class);

	}

}
