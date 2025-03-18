package com.ds.practice.part2.단순연결리스트;

import java.util.NoSuchElementException;

public class SinglyLinkedList <T extends Comparable<T>> {

    public Node<T> head; // 첫 번째 노드
    public int size; // 현재 배열 크기

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    // 순차 탐색
    public int search(Node<T> node) {
        // 예외 처리
        if (size == 0) {
            throw new NoSuchElementException();
        }
        // 현재 배열을 저장한다.
        Node<T> current = head;
        // 현재 배열 크기 만큼 순회한다.
        for (int i = 0; i <= size; i++) {
            // 매개변수 node 와 i 로 받는 인덱스의 요소(노드) 비교
            if (node.getItem().compareTo(current.getItem()) == 0) {
                // 두 개의 노드가 동일하면 해당 인덱스 반환
                return i;
            }
            // 반환되지 않았다면 저장된 배열을 넘어간다.
            current = current.getNext();
        }
        // 반복문을 실행한 후에도 반환되지 않았다면 없다는 의미
        return -1;
    }

    public void insertFirst(T newItem) {
        // 기존의 헤드를 next 로 가지는 노드를 만든다.
        head = new Node<T>(newItem, head);
        // 배열의 크기를 증가시킨다.
        size++;
    }

    public void insertAfter(T newItem, Node<T> node) {
        // 기준 노드의 다음 노드를 선언한다.
        Node<T> nextNode = node.getNext();
        // 다음 노드를 next 로 가지는 노드를 생성한다.
        Node<T> newNode = new Node<>(newItem, nextNode);
        // 기준 노드의 next 를 생성한 노드로 변경한다.
        node.setNext(newNode);
        // 배열의 크기를 증가시킨다.
        size++;
    }

    public void deleteFirst() {
        // 예외처리
        if (size == 0) { // 리스트가 비어있는 경우에 대한 예외 처리
            throw new NoSuchElementException();
        }
        // 헤드를 헤드의 다음 노드로 변경한다.
        head = head.getNext();
        // 배열의 크기를 감소시킨다.
        size--;
    }

    public void deleteAfter(Node<T> node) {
        // 기준 노드의 다음 노드를 선언한다.
        Node<T> nextNode = node.getNext();
        // 기준 노드의 next 를 선언한 노드의 다음 노드로 변경한다.
        node.setNext(nextNode.getNext());
        // 선언한 노드의 next 를 null 로 변경한다.
        nextNode.setNext(null);
        // 배연의 크기를 감소시킨다.
        size--;
    }
}
