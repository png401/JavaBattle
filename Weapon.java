package weapon;

public class Weapon {
	public String name;
	private int power;
	private boolean isHealing;//회복효과있는지
	private boolean isRandom;//효과 랜덤인지
	private String ownerType;//학생 or 과제몬 구분
	
	public int getPower() {
		return power;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	//생성자
	public Weapon(String name, int power) {
		super();
		this.name = name;
		this.power = power;
	}
	
	public Weapon(String name, int power, boolean isHealing, boolean isRandom, String ownerType) {
		this.name = name;
		this.power = power;
		this.isHealing = isHealing;
		this.isRandom = isRandom;
		this.ownerType = ownerType;
	}
	
	//getter만 지정, 어차피 무기 관련 다 바꿀 일 없음
	public boolean isHealing() {
		return isHealing;
	}
	public boolean isRandom() {
		return isRandom;
	}
	public String getOwnerType() {
		return ownerType;
	}
	

	
	
	
	 
	
	
}
