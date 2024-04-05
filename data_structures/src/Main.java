import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Main {
  public static void main(String[] args) {

    // arraylists
    // order: insertion order
    List<String> names = new ArrayList<>();
    names.add("Seba");
    names.add("Vichi");
    names.add("Chime");
    names.forEach(System.out::println);

    for (String name : names) {
      System.out.printf("Name: %s %n", name);
    }
    ;

    List<Integer> numberz = List.of(12, 23, 345);
    numberz.forEach(num -> System.out.println(num));

    // stack
    // order: LIFO
    Stack<String> nameStack = new Stack<>();
    nameStack.push("BOBBY");
    nameStack.push("SONNY");
    nameStack.push("MEINE");
    String peeking = nameStack.peek();
    System.out.println(nameStack);
    System.out.println(nameStack.size());
    String lastVal = nameStack.pop();
    System.out.println(lastVal);
    System.out.println(nameStack.size());

    // queues
    // order: FIFO

    Queue<PrintableDocument> printerQueue = new LinkedList<>();
    printerQueue.add(new PrintableDocument("doc1", ".pdf"));
    printerQueue.add(new PrintableDocument("doc2", ".doc"));
    printerQueue.add(new PrintableDocument("doc3", ".txt"));
    printerQueue.add(new PrintableDocument("doc4", ".pdf"));
    System.out.println(printerQueue);
    System.out.println(printerQueue.size());
    System.out.println(printerQueue.poll());
    System.out.println(printerQueue);
    System.out.println(printerQueue.size());
    System.out.println(printerQueue.poll());
    System.out.println(printerQueue.poll());
    System.out.println(printerQueue.poll());
    System.out.println(printerQueue.poll());
    System.out.println(printerQueue.poll());
    System.out.println(printerQueue);

    // linkedlists
    // order: insertion order

    LinkedList<PrintableDocument> docsLinkedList = new LinkedList<>();
    docsLinkedList.add(new PrintableDocument("file1", "pdf"));
    docsLinkedList.add(new PrintableDocument("file2", "pdf"));
    docsLinkedList.add(new PrintableDocument("file3", "pdf"));
    System.out.println(docsLinkedList);
    docsLinkedList.add(1, new PrintableDocument("xx", "pdf"));
    System.out.println(docsLinkedList);
    System.out.println(docsLinkedList.getFirst());
    System.out.println(docsLinkedList.get(3));
    for (PrintableDocument printableDocument : docsLinkedList) {
      System.out.println(printableDocument);
    }
    ListIterator iterator = docsLinkedList.listIterator();
    System.out.println("---LINKEDLIST ITERATOR---");
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    System.out.println("---LINKEDLIST ITERATOR BACKWARDS---");
    while (iterator.hasPrevious()) {
      System.out.println(iterator.previous());
    }

    // sets
    System.out.println("---SETS---");
    Set<User> userSet = new HashSet<>();
    userSet.add(new User("alex", 123));
    userSet.add(new User("alex", 123));
    userSet.add(new User("amanda", 111));
    userSet.add(new User("ángel", 232));
    System.out.println(userSet);
    System.out.println(userSet.contains(new User("pepito02", 111)));
    System.out.println(userSet.contains(new User("ángel", 232)));

    Iterator<User> userIterator = userSet.iterator();
    while (userIterator.hasNext()) {
      System.out.println(userIterator.next());
    }

    // maps
    System.out.println("---MAPS---");
    Map<String, String> userProperties = new HashMap<>();
    userProperties.put("name", "pepito");
    userProperties.put("edad", "32");
    userProperties.put("ciudad", "viña");

    System.out.println(userProperties);
    for (String key : userProperties.keySet()) {
      System.out.printf("key: %s, val: %s  %n", key, userProperties.get(key));
    }

    userProperties.forEach(
        (key, val) -> {
          System.out.printf("key: %s ! val: %s  %n", key, val);
        });

    userProperties
        .entrySet()
        .forEach(
            val -> {
              System.out.printf(" key: %s || value: %s %n", val.getKey(), val.getValue());
            });

    System.out.println("userProperties keys hashCode");
    userProperties.keySet().forEach(key -> System.out.println(key.hashCode()));

    Map<Integer, String> otroMap = new HashMap<>();
    otroMap.put(1, "hola");
    otroMap.put(2, "chao");

    System.out.println("otroMap");
    System.out.println(otroMap.entrySet());
    System.out.println("otroMap keys hashCode");
    otroMap.keySet().forEach(key -> System.out.println(key.hashCode()));

    Map<Person, String> personStringMap = new HashMap<>();
    Person lucia = new Person("Lucía");
    personStringMap.put(new Person("Lucía"), "Usuario encontrado!!");

    personStringMap.keySet().forEach(key -> System.out.println(key.hashCode()));
    System.out.println(lucia.hashCode());

    System.out.println(personStringMap.get(new Person("Lucía")));
  }

  static class Person {
    String name;

    public Person(String name) {
      this.name = name;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Person person = (Person) o;
      return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name);
    }
  }
}
