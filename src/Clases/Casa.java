/*
 * Esta clase representa una casa que contiene un nombre y una lista de personajes asociados a dicha casa.
 * 
 */
package Clases;

/**
 * Nombre de la casa
 * Lista de personajes que pertenecen a la casa
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
