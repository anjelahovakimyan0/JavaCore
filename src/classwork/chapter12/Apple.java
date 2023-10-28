package classwork.chapter12;

public enum Apple {

    JONATHAN(10),
    GOLDEN_DEL(9),
    RED_DEL,
    WINESAP(15),
    CORTLAND(8);

    private int price;

    Apple() {
        price = -1;
    }

    Apple(int p) {
        price = p;
    }

    public int getPrice() {
        return price;
    }
}
