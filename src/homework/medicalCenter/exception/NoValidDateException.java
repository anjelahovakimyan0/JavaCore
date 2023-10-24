package homework.medicalCenter.exception;

public class NoValidDateException extends Exception {

    public NoValidDateException() {
    }

    public NoValidDateException(String message) {
        super(message);
    }

    public NoValidDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoValidDateException(Throwable cause) {
        super(cause);
    }

    public NoValidDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
