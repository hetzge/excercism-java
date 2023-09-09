import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class StreamsTest {

	@Test
	public void test() {
		assertThat(Streams.createRequestStream(new Item[] { new Item(0, "Some title"), new Item(1, "Some other title"), new Item(2, "prefix_one"), new Item(3, "prefix_two"), new Item(4, "prefix_three"), new Item(5, "Some more title"), new Item(6, "prefix_four"), new Item(7, "prefix_five"), }, 1, 3, "prefix_", SortBy.ID, true)).containsExactly(new ItemDto(3, "prefix_two"), new ItemDto(4, "prefix_three"), new ItemDto(6, "prefix_four"));
	}

}
