import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) throws FileNotFoundException, IOException {
        Bank bank = new Bank();
<<<<<<< HEAD
        HashMap<Integer, AccountDetails>mp=bank.getMap();
=======
<<<<<<< HEAD
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
=======
>>>>>>> 0ff19a6e1b9fa1b2980d2827791bf3f8d44e21ce
        try (InputStreamReader isr = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(isr);) {
            System.out.println("-------- Welcome to the Banking System --------");
            System.out.print("Enter Account Number :: ");
            int accountNumber = Integer.parseInt(br.readLine());
            boolean continueTransaction = true;
            if(mp.containsKey(accountNumber))
            {
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
            bank.write();
        }
        else
        System.out.println("Account number does not exits in our Bank");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
>>>>>>> 239e911fb3e4727df4991d220285854e4496ffdc
    }
}