
package proyecto2;

import Clases.Persona;

public interface IHashTable {
    
    public Persona get(String key);
    public void remove(String key);
    public void add(Persona person, boolean mote);
    public boolean isEmpty();
    public int getMax();
    public int hash(String key, boolean mote);
    public long transformString(String key);
}
