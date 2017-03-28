package com.greensnow25;

import com.greensnow25.foods.Fish;
import com.greensnow25.foods.Fruit;
import com.greensnow25.foods.Meat;
import com.greensnow25.input.ConsolInput;
import com.greensnow25.input.Input;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * public class ControlQuality.
 *
 * @author greensnow25.
 * @version 1.
 * @since 27.03.2017.
 */
public class ControlQuality {
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
    private Input input;
    /**
     * pattern for search.
     */
    private final String pattern = "(\\w+\\S){1}\\s?(\\w+){1}\\s?(\\d{2}\\.?\\d{2}\\.?\\d+\\.?)\\s?(\\d{2}\\.?\\d{2}\\.?\\d+\\.?)\\s?(\\d+)\\s?";
    /**
     * type of food(fish, fruit...).
     */
    private String type;
    /**
     * current day.
     */
    private String currentDay;
    /**
     * food name.
     */
    private String name;
    /**
     * food create day.
     */
    private String createDate;
    /**
     * food expaire day.
     */
    private String expaireDate;
    /**
     * prise of the food.
     */
    private String prise;
    /**
     * If the expiration date ends, we make a discount.
     */
    private String discount;
    /**
     * Storage space for products.
     */
    private Place place;

    /**
     * class constructor.
     *
     * @param input input system.
     */
    public ControlQuality(Input input) {
        this.input = input;
        this.warehouse = new Warehouse();
        this.shop = new Shop();
        this.trash = new Trash();

    }

    /**
     * default constructor.
     */
    public ControlQuality() {
        this.warehouse = new Warehouse();
        this.shop = new Shop();
        this.trash = new Trash();

    }

    /**
     * main.
     *
     * @param args string.
     */
    public static void main(String[] args) {
        ControlQuality controlQuality = new ControlQuality(new ConsolInput());

        controlQuality.run();
    }

    /**
     * method run application.
     */
    public void run() {
        String fullName;
        this.currentDay = input.answer("Enter current day");
        do {
            System.out.println("Example : fish bass 27.03.2017 25.04.2018 120");
            fullName = input.answer("Enter product: type, name,createDate, expaireDate, prise");
            if (enterFood(fullName)) {
                int percents = checkDate();
                Place place = productDestination(percents);
                moveProduct(this.name, this.createDate, this.expaireDate, this.prise, this.discount, place);
            }
        } while (!fullName.equals("exit"));


    }

    /**
     * method find matcher.
     *
     * @param fullName entered food name.
     * @return trye if correct, else false.
     */
    public boolean enterFood(String fullName) {
        boolean res = false;
        Pattern patt = Pattern.compile(pattern);
        Matcher matcher = patt.matcher(fullName);
        if (matcher.find()) {
            this.type = matcher.group(1);
            this.name = matcher.group(2);
            this.createDate = matcher.group(3);
            this.expaireDate = matcher.group(4);
            this.prise = matcher.group(5);
            res = true;
        } else {
            System.out.printf("Invalid data entry: ");
        }
        return res;
    }

    /**
     * method returns the percentage representation of the expiration date.
     *
     * @return percents.
     */
    public int checkDate() {
        String[] create = this.createDate.split("\\.");
        String[] balance = this.expaireDate.split("\\.");
        String[] current = this.currentDay.split("\\.");
        int expireDateInPercent = 0;
        if (validDate(create, balance) && validDate(create, current)) {
            int expireDateInDays = sumDays(create, balance);
            int passedDays = sumDays(create, current);
            expireDateInPercent = passedDays * 100 / expireDateInDays;
        } else {
            System.out.println("Invalid data input");
        }
        return expireDateInPercent;
    }

    /**
     * method determines storage space.
     *
     * @param percents percents.
     * @return storage.
     */
    public Place productDestination(int percents) {

        if (percents <= 25) {
            this.place = warehouse;
        } else if (percents > 25 && percents <= 75) {
            this.place = shop;
        } else if (percents > 75 && percents < 100) {
            this.place = shop;
            this.discount = input.answer("The expiration date of the product. What kind of discount: ");
        } else {
            this.place = trash;
        }
        return place;
    }

    /**
     * create product and move it.
     *
     * @param name        product name.
     * @param createDate  product create date.
     * @param expaireDate product expaire date.
     * @param prise       product prise.
     * @param discount    product discount.
     * @param place       storage.
     */
    public void moveProduct(String name, String createDate, String expaireDate, String prise, String discount, Place place) {

        if (this.type.equals("fish")) {
            place.addFood(new Fish(name, createDate, expaireDate, prise, discount));
        } else if (this.type.equals("meat")) {
            place.addFood(new Meat(name, createDate, expaireDate, prise, discount));
        } else if (this.type.equals("fruit")) {
            place.addFood(new Fruit(name, createDate, expaireDate, prise, discount));
        }

    }

    /**
     * valid dates(one less two).
     *
     * @param dateOne one date.
     * @param dateTwo two date.
     * @return true if correct, else false.
     */
    public boolean validDate(String[] dateOne, String[] dateTwo) {
        int startYear = Integer.parseInt(dateOne[2]);
        int startMonth = Integer.parseInt(dateOne[1]);
        int startDay = Integer.parseInt(dateOne[0]);

        int finalYear = Integer.parseInt(dateTwo[2]);
        int finalMonth = Integer.parseInt(dateTwo[1]);
        int finalDay = Integer.parseInt(dateTwo[0]);

        boolean result = false;
        if (startYear < finalYear) {
            result = true;
        } else if (startYear == finalYear) {
            if (startMonth < finalMonth) {
                result = true;
            } else if (startMonth == finalMonth) {
                if (startDay <= finalDay) {
                    result = true;
                }
            }
        }
        return result;
    }

    /**
     * method sum days(one less two).
     *
     * @param dateOne one date.
     * @param dateTwo two date.
     * @return boolean.
     */
    public int sumDays(String[] dateOne, String[] dateTwo) {
        int sumDays = 0;
        boolean qq = false;
        int startYear = Integer.parseInt(dateOne[2]);
        int startMonth = Integer.parseInt(dateOne[1]);
        int startDay = Integer.parseInt(dateOne[0]);

        int finalYear = Integer.parseInt(dateTwo[2]);
        int finalMonth = Integer.parseInt(dateTwo[1]);
        int finalDay = Integer.parseInt(dateTwo[0]);

        for (int i = finalYear; i >= startYear; i--) {
            for (int j = finalMonth; j > 0; j--) {
                if (i == startYear && startMonth == j && qq) {
                    sumDays += 30 - startDay;
                    break;
                } else if (startYear == finalYear && startMonth == finalMonth) {
                    sumDays = finalDay - startDay;
                    break;
                } else if (j == 1) {
                    finalMonth = 12;
                }
                if (j % 2 == 0 && qq) {
                    sumDays += 31;
                } else if (j % 2 != 0 && qq) {
                    sumDays += 30;
                } else {
                    sumDays += finalDay;
                    qq = true;
                }


            }
        }
        return sumDays;
    }

    /**
     * getDiscount.
     *
     * @return discount.
     */
    public String getDiscount() {
        return discount;
    }

    /**
     * getWarehouse.
     *
     * @return warehouse.
     */
    public Warehouse getWarehouse() {
        return warehouse;
    }
}
