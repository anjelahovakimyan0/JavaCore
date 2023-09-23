package classwork.chapter6;

public class Box {

    double width;
    double height;
    double depth;

    Box() {
    }

    Box(double width, double height, double depth) {
        System.out.println("Конструктирование объекта Box");
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    void setDim(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    double volume() {
        System.out.print("Объем равен ");
        return width * height * depth;
    }
}
