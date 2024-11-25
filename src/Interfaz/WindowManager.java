/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz;

import Clases.Lista;
import Clases.Nodo;
import javax.swing.JFrame;
/**
 *
 * @author sebas
 */
public class WindowManager {
    private static Lista<JFrame> ventanas = new Lista<>(); // Lista para las ventanas

    /**
     * Registra una ventana en la lista de ventanas abiertas.
     * @param ventana La ventana que se debe registrar.
     */
    public static void registrarVentana(JFrame ventana) {
        ventanas.insertFinal(ventana);
    }

    /**
     * Cierra todas las ventanas registradas y limpia la lista.
     */
    public static void cerrarTodasLasVentanas() {
        Nodo<JFrame> actual = ventanas.getHead(); // Inicio de la lista
        while (actual != null) {
            JFrame ventana = actual.getElement();
            if (ventana != null) {
                ventana.dispose(); // Cierra la ventana
            }
            actual = actual.getNext();
        }
        ventanas = new Lista<>(); // Reinicia la lista
        System.out.println("Todas las ventanas han sido cerradas.");
    }
}
