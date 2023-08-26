package classwork.chapter3;

public class ScopeErr {

    public static void main(String[] args) {
        int bar = 1;
        {
            // int bar = 2;
            //
            // переменная bar уже обьявлена
            // в методе main глобально и оно доступна и здесь
            // второй раз вы его обьявить не сможете
        }
    }

}
