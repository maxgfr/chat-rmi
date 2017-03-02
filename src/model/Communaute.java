/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author maxime
 */
public class Communaute {
    private final ObservableList<User> lesTravauxObservables = FXCollections.observableArrayList();
    
    private final ListProperty<User> lesTravaux = new SimpleListProperty<>(lesTravauxObservables);
        public ObservableList<User> getLesTravaux() {return lesTravaux.get();}
        public ReadOnlyListProperty<User> lesTravauxProperty() {return lesTravaux;}

    public Communaute(){
        
    }
}
