package com.adaming.project.alexander_time_manager.exception;

public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException() {
        System.out.println("!!!Impossible d'enregistrer un Joueur déjà existant!!!");
    }
}

