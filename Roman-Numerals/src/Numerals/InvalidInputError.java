package Numerals;

public class InvalidInputError extends Error{
    String message;

    public InvalidInputError(String message) {
        this.message = message;
    }

    public String getMessage() {
       return message;
    }
}
