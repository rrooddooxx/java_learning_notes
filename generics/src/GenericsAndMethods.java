import java.util.ArrayList;
import java.util.List;

public class GenericsAndMethods {
    public static void main(String[] args)
    {
        print(new String[]{"Hello", "World"});
        print(new Character[]{'A', 'B'});
        print(new Boolean[]{false, false, true});

        List<Character> aListReturned = getReturnedAsList(new Character[]{'D', 'E'});
        aListReturned.forEach(el -> {
            System.out.println(el.getClass().getName() + " -> " + el);
        });
    }

    public static <T> void print(T[] arr)
    {
        for (T el : arr) {
            System.out.println(el.getClass().getName() + " - " + el);
        }
    }

    public static <T> List<T> getReturnedAsList(T[] arr)
    {
        List<T> genericList = new ArrayList<>();
        for (T el : arr) {
            System.out.printf("Returning %s %n", el);
            genericList.add(el);
        }
        return genericList;
    }


}
