package homework.onlineShop.util;

import java.util.UUID;

public class OrderIdUtil {

    public static String generateId() {
        String uuid = UUID.randomUUID().toString();
        String[] uuids = uuid.split("-");
        String id = uuids[0];
        return id;
    }
}
