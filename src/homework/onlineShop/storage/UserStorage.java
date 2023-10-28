package homework.onlineShop.storage;

import homework.onlineShop.model.User;

public class UserStorage {

    private User[] users = new User[10];
    private int size;

    public void register(User user) {
        if (size == users.length) {
            extend();
        }
        users[size++] = user;
    }

    public User getById(String id) {
        for (int i = 0; i < size; i++) {
            if (users[i].getId().equals(id)) {
                return users[i];
            }
        }
        return null;
    }

    public User login(String email, String password) {
        for (int i = 0; i < size; i++) {
            if (users[i].getEmail().equals(email) && users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }

    public void printUsers() {
        for (int i = 0; i < size; i++) {
            System.out.println(users[i]);
        }
    }

    private void extend() {
        User[] tmp = new User[users.length + 10];
        System.arraycopy(users, 0, tmp, 0, users.length);
        users = tmp;
    }
}
