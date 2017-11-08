import java.util.*;
/*
Author: Anthony Perez
Date: 04-19-2016
*/
public class TaxMan
{
	public TaxMan()
	{
	}
 
	public static void main(String [] args) throws Exception
	{
		TaxMan taxMan = new TaxMan();
 
		// get purchase
		Vector<PurchaseItem> basket = taxMan.getPurchase();
		//System.out.println(basket);
 
		// print reciept
		taxMan.printReciept(basket);
 
	}
	
	public void printReciept(Vector<PurchaseItem> basket) throws Exception
	{
		float totPrice = 0.0f;
		float totTax = 0.0f;
 
		for(int i=0; i<basket.size(); i++)
		{
			PurchaseItem purchaseItem = basket.get(i);
 
			totPrice += purchaseItem.price;
			totTax += purchaseItem.tax;
			System.out.println(purchaseItem);
		}
 
		// round tax to near $0.05
		float reminder = totTax % 0.05f;
		if( reminder != 0.0f )
		{
			if( reminder > 0.025f ) // round up
				totTax -= reminder;
			else // round up
				totTax += (0.05f - reminder);
		}
 
		System.out.println("Sales Taxes: $"+totTax);
		System.out.println("Total: $"+(totPrice+totTax));
	}
 
	public Vector<PurchaseItem> getPurchase() throws Exception
	{
		// for getting keyboard input
		Scanner keyboard = new Scanner(System.in);
		String userInput = null;
 
		Vector<PurchaseItem> basket = new Vector<PurchaseItem>();
 
		int no = 1;
		while(true)
		{
			PurchaseItem purchaseItem = new PurchaseItem();
 
			System.out.print("Item"+no+" Qty: ");
			userInput = keyboard.nextLine();
			purchaseItem.qty = Integer.parseInt(userInput);
 
			System.out.print("Item"+no+" Name: ");
			userInput = keyboard.nextLine();
			purchaseItem.name = userInput;
 
			System.out.print("Item"+no+" Price: $");
			userInput = keyboard.nextLine();
			purchaseItem.price = Float.parseFloat(userInput);
 
			System.out.print("Item"+no+" Imported[y/n]: ");
			userInput = keyboard.nextLine();
			if(userInput.toLowerCase().equals("y"))
				purchaseItem.imported = true;
 
			System.out.print("Item"+no+" Exempted[y/n]: ");
			userInput = keyboard.nextLine();
			if(userInput.toLowerCase().equals("y"))
				purchaseItem.exempted = true;
 
			// compute tax
			purchaseItem.computeTax();
			
			// add to basket
			basket.add(purchaseItem);
			no++;
			
			System.out.print("More Item[y/n]: ");
			userInput = keyboard.nextLine();
			if(userInput.toLowerCase().equals("n"))
				break;
		}
		return basket;
	}
}
 
class PurchaseItem
{
	int qty = 0;
	String name = null;
	float price = 0.0f;
	boolean imported = false; // 10%
	boolean exempted = false; // 5%
 
	float tax = 0.0f;
	
	public String toString()
	{
		return qty+" "+name+" at $"+price+" (imported:"+imported+" exempted:"+exempted+")";
	}
	
	void computeTax()
	{
		float totTaxPercent = 0.0f;
 
		// check tax
		if(imported)
			totTaxPercent = 0.1f;
		if(!exempted)
			totTaxPercent += 0.05f;
 
		// compute tax
		tax = totTaxPercent * price;
	}
}
