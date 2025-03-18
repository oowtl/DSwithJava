package com.ds.concept.Part2.단순연결리스트;

import java.util.NoSuchElementException;

public class SinglyLinkedList <T extends Comparable<T>> { // T가 비교가 가능해야 하기 때문에 Comparable 을 구현해야 한다.
    protected Node<T> head; // 연결 리스트의 첫 노드
    private int size; // 연결 리스트 요소들의 크기

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int search(T target) { // target 탐색
        // 시작점
        Node<T> current = head;
        // head 에서 시작해서 size 만큼 순회한다.
        for (int i = 0; i < this.size; i++) {
            // target 과 비교
            if (current.getItem().compareTo(target) == 0) {
                return i;
            }
            // 다음 노드로 넘어간다.
            current = current.getNext();
        }
        // 탐색 실패 시 -1 반환
        return -1;
    }

    public void insertFront(T item) {
        // head 변경
        this.head = new Node<>(item, this.head);
        // 배열 크기 증가
        this.size++;
    }

    public void insertAfter(T newItem, Node<T> node) {
        // 노드 생성 - 매개변수로 받은 노드가 가리키는 다음 노드를 가리켜야 한다.
        Node<T> newNode = new Node<>(newItem, node.getNext());
        // node 가 가리키는 다음 노드 변경하기
        node.setNext(newNode);
        // 배열 크기 증가
        this.size++;
    }

    public void deleteFront() {
        // 배열에 요소가 없는 경우 예외 발생
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        // 현재 head 를 head 의 다음 노드로 옮긴다.
        this.head = this.head.getNext();
        // 배열 크기 감소
        this.size--;
    }

    public void deleteAfter(Node<T> node) {
        // 노드의 다음 노드를 지워야 한다. == 노드의 다음 노드와 다음다음 노드간의 연결이 없어져야 한다.
        // 현재 노드와 다음 다음 노드가 연결되어야 한다.

        // 노드 값이 없는 경우 예외 발생
        if (node == null) {
            throw new NoSuchElementException();
        }
        // 1. 삭제 대상 노드
        Node<T> deletingNode = node.getNext();
        // 2. 연결 대상 노드
        Node<T> connectingNode = deletingNode.getNext();
        // 3. 현재 노드와 연결 대상 노드를 연결한다.
        node.setNext(connectingNode);
        // 4. 삭제 대상 노드와 연결 대상 노드의 연결을 끊는다.
        deletingNode.setNext(null);
        // 5. 배열 크기 감소
        this.size--;
    }
}
