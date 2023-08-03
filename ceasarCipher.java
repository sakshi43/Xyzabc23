import java.util.Scanner;

public class ceasarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your text that needs to be encrypted: ");
        String plaintext = scanner.nextLine();
        System.out.print("Enter the key: ");
        int key = scanner.nextInt();
        
        String ciphertext = encrypt(plaintext, key);
        String decryptedText = decrypt(ciphertext, key);
        
        System.out.println("**Encrypted value is**");
        System.out.println(ciphertext);
        System.out.println("**Decrypted value is**");
        System.out.println(decryptedText);
        scanner.close();
    }
    
    public static String encrypt(String plaintext, int key) {
        String alph = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        StringBuilder res = new StringBuilder();
        
        for (char ch : plaintext.toCharArray()) {
            int index = alph.indexOf(ch);
            int encryptedIndex = (index + key) % 53;
            res.append(alph.charAt(encryptedIndex));
        }
        
        return res.toString();
    }
    
    public static String decrypt(String ciphertext, int key) {
        String alph = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        StringBuilder res = new StringBuilder();
        
        for (char ch : ciphertext.toCharArray()) {
            int index = alph.indexOf(ch);
            int decryptedIndex = (index - key + 53) % 53;
            res.append(alph.charAt(decryptedIndex));
        }
        
        return res.toString();
    }
}