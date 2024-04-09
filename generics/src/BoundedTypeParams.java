import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoundedTypeParams {
    public static void main(String[] args)
    {
        Double[] nums = {1.0, 2.2, 3.4, 4.0, 5.3, 6.3, 7.0, 8.0};
        System.out.println(countGreaterThan(nums, 5.7));

        Integer[] numsInt = {1, 3, 7, 9, 3, 4};
        System.out.println(countGreaterThan(numsInt, 5));

        System.out.println(countGreaterThan(new String[]{"Hello", "World"}, "Hello World"));

        List<String> listWords = new ArrayList<>(Arrays.asList("Hello", "world"));
        Set<String> setWords = new HashSet<>(Set.of("Hello", "World"));
        printsListsOnly(listWords);
        printsListsOnly(setWords);
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

}
