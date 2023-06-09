import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(final String[] args) {
        final String outputFileName = "Bank.txt";
        Bank bank = new Bank();
        try (InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);) {
            System.out.println("-------- Welcome to the Banking System --------");
            System.out.print("Enter Account Number :: ");
            int accountNumber = Integer.parseInt(br.readLine());
            boolean continueTransaction = true;
            while (continueTransaction) {
                System.out.println("Enter 0 to add balance, 1 to withdraw balance, -1 to exit: ");
                int choice = Integer.parseInt(br.readLine());
                switch (choice) {
                    case 0:
                        bank.addAmount(accountNumber);
                    case 1:
                        bank.withdraw(accountNumber);
                    default:
                        continueTransaction = false;
                        break;
                }
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        bank.write();
    }
}