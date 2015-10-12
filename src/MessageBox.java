import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 		이 클래스는 최종적인 결과 메세지가 나오는 클래스이다. 
 * 		승리했을경우 승리의 메세지를 
 * 		패배했을경우 패배의 메세지를 보여준다
 * */
public class MessageBox extends JFrame implements ActionListener{

	JPanel center,south;
	JButton bt_ok,bt_cancle; 
	JLabel la_msg;
	
	public MessageBox(String msg){
		
		
		center = new JPanel();
		south = new JPanel();
		
		bt_ok = new JButton("확인");
		bt_cancle = new JButton("취소");
		
		la_msg = new JLabel(msg);
		
		this.add(center,BorderLayout.CENTER);
		this.add(south,BorderLayout.SOUTH);
		
		center.add(la_msg);
		
		south.setLayout(new GridLayout(0,2));
		
		south.add(bt_ok);
		south.add(bt_cancle);
		
		
		bt_cancle.addActionListener(this);
		bt_ok.addActionListener(this);
		
		this.setVisible(true);
		this.setBounds(580,710,400,150);
	}

	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj.equals(bt_cancle)){
			this.setVisible(false);
		}
		if(obj.equals(bt_ok)){
			this.setVisible(false);

		}
		
	}
	
	
}






