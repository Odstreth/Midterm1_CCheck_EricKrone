import java.util.Scanner;


public class CheckDigit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a credit card number as a long integer: ");
		long value = input.nextLong();
		boolean valid = false;
		Long valueInt = value;
		String valueString = valueInt.toString();
		String output = "";
		for (int i = 3; i>=0; i--){
    		output += valueString.charAt(valueString.length() -1 - i);
    	}
        if (validateType(valueString) && checkByDigit(valueString)){
        	System.out.println("*" + output + "is valid");
        	
        }
        else{
        	System.out.println("*" + output + " is invalid");
        }
	}
	
	public static boolean validateType(String number){
		int first = number.charAt(0)-48;
		boolean validLength = false;
		if (number.length() >= 13 && number.length() <=16){
			validLength = true;
		}
		boolean valid = false;
		switch(first){
		case 4: valid = true;
		break;
		case 5: valid = true;
		break;
		case 6: valid = true;
		break;
		case 3: if (number.charAt(1)-48 == 7){
			valid = true;
		}
		}
		return valid && validLength;
		
	}
	
	public static boolean checkByDigit(String number){
		int sum = 0;
		//double every second digit from right to left
		for (int i = number.length()-2; i >= 0; i = i-2){
			int value = 2*(number.charAt(i) - 48);
			if (value > 9){
				sum += doubleSum(value);
			}
			else{
				sum += value;
			}
		}
		//double digits in the odd places
		for (int i = number.length()-1; i>=0; i = i-2){
			int value = number.charAt(i) - 48;
			sum += value;
		}
		
		return sum % 10 == 0;
	}
	
	public static int doubleSum(int number){
		//number is 18 at most
		int sum = 0;
		//get the one position
		sum += number - 10;
		//the ten position is always 1
		sum += 1;
		return sum;
	}
	
}
