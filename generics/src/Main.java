import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args)
    {

        // EJ1.

        // MALO
        List aGenericList = new ArrayList();

        aGenericList.add(1);
        aGenericList.add("1");

        System.out.println(aGenericList);

    /*for (Object element : aGenericList) {
      Integer el = (Integer) element;
       -- this produces a runtime crash "class java.lang.String cannot be cast to class java.lang.Integer"
      System.out.println(el);
    }*/

        // BUENO
        List<Integer> aNumbersList = new ArrayList<>();
        aNumbersList.add(1);
        // aNumbersList.add("1"); -- forbidden by compiler, thnxs to generics :)
        // now executing methods for Integers is safe

        // EJ2.
        Comparable<Integer> number = 10; // provides safety for operations with implicit casting
        System.out.println(number.compareTo(11));

        // EJ3.
        List<String> listaNombres = new ArrayList<>();

        Map<String, Boolean> mapOfFlags = new HashMap<>();
        mapOfFlags.put("isReady", false);
        mapOfFlags.put("wasExecuted", false);
        System.out.println(mapOfFlags);

        // EJ4.

        Box<Phone> boxOfPhones = new Box<>();
        boxOfPhones.setState(new Phone("Nokia"));
        System.out.println(boxOfPhones.getState());

        Box<Letter> boxOfLetters = new Box<>();
        boxOfLetters.setState(new Letter("Seba"));
        System.out.println(boxOfLetters.getState());

        // EJ5.
        Box<Shape> boxOfRectangles = new Box<>();
        boxOfRectangles.setState(new Rectangle("rectángulo", 22.0, 12.4));
        System.out.println(boxOfRectangles.getState());

        Box<Shape> boxOfCircles = new Box<>();
        boxOfCircles.setState(new Circle("circulito", 22.0));
        System.out.println(boxOfCircles.getState());

    }
}
