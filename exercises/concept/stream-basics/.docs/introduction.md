# Introduction

## Java Streams

Java's standard library provides a concept named "Stream" that is implemented by the type `java.util.stream.Stream`. It provides a declarative API to execute operations on collections of data. So it can replace code that is typically implemented by as example for-loops and if-statements.

The typical steps to use `Stream`:

- Create the `Stream` from a existing collection (as example a `List` or an array). This can be done as example by the `Stream.of(array)` method from an array or the `Collection#stream()` method available in collections like `List`.
- Declare the operations to execute on the `Stream`. As example the `map` operation can be used to convert the items in the stream from one type to another. Other examples are the `sorted` operation to sort the items or the `filter` operation to exclude items from the `Stream`s result
- The last step is to collect the result items of the `Stream` back into a classical Java collection like `List` or an array. Without this last step a `Stream` will not do anything because all operations are lazy (which means they are not executed until we collect the `Stream`). A `Stream` can be collected by code like `myStream.collect(Collectors.toList())` or since Java 11 with `myStream.toList()`. Alternatively there are also useful method like `Stream#count()` which provides us a long with the count of result items of the `Stream`.

There are many things a `Stream` can do and it is not possible to explain them all in one place. Therefore it is a good practice to use [JavaDoc](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/stream/Stream.html) and/or an IDE to explore the possibilities. It's not easy to understand all the concepts behind `Stream`s directly. But many would say that the time invested is worth it.

Here are a few links to further explore the topic:

- https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
- https://www.baeldung.com/java-8-streams
