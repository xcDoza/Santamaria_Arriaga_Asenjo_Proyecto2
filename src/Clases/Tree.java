/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author sebas
 */
public class Tree {

    private NodoTree root;
    private int keyCounter;

    public Tree() {
        this.root = null;
        this.keyCounter = 0;
    }

    public NodoTree getRoot() {
        return root;
    }

    public void setRoot(NodoTree root) {
        this.root = root;
    }

    public int getKeyCounter() {
        return keyCounter;
    }

    public void setKeyCounter(int keyCounter) {
        this.keyCounter = keyCounter;
    }

    public boolean isEmpty() {
        return getRoot() == null;
    }

    public NodoTree insert(Object element, int fatherKey, NodoTree pointer) {
        NodoTree nodo = new NodoTree(element, getKeyCounter());
        if (isEmpty()) {
            setRoot(nodo);
        } else {
            if (pointer.getKey() == fatherKey) {
                increaseSons(pointer, nodo);
            } else {
                for (int i = 0; i < pointer.getSons().length; i++) {
                    insert(element, fatherKey, pointer.getSons()[i]);
                }
            }
        }
        keyCounter++;
        return nodo;
    }

    public void increaseSons(NodoTree father, NodoTree nodo) {
        NodoTree[] newSons = new NodoTree[father.getSons().length + 1];
        for (int i = 0; i < father.getSons().length; i++) {
            newSons[i] = father.getSons()[i];
        }
        newSons[newSons.length - 1] = nodo;
        father.setSons(newSons);
    }

    public void print(NodoTree root) {
        if (isEmpty()) {
            System.out.println("The tree is empty");
        } else {
            System.out.println("[" + root.getElement() + "]");
            for (int i = 0; i < root.getSons().length; i++) {
                print(root.getSons()[i]);
            }
        }
    }
}
