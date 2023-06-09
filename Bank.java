import java.util.Scanner;
import java.util.HashMap;

public class Bank {
    private static HashMap<Integer, AccountDetails> accountDetailsMap = new HashMap<Integer, AccountDetails>();

    Bank() {
        FileReader fr = new FileReader("Bank.csv");
        BufferedReader br = new BufferedReader(fr);

        // first line contains the headings of the columns, here we discard the line
        br.readLine();

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

            accountDetailsMap.put(accNumber, new FruitDetails(accNumber, name, balance));
        }

        br.close();
        fr.close();
    }

    public void addAmount(int accNo) {
        Scanner sc = new Scanner(System.in)

        AccountDetails acc = accountDetailsMap.get(accNo);
        double balance = acc.getBalance();

        System.out.print("Enter amount to add: ");
        float amount = sc.nextFloat();
        acc.setBalance(balance + amount);
    }

    public void withdraw(int accNo) {
        Scanner sc = new Scanner(System.in)

        AccountDetails acc = accountDetailsMap.get(accNo);
        double balance = acc.getBalance();

        System.out.print("Enter amount to withdraw: ");
        float amount = sc.nextFloat();

        if (amount > balance) {
            System.out.println("Insufficient balance");
            return;
        }

        acc.setBalance(balance - amount);
    }
}
