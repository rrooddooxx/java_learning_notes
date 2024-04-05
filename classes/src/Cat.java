public class Cat {


    public static int count;

    static {
        System.out.println(" static initializer");
        count++;
    }


    private String name;
    private int age;

    public void meow() {
        System.out.println(String.format("%s dice: meooowww...!!", this.name));
    }


    {
        System.out.println("instance initializer");
    }

    public Cat() {
        System.out.println("Class constructor");
        count++;
    }

    public Cat(String name, int age) {
        System.out.println("Class constructor");
        count++;

        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().getName().equals(this.getClass().getName())) {
            return obj.toString().equals(this.toString());
        }
        return false;
    }
}
