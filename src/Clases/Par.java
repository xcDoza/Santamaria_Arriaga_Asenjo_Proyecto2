/*
 * Clase Par para poder representar clave-valor y poder utilizar Map
 * 
 */
package Clases;

/**
 * Constructor toma un dato de tipo estación junto con un integer
 * 
 * @author sebas
 * @param <K>
 * @param <V>
 */

public class Par<K, V> {
    private K clave;
    private V valor;

    public Par(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() {
        return clave;
    }

    public void setClave(K clave) {
        this.clave = clave;
    }

    public V getValor() {
        return valor;
    }

    public void setValor(V valor) {
        this.valor = valor;
    }
    
}