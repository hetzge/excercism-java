import java.util.Objects;

public final class ItemDto {
	private int id;
	private String title;

	public ItemDto(int id, String title) {
		this.id = id;
		this.title = title;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(this.id, this.title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final ItemDto other = (ItemDto) obj;
		return this.id == other.id && Objects.equals(this.title, other.title);
	}

	@Override
	public String toString() {
		return "ItemDto [id=" + this.id + ", title=" + this.title + "]";
	}
}