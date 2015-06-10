
/**
 * Counts in different ways using loops
 * @author gunboat
 *
 */
public class Loops {

	/**
	 * runs the looping methods
	 * 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Loops tester = new Loops();
		tester.displayingWhile();
		tester.reverseDisplaying();
		tester.skippingOdds();
	}

	/**
	 * counts from 1-10 using a while loop
	 */
	public void displayingWhile(){
		int i = 1;
		while(i < 11){
			System.out.println(i);
			i++;
		}
		System.out.println();
	}
	
	/**
	 * counts from 10-1 using a for loop
	 */
	public void reverseDisplaying(){
		for(int i = 10; i > 0; i--){
			System.out.println(i);
		}
		System.out.println();
	}
	
	/**
	 * Counts from 1-20 skipping odd numbers using a for loop
	 */
	public void skippingOdds(){
		for(int i = 1; i < 21; i++){
			if(i%2 == 0){
				System.out.println(i);
			}
		}
		System.out.println();
	}
	
}
