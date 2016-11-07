/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

public class ListImpl implements List {

    private int size;
    private Nodo first;

    ListImpl(Nodo first) {
        this.first = first;
        size++;
    }

    ListImpl() {
        size = 0;
        first = null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(int dato) {
        boolean flag;
        if (isEmpty()) {
            first = new Nodo(dato);
            flag = true;
        } else {
            Nodo aux = first;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(new Nodo(dato));
            flag = true;
        }
        size++;
        return flag;
    }

    @Override
    public boolean add(int index, int dato) throws NullPointerException {
        int posicion = 0;
        
        try {
            if (index < 0 || index > size()) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            System.err.println("La posición indicada no se encuentra dentro del rango existente");
            System.out.println(e);
            return false;
        }
        if (index == 0) {
            Nodo tmp = first;
            first = new Nodo(dato, tmp);
            ++size;
            return true;
        }
        Nodo aux = first;
        while (aux.getNext() != null && posicion != index-1) {
            aux = aux.getNext();
            posicion++;
        }
        Nodo nuevo = new Nodo(dato, aux.getNext());
        aux.setNext(nuevo);
        ++size;
        return true;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            System.out.println("La lista se encuentra vacía");
        } else {
            clearRecurse(first);
            System.out.println("La lista fue vaciada por completo");
        }
    }

    void clearRecurse(Nodo borrar) {
        if (borrar.getNext() == null) {
            borrar = null;
        } else {
            clearRecurse(borrar.getNext());
            borrar.setNext(null);
            borrar = null;
            size--;
        }

    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            Nodo aux = first;
            while (aux.getNext() != null) {
                System.out.print(" " + aux.getDato());
                aux = aux.getNext();
            }
            System.out.println(" " + aux.getDato());
        }
    }

    @Override
    public boolean contains(int d) {
        int contiene = 0;
        if (isEmpty()) {
            System.err.println("La lista se encuentra vacía");
            return false;
        } else {
            Nodo aux = first;
            if (first.getDato() == d) {
                ++contiene;
            }
            while (aux.getNext() != null) {
                aux = aux.getNext();
                if (aux.getDato() == d) {
                    ++contiene;
                }
            }
            if (contiene > 0) {
                System.out.println((contiene == 1) ? "La lista contiene " + contiene + " vez el número " + d : "La lista contiene " + contiene + " veces el número " + d);
            } else {
                System.out.println("La lista no contiene el número " + d);
            }
        }
        return contiene > 0;
    }

    @Override
    public int get(int index) throws NullPointerException {
        int posicion = 0;
        int valor;
        try {
            if (index < 0 || index > size()) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            System.err.println("La posicion ingresada no se encuentra dentro del rango actual en la lista");
            System.out.println(e);
            return -1;
        }
        if (isEmpty()) {
            valor = -1;
        } else {
            Nodo aux = first;
            if (index == 0) {
                valor = first.getDato();
            } else {
                while (aux.getNext() != null || posicion != index) {
                    aux = aux.getNext();
                    posicion++;
                }
                valor = aux.getDato();
            }
        }
        return valor;
    }

    @Override
    public int indexOf(int d) {
        int posicion = 0;
        if (isEmpty()) {
            System.err.println("La lista se encuentra vacía");
            return -1;
        } else {
            Nodo aux = first;
            if (d == first.getDato()) {
                return posicion;
            }
            while (aux.getNext() != null) {
                if (aux.getDato() == d) {
                    return posicion;
                } else {
                    aux = aux.getNext();
                    ++posicion;
                }
            }
            return (aux.getDato() == d) ? posicion : -1;
        }
    }

    @Override
    public boolean remove(int d) {
        boolean flag = false;
        if (first.getDato() == d) {
            Nodo aux = first;
            first = aux.getNext();
            aux.setNext(null);
            aux = null;
            return true;
        }
        Nodo aux = first;
        while (aux.getNext().getNext() != null) {
            if (aux.getDato() == d) {
                flag = true;
                break;
            }
            aux = aux.getNext();
        }
        if (flag) {
            Nodo tmp = aux.getNext();
            aux.setNext(tmp.getNext());
            tmp.setNext(null);
            tmp = null;
            size--;
            return flag;
        } else if (aux.getNext().getDato() == d) {
            aux.setNext(null);
            size--;
            return flag;
        }
        return false;
    }

    @Override
    public boolean removeIndex(int index) {
        int posicion = 0;
        try {
            if (index < 0 || index > size()) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            System.err.println("La posición indicada no se encuentra dentro del rango existente");
            System.out.println(e);
            return false;
        }
        if (index == 0) {
            Nodo tmp = first;
            first = tmp.getNext();
            tmp.setNext(null);
            tmp = null;
            --size;
            return true;
        }
        Nodo aux = first;
        while (posicion != index - 1) {
            aux = aux.getNext();
            posicion++;
        }
        Nodo tmp = aux;
        if (tmp.getNext() == null) {
            aux.setNext(tmp.getNext());
            tmp.setNext(null);
            tmp = null;
        } else {
            aux.setNext(tmp.getNext().getNext());
            tmp.setNext(null);
            tmp = null;
        }
        --size;
        return true;
    }

    @Override
    public int set(int index, int d) {
        int contenido;
        int posicion = 0;
        try {
            if (index < 0 || index > size()) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            System.err.println("La posición indicada no se encuentra dentro del rango existente");
            System.out.println(e);
            return -1;
        }
        if (index == 0) {
            contenido = first.getDato();
            first.setDato(d);
            return contenido;
        }
        Nodo aux = first;
        while (posicion != index - 1) {
            aux = aux.getNext();
            posicion++;
        }
        contenido = aux.getNext().getDato();
        aux.getNext().setDato(d);
        return contenido;
    }

    @Override
    public int[] toArray() {
        int[] arreglo = new int[size()];
        arreglo[0] = first.getDato();
        Nodo aux = first;
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = aux.getDato();
            aux = aux.getNext();
        }
        return arreglo;
    }

}
