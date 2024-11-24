
package proyecto2;

import Clases.NodoTree;

public interface IHashTable {
    
    public NodoTree get(String key, boolean mote);
    public String[] getMatch(String key, boolean mote);
    public void remove(String key);
    public void add(NodoTree person, boolean mote);
    public boolean isEmpty();
    public int getMax();
    public int hash(String key, boolean mote);
    public long transformString(String key);
}
