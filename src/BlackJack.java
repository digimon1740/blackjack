/**	이 클래스는 블랙잭 클래스로써, 	실제 디자인과 버튼을 눌렀을시의 이벤트를 담당하는 클래스 이다. */

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

	/*		is a 관계 
	  자바에서 상속 관계를 is a 라고 한다
	  예) BlackJack extends JFrame == 블랙잭은 JFrame 이다
	  setSize(); 
	  
	       has a 관계
	  자바에서 has a 관계는 사용하고 싶은 기능을 가진 클래스를 "멤버변수"로 소유하면 된다. 
	  예) JFrame jframe = new JFrame();
	  frame.setSize();
	
	*/
	
	//레이아웃에 필요한 패널 객체 선언 
	JPanel north,south,east,center;
	//라벨 객체선언
	JLabel la_player,la_dealer;
	//버튼을 선언
	JButton bt_shuffle,bt_start,bt_end;
	//텍스트필드 선언
	JTextField t_playerScore,t_dealerScore;
	
	//east영역에 들어갈 패널생성 
	JPanel east_p1,east_p2,east_p3;
	
	//센터영역에 카드를 올릴 패널생성
	JPanel p_dealer,p_player;
	
	//플레이어영역안에 들어갈 2개 패널 생성
	JPanel p_playerNorth, p_playerSouth;
	
	//센터영역 카드이미지 보여줄 라벨 생성
	JLabel la_dealerCard1,la_dealerCard2,la_playerCard1,la_playerCard2;
	
	//이미지를 담을 이미지 아이콘 객체 생성 
	ImageIcon cardImg1,cardImg2,cardImg3,cardImg4;
	String cardImgSrc;
	
	
	public BlackJack(){

		super("BlackJack(21)");
		//패널을 메모리에 올린다.
		center = new JPanel();
		north = new JPanel();
		south = new JPanel();
		east = new JPanel();
		
		//라벨 메모리에 올리기. 
		la_player = new JLabel("플 레 이 어   :  ");
		la_dealer = new JLabel("딜        러   :  ");
		
		//버튼 메모리에 올리기.
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
		
		//텍스트필드 메모리에 올리기.
		t_dealerScore = new JTextField(textDealerScore);
		t_playerScore = new JTextField(textPlayerScore);//현재는 디폴트 생성자를 사용하지만 나중에 점수를 계산하는 로직에서 불러와서 매개변수로 넣어주면됨.
		
		cardImg2 = new ImageIcon(initImgPath[1]);
		cardImg3 = new ImageIcon(initImgPath[2]);
		cardImg4 = new ImageIcon(initImgPath[3]);
		cardImg1 = new ImageIcon(initImgPath[0]);
			
		//센터영역에 라벨로 카드이미지를 올린다.
		la_dealerCard1 = new JLabel(cardImg1);
		la_dealerCard2 = new JLabel(cardImg2);
		la_playerCard1 = new JLabel(cardImg3);
		la_playerCard2 = new JLabel(cardImg4);

		//센터영역에 카드를 올릴 패널을 생성
		p_dealer = new JPanel();
		p_player = new JPanel();
		p_playerNorth = new JPanel();
		p_playerSouth = new JPanel();
		
	    p_player.setLayout(new GridLayout(2,0));
		//플레이어영역안에 들어가는 2개 패널을 메모리에 올리기
		p_player.add(p_playerNorth);
		p_player.add(p_playerSouth);
		p_playerSouth.add(la_playerCard1);
		p_playerSouth.add(la_playerCard2);
		
		//북쪽영역 패널안에 컴포넌트 부착 
		north.add(la_dealer);
		north.add(t_dealerScore);
		
		//남쪽영역 패널안에 컴포넌트 부착
		south.add(la_player);
		south.add(t_playerScore);
		
		
		//동쪽영역 패널안에 컴포넌트 부착  &&  패널에 사이즈를 정해준다.
		east.setPreferredSize(new Dimension(115,150));
		
		//east영역 패널의 레이아웃을 그리드로 나눈다 
		east.setLayout(new GridLayout(3,0));
		east.add(bt_shuffle);
		east.add(bt_start);
		east.add(bt_end);
		
		
		//center영역 패널의 레이아웃을 그리드로 나눈다.
		center.setLayout(new GridLayout(2,0));
		//p_dealer.setBackground(Color.RED);
		
		
		//딜러 패널에 카드라벨 컴포넌트를 올린다.
		p_dealer.add(la_dealerCard1);
		p_dealer.add(la_dealerCard2);
		
		
		//카드라벨 컴포넌트를 안고있는 패널을 센터영역에 붙인다.
		center.add(p_dealer);
		center.add(p_player);
		
		
		//레이아웃 패널을 프레임에 붙인다
		//북쪽영역 패널 레이아웃은 북쪽
		this.add(north,BorderLayout.NORTH);	// static 영역에 있는 변수나 메서드는 클래스명.변수명 으로 바로 사용이가능
		//남쪽영역 패널 레이아웃은 남쪽
		this.add(south,BorderLayout.SOUTH);
		//동쪽 영역 패널 레이아웃은 동쪽
		this.add(east,BorderLayout.EAST);
		//센터 영역 패널 레이아웃은 센터 
		this.add(center,BorderLayout.CENTER);
		
		//버튼에 귀를단다.
		bt_shuffle.addActionListener(this);
		bt_start.addActionListener(this);
		bt_end.addActionListener(this);
		
		//프레임의 사이즈
		setBounds(400,80,800,600);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		//Object 는 객체지향에서 모든 클래스의 어버이기때문에 
		//어떤 클래스든지 형변환 없이 받을 수가 있다 가장 큰 자료형이니까 
		Object obj = ae.getSource();

		
		if(obj.equals(bt_shuffle)){
			//System.out.println("셔플버튼작동중");
			JOptionPane.showMessageDialog(getParent(), "카드가 섞였습니다.");
			GameFunction.shuffle();
		}
		if(obj.equals(bt_start)){

			if(GameFunction.start())//스타트 메서드가 작동할때
			//기존의 화면은 사라지고 
			setVisible(false);
			//새로운 화면이 생성됨. 
			BlackJack jack = new BlackJack();
			
			
		}
		if(obj.equals(bt_end)){
			//시스템 클래스의 static 메서드인 exit를 사용해서 
			//프로세스를 종료
			int flag = JOptionPane.showConfirmDialog(getParent(), "종료하시겠습니까?");
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
