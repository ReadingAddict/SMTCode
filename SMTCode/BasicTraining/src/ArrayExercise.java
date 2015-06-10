import java.util.Random;


/**
 * Creates an Array of random integers
 * @author gunboat
 *
 */
public class ArrayExercise {
	
	/**
	 * Calls the createArray method
	 * @param args
	 */
	public static void main(String[] args){
		//TODO auto generated method stub
		ArrayExercise ca = new ArrayExercise();
		ca.createArray();
	}
	
	/**
	 * Creates an array of ten random integers and then prints them
	 */
	public void createArray(){
		int [] arrayInts = new int[10];
		
		for(int i = 0; i < arrayInts.length; i++){
			arrayInts[i] = Math.abs(new Random().nextInt()) + 1;
		}
		
		for(int n = 0; n < arrayInts.length; n++){
			System.out.println(n + " : " + arrayInts[n]);
		}
	}
}
