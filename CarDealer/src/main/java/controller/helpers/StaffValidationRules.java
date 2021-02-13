/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helpers;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author Tomas
 */
public class StaffValidationRules {
    public StaffValidationRules() {
    }
    
    public Boolean valid_fullname(String name){
        if(name!= null && name.split(" ").length == 2)
        {
            String[] temp = name.split(" ");
            if(temp[0].length() > 3 || temp[0].length() > 3 )
                return temp[0].chars().allMatch(Character::isLetter) && temp[1].chars().allMatch(Character::isLetter) ;
        }
        return false;
    }
    
    public Boolean valid_phoneFax (String phoneFax){
        
        if(phoneFax.split(" ").length == 2){
            String[] temp = phoneFax.split(" ");
            if(temp[0].matches("[0-9]+") && temp[0].length() == 3)
                if(temp[1].matches("[0-9]+") && temp[1].length() > 6)
                    return true; 
        }
            
        if(phoneFax.matches("[0-9]+") && phoneFax.length() > 9) 
            return true;
            
        return false;
    }
       
    public Boolean valid_email(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
    
    public Boolean valid_password(String password){
        
        return  password != null && password.matches("^[a-zA-Z0-9]*$") && password.length() > 5;
        
    }
}
