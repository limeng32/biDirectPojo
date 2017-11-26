package myPackageB;

public abstract class PojoSupport<T extends PojoSupport<T>> {

	abstract public Integer getId();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PojoSupport<?> other = (PojoSupport<?>) obj;
		if (getId() == null) {
			return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}
}