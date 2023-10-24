package homework.medicalCenter.exception;

public class PersonExistsException extends Exception {

    public PersonExistsException() {
    }

    public PersonExistsException(String message) {
        super(message);
    }

    public PersonExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonExistsException(Throwable cause) {
        super(cause);
    }

    public PersonExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
