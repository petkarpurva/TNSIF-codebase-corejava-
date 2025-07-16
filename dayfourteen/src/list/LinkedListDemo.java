package list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> li = new LinkedList<Integer>();

        li.add(10);
        li.add(20);
        li.add(40);
        li.add(50);

        System.out.println(li);

        li.addFirst(5);
        System.out.println(li);

        li.add(2, 60);
        System.out.println(li);
    }
}
