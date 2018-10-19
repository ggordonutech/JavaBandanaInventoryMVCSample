package com.bandana.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.bandana.controller.PurchaseInventoryController;
import com.bandana.models.Purchase;

public class PurchaseInventoryView 
    extends JFrame 
    implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private PurchaseInventoryController controller;
	private JButton btnPurchase;
	private JButton btnClear;
	private JTextArea txtReporting;
	private JTextField txtCustomer;
	private JTextField txtQuantity;
	private JComboBox<String> ddlType;
	
	private static final String tableHeader= 
			String.format("%2s | %10s | %10s | %10s | %5s",
					"Id","Customer","Quantity","Type","Cost");
	
	public PurchaseInventoryView(
			PurchaseInventoryController controller
			) {
		this.controller = controller;
		initView();
		configureListeners();
	}
	
	private void initView() {

		setLayout(new BorderLayout());
		JPanel pnlTop = new JPanel(new GridLayout(1,2));
		pnlTop.add(new JLabel("Customer:"));
		pnlTop.add(new JLabel("Reporting"));
		this.add(pnlTop,BorderLayout.NORTH);
		
		JPanel pnlCenter = new JPanel(new GridLayout(1,2));
		JPanel pnlCenterLeft = new JPanel(new GridLayout(5,1));
		pnlCenterLeft.add(txtCustomer = new JTextField());
		pnlCenterLeft.add(new JLabel("Quantity:"));
		pnlCenterLeft.add(txtQuantity = new JTextField());
		pnlCenterLeft.add(new JLabel("Type:"));
		pnlCenterLeft.add(ddlType = new JComboBox<String>( 
				new String[] {"Floral","Army"}
				));
		pnlCenter.add(pnlCenterLeft);
		JScrollPane scrollPaneReporting = new JScrollPane( 
				txtReporting = new JTextArea(tableHeader)
				);
		pnlCenter.add(scrollPaneReporting);
		this.add(pnlCenter,BorderLayout.CENTER);
		
		JPanel pnlFooter = new JPanel(new GridLayout(1,2));
		pnlFooter.add(btnPurchase = new JButton("Purchase"));
		pnlFooter.add(btnClear = new JButton("Clear"));
		this.add(pnlFooter,BorderLayout.SOUTH);
		
		setTitle("Bandana Inventory");
		setSize(400,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	private void configureListeners() {
		btnPurchase.addActionListener(this);
		btnClear.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(btnClear)) {
			txtCustomer.setText("");
			txtQuantity.setText("");
			txtReporting.setText(tableHeader);
		}
		if(event.getSource().equals(btnPurchase)) {
			try {
				int quantity = Integer.parseInt(txtQuantity.getText());
				Purchase itemPurchase = new Purchase();
				itemPurchase.setCustomerName(txtCustomer.getText());
				itemPurchase.setType((String)ddlType.getSelectedItem());
				itemPurchase.setQuantity(quantity);
				itemPurchase = controller.storePurchase(itemPurchase);
				if(itemPurchase == null) {
					JOptionPane.showMessageDialog(
							this, 
							"We were unable to save this purchase at this time, please try again",
							"Purchase Inventory Message",
							JOptionPane.ERROR_MESSAGE
							);
				}else {
					txtReporting.append(
							String.format("%2d | %10s | %10d | %10s | %2.2f", 
									itemPurchase.getId(),
									itemPurchase.getCustomerName(),
									itemPurchase.getQuantity(),
									itemPurchase.getType(),
									itemPurchase.getCost()
									));
				}
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(
						this, 
						"Please enter a valid whole number for quantity",
						"Purchase Inventory Message",
						JOptionPane.ERROR_MESSAGE
						);
			}
		}		
	}
}
