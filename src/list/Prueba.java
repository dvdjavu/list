/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import java.util.Arrays;

/**
 *
 * @author Alumno
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListImpl lista = new ListImpl();

        lista.add(2);
        lista.printList();
        lista.add(0, 1);
        System.out.println("b lajlndojow");
        lista.printList();
        lista.contains(2);
        System.out.println("El número que se encuentra en la posición 0 es: " + lista.get(0));
        System.out.println("El número que buscaste se encuentra en la posición: " + lista.indexOf(1));
        System.out.println("¿La lista esta vacia? " + lista.isEmpty());
        lista.remove(2);
        lista.printList();
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.add(2);
        lista.printList();
        lista.removeIndex(5);
        lista.printList();
        lista.set(3, -32);
        lista.printList();
        System.out.println(getMemory());
        System.gc();
        lista.clear();
        lista.printList();
        System.out.println(getMemory());
        System.gc();
        /*
        
        Listas circulares
        
         */
        ListImplCircular listaCircular = new ListImplCircular();
        System.out.println(getMemory());
        listaCircular.add(6);
        listaCircular.add(8);
        listaCircular.add(2,5);
        listaCircular.printList();
        listaCircular.clear();
        listaCircular.printList();
        System.out.println(listaCircular.size());
    }

    public static double getMemory() {
        return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
    }
}
