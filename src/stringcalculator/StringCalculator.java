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
            return getsum(numbers);
        }
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
