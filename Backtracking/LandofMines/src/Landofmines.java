import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

/*///////////////////////////////////
input should be of this type
...S..
.B...B
...D..
......


S==>start point
B=bomb
D=destination
/////////////////////////////////////*/
public class Landofmines {

	private StringBuffer[] land;
	
	private class point{
		private int x;
		private int y;
		
		public point(int x,int y){
			this.x=x;
			this.y=y;
		}
		
		public int getx(){
			return x;
		}

		public int gety(){
			return y;
		}
	}
	static final int maxinteger=12899;//just to denote max
	private void initialize(){
		Scanner in=new Scanner(System.in);
		
		
		for(int i=0;i<land.length;i++){
			String test; 
			land[i]=new StringBuffer();
			System.out.println("enter the "+ i + "th string careful on number of characters");
			test=in.nextLine();
			land[i].append(test);
		}
		
		in.close();
	}

	public Landofmines(int rows){
		land=new StringBuffer[rows];
		initialize();
	}
	
	private boolean issafe(int row,int col){
		boolean canadd=false;
		
		while(true){
		    if(row<0 || row >= land.length || col<0 || col >= land.length){
		    	break;
		    }
		    if(land[row].charAt(col)== 'B'){
		    	break;
		    }
		    canadd=true;
		    break;
		}
		return canadd;
	}
	private int SolveLandofMinesUtil(int rowcurr,int currcol,int xmove[],int ymove[],int temp[][]){
		
		int nextrow;
		int nextcol;
		//int returnvalue=maxinteger;
		int level=0;
		int returnx=-1;
		int returny=-1;
		boolean insertdummy=false;
		Queue<point> myqueue=new LinkedList<>();
		point currentpoint;
		point dummy=new point(maxinteger,maxinteger);
		
		myqueue.add(new point(rowcurr,currcol));
		myqueue.add(dummy);
		while(!myqueue.isEmpty()){
			
			currentpoint=myqueue.peek();
			myqueue.remove();
			
			if(currentpoint.getx() == maxinteger && currentpoint.gety() ==maxinteger){
				level=level+1;
				insertdummy=true;
				continue;
			}
			
			//System.out.println(land[currentpoint.getx()].charAt(currentpoint.gety()));
			if(land[currentpoint.getx()].charAt(currentpoint.gety()) == 'D' ){
				returnx=currentpoint.getx();
				returny=currentpoint.gety();
				continue;
			}
			
			for(int i=0;i<4;i++){
				
				nextrow=currentpoint.getx() + xmove[i];
				nextcol=currentpoint.gety() + ymove[i];
				
				if(issafe(nextrow,nextcol)){
					if(insertdummy){
						myqueue.add(new point(maxinteger,maxinteger));
						insertdummy=false;
					}
					if(temp[nextrow][nextcol]>level+1){
						if(temp[nextrow][nextcol] == maxinteger){
							myqueue.add(new point(nextrow,nextcol));
						}
						
						temp[nextrow][nextcol] = level+1;
					}
					
				}
			}
			
		}
		return temp[returnx][returny];
	
	}
	public void SolveLandofMines(){
		
		int xmove[]= {0,1,0,-1};
		int ymove[]= {1,0,-1,0};
		int temp[][]= new int[land.length][land.length]; 
		int startrow=0;
		int startcol=0;
		
		
		for(int i=0;i<land.length;i++){
			for(int j=0;j<land.length;j++){
				if(land[i].charAt(j) == 'S'){
					startrow=i;
					startcol=j;
					temp[i][j]=0;
					System.out.println(land[i].charAt(j));
					continue;
				}
				temp[i][j]=maxinteger;
			}
		}
		System.out.println( SolveLandofMinesUtil(startrow,startcol,xmove,ymove,temp) );
		
	}
	
}
