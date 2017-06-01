package greensnow25.com;

/**
 * public class Book.
 *
 * @author greensnow25.
 * @version 1.
 * @since 01.06.2017.
 */
public class Book {
    /**
     * book type
     */
    private String type;
    /**
     * operation true - byu, false - sell.
     */
    private boolean operation;
    /**
     * book prise.
     */
    private double prise;
    /**
     * book volume.
     */
    private int volume;
    /**
     * book id.
     */
    private int orderId;

    /**
     * constructor.
     * @param type book type.
     * @param operation operation true - byu, false - sell.
     * @param prise  book prise.
     * @param volume book volume.
     * @param orderId book id.
     */
    public Book(String type, boolean operation, double prise, int volume, int orderId) {
        this.type = type;
        this.operation = operation;
        this.prise = prise;
        volume = volume;
        this.orderId = orderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOperation() {
        return operation;
    }

    public void setOperation(boolean operation) {
        this.operation = operation;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        volume = volume;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Book{" +
                "type='" + type + '\'' +
                ", operation=" + operation +
                ", prise=" + prise +
                ", volume=" + volume +
                ", orderId=" + orderId +
                '}';
    }
}
