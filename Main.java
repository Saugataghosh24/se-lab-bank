import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) throws FileNotFoundException, IOException {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        System.out.println("-------- Welcome to the Banking System --------");

        System.out.print("Enter Account Number :: ");
        int accountNumber = sc.nextInt();
        sc.nextLine();
        if (!bank.checkAccountExistance(accountNumber)) {
            System.out.println("Account does not exists!");
            System.exit(1);
        }
        boolean continueTransaction = true;
        while (continueTransaction) {
            System.out.print("Enter 0 to add balance, 1 to withdraw, -1 to exit :: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    bank.addAmount(accountNumber);
                    break;
                case 1:
                    bank.withdraw(accountNumber);
                    break;
                default:
                    continueTransaction = false;
                    break;
            }
        }
        sc.close();
        bank.write();
    }
}