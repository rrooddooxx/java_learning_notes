public class Rectangle implements Shape {

    private String name;
    Double width;
    Double height;

    public Rectangle(String name, Double width, Double height)
    {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public Double getArea()
    {
        return width * height;
    }

    @Override
    public Double getPerimeter()
    {
        return width + height;
    }

    @Override
    public String toString()
    {
        return "Rectangle{" + "name='" + name + '\'' + ", width=" + width + ", height=" + height + '}';
    }
}
