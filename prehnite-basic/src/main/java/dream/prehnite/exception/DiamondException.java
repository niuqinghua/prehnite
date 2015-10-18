package dream.prehnite.exception;

/**
 * Created by niuqinghua on 2015/7/9.
 */
public class DiamondException extends RuntimeException {

    public DiamondException() {
    }

    public DiamondException(String message) {
        super(message);
    }

    public DiamondException(String message, Throwable cause) {
        super(message, cause);
    }

    public DiamondException(Throwable cause) {
        super(cause);
    }
}
