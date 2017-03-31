package com.greensnow25;

import com.greensnow25.foods.Fish;
import com.greensnow25.foods.Food;
import com.greensnow25.foods.Fruit;
import com.greensnow25.foods.Meat;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
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
     * food Array.
     */
    private Food[] foods;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.controlQuality = new ControlQuality();
        this.shop = new Shop();
        this.trash = new Trash();
        this.warehouse = new Warehouse();
        this.foods = new Food[4];
        this.addPlaces();
        this.addProducts();
    }

    public void addPlaces() {
        controlQuality.addPlaces(this.shop);
        controlQuality.addPlaces(this.trash);
        controlQuality.addPlaces(this.warehouse);
    }

    public void addProducts() {
        int pos = 0;
        // to shop, with discount.
        foods[pos++] = new Fruit("apple", "10.01.17", "10.04.17", "15", null);
        //warehause.
        foods[pos++] = new Fish("bass", "27.03.2017", "25.04.2018", "120", null);
        //to shop with out discount.
        foods[pos++] = new Meat("chicken", "10.03.17", "30.04.17", "50", null);
        //to trash.
        foods[pos++] = new Meat("cow", "30.02.17", "30.03.17", "80", null);
    }

    /**
     * move to shop
     */
    @Test
    public void whenRunApplicationMoveAppleToShop() throws ParseException {

        controlQuality.move(this.foods, controlQuality.getPlaces());

        assertThat(shop.getFood()[0].getName(), is("apple"));

    }

    /**
     * move to shop with discount.
     */
    @Test
    public void whenRunApplicationMoveAppleToShopWithDiscount() throws ParseException {

        controlQuality.move(this.foods, controlQuality.getPlaces());

        assertThat(shop.getFood()[0].getDisscount(), is("30%"));

    }

    /**
     * move to shop with out discount.
     */
    @Test
    public void whenRunApplicationMoveAppleToShopWithOutDiscount() throws ParseException {

        controlQuality.move(this.foods, controlQuality.getPlaces());

        assertNull(shop.getFood()[1].getDisscount());

    }

    /**
     * move to warehouse.
     */
    @Test
    public void whenRunApplicationMoveAppleToWarehause() throws ParseException {

        controlQuality.move(this.foods, controlQuality.getPlaces());

        assertThat(warehouse.getFood()[0].getName(), is("bass"));

    }

    /**
     * move to warehouse.
     */
    @Test
    public void whenRunApplicationMoveAppleToTrash() throws ParseException {

        controlQuality.move(this.foods, controlQuality.getPlaces());

        assertThat(trash.getFood()[0].getName(), is("cow"));

    }

}