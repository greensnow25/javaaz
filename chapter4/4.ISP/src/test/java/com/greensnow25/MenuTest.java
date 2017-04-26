package com.greensnow25;

import com.greensnow25.Input.StabInput;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * public class MenuTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 26.04.2017.
 */
public class MenuTest {
    /**
     * object of the class.
     */
    private Menu menu;
    /**
     * list wsth answers.
     */
    private ArrayList<String> answers;

    /**
     * method create class object.
     *
     * @param list answers.
     */
    public void createClassObject(ArrayList<String> list) {
        this.menu = new Menu(new StabInput(list));
    }

    /**
     * test changing the name to a different name.
     */
    @Test
    public void whenCallRenameThenChangeName() {
        this.answers = new ArrayList<>();
        this.answers.add("2");
        this.answers.add("one33");
        this.answers.add("newName");
        this.answers.add("exit");
        createClassObject(this.answers);
        menu.run();
        String result = menu.getItemOnces().get(0).getItems().get(0).getItems().get(0).getName();
        assertThat(result, is("newName"));
    }


}