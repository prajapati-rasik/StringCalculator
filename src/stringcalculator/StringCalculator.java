package stringcalculator;

import java.util.regex.Pattern;

/**
 *
 * @author 18bce184 Rasik Prajapati
 */
public class StringCalculator {
    
    private final String delimiters = ",|\n";
    
    public int add(String numberString){
        String[] numbers = splitString(numberString);
        if(numberString.isEmpty()){
            return 0;
        }else if(numberString.length() == 1){
            return convertStringToInt(numberString);
        }else{
            return getsum(numbers);
        }
    }
    
    private String[] splitString(String numberString){
        if(numberString.startsWith("//")){
            String delimiter = numberString.substring(2, 3);
            String number = numberString.substring(4);
            return number.split(delimiter);
        }
        return numberString.split(delimiters);
    }
    
    private int getsum(String[] numbers){
        int sum = 0;
        for(String number : numbers){
            sum += convertStringToInt(number);
        }
        return sum;
    }
    
    private int convertStringToInt(String number){
        return Integer.parseInt(number);
    }
}
