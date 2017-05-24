package greensnow25.com;

import java.util.GregorianCalendar;

/**
 * public class SimpleMap.
 *
 * @author greensnow25.
 * @version 1.
 * @since 24.05.2017.
 */
public class SimpleMap {
    public static void main(String[] args) {
        SimpleMap sm = new SimpleMap();
        sm.add();
    }

    public void add() {
        User userOne = new User("Alexandr", 0, new GregorianCalendar(25, 06, 1987));
        User userTwo = new User("Alexandr", 0, new GregorianCalendar(25, 06, 1987));
        System.out.println(userOne.equals(userTwo));
    }
}
