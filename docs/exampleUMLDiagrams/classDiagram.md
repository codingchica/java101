# Example UML Diagram - Class Diagram

## Mermaid Syntax

The following syntax uses the [Mermaid Class Diagram syntax](https://mermaid.js.org/syntax/classDiagram.html).  
If you are viewing this page on github, or in certain IDEs, it may render as a diagram, rather than text.

The [Mermaid Live editor](https://mermaid.live/edit) can be used to draft such diagrams if your IDE does not render
them as an image when viewing the markdown file.

More information:
- [UML diagrams](http://websites.umich.edu/~eecs381/handouts/UMLNotationSummary.pdf)

## java.util.ArrayList

```mermaid
classDiagram
     direction LR
    `java.lang.Iterable&lt;T&gt;` <|-- `java.util.Collection&lt;E&gt;`
    `java.util.Collection&lt;E&gt;` <|-- `java.util.List&lt;E&gt;`
    `java.lang.Object` <|-- `java.util.AbstractCollection&lt;E&gt;`
    `java.util.Collection&lt;E&gt;` <|.. `java.util.AbstractCollection&lt;E&gt;`
    `java.util.AbstractCollection&lt;E&gt;` <|-- `java.util.AbstractList&lt;E&gt;`
    `java.util.AbstractList&lt;E&gt;` <|-- `java.util.ArrayList&lt;E&gt;`
    `java.util.List&lt;E&gt;` <|.. `java.util.AbstractList&lt;E&gt;`

    class `java.lang.Object` {
        +equals(Object obj) boolean
        +getClass() Class~?~
        +hashCode() int
        +notify() 
        +notifyAll()
        +toString() String
        +wait()
        +wait(long timeoutMillis)
        +wait(long timeoutMillis, int nanos)
    }
    
    class `java.lang.Iterable&lt;T&gt;` {
        <<interface>>
        +iterator() Iterator~T~*
    }

    class `java.util.Collection&lt;E&gt;`  {
        <<interface>>
        +add(~E~ e) boolean*
        +addAll(Collection&lt;? extends E&gt; c) boolean*
        +clear()*
        +contains(Object o) boolean*
        +containsAll(Collection~?~ c) boolean*
        +equals(Object o) boolean*
        +hashCode() int*
        +isEmpty() boolean*
        +remove(Object o) boolean*
        +removeAll(Collection~?~ c) boolean*
        +retainAll(Collection~?~ c) boolean*
        +size() int*
        +toArray() Object[]*
        +toArray(T[] a) ~T~ T[]*
    }

    class `java.util.List&lt;E&gt;` {
        <<interface>>
        +add(int index, E element)*
        +addAll(int index, Collection&lt;? extends E&gt; c) boolean*
        +get(int index) E*
        +indexOf(Object) int*
        +lastIndexOf(Object) int*
        +listIterator() listIterator*
        +listIterator(int) listIterator*
        +set(int, T) T*
        +subList(int, int) List~T~*

        +copyOf(Collection&lt;? extends E&gt;) List~E~$*
        +of() List~E~ $
        +of(E) List~E~ $
        +of(E, E) List~E~ $
        +of(E, E, E) List~E~ $
        +of(E, E, E, E) List~E~ $
        +of(E, E, E, E, E) List~E~ $
        +of(E, E, E, E, E, E) List~E~$
        +of(E, E, E, E, E, E, E) List~E~ $
        +of(E, E, E, E, E, E, E, E) List~E~ $
        +of(E, E, E, E, E, E, E, E, E) List~E~ $
        +of(E, E, E, E, E, E, E, E, E, E) List~E~ $
    }

    class `java.util.AbstractCollection&lt;E&gt;` {
        <<abstract>>
    }
    
    class `java.util.AbstractList&lt;E&gt;` {
        <<abstract>>
        +listIterator() ListIterator~E~
        +listIterator(int index) ListIterator~E~
    }

    class `java.util.ArrayList&lt;E&gt;` {
        +ArrayList() ArrayList
        +ArrayList(int initialCapacity) ArrayList
        +ArrayList(Collection&lt;? extends E&gt; c) ArrayList
        +ensureCapacity(int minCapacity)
        +trimToSize()
    }


    click `java.lang.Object` href "https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html" "Java 17 Javadoc java.lang.Object"
    click `java.lang.Iterable&lt;T&gt;` href "https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Iterable.html" "Java 17 Javadoc for java.lang.Iterable"
    click `java.util.Collection&lt;E&gt;` href "https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Collection.html" "Java 17 Javadoc for java.util.Collection"
    click `java.util.List&lt;E&gt;` href "https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html" "Java 17 Javadoc for java.util.List" 
    click `java.util.AbstractCollection&lt;E&gt;` href "https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/AbstractCollection.html" "Java 17 Javadoc for java.util.AbstractCollection"
    click `java.util.AbstractList&lt;E&gt;` href "https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/AbstractList.html" "Java 17 Javadoc for java.util.abstractList"


```

## codingchica.java101.model.Animal

```mermaid
classDiagram
     direction LR
    `java.lang.Object` <|-- `codingchica.java101.model.Animal`

    class `java.lang.Object` {
        +equals(Object obj) boolean
        +getClass() Class~?~
        +hashCode() int
        +notify() 
        +notifyAll()
        +toString() String
        +wait()
        +wait(long timeoutMillis)
        +wait(long timeoutMillis, int nanos)
    }
    
    class `codingchica.java101.model.Animal` {
        +getAgeInYears() long
        +getAgeInDays() long
        +getAgeInHours() long
        +getAge(AgeUnits units) long
        +getTimeOfBirth() Instant
        +setTimeOfBirth(Instant timeOfBirth)
    }

    click `java.lang.Object` href "https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html" "Java 17 Javadoc java.lang.Object"
    click `codingchica.java101.model.Animal` href "https://github.com/codingchica/java101/blob/main/src/main/java/codingchica/java101/model/Animal.java" "codingchica.java101.model.Animal.java"

```

