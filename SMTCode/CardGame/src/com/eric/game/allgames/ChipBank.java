 /****************************************************************************
 * <b>Title</b>: ChipBank.java <p/>
 * <b>Project</b>: 21 Game <p/>
 * <b>Description: </b> Bank of Chips
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2015<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author Eric Masinter
 * @version 2.0
 * @since Jun 16, 2015<p/>
 * @updates:
 ****************************************************************************/
package com.eric.game.allgames;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.eric.game.interfaces.Bank;
import com.eric.game.valueobjects.Chip;

/**
 * @author gunboat
 *
 */
public class ChipBank implements Bank{
	Map<Double, Chip> chips;
	private static Logger log = Logger.getLogger(Table.class);
	
	
	public ChipBank(HashMap<Double, Chip> chips){
		this.chips = chips;
	}

	@Override
	public void betMoney(int amt, Chip chip) {
		// TODO Auto-generated method stub
		if( amt <= (chips.get(chip.getChipValue())).getNumChips()){
			int i = (chips.get(chip.getChipValue())).getNumChips() - amt;
			(chips.get(chip.getChipValue())).setNumChips(i);
			//System.out.println(chip);
			
		}
		
		else{
			System.out.println("You don't have that many chips, please bet again, your old bet has been refunded");
		}
		
		
	}

	@Override
	public void addMoney(int amt, Chip chip) {
		// TODO Auto-generated method stub
		(chips.get(chip.getChipValue())).setNumChips(amt);
			}
	
}
