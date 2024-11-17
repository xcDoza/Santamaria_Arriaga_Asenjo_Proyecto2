/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author xc2do
 */
public class Nodo<T> {
    
    private String key;
    private T element;
    private Nodo next;

    public Nodo(T element) {
        this.element = element;
        this.key = null;
        this.next = null;
    }

    public Nodo(String key, T element) {
        this.key = key;
        this.element = element;
        this.next = null;
    }
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
}
