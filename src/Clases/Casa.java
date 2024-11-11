/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author xc2do
 */
public class Casa {

    private String nombre;
    private Lista<Persona> personajes;

    public Casa(String nombre) {
        this.nombre = nombre;
        this.personajes = new Lista<>();
    }

    public void addPersonaje(Persona personaje) {
        personajes.insertFinal(personaje);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Lista<Persona> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Lista<Persona> personajes) {
        this.personajes = personajes;
    }

}
