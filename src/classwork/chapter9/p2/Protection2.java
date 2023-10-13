package classwork.chapter9.p2;

import classwork.chapter9.p1.Protection;

public class Protection2 extends Protection {

    Protection2() {
        System.out.println("Конструктор, унаследованний из другого пакета");
        System.out.println("n_pro " + n_pro);
        System.out.println("n_pub " + n_pub);
    }
}
