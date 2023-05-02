package exercise;

// BEGIN
class Flat implements Home {

    private double area;
    private double balconyArea;
    private int floor;

    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home another) {
        return this.getArea() == another.getArea() ? 0 : (this.getArea() > another.getArea() ? 1 : -1);


    }

    @Override
    public String toString() {
        return  "Квартира площадью " + getArea() +  " метров на " + floor + " этаже";
    }
}
// END
