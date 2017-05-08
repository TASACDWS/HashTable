/**
 * Created by silvia valencia on 4/28/2017.
 */

public class HashTable {
    private int maxEntryCollision = 0;
    private int countElements = 0;
    private double loadFactor = 0.75;
    private HashEntry[] table;

    public HashTable(int tableSize) {
        this.table = new HashEntry[tableSize];
    }

    /**
     * Calculates the pos in the table
     * @param key
     * @return
     */
    private int getHashCode(String key) {
        int sum = 0;
        for (int i = 0;i < key.length(); i++){
            sum += (int)key.charAt(i);
        }
        return sum % table.length;
    }

    /**
     * Alocates one entry in the hash table
     */
    public void alocate(HashEntry[] newTable, int hashCode, HashEntry hashEntry) {
        int entryCollision =0;

        while(newTable[hashCode] != null) {

            //If we are not in the last index of the array
            if(hashCode < newTable.length - 1) {
                hashCode += 1;

            //If we get the last index of the array
            } else {
                hashCode = 0;
            }
            entryCollision += 1;
        }

        table[hashCode] = hashEntry;

        //To keep the biggest number of collisions ever
        if (entryCollision > maxEntryCollision) maxEntryCollision = entryCollision;
    }

    /**
     * Extend the table and insert all the elements
     */
    public void realocate(int newSize){
        HashEntry[] newTable = new HashEntry[newSize];

        for(int i=0; i < table.length; i++) {
            if (table[i] != null) alocate(newTable, getHashCode(table[i].getKey()), table[i]);
        }

        this.table = newTable;
    }

    /**
     * Calculates the new size of the table
     * @return
     */
    private int getNewSize() {

        //ToDo Need to improve
        return table.length + table.length/3;
    }


    /**
     * Puts the hash table entry in the table
     * @param key
     * @param value
     */
    public void put(String key, String value) {
        int hashCode;
        countElements ++;

        //If the array tableSize is almost full, we need to resize an realocate
        if ((double)countElements / (double) table.length > loadFactor ) {
            realocate(getNewSize());
        }

        //Get the code to alocate the entry in the table
        hashCode = getHashCode(key);

        //Alocate the entry in the table
        HashEntry hash_Entry = new HashEntry(key, value);
        alocate(table, hashCode, hash_Entry);
    }

    /**
     * Gets the table pos for the entry
     * @return -1 when the key is not found
     */
    public int getPos(String key) {
        int hashCode = getHashCode(key);

        int count = 0;
        HashEntry retrievedEntry = table[hashCode];

        //To only iterate
        while(retrievedEntry.getKey() != key && count <= maxEntryCollision) {

            //If we are not in the last index of the array
            if(hashCode < table.length) {
                hashCode += 1;

                //If we get the last index of the array
            } else {
                hashCode = 0;
            }

            //Get the new entry key
            retrievedEntry = table[hashCode];
            count++;
        }

        if (count > maxEntryCollision) hashCode = -1;
        return hashCode;
    }

    /**
     * Returns the hash entry value
     * @param key
     * @return
     */
    public Object get(String key) {
        Object value = null;
        if (getPos(key) != -1) value = table[getPos(key)].getValue();
        return value;
    }

    /**
     * Removes the hash table entry from the table
     * @param key
     */
    public void remove(String key) {
        int pos = getPos(key);
        if ( pos != -1)
            table[pos] = null;
    }
}