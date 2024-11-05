package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private JobRepository jobRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "My Jobs");
        model.addAttribute("jobs", jobRepository.findAll());
        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
        model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerRepository.findAll());
        return "add";
    }

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                    Errors errors,
                                    Model model,
                                    @RequestParam int employerId) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Job");
            model.addAttribute("employers", employerRepository.findAll());
            return "add";
        }

        // Find the selected employer and set it on the new job object
        Optional<Employer> result = employerRepository.findById(employerId);
        if (result.isPresent()) {
            Employer employer = result.get();
            newJob.setEmployer(employer); // Corrected to set the Employer object
        } else {
            // Optionally handle the case where the employer is not found
            model.addAttribute("title", "Add Job");
            model.addAttribute("employers", employerRepository.findAll());
            model.addAttribute("errorMessage", "Employer not found");
            return "add";
        }

        // Save the job (assuming the employer has been set successfully)
        jobRepository.save(newJob);

        return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {
        Optional<Job> job = jobRepository.findById(jobId);
        if (job.isPresent()) {
            model.addAttribute("job", job.get());
            return "view";
        } else {
            return "redirect:/";
        }
    }
}
