package leetcode;

/*
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 
 * For example,
 * 
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * Credits:
 * Special thanks to @Shangrila for adding this problem and creating all test cases.
 */

public class FractionToRecurringDecimal {
	
    public static String fractionToDecimal(int numerator, int denominator) {
    	
    	String ret = "";
    	ret += numerator / denominator;
    	
    	int remainder = numerator % denominator;
    	if (remainder != 0)
    		ret += ".";
    	
    	int rd = 0;
    	int lastRemainder = 0;
    	String tmp = "";
    	String lastTmp = "";
    	while (remainder != 0) {
    		remainder *= 10;
    		if (remainder >= denominator) {
    			if (lastRemainder == remainder) {
    				ret += "(" + tmp + rd + ")";
    				break;
    			}
    			
	    		if (remainder % denominator == 0) {
	    			rd = remainder / denominator;
	    			ret += tmp + rd;
	    			break;
	    		}
	    		if (rd != 0) {
	    			ret += lastTmp + rd;
	    			tmp = "";
	    		}
	    		rd = remainder / denominator;
	    		lastRemainder = remainder;
	    		remainder = remainder % denominator;
	    		lastTmp = tmp;
    		} else {
    			tmp += "0";
    		}
    	}
    	
		return ret;
    }

	public static void main(String[] args) {
//		System.out.println(fractionToDecimal(1, 2));
//		System.out.println(fractionToDecimal(1, 3));
//		System.out.println(fractionToDecimal(1, 10));
//		System.out.println(fractionToDecimal(1, 100));
		System.out.println(fractionToDecimal(1, 123));
		System.out.println(fractionToDecimal(1, 99));
	}
}
