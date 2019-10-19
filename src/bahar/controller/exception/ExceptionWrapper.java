package bahar.controller.exception;

import java.sql.SQLException;

public class ExceptionWrapper {
    public static String getMessage(Exception e) {
        if (e instanceof SQLException) {
            return "DATABASE MOSHKEL  DARAD"+ e.getMessage();
        } else if (e instanceof NumberFormatException) {
            return "ID RA ADAD BEDID"+ e.getMessage();
        } else {
            return "KHATA :" + e.getMessage();
        }
    }
}
