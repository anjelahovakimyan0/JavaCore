package classwork.chapter7;

public class Test {

    int a, b;

    Test() {
    }

    Test(int i) {
        a = i;
    }

    Test(int i, int j) {
        a = i;
        b = j;
    }

    Test incrByTen() {
        Test temp = new Test(a + 10);
        return temp;
    }

    void meth(Test o) {
        o.a *= 2;
        o.b /= 2;
    }

    void meth(int i, int j) {
        i *= 2;
        j /= 2;
    }

    boolean equalTo(Test o) {
        if (o.a == a && o.b == b) {
            return true;
        } else {
            return false;
        }
    }
}
