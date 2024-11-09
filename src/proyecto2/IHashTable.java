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
    
    public Object get(K key);
    public void remove(K key);
    public void add();
    public boolean isEmpty();
    public int getSize();
}
