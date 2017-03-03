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

    // Une méthode permettant d’afficher un message envoyé, écrire l’implémentation de cet interface.
    void dispMsg(String message) throws RemoteException;

}

