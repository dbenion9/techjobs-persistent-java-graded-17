package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Job extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employer_id") // Specifies the foreign key column
    @NotNull(message = "Employer cannot be null")
    private Employer employer;

    @ManyToMany
    private Set<Skill> skills = new HashSet<>(); // Initializes the skills set

    // Constructor
    public Job() {
    }

    // Getters and setters for employer
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    // Getter and setter for skills
    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}
