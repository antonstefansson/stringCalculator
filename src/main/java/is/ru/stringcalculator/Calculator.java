package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.contains("//") && text.contains("\n")){
			String[] delimiter = text.split("//|\n");
			String[] numbers = delimiter[2].split(delimiter[1]);
			return sum(numbers);
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
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}