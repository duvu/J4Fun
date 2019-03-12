package be.vdab.exception;

/**
 * @author beou on 3/12/19 17:23
 */
public class WerknemerException extends IllegalArgumentException {

    private static final long serialVersionUID = -3963898248978293392L;

    /**
     * Constructs an <code>IllegalArgumentException</code> with the
     * specified detail message.
     *
     * @param s the detail message.
     */
    public WerknemerException(String s) {
        super(s);
    }
}
