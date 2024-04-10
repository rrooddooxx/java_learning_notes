import java.util.ArrayList;
import java.util.List;

public class ExerciseOneStreams {
  
  public static void main(String[] args)
  {
    System.out.printf("-- FORMA IMPERATIVA -- %n count: %s | list: %s %n%n", imperativeApproach(peopleList).size(),
                      imperativeApproach(peopleList));
    
    System.out.printf("-- FORMA DECLARATIVA/FUNCIONAL (STREAMS) -- %n count: %s | list: %s %n%n",
                      declarativeApproachWithStreams(peopleList).size(), declarativeApproachWithStreams(peopleList));
  }
  
  static List<Person> imperativeApproach(List<Person> list)
  {
    List<Person> filteredList = new ArrayList<>();
    int counter = 0;
    int limit = 10;
    for (Person person : list) {
      if (person.getAge() <= 18) {
        filteredList.add(person);
        counter++;
        if (counter == limit) {
          break;
        }
      }
    }
    return filteredList;
  }
  
  static List<Person> declarativeApproachWithStreams(List<Person> list)
  {
    return list.stream()
               .filter(person -> person.getAge() <= 18)
               .limit(10)
               .toList();
  }
  
  static List<Person> peopleList =
          List.of(new Person(23), new Person(22), new Person(15), new Person(12), new Person(8), new Person(56),
                  new Person(34), new Person(47), new Person(4), new Person(9), new Person(13), new Person(18),
                  new Person(17), new Person(27), new Person(34), new Person(31), new Person(67), new Person(8),
                  new Person(3), new Person(1));
  
  
}
