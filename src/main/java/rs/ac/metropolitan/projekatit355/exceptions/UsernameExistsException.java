package rs.ac.metropolitan.projekatit355.exceptions;

public class UsernameExistsException extends Exception {

    public UsernameExistsException() {super();}
    public UsernameExistsException(String message) {super(message);}
    public UsernameExistsException(String message, Throwable cause) {super(message, cause);}
    public UsernameExistsException(Throwable cause) {super(cause);}

}
