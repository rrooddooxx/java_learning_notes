# JAVA LEARNING NOTES

> x Sebastián Kravetz @wwiiddeeweb

## Data Structures

## Generics

1. Nos ayudan reforzar el checkeo de datos en tiempo de compilación.

   Ejemplo: En una estructura de datos como _ArrayList_ nos permite asegurar qué tipo de datos
   se almacenarán en esta estructura.

    ```java
    // 👎
   
    List aGenericList = new ArrayList();
    aGenericList.add("1"); // crashea en runtime
    aGenericList.add(1);

   // 👍
   
   List<Integer> aNumbersList = new ArrayList<>();
    aNumbersList.add(1);
    aNumbersList.add("1"); // el compilador no permitirá esto, seremos notificados por el IDE antes de ejecutar el programa.
    ```

2. Para generalizar el tipado de una estructura, existen:
    1. Type parameters: Son los _placeholders_ que indican en donde debe especificarse un tipo
       concreto de datos, ejemplo:
   ```java
      public interface Map<K, V> 
   // en donde K= primer type parameter
   // y V= segundo type parameter
   ``` 
    2. Type arguments: Es cuando, en la posición de los _placeholders_ de los type parameters,
       declaramos el tipo de dato concreto al inicializar una estructura de datos.
   ```java
      Map<String, Integer> myMap = new HashMap<>();
   // en la posición K declaramos el tipo String
   // en la posición V declaramos el tipo Integer
   ``` 
      
