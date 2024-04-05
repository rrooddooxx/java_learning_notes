package com.wideweb;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //        System.out.println("Hello JAVA ️🛠️!!");

        // primitive data types:

        int n = 128;
        char charsito = 'a';
        System.out.println(n);
        System.out.println(charsito);

        // numeric literals with underscore

        long bigNum = 2_000_000_000;
        int almostBigNum = 100_000_000;

        double numWithDecimal = 3_000.08;

        System.out.println(numWithDecimal);
        System.out.println(bigNum);
        System.out.println(almostBigNum);

        int anotherNum = 5;

        System.out.println(anotherNum);
        System.out.println(++anotherNum);
        System.out.println(--anotherNum);
        System.out.println(--anotherNum);
        System.out.println(anotherNum);

        System.out.println(anotherNum < 5);
        System.out.println(anotherNum >= 18);
        System.out.println(anotherNum != 18);

        int resultNum = 2;
        resultNum += anotherNum;
        System.out.println(resultNum);
        resultNum /= anotherNum; // igual a: resultNum = resultNum / anotherNum;
        System.out.println(resultNum);


        // STRINGS
        String myName = "Sebastián";
        System.out.println(myName.substring(1));
        System.out.println(myName.substring(0, 3));
        System.out.println(myName.substring(0, myName.length() - 1));
        System.out.println(myName.charAt(3));
        System.out.println(myName.charAt(myName.length() - 1));

        // checking empty/blank strings
        String aBlank = "    ";
        String anEmpty = "";
        System.out.println(aBlank.isEmpty()); // false
        System.out.println(aBlank.isBlank()); // true
        System.out.println(anEmpty.isEmpty()); // true
        System.out.println(anEmpty.isBlank()); // true

        // trim
        String toTrim = "aaa      ,        ddd   ";
        String[] strArr = toTrim.split(",");
        System.out.println(toTrim.trim());
        System.out.println(Arrays.stream(strArr).map(str -> str.trim()).collect(Collectors.joining(" - ")));
        System.out.println("              xxx         ".trim());


        /*// reference types / objects

        int edad = 33;
        Point pointA = new Point(2,32);
        System.out.println(pointA.getX());
        System.out.println(pointA.getY());*/


        /*// ARRAYS

        int[] numbersArr = {1,2,3,4};
        Arrays.stream(numbersArr).forEach(Main::logger);

        int[] anotherNumArr = new int[3];
        int[] anotherCopyNumArr = new int[3];
        anotherNumArr[0] = 1;
        anotherCopyNumArr [0] = 99;
        anotherNumArr[1] = 2;
        System.out.println(Arrays.toString(anotherNumArr));
        System.out.println(anotherNumArr);
        System.out.println(Arrays.toString(anotherCopyNumArr));
        System.out.println(anotherCopyNumArr);

        String[] namesArr = {"Seba", "Vichi", "Chime"};
        Arrays.stream(namesArr).forEach(System.out::println);


        Integer[] arrNumbs = new Integer[5];
        Arrays.fill(arrNumbs, 99);
        arrNumbs[3] = 22;
        System.out.println(Arrays.toString(arrNumbs));

        String[] namesArr2 = new String[4];
        Arrays.fill(namesArr2, "__");
        namesArr2[2] = "Valentina";
        System.out.println(Arrays.toString(namesArr2));*/

        // LOOPS

        /*// print hello 10 times

        for (int i = 0; i < 10; i++)
        {
            Main.logger("hello " + (i + 1));
        }

        for (int i = 0; i > -10; i--) {
            System.out.println("inverse loop! iteration no. " + ((i/-1)+1));
        }*/

        // looping arrays

        String[] namesArrAgain = {"Seba", "Vichi", "Chime", "Mimi", "Fifi"};

       /* for (int i = 0; i < namesArrAgain.length ; i++) {
            System.out.println(namesArrAgain[i]);
        }*/
        /*
        for (String name: namesArrAgain) {
            System.out.println("name : " + name);
        }

        Arrays.stream(namesArrAgain).forEach(System.out::println);
        Arrays.stream(namesArrAgain).forEach(Main::logger);
        */

       /* for (int i = (namesArrAgain.length - 1); i > -1; i--) {
            System.out.println(namesArrAgain[i]);
        }
*/

       /* // ex. 10 and 11
        int[] storedNumbers = {1,2,3,4,5,6,7,8};
        int total = 0;
        for (int i = 0; i < storedNumbers.length; i++) {
            total += storedNumbers[i];
        }
        System.out.println(" sum : " + total);*/

        // WHILE AND DO-WHILE

        /*
        while (counter < 5) {
            System.out.println("counter is doing fine! " + (counter+1));
            counter++;
        }*/
       /* int counter = 0;
        do {
            System.out.println("i'm dumb!!");
            counter++;
        } while (counter < 5);*/


   /* // IFS

        String genderInfo = "FEMAlE";
        if (genderInfo.equalsIgnoreCase("MALE") || genderInfo.equalsIgnoreCase("FEMALE")) {
            System.out.println("Binary Genders");
        } else {
            System.out.println("Nonbinary!");
        }*/

        // SWITCH

        //        char[] grades = {'A','B','C','D','E','F'};
        //        int randomNum = (int) (Math.random() * 10) % grades.length;
        Grades grade = Grades.PASS;
        switch (grade) {
            case EXCELLENT:
                System.out.println("Excellent!");
                break;
            case PASS:
                System.out.println("Pass");
                break;
            default:
                Main.logger("Failed");
                break;
        }

        // STORED SWITCH

        String switchResult = switch (grade) {
            case EXCELLENT -> "Excellent :)";
            case PASS -> "You did it!";
            default -> "You failed :(";
        };
        System.out.println(switchResult);

        // IMPORTS WITH FULLY QUALIFIED CLASS NAME

        Date aDate = new Date(1342342423);
        java.sql.Date dbDate = new java.sql.Date(1342342423);
        System.out.println(aDate + " | " + dbDate);

        // METHODS

        /*
         * GETTING NON-STATIC METHODS INTO STATIC CONTEXT (THIS "main" METHOD) BY
         * INSTANTIAING THE CLASS. IT ALLOWS CALLS TO PRIVATE
         * METHODS SINCE IT'S THE SAME CLASS, _DOESN'T BREAK ENCAPSULATION_
         */

        Main main = new Main();
        main.greet();


        // RENTAL YIELD CALCULATOR
        RentalCalc rentalCalc = new RentalCalc();
        System.out.println(rentalCalc.calculateRentalYield(1300, 250000) + "%");

        // EXECUTION ARGS
        if (args.length > 0) {
            System.out.println("ARGS RECEIVED: " + Arrays.toString(args));
        }

        // STRINGS

       /* String anyThing = " ";
        System.out.println(anyThing.isBlank()); // considera espacios
        System.out.println(anyThing.isEmpty()); // sólo considera el largo total, si el largo es mayor a 0, aunq sea con espacios ,da true.*/

        String name1 = "Sofía";
        String name2 = new String("Sofía");
        String name3 = "Sofía";

        // referencia -> puntero a una instancia.
        // el comparador "==" compara las referencias, no el valor.
        System.out.println(name1 == name2); // false porque name1 vive en el string pool y name2 en la memoria heap
        System.out.println(name1 == name3); // true porque ambos viven en el string pool

        // comparador "String.equals()" compara el valor.
        System.out.println(name1.equals(name2)); // es true, xq aunque sean dos referencias distintas el valor es igual.

        // String static methods
        String params1 = "ws-prueba";
        String params2 = "1245598";
        String params3 = "1.111.111-1";
        String xmlPayload = String.format("""
                                          <BODY>
                                          <Application name="@ipx-%s" params="%s">
                                            <WS:SOAP_STD123 app:WS_CTA_CTE_CLIENTE>%s</WS:SOAP_STD123>
                                            <WS:SOAP_STD123 app:WS_RUT_CLIENTE>%s</WS:SOAP_STD123>
                                          </Application>
                                          </BODY>
                                          """, params1, params1, params2, params3);
        System.out.println(xmlPayload);
        String[] namesToJoin = {"Valentina", "Rodrigo", "Sofía", "Diego"};
        System.out.println(String.valueOf(38.99));
        System.out.println(String.join(" - ", namesToJoin));

        // DATES AND TIME
        System.out.println("--LocalDateTime--");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.plusHours(2));
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now().getHour());
        System.out.println(LocalDateTime.parse("2022-10-07T00:00:00"));
        System.out.println(LocalDateTime.now().isAfter(LocalDateTime.parse("2022-10-07T00:00:00")));

        // ONLY DATES
        System.out.println("--LocalDate--");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getMonthValue());
        System.out.println(LocalDate.of(2022, Month.OCTOBER, 7));


        // ONLY TIME
        System.out.println("--LocalTime--");
        LocalTime localTime = LocalTime.now();
        LocalTime localTime2 = LocalTime.now();
        LocalTime specificTime = LocalTime.of(16, 33);
        System.out.println(localTime);
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(specificTime);
        System.out.println(LocalDateTime.of(LocalDate.of(2022, Month.OCTOBER, 7), LocalTime.of(16, 33)));
        System.out.println(specificTime.equals(LocalTime.of(16, 33)));

        // ZONES AND ZONED TIME
        System.out.println("--ZoneDateTime--");
        String zoneId = "Australia/Sydney";
        ZoneId zoneIdTime = ZoneId.of(zoneId);
        System.out.println(LocalDateTime.now(zoneIdTime));

        // ZONEDDATETIME TYPE
        System.out.println("--ZoneDateTime--");
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.isBefore(ZonedDateTime.now(ZoneId.of(zoneId))));

        // INSTANT. MARCA UN INSTANTE EN LA LÍNEA DE TIEMPO, SE USA PARA EVENTOS POR EJEMPLO.
        System.out.println("--INSTANT--");
        Instant anInstant = Instant.now();
        System.out.println(anInstant); // instante, utiliza x defecto el tiempo UTC
        System.out.println(anInstant.atZone(ZoneId.of("America/Santiago"))); // se puede justar el instante a una zona horaria
        System.out.println(LocalDateTime.now()); // esta fecha local, utiliza x defecto la zona horaria local.

        // BigDecimal
        System.out.println("--BigDecimal--");
        double double1 = 0.02;
        double double2 = 0.03;
        double dbResult = double2 - double1;
        // debería ser 0.01, pero por la falta de precisión de decimales, es aproximadamente 0.000099999998, no alcanza a redondear a 0.1
        System.out.println(dbResult + " | usando _double_");

        // la solución para recuperar esta precisión es usar BigDecimal, se recomienda para montos de dinero.
        BigDecimal dec1 = new BigDecimal("0.02");
        BigDecimal dec2 = new BigDecimal("0.03");
        System.out.println(dec2.subtract(dec1) + " | usando _BigDecimal_"); // se utilizan los métodos del objeto para las operaciones.

        System.out.println(dec2.subtract(dec1).floatValue());


        System.out.println("--Scanner - Text input--");
        System.out.println("Escribe tu nombre:");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Hola %s 😃", scanner.nextLine());
        System.out.println("\nEscribe tu número de teléfono: ");
        int telephoneNumber = scanner.nextInt();
        if (telephoneNumber > 0) {
            System.out.println("Teléfono recibido!");
        }
    }

    private void greet() {
        System.out.println("gr33t!");
    }

    static void logger(String message) {
        System.out.println(" [logger]: " + message);
    }


    ;

    enum Grades {
        EXCELLENT(), PASS(), FAILED(),

    }

}