package lab6.thirdPart.Tests;

import lab6.secondPart.ACipher;
import lab6.secondPart.BCipher;
import lab6.secondPart.ICipher;

public class CipherTest {
    public static void main() {
        ICipher aCipher = new ACipher();
        ICipher bCipher = new BCipher();

        String message = "HelloWorld";

        String aEncoded = aCipher.encode(message);
        String aDecoded = aCipher.decode(aEncoded);

        System.out.println("ACipher:");
        System.out.println("Encoded: " + aEncoded);
        System.out.println("Decoded: " + aDecoded);

        String bEncoded = bCipher.encode(message);
        String bDecoded = bCipher.decode(bEncoded);

        System.out.println("\nBCipher:");
        System.out.println("Encoded: " + bEncoded);
        System.out.println("Decoded: " + bDecoded);
    }
}
