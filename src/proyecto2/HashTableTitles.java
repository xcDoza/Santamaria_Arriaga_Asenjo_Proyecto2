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

    public HashTableTitles() {
        this.size = 0;
        this.table = new Lista[max];
        int i = 0;
        while (i < max){
           table[i] = null;
           i++;
        }
    }  
    
    public Lista get(String key) {
        Lista list;
        int position = hash(key);
        list = table[position];                                                                                                                                                                                                                                    
        return list;
    }

    public void remove(String key) {
        int position = hash(key);
        table[position] = null;
        size--;
    }

    public void add(Persona person) {
        int position;
        String[] keys = person.getTitle().split(",");
        for (String key : keys){
            position = hash(key);
            if (table[position] == null){
                table[position] = new Lista();
                table[position].insertFinal(person, key);
            } else {
                if (table[position].getHead().getKey().equalsIgnoreCase(key)){
                    table[position].insertFinal(person, key);
                }else {
                    // Resolución de colisiones usando prueba cuadrática
                    int i = 1;
                    while (table[position] != null && !table[position].getHead().getKey().equalsIgnoreCase(key)) {
                        position = (position + i * i) % max;
                        i++;
                    }
                    if (table[position] == null){
                        table[position] = new Lista();
                    }
                    table[position].insertFinal(person, key);
                }
            }
        }
    }
    
    /**
     * Vacía todos los nodos de la tabla hash.
     */
    public void clear() {
        for (int i = 0; i < max; i++) {
            table[i] = null; // Elimina el nodo de cada posición
        }
        size = 0; // Reinicia el tamaño de la tabla a 0
        System.out.println("La tabla hash ha sido vaciada.");
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getMax() {
        return max;
    }

    /**
     * Método hash para calcular la posición en la tabla
     * @param key Clave para hashear
     * @return Posición en la tabla
     */
    public int hash(String key) {
        long hashValue = transformString(key); // Genera el valor hash a partir de la clave
        int position = (int) (hashValue % max);
        // Prueba cuadrática en caso de colisión
        int i = 0;
        String auxKey;
        do {
            Lista lista = table[position];
            if (lista == null) break;

            auxKey = lista.getHead().getKey();
            if (auxKey.equalsIgnoreCase(key)) break;

            i++;
            position = (position + i * i) % max;
        } while (table[position] != null);
        return position;
    }

    /**
     * Transforma un String en un valor numérico para el hash
     * @param key String a transformar
     * @return Valor hash
     */
    public long transformString(String key) {
        long hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 31) + key.charAt(i); // Función hash base 31
        }
        return Math.abs(hash);
    }
    
    public String[] getMatch(String key) {
        String[] matches = new String[0];
        for (Lista element : table){
            if(element != null && element.getHead().getKey().contains(key)){
                matches = new String[matches.length+1];
                matches[matches.length-1] = element.getHead().getKey();
            }
        }
        return matches;
    }
}
