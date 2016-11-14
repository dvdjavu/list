package list;

public class ListImplDoble implements List {

    private int size;
    private NodoDoble first;

    ListImplDoble(NodoDoble first) {
        this.first = first;
        size++;
    }

    ListImplDoble() {
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
            first = new NodoDoble(dato);
            flag = true;
        } else {
            NodoDoble aux = first;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            NodoDoble nuevo = new NodoDoble(aux, dato);
            aux.setNext(nuevo);
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
        if (isEmpty()) {
            add(dato);
            return true;
        }
        if (index == 0) {
            NodoDoble tmp = first;
            NodoDoble nuevo = new NodoDoble(first.getBefore(), dato, first);
            first = nuevo;
            tmp.setBefore(nuevo);
            ++size;
            return true;
        }
        NodoDoble aux = first;
        while (posicion != index - 1) {
            aux = aux.getNext();
            posicion++;
        }
        NodoDoble nuevo = new NodoDoble(aux, dato, aux.getNext());
        aux.setNext(nuevo);
        aux.getNext().setBefore(nuevo);
        ++size;
        return true;
    }

    @Override
    public void clear() {
        if (isEmpty()) {
            System.out.println("La lista se encuentra vacía");
        } else {
            clearRecurse(first);
            first = null;
            size--;
            System.out.println("La lista fue vaciada por completo");
        }
    }

    void clearRecurse(NodoDoble borrar) {
        if (borrar.getNext() == null) {
            borrar.setBefore(null);
            borrar = null;
            size--;
        } else {
            clearRecurse(borrar.getNext());
            borrar.setNext(null);
            borrar.setBefore(null);
            borrar = null;
            --size;
            System.gc();
        }
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("La lista esta vacía");
        } else {
            NodoDoble aux = first;
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
            NodoDoble aux = first;
            while (aux.getNext() != null) {
                if (aux.getDato() == d) {
                    ++contiene;
                }
                aux = aux.getNext();
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
            NodoDoble aux = first;
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
            NodoDoble aux = first;
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
            NodoDoble aux = first;
            first = aux.getNext();
            aux.setNext(null);
            aux = null;
            return true;
        }
        NodoDoble aux = first;
        while (aux.getNext() != null) {
            if (aux.getDato() == d) {
                flag = true;
                break;
            }
            aux = aux.getNext();
        }
        if (!flag) {
            if(aux.getDato() == d){
                aux.getBefore().setNext(null);
                aux = null;
                size--;
                return true;
            }
        }
        if (flag) {
            aux.getBefore().setNext(aux.getNext());
            aux.getNext().setBefore(aux.getBefore());
            aux.setBefore(null);
            aux.setNext(null);
            aux = null;
            size--;
            return true;
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
            NodoDoble tmp = first;
            first = tmp.getNext();
            tmp.setNext(null);
            tmp = null;
            --size;
            return true;
        }
        NodoDoble aux = first;
        while (posicion != index - 1) {
            aux = aux.getNext();
            posicion++;
        }
        NodoDoble tmp = aux;
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
        NodoDoble aux = first;
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
        NodoDoble aux = first;
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = aux.getDato();
            aux = aux.getNext();
        }
        return arreglo;
    }

}
