/* 
 * Esta clase representa la lógica para construir y manipular un árbol genealógico a partir de datos proporcionados. 
   La clase utiliza estructuras como Tree y Map para organizar la información y permitir operaciones sobre los nodos y las relaciones familiares.
 */
package Interfaz;

import Clases.Casa;
import Clases.Lista;
import Clases.Map;
import Clases.Nodo;
import Clases.NodoTree;
import Clases.Par;
import Clases.Persona;
import Clases.Tree;

/**
 * Representa el árbol genealógico principal, donde se almacenan las relaciones entre las personas.
 * Mapa que relaciona identificadores únicos con objetos de tipo Persona. Esto permite localizar personas rápidamente.
 * @author sebas
 */

public class ArbolGenealogico {

    private Tree arbolGenealogico;
    private Map<String, Persona> mapaPersonas; // Cambiado a Map

    public ArbolGenealogico() {
        this.arbolGenealogico = new Tree();
        this.mapaPersonas = new Map<>();
    }

    public void construirArbol(Lista<Casa> casas) {
        // Paso 1: Mapear todas las personas
        Nodo<Casa> casaNodo = casas.getHead();
        while (casaNodo != null) {
            Casa casa = casaNodo.getElement();
            Nodo<Persona> personajeNodo = casa.getPersonajes().getHead();
            while (personajeNodo != null) {
                Persona persona = personajeNodo.getElement();
                if (persona == null) {
                    System.out.println("Persona nula encontrada, no se añade al mapa.");
                } else {
                    // Obtener el atributo "Of his name"
                    String ofHisName = persona.getAtributo("Of his name");
                    if (ofHisName == null || ofHisName.isEmpty()) {
                        System.out.println("Persona sin 'Of his name': " + persona.getNombre());
                        personajeNodo = personajeNodo.getNext();
                        continue;
                    }

                    // Generar clave única combinando nombre y "Of his name"
                    String[] nombre = persona.getNombre().split(" ");
                    System.out.println(nombre[0]);
                    String claveUnica = nombre[0] + "_" + ofHisName;
                    mapaPersonas.put(claveUnica, persona); // Uso de Map
                    System.out.println("Persona añadida al mapa: " + claveUnica);
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
            System.out.println("No se pudo crear el nodo raíz.");
            return;
        }
        arbolGenealogico.setRoot(nodoRaiz);

        // Paso 3: Construir árbol recursivamente
        construirHijos(nodoRaiz, fundador);
        System.out.println("Árbol construido:");
        arbolGenealogico.printAllNodes(arbolGenealogico.getRoot(), "");
    }

    private void construirHijos(NodoTree nodoPadre, Persona padre) {
        if (nodoPadre == null) {
            System.out.println("Nodo padre nulo para la persona: " + padre.getNombre());
            return;
        }

        Lista<String> hijosNombres = padre.getAtributoComoLista("Father to");
        if (hijosNombres == null || hijosNombres.esVacio()) {
            return; // No tiene hijos
        }

        Nodo<String> hijoNodo = hijosNombres.getHead();
        while (hijoNodo != null) {
            String nombreHijoLimpio = limpiarNombre(hijoNodo.getElement());
            Persona hijoEncontrado = null;

            // Buscar hijo en el mapa comparando nombre y "Of his name"
            Nodo<Par<String, Persona>> entrada = mapaPersonas.entrySet().getHead();
            while (entrada != null) {
                String clave = entrada.getElement().getClave();
                Persona candidato = entrada.getElement().getValor();

                String[] partesClave = clave.split("_");
                System.out.println(partesClave[0] + partesClave[1]);

                if (partesClave.length == 2 && partesClave[0].equalsIgnoreCase(nombreHijoLimpio)) {
                    String ofHisNameHijo = candidato.getAtributo("Of his name");
                    System.out.println("TITULO DE LA PERSONA");
                    System.out.println(ofHisNameHijo);
                    System.out.println("TITULO DEL MAP");
                    System.out.println(partesClave[1]);

                    // Verificar que "Of his name" coincide
                    if (ofHisNameHijo != null && ofHisNameHijo.equalsIgnoreCase(partesClave[1])) {
                        hijoEncontrado = candidato;
                        mapaPersonas.remove(clave); // Uso de Map
                        break;
                    }
                }
                entrada = entrada.getNext();
            }

            if (hijoEncontrado != null) {
                // Insertar hijo en el árbol
                NodoTree nodoHijo = arbolGenealogico.insert(hijoEncontrado, nodoPadre.getKey(), arbolGenealogico.getRoot());
                if (nodoHijo != null) {
                    construirHijos(nodoHijo, hijoEncontrado); // Construir recursivamente
                } else {
                    System.out.println("No se pudo insertar al hijo: " + hijoEncontrado.getNombre());
                }
            } else {
                System.out.println("Hijo no encontrado en el JSON: " + nombreHijoLimpio);
            }
            hijoNodo = hijoNodo.getNext();
        }
    }

    private Persona encontrarFundador() {
        Nodo<Par<String, Persona>> entrada = mapaPersonas.entrySet().getHead();
        while (entrada != null) {
            Persona persona = entrada.getElement().getValor();
            if (persona.getAtributo("Notes") != null && persona.getAtributo("Notes").contains("Founder")) {
                return persona;
            }
            entrada = entrada.getNext();
        }
        return null; // No se encontró
    }
    
    private String limpiarNombre(String nombreCompleto) {
        if (nombreCompleto.contains(" ")) {
            return nombreCompleto.split(" ")[0]; // Usar solo el primer nombre
        }
        return nombreCompleto;
    }

    public void imprimirArbol() {
        arbolGenealogico.printAllNodes(arbolGenealogico.getRoot(), "");
    }

    public void mostrarArbol() {
        arbolGenealogico.displayGraph();
    }

    public Tree getArbolGenealogico() {
        return arbolGenealogico;
    }
    
    
}
