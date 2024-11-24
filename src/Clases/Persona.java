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

    public Persona(String nombre, String apodo, int maxAtributos, int contador) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.atributos = new ListaArray(maxAtributos); // Tamaño fijo
        // Inicializar con "none" en todas las posiciones
        for (int i = 0; i < maxAtributos; i++) {
            atributos.insertFinal("none");
        }
    }

    public String getNumeric() {
        return getAtributo("Of his name"); // tengo que confirmar el indice de esto
    }

    public String getTitle() {
        return getAtributo("Held title"); // tengo que confirmar el indice de esto
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

    @Override
    public String toString() {
        return nombre; // Devuelve solo el nombre de la persona
    }

    // Buscar atributo directamente en ListaArray
    public String getAtributo(String clave) {
        return atributos.buscarPorClave(clave); // Busca clave y devuelve el valor
    }

// Extraer listas desde atributos tipo JSON
    public Lista<String> getAtributoComoLista(String clave) {
        String valor = getAtributo(clave); // Busca el valor del atributo
        Lista<String> lista = new Lista<>();
        if (valor != null && valor.startsWith("[") && valor.endsWith("]")) {
            // Extraer contenido entre corchetes y separar por comas
            valor = valor.substring(1, valor.length() - 1);
            String[] elementos = valor.split(",");
            for (String elemento : elementos) {
                lista.insertFinal(elemento.trim().replace("\"", "")); // Limpiar espacios y comillas
            }
        }
        return lista; // Retorna la lista creada
    }

}
