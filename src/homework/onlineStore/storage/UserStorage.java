package homework.onlineStore.storage;

import homework.onlineStore.model.User;
import homework.onlineStore.model.enums.UserType;
import homework.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserStorage implements Serializable {

    private Map<String, User> users = new HashMap<>();

    public void register(User user) {
        users.put(user.getEmail(), user);
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public User getByEmail(String email) {
        return users.get(email);
    }

    public void printByType(UserType userType) {
        for (User user : users.values()) {
            if (user.getType() == userType) {
                System.out.println(user);
            }
        }
    }
}
