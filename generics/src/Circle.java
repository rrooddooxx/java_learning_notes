public class Circle implements Shape {

    private String name;
    Double radius;


    public Circle(String name, Double radius)
    {
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public Double getArea()
    {
        return Math.pow(radius, 2);
    }

    @Override
    public Double getPerimeter()
    {
        return radius * 2;
    }

    @Override
    public String toString()
    {
        return "Circle{" + "name='" + name + '\'' + ", radius=" + radius + '}';
    }
}
