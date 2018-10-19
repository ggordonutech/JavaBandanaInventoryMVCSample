package com.bandana.models;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryPurchaseDatabase 
    implements IPurchaseDatabase
{
	/**
	 * Stores all purchases
	 * */
	private static Map<Integer,Purchase> purchases;
	
	/**
	 * Stores last generated id
	 * */
	private static int nextId = 0;
	
	/**
	 * Ensures that only one instance of purchases is used,
	 * initializes purchases Map/Dictionary if this is first time use
	 * */
	private static Map<Integer,Purchase> getInstance(){
		if(purchases == null) {
			purchases = new HashMap<Integer,Purchase>();
		}
		return purchases;
	}
	

	
	@Override
	public boolean store(Purchase purchase) {
		purchase.setId(++nextId);
		getInstance().put(nextId, purchase);
	    return true;
	}

	@Override
	public List<Purchase> retrieveAll() {
		List<Purchase> purchases = 
				new ArrayList<Purchase>();
	    for( Purchase purchase :  getInstance().values())
	    {
	    	purchases.add(purchase);
	    }
		return purchases;
	}
	
	@Override
	public int getLastInsertId() {
		return nextId;
		
	}

}
