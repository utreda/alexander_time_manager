package com.adaming.project.alexander_time_manager.exception;

public class NullUserException extends Exception {
    public NullUserException() {
        System.out.println("!!!Impossible d'enregistrer un joueur nul!!!");
    }
}

