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

     public void remove(long experienceID) throws Exception {
        try (ExperiencesDAO experiencesDAO = new ExperiencesDAO()) {
            experiencesDAO.delete(experienceID);
        }
    }
    public void removeByEmployeeID(long employeeID) throws Exception {
        try (ExperiencesDAO experiencesDAO = new ExperiencesDAO()) {
            experiencesDAO.deleteByEmployeeID(employeeID);
        }
    }

    public String findAll() throws Exception {
        try (ExperiencesDAO experiencesDAO = new ExperiencesDAO()) {
           return experiencesDAO.select();
        }
    }

    public String findByEmployeeID(long employeeID) throws Exception {
        try (ExperiencesDAO experiencesDAO = new ExperiencesDAO()) {
           return experiencesDAO.selectByEmployeeID(employeeID);
        }
    }
}