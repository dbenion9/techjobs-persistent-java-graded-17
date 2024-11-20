package org.launchcode.techjobs.persistent.models.data;

import org.launchcode.techjobs.persistent.models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends CrudRepository<Job, Integer> {
    // Custom query methods to find jobs by employer name or skill name
    List<Job> findByEmployer_Name(String employerName);
    List<Job> findBySkills_Name(String skillName);
}
