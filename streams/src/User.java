import java.util.Objects;

public class User {
    private int age;
    private String name;
    private String lastName;

    public User(int age, String name, String lastName)
    {
        this.age = age;
        this.name = name;
        this.lastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public String getName()
    {
        return name;
    }

    public String getLastName()
    {
        return lastName;
    }

    @Override
    public String toString()
    {
        return "User{" + "age=" + age + ", name='" + name + '\'' + ", lastName='" + lastName + '\'' + '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(lastName,
                                                                                    user.lastName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(age, name, lastName);
    }
}
