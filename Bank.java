import java.util.Scanner;
import java.util.HashMap;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Bank {
    private HashMap<Integer, AccountDetails> accountDetailsMap;

    Bank() {
        this.accountDetailsMap = new HashMap<Integer, AccountDetails>();
        try (FileReader fr = new FileReader("Bank.csv");
                BufferedReader br = new BufferedReader(fr);) {
            String line = "";
            // populate hashmap to store account details
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.equals("")) {
                    continue;
                }
                // generate individual strings seperated by comma
                final String[] words = line.split(",");
                final int accNumber = Integer.parseInt(words[0].trim());
                final String name = words[1].trim();
                final Double balance = Double.parseDouble(words[2].trim());
                accountDetailsMap.put(accNumber, new AccountDetails(accNumber, name, balance));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void addAmount(int accNo) {
        Scanner sc = new Scanner(System.in);

        AccountDetails acc = accountDetailsMap.get(accNo);
        double balance = acc.getBalance();

        System.out.print("Enter amount to add: ");
        float amount = sc.nextFloat();
        acc.setBalance(balance + amount);
        sc.close();
    }

    public void withdraw(int accNo) {
        Scanner sc = new Scanner(System.in);

        AccountDetails acc = accountDetailsMap.get(accNo);
        double balance = acc.getBalance();

        System.out.print("Enter amount to withdraw: ");
        float amount = sc.nextFloat();

        if (amount > balance) {
            System.out.println("Insufficient balance");
            sc.close();
            throw new Error("insufficient amount");
        }

        acc.setBalance(balance - amount);
        sc.close();
    }

    public void write() throws IOException {
        FileWriter fw = new FileWriter("Bank.csv");
        BufferedWriter bw = new BufferedWriter(fw);

        for (Integer accountNumber : accountDetailsMap.keySet()) {
            AccountDetails details = accountDetailsMap.get(accountNumber);
            String outputString = String.format("%d,%s,%.2f", accountNumber, details.getName(),
                    details.getBalance());
            bw.write(outputString);
            bw.newLine();
        }

        bw.close();
        fw.close();
    }
}
