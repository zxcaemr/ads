Project Overview: Custom Data Structures Implementation

This project provides custom implementations of fundamental data structures in Java, developed as part of Assignment 2. The goal was to build physical data structures (ArrayList and LinkedList) from scratch and use them to create logical data structures (Stack, Queue, and MinHeap) without using the java.util library.
Implemented Components
Physical Data Structures

    MyArrayList: A dynamic array-based implementation of the MyList interface. It uses an internal Object[] array that automatically resizes as elements are added.

    MyLinkedList: A doubly linked list implementation. It utilizes a private MyNode inner class with references to both next and previous nodes to allow efficient bidirectional traversal.

Logical Data Structures

    MyStack: A Last-In-First-Out (LIFO) structure built using MyArrayList for efficient tail-end operations.

    MyQueue: A First-In-First-Out (FIFO) structure built using MyLinkedList to ensure O(1) performance for both additions and removals.

    MyMinHeap: A binary heap implementation used as a priority queue, built on top of MyArrayList to maintain a complete binary tree structure.

Features and Requirements

    Generic Support: All classes support generic types T, allowing for flexible data storage.

    Manual Implementations: No external libraries were used except for the Iterator interface for collection traversal.

    Interface Driven: Both physical structures implement a comprehensive MyList<T> interface, ensuring consistency in method availability (e.g., add(), remove(), sort(), indexOf()).

    Sorting: Includes internal sorting logic based on the Comparable interface.

How to Run Tests

The project includes test cases for all methods in both MyArrayList and MyLinkedList to ensure stability and correct behavior under various conditions.

    Compile the source files using javac.

    Run the main test class to verify the functionality of the lists, stack, queue, and heap.
