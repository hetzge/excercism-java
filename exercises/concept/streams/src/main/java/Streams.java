import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Streams {

	public static class Item {
		int id;
		String title;
		Instant timestamp;

		public int getId() {
			return this.id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return this.title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Instant getTimestamp() {
			return this.timestamp;
		}

		public void setTimestamp(Instant timestamp) {
			this.timestamp = timestamp;
		}
	}

	public static class ItemDto {
		int id;
		String title;
		Instant timestamp;

		public int getId() {
			return this.id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return this.title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Instant getTimestamp() {
			return this.timestamp;
		}

		public void setTimestamp(Instant timestamp) {
			this.timestamp = timestamp;
		}
	}

	public static enum SortBy {
		ID, TIMESTAMP;
	}

	public static class Query {
		int offset;
		int limit;
		String titlePrefix;
		SortBy sortBy;
		boolean desc;
	}

	public static List<ItemDto> createRequestStream(Item[] items, Query query) {
		return Stream.of(items) // create the stream from the array
				.skip(query.offset) // ignore the first elements until we are at offset position
				.limit(query.limit) // limit the result item count
				.filter(item -> query.titlePrefix == null || item.title.startsWith(query.titlePrefix)) // only keep elements with given prefix
				.sorted(Streams.createItemComparator(query)) // use an comparator to sort the items
				.map(Streams::toDto) // Convert the Item objects to ItemDto objects
				.toList(); // execute stream and collect result in a List
	}

	private static Comparator<Item> createItemComparator(Query query) {
		Comparator<Streams.Item> comparator;
		if (query.sortBy == SortBy.ID) {
			comparator = Comparator.comparing(Item::getId);
		} else if (query.sortBy == SortBy.TIMESTAMP) {
			comparator = Comparator.comparing(Item::getTimestamp);
		} else {
			comparator = (a, b) -> 0;
		}
		return query.desc ? comparator.reversed() : comparator;
	}

	private static ItemDto toDto(Item item) {
		final Streams.ItemDto dto = new ItemDto();
		dto.id = item.id;
		dto.title = item.title;
		dto.timestamp = item.timestamp;
		return dto;
	}
}
