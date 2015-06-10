
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


/**
 * Creates various collections
 * @author gunboat
 *
 */
public class Collection {

	/**
	 * runs the other methods from this class
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Collection tester = new Collection();
		tester.shuffleCards();
		tester.reverseMap();
		
	}
	
	/**
	 * creates a map of states (state code/state name)
	 */
	public Map<String, String> mapping(){
		Map<String, String> states = new TreeMap<String, String>();
		states.put("AL", "Alabama");
		states.put("AZ", "Arizona");
		states.put("AR", "Arkansas");
		states.put("CA", "California");
		states.put("CO", "Colorado"); 
		states.put("CT", "Connecticut");
		
		return states;
	}
	
	/**
	 * orders and then reverses the order of the map
	 */
	public void reverseMap(){
	TreeMap<String, String> orderedStates = new TreeMap<String, String>();
	Set<String> keys = mapping().keySet();
	for(String s : keys){
		orderedStates.put(s, mapping().get(s));
	}
	System.out.println(orderedStates);
	NavigableMap<String, String> reversedStates = orderedStates.descendingMap();
	System.out.println(reversedStates);
	}
	
	
	/**
	 * creates a list of cards
	 * @return the list of cards
	 */
	public List listCards(){
		List <String> cards = new ArrayList<String>();
		cards.add("Jack of Diamonds");
		cards.add("Ace of Spades");
		cards.add("Nine of Clubs");
		cards.add("Eight of Hearts");
		cards.add("Queen of spades");
		
		return cards; 
	}

	/**
	 * shuffles the cards
	 */
	public void shuffleCards(){
		List <String> cards = new ArrayList<String>();
		for(Object o: listCards()){
			cards.add((String)o); 
		}
		System.out.println(cards);
		Collections.shuffle(cards);
		System.out.println(cards);
	}

	
}
