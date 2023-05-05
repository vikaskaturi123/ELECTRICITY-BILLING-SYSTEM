package com.electricitybillingsystem.entity;

public class BillCalculation {
	
	public static int BillAmount(int units) {
        
        int billToPay = 0;
        if (units < 100) {
            billToPay = units * 1;
        }
        // check whether the units are less than 300
        else if (units < 300) {
            billToPay = 100 * 10 + (units - 100) * 20;
        }
        // check whether the units are greater than 300
        else if (units > 300) {
            billToPay = 100 * 10 + 200 * 20 + (units - 300) * 32;
        }
        System.out.println("The electricity bill for " + units + " is : " + billToPay);
        
        return billToPay;

    }

}
