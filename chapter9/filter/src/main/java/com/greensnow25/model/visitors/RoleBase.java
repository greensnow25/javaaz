package com.greensnow25.model.visitors;

import java.util.*;

/**
 * Public class RoleBase.
 *
 * @author greensnow25.
 * @version 1.
 * @since 19.09.2017.
 */
public class RoleBase {
    /**
     * map consist enums.
     */
    private Map<String, List<Actions>> map;

    /**
     * constructor.
     */
    public RoleBase() {
        this.map = new HashMap<>();
        this.createBase("admin", AdminActions.values());
        this.createBase("moderator", ModeratorActions.values());
        this.createBase("user", UserAction.values());
    }

    /**
     * add enum to the list.
     *
     * @param desc description.
     * @param e    enum values.
     */
    public void createBase(String desc, Object[] e) {
        List l = Arrays.asList(e);
        this.map.putIfAbsent(desc, l);

    }

    /**
     * get map.
     * @return map.
     */
    public Map<String, List<Actions>> getMap() {
        return map;
    }
}
