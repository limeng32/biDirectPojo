package myPackageA;

public class Role extends PojoSupport<Role> {
	public Role(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	private Integer id;
	private java.lang.String description;
	private java.util.Collection<PersonRoleFace> personRole;

	public java.util.Collection<PersonRoleFace> getPersonRole() {
		if (personRole == null)
			personRole = new java.util.LinkedHashSet<PersonRoleFace>();
		return personRole;
	}

	public java.util.Iterator<PersonRoleFace> getIteratorPersonRole() {
		if (personRole == null)
			personRole = new java.util.LinkedHashSet<PersonRoleFace>();
		return personRole.iterator();
	}

	public void setPersonRole(java.util.Collection<? extends PersonRoleFace> newPersonRole) {
		removeAllPersonRole();
		for (java.util.Iterator<? extends PersonRoleFace> iter = newPersonRole.iterator(); iter.hasNext();)
			addPersonRole((PersonRoleFace) iter.next());
	}

	public void addPersonRole(PersonRoleFace newPersonRole) {
		if (newPersonRole == null)
			return;
		if (this.personRole == null)
			this.personRole = new java.util.LinkedHashSet<PersonRoleFace>();
		if (!this.personRole.contains(newPersonRole)) {
			this.personRole.add(newPersonRole);
			newPersonRole.setRole(this);
		} else {
			for (PersonRoleFace temp : this.personRole) {
				if (newPersonRole.equals(temp)) {
					if (temp != newPersonRole) {
						removePersonRole(temp);
						this.personRole.add(newPersonRole);
						newPersonRole.setRole(this);
					}
					break;
				}
			}
		}
	}

	public void removePersonRole(PersonRoleFace oldPersonRole) {
		if (oldPersonRole == null)
			return;
		if (this.personRole != null)
			if (this.personRole.contains(oldPersonRole)) {
				for (PersonRoleFace temp : this.personRole) {
					if (oldPersonRole.equals(temp)) {
						if (temp != oldPersonRole) {
							temp.setRole((Role) null);
						}
						break;
					}
				}
				this.personRole.remove(oldPersonRole);
				oldPersonRole.setRole((Role) null);
			}
	}

	public void removeAllPersonRole() {
		if (personRole != null) {
			PersonRoleFace oldPersonRole;
			for (java.util.Iterator<PersonRoleFace> iter = getIteratorPersonRole(); iter.hasNext();) {
				oldPersonRole = (PersonRoleFace) iter.next();
				iter.remove();
				oldPersonRole.setRole((Role) null);
			}
			personRole.clear();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public java.lang.String getDescription() {
		return description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}
}