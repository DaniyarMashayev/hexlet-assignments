package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    private String str;
    public NegativeRadiusException(String str) {
        this.str = str;
    }
}
// END
