import javax.swing.JOptionPane;


/**
 * 		이 클래스는 실제로 게임의 로직을 담당하는 클래스이다.
 *     설명 
 *     		shuffle() - 카드를 랜덤하게 섞는 메서드
 *         start() - 게임을 실행해서 플레이어와 딜러에게 카드를 나눠주는 메서드  
 * */
public class GameFunction {

	/*
	 * 	이 메서드의 역할 게임을 시작하기에 앞서 트럼프 카드 52장을 math.random함수를 사용해서 섞는다.
	 *  
	 */
	static String[] imgPath = new String[4];

	public static  String shuffle(){
		//System.out.println("셔플메서드작동중 ");
		//count 변수는 몇번 섞일지에 대한 카운트값
		int count = 0;
		String imgPath = "C:/Users/이상훈/Desktop/BlackJack/src/img/";
		while(true){
			//카드를 랜덤하게 섞은 값을 int 형에 저장한다. 
			int card_result = (int)(Math.random()*52)+1;
			int card_div = 0;
			if(card_result>=1&&card_result<=13){	//하트
				//System.out.println("카드밸류"+card_result);
				
				card_div = dividing(card_result);
			
				return imgPath+"Hea"+card_div+".jpg";
			}
			if(card_result>=14&&card_result<=26){	//스페이드
				//System.out.println("카드밸류"+card_result);
				
				card_div = dividing(card_result);
				
				return imgPath+"Spa"+card_div+".jpg";
			}
			if(card_result>=27&&card_result<=39){	//다이아
				//System.out.println("카드밸류"+card_result);
				//화면보고있나해서 .ㅋㅋ
				//보니까 스타트 누를때 새로생성이되니까
				//값이랑 카드랑 다르게 나오네 ㅋㅋ
				//아 스윙 좃나짱난다 진짜 ㅋㅋㅋ ㅋㅋㅋ
				card_div = dividing(card_result);
				
				return imgPath+"Dia"+card_div+".jpg";
			}
			if(card_result>=40&&card_result<=52){	//클럽
				//System.out.println("카드밸류"+card_result);
				
				card_div = dividing(card_result);
				
				return imgPath+"Clu"+card_div+".jpg";
			}			
			
			
		}
		
	}
	
	/*
	 * 	이 메서드의 역할은 섞은 52장을 가지고 딜러와 플레이어에게 각각 2장의 카드를 분배하고 비교한뒤 텍스트필드에 점수를 표시함. 
	 *   -  딜러와 플레이어 중 21점에 가장 근접한 점수가 승리한다.
	 *   
	 *   start 버튼을 눌렀을때의 트랜잭션
	 *   1. 섞인카드를 불러와서 플레이어와 딜러에게 분배
	 *       - 실제로 랜덤하게 섞인 카드 이미지가 딜러와 플레이어에게 보여져야함.
	 *   2. 나눠진 카드를 가지고 점수를 비교한 뒤 
	 *       -  21점에 가까운사람이 플레이어 일 경우 : 승리했습니다 메세지 띄우기 
	 *       -  21점에 가까운사람이 딜러일 경우 : 패배했습니다 메세지 띄우기   
	 */
	public static String imgPath(){
		//4개의 이미지 절대경로를 담을 배열선언 
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
	
	//점수계산 로직 작성
	//점수계산은 딜러와 플레이어의 점수를 합산한 결과를 비교하여 반환해야함.
	public static int[] cardScore(int[] score){
		int[] totalScore = new int[2];
		for(int i = 0; i<score.length; i++){
			//넘어온 11,12,13 값을 10으로 변환 
			if(score[i]>=11 && score[i]<=13 ){
				score[i] = 10;
			}
			
			//받은 점수를 가지고 결과를 출력해낸다.
			System.out.println("카드점수"+score[i]);
		}
		
		//점수 합산 
		int dealerScore = score[0]+score[1];
		int playerScore = score[2]+score[3];
		
		totalScore[0] = dealerScore;
		totalScore[1] = playerScore;
		
		if(dealerScore>playerScore){	//플레이어가 진경우
			String msg = "게임에서 지셨네요~ㅜㅜ \n 다시 시작하시겠습니까?";
			 MessageBox box = new MessageBox(msg);
			
		}else if(dealerScore<playerScore){//플레이어가 이긴경우
			String msg = "게임에서 이기셨네요~!! \n 한번 더? 콜?";
			MessageBox box = new MessageBox(msg);
			
		}else if(dealerScore==playerScore){//비긴경우
			String msg = "게임에서 비기셨네요~!! \n 아깝네..한번 더 콜?";
			MessageBox box = new MessageBox(msg);
			
		}
		
		
		return totalScore;
	} 
	
	
	
	
	/*		이 메서드의 필요성
	 * 		파일명의 규칙을 위해서 쓴다.
	 * 		- 사용법 : 이메서드는 랜덤함수로 돌린 카드의 결과값을 
	 *                  인수로 받아서 조건에 따라 값을 반환해준다.
	 * */
	public static int dividing(int card_result){
		//card_result값을 13으로 나눴을때 0일경우 13을 반환해준다.
		int returnValue = 0;
		
		if(card_result%13!=0){
			//card_result를 13으로 나눴을때 나머지가 0 이 아닌 경우 card_result값을 returnValue에 저장하여 반환 
			returnValue=card_result%13;
			
			return returnValue;
			
		}else if(card_result%13==0){
			//card_result를 13으로 나눴을때 나머지가 0 인 경우 retrunValue에 13을 저장하여 반환
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












