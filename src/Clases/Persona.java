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
    private Lista<String> atributos;

    public Persona(String nombre, String apodo) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.atributos = new Lista<>();
    }

    public void addAtributo(String atributo) {
        atributos.insertFinal(atributo);
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

    public Lista<String> getAtributos() {
        return atributos;
    }

    public void setAtributos(Lista<String> atributos) {
        this.atributos = atributos;
    }

}
