package 배틀과제;
import Player.*;
import View.MyWin1;
import weapon.Weapon;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

public class Main {
	public static void consoleGame(Player p1, Player p2) {
		Player attacker, target;
		조교 헬퍼 = new 조교("조교","조교.png");
		
		int i=0;
		
		while(true) {
			System.out.printf("====== %d ======\n", i+1);
			if(p1.getHp()<0||p2.getHp()<0) break;
			if(((int)(Math.random()*100))%2==0) {
				attacker = p1;
				target = p2;
			}
			else {
				attacker = p2;
				target = p1;
			}
			
			Weapon weapon = getRandomWeaponFor(attacker);
			attacker.공격하기(target, weapon);
			
			if(p1 instanceof 학생 && 조교.등장조건_학생(p1)) {
				헬퍼.학생돕기(p1);
			}
			else if (p2 instanceof 학생 && 조교.등장조건_학생(p2)) {
				헬퍼.학생돕기(p2);
			}
			
			if(p1 instanceof 과제몬 && 조교.등장조건_과제몬(p1)) {
				헬퍼.과제몬지원하기(p1);
			}
			else if (p2 instanceof 과제몬 && 조교.등장조건_과제몬(p2)) {
				헬퍼.과제몬지원하기(p2);
			}
			
			
			
			//각자 무기 있는 상태이므로
			//attacker.(target, attacker.getWeapon());
			System.out.println("\n 현재 상태");
			p1.show();
			p2.show();
			System.out.println("-----------------------------");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
			
		}
		
		Player winner;
		if(p1.getHp()<0) {
			winner = p2;
		}
		else winner = p1;
		
		System.out.println(winner.name+"의 승리!");
		
		
	}
	
	public static Weapon getRandomWeaponFor(Player p) {
		Weapon[] 학생무기들 = {
				new Weapon("형광펜 검", 10, false, false, "학생"),
				new Weapon("카페인 포션", 10, true, false, "학생"),
				new Weapon("챗GPT 소환", 15, false, false, "학생"),
				new Weapon("팀플 카드", 10, false, true, "학생"),
		};
		
		Weapon[] 과제몬무기들 = {
				new Weapon("과제 폭탄", 15, false, false, "과제몬"),
				new Weapon("기습 퀴즈", 5, false, false, "과제몬"),
				new Weapon("회복 포션", 10, true, false, "과제몬"),
				new Weapon("개념 미로", 10, false, false, "과제몬"),
				new Weapon("마감 모래시계", 10, false, false, "과제몬"),
		};
		
		Weapon[] 선택;
		
		if(p instanceof 학생) {
			선택 = 학생무기들;
		}
		else {
			선택 = 과제몬무기들;
		}
		
		int index = (int)(Math.random()*선택.length);
		return 선택[index];
		
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Player 학생 = new 학생("짱구", 100, 20);
		//Player 과제몬 = new 과제몬("과제몬", 120, 15);
		//System.out.println("이미지 경로: " + MyWin1.class.getResource("/images/학생1.png"));
		
		/*Weapon w1 = new Weapon("형광펜검", 10);
		Weapon w2 = new Weapon("귀여움", 10);
		Weapon w3 = new Weapon("잔소리", 20);*/
		
		//무기연결
		//p1.setWeapon(w1);
		//p2.setWeapon(w3);
		
		//콘솔에서 동작시킨다!
		
		Player 학생 = new 학생("짱구", 100, 20, "학생1.png", "학생2.png");
        Player 과제몬 = new 과제몬("과제몬", 120, 15, "과제몬1.png", "과제몬2.png");
		
        /*EventQueue.invokeLater(() -> {
        	MyWin1 frame = new MyWin1();
        	frame.setPlayers(학생, 과제몬);
        	frame.setVisible(true);
        });*/
        
	    //MyWin1 frame = new MyWin1();
	    //frame.setPlayers(학생, 과제몬);
	    //frame.setVisible(true);
	    
		
		//consoleGame(학생, 과제몬);
		
		//윈도우에서 동작시킨다!!
		winGame(학생, 과제몬);
		
		
	
	}
	
	public static void winGame(Player 학생, Player 과제몬) {
		//new MyWin1(학생, 과제몬).setPlayers(학생, 과제몬);
		//new MyWin1(학생, 과제몬).setVisible(true);
		//new setPlayers(학생, 과제몬).setVisible(true);
		EventQueue.invokeLater(() -> {
        	MyWin1 frame = new MyWin1();
        	frame.setPlayers(학생, 과제몬);
        	frame.setVisible(true);
        });
		
		
	}


	
	
}