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
}
