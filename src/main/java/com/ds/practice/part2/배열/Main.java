package com.ds.practice.part2.배열;

public class Main {

    public static void main(String[] args) {
        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        dynamicArray.insertLast(1);
        dynamicArray.insertLast(2);
        dynamicArray.insertLast(3);

        System.out.println(dynamicArray.peek(0));

        System.out.println(dynamicArray.peek(1));
//        System.out.println(dynamicArray.peek(5));
    }
}
