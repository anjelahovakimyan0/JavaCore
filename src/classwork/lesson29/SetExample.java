package classwork.lesson29;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {
        Set<Integer> mySet = new LinkedHashSet<>();

        mySet.add(5);
        mySet.add(4);
        mySet.add(8);
        mySet.add(1);
        mySet.add(115);
        mySet.add(1000);
        mySet.add(5);

        for (Integer integer : mySet) {
            System.out.println(integer);
        }
    }
}
