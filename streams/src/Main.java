import java.util.ArrayList;
import java.util.List;

public
class Main {
  public static
  void main(String[] args)
  {
    
    System.out.println("--- STREAMS ---");
    
    // filter all users above 18yrs
    List<User> userList = new ArrayList<>();
    userList.add(new User(34, "Seba", "Kravetz"));
    userList.add(new User(15, "Lola", "Kravetz"));
    userList.add(new User(24, "Pablo", "Kravetz"));
    userList.add(new User(12, "Rodrigo", "Kravetz"));
    userList.add(new User(18, "Sofía", "Kravetz"));
    userList.add(new User(19, "Pabla", "Kravetz"));
    userList.add(new User(8, "Pedro", "Kravetz"));
    
    List<User> filteredList = userList.stream()
                                      .filter(user -> user.getAge() >= 18)
                                      .toList();
    
    System.out.println(filteredList);
  }
}
