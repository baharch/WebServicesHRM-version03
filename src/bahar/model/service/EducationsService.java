package bahar.model.service;

import bahar.model.entity.Educations;
import bahar.model.repository.EducationsDAO;

public class EducationsService {
    private static EducationsService ourInstance = new EducationsService();
    public static EducationsService getInstance() {
        return ourInstance;
    }

    private EducationsService() {
    }

    public void save(Educations education) throws Exception {
        try (EducationsDAO educationsDAO = new EducationsDAO()) {
            educationsDAO.insert(education);
        }
    }

    public void edit(Educations education) throws Exception {
        try (EducationsDAO educationsDAO = new EducationsDAO()) {
            educationsDAO.update(education);
        }
    }

    public void remove(long educationID) throws Exception {
        try (EducationsDAO educationsDAO = new EducationsDAO()) {
            educationsDAO.delete(educationID);
        }
    }

    public void removeByEmployeeID(long employeeID) throws Exception {
        try (EducationsDAO educationsDAO = new EducationsDAO()) {
            educationsDAO.deleteByEmployeeID(employeeID);
        }
    }

    public String findAll() throws Exception {
        try (EducationsDAO educationsDAO = new EducationsDAO()) {
          return   educationsDAO.select();
        }
    }
    public String findByEmployeeID(long employeeID) throws Exception {
        try (EducationsDAO educationsDAO = new EducationsDAO()) {
          return   educationsDAO.selectByEmployeeID(employeeID);
        }
    }
}
