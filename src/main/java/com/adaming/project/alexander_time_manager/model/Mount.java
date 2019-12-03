package com.adaming.project.alexander_time_manager.model;

import com.adaming.project.alexander_time_manager.enumeration.Animal;

import javax.persistence.*;

@Entity
@Table(name = "Mounts")
public class Mount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Animal animal;
    @OneToOne
    @JoinColumn(name = "activity_id")
    private Activity trial;

    public Mount(Animal animal, Activity trial) {
        this.animal = animal;
        this.trial = trial;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Activity getTrial() {
        return trial;
    }

    public void setTrial(Activity trial) {
        this.trial = trial;
    }
}
