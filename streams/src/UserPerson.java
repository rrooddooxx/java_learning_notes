import java.util.Objects;

public class UserPerson {
  private int age;
  private String firstName;
  private String lastName;
  private String email;
  private ExerciseTwo.Gender gender;
  
  public UserPerson(int age, String firstName, String lastName, String email, ExerciseTwo.Gender gender)
  {
    this.age = age;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.gender = gender;
  }
  
  public int getAge()
  {
    return age;
  }
  
  public String getFirstName()
  {
    return firstName;
  }
  
  public String getLastName()
  {
    return lastName;
  }
  
  public String getEmail()
  {
    return email;
  }
  
  public ExerciseTwo.Gender getGender()
  {
    return gender;
  }
  
  @Override
  public String toString()
  {
    return "UserPerson{" + "age=" + age + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", "
            + "email='" + email + '\'' + ", gender=" + gender + '}';
  }
  
  @Override
  public boolean equals(Object o)
  {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserPerson that = (UserPerson) o;
    return age == that.age && gender == that.gender && Objects.equals(firstName, that.firstName) && Objects.equals(
            lastName, that.lastName) && Objects.equals(email, that.email);
  }
  
  @Override
  public int hashCode()
  {
    return Objects.hash(age, firstName, lastName, email, gender);
  }
}
