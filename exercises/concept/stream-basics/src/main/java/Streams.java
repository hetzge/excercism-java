import java.util.List;

public class Streams {

	public static List<ItemDto> createRequestStream(Item[] items, int offset, int limit, String titlePrefix,
			SortBy sortBy, boolean desc) {
		/*
		 * TODO Implement this method to transform the given array of `Item`s to a list
		 * of `ItemDto`s specified by the other parameters. Implement the following
		 * steps by using the `Stream` type:
		 */
		// * a) create the stream from the array
		// * b) ignore the first elements until we are at offset position
		// * c) limit the result item count
		// * d) only keep elements with given prefix
		// * e) use an comparator to sort the items
		// * f) convert the Item objects to ItemDto objects
		// * g) execute the stream and collect result in a List
		throw new UnsupportedOperationException();
	}

}
