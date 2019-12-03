package com.adaming.project.alexander_time_manager.model;

import com.adaming.project.alexander_time_manager.enumeration.ActivityType;
import com.adaming.project.alexander_time_manager.enumeration.Experience;
import com.adaming.project.alexander_time_manager.enumeration.Recurency;

import javax.persistence.*;
import java.sql.Time;
@Entity
@Table(name = "Activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Experience exp;
    private int memoquartz;
    private ActivityType activityType;
    @OneToOne
    @JoinColumn(name = "mount_id")
    private Mount mount;
    private Time length;
    private Recurency recurency;
    private boolean done;

    public Activity() { }

    public Activity(String name, Experience exp, int memoquartz, ActivityType activityType, Mount mount, Time length, Recurency recurency) {
        this.name = name;
        this.exp = exp;
        this.memoquartz = memoquartz;
        this.activityType = activityType;
        this.mount = mount;
        this.length = length;
        this.recurency = recurency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Experience getExp() {
        return exp;
    }

    public void setExp(Experience exp) {
        this.exp = exp;
    }

    public int getMemoquartz() {
        return memoquartz;
    }

    public void setMemoquartz(int memoquartz) {
        this.memoquartz = memoquartz;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public Mount getMount() {
        return mount;
    }

    public void setMount(Mount mount) {
        this.mount = mount;
    }

    public Time getLength() {
        return length;
    }

    public void setLength(Time length) {
        this.length = length;
    }

    public Recurency getRecurency() {
        return recurency;
    }

    public void setRecurency(Recurency recurency) {
        this.recurency = recurency;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
;
