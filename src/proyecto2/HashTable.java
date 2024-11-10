
package proyecto2;

public class HashTable implements IHashTable{

    static final int max = 53;
    public int size;
    public Persona[] table;

    public HashTable() {
        this.size = 0;
        this.table = new Persona[max];
        int i = 0;
        while (i < max){
           table[i] = null;
           i++;
        }
    }
    
    @Override
    public Persona get(String key) {
        Persona p;
        int position = hash(key);
        p = table[position];
        return p;
    }

    @Override
    public void remove(String key) {
        int position = hash(key);
        table[position] = null;
        size--;
    }

    @Override
    public void add(Persona person, boolean mote) {
        int position;
        String key;
        if (mote){
            key = person.getMote();
            position = hash(key);
        } else {        
            key = person.getName() + person.getNumeric();
            position = hash(key);
        }
        table[position] = person;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getMax() {
        return max;
    }

    @Override
    public int hash(String key) {
        int i = 0, p;
        long d;
        String aux;
        d = transformString(key);
        p = (int) d % getMax();
        aux = table[p].getNombre() + table[p].getNumeric();
        while (table[p] != null && aux.equals(key))
            p++;
            aux = table[p].getName() + table[p].getNumeric();
        return p;
    }

    @Override
    public long transformString(String key) {
        long d = 0;
        int i = 0;
        while (i < key.length()){
            d = d * 27 + (int) key.charAt(i);
            i++;
        }
        if (d < 0){
            d = -d;
        }
        return d;
    }


}