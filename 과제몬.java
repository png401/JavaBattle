package Player;
import java.util.Random;

import weapon.*;
import 배틀과제.Main;

public class 과제몬 extends Player{
	
	public 과제몬(String name, int hp, int power, String imgFile1, String imgFile2) {
		super(name, hp, power, imgFile1, imgFile2);
	}
	
	public void 과제내기(Player target) {
		System.out.println(this.name+"이 과제를 냅니다!");
		
		Weapon 선택 = Main.getRandomWeaponFor(this);
		공격하기(target, 선택);
		
		
	}

}
