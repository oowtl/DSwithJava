package com.ds.Part2.배열;

public interface ListAdt <T> {

    /**
     * List ADT
     * 리스트의 수행 연산
     * 1. Access
     * 2. Search
     * 3. Insertion
     * 4. Deletion
     */

    /**
     * index에 해당하는 item을 반환
     *
     * @param index
     * @return
     */
    public T peek(int index);

    public T indexOf(T item);

    public void insert(int index, T item);

    /**
     * 리스트의 맨 마지막에 요소를 추가
     * @param item
     */
    public void insertLast(T item);

    public boolean delete(int index);
}
