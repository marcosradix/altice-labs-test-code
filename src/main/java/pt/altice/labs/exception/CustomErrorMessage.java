package pt.altice.labs.exception;

public class CustomErrorMessage {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomErrorMessage(String message) {
        super();
        this.message = message;
    }

    public CustomErrorMessage() {
        super();
    }
}
