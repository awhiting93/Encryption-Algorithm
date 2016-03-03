import java.util.Scanner;

/**
 * 
 */

/**
 * @author awhiting18
 *
 */
public class EncryptionTest {
	
	public static void main(String[] args) {
		String plainText;
		Encryption encryption = new Encryption();
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the text to encrypt: ");
		plainText = keyboard.nextLine();
		
		// Perform encryption processes
		encryption.setPlainText(plainText);
		encryption.encrypt(encryption.encrypt());
		
		// Print results
		System.out.println("--[ Original Text: " + plainText + " ]--");
		System.out.println("--[ Encrypted Text: " + encryption.getCipherText());
		System.out.println(encryption.getKey() + " ]--");
//		System.out.println("--[ Original Length: " + plainText.length() + " ]--");
//		System.out.println("--[ Encrypted Length: " + encryption.getCipherText().length() + " ]--");
//		System.out.println("--[ Base Key: " + encryption.getBaseKey() + " ]--");
//		System.out.println("--[ Character Base String: " + encryption.getCharacterKey() + " ]--");
//		System.out.println("--[ Alphabet Used: " + encryption.getAlphabetUsed() + " ]--");
	}

}
