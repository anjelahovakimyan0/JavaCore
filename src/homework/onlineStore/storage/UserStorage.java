package homework.onlineStore.storage;

import homework.onlineStore.model.User;
import homework.onlineStore.model.enums.UserType;
import homework.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserStorage implements Serializable {

    private Map<String, User> userMap = new HashMap<>();

    public void register(User user) {
        userMap.put(user.getEmail(), user);
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public User getByEmail(String email) {
        for (String key : userMap.keySet()) {
            if (key.equals(email)) {
                return userMap.get(key);
            }
        }
        return null;
    }

    public void printByType(UserType userType) {
        for (User user : userMap.values()) {
            if (user.getType().equals(userType)) {
                System.out.println(user);
            }
        }
    }
}
