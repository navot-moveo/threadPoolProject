package com.company;

public class MyQueue<T> {

    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;

        }
    }

    private QueueNode<T> first; //the first that we will get out from the queue
    private QueueNode<T> last; //the last that we will get out from the queue
    private int size = 0;

    //------------------- pay attention this is a blocking queue --------------//
    public synchronized void add(T item) {
        QueueNode<T> temp = new QueueNode<T>(item);
        //queue isn't emppty
        if(last != null) {
            last.next = temp;
        }
        last = temp;
        //queue is empty
        if(first == null) {
            first = last;
        }
        //todo think if this need to be synchronized diffrently
        size++;
        notifyAll();
    }

    public synchronized T remove() {

        if (first == null) {
            System.out.println("the queue is empty, there isn't item to remove");
        }
        T dataToReturn = first.data;
        first = first.next;
        //if we remove the last element
        if(first == null) {
            last = null;
        }
        notifyAll();
        //todo think if this need to be synchronized diffrently
        size--;
        return dataToReturn;
    }

    public T peek(){
        //queue is empty
        if(first == null) {
            System.out.println("the queue is empty, there isn't item to remove");
        }
        return first.data;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int getSize(){
        return this.size;
    }

}

