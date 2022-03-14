package by.mazets.textparser.exception;

public class ProjectException extends Exception {
    public ProjectException() {
        super();
    }

    public ProjectException(String message) {
        super(message);
    }

    public ProjectException(Throwable cause) {
        super(cause);
    }

    public ProjectException(String message, Throwable cause) {
        super(message, cause);
    }
}