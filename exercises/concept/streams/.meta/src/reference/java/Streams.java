import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Streams {

	public static List<ItemDto> createRequestStream(Item[] items, int offset, int limit, String titlePrefix,
			SortBy sortBy, boolean desc) {
		return Stream.of(items) // create the stream from the array
				// only keep elements with given prefix
				.filter(item -> titlePrefix == null || item.getTitle().startsWith(titlePrefix))
				// ignore the first elements until we are at offset position
				.skip(offset) 
				// limit the result item count
				.limit(limit) 
				// use an comparator to sort the items
				.sorted(Streams.createItemComparator(sortBy, desc)) 
				// convert the Item objects to ItemDto objects
				.map(item -> new ItemDto(item.getId(), item.getTitle()))
				// execute stream and collect result in a List
				.toList();
	}

	private static Comparator<Item> createItemComparator(SortBy sortBy, boolean desc) {
		Comparator<Item> comparator;
		if (sortBy == SortBy.ID) {
			comparator = Comparator.comparing(Item::getId);
		} else if (sortBy == SortBy.TITLE) {
			comparator = Comparator.comparing(Item::getTitle);
		} else {
			comparator = (a, b) -> 0;
		}
		return desc ? comparator.reversed() : comparator; 
	}
}
