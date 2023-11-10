package classwork.lesson27.serialization;

import java.io.*;

public class SerializationDemo {

    private static final String FILE_PATH = "C:\\Users\\sky\\IdeaProjects\\JavaCore0\\src\\classwork\\lesson27\\serialization\\file\\example.txt";

    public static void main(String[] args) {
//        Student student = new Student("poxosId", "poxos", "poxosyan", "poxos@gmail.com", "0123456");
//
//        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
//            objectOutputStream.writeObject(student);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))){
            Object object = objectInputStream.readObject();
            if(object instanceof Student student) {
                System.out.println(student);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
