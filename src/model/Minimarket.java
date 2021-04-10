package model;

import exceptions.*;
import java.util.ArrayList;

public class Minimarket {
    
    private ArrayList<Client> clients = new ArrayList<>();
    private int tryIn = 0;

    public boolean registerClient(String doc, long docInt, int day) {
        tryIn++;
        try {
            if (doc.equalsIgnoreCase("TI")) {
                throw new ExceptionDocument(doc);
            }
            if (!validateDoc(docInt, day)) {
            	throw new ExceptionGoberment(docInt, day);
            }
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
        return clients.add(new Client(doc, docInt));
    }

    public boolean validateDoc(long docInt, int day) throws ExceptionGoberment {
        String temp = String.valueOf(docInt);
        char temp1 = temp.charAt(temp.length() - 2);
        int temp2 = Character.getNumericValue(temp1);
        if (temp2 % 2 == 0 && day % 2 != 0 || temp2 % 2 != 0 && day % 2 == 0) {
            return true;
        } else if (temp2 % 2 == 0 && day % 2 == 0 || temp2 % 2 != 0 && day % 2 != 0) {
            return false;
        } else {
        	return false;
        }
    }
    
    public int getTryIn() {
    	return tryIn;
    }
    
    public int getClientsSize() {
    	return clients.size();
    }
}
