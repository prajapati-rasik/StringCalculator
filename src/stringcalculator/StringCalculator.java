package stringcalculator;

import java.util.regex.Pattern;

/**
 *
 * @author 18bce184 Rasik Prajapati
 */
public class StringCalculator {
    
    private final String delimiters = ",|\n";
    private int callCount = 0;
    
    public int add(String numberString) throws Exception{
        callCount += 1;
        String[] numbers = splitString(numberString);
        if(numberString.isEmpty()){
            return 0;
        }else if(numberString.length() == 1){
            return convertStringToInt(numberString);
        }else{
            return getsum(numbers);
        }
    }
    
    public int getCalledCount(){
        return callCount;
    }
    
    private String[] splitString(String numberString){
        if(numberString.startsWith("//")){
            String delimiter = numberString.substring(2, 3);
            String number = numberString.substring(4);
            return number.split(delimiter);
        }
        return numberString.split(delimiters);
    }
    
    private int getsum(String[] numbers) throws Exception{
        checkForNegatives(numbers);
        int sum = 0;
        for(String number : numbers){
            sum += convertStringToInt(number);
        }
        return sum;
    }
    
    private void checkForNegatives(String[] numbers) throws Exception {
        String message = "";
        for(String number : numbers){
            int value = convertStringToInt(number);
            if(value < 0){
                message += (" "+value);
            }
        }
        if(!message.isEmpty()){
            throw new Exception("Negatives not allowed :" + message);
        }
    }
    
    private int convertStringToInt(String number){
        return Integer.parseInt(number);
    }
}
