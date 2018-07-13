package permutations;

public class permutationsofaString {

	public static void swap(StringBuffer stringtoswap,int sp1,int sp2){
		
		String temp;
		String temp2;
		
		temp=Character.toString(stringtoswap.charAt(sp1));
		temp2=Character.toString(stringtoswap.charAt(sp2));
		stringtoswap.replace(sp2, sp2+1, temp);
		stringtoswap.replace(sp1, sp1+1, temp2);
		return;
	}
	public static void permutations(StringBuffer test1,int start, int length){
	
		if(start == length){
			System.out.println(test1);
			return;
		}
		for(int i=start;i<length;i++){
			swap(test1,start,i);
			permutations(test1,start+1,length);
			swap(test1,i,start);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer test=new StringBuffer("abac");
		//test ="abc"
		int start=0;
		permutations(test,start, test.length());
	}

}
