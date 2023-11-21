package classwork.lesson29;

public class Storage<T> {

    private Object[] objects = new Object[10];
    private int size;

    public void add(T value) {
        if (objects.length == size) {
            extend();
        }
        objects[size++] = value;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(objects[i]);
        }
    }

    public T getByIndex(int index) {
        return (T) objects[index];
    }

    private void extend() {
        Object[] tmp = new Object[objects.length + 10];
        System.arraycopy(objects, 0, tmp, 0, objects.length);
        objects = tmp;
    }
}
