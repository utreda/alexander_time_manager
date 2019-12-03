package com.adaming.project.alexander_time_manager.model;

import com.adaming.project.alexander_time_manager.enumeration.JobType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int level;
    private JobType type;

    @ManyToMany(mappedBy = "jobs")
    private List<User> users;

    public Job(String name, int level, JobType type) {
        this.name = name;
        this.level = level;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }
}
