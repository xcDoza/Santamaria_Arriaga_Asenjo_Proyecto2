/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.arbolgenealogico;

/**
 *
 * @author xc2do
 */
public class Lista<T> {

    private Nodo<T> head;
    private Nodo<T> tail;
    private int size;

    public Lista() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean esVacio() {
        return head == null;
    }

    public void insertFinal(T info) {
        Nodo<T> nuevo = new Nodo<>(info);
        if (esVacio()) {
            head = nuevo;
            tail = nuevo;
        } else {
            Nodo<T> aux = tail;
            aux.setNext(nuevo);
            tail = nuevo;
        }
        size++;
    }

    //esto devuelve los elementos de una lista en una cadena
    @Override
    public String toString() {
        String cadena = "";
        if (esVacio()) {
            cadena = "La lista está vacía.";
        } else {
            Nodo<T> aux = head;
            for (int i = 0; i < size; i++) {
                cadena = cadena + aux.getElement();
                if (i != size - 1) {
                    cadena = cadena + ", ";
                }
                aux = aux.getNext();
            }
        }
        return cadena;
    }

    //esto devuelve el valor del nodo en la posición especificada en minúsculas y sin espacios en blanco
    public String toStringAt(int index) {
        String valor = "";
        Nodo<T> aux = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                valor = (String) aux.getElement();
            }
            aux = aux.getNext();
        }
        valor = valor.toLowerCase().trim();
        return valor;
    }

    //con esto se verifica si la lista contiene un valor especificado
    public boolean contains(T valor) {
        boolean encontrado = false;
        String aux;
        for (int i = 0; i < size; i++) {
            aux = this.toStringAt(i);
            if (aux.equals(valor)) {
                encontrado = true;
            }
        }
        return encontrado;
    }

    //esto verifica si existe un nodo con el valor especificado en la lista
    public boolean existe(T valor) {
        boolean encontrado = false;
        Nodo<T> actual = head;
        while (actual != null) {
            if (actual.getElement().equals(valor)) {
                encontrado = true;
            }
            actual = actual.getNext();
        }
        return encontrado;
    }

    //con esto se obtiene una lista de títulos ordenados alfabéticamente
    public Lista<String> obtenerTitulosOrdenados(Lista<String> titulos) {
        return ordenarLista(titulos);
    }

    //esto ordena una lista de cadenas alfabéticamente utilizando el algoritmo de ordenamiento burbuja
    private Lista<String> ordenarLista(Lista<String> lista) {
        String[] arr = new String[lista.getSize()];
        Nodo<String> actual = lista.getHead();
        int index = 0;
        while (actual != null) {
            arr[index++] = actual.getElement();
            actual = actual.getNext();
        }
        // Ordenamiento burbuja
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        Lista<String> sortedList = new Lista<>();
        for (String titulo : arr) {
            sortedList.insertFinal(titulo);
        }
        return sortedList;
    }

    //con esto se imprimen los valores de los nodos de la lista
    public void imprimir() {
        Nodo<T> aux = head;
        while (aux != null) {
            System.out.println(aux.getElement());
            aux = aux.getNext();
        }
    }

    public Nodo<T> getHead() {
        return head;
    }

    public void setHead(Nodo<T> head) {
        this.head = head;
    }

    public Nodo<T> getTail() {
        return tail;
    }

    public void setTail(Nodo<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
