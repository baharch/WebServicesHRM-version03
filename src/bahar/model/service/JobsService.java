package bahar.model.service;

import bahar.model.entity.Experiences;
import bahar.model.entity.Jobs;
import bahar.model.repository.ExperiencesDAO;
import bahar.model.repository.JobDAO;

public class JobsService {
    private static JobsService experiencesService = new JobsService();
    public static JobsService getInstance() {
        return experiencesService;
    }

    private JobsService() {
    }

    public void save(Jobs job) throws Exception {
        try (JobDAO jobDAO = new JobDAO()) {
            jobDAO.insert(job);
        }
    }

    public void edit(Jobs job) throws Exception {
        try (JobDAO jobDAO = new JobDAO()) {
            jobDAO.update(job);
        }
    }

    public void removeAll() throws Exception {
        try (JobDAO jobDAO = new JobDAO()) {
            jobDAO.deleteAll();
        }
    }

     public void removeJob(long employeeID) throws Exception {
         try (JobDAO jobDAO = new JobDAO()) {
             jobDAO.deleteJob(employeeID);
        }
    }
    public void removeJobs( ) throws Exception {
        try (JobDAO jobDAO = new JobDAO()) {
            jobDAO.deleteAll();
        }
    }

    public void freeJob(Long employeeID) throws Exception {
        try (JobDAO jobDAO = new JobDAO()) {
            jobDAO.freeJob();
        }
    }

    public String findAll() throws Exception {
        try (JobDAO jobDAO = new JobDAO()) {
           return jobDAO.selectAll();
        }
    }

    public String findExperience(long experienceID) throws Exception {
        try (ExperiencesDAO experiencesDAO = new ExperiencesDAO()) {
           return experiencesDAO.selectExperience(experienceID);
        }
    }
    public String findExperiences(long employeeID) throws Exception {
        try (ExperiencesDAO experiencesDAO = new ExperiencesDAO()) {
            return experiencesDAO.selectExperiences(employeeID);
        }
    }
}