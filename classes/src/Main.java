public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        User user = new User("Sebastián");
        System.out.println(user.userName);
        user.sayHello();

        // using Cat class
        Cat cat = new Cat();
        cat.setName("Chime");
        cat.meow();
        System.out.println(cat.getName());

        Cat cat1 = new Cat();
        cat1.setName("Galaxia");
        cat1.meow();
        System.out.println(cat1.getName());

        Cat anotherCat = new Cat("Rosita", 3);
        Cat anotherCat2 = new Cat("Rosita", 3);
        System.out.println(anotherCat.getName());
        anotherCat.meow();

        System.out.println(anotherCat);
        System.out.println(anotherCat2);
        System.out.println(anotherCat2.equals(anotherCat));

        System.out.println(Cat.count);

    }

    static class User {
        String userName;

        public User(String userName) {
            this.userName = userName;
        }

        void sayHello() {
            System.out.printf("hello! i'm %s \n", this.userName);
        }
    }
}

