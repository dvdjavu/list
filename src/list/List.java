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
public interface List {
    boolean add(int d);
    boolean add(int index, int d);
    void clear();
    boolean contains(int d);
    int get(int index);
    boolean isEmpty();
    int size();
    
    int indexOf(int d);
    boolean remove(int d);
    boolean removeIndex(int index);
    int set(int index, int d);
    int[] toArray();
}
