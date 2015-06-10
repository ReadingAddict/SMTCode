
/**
 * stores data and prints it
 * @author gunboat
 *
 */
public class DataTypes {

	/**
	 * runs the data fron displayer
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataTypes dt = new DataTypes();
		dt.displayer();
	}

	/**
	 * creates five different data type variables and stores data
	 * then prints the data
	 */
	public void displayer(){
		int i = 1;
		double d = 2.3;
		float f = 7.6F;
		char c = 'a';
		boolean b = false;
		System.out.println(i +", " + d + ", " + f + ", " + c + ", " + b);
	}
	
}
