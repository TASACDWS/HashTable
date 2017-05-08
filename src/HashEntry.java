/**
 * Created by silvia valencia on 4/28/2017.
 */
public class HashEntry {
    String key;
    Object value;

    public HashEntry(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
}