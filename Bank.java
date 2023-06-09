import java.util.HashMap;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Bank {
    private static HashMap<Integer, AccountDetails> accountDetailsMap = new HashMap<Integer, AccountDetails>();

    Bank() {
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
}
