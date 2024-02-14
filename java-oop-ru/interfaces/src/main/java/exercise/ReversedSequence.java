package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String sequence;

    public ReversedSequence(String sequence) {
        this.sequence = sequence;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    @Override
    public String toString() {
        String rev = "";
        char ch;
        for (int i = 0; i < sequence.length(); i++) {
            ch = sequence.charAt(i);
            rev = ch + rev;
        }
        return rev;
    }
}
// END
