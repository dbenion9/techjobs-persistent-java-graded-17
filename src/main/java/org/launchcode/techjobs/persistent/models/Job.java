package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "employer_id")  // owning side of the relationship
    private Employer employer;

    @ManyToMany
    @JoinTable(
            name = "job_skill", // Name of the join table
            joinColumns = @JoinColumn(name = "job_id"), // Foreign key for Job
            inverseJoinColumns = @JoinColumn(name = "skill_id") // Foreign key for Skill
    )
    private List<Skill> skills = new ArrayList<>();

    // Default constructor
    public Job() {}

    // Non-default constructor to handle employer and skills
    public Job(Employer employer, List<Skill> skills) {
        this.employer = employer;
        this.skills = skills;
    }

    // Getter and setter for employer
    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
        System.out.println("Setting employer: " + (employer != null ? employer.getId() : "null")); // Debug statement
        this.employer = employer;
    }

    // Getter and setter for skills
    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
