package practice.jdbc.mvc;

public class AddressDTO {
	
	private String seq;
	private String name;
	private String age;
	private String gender;
	private String tel;
	private String address;
	private String regdate;
	
	protected String getSeq() {
		return seq;
	}
	protected void setSeq(String seq) {
		this.seq = seq;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected String getAge() {
		return age;
	}
	protected void setAge(String age) {
		this.age = age;
	}
	protected String getGender() {
		return gender;
	}
	protected void setGender(String gender) {
		this.gender = gender;
	}
	protected String getTel() {
		return tel;
	}
	protected void setTel(String tel) {
		this.tel = tel;
	}
	protected String getAddress() {
		return address;
	}
	protected void setAddress(String address) {
		this.address = address;
	}
	protected String getRegdate() {
		return regdate;
	}
	protected void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
}

