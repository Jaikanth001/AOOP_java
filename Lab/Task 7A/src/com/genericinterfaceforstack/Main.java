package com.genericinterfaceforstack;

public class Main {
    public static void main(String[] args) {
        // Test LinkedListStack with Integer
        Stack<Integer> linkedListStack = new LinkedListStack<>();
        linkedListStack.push(10);
        linkedListStack.push(20);
        linkedListStack.push(30);
        System.out.println("LinkedListStack (Integer) - Peek: " + linkedListStack.peek());
        System.out.println("LinkedListStack (Integer) - Pop: " + linkedListStack.pop());
        System.out.println("LinkedListStack (Integer) - Peek: " + linkedListStack.peek());
        System.out.println("LinkedListStack (Integer) - IsEmpty: " + linkedListStack.isEmpty());

        // Test ArrayStack with String
        Stack<String> arrayStack = new ArrayStack<>(5);
        arrayStack.push("Hello");
        arrayStack.push("World");
        arrayStack.push("!");
        System.out.println("\nArrayStack (String) - Peek: " + arrayStack.peek());
        System.out.println("ArrayStack (String) - Pop: " + arrayStack.pop());
        System.out.println("ArrayStack (String) - Peek: " + arrayStack.peek());
        System.out.println("ArrayStack (String) - IsEmpty: " + arrayStack.isEmpty());

        // Test LinkedListStack with Character
        Stack<Character> charLinkedListStack = new LinkedListStack<>();
        charLinkedListStack.push('A');
        charLinkedListStack.push('B');
        charLinkedListStack.push('C');
        System.out.println("\nLinkedListStack (Character) - Peek: " + charLinkedListStack.peek());
        System.out.println("LinkedListStack (Character) - Pop: " + charLinkedListStack.pop());
        System.out.println("LinkedListStack (Character) - Peek: " + charLinkedListStack.peek());
        System.out.println("LinkedListStack (Character) - IsEmpty: " + charLinkedListStack.isEmpty());
    }
}
