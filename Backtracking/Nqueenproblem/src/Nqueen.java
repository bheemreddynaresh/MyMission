
public class Nqueen {
	private int chessboardsize;
	private int Nofqueens;
	private Integer chessboard[][];
	
	public Nqueen(int size,int queens){
		chessboardsize=size;
		Nofqueens=queens;
		chessboard =new Integer[chessboardsize][chessboardsize];
		for(int i=0;i<chessboardsize;i++){
			for(int j=0;j<chessboardsize;j++){
				chessboard[i][j]=0;
			}
		}
	}
	
	private boolean isattacking(int checkrow,int checkcol){
		
		boolean result=true;
		int row=checkrow;
		int col=checkcol;
		
		for(int i=0;i<chessboardsize;i++){
			//horizontal check
			if(chessboard[row][i]== 1){
				result=false;
				break;
			}
			
			//vertical check
			if(chessboard[i][col]== 1){
				result=false;
				break;
			}
		}
		
		if(result){
			
			//arrow downwards
			for(int i=row;i<chessboardsize && col<chessboardsize;i++,col++){
				
				if(chessboard[i][col] ==1){
					return false;
				}
			}
			
			row=checkrow;
			col=checkcol;
			//arrow upwards
			for(int i=row;i>=0 && col>=0 ;i--,col--){
				if(chessboard[i][col] ==1){
					return false;
				}
			}
			
			row=checkrow;
			col=checkcol;
			//arrow upwards left side
			for(int i=col;i<chessboardsize && row>=0 ;i++,row--){
				
				if(chessboard[row][i] ==1){
					return false;
				}
			}
			row=checkrow;
			col=checkcol;
			//arrow downwards left
			for(int i=col; i>=0 && row<chessboardsize ;i--,row++){
				
				if(chessboard[row][i] ==1){
					return false;
				}
			}
		}
		return result;
	}
	private boolean solvenqueenutil(int row,int col){
		boolean val=false;
		
		if(col >=Nofqueens){
			val=true;
			
		}
		else{
			for(int i=0;i<chessboardsize;i++){
				if(isattacking(row+i,col)){
					chessboard[row+i][col]=1;
					if(!solvenqueenutil(row,col+1)){
						chessboard[row+i][col]=0;
					}
					else{
						val=true;
						break;
					}
				}
			}
		}
		return val;
	}
	public boolean solveNqueen(int... parameters){
		int row=0;
		int col=0;
		return solvenqueenutil(row,col);
	}
	
	public void print(){
		for(int i=0;i<chessboardsize;i++){
			for(int j=0;j<chessboardsize;j++){
				System.out.print(chessboard[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
