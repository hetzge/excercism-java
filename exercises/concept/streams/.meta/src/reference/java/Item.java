import java.util.Objects;

public final class Item {
	private int id;
	private String title;

	public Item(int id, String title) {
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
		return Objects.hash(this.id);
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
		final Item other = (Item) obj;
		return this.id == other.id;
	}

	@Override
	public String toString() {
		return "Item [id=" + this.id + ", title=" + this.title + "]";
	}
}