package classwork.chapter14;

public class Gen6Arrays {

    public static void main(String[] args) {
        Integer[] n = {1, 2, 3, 4, 5};

        Gen6<Integer> iOb = new Gen6<>(50, n);

        Gen6<?>[] gens = new Gen6<?>[10];
    }
}
