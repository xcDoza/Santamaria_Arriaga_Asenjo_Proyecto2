
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
    
    private T element;
    private Nodo next;
    private Par element1;

    public Nodo(T element) {
        this.element = element;
        this.next = null;
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

    public Par getElement1() {
        return element1;
    }

    public void setElement1(Par element1) {
        this.element1 = element1;
    }
    
}