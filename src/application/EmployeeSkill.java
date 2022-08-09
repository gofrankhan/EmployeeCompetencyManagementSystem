package application;

public class EmployeeSkill extends Employee{
	
	private String category;
	private String skill_name;
	private String level;
	private String type;
	private int duration;
	
	public EmployeeSkill(){
		super();
	}
	
	public EmployeeSkill(String id, String full_name, String department, String designation, String
			email, String category, String skill_name, String level, String type, int duration){
		super(id,  full_name, department, designation, email);
		this.category = category;
		this.skill_name = skill_name;
		this.level = level;
		this.type = type;
		this.duration = duration;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSkill_name() {
		return skill_name;
	}

	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
