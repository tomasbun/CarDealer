/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helpers;

/**
 *
 * @author Tomas
 */
public class CarValidationRules {

    public CarValidationRules() {
    }
    
    public Boolean valid_price(String price){
        return price.matches("[0-9]+");
    }
    
    public Boolean valid_color (String color){
       return  color.chars().allMatch(Character::isLetter);
    }
    
    public Boolean valid_odometer (String odometer){
       return  odometer.matches("[0-9]+");
    }
           
    public Boolean valid_tax(String tax) {
        return tax.matches("[0-9]+");
    }
    
    public Boolean valid_description(String description){
        
        if(description.matches("^[a-zA-Z0-9]*$"))
            return true;
        
        if(description.contains("script>"))
            return false;
        
         if(description.contains("<") || description.contains(">"))
             return false;
         
        return  true;
        
    }
    
    public Boolean valid_note(String note){
        
        if(note.matches("^[a-zA-Z0-9]*$"))
            return true;
        
        if(note.contains("script>"))
            return false;
        
         if(note.contains("<") || note.contains(">"))
             return false;
         
        return  true;
        
    }
}
