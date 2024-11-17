/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author xc2do
 */

public class Persona {

    private String nombre;
    private String apodo;
    private ListaArray atributos; // Cambiado a ListaArray
    private int numeric; //creo que esto es lo que buscan con el metodo numeric para personas con el mismo nombre

    public Persona(String nombre, String apodo, int maxAtributos) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.atributos = new ListaArray(maxAtributos); // Tamaño fijo
        this.numeric = 0;//para su incremento si es necesario
        // Inicializar con "none" en todas las posiciones
        for (int i = 0; i < maxAtributos; i++) {
            atributos.insertFinal("none");
        }
    }

    public int getNumeric() {
        return numeric;
    }

    public void setNumeric(int numeric) {
        this.numeric = numeric;
    }

    public void setAtributo(int index, String atributo) {
        if (index >= 0 && index < atributos.getMaxSize()) {
            atributos.getArray()[index].setElement(atributo);
        }
    }

    public String getAtributo(int index) {
        if (index >= 0 && index < atributos.getMaxSize()) {
            return (String) atributos.getArray()[index].getElement();
        }
        return "none"; // Si el índice es inválido
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public ListaArray getAtributos() {
        return atributos;
    }

    public void setAtributos(ListaArray atributos) {
        this.atributos = atributos;
    }
}
