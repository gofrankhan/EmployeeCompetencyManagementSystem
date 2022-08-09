package application;

public class Skill {
	
	private String skill_name;
	private String level;
	private String type;
	private int duration;
	private String category;
	
	public Skill(){
		
	}
	
	public Skill(String skill_name, String level, String type, int duration){
		this.skill_name = skill_name;
		this.level = level;
		this.type = type;
		this.duration = duration;
	}

	public String getSkill_name() {
		return this.skill_name;
	}

	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
