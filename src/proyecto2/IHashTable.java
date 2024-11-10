/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Eddy
 */
public interface IHashTable {
    
    public Object get(String key);
    public void remove(String key);
    public void add(String key);
    public boolean isEmpty();
    public int getSize();
    public int hash(String key);
    public long transformString(String c);
}
