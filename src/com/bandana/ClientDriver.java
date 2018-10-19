package com.bandana;

import java.awt.EventQueue;

import com.bandana.controller.PurchaseInventoryController;
import com.bandana.views.PurchaseInventoryView;

public class ClientDriver {

	public static void main(String[] args) {
       EventQueue.invokeLater(new Runnable() {
    	   public void run() {
    		   new PurchaseInventoryView(
    				   new PurchaseInventoryController()
    				   );
    	   }
       });

	}

}
