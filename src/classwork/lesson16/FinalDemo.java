package classwork.lesson16;

import classwork.chapter6.Box;

public class FinalDemo {

    public static void main(String[] args) {
        final Box myBox = new Box(1,2,3);

        myBox.width = 10;
    }
}
