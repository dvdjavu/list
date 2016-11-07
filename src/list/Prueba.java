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
//        ListImpl lista = new ListImpl();
//
//        lista.add(2);
//        lista.printList();
//        lista.add(0, 1);
//        System.out.println("");
//        lista.printList();
//        lista.contains(2);
//        System.out.println("El número que se encuentra en la posición 0 es: " + lista.get(0));
//        System.out.println("El número que buscaste se encuentra en la posición: " + lista.indexOf(1));
//        System.out.println("¿La lista esta vacia? " + lista.isEmpty());
//        lista.remove(2);
//        
//        lista.printList();
//        lista.add(2);
//        lista.add(2);
//        lista.add(2);
//        lista.add(2);
//        lista.printList();
//        lista.removeIndex(5);
//        lista.printList();
//        lista.set(3, -32);
//        lista.printList();
//        System.out.println(getMemory());
//        System.gc();
//        lista.clear();
//        lista.printList();
//        System.out.println(getMemory());
//        System.gc();
        /*
        
        Listas circulares
        
         */
        ListImplCircular listaCircular = new ListImplCircular();
        listaCircular.add(6);
        listaCircular.add(8);
        listaCircular.add(0,5);
        listaCircular.add(2,5);
        listaCircular.printList();
        listaCircular.contains(5);
        listaCircular.printList();
        System.out.println(listaCircular.size());
        listaCircular.get(5);
        listaCircular.printList();
        listaCircular.remove(5);
        listaCircular.printList();
        listaCircular.removeIndex(0);
        listaCircular.printList();
        listaCircular.set(0, 4);
        listaCircular.printList();
        listaCircular.clear();
        listaCircular.printList();
        System.out.println(Arrays.toString(listaCircular.toArray()));
        /*
        
        Listas circulares
        
         */
//        ListImplDobleCircular listaDobleCircular = new ListImplDobleCircular();
//        listaDobleCircular.add(6);
//        listaDobleCircular.add(8);
//        listaDobleCircular.add(2,5);
//        listaDobleCircular.printList();
//        listaDobleCircular.clear();
//        listaDobleCircular.printList();
//        System.out.println(listaDobleCircular.size());
    }

    public static double getMemory() {
        return (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
    }
}
