package bahar.model.service;

import bahar.model.entity.Experiences;
import bahar.model.repository.ExperiencesDAO;

public class ExperiencesService {
    private static ExperiencesService experiencesService = new ExperiencesService();
    public static ExperiencesService getInstance() {
        return experiencesService;
    }

    private ExperiencesService() {
    }

    public void save(Experiences experience) throws Exception {
        try (ExperiencesDAO experiencesDAO = new ExperiencesDAO()) {
            experiencesDAO.insert(experience);
        }
    }

    public void edit(Experiences experience) throws Exception {
        try (ExperiencesDAO experiencesDAO = new ExperiencesDAO()) {
            experiencesDAO.update(experience);
        }
    }

    public void removeAll() throws Exception {
        try (ExperiencesDAO experiencesDAO = new ExperiencesDAO()) {
            experiencesDAO.deleteAll();
        }
    }

     public void removeExperience(long experienceID) throws Exception {
        try (ExperiencesDAO experiencesDAO = new ExperiencesDAO()) {
            experiencesDAO.deleteExperience(experienceID);
        }
    }
    public void removeExperiences(long employeeID) throws Exception {
        try (ExperiencesDAO experiencesDAO = new ExperiencesDAO()) {
            experiencesDAO.deleteExperiences(employeeID);
        }
    }

    public String findAll() throws Exception {
        try (ExperiencesDAO experiencesDAO = new ExperiencesDAO()) {
           return experiencesDAO.selectAll();
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