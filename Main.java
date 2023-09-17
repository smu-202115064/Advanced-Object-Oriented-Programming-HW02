import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;

class MyStack<E> implements Iterable<E> {
    protected ArrayList<E> data;

    public MyStack() {
        data = new ArrayList<>();
    }

    public void push(E e) {
        data.add(e);
    }

    public E pop() {
        if (data.isEmpty()) {
            throw new EmptyStackException();
        }
        E top = data.get(data.size()-1);
        data.remove(data.size()-1);
        return top;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return new MyStackIterator();
    }

    private class MyStackIterator implements Iterator<E> {
        private int index;

        private MyStackIterator() {
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < data.size();
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException();
            }
            return data.get(index++);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyStack<Integer> intStack = new MyStack<>();
        for (int i = 0; i < 10; i++) {
            intStack.push(i);
        }

        System.out.println("Iterator 사용");
        for (Integer n : intStack) {
            System.out.println(n);
        }


        System.out.println("Pop 사용");
        while (!intStack.isEmpty()) {
            int n = intStack.pop();
            System.out.println(n);
        }

        //Boolean empty = ;
        System.out.printf("스택이 비었는지 확인: %s\n", intStack.isEmpty());
    }
}
