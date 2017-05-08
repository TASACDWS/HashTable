/**
 * Created by silvia valencia on 4/28/2017.
 */
public class HashTableExample {
    public static void main(String[] args) {
        try {
            int i, n, resp;
            int table_size = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Enter the size of the table"));
            HashTable hashTable = new HashTable(table_size);
            String key;
            String value;
            do {
                resp = Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Options "
                        + "Put (1) Search (2) Remove (3) Exit (4)"));
                switch (resp) {
                    case 1:
                        key = javax.swing.JOptionPane.showInputDialog("Insert the entry key to put:");
                        value = javax.swing.JOptionPane.showInputDialog("Insert the entry value to put:");
                        hashTable.put(key, value);
                        break;
                    case 2:
                        key = javax.swing.JOptionPane.showInputDialog("Insert the entry key to search:");
                        value = hashTable.get(key).toString();
                        if (value != null) {
                            javax.swing.JOptionPane.showMessageDialog(null, value);
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(null, "Entry not found");
                        }
                        break;
                    case 3:
                        key = javax.swing.JOptionPane.showInputDialog("Insert the entry key to remove:");
                        hashTable.remove(key);
                        javax.swing.JOptionPane.showMessageDialog(null, "Entry removed");
                        break;
                    case 4:
                        System.exit(0);
                    default:
                }
            } while (resp != 4);
        } catch (NumberFormatException nfe) {
            javax.swing.JOptionPane.showMessageDialog(null, "Exit the program");
        } catch (OutOfMemoryError ome) {
            javax.swing.JOptionPane.showMessageDialog(null, "No memory space");
        }
    }
}
