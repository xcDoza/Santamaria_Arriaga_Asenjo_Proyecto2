/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

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
        System.out.println("Insertando: " + element + " en nodo con clave padre: " + fatherKey);

        if (pointer == null) {
            if (fatherKey == -1) { // Caso especial: insertar la raíz
                NodoTree nodo = new NodoTree(element, getKeyCounter());
                setRoot(nodo);
                keyCounter++;
                return nodo;
            } else {
                System.out.println("Puntero nulo y clave padre no es -1. No se puede insertar: " + element);
                return null; // Nodo no válido
            }
        }

        if (pointer.getKey() == fatherKey) {
            NodoTree nodo = new NodoTree(element, getKeyCounter());
            increaseSons(pointer, nodo);
            keyCounter++;
            return nodo;
        }

        for (NodoTree hijo : pointer.getSons()) {
            NodoTree resultado = insert(element, fatherKey, hijo);
            if (resultado != null) {
                return resultado;
            }
        }

        return null; // Si no se encontró el padre
    }

    public void increaseSons(NodoTree father, NodoTree nodo) {
        System.out.println("Aniadiendo hijo: " + nodo.getElement() + " al padre: " + father.getElement());

        NodoTree[] newSons = new NodoTree[father.getSons().length + 1];
        for (int i = 0; i < father.getSons().length; i++) {
            newSons[i] = father.getSons()[i];
        }
        newSons[newSons.length - 1] = nodo;
        father.setSons(newSons);
    }

    /**
     * Método para convertir el árbol en un grafo de GraphStream.
     */
    public Graph toGraph() {
        Graph graph = new SingleGraph("Tree Graph");
        if (isEmpty()) {
            System.out.println("El arbol esta vacio. No se puede mostrar.");
            return graph;
        }

        // Recorrer el árbol y añadir nodos y aristas al grafo
        addNodeToGraph(graph, root, null);

        // Configurar estilo básico del grafo
        graph.setAttribute("ui.stylesheet",
                "node { size: 20px; fill-color: blue; text-alignment: center; text-size: 15px; }"
                + "edge { fill-color: black; }");
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");
        return graph;
    }

    /**
     * Método auxiliar para recorrer el árbol y añadir nodos/aristas al grafo.
     */
    private void addNodeToGraph(Graph graph, NodoTree nodo, String parentId) {
        if (nodo == null) {
            return;
        }

        String nodeId = String.valueOf(nodo.getKey());
        graph.addNode(nodeId).setAttribute("ui.label", nodo.getElement().toString());

        if (parentId != null) {
            graph.addEdge(parentId + "-" + nodeId, parentId, nodeId);
        }

        for (NodoTree child : nodo.getSons()) {
            addNodeToGraph(graph, child, nodeId);
        }
    }

    /**
     * Método para mostrar gráficamente el árbol utilizando GraphStream.
     */
    public void displayGraph() {
        Graph graph = toGraph();
        graph.display();
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

    public void printAllNodes(NodoTree node, String prefix) {
        if (node == null) {
            return;
        }
        System.out.println(prefix + "- " + node.getElement());
        for (NodoTree hijo : node.getSons()) {
            printAllNodes(hijo, prefix + "  ");
        }
    }

    public int obtenerAlturaArbol() {
        int altura = obtenerAltura(getRoot());
        System.out.println("Altura del arbol: " + altura);
        return obtenerAltura(getRoot());
    }

    private int obtenerAltura(NodoTree nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaMaxima = 0;
        for (NodoTree hijo : nodo.getSons()) {
            alturaMaxima = Math.max(alturaMaxima, obtenerAltura(hijo));
        }
        return alturaMaxima + 1;
    }

    public ListaArray obtenerIntegrantesDeGeneracion(int generacion, int maxSize) {
        ListaArray integrantes = new ListaArray(maxSize);
        obtenerIntegrantesDeGeneracion(getRoot(), generacion -1 , 0, integrantes);
        return integrantes;
    }

    private void obtenerIntegrantesDeGeneracion(NodoTree nodo, int generacion, int nivelActual, ListaArray integrantes) {
        if (nodo == null) {
            return;
        }
        if (nivelActual == generacion) {
            integrantes.insertFinal((Persona) nodo.getElement());
            System.out.println("Aniadido: " + ((Persona) nodo.getElement()).getNombre() + " en generacion " + nivelActual);
        }
        for (NodoTree hijo : nodo.getSons()) {
            obtenerIntegrantesDeGeneracion(hijo, generacion, nivelActual + 1, integrantes);
        }
    }

}
