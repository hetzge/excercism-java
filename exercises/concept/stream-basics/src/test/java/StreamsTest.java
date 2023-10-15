import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class StreamsTest {

	private static final Item ZERO_ITEM = new Item(0, "PRE_ZERO");
	private static final Item ONE_ITEM = new Item(1, "ONE");
	private static final Item TWO_ITEM = new Item(2, "PRE_TWO");
	private static final Item THREE_ITEM = new Item(3, "THREE");

	private static final ItemDto ZERO_ITEM_DTO = new ItemDto(0, "PRE_ZERO");
	private static final ItemDto ONE_ITEM_DTO = new ItemDto(1, "ONE");
	private static final ItemDto TWO_ITEM_DTO = new ItemDto(2, "PRE_TWO");
	private static final ItemDto THREE_ITEM_DTO = new ItemDto(3, "THREE");

	@Test
	public void test_offset() {
		assertThat(Streams.createRequestStream(new Item[] { ZERO_ITEM, ONE_ITEM, TWO_ITEM, THREE_ITEM }, 2, 100, null,
				null, false)).containsExactly(TWO_ITEM_DTO, THREE_ITEM_DTO);
	}

	@Test
	public void test_offset_greater_then_length() {
		assertThat(Streams.createRequestStream(new Item[] { ZERO_ITEM, ONE_ITEM, TWO_ITEM, THREE_ITEM }, 4, 100, null,
				null, false)).isEmpty();
	}

	@Test
	public void test_limit() {
		assertThat(Streams.createRequestStream(new Item[] { ZERO_ITEM, ONE_ITEM, TWO_ITEM, THREE_ITEM }, 0, 2, null,
				null, false)).containsExactly(ZERO_ITEM_DTO, ONE_ITEM_DTO);
	}

	@Test
	public void test_limit_zero() {
		assertThat(Streams.createRequestStream(new Item[] { ZERO_ITEM, ONE_ITEM, TWO_ITEM, THREE_ITEM }, 0, 0, null,
				null, false)).isEmpty();
	}

	@Test
	public void test_prefix() {
		assertThat(Streams.createRequestStream(new Item[] { ZERO_ITEM, ONE_ITEM, TWO_ITEM, THREE_ITEM }, 0, 100, "PRE_",
				null, false)).containsExactly(ZERO_ITEM_DTO, TWO_ITEM_DTO);
	}

	@Test
	public void test_prefix_no_match() {
		assertThat(Streams.createRequestStream(new Item[] { ZERO_ITEM, ONE_ITEM, TWO_ITEM, THREE_ITEM }, 0, 100,
				"POST_", null, false)).isEmpty();
	}

	@Test
	public void test_sort_title() {
		assertThat(Streams.createRequestStream(new Item[] { ZERO_ITEM, ONE_ITEM, TWO_ITEM, THREE_ITEM }, 0, 100, null,
				SortBy.TITLE, false)).containsExactly(ONE_ITEM_DTO, TWO_ITEM_DTO, ZERO_ITEM_DTO, THREE_ITEM_DTO);
	}

	@Test
	public void test_sort_id_desc() {
		assertThat(Streams.createRequestStream(new Item[] { ZERO_ITEM, ONE_ITEM, TWO_ITEM, THREE_ITEM }, 0, 100, null,
				SortBy.ID, true)).containsExactly(THREE_ITEM_DTO, TWO_ITEM_DTO, ONE_ITEM_DTO, ZERO_ITEM_DTO);
	}

	@Test
	public void test_empty_input() {
		assertThat(Streams.createRequestStream(new Item[] {}, 0, 100, null, null, false)).isEmpty();
	}
}
