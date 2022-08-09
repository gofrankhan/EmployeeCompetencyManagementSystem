package application;

public class Employee {
	private String full_name;
	private String emp_id;
	private String department;
	private String designation;
	private Integer experience;
	private String phone_no;
	private String email;
	private String address;
	private String gender;
	
	public Employee(){
		
	}
	
	public Employee(String emp_id, String full_name, String department, String designation,
			String email){
		this.full_name = full_name;
		this.emp_id = emp_id;
		this.department = department;
		this.designation = designation;
		this.email = email;
	}
	
	public Employee(String full_name, String emp_id, String department, String designation,
			Integer experience, String phone_no, String email, String address, String gender){
		this.full_name = full_name;
		this.emp_id = emp_id;
		this.department = department;
		this.designation = designation;
		this.experience = experience;
		this.phone_no = phone_no;
		this.email = email;
		this.address = address;
		this.gender = gender;
	}
	
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
