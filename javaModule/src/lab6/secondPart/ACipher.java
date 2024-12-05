package lab6.secondPart;

public class ACipher implements ICipher {
    @Override
    public String encode(String text) {
        return text.chars()
                .mapToObj(c -> String.valueOf((char) (c + 1)))
                .reduce("", String::concat);
    }

    @Override
    public String decode(String text) {
        return text.chars()
                .mapToObj(c -> String.valueOf((char) (c - 1)))
                .reduce("", String::concat);
    }
}
