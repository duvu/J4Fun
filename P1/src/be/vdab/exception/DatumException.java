package be.vdab.exception;

/**
 * @author beou on 3/12/19 16:36
 */
public class DatumException extends IllegalArgumentException {

    private static final long serialVersionUID = 5892804707315737731L;

    /**
     * Constructs an <code>IllegalArgumentException</code> with the
     * specified detail message.
     *
     * @param s the detail message.
     */
    public DatumException(String s) {
        super(s);
    }
}
