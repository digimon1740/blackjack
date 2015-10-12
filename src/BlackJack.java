/**	�� Ŭ������ ���� Ŭ�����ν�, 	���� �����ΰ� ��ư�� ���������� �̺�Ʈ�� ����ϴ� Ŭ���� �̴�. */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BlackJack extends JFrame implements ActionListener{

	/*		is a ���� 
	  �ڹٿ��� ��� ���踦 is a ��� �Ѵ�
	  ��) BlackJack extends JFrame == ������ JFrame �̴�
	  setSize(); 
	  
	       has a ����
	  �ڹٿ��� has a ����� ����ϰ� ���� ����� ���� Ŭ������ "�������"�� �����ϸ� �ȴ�. 
	  ��) JFrame jframe = new JFrame();
	  frame.setSize();
	
	*/
	
	//���̾ƿ��� �ʿ��� �г� ��ü ���� 
	JPanel north,south,east,center;
	//�� ��ü����
	JLabel la_player,la_dealer;
	//��ư�� ����
	JButton bt_shuffle,bt_start,bt_end;
	//�ؽ�Ʈ�ʵ� ����
	JTextField t_playerScore,t_dealerScore;
	
	//east������ �� �гλ��� 
	JPanel east_p1,east_p2,east_p3;
	
	//���Ϳ����� ī�带 �ø� �гλ���
	JPanel p_dealer,p_player;
	
	//�÷��̾���ȿ� �� 2�� �г� ����
	JPanel p_playerNorth, p_playerSouth;
	
	//���Ϳ��� ī���̹��� ������ �� ����
	JLabel la_dealerCard1,la_dealerCard2,la_playerCard1,la_playerCard2;
	
	//�̹����� ���� �̹��� ������ ��ü ���� 
	ImageIcon cardImg1,cardImg2,cardImg3,cardImg4;
	String cardImgSrc;
	
	
	public BlackJack(){

		super("BlackJack(21)");
		//�г��� �޸𸮿� �ø���.
		center = new JPanel();
		north = new JPanel();
		south = new JPanel();
		east = new JPanel();
		
		//�� �޸𸮿� �ø���. 
		la_player = new JLabel("�� �� �� ��   :  ");
		la_dealer = new JLabel("��        ��   :  ");
		
		//��ư �޸𸮿� �ø���.
		bt_shuffle = new JButton("Shuffle");
		bt_start = new JButton("Start");
		bt_end = new JButton("End");
		
		
		
		
		String[] initImgPath = new String[4];
		int[] score = new int[initImgPath.length];
		int[] totalScore = new int[2];
		String imgResult =null;
		for(int i = 0 ; i<initImgPath.length; i++){
			initImgPath[i] = GameFunction.imgPath();
			
			imgResult=initImgPath[i].substring(initImgPath[i].lastIndexOf("/")+1, initImgPath[i].indexOf("."));
 			imgResult =imgResult.substring(3, imgResult.length());
			
 			score[i] = Integer.parseInt(imgResult);
			
 			
			
		}
		
		totalScore= GameFunction.cardScore(score);
		String textDealerScore = ""+totalScore[0];
		String textPlayerScore = ""+totalScore[1];
		
		//�ؽ�Ʈ�ʵ� �޸𸮿� �ø���.
		t_dealerScore = new JTextField(textDealerScore);
		t_playerScore = new JTextField(textPlayerScore);//����� ����Ʈ �����ڸ� ��������� ���߿� ������ ����ϴ� �������� �ҷ��ͼ� �Ű������� �־��ָ��.
		
		cardImg2 = new ImageIcon(initImgPath[1]);
		cardImg3 = new ImageIcon(initImgPath[2]);
		cardImg4 = new ImageIcon(initImgPath[3]);
		cardImg1 = new ImageIcon(initImgPath[0]);
			
		//���Ϳ����� �󺧷� ī���̹����� �ø���.
		la_dealerCard1 = new JLabel(cardImg1);
		la_dealerCard2 = new JLabel(cardImg2);
		la_playerCard1 = new JLabel(cardImg3);
		la_playerCard2 = new JLabel(cardImg4);

		//���Ϳ����� ī�带 �ø� �г��� ����
		p_dealer = new JPanel();
		p_player = new JPanel();
		p_playerNorth = new JPanel();
		p_playerSouth = new JPanel();
		
	    p_player.setLayout(new GridLayout(2,0));
		//�÷��̾���ȿ� ���� 2�� �г��� �޸𸮿� �ø���
		p_player.add(p_playerNorth);
		p_player.add(p_playerSouth);
		p_playerSouth.add(la_playerCard1);
		p_playerSouth.add(la_playerCard2);
		
		//���ʿ��� �гξȿ� ������Ʈ ���� 
		north.add(la_dealer);
		north.add(t_dealerScore);
		
		//���ʿ��� �гξȿ� ������Ʈ ����
		south.add(la_player);
		south.add(t_playerScore);
		
		
		//���ʿ��� �гξȿ� ������Ʈ ����  &&  �гο� ����� �����ش�.
		east.setPreferredSize(new Dimension(115,150));
		
		//east���� �г��� ���̾ƿ��� �׸���� ������ 
		east.setLayout(new GridLayout(3,0));
		east.add(bt_shuffle);
		east.add(bt_start);
		east.add(bt_end);
		
		
		//center���� �г��� ���̾ƿ��� �׸���� ������.
		center.setLayout(new GridLayout(2,0));
		//p_dealer.setBackground(Color.RED);
		
		
		//���� �гο� ī��� ������Ʈ�� �ø���.
		p_dealer.add(la_dealerCard1);
		p_dealer.add(la_dealerCard2);
		
		
		//ī��� ������Ʈ�� �Ȱ��ִ� �г��� ���Ϳ����� ���δ�.
		center.add(p_dealer);
		center.add(p_player);
		
		
		//���̾ƿ� �г��� �����ӿ� ���δ�
		//���ʿ��� �г� ���̾ƿ��� ����
		this.add(north,BorderLayout.NORTH);	// static ������ �ִ� ������ �޼���� Ŭ������.������ ���� �ٷ� ����̰���
		//���ʿ��� �г� ���̾ƿ��� ����
		this.add(south,BorderLayout.SOUTH);
		//���� ���� �г� ���̾ƿ��� ����
		this.add(east,BorderLayout.EAST);
		//���� ���� �г� ���̾ƿ��� ���� 
		this.add(center,BorderLayout.CENTER);
		
		//��ư�� �͸��ܴ�.
		bt_shuffle.addActionListener(this);
		bt_start.addActionListener(this);
		bt_end.addActionListener(this);
		
		//�������� ������
		setBounds(400,80,800,600);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		//Object �� ��ü���⿡�� ��� Ŭ������ ����̱⶧���� 
		//� Ŭ�������� ����ȯ ���� ���� ���� �ִ� ���� ū �ڷ����̴ϱ� 
		Object obj = ae.getSource();

		
		if(obj.equals(bt_shuffle)){
			//System.out.println("���ù�ư�۵���");
			JOptionPane.showMessageDialog(getParent(), "ī�尡 �������ϴ�.");
			GameFunction.shuffle();
		}
		if(obj.equals(bt_start)){

			if(GameFunction.start())//��ŸƮ �޼��尡 �۵��Ҷ�
			//������ ȭ���� ������� 
			setVisible(false);
			//���ο� ȭ���� ������. 
			BlackJack jack = new BlackJack();
			
			
		}
		if(obj.equals(bt_end)){
			//�ý��� Ŭ������ static �޼����� exit�� ����ؼ� 
			//���μ����� ����
			int flag = JOptionPane.showConfirmDialog(getParent(), "�����Ͻðڽ��ϱ�?");
			if(flag==0){
				//this.setVisible(false);
				System.exit(0);
			}
			
		}
		
		
		
	}
	 
	

	public static void main(String[] arg){
			new BlackJack();
		
		
	}



	
	
	
	
	
	
	
}
