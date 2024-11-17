/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

import Clases.Lista;
import Clases.Persona;

/**
 *
 * @author Eddy
 */
public class HashTableTitles{
   
    static final int max = 53;
    public int size;
    public Lista[] table;

    public HashTableTitles(int size, Lista[] table) {
        this.size = 0;
        this.table = new Lista[max];
        int i = 0;
        while (i < max){
           table[i] = null;
           i++;
        }
    }
    
    
    public Lista get(String key) {
        Lista l;
        int position = hash(key);
        l = table[position];                                                                                                                                                                                                                                    
        return l;
    }

    public void remove(String key) {
        int position = hash(key);
        table[position] = null;
        size--;
    }

    public void add(Persona person) {
        int position;
        String[] keys = person.getTitle().split(",");
        String key;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getMax() {
        return max;
    }

    public int hash(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public long transformString(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
