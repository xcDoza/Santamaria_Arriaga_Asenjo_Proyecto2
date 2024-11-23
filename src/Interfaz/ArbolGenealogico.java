/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import Clases.Casa;
import Clases.Lista;
import Clases.ListaArray;
import Clases.Nodo;
import Clases.NodoArray;
import Clases.NodoTree;
import Clases.Persona;
import Clases.Tree;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author sebas
 */
public class ArbolGenealogico {

    private Tree arbolGenealogico;
    private HashMap<String, Persona> mapaPersonas; // Mapeo de nombres a personas

    public ArbolGenealogico() {
        this.arbolGenealogico = new Tree();
        this.mapaPersonas = new HashMap<>();
    }

    // Construye el árbol genealógico a partir de las casas
    public void construirArbol(Lista<Casa> casas) {
        // Paso 1: Mapear todas las personas
        Nodo<Casa> casaNodo = casas.getHead();
        while (casaNodo != null) {
            Casa casa = casaNodo.getElement();
            Nodo<Persona> personajeNodo = casa.getPersonajes().getHead();
            while (personajeNodo != null) {
                Persona persona = personajeNodo.getElement();
                if (persona == null) {
                    System.out.println("Persona nula encontrada, no se aniade al mapa.");
                } else {
                    String nombreLimpio = limpiarNombre(persona.getNombre());
                    mapaPersonas.put(nombreLimpio, persona); // Guardar en el mapa 
                    System.out.println("Persona aniadida al mapa: " + nombreLimpio);
                }
                personajeNodo = personajeNodo.getNext();
            }
            casaNodo = casaNodo.getNext();
        }

        // Paso 2: Encontrar al fundador
        Persona fundador = encontrarFundador();
        if (fundador == null) {
            System.out.println("No se encontró al fundador.");
            return; // Salir si no hay fundador
        }

        // Crear nodo raíz
        NodoTree nodoRaiz = arbolGenealogico.insert(fundador, -1, null);
        if (nodoRaiz == null) {
            System.out.println("No se pudo crear el nodo raiz.");
            return;
        }
        arbolGenealogico.setRoot(nodoRaiz);

        // Paso 3: Construir árbol recursivamente
        construirHijos(nodoRaiz, fundador);
        System.out.println("Arbol construido:");
        arbolGenealogico.printAllNodes(arbolGenealogico.getRoot(), "");
    }

    private void construirHijos(NodoTree nodoPadre, Persona padre) {
        if (nodoPadre == null) {
            System.out.println("Nodo padre nulo para la persona: " + padre.getNombre());
            return; // No hacer nada si el nodo padre es nulo
        }

        Lista<String> hijosNombres = padre.getAtributoComoLista("Father to");
        if (hijosNombres == null || hijosNombres.esVacio()) {
            return; // No tiene hijos
        }

        Nodo<String> hijoNodo = hijosNombres.getHead();
        while (hijoNodo != null) {
            String nombreHijo = limpiarNombre(hijoNodo.getElement());
            Persona hijo = mapaPersonas.get(nombreHijo);
            if (hijo != null) {
                // Insertar hijo en el árbol
                NodoTree nodoHijo = arbolGenealogico.insert(hijo, nodoPadre.getKey(), arbolGenealogico.getRoot());
                if (nodoHijo != null) {
                    construirHijos(nodoHijo, hijo); // Construir recursivamente
                } else {
                    System.out.println("No se pudo insertar al hijo: " + hijo.getNombre());
                }
            } else {
                System.out.println("Hijo no encontrado en el JSON: " + nombreHijo);
            }
            hijoNodo = hijoNodo.getNext();
        }
    }

    private Persona encontrarFundador() {
        for (Persona persona : mapaPersonas.values()) {
            if (persona.getAtributo("Notes") != null && persona.getAtributo("Notes").contains("Founder")) {
                return persona;
            }
        }
        return null; // No se encontró
    }

    private String limpiarNombre(String nombreCompleto) {
        if (nombreCompleto.contains(" ")) {
            return nombreCompleto.split(" ")[0]; // Usar solo el primer nombre
        }
        return nombreCompleto;
    }

    // Imprime el árbol completo
    public void imprimirArbol() {
        arbolGenealogico.printAllNodes(arbolGenealogico.getRoot(), "");
    }

    // Muestra el árbol gráficamente
    public void mostrarArbol() {
        arbolGenealogico.displayGraph();
    }

    //obtener el árbol genealógico 
    public Tree getArbolGenealogico() {
        return arbolGenealogico;
    }

}
