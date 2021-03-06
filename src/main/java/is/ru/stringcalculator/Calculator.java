package is.ru.stringcalculator;
import java.util.*;
import java.lang.IllegalArgumentException;

public class Calculator {

	public static int add(String text){
		if(text.contains("//") && text.contains("\n")){
			return sum(newDelimiter(text));
		}
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split(",|\n");
	}
      
	private static int sum(String[] numbers){
		int total = 0;
		List<Integer> negativeList = new ArrayList<Integer>();
		int n;
		for(String number : numbers){
			n = toInt(number);
			if(n < 0){
				negativeList.add(n);
			}
			else{
				total += n;
			}
		}
		if(!negativeList.isEmpty()){
			throwException(negativeList);
		}
		return total;
	}
	private static String[] newDelimiter(String text){
		String[] delimiter = text.split("//|\n");
		return delimiter[2].split(delimiter[1]);
	}

	private static void throwException(List<Integer> negativeList){
		String negatives = "Negatives not allowed: ";
		for(int negative : negativeList){
			negatives += negative + ", ";
		}
		throw new IllegalArgumentException(negatives);
	}
}