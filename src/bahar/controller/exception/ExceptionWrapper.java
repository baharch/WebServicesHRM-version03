package bahar.controller.exception;

import java.sql.SQLException;

public class ExceptionWrapper {
    public static String getMessage(Exception e) {
        if (e instanceof SQLException) {
            return "DATABASE MOSHKEL  DARAD";
        } else if (e instanceof NumberFormatException) {
            return "ID RA ADAD BEDID";
        } else {
            return "KHATA :" + e.getMessage();
        }
    }
}
