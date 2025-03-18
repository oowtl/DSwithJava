package com.ds.practice.part2.배열;

/**
 *
 * 1. Access
 * 2. Search
 * 3. Insertion
 * 4. Deletion
 *
 * @param <T>
 */
public interface ListADT<T> {
    public T peek(int index);
    public T search(T item);
    public void insert(int index, T item);
    public void insertLast(T item);
    public T delete(int index);
}
