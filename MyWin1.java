package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Player.Player;
import Player.조교;
import weapon.Weapon;
import 배틀과제.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyWin1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel 학생Image;
	private JLabel 과제몬Image;
	private JProgressBar 학생bar;
	private JButton 학생btn;
	private JLabel 학생name;
	private JLabel 학생hp;
	private JLabel 학생nameValue;
	private JLabel 학생hpValue;
	private JLabel 과제몬name;
	private JLabel 과제몬hp;
	private JLabel 과제몬nameValue;
	private JLabel 과제몬hpValue;
	private JButton 과제몬btn;
	private JProgressBar 과제몬bar;

	/**
	 * Launch the application.
	 */
	
	private Player 학생;
	private Player 과제몬;
	private 조교 헬퍼 = new 조교("조교", "조교.png");
	private Random random = new Random();
	private JScrollPane scrollPane;
	
	public MyWin1(Player 학생, Player 과제몬) {
		this();
		this.학생 = 학생;
		this.과제몬 = 과제몬;
		
		System.out.println("학생 정보로 업데이트1");
		//이름교체
		System.out.println(학생.name);
		학생nameValue.setText(학생.name);
		
		학생hpValue.setText(Integer.toString(학생.getHp()));
		
		학생bar.setMinimum(0);
		학생bar.setMaximum(100);
		학생bar.setValue(학생.getHp());
		
		학생Image.setIcon(new ImageIcon(MyWin1.class.getResource("/images/학생1.png")));
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyWin1 frame = new MyWin1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void updateStatus() {
		학생hpValue.setText(String.valueOf(학생.getHp()));
		학생bar.setValue(학생.getHp());
		과제몬hpValue.setText(String.valueOf(과제몬.getHp()));
		과제몬bar.setValue(과제몬.getHp());
		
		if(학생.getHp()<=0) {
			학생Image.setIcon(new ImageIcon(MyWin1.class.getResource("/images/"+학생.getImgFile2())));
			학생btn.setEnabled(false);
			과제몬btn.setEnabled(false);
		}
		
		if(과제몬.getHp()<=0) {
			과제몬Image.setIcon(new ImageIcon(MyWin1.class.getResource("/images/"+과제몬.getImgFile2())));
			학생btn.setEnabled(false);
			과제몬btn.setEnabled(false);
		}
		
	}
	
	/**
	 * Create the frame.
	 */
	public MyWin1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//학생/과제몬 이미지
		과제몬Image = new JLabel("New label");
		과제몬Image.setBounds(464, 0, 206, 213);
		과제몬Image.setIcon(new ImageIcon(MyWin1.class.getResource("/images/과제몬1.png")));
		contentPane.add(과제몬Image);
		
		학생Image = new JLabel("New label");
		학생Image.setIcon(new ImageIcon(MyWin1.class.getResource("/images/학생1.png")));
		학생Image.setBounds(4, 0, 212, 213);
		contentPane.add(학생Image);
		
		//HP bar
		학생bar = new JProgressBar();
		학생bar.setForeground(new Color(0, 128, 64));
		학생bar.setValue(100);
		학생bar.setBounds(23, 336, 193, 35);
		contentPane.add(학생bar);
		
		과제몬bar = new JProgressBar();
		과제몬bar.setForeground(new Color(0, 128, 64));
		과제몬bar.setValue(100);
		과제몬bar.setBounds(464, 336, 193, 35);
		contentPane.add(과제몬bar);
		
		//버튼
		학생btn = new JButton("과제하기");
		학생btn.setFont(new Font("HY견고딕", Font.PLAIN, 20));
		학생btn.setBounds(31, 275, 185, 51);
		//학생btn.setEnabled(false);//초기 비활성화
		contentPane.add(학생btn);
		
		과제몬btn = new JButton("과제내기");
		과제몬btn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 20));
		과제몬btn.setBounds(464, 275, 185, 51);
		//과제몬btn.setEnabled(false);
		contentPane.add(과제몬btn);

		
	
		//이름/hp 라벨
		학생name = new JLabel("이름");
		학생name.setBounds(23, 215, 43, 28);
		contentPane.add(학생name);
		
		학생hp = new JLabel("HP");
		학생hp.setBounds(23, 251, 50, 28);
		contentPane.add(학생hp);
		
		학생nameValue = new JLabel("New label");
		학생nameValue.setBounds(81, 215, 94, 28);
		contentPane.add(학생nameValue);
		
		학생hpValue = new JLabel("New label");
		학생hpValue.setBounds(78, 251, 97, 28);
		contentPane.add(학생hpValue);
		
		과제몬name = new JLabel("이름");
		과제몬name.setBounds(474, 215, 43, 28);
		contentPane.add(과제몬name);
		
		과제몬hp = new JLabel("HP");
		과제몬hp.setBounds(474, 251, 43, 28);
		contentPane.add(과제몬hp);
		
		과제몬nameValue = new JLabel("New label");
		과제몬nameValue.setBounds(555, 215, 94, 28);
		contentPane.add(과제몬nameValue);
		
		과제몬hpValue = new JLabel("New label");
		과제몬hpValue.setBounds(553, 251, 97, 28);
		contentPane.add(과제몬hpValue);	
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(4, 372, 666, 88);
		contentPane.add(scrollPane);
		
		JTextArea ta = new JTextArea();
		scrollPane.setViewportView(ta);
		
		System.setOut(new java.io.PrintStream(new TextAreaOutputStream(ta), true));
		System.setOut(new java.io.PrintStream(new TextAreaOutputStream(ta), true));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MyWin1.class.getResource("/images/배경.png")));
		lblNewLabel.setBounds(0, 0, 680, 470);
		contentPane.add(lblNewLabel);
	}
	
	public void setPlayers(Player 학생, Player 과제몬) {
		this.학생 = 학생;
		this.과제몬 = 과제몬;
		
		//라벨 업데이트
		학생nameValue.setText(학생.name);
		과제몬nameValue.setText(과제몬.name);
		학생hpValue.setText(Integer.toString(학생.getHp()));
		과제몬hpValue.setText(Integer.toString(과제몬.getHp()));
		학생bar.setValue(학생.getHp());
		과제몬bar.setValue(과제몬.getHp());
		
		//이미지 업데이트
		학생Image.setIcon(new ImageIcon(MyWin1.class.getResource("/images/"+학생.getImgFile1())));
		과제몬Image.setIcon(new ImageIcon(MyWin1.class.getResource("/images/"+과제몬.getImgFile1())));
		
		//버튼 활성화
		학생btn.setEnabled(true);
		과제몬btn.setEnabled(true);
		
		//버튼 이벤트
		학생btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("학생이 공격한다");
				//Weapon 무기 = new Weapon("챗GPT 소환", 15, false, false, "학생");
				Weapon 무기 = Main.getRandomWeaponFor(학생);
				학생.공격하기(과제몬, 무기);
				checkStatus();
			}
		});
		
		과제몬btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("과제몬 공격!");
                Weapon 무기 = Main.getRandomWeaponFor(과제몬);
                과제몬.공격하기(학생, 무기);
                checkStatus();
            }
        });
		
		
		
	}
	
	private void checkStatus() {
		학생hpValue.setText(Integer.toString(학생.getHp()));
		과제몬hpValue.setText(Integer.toString(과제몬.getHp()));
		학생bar.setValue(학생.getHp());
        과제몬bar.setValue(과제몬.getHp());

        if(헬퍼.등장조건_학생(학생)) {
        	헬퍼.학생돕기(학생);
        	ImageIcon icon = new ImageIcon(MyWin1.class.getResource("/images/조교.png"));
        	JOptionPane.showMessageDialog(MyWin1.this,
                    "조교 등장!\n" + 학생.name + "을 도왔습니다!",
                    "조교 지원",
                    JOptionPane.INFORMATION_MESSAGE, icon);
        }
        
        if (조교.등장조건_과제몬(과제몬)) {
            헬퍼.과제몬지원하기(과제몬);
        	ImageIcon icon = new ImageIcon(MyWin1.class.getResource("/images/조교.png"));
            JOptionPane.showMessageDialog(MyWin1.this,
                "조교 등장!\n" + 과제몬.name + "을 도왔습니다!",
                "조교 지원",
                JOptionPane.INFORMATION_MESSAGE, icon);
        }
        
        //사망처리
        if (학생.getHp() <= 0) {
            학생Image.setIcon(new ImageIcon(MyWin1.class.getResource("/images/" + 학생.getImgFile2())));
            학생btn.setEnabled(false);
            과제몬btn.setEnabled(false);
        }

        if (과제몬.getHp() <= 0) {
            과제몬Image.setIcon(new ImageIcon(MyWin1.class.getResource("/images/" + 과제몬.getImgFile2())));
            학생btn.setEnabled(false);
            과제몬btn.setEnabled(false);
        }
	}
	}
	

