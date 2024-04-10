# JAVA LEARNING NOTES

> x Sebastián Kravetz @wwiiddeeweb

## Data Structures

[➡️ EJERCICIOS](./data_structures/src/Main.java)

- ArrayList (orden de inserción)
- Stack (last in, first out - _LIFO_)
- Queue (first in, first out - _FIFO_)
- LinkedList (orden de inserción)
- Set (no garantiza orden)
- Map (orden por llaves)

## Generics

Se definen con el operador de diamantes `<>`

1. **Nos ayudan reforzar el checkeo de datos en tiempo de compilación.**

   Su existencia se relaciona con el riesgo de operaciones de _casting_ en la que el compilador
   no puede asegurar la integridad del tipado. Los _generics_ tienen su razón de ser sólo para
   reforzar las reglas del compilador y asegurar la consistencia de los tipos de datos.
   <br><br>

    - Ejemplo: En una estructura de datos como _ArrayList_ nos permite asegurar qué tipo de datos
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

<br>

2. **Para generalizar el tipado de una estructura, existen:**
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

<br>

3. **Convenciones para el nombrado de los type parameters.**
    ````java
    <E>: "Element" -> usado harto en java.lang
    <K>: "Key" -> usado en Map
    <V>: "Value" -> usado en Map
    <N>: "Number"
    <T>: "Type"
    ````

<br>

4. **Usando _generics_ en clases**: [➡️ EJERCICIOS](./generics/src/Main.java)

    ```java
    public class Box<T> {
    
        private T internalState;
    
        public void setState(T state)
        {
            this.internalState = state;
        }
    
        public T getState()
        {
            return this.internalState;
        }
    }
    ```

   Podemos luego, utilizar esta clase con cualquier tipo de dato concreto:

   ````java
   // EJ4.

        Box<Phone> boxOfPhones = new Box<>();
        boxOfPhones.setState(new Phone("Nokia"));
        System.out.println(boxOfPhones.getState());
   // Phone{brand='Nokia'}

        Box<Letter> boxOfLetters = new Box<>();
        boxOfLetters.setState(new Letter("Seba"));
        System.out.println(boxOfLetters.getState());
   // Letter{sender='Seba'}
   ````

   ````java
   // EJ5 
   Box<Shape> boxOfRectangles = new Box<>();
   boxOfRectangles.setState(new Rectangle("rectángulo", 22.0, 12.4));
   System.out.println(boxOfRectangles.getState());
   // Rectangle{name='rectángulo', width=22.0, height=12.4}

   Box<Shape> boxOfCircles = new Box<>();
   boxOfCircles.setState(new Circle("circulito", 22.0));
   System.out.println(boxOfCircles.getState());
   // Circle{name='circulito', radius=22.0}
   ````
   _EJ5: En este ejemplo, también estamos poniendo los tipos genéricos al servicio del
   polimorfismo, utilizando la interfaz Shape en común para los objetos de Rectangle y Circle_

<br>

5. **Genéricos y métodos**: [➡️ EJERCICIOS](./generics/src/GenericsAndMethods.java)

   Definiendo tipos de datos genéricos en la implementación de un método:

    1. Generic Type Parameter para ser utilizado como tipado de los parámetros del método.

       ````java
       public <T> void printValues(T[] valuesArray) {
            for (T element : valuesArray) 
             {
              // something...
             }
       }
       ````
    2. Generic Type Parameter para ser utilizado como tipado del retorno del método. El mismo
       genérico del parámetro del método es también usado para tipar su retorno.
        ```java
           // ejemplo retorna el mismo tipo:
           public static <T> T getReturnedAsIs(T element)
           // ejemplo retorna una lista que contiene el mismo tipo:
           public static <T> List<T> getReturnedAsList(T[] arr)
          ```

<br>

6. **Bounded Type Parameters**
   [➡️ EJERCICIOS](./generics/src/BoundedTypeParams.java)
   > In the context of Java generics, a "bound" refers to a restriction placed on a type parameter.
   It specifies the types that can be used as arguments for a type parameter in a generic class,
   interface, or method. Bounds are used to enforce type safety by ensuring that the generic type
   meets certain criteria, such as being a subclass of a particular class or implementing a
   particular interface.
    1. _Simple Bounded Type:_

       Sirven para acotar una definición genérica. Es decir, dado un generic type parameter `<T>`,
       podemos
       decir que este type parameter sólo funcione para ciertos tipos de datos.

       Esto se hace en base a una suerte de "herencia" y/o afinidad. Digamos que que el genérico
       `<T>` sólo debería funcionar para la familia de la interfaz List y sus implementaciones, pero
       no para otras estructuras de datos que no desciendan de List,
       podríamos decir: `<T extends List>`

        ```java
        // Ejemplos:
        // 1. 
        static <T extends Comparable<T>> int countGreaterThan(T[] nums, T min)
        {
            int finalCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i].compareTo(min) > 0) finalCount++;
            }
            return finalCount;
        }

        // 2. 
        static <T extends List<V>, V> void printsListsOnly(T list)
        {
            list.forEach(System.out::println);
        }

        ```

    2. _Multiple Bounded Types:_

       Acotan aún más lo que debe cumplir el genérico, pudiendo concatenar clases e interfaces para
       este propósito. Se utiliza el operador `&` para concatenar los tipos.

       La sintaxis es `<T extends Clase & Interfaz & ...>`
   > Importante: Si se mezclan clases e interfaces, las clases siempre deberán ser el primer
   > argumento del Bounded Type, y sólo puede ser una clase, pero no hay problema con múltiples
   > interfaces.

      ````java
      // MULTIPLE BOUNDS

      static <T extends Collections & List<V>, V> void multipleBoundsToComply(T param)
      {
          System.out.println(param);
      }
   
      // 👍
      List<String> anotherListForChristsSake = new ArrayList<>(Arrays.asList("Bye", "Byex"));
      multipleBoundsToComply(anotherListForChristsSake); // esto funciona! porque anotherListForChristsSake cumple todo lo solicitado en el genérico.
   
      // 👎
      Set<String> anotherMapForChristsSake = new ArrayList<>(Arrays.asList("Bye", "Byex"));
      multipleBoundsToComply(anotherMapForChristsSake);
      // esto no funciona, porque un Set<String> sólo cumple el requisito de Collection pero no el de List
      ````
    3. Unbounded Wildcard

       Se escribe con la sintaxis `<?>`. Permite definir un tipo genérico para dato desconocido,
       permitiendo cualquier que cualquier tipo de dato sea utilizado.
          ````java
          // ejemplo:
          static void printLists(List<?> list)
       ````
    4. Upper Bounded Wildcard
       > Fija un "límite superior" (limita arriba), es decir, permite usar tipos que sean el mismo ó
       los que están "hacia abajo" (subclases)

       > _"Type Set Direction: The set of acceptable types is "bounded above" by the specified type.
       That is, it includes the bound itself and any types that are "below" it in the hierarchy (
       subtypes)."_

       Sintaxis: `<T extends SubClass>` o `<T extends Interface>`

       ```java
         // UPPER BOUNDS + WILDCARDS
         // Sólo aceptará los tipos que sean Number ó desciendan de él
         static void upperBounds(List<? extends Number> numberList)
         {
             System.out.println(numberList);
         }
       ```

    5. Lower Bounded Wildcard
       > Fija un "límite inferior" (limita abajo), es decir, permite usar tipos que sean el mismo
       ó los que están "hacia arriba" en la jerarquía (superclases)

       > _"Type Set Direction: The set of acceptable types is "bounded below" by the specified type.
       This means it includes the bound itself and any types that are "above" it in the hierarchy (
       supertypes)."_

       Sintaxis: `<? super SuperClass>`

        ```java
        // LOWER BOUNDS + WILDCARDS
       // Sólo aceptará Number o superclases de Number
       static void lowerBounds(List<? super Number> numberList)
       {
            System.out.println(numberList);
       }
        ``` 

    6. Diferencias entre _Wildcards_ y _Bounded Type Parameters_:
        1. La unión de tipos (multiple bounds), sólo se puede con _bounded type parameters_, esto
           no es posible con _wildcards_:
           ```java
           // ejemplo de unión de tipos:
            static <T extends Collections & AnInterface> void method(T param) {}
           ```
        2. Los _bounded type parameters_ sólo tienen upper bound (_extends_), pero no se puede
           usar el lower bound (_super_), ya que esto es exclusivo de los _wildcards_.
        3. Los _wildcards_ NO permiten "capturar" un tipo para luego ser reutilizado en el mismo
           contexto de manera que se conozca su relación con otros tipos. Por ejemplo, no puedes
           declarar un método que tome un List<?> y luego añadir elementos de ese mismo tipo
           desconocido a la lista, porque el compilador no puede asegurar el tipo de los elementos
           de forma segura.

## Streams API

[➡️ EJERCICIOS](./streams/src/Main.java)

Permiten trabajar con un paradigma declarativo y funcional, versus el paradigma imperativo
clásico de Java.

Esto significa, por ejemplo al recorrer un arreglo, que no debemos hacernos cargo de definir
paso a paso el algoritmo: iniciar un ciclo, fijar contadores, fijar condiciones de límite, fijar
condicionales para terminar un recorrido, poblar una lista en base a lo encontrado, etc. En
cambio, podremos ejecutar las mismas operaciones desde una perspectiva funcional, utilizando
_funciones lambda_

**Componentes de los streams:**

1. Una colección (_Collections_)
2. Una serie de operaciones intermedias o "pipes" (_Intermediate Operators_). Estas son las
   operaciones concatenables, como _map_, _reduce_, _filter_, etc.
3. Operadores de finalización (_Terminal Operators_). Toman el resultado al final de todas las
   operaciones y lo almacenan en una estructura de datos apropiada.

> Nota: Para los _ARRAYS_ también podremos utilizar el Streams API, pero no se pueden usar
> directamente al no pertenecer a la interfaz Collections, en este caso es necesario utilizar el
> método
> Arrays.stream()

- [Ejercicio comparando implementaciones imperativas v/s declarativas](./streams/src/ExerciseOneStreams.java)
- [Ejercicio tomando datos separados por coma en un string y llevándolo a objetos procesados por 
  Streams](./streams/src/ExerciseTwo.java)