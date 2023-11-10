package homework.onlineStore.storage;

import homework.onlineStore.model.User;
import homework.onlineStore.model.enums.UserType;
import homework.onlineStore.util.StorageSerializeUtil;

import java.io.Serializable;

public class UserStorage implements Serializable {

    private User[] users = new User[10];
    private int size;

    public void register(User user) {
        if (size == users.length) {
            extend();
        }
        users[size++] = user;
        StorageSerializeUtil.serializeUserStorage(this);
    }

    public User getById(String id) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId().equals(id)) {
                return users[i];
            }
        }
        return null;
    }

    public User verifyLogin(String email, String password) {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(email) && users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }

    public User getByEmail(String email) {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(email)) {
                return users[i];
            }
        }
        return null;
    }
    
    public void printByType(UserType userType) {
        for (int i = 0; i < size; i++) {
            if (users[i].getType().equals(userType)) {
                System.out.println(users[i]);
            }
        }
    }
    
    private void extend() {
        User[] tmp = new User[users.length + 10];
        System.arraycopy(users, 0, tmp, 0, users.length);
        users = tmp;
    }
}
