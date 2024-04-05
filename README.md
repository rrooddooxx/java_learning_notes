# JAVA LEARNING NOTES

> x Sebastián Kravetz @wwiiddeeweb

## Data Structures

## Generics

1. Nos ayudan reforar el checkeo de datos en tiempo de compilación.

   Ejemplo: En una estructura de datos como _ArrayList_ nos permite asegurar qué tipo de datos
   se almacenarán en esta estructura.

    ```java
    // 👎
   
    List aGenericList = new ArrayList();

    aGenericList.add(1);
    aGenericList.add("1"); // crashea en runtime

    System.out.println(aGenericList);
   
   // 👍
   
   List<Integer> aNumbersList = new ArrayList<>();
    aNumbersList.add(1);
   
    aNumbersList.add("1"); // el compilador no permitirá esto
   
    

```
