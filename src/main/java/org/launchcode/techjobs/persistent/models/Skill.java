package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @ManyToMany(mappedBy = "skills")
    private List<Job> jobs = new ArrayList<>();

    @Size(max = 500, message = "Description must not exceed 500 characters")
    private String description;

    // No-arg constructor required for Hibernate
    public Skill() {
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for jobs
    public List<Job> getJobs() {
        return jobs;
    }

    // Setter for jobs
    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
