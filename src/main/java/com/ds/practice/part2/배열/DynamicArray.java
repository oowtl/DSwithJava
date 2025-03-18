package com.ds.practice.part2.배열;

import java.util.NoSuchElementException;

public class DynamicArray<T> implements ListADT<T> {

    T[] a; // 요소들을 저장할 배열
    int size = 0; // 현재 배열의 요소 수

    public DynamicArray() {
        this.a = (T[]) new Object[1];
    }

    @Override
    public T peek(int index) {
//        if (size == 0 || (size - 1 < index)) { // underflow and overflow
        if (size == 0) { // underflow and overflow
            throw new NoSuchElementException();
        }

        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return a[index];
    }

    @Override
    public T search(T item) {
        return null;
    }

    @Override
    public void insert(int index, T item) {
        // 배열의 요소가 전부 찼을 때
        if (size == a.length) {
            resize(a.length * 2);
        }
        // 들어가야할 위치에서 부터 한칸 씩 밀어낸다.
        for (int i = size - 1; i >= index; i--) {
            a[i + 1] = a[i];
        }
        // 해당 위치에 요소를 삽입한다.
        a[index] = item;
    }

    @Override
    public void insertLast(T item) {
        // 배열이 꽉 찼을 떄
        if (size == a.length) {
            resize(2 * a.length);
        }
        a[size++] = item;
    }

    @Override
    public T delete(int index) {
        // 삭제할 요소가 없는 경우 = 배열이 비어 있는 경우
        if (a.length == 0) {
            throw new NoSuchElementException();
        }
        // 삭제할 요소 저장
        T item = a[index];
        // 배열의 요소를 한 칸씩 옮긴다. = 삭제
        for (int i = index; i < size; i++) {
            a[i] = a[i + 1];
        }
        // 배열 요소의 현재 크기를 줄여준다.
        size--;
        // 배열 크기 리사이징 조건 = 현재 배열 요소의 크기가 배열의 크기의 1/4 일 때
        if (size > 0 && size == a.length / 4) {
            // 배열의 크기를 리사이징 한다.
            resize(a.length / 2);
        }

        return item;
    }

    private void resize(int capacity) {
        // 새로운 배열의 크기로 생성
        T[] temp = (T[]) new Object[capacity];

        // 기존 배열의 요소들을 복사
        for (int i = 0; i < size; i++) {
            temp[i] = a[i];
        }

        a = temp;
    }
}
