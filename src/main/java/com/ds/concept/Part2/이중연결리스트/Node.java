package com.ds.concept.Part2.이중연결리스트;

public class Node <T> {
    private T item;
    private Node<T> previous;
    private Node<T> next;

    public Node(T item, Node<T> previous, Node<T> next) {
        this.item = item;
        this.previous = previous;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
