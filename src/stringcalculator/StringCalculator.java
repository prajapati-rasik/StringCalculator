package stringcalculator;

/**
 *
 * @author 18bce184 Rasik Prajapati
 */
public class StringCalculator {
    
    public int add(String numberString){
        String[] numbers = numberString.split(",");
        if(numberString.isEmpty()){
            return 0;
        }else if(numberString.length() == 1){
            return convertStringToInt(numberString);
        }else{
            return convertStringToInt(numbers[0]) + convertStringToInt(numbers[1]);
        }
    }
    
    private int convertStringToInt(String number){
        return Integer.parseInt(number);
    }
}
