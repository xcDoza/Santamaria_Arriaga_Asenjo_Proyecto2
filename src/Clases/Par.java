/*
 * Clase Par para poder representar clave-valor y poder utilizar Map
 * 
 */
package Clases;

/**
 * Constructor toma un dato de tipo estación junto con un integer
 * 
 * @author sebas
 * @param <T>
 */

public class Par <T>{
    private T clave;
    private T valor;

    public Par(T clave, T valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public T getClave() {
        return clave;
    }

    public void setClave(T clave) {
        this.clave = clave;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
}