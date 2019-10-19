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

    public void removeAll() throws Exception {
        try  (RelativesDAO relativesDAO = new RelativesDAO()) {
            relativesDAO.deleteAll();
        }
    }

    public void removeRelatives(long employeeID) throws Exception {
        try  (RelativesDAO relativesDAO = new RelativesDAO()) {
            relativesDAO.deleteRelatives(employeeID);
        }
    }

    public void removeRelative(long relativeID) throws Exception {
        try  (RelativesDAO relativesDAO = new RelativesDAO()) {
            relativesDAO.deleteRelative(relativeID);
        }
    }


    public String findAll() throws Exception {
        try (RelativesDAO relativesDAO = new RelativesDAO()) {
           return relativesDAO.selectAll();
        }
    }

    public String findRelatives(long employeeID) throws Exception {
        try (RelativesDAO relativesDAO = new RelativesDAO()) {
           return relativesDAO.selectRelatives(employeeID);
        }
    }

    public String findRelative(long relativeID) throws Exception {
        try (RelativesDAO relativesDAO = new RelativesDAO()) {
           return relativesDAO.selectRelative(relativeID);
        }
    }


}
