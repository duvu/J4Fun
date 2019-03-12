package j4fun.countwords;

/**
 * @author beou on 3/12/19 15:29
 */
public class Main {
    public static void main(String[] args) {
        WordUtils wordUtils = new WordUtils();
        wordUtils.process("This is a test. That is not a test. Test");

        wordUtils.println();
    }
}
