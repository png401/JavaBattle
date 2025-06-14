package Player;
import weapon.*;
import java.util.ArrayList;

public class Player implements 공격할수있는{
	public String name;
	private int hp, power;
	private Weapon weapon;
	//protected ArrayList<Weapon> weapons = new ArrayList<>();
	private String imgFile1;
	private String imgFile2;
	
	
	//생성자
	public Player(String name, int hp, int power, String imgFile1, String imgFile2) {
		super();
		this.name = name;
		this.hp = hp;
		this.power = power;
		
		this.setImgFile1(imgFile1);
		this.setImgFile2(imgFile2);
	}
	
	public Player(String name, String imgFile1) {
		this.name= name;
		this.setImgFile1(imgFile1);
	}
	
	//hp,power에 대해 getter, setter 구현
	public int getHp() {
		return hp;
	}
	
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getPower() {
		return power;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	/*public Weapon getWeapon() {
		if(weapons.isEmpty()) return null;
		int index = (int)(Math.random()*weapons.size());
		return weapons.get(index);
	}
	
	public void addWeapon(Weapon w) {
		weapons.add(w);
	}*/
	
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public void 공격하기(Player target) {
		if(this.weapon== null) {
			System.out.println(this.name+"이(가) 맨손으로 "+target.name+"을 공격한다!");
			target.hp -= this.power;
		}
		
		else {
		//System.out.println(this.name+"이(가) "+target.name+"을(를) "+weapon.name+"으로 공격한다!");
			공격하기(target, weapon);
			target.hp -= this.power+weapon.getPower();
		}
	}
	
	public void 공격하기(Player target, Weapon weapon) {
		System.out.println(this.name+"이(가) "+target.name+"을/를 ["+weapon.name+"]으로 공격한다!");
		//target.hp -= (this.power+weapon.getPower());
		if(weapon.isRandom()) {
			int effect = (Math.random()<0.5? -15:15);
			this.hp += effect;
			System.out.println("효과는 랜덤이다!");
			System.out.println("-> "+this.name+"의 HP가 "+(effect > 0 ? "회복" : "감소")+"되었다! ("+effect+")");
		}
		else if (weapon.isHealing()) {
			this.hp += weapon.getPower();
			System.out.println(this.name+"의 HP가 "+weapon.getPower()+"만큼 회복되었다! +");
		}
		else {
			int damage = this.power + weapon.getPower();
			target.hp -= damage;
			System.out.println(this.name+"의 공격! "+target.name+"에게 "+damage+"의 데미지!");//ctrl+alt+down
		}
		//set은 세팅하니까 매개변수가 필요하고 get은 나와야되니까 리턴값 있다.
	}
	
	//public void 
	
	public void show() {
		//System.out.printf("%s(%d, %d)\n", this.name, this.power, this.hp);
		System.out.printf("%-5s ▶️ HP: %3d | Power: %2d\n", this.name, this.hp, this.power);
	}
	
	public String getImgFile2() {
		return imgFile2;
	}



	public void setImgFile2(String imgFile2) {
		this.imgFile2 = imgFile2;
	}



	public String getImgFile1() {
		return imgFile1;
	}



	public void setImgFile1(String imgFile1) {
		this.imgFile1 = imgFile1;
	}
	
	
}
