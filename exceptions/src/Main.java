public class Main {
    public static void main(String[] args) {

        /*// EXCEPTION HANDLING

        // triggering exception
        try {
            Integer maybeNotANumber = Integer.parseInt("1");
            System.out.println(maybeNotANumber);
            //            System.out.println(10 / 0);
            throw new RuntimeException("this is not a test");
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("something unexpected blew up | error: " + e.getMessage());
        }*/


        //CHECKED EXCEPTIONS (checked at compile time)
        /*try {
            File aFile = new File("./foo.txt");
            if (!aFile.exists()) {
                aFile.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("error creating file | " + e.getMessage());
        }*/

        //THROWING AND CATCHING

        try {
            int divisionResult = divide(2, 0);
            System.out.println(divisionResult);
        } catch (Exception e) {
            System.out.printf("Error operating : %s : %s", e.getClass().getSimpleName(), e.getMessage());
        }

    }

    // CREATING MY OWN CHECKED EXCEPTION
    public static int divide(int a, int b) throws IllegalDivisionException {
        if (b == 0) {
            throw new IllegalDivisionException();
        }

        return a / b;
    }
}