package com.ds.practice.part2.단순연결리스트;

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getItem() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setItem(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
