package projects;

import java.util.Scanner;

public class finalCall {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("How many passwords do you want to generate? ");
            int count = scanner.nextInt();

            System.out.print("Enter the length of each password: ");
            int length = scanner.nextInt();

            RSA_Algoritham rsa = new RSA_Algoritham();
            rsa.GenerateKeys();

            for (int i = 1; i <= count; i++) {
                String password = RandompassGenerator.Random(length);
                System.out.println("\nPassword " + i + ": " + password);

                String encrypted = rsa.encrypte(password);
                System.out.println("Encrypted: " + encrypted);

                String decrypted = rsa.decrypte(encrypted);
                System.out.println("Decrypted: " + decrypted);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}


