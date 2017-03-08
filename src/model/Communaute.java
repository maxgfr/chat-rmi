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
 * Communaute
 * @author maxime
 */
public class Communaute {
    
	/**
	 * Observable List of user
	 */
    private final ObservableList<User> lesTravauxObservables = FXCollections.observableArrayList();
    
    /**
     * JavaFx list of observable Users
     */
    private final ListProperty<User> lesTravaux = new SimpleListProperty<>(lesTravauxObservables);
        /**
         * Getter
         * @return ObservableList User
         */
        public ObservableList<User> getLesTravaux() {return lesTravaux.get();}
        /**
         * Getter
         * @return ReadOnlyListProperty User
         */
        public ReadOnlyListProperty<User> lesTravauxProperty() {return lesTravaux;}
}
