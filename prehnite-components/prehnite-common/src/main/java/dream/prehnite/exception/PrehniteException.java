package dream.prehnite.exception;

/**
 * Created by niuqinghua on 2015/7/9.
 */
public class PrehniteException extends RuntimeException {

    public PrehniteException() {
    }

    public PrehniteException(String message) {
        super(message);
    }

    public PrehniteException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrehniteException(Throwable cause) {
        super(cause);
    }
}
