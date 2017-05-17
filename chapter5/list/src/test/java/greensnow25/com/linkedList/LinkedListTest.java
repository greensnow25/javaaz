package greensnow25.com.linkedList;

import org.junit.Test;

import java.util.*;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * public class LinkedListTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 16.05.2017.
 */
public class LinkedListTest {
    SimpleLinkedList<String> w;
    @Test
    public void add(){
       w= new SimpleLinkedList<String>();
        w.add("dw");
        w.add("dwe");

        System.out.println(w.get(1));
    }

    @Test
    public void whenCallNextFourTimesThenReturnFour(){
        w= new SimpleLinkedList<String>();
        w.add("1111");
        w.add("2222");
        w.add("333");
        w.add("444");
        w.add("555");
        Iterator iterator = w.iterator();
        for (int i = 0; i <15;i++){
            System.out.println(iterator.next());
        }
    }








}