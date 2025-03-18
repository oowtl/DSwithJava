package com.ds.concept.Part2.단순연결리스트;

public class Node<E> {
    private E item; // 현재 노드 항목
    private Node<E> next; // 다음 노드 요소 - Node 의 레퍼런스를 저장한다.

    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }

    public E getItem() {
        return item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setItem(E item) {
        this.item = item;
    }
}
