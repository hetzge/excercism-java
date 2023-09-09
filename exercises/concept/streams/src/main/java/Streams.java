import java.util.List;

public class Streams {

	public static List<ItemDto> createRequestStream(Item[] items, int offset, int limit, String titlePrefix, SortBy sortBy, boolean desc) {
		throw new UnsupportedOperationException();
		// TODO Implement this method to transform the given array of `Item`s to a list
		// of `ItemDto`s specified by the other parameters. Implement the following
		// steps by using the `Stream` type:
		// * create the stream from the array
		// * ignore the first elements until we are at offset position
		// * limit the result item count
		// * only keep elements with given prefix
		// * use an comparator to sort the items
		// * Convert the Item objects to ItemDto objects
		// * execute the stream and collect result in a List
	}

}
