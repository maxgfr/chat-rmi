package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maxime
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServeur extends Remote
{
	String DEFAULT_NAME = "ChatServer";

	boolean logInPossible(String name) throws RemoteException;

	void addUser(String name, ICallback client) throws RemoteException;

	void logOut(String name) throws RemoteException;

	void postMessage(String name, String message) throws RemoteException;
}
