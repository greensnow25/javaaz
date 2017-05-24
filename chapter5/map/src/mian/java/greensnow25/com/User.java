package greensnow25.com;

import java.util.Calendar;

/**
 * public class User.
 *
 * @author greensnow25.
 * @version 1.
 * @since 24.05.2017.
 */
public class User {
    /**
     * user name.
     */
    private String name;
    /**
     * amount of children.
     */
    private int children;
    /**
     * user birthday.
     */
    private Calendar birthday;

    /**
     * constructor.
     *
     * @param name     user name.
     * @param children amount of children.
     * @param birthday user birthday.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }
}
