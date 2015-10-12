import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 		�� Ŭ������ �������� ��� �޼����� ������ Ŭ�����̴�. 
 * 		�¸�������� �¸��� �޼����� 
 * 		�й�������� �й��� �޼����� �����ش�
 * */
public class MessageBox extends JFrame implements ActionListener{

	JPanel center,south;
	JButton bt_ok,bt_cancle; 
	JLabel la_msg;
	
	public MessageBox(String msg){
		
		
		center = new JPanel();
		south = new JPanel();
		
		bt_ok = new JButton("Ȯ��");
		bt_cancle = new JButton("���");
		
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






