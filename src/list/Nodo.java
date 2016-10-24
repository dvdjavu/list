/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

/**
 *
 * @author Alumno
 */
public class Nodo{
    private int dato;
    private Nodo next;

    public Nodo(int dato) {
        this.dato = dato;
        this.next = null;
    }

    public Nodo(int dato, Nodo next) {
        this.dato = dato;
        this.next = next;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}
