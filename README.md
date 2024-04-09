# JAVA LEARNING NOTES

> x Sebastián Kravetz @wwiiddeeweb

## Data Structures

## Generics

Se definen con el operador de diamantes `<>`

1. **Nos ayudan reforzar el checkeo de datos en tiempo de compilación.**

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

3. **Convenciones para el nombrado de los type parameters.**
    ````java
    <E>: "Element" -> usado harto en java.lang
    <K>: "Key" -> usado en Map
    <V>: "Value" -> usado en Map
    <N>: "Number"
    <T>: "Type"
    ````

4. **Usando _generics_ en clases.**

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


5. **Genéricos y métodos**

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
       ````java
       // ejemplo retorna el mismo tipo:
       public static <T> T getReturnedAsIs(T element)
       // ejemplo retorna una lista que contiene el mismo tipo:
       public static <T> List<T> getReturnedAsList(T[] arr)
      ````