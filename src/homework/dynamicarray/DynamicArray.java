package homework.dynamicarray;

public class DynamicArray {

    int[] array = new int[10];
    int size = 0;

    void add(int value) {
        if (size == array.length) {
            extend();
        }
        array[size++] = value;
    }

    int getByIndex(int index) {
        if (index >= size || index < 0) {
            return 0;
        }
        return array[index];
    }

    void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void deleteByIndex(int index) {
        if (index > 0 && index < size) {
            for (int i = 0; i < size; i++) {
                if (index == i) {
                    for (int j = i + 1; j < size; j++) {
                        array[j - 1] = array[j];
                    }
                    size--;
                    break;
                }
            }
        } else {
            System.out.println("Index is incorrect");
        }
    }

    public void set(int index, int value) {
        if (index > 0 && index < size) {
            for (int i = 0; i < size; i++) {
                if (index == i) {
                    array[index] = value;
                    break;
                }
            }
        } else {
            System.out.println("Index is incorrect");
        }
    }

    public void add(int index, int value) {
        if (index > 0 && index < size) {
            for (int i = 0; i < size; i++) {
                if (index == size - 1) {
                    array[index] = value;
                } else if (index == i) {
                    int tmp = array[index];
                    array[index] = value;
                    array[index + 1] = tmp;
                }
            }
        } else {
            System.out.println("Index is incorrect");
        }
    }

    public boolean exists(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int getIndexByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private void extend() {
        int[] newArray = new int[array.length + 10];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
