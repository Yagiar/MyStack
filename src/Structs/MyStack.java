package Structs;

import java.lang.reflect.Array;

public class MyStack<T> {
    T[] arr;
    int capacity;
    int length;

    public MyStack(Class clasz, int capacity) {
        arr = (T[]) Array.newInstance(clasz, capacity);
        this.capacity = capacity;
        length = 0;
    }

    public void info() {
        System.out.println("\n--------------------Start-info--------------------");
        for (int i = 0; i < length; i++) {
            System.out.println("element " + i + " = " + arr[i]);
        }
        System.out.println("\n--------------------End-info--------------------");
    }

    public boolean empty() { //Проверяет, является ли стек пустым. Возвращает true, если стек пустой. Возвращает false, если стек содержит элементы.
        return length == 0;
    }

    public T top() throws Exception { //Возвращает элемент, находящийся в верхней части стэка, но не удаляет его.
        if (length > 0) {
            return arr[length - 1];
        }
        else {
            throw new Exception("Stack empty");
        }
    }

    public T pop() throws Exception { //Возвращает элемент, находящийся в верхней части стэка, удаляя его в процессе.
        if (length > 0) {
            length--;
            return arr[length];
        }
        else {
            throw new Exception("Stack empty");
        }
    }

    public void push(T element) throws Exception { //Вталкивает элемент в стек.
        if (length < capacity) {
            arr[length] = element;
            length++;
        }
        else {
            throw new Exception("Stack overflow");
        }
    }

    public int search(T element) { //Ищет элемент в стеке. Если найден, то возвращается его смещение от вершины стека. В противном случае возвращается -1.
        for (int i = 0; i < length; i++) {
            if (element.equals(arr[i])) {
                return length - i;
            }
        }
        return -1;
    }

    public void clear() {
        length = 0;
    }

}
