package com.ds.concept.Part2.배열;

import java.util.NoSuchElementException;

public class ArrayDs <E> implements ListAdt<E> {
    private E a[]; // 요소들을 저장할 배열
    private int size; // 현재 배열의 항목 수

    public ArrayDs() {
        a = (E[]) new Object[1];
        size = 0;
    }

    @Override
    public E peek(int index) {
        if (size == 0) {
            throw new NoSuchElementException(); // underflow
        }

        return a[index];
    }

    @Override
    public E indexOf(E item) {
        return null;
    }

    @Override
    public void insert(int index, E item) {
        if (size == a.length) { // 배열에 빈 공간이 없다면
            resize(a.length * 2); // 배열의 크기를 2배로 키워라.
        }
        // 삽입할 인덱스 부터 한칸 씩 밀어낸다.
        for (int i = size - 1; i >= index; i--) {
            a[i+1] = a[i]; // 한칸 뒤에 저장하기
        }
        a[index] = item; // 삽입해야할 위치에 넣기
        size++; // 현재 배열 크기
    }

    @Override
    public void insertLast(E newItem) {
        if (size == a.length) { // 배열에 빈 공간이 없다면
            resize(a.length * 2 ); // 배열의 크기를 2배로 키워라.
        }
        a[size++] = newItem; // 새 항목을 삽입한 후에 size 를 +1 한다.
    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    /**
     * 배열의 크기를 확대 또는 축소
     * @param newSize
     */
    private void resize(int newSize) {
        // 새로운 배열 생성
        Object[] target = new Object[newSize]; // 입력받은 크기에 맞는 배열 생성

        // 값 복사
        for (int i = 0; i < size; i++) {
            target[i] = a[i];
        }

        // 참조 변경
        a = (E[]) target;
    }
}
