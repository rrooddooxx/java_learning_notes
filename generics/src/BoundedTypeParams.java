import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BoundedTypeParams {
    public static void main(String[] args)
    {
        /*Double[] nums = {1.0, 2.2, 3.4, 4.0, 5.3, 6.3, 7.0, 8.0};
        System.out.println(countGreaterThan(nums, 5.7));

        Integer[] numsInt = {1, 3, 7, 9, 3, 4};
        System.out.println(countGreaterThan(numsInt, 5));

        System.out.println(countGreaterThan(new String[]{"Hello", "World"}, "Hello World"));

        List<String> listWords = new ArrayList<>(Arrays.asList("Hello", "world"));
        Set<String> setWords = new HashSet<>(Set.of("Hello", "World"));
        printsListsOnly(listWords);
        // printsListsOnly(setWords); -- esto no funcionará, ya que la estructura Set no cumple
        // lo definido por el genérico

        List<String> anotherListForChristsSake = new ArrayList<>(Arrays.asList("Bye", "Byex"));
        Set<String> anotherMapForChristsSake = new ArrayList<>(Arrays.asList("Bye", "Byex"));
        multipleBoundsToComply(anotherListForChristsSake);
        // multipleBoundsToComply(anotherMapForChristsSake); -- esto no funcionará,no cumple los
        // límites especificados por el genérico. (bounds)*/

        List<Object> objectList = Arrays.asList("hola", 2.22, new Date());
        List<String> objectListTwo = Arrays.asList("hola", "mundo");
        printLists(objectList);
        printLists(objectListTwo);

        List<Double> doubleList = Arrays.asList(2.0, 3.4, 2.34);
        List<Integer> intList = Arrays.asList(2, 3, 4, 5);
        List<Object> objectList1 = Arrays.asList("d", "c");

        upperBounds(doubleList);
        upperBounds(intList);
//        upperBounds(Arrays.asList("hola", "mundo")); -- no cumple !

        lowerBounds(Arrays.asList(1, 2, 3));
//        lowerBounds(doubleList); -- no cumple el lower bound

        lowerBounds(objectList1); /*
         * Paradójicamente si lo cumple! porque Object es superclase de Number, y String es un
         * Object válido 🤣
         * */
    }

    static <T extends Comparable<T>> int countGreaterThan(T[] nums, T min)
    {
        int finalCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].compareTo(min) > 0) finalCount++;
        }
        return finalCount;
    }

    static <T extends List<V>, V> void printsListsOnly(T list)
    {
        list.forEach(System.out::println);
    }

    // MULTIPLE BOUNDS (&)
    // si se mezclan clases e interfaces, la clase debe ir _siempre_ primero

    static <T extends Collections & List<V>, V> void multipleBoundsToComply(T param)
    {
        System.out.println(param);

    }

    // UNBOUNDED WILDCARD (?)
    // Se usa para cuando el tipo de dato genérico es desconocido, pudiendo aceptar cualquiera.


    static void printLists(List<?> list)
    {
        list.forEach(el -> System.out.printf("%s - %s %n", el.getClass().getName(), el));
    }

    // UPPER BOUNDS + WILDCARDS
    // Sólo aceptará los tipos que sean Number ó desciendan de él
    static void upperBounds(List<? extends Number> numberList)
    {
        System.out.println(numberList);
    }

    // LOWER BOUNDS + WILDCARDS
    // Sólo aceptará Number o superclases de Number
    static void lowerBounds(List<? super Number> numberList)
    {
        System.out.println(numberList);
    }

}
