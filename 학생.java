package Player;

import java.util.Random;

import weapon.Weapon;

public class 학생 extends Player{
	
	public 학생(String name, int hp, int power, String imgFile1, String imgFile2) {
		super(name, hp, power, imgFile1, imgFile2);
	}
	
	public void 공부하기(Player target) {//name이 public이나 protected면 this사용 가능
		System.out.println(this.name+"이 공부를 시작합니다!");
		Weapon 형광펜검 = new Weapon("형광펜 검", 10, false, false, "학생");
		Weapon 카페인포션 = new Weapon("카페인 포션", 10, true, false, "학생");
		Random rand = new Random();
		Weapon 선택된무기 = (rand.nextBoolean() ? 형광펜검 : 카페인포션);
		setWeapon(선택된무기);
		this.공격하기(target);
		
	}
	
	public void 과제하기(Player target) {
		System.out.println(this.name+"이 과제를 시작합니다!");
		Weapon 챗GPT소환 = new Weapon("챗 GPT 소환", 15, false, false, "학생");
		Weapon 팀플카드 = new Weapon("팀플 카드", 15, true, false, "학생");
		Random rand = new Random();
		Weapon 선택된무기 = (rand.nextBoolean() ? 챗GPT소환 : 팀플카드);
		setWeapon(선택된무기);
		this.공격하기(target);
	}
	
	
	
}
