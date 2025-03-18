package com.ds.concept.Part2.이중연결리스트;

import java.util.NoSuchElementException;

public class DoublyLinkedList <T> {
    protected Node<T> head, tail;
    protected int size;

    public DoublyLinkedList() {
        // head 선언
        head = new Node<>(null, null, null);
        // tail 선언 - 이전 노드로 head
        tail = new Node<>(null, head, null);
        // head 의 다음 노드로 tail
        head.setNext(tail);
        // 아직 배열의 요소가 추가되지 않았기 때문에 크기는 0으로 초기화
        size = 0;
    }

    public void insertBefore(Node<T> node, T item) {
        // 기준 노드의 이전 노드 선언
        Node<T> beforeNode = node.getPrevious();
        // 삽입할 노드 선언
        Node<T> newNode = new Node<>(item, beforeNode, node);
        // 이전 노드의 next 를 삽입할 노드로 설정
        beforeNode.setNext(newNode);
        // 기준 노드의 previous 를 삽입할 노드로 설정
        node.setPrevious(newNode);
        // 배열의 크기 증가
        size++;
    }

    public void insertAfter(Node<T> node, T item) {
        // 기준 노드의 next 노드 선언
        Node<T> afterNode = node.getNext();
        // 삽입할 노드 생성
        Node<T> newNode = new Node<>(item, node, afterNode);
        // 연결 조정 - 기준 노드의 next 변경
        node.setNext(newNode);
        // 연결 조정 - afterNode 의 previous 변경
        afterNode.setPrevious(newNode);
        // 배열의 크기 증가
        size++;
    }

    public void delete(Node<T> node) {
        // 삭제할 것이 없을 때 예외 처리
        if (node == null) {
            throw new NoSuchElementException();
        }
        // 아이디어 : 기준 노드에 연결되어 있는 것을 끊어서 다시 연결시킨다.
        // 기준 노드의 이전 노드 선언
        Node<T> beforeNode = node.getPrevious();
        // 기준 노드의 이후 노드 선언
        Node<T> afterNode = node.getNext();
        // 이전 노드의 next 변경 (node -> afterNode)
        beforeNode.setNext(afterNode);
        // 이후 노드의 previous 변경 (node -> beforeNode)
        afterNode.setPrevious(beforeNode);
        // 배열의 크기 감소
        size--;
    }
}
