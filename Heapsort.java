import java.util.Scanner;
import java.util.ArrayList;

public class Heapsort {
	public static void main(String[] args){
		Scanner inputScanner = new Scanner(System.in);
		ArrayList myAlist = new ArrayList(1);
		while (inputScanner.hasNextInt()){
			myAlist.add(new Integer(inputScanner.nextInt()));			
		}
		if(inputScanner!=null)
			inputScanner.close();
				
		PQHeap myHeap = new PQHeap(myAlist.size());
		
		for (int i=0; i<=myAlist.size()-1; i++ ){
			Element myElement = new Element(((Integer)myAlist.get(i)).intValue(), null);
			myHeap.insert(myElement);
		}
		
		while (myHeap.HeapSize > 0){
			Element out = myHeap.extractMin();
			System.out.println(out.key);
		}
	}

}
