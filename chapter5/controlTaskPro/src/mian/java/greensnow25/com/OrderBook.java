package greensnow25.com;

import java.util.*;

/**
 * public class OrderBook.
 *
 * @author greensnow25.
 * @version 1.
 * @since 01.06.2017.
 */
public class OrderBook {
    /**
     * unsorted orders.
     */
    private HashMap<Integer, Order> unsortedOrders;
    /**
     * buy orders, book price is key.
     */
    private TreeMap<Double, HashMap<Integer, Order>> buyOrders;
    /**
     * sell orders, book price is key.
     */
    private TreeMap<Double, HashMap<Integer, Order>> sellOrders;

    /**
     * constructor.
     */
    public OrderBook() {
        this.unsortedOrders = new HashMap<>();
        this.buyOrders = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o1 - o2);
            }
        });
        this.sellOrders = new TreeMap<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o1 - o2);
            }
        });
    }

    /**
     * The method adds an order to a collection of the appropriate type.
     *
     * @param order order.
     */
    public void add(Order order) {
        unsortedOrders.put(order.getOrderId(), order);
        if (order.isOperation()) {
            sort(buyOrders, order);
        } else sort(sellOrders, order);
    }

    /**
     * remove order from collection.
     *
     * @param orderId order id.
     */
    public void remove(Integer orderId) {
        Order order = unsortedOrders.get(orderId);
        if (order != null) {
            if (order.isOperation()) {
                buyOrders.get(order.getPrise()).remove(orderId);
                checkIsEmpty(buyOrders, order);
            } else {
                sellOrders.get(order.getPrise()).remove(orderId);
                checkIsEmpty(sellOrders, order);
            }
        }
    }

    /**
     * The method checks if the Map container with the specified key is empty, if it is empty, it deletes it.
     *
     * @param orders Verification map.
     * @param order  Verification order.
     */
    public void checkIsEmpty(TreeMap<Double, HashMap<Integer, Order>> orders, Order order) {
        if (orders.get(order.getPrise()).size() == 0) {
            orders.remove(order.getPrise());
        }
    }

    /**
     * The method sorts orders at a price.
     *
     * @param map   map type for add.
     * @param order order to add.
     */
    public void sort(TreeMap<Double, HashMap<Integer, Order>> map, Order order) {
        if (map.containsKey(order.getPrise())) {
            map.get(order.getPrise()).put(order.getOrderId(), order);
        } else {
            HashMap<Integer, Order> tmp = new HashMap<>();
            tmp.put(order.getOrderId(), order);
            map.put(order.getPrise(), tmp);
        }
    }

    /**
     * Counting the sum of the volume.
     *
     * @param map price map.
     * @return sum.
     */
    public int sumValue(HashMap<Integer, Order> map) {
        int sum = 0;
        for (Order order : map.values()) {
            sum += order.getVolume();
        }
        return sum;
    }

    /**
     * The method runs through all books and groups books at a price and prints them out.
     */
    public void print() {
        String bookName = null;
        Iterator<Double> iterator = buyOrders.keySet().iterator();
        Iterator<Double> iteratorOne = sellOrders.keySet().iterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext() || iteratorOne.hasNext()) {
            int sum = 0;
            int sumOne = 0;
            double price = 0;
            double priceOne = 0;

            if (iterator.hasNext()) {
                price = iterator.next();
                sum = this.sumValue(buyOrders.get(price));
            }
            if (iteratorOne.hasNext()) {
                priceOne = iteratorOne.next();
                sumOne = this.sumValue(sellOrders.get(priceOne));
            }
            if (bookName == null) {
                if (buyOrders.size() != 0 && price != 0)
                    bookName = buyOrders.get(price).values().iterator().next().getType();
                if (sellOrders.size() != 0 && priceOne != 0)
                    bookName = sellOrders.get(price).values().iterator().next().getType();
                String title = String.format("%s    %s%s", "buy " + bookName, "sell " + bookName, System.getProperty("line.separator"));
                sb.append(title);
            }
            sb.append(String.format("%.2f%s%d%s %.2f%s%d%s", price, "@", sum, "   "
                    , priceOne, "@", sumOne, System.getProperty("line.separator")));
        }
        System.out.println(sb.toString());
    }
}
