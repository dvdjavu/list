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
     * adds an item to the list
     * @param d value that will be added to the list
     * @return true if everything went well otherwise return false
     */
    boolean add(int d);

    /**
     * adds an item to the list in the indicated position
     * @param index position of the list
     * @param d value that will be added to the list
     * @return true if everything went well otherwise return false
     */
    boolean add(int index, int d);

    /**
     * uses a recursive method to delete node per node until the list is totally deleted
     */
    void clear();

    /**
     * Check if an item is in the list
     * @param d value that will be cheked if is in the list
     * @return true if exist and false if not
     */
    boolean contains(int d);

    /**
     * return a value of the list in an exact position
     * @param index the position of the value that will be substracted
     * @return the value of that position
     */
    int get(int index);

    /**
     * checks if the list is empty
     * @return true if the list is empty otherwise return false
     */
    boolean isEmpty();

    /**
     * Return the value of size in the list
     * @return numer of elements in the list
     */
    int size();
    
    /**
     * returns the index of a value if is found on the list
     * @param d the value to find
     * @return the index of the value if is found
     */
    int indexOf(int d);

    /**
     * delete an index of the list if the sended number is equal
     * @param d value that will be found and removed from the list
     * @return true if an item was deleted otherwise return false
     */
    boolean remove(int d);

    /**
     * delete an index of the list
     * @param index position of the list that will be deleted
     * @return true if the position was deleted otherwise return false
     */
    boolean removeIndex(int index);

    /**
     * replace a value with other in an exact position
     * @param index the position that will be replaced
     * @param d the value that replace the previous one
     * @return the previous value
     */
    int set(int index, int d);

    /**
     * transform the list to an array
     * @return the array of the list
     */
    int[] toArray();
}
