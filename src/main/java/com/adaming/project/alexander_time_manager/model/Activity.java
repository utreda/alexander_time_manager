package com.adaming.project.alexander_time_manager.model;

import com.adaming.project.alexander_time_manager.enumeration.ActivityType;
import com.adaming.project.alexander_time_manager.enumeration.Experience;
import com.adaming.project.alexander_time_manager.enumeration.Recurency;

import java.sql.Time;

public class Activity {
    private String name;
    private Experience exp;
    private int memoquartz;
    private ActivityType activityType;
    private Mount mount;
    private Time length;
    private Recurency recurency;
    private boolean done;
}
;
