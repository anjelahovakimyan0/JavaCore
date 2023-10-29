package classwork.lesson25;

import java.util.UUID;

public class UUIDExample {

    public static void main(String[] args) {
        UUID.fromString("");
        String uuid = UUID.randomUUID().toString();
        String[] uuids = uuid.split("-");
        String id = uuids[0];
        System.out.println(id);
    }
}
