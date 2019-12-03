package com.adaming.project.alexander_time_manager.model;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pseudo;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "job_user",
            joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id",
                    referencedColumnName = "id"))
    private List<Job> jobs;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "activity_user",
            joinColumns = @JoinColumn(name = "mactivity_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id",
                    referencedColumnName = "id"))
    private List<Activity> activities;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "mount_user",
            joinColumns = @JoinColumn(name = "mount_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private List<Mount> mounts;

    public User() {
    }

    public User(String pseudo) {
        this.pseudo = pseudo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
    public List<Mount> getMounts() {
        return mounts;
    }
    public void setMounts(List<Mount> mounts) {
        this.mounts = mounts;
    }
}
