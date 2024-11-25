/*
 * Implementa un mapa genérico utilizando una lista enlazada para almacenar pares clave-valor.
 */
package Clases;

/**
 * Lista que almacena pares clave-valor
 * @author sebas
 * @param <K>
 * @param <V>
 */
public class Map<K, V> {

    public Lista<Par<K, V>> pares;

    public Map() {
        this.pares = new Lista<>();
    }

    public void put(K clave, V valor) {
        if (clave == null) {
            throw new IllegalArgumentException("La clave no puede ser null");
        }
        Nodo<Par<K, V>> current = pares.getHead();

        // Verificar si la clave ya existe
        while (current != null) {
            Par<K, V> parExistente = current.getElement();
            if (parExistente != null && clave.equals(parExistente.getClave())) {
                parExistente.setValor(valor); // Actualizar valor
                return;
            }
            current = current.getNext();
        }
        // Insertar nuevo par si la clave no existe
        pares.insertFinal(new Par<>(clave, valor));
    }

    public V get(K clave) {
        if (clave == null) {
            throw new IllegalArgumentException("La clave no puede ser null");
        }
        Nodo<Par<K, V>> current = pares.getHead();

        // Buscar el nodo con el par correspondiente a la clave
        while (current != null) {
            Par<K, V> par = current.getElement();
            if (par != null && clave.equals(par.getClave())) {
                return par.getValor(); // Retornar el valor si la clave coincide
            }
            current = current.getNext();
        }
        return null; // Retornar null si la clave no existe en el mapa
    }

    public boolean containsKey(K clave) {
        Nodo<Par<K, V>> current = pares.getHead();
        while (current != null) {
            if (clave.equals(current.getElement().getClave())) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void remove(K clave) {
        if (clave == null) {
            throw new IllegalArgumentException("La clave no puede ser null");
        }
        Nodo<Par<K, V>> prev = null;
        Nodo<Par<K, V>> current = pares.getHead();

        while (current != null) {
            if (clave.equals(current.getElement().getClave())) {
                if (prev == null) {
                    pares.deleteBegin();
                } else {
                    prev.setNext(current.getNext());
                }
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }

    public int size() {
        return pares.getSize();
    }
    
    public Lista<Par<K, V>> entrySet() {
    return pares;
    }
}
