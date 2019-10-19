package bahar.controller.exception;

public class MessageWrapper {

    public static String getMessage(String bdMessage) {
        if (bdMessage=="successful_add") {
            return "The Record is added successfully into data base.";
        } else if ( bdMessage=="successful_edit") {
            return "The Record is edited successfully .";
        } else if ( bdMessage=="successful_delete") {
            return "The Record is deleted successfully .";
        } else if ( bdMessage=="successful_deletes") {
            return "Records are deleted successfully .";
        } else if ( bdMessage=="emptySearch") {
            return "No match Record found.";
        } else {
            return "Done!";
        }
    }
}
