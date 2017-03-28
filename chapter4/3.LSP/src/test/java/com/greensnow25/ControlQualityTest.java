package com.greensnow25;

import com.greensnow25.input.StubInput;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

/**
 * public class ControlQualityTest.
 *
 * @author greensnow25.
 * @version 1.
 * @since 28.03.2017.
 */
public class ControlQualityTest {
    /**
     * class object.
     */
    private Shop shop;
    /**
     * class object.
     */
    private Trash trash;
    /**
     * class object.
     */
    private Warehouse warehouse;
    /**
     * class object.
     */
    private ControlQuality controlQuality;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.controlQuality = new ControlQuality();
        this.shop = new Shop();
        this.warehouse = new Warehouse();
        this.trash = new Trash();
    }

    /**
     * test enter correct name.
     */
    @Test
    public void whenEnterFullNameCorrectThenReturnTrue() {
        String fullName = "fish bass 27.03.2017 25.04.2018 120";
        boolean res = controlQuality.enterFood(fullName);

        assertTrue(res);

    }

    /**
     * enter inccorectly name.
     */
    @Test
    public void whenEnterFullNameInccorectlyThenReturnTrue() {
        String fullName = "fish  27.03.2017 25.04.2018 120";
        boolean res = controlQuality.enterFood(fullName);

        assertFalse(res);

    }

    /**
     * test move food to warehouse.
     */
    @Test
    public void whenEnterLess25PercentsThenReturnWarehouse() {
        int date = 24;
        Place place = controlQuality.productDestination(date);
        assertThat(warehouse instanceof Warehouse, is(place instanceof Warehouse));
    }

    /**
     * test move food to shop.
     */
    @Test
    public void whenEnterLess75AndMore25PercentsThenReturnShop() {
        int date = 54;
        Place place = controlQuality.productDestination(date);
        assertThat(shop instanceof Shop, is(place instanceof Shop));
    }

    /**
     * test move food to shop with discount.
     */
    @Test
    public void whenEnterMore75PercentsThenReturnShop() {
        int date = 84;
        String[] line = new String[]{"10"};
        ControlQuality control = new ControlQuality(new StubInput(line));
        Place place = control.productDestination(date);
        assertThat(shop instanceof Shop, is(place instanceof Shop));
    }

    /**
     * test move food to shop with discount.check discount.
     */
    @Test
    public void whenEnterMore75PercentsThenCheckDiscount() {
        int date = 84;
        String[] line = new String[]{"10"};
        ControlQuality control = new ControlQuality(new StubInput(line));
        control.productDestination(date);

        assertThat(control.getDiscount(), is("10"));
    }

    /**
     * test move food to trash.
     */
    @Test
    public void whenEnterMore100PercentsThenReturnTrash() {
        int date = 102;
        Place place = controlQuality.productDestination(date);
        assertThat(trash instanceof Trash, is(place instanceof Trash));
    }

    /**
     * test correct date.
     */
    @Test
    public void whenCorrectDateEntryThenReturnTrue() {
        String[] current = new String[]{"10", "04", "2017"};
        String[] nextDate = new String[]{"15", "04", "2017"};
        boolean res = controlQuality.validDate(current, nextDate);
        assertTrue(res);
    }

    /**
     * test incorrect date.
     */
    @Test
    public void whenIncorrectDateEntryReturnFalse() {
        String[] current = new String[]{"10", "04", "2017"};
        String[] nextDate = new String[]{"15", "03", "2017"};
        boolean res = controlQuality.validDate(current, nextDate);
        assertFalse(res);
    }

    /**
     * check sumDates.
     */
    @Test
    public void whenEnterDatesThenReturnSumOfDaysEnteringTheGap() {
        String[] current = new String[]{"10", "04", "2017"};
        String[] nextDate = new String[]{"15", "04", "2017"};
        int res = controlQuality.sumDays(current, nextDate);
        assertThat(res, is(5));
    }

    /**
     * check name on Warehouse.
     */
    @Test
    public void whenAddFoodMoveItInThePlaceShopCheckName() {
        String[] answers = new String[]{"05.04.2017", "fish bass 27.03.2017 25.04.2018 120", "exit"};
        ControlQuality control = new ControlQuality(new StubInput(answers));
        control.run();
        assertThat(control.getWarehouse().getFood()[0].getName(), is("bass"));
    }

    /**
     * check create date.
     */
    @Test
    public void whenAddFoodMoveItInThePlaceShopCheckCreateDate() {
        String[] answers = new String[]{"05.04.2017", "fish bass 27.03.2017 25.04.2018 120", "exit"};
        ControlQuality control = new ControlQuality(new StubInput(answers));
        control.run();
        assertThat(control.getWarehouse().getFood()[0].getCreateDate(), is("27.03.2017"));
    }

    /**
     * check expaire date.
     */
    @Test
    public void whenAddFoodMoveItInThePlaceShopCheckExpaireDate() {
        String[] answers = new String[]{"05.04.2017", "fish bass 27.03.2017 25.04.2018 120", "exit"};
        ControlQuality control = new ControlQuality(new StubInput(answers));
        control.run();
        assertThat(control.getWarehouse().getFood()[0].getExpaireDate(), is("25.04.2018"));
    }

    /**
     * check prise.
     */
    @Test
    public void whenAddFoodMoveItInThePlaceShopCheckPrise() {
        String[] answers = new String[]{"05.04.2017", "fish bass 27.03.2017 25.04.2018 120", "exit"};
        ControlQuality control = new ControlQuality(new StubInput(answers));
        control.run();
        assertThat(control.getWarehouse().getFood()[0].getPrise(), is("120"));
    }

    /**
     * if food move to warehouse then discount equels null .
     */
    @Test
    public void whenAddFoodMoveItInThePlaceShopCheckDiscountEquelsNull() {
        String[] answers = new String[]{"05.04.2017", "fish bass 27.03.2017 25.04.2018 120", "exit"};
        ControlQuality control = new ControlQuality(new StubInput(answers));
        control.run();
        assertNull(control.getWarehouse().getFood()[0].getDisscount());
    }
}