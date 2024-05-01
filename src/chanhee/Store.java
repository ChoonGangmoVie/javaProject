package chanhee;

public class Store {

    private int menuNumber;
    private String name;
    private int price;

    public Store(int menuNumber, String name, int price) {
        this.menuNumber = menuNumber;
        this.name = name;
        this.price = price;
    }

    public int getMenuNumber() {
        return menuNumber;
    }

    public void setMenuNumber(int menuNumber) {
        this.menuNumber = menuNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Store{" +
                "menuNumber=" + menuNumber +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
