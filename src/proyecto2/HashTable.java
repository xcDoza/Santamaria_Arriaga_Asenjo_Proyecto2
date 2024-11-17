
package proyecto2;

import Clases.Persona;

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
    public Persona get(String key, boolean mote) {
        Persona p;
        int position = hash(key, mote);
        p = table[position];
        return p;
    }

    @Override
    public void remove(String key, boolean mote) {
        int position = hash(key, mote);
        table[position] = null;
        size--;
    }

    @Override
    public void add(Persona person, boolean mote) {
        int position;
        String key;
        if (mote){
            key = person.getApodo();
            position = hash(key.toLowerCase(), mote);
        } else {        
            key = person.getApodo() + person.getNumeric();
            position = hash(key.toLowerCase(), mote);
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
    public int hash(String key, boolean mote) {
        int i = 0, p;
        long d;
        String aux;
        d = transformString(key);
        p = (int) d % getMax();
        if (mote){
            aux = table[p].getApodo();
        }else{
            aux = table[p].getNombre() + " " + table[p].getNumeric();
        }
        while (table[p] != null && aux.toLowerCase().equals(key)){
            i++;
            p = p + i * i;
            p = (int) p % size;
            if (mote){
            aux = table[p].getApodo();
            }else{
            aux = table[p].getNombre() + " " + table[p].getNumeric();
            }
        }
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