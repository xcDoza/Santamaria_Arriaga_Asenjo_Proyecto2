/**
 * Clase ListaArray junto con sus primitivas
 *
 * @author Sebastián Arriaga
 */
package Clases;

public class ListaArray {

    private Integer head;
    private NodoArray[] array;
    private int size, maxSize;

    public ListaArray(int maxSize) {
        this.maxSize = maxSize;
        this.head = null;
        this.size = 0;
        this.array = new NodoArray[0];
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public NodoArray[] getArray() {
        return array;
    }

    public void setArray(NodoArray[] array) {
        this.array = array;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public NodoArray insertBegin(Object element) {
        NodoArray nodo = new NodoArray(element);
        if (getSize() >= getMaxSize()) {
            System.out.println("El maximo tamaño ha sido alcanzado");
            return null;
        } else {
            int position = searchSpace();
            if (position == -1) {
                nodo.setNext(getHead());
                NodoArray[] newArray = cloneArray();
                newArray[newArray.length - 1] = nodo;
                setHead(newArray.length - 1);
                setArray(newArray);
            } else {
                nodo.setNext(getHead());
                getArray()[position] = nodo;
                setHead(position);
            }
            size++;
            return nodo;
        }
    }

    public NodoArray[] cloneArray() {
        NodoArray[] newArray = new NodoArray[getArray().length + 1];
        for (int i = 0; i < getArray().length; i++) {
            newArray[i] = getArray()[i];
        }
        return newArray;
    }

    public int searchSpace() {
        for (int i = 0; i < getArray().length; i++) {
            if (getArray()[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public NodoArray insertFinal(Object element) {
        NodoArray nodo = new NodoArray(element);
        if (getSize() >= getMaxSize()) {
            System.out.println("El maximo tamaño ha sido alcanzado");
            return null;
        } else {
            if (isEmpty()) {
                insertBegin(element);
            } else {
                int position = searchSpace();
                if (position == -1) {
                    NodoArray[] newArray = cloneArray();
                    Integer pointer = getHead();
                    while (newArray[pointer].getNext() != null) {
                        pointer = newArray[pointer].getNext();
                    }
                    newArray[pointer].setNext(newArray.length - 1);
                    newArray[newArray.length - 1] = nodo;
                    setArray(newArray);
                } else {
                    Integer pointer = getHead();
                    while (getArray()[pointer].getNext() != null) {
                        pointer = getArray()[pointer].getNext();
                    }
                    getArray()[pointer].setNext(position);
                    getArray()[position] = nodo;
                }
                size++;
            }
            return nodo;
        }
    }

    public NodoArray deleteBegin() {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return null;
        } else {
            NodoArray pointer = getArray()[getHead()];
            getArray()[getHead()] = null;
            setHead(pointer.getNext());
            pointer.setNext(null);
            size--;
            return pointer;
        }
    }

    public NodoArray deleteFinal() {
        if (isEmpty()) {
            System.out.println("The list is empty");
            return null;
        } else {
            Integer pointer = getHead(); //2
            while (getArray()[getArray()[pointer].getNext()].getNext() != null) {
                pointer = getArray()[pointer].getNext();
            }
            Integer pointer2 = getArray()[pointer].getNext();
            NodoArray nodoDeleted = getArray()[pointer2];
            getArray()[pointer2] = null;
            getArray()[pointer].setNext(null);
            size--;
            return nodoDeleted;
        }
    }

    // Método para buscar un atributo por su clave
    public String buscarPorClave(String clave) {
        for (NodoArray nodo : array) {
            if (nodo != null && nodo.getElement() instanceof String) {
                String elemento = (String) nodo.getElement();
                if (elemento.startsWith(clave + ":")) {
                    return elemento.substring(clave.length() + 2).trim(); // Extraer valor después de "clave:"
                }
            }
        }
        return null; 
    }

    //esto devuelve el valor del nodo en la posición especificada en minúsculas y sin espacios en blanco
    public String toStringAt(int index) {
        if (index >= 0 && index < getMaxSize() && array[index] != null) {
            String valor = (String) array[index].getElement();
            return valor.toLowerCase().trim();
        }
        return "nada"; //si el índice es inválido o el elemento es nulo
    }

    public boolean isEmpty() {
        return getHead() == null;
    }

    public void print() {
        Integer pointer = getHead();
        while (pointer != null) {
            System.out.println("[" + getArray()[pointer].getElement() + "]");
            pointer = getArray()[pointer].getNext();
        }
    }

}
