# Hints

## General

## 1. Create a Stream

To create a Stream from an array you can use the static [Stream.of](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#of-T...-) factory method.

## 2. Transform the elements in the Stream

To convert the elements in the Stream from one type to another you can use the [Stream#map](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#map-java.util.function.Function-) method.

## 3. Skip elements / limit result size

To ignore the first x elements in the Stream you can use the [Stream#skip](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#skip-long-) method. 
To limit the element count in the result of the Stream you can check the [Stream#limit](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#limit-long-) method.

## 4. Exclude elements by condition

To exclude elements by a boolean expression from the result the [Stream#filter](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#filter-java.util.function.Predicate-) method can be used.

## 5. Sort elements

To sort the elements in the Stream the [Stream#sorted](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#sorted-java.util.Comparator-) method can be used in the combination with [Comparator](https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html)s.

## 6. Different patterns of callbacks

Many methods of a Java Stream requires to define a callback. This can happen in different shapes:

a) As anonymous class

```java
objectStream.forEach(new Consumer() {
	@Override
	public void accept(Object it) {
		doSomething(it);
	}
})
```
b) As single-line lambda function

```java
objectStream.forEach(it -> doSomething(it));
```
c) As multi-line lambda function

```java
objectStream.forEach(it -> {
	doSomething(it);
});
```
d) As method reference

```java
objectStream.forEach(this::doSomething);
```
e) As passed in function

```java
objectStream.forEach(createCallback());
...
private Consumer<Object> createCallback() {
	return it -> {
		doSomething(it);
	};
}
```



