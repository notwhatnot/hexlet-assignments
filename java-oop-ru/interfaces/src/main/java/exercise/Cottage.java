package exercise;

// BEGIN
class Cottage implements  Home {
    private double area;
    private int floorCount;

    Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        return this.getArea() == another.getArea() ? 0 : (this.getArea() > another.getArea() ? 1 : -1);



    }
    @Override
    public String toString() {
        return floorCount +  " этажный коттедж площадью " + area + " метров";
    }
}
// END
