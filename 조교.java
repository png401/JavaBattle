package Player;
import java.util.Random;
import weapon.*;


public class 조교 extends Player{

	//private Weapon 꿀팁전달 = new Weapon
	
	private static int 학생도움횟수 = 0;
	private static int 과제몬도움횟수 = 0;
	
	public 조교(String name, String imgFile1) {
		super(name, imgFile1);
	}

	public void 학생돕기(Player 학생) {
		System.out.println("조교 등장!");
		System.out.println(this.name+"가 "+학생.name+"을 돕습니다!");
		Weapon[] 조교무기들 = {
				new Weapon("꿀팁 전달", 10, true, false, "조교"),
				new Weapon("공략 전수", 20, true, false, "조교"),
		};

		Weapon 선택 = 조교무기들[new Random().nextInt(조교무기들.length)];
		공격하기(학생, 선택);
		학생도움횟수++;

	}

	public void 과제몬지원하기(Player 과제몬) {
		System.out.println("조교 등장!");
		System.out.println(this.name+"가 "+과제몬.name+"을 돕습니다!");
		Weapon[] 조교무기들 = {
				new Weapon("과제 강화", 10, true, false, "조교"),
				new Weapon("공략 차단", 20, true, false, "조교")
		};

		Weapon 선택 = 조교무기들[new Random().nextInt(조교무기들.length)];
		공격하기(과제몬, 선택);
		과제몬도움횟수++;
	}

	public void 공격하기(Player target, Weapon w) {
		//조교는 돕기만 함!
		//System.out.println("조교가 돕는 코드를 구현하세요");
		System.out.println(this.name + "가 [" + w.name + "] 무기를 사용합니다!");
		int heal = w.getPower();  // 무기의 power 값 사용
	    target.setHp(target.getHp() + heal);
	    System.out.println("조교의 도움으로 " + target.name + "의 hp가 " + heal + "만큼 회복됐음!");
		}
		
		
	
	
	public static boolean 등장조건_학생(Player 학생) {
		return (학생.getHp() <= 30) && (학생도움횟수 <2) && (Math.random() < 0.9);
	}

	public static boolean 등장조건_과제몬(Player 과제몬) {
		return (과제몬.getHp() <= 30) && (과제몬도움횟수 <2) && (Math.random() < 0.9);
	}

}




