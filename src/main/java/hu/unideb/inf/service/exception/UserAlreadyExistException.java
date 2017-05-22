package hu.unideb.inf.service.exception;

/**
 * Created by mates on 2017. 05. 20..
 */
public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException() {
    }

    public UserAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
