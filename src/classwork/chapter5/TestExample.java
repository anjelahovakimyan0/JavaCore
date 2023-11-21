package classwork.chapter5;

import java.util.ArrayList;
import java.util.List;

public class TestExample {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(11);
        arrayList.add(112);
        arrayList.add(111);
        arrayList.add(10);
        arrayList.add(1055);
        int b = 10;

        for (int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).equals(b)) {
                System.out.println("true");
            }
        }

        for (Integer element : arrayList) {
            if(element.equals(b)) {
                System.out.println("true");
            }
        }
    }
}
