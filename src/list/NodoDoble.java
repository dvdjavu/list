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
public class NodoDoble{
    private int dato;
    private NodoDoble next;
    private NodoDoble before;

    public NodoDoble(int dato) {
        this.dato = dato;
        this.next = null;
    }

    public NodoDoble(int dato, NodoDoble next) {
        this.dato = dato;
        this.next = next;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoDoble getNext() {
        return next;
    }

    public NodoDoble getBefore() {
        return before;
    }

    public void setNext(NodoDoble next) {
        this.next = next;
    }
    
    public void setBefore(NodoDoble before) {
        this.before = before;
    }
    
}
