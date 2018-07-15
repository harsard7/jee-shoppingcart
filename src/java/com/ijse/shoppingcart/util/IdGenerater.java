/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.shoppingcart.util;

import com.ijse.shoppingcart.CONSTANTS.CONSTANTSTYPE;
import java.util.UUID;

/**
 *
 * @author Hafees
 */
public class IdGenerater {
    private static String id;
    
    private static String getId(CONSTANTSTYPE constantstype){
        switch(constantstype){
            case CUSTOMER:id="CS"; break;
            case ITEM:id="IM"; break;
            case CATEGORY:id="CT"; break;
            case ORDERS:id="OD"; break;
             default:id="NIL";         
        }
    return id;
    }
    
    public static String generateUUID(CONSTANTSTYPE constantstype) {
		UUID uuidOne = UUID.randomUUID();
		long keyValues = uuidOne.getMostSignificantBits();
            String key = Long.toString(keyValues).substring(1, 5);
        String id = getId(constantstype);
		return id+key;
	}
    
}
