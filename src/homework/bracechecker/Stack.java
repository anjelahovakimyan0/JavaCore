package homework.bracechecker;

public class Stack {

    private int[] stck;
    private int tos;

    Stack(int size) {
        stck = new int[size];
        tos = -1;
    }

    public int getSize() {
        return tos;
    }

    public int[] getStck() {
        return stck;
    }

    void push(int item) {
        if (tos == stck.length - 1) {
            extend();
        } else {
            stck[++tos] = item;
        }
    }

    int pop() {
        if (tos < 0) {
            return 0;
        }
        return stck[tos--];
    }

    private void extend() {
        int[] tmp = new int[stck.length + 10];
        for (int i = 0; i < stck.length; i++) {
            tmp[i] = stck[i];
        }
        stck = tmp;
    }
}
