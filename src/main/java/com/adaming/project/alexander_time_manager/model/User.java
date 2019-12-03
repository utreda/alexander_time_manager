package com.adaming.project.alexander_time_manager.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User {
    private @Id @GeneratedValue Long id;
    private String pseudo;
    private Job[] battleJobs;
    private Job[] crafterGathererJobs;
    private Activity[] activities;
    private Mount[] mounts;
}
