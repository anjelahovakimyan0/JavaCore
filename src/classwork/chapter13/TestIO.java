package classwork.chapter13;

import java.io.*;

public class TestIO {

    private static final String FILE_PATH = "C:\\Users\\sky\\IdeaProjects\\JavaCore0\\src\\classwork\\chapter13\\example.txt";

    public static void main(String[] args) {
//        try (ObjectOutputStream objectInputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
//            objectInputStream.writeObject(UserType.USER);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            System.out.println(objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
