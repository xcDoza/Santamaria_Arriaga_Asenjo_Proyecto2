/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author sebas
 */
public class NodoTree {

    private Object element;
    private int key;
    private NodoTree[] sons;

    public NodoTree(Object element, int key) {
        this.element = element;
        this.key = key;
        this.sons = new NodoTree[0];
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public NodoTree[] getSons() {
        return sons;
    }

    public void setSons(NodoTree[] sons) {
        this.sons = sons;
    }
}
