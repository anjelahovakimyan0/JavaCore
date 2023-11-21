package classwork.lesson29;

import homework.onlineStore.model.User;
import homework.onlineStore.model.enums.UserType;

import java.util.*;

public class CollectionTest {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Poxos");
        names.add("Petros");

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("-------");

        names.remove(0);

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("--------------");

        List<Integer> numbers = new LinkedList<>();
        numbers.add(5);
        numbers.add(50);
        numbers.add(6);

        for (Integer number : numbers) {
            System.out.println(number);
        }

        System.out.println("------");

        numbers.remove(Integer.valueOf(50));

        for (Integer number : numbers) {
            System.out.println(number);
        }

        List<String> linkedNames = new LinkedList<>();

        linkedNames.add("poxos");

        System.out.println("-------");

        List<User> users = new ArrayList<>();
        User user = new User("userId", "Poxos", "Poxosyan", "user@gmail.com", "user", UserType.USER);
        users.add(user);

        for (User user1 : users) {
            System.out.println(user1);
        }

        System.out.println("--------");

        Queue<String> myQueue = new PriorityQueue<>();
        myQueue.add("Poxos");
        myQueue.add("Aram");
        myQueue.add("Zaven");

        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());

        System.out.println("--------");
//
//        System.out.println(myQueue.poll());
//        System.out.println(myQueue.poll());
//        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

        System.out.println("---");

        for (String s : myQueue) {
            System.out.println(s);
        }
    }
}
