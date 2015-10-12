import javax.swing.JOptionPane;


/**
 * 		�� Ŭ������ ������ ������ ������ ����ϴ� Ŭ�����̴�.
 *     ���� 
 *     		shuffle() - ī�带 �����ϰ� ���� �޼���
 *         start() - ������ �����ؼ� �÷��̾�� �������� ī�带 �����ִ� �޼���  
 * */
public class GameFunction {

	/*
	 * 	�� �޼����� ���� ������ �����ϱ⿡ �ռ� Ʈ���� ī�� 52���� math.random�Լ��� ����ؼ� ���´�.
	 *  
	 */
	static String[] imgPath = new String[4];

	public static  String shuffle(){
		//System.out.println("���ø޼����۵��� ");
		//count ������ ��� �������� ���� ī��Ʈ��
		int count = 0;
		String imgPath = "C:/Users/�̻���/Desktop/BlackJack/src/img/";
		while(true){
			//ī�带 �����ϰ� ���� ���� int ���� �����Ѵ�. 
			int card_result = (int)(Math.random()*52)+1;
			int card_div = 0;
			if(card_result>=1&&card_result<=13){	//��Ʈ
				//System.out.println("ī����"+card_result);
				
				card_div = dividing(card_result);
			
				return imgPath+"Hea"+card_div+".jpg";
			}
			if(card_result>=14&&card_result<=26){	//�����̵�
				//System.out.println("ī����"+card_result);
				
				card_div = dividing(card_result);
				
				return imgPath+"Spa"+card_div+".jpg";
			}
			if(card_result>=27&&card_result<=39){	//���̾�
				//System.out.println("ī����"+card_result);
				//ȭ�麸���ֳ��ؼ� .����
				//���ϱ� ��ŸƮ ������ ���λ����̵Ǵϱ�
				//���̶� ī��� �ٸ��� ������ ����
				//�� ���� ����¯���� ��¥ ������ ������
				card_div = dividing(card_result);
				
				return imgPath+"Dia"+card_div+".jpg";
			}
			if(card_result>=40&&card_result<=52){	//Ŭ��
				//System.out.println("ī����"+card_result);
				
				card_div = dividing(card_result);
				
				return imgPath+"Clu"+card_div+".jpg";
			}			
			
			
		}
		
	}
	
	/*
	 * 	�� �޼����� ������ ���� 52���� ������ ������ �÷��̾�� ���� 2���� ī�带 �й��ϰ� ���ѵ� �ؽ�Ʈ�ʵ忡 ������ ǥ����. 
	 *   -  ������ �÷��̾� �� 21���� ���� ������ ������ �¸��Ѵ�.
	 *   
	 *   start ��ư�� ���������� Ʈ�����
	 *   1. ����ī�带 �ҷ��ͼ� �÷��̾�� �������� �й�
	 *       - ������ �����ϰ� ���� ī�� �̹����� ������ �÷��̾�� ����������.
	 *   2. ������ ī�带 ������ ������ ���� �� 
	 *       -  21���� ��������� �÷��̾� �� ��� : �¸��߽��ϴ� �޼��� ���� 
	 *       -  21���� ��������� ������ ��� : �й��߽��ϴ� �޼��� ����   
	 */
	public static String imgPath(){
		//4���� �̹��� �����θ� ���� �迭���� 
		String imgSrc = null;
		imgSrc = shuffle();

		return imgSrc;
	}
	
	public static boolean start(){
		boolean flag = false;
		String[] arrImgPath = new String[imgPath.length];
		for(int i = 0 ; i<imgPath.length; i++){
			arrImgPath[i] = imgPath();
			GameFunction.setImgPath(arrImgPath);
			
			
			flag=true;
			
		}
		
		return flag;
		
	}
	
	//������� ���� �ۼ�
	//��������� ������ �÷��̾��� ������ �ջ��� ����� ���Ͽ� ��ȯ�ؾ���.
	public static int[] cardScore(int[] score){
		int[] totalScore = new int[2];
		for(int i = 0; i<score.length; i++){
			//�Ѿ�� 11,12,13 ���� 10���� ��ȯ 
			if(score[i]>=11 && score[i]<=13 ){
				score[i] = 10;
			}
			
			//���� ������ ������ ����� ����س���.
			System.out.println("ī������"+score[i]);
		}
		
		//���� �ջ� 
		int dealerScore = score[0]+score[1];
		int playerScore = score[2]+score[3];
		
		totalScore[0] = dealerScore;
		totalScore[1] = playerScore;
		
		if(dealerScore>playerScore){	//�÷��̾ �����
			String msg = "���ӿ��� ���̳׿�~�̤� \n �ٽ� �����Ͻðڽ��ϱ�?";
			 MessageBox box = new MessageBox(msg);
			
		}else if(dealerScore<playerScore){//�÷��̾ �̱���
			String msg = "���ӿ��� �̱�̳׿�~!! \n �ѹ� ��? ��?";
			MessageBox box = new MessageBox(msg);
			
		}else if(dealerScore==playerScore){//�����
			String msg = "���ӿ��� ���̳׿�~!! \n �Ʊ���..�ѹ� �� ��?";
			MessageBox box = new MessageBox(msg);
			
		}
		
		
		return totalScore;
	} 
	
	
	
	
	/*		�� �޼����� �ʿ伺
	 * 		���ϸ��� ��Ģ�� ���ؼ� ����.
	 * 		- ���� : �̸޼���� �����Լ��� ���� ī���� ������� 
	 *                  �μ��� �޾Ƽ� ���ǿ� ���� ���� ��ȯ���ش�.
	 * */
	public static int dividing(int card_result){
		//card_result���� 13���� �������� 0�ϰ�� 13�� ��ȯ���ش�.
		int returnValue = 0;
		
		if(card_result%13!=0){
			//card_result�� 13���� �������� �������� 0 �� �ƴ� ��� card_result���� returnValue�� �����Ͽ� ��ȯ 
			returnValue=card_result%13;
			
			return returnValue;
			
		}else if(card_result%13==0){
			//card_result�� 13���� �������� �������� 0 �� ��� retrunValue�� 13�� �����Ͽ� ��ȯ
			returnValue = 13;
		}
		
		return returnValue;
		
		
	}
	
	
	public static String[] getImgPath() {
		String[] arrImgPath = new String[imgPath.length];
		for(int i = 0 ; i<imgPath.length; i++){
			arrImgPath[i] = imgPath();
			GameFunction.setImgPath(arrImgPath);
		}
		return arrImgPath;
	}

	public static void setImgPath(String[] imgPath) {
		
		GameFunction.imgPath = imgPath;
	}

	
}












