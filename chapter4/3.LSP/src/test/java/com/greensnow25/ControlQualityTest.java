package com.greensnow25;

import com.greensnow25.decorator.PlaceDecorator;
import com.greensnow25.decorator.Refregerator;
import com.greensnow25.foods.Fish;
import com.greensnow25.foods.Food;
import com.greensnow25.foods.Fruit;
import com.greensnow25.foods.Meat;
import com.greensnow25.foodsCanReproduct.FruitOnce;
import com.greensnow25.foodsCanReproduct.MeatOnce;
import com.greensnow25.decorator.Recycling;
import com.greensnow25.foodsCanReproduct.RecycleFood;
import com.greensnow25.storage.Shop;
import com.greensnow25.storage.Trash;
import com.greensnow25.storage.Warehouse;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
    private ControlQualityOnce controlQualityOnce;
    /**
     * food list.
     */
    private List<Food> foods;
    /**
     * recycle foods list.
     */
    private List<RecycleFood> foodsR;
    /**
     * Recycle.
     */
    private Recycling recycling;
    /**
     * refregerator.
     */
    private Refregerator refregerator;
    /**
     * refregerator decorator.
     */
    private PlaceDecorator placeRef;
    /**
     * recycle decorator.
     */
    private PlaceDecorator placeRec;

    /**
     * before the test.
     */
    @Before
    public void beforeTheTest() {
        this.controlQualityOnce = new ControlQualityOnce();
        this.shop = new Shop();
        this.trash = new Trash();
        this.warehouse = new Warehouse();

        this.foods = new ArrayList();
        this.foodsR = new ArrayList<>();

        this.refregerator = new Refregerator(warehouse);
        this.placeRef = refregerator;

        this.recycling = new Recycling(trash);
        this.placeRec = recycling;

        this.addPlaces();
        this.addProducts();
        this.addPleceDecor();
        this.addRecycleFoods();
    }

    /**
     * add storage.
     */
    public void addPlaces() {
        controlQualityOnce.addPlaces(this.shop);
        controlQualityOnce.addPlaces(this.trash);
        controlQualityOnce.addPlaces(this.warehouse);
    }

    /**
     * add srtorage with decorator.
     */
    public void addPleceDecor() {
        controlQualityOnce.addPleceDecor(this.placeRef);
        controlQualityOnce.addPleceDecor(this.placeRec);
    }

    /**
     * add old version products.
     */
    public void addProducts() {
        //warehause.
        foods.add(new Fish("bass", "27.03.2017", "25.04.2018", "120", null));
        //to shop with out discount.
        foods.add(new Meat("chicken", "10.03.17", "30.04.17", "50", "30%"));
        //to trash.
        foods.add(new Meat("cow", "30.02.17", "30.03.17", "80", null));
        //refregerator.
        foods.add(new Fruit("orange", "10.01.17", "10.04.18", "15", null));
    }

    /**
     * add expanded foods.
     */
    public void addRecycleFoods() {
        // to shop, with discount.
        foodsR.add(new FruitOnce("apple", "10.01.17", "30.05.19", "15", null));
        //to recycle.
        foodsR.add(new MeatOnce("pig", "30.02.17", "30.03.17", "80", null));
    }

    /**
     * move to shop
     */
    @Test
    public void whenRunApplicationMoveChickenToShop() throws ParseException {

        controlQualityOnce.move(this.foods);

        assertThat(shop.getFood()[0].getName(), is("chicken"));
    }

    /**
     * move to shop with discount.
     */
    @Test
    public void whenRunApplicationMoveAppleToShopWithDiscount() throws ParseException {

        controlQualityOnce.move(this.foods);

        assertThat(shop.getFood()[0].getDisscount(), is("30%"));
    }

    /**
     * move to warehouse.
     */
    @Test
    public void whenRunApplicationMoveAppleToWarehause() throws ParseException {

        controlQualityOnce.move(this.foods);

        assertThat(warehouse.getFood()[0].getName(), is("bass"));
    }

    /**
     * move to trash.
     */
    @Test
    public void whenRunApplicationMoveAppleToTrash() throws ParseException {

        controlQualityOnce.move(this.foods);

        assertThat(trash.getFood()[0].getName(), is("cow"));
    }

    /**
     * move to refregerator.
     */
    @Test
    public void whenRunApplicationThenMoveToRefregerator() throws ParseException {

        controlQualityOnce.moveOne(foodsR);

        assertThat(refregerator.getList().get(0).getName(), is("apple"));
    }

    /**
     * move to recycle.
     */
    @Test
    public void whenRunApplicationThenMovePIgToRecycle() throws ParseException {

        controlQualityOnce.moveOne(foodsR);

        assertThat(recycling.getList().get(0).getName(), is("pig"));
    }

    /**
     * collect Foods from storages in to fod list.
     * @throws ParseException
     */
    @Test
    public void whenResortThenReturnListAndMoveHimThen() throws ParseException {
        controlQualityOnce.moveOne(foodsR);
        List<Food> list = controlQualityOnce.resort(controlQualityOnce.getPlaceDecor());
        assertThat(list, is(foodsR));

    }
}