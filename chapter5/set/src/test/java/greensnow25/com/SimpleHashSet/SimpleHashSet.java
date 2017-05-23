package greensnow25.com.SimpleHashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * public class SimpleHashSet.
 *
 * @author greensnow25.
 * @version 1.
 * @since 23.05.2017.
 */
public class SimpleHashSet<E> implements ISimpleHashSet<E>{

    private Object[][] set;
    int io = 0;

    public SimpleHashSet(int size){
        this.set = new Object[size][size];
    }


    @Override
    public boolean add(E e) {
        int h = e.hashCode();
        return false;
    }


    @Override
    public Iterator<E> iterator() {
        return null;
    }


}
