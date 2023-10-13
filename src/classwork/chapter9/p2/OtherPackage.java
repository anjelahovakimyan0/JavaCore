package classwork.chapter9.p2;

import classwork.chapter9.p1.Protection;

public class OtherPackage {

    OtherPackage() {
        Protection p = new Protection();
        System.out.println("Конструктор из другого пакета");
        System.out.println("n_pub = " + p.n_pub);
    }
}
