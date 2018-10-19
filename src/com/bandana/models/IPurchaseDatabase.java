package com.bandana.models;

import java.util.List;

/***
 * Provides access to a Purchase DataStore 
 */
public interface IPurchaseDatabase {
	
	/**
	 * Saves a purchase to a data store
	 * @return whether the store operation was successful
	 * */
	boolean store(Purchase purchase);
	
	/**
	 * Retrieves all purchases from the data store
	 * @return {@link java.util.List} of purchases
	 * */
	List<Purchase> retrieveAll();
	
	/**
	 * Returns last automatically generated id from data store
	 * */
	int getLastInsertId();

}
