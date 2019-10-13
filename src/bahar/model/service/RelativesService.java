package bahar.model.service;

import bahar.model.entity.Relatives;
import bahar.model.repository.RelativesDAO;

public class RelativesService {
    private static RelativesService relativesService = new RelativesService();
    public static RelativesService getInstance() {
        return relativesService;
    }

    private RelativesService() {
    }

    public void save(Relatives relatives) throws Exception {
        try (RelativesDAO relativesDAO = new RelativesDAO()) {
            relativesDAO.insert(relatives);
        }
    }

    public void edit(Relatives relative) throws Exception {
        try  (RelativesDAO relativesDAO = new RelativesDAO()) {
            relativesDAO.update(relative);
        }
    }

    public void remove(long relativeID) throws Exception {
        try  (RelativesDAO relativesDAO = new RelativesDAO()) {
            relativesDAO.delete(relativeID);
        }
    }

    public void removeByEmployeeID(long employeeID) throws Exception {
        try  (RelativesDAO relativesDAO = new RelativesDAO()) {
            relativesDAO.delete(employeeID);
        }
    }

    public String findAll() throws Exception {
        try (RelativesDAO relativesDAO = new RelativesDAO()) {
           return relativesDAO.select();
        }
    }

    public String findByEmployeeID(long employeeID) throws Exception {
        try (RelativesDAO relativesDAO = new RelativesDAO()) {
           return relativesDAO.selectByID(employeeID);
        }
    }

    public String findByRelativeID(long relativeID) throws Exception {
        try (RelativesDAO relativesDAO = new RelativesDAO()) {
           return relativesDAO.selectByRelativeID(relativeID);
        }
    }


}
