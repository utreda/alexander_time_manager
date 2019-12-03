package com.adaming.project.alexander_time_manager.enumeration;

public enum ActivityType {
    Roulette("Daily Roulette"),
    Raid24("24 man raid"),
    Raid8 ("8 man raid"),
    Raid8S("8 man raid Savage"),
    TrialS("Trials Savage"),
    Beast("Beast tribe quests"),
    Deliveries("Custom Deliveries");

    private String name = "";

    //Constructeur
    ActivityType(String name){
        this.name = name;
    }

    public String toString(){
        return name;
    }
}
