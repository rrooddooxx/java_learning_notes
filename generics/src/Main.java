import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {


    // MALO
    List aGenericList = new ArrayList();

    aGenericList.add(1);
    aGenericList.add("1");

    System.out.println(aGenericList);

    // BUENO

    List<Integer> aNumbersList = new ArrayList<>()
  }
}
