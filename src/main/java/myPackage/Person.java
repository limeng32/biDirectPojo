package myPackage;

public class Person extends PojoSupport<Person> {
	public Person(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	private Integer id;
	private java.lang.String name;
	private java.util.Collection<PersonRole> personRole;

	public java.util.Collection<PersonRole> getPersonRole() {
		if (personRole == null) {
			personRole = new java.util.LinkedHashSet<PersonRole>();
		}
		return personRole;
	}

	public java.util.Iterator<PersonRole> getIteratorPersonRole() {
		if (personRole == null) {
			personRole = new java.util.LinkedHashSet<PersonRole>();
		}
		return personRole.iterator();
	}

	public void setPersonRole(java.util.Collection<PersonRole> newPersonRole) {
		removeAllPersonRole();
		for (java.util.Iterator<PersonRole> iter = newPersonRole.iterator(); iter.hasNext();) {
			addPersonRole((PersonRole) iter.next());
		}
	}

	public void addPersonRole(PersonRole newPersonRole) {
		if (newPersonRole == null) {
			return;
		}
		if (this.personRole == null) {
			this.personRole = new java.util.LinkedHashSet<PersonRole>();
		}
		if (!this.personRole.contains(newPersonRole)) {
			this.personRole.add(newPersonRole);
			newPersonRole.setPerson(this);
		} else {
			for (PersonRole temp : this.personRole) {
				if (newPersonRole.equals(temp)) {
					if (temp != newPersonRole) {
						removePersonRole(temp);
						this.personRole.add(newPersonRole);
						newPersonRole.setPerson(this);
					}
					break;
				}
			}
		}
	}

	public void removePersonRole(PersonRole oldPersonRole) {
		if (oldPersonRole == null) {
			return;
		}
		if (this.personRole != null) {
			if (this.personRole.contains(oldPersonRole)) {
				for (PersonRole temp : this.personRole) {
					if (oldPersonRole.equals(temp)) {
						if (temp != oldPersonRole) {
							temp.setPerson((Person) null);
						}
						break;
					}
				}
				this.personRole.remove(oldPersonRole);
				oldPersonRole.setPerson((Person) null);
			}
		}
	}

	public void removeAllPersonRole() {
		if (personRole != null) {
			PersonRole oldPersonRole;
			for (java.util.Iterator<PersonRole> iter = getIteratorPersonRole(); iter.hasNext();) {
				oldPersonRole = (PersonRole) iter.next();
				iter.remove();
				oldPersonRole.setPerson((Person) null);
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

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}
}