package lab6.secondPart;

public class BCipher implements ICipher {
    @Override
    public String encode(String text) {
        return text.chars()
                .mapToObj(c -> {
                    if (Character.isLetter(c)) {
                        char offset = Character.isUpperCase(c) ? 'A' : 'a';
                        return String.valueOf((char) (offset + ('Z' - c)));
                    }
                    return String.valueOf((char) c);
                })
                .reduce("", String::concat);
    }

    @Override
    public String decode(String text) {
        return encode(text); // Symmetric cipher
    }
}
