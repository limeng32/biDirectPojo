package myPackage;

public class PersonRole extends PojoSupport<PersonRole> {

	private Integer id;

	private Person person;

	private Role role;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person newPerson) {
		if (this.person == null || this.person != newPerson) {
			if (this.person != null) {
				Person oldPerson = this.person;
				this.person = null;
				oldPerson.removePersonRole(this);
			}
			if (newPerson != null) {
				this.person = newPerson;
				this.person.addPersonRole(this);
			}
		}
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role newRole) {
		if (this.role == null || this.role != newRole) {
			if (this.role != null) {
				Role oldRole = this.role;
				this.role = null;
				oldRole.removePersonRole(this);
			}
			if (newRole != null) {
				this.role = newRole;
				this.role.addPersonRole(this);
			}
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}