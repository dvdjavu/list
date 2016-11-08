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

    /**
     *
     * @param d
     * @return
     */
    boolean add(int d);

    /**
     *
     * @param index
     * @param d
     * @return
     */
    boolean add(int index, int d);

    /**
     *
     */
    void clear();

    /**
     *
     * @param d
     * @return
     */
    boolean contains(int d);

    /**
     *
     * @param index
     * @return
     */
    int get(int index);

    /**
     *
     * @return
     */
    boolean isEmpty();

    /**
     * Return the value of size in the list
     * @return numer of elements in the list
     */
    int size();
    
    /**
     *
     * @param d
     * @return
     */
    int indexOf(int d);

    /**
     *
     * @param d
     * @return
     */
    boolean remove(int d);

    /**
     *
     * @param index
     * @return
     */
    boolean removeIndex(int index);

    /**
     *
     * @param index
     * @param d
     * @return
     */
    int set(int index, int d);

    /**
     *
     * @return
     */
    int[] toArray();
}
