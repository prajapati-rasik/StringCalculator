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
            int startIndex = 2; //start index of delimiter
            int endIndex = 3; //end index of delimiter
            if(numberString.charAt(2) == '['){
                startIndex = 3;
                for(int i = 3;i < numberString.length();i++){
                    if(numberString.charAt(i) == ']'){
                        endIndex = i;
                        break;
                    }
                }
            }
            String delimiter = numberString.substring(startIndex, endIndex);
            //for excluding '\n'
            if(endIndex != 3) endIndex += 1;
            String number = numberString.substring(endIndex + 1);
            //for escaping meta characterd
            number = number.replaceAll("\\"+delimiter.substring(0,1), "ff");
            delimiter = delimiter.replaceAll("\\"+delimiter.substring(0,1), "ff");
            return number.split(delimiter);
        }
        return numberString.split(delimiters);
    }
    
    private int getsum(String[] numbers) throws Exception{
        checkForNegatives(numbers);
        int sum = 0;
        for(String number : numbers){
            if(convertStringToInt(number) <= 1000)
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
