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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (children != user.children) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }
}
