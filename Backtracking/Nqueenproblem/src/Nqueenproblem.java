
public class Nqueenproblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nqueen chessboard=new Nqueen(8,8);
		if(chessboard.solveNqueen(0,0)){
			chessboard.print();
		}
		else{
			System.out.println("Not possible");
		}
		
		System.out.println("=========================");
		Nqueen chessboard2=new Nqueen(16,16);
		if(chessboard2.solveNqueen(0,0)){
			chessboard2.print();
		}
		else{
			System.out.println("Not possible");
		}
		
		System.out.println("=========================");
		Nqueen chessboard3=new Nqueen(32,32);
		if(chessboard3.solveNqueen(0,0)){
			chessboard3.print();
		}
		else{
			System.out.println("Not possible");
		}
	}

}
