public class Phone {
    private final String brand;

    public Phone(String brand)
    {
        this.brand = brand;
    }

    @Override
    public String toString()
    {
        return "Phone{" + "brand='" + brand + '\'' + '}';
    }
}
