package leetcode;

public class ArabicNumerals {

	private final String[] ChineseNumbers = new String[] { "Áã", "Ò¼", "·¡", "Èþ", "ËÁ", "Îé", "Â½", "Æâ", "°Æ", "¾Á" };
	private final String[] ChineseUnits1 = new String[] { "", "Ê°", "°Û", "Çª" };
	private final String[] ChineseUnits2 = new String[] { "Íò", "ÒÚ" };
	private final String YUAN = "Ôª";
	private final String JIAO = "½Ç";
	private final String FEN = "·Ö";
	private final String ZHENG = "Õû";

	private String convertToChineseNumerals(String ArabicNumerals) {

		if (!checkNumberValid(ArabicNumerals))
			return "";

		String[] intAndDecimals = null;
		if (ArabicNumerals.split("\\.").length == 0)
			intAndDecimals = new String[] { ArabicNumerals };
		else
			intAndDecimals = ArabicNumerals.split("\\.");

		String decimal = null;
		if (intAndDecimals.length == 2) {
			decimal = convertDecimalPart(intAndDecimals[1]);
		} else {
			decimal = YUAN + ZHENG;
		}

		String integer = convertIntPart(intAndDecimals[0]);

		return integer + decimal;
	}

	private String convertIntPart(String integer) {

		int i = 0;
		for (; i < integer.length(); ++i) {
			if (integer.charAt(i) > '0')
				break;
		}

		if (i == integer.length()) // all zero
			return ChineseNumbers[0];

		boolean hasNotZero = false;
		boolean zeroFlag = false;

		char[] intPart = integer.substring(i).toCharArray();
		String ret = new String();

		String unit = "";
		String preUnit = "";
		String tmp = "";
		i = 0;
		int j = intPart.length - 1;
		int unitIdx = 0;
		boolean preZero = false;
		for (; j - 4 >= 0; j -= 4) {
			tmp = "";
			hasNotZero = false;
			zeroFlag = false;
			for (int m = j; m > j - 4; m--) {
				if (intPart[m] == '0') {
					if (hasNotZero)
						zeroFlag = true;
					preZero = true;
				} else {
					preZero = false;
					hasNotZero = true;
					if (zeroFlag) {
						tmp = ChineseNumbers[0] + tmp;
						zeroFlag = false;
					}

					tmp = ChineseNumbers[intPart[m] - '0'] + ChineseUnits1[j - m] + tmp;
				}
			}

			if (preZero) {
				if (tmp.equals("") && hasNotZero)
					ret = tmp + ChineseNumbers[0] + ret;
				else if (hasNotZero)
					ret = tmp + unit + ChineseNumbers[0] + ret;
			} else {
				if (!tmp.equals(""))
					ret = tmp + unit + ret;
			}

			unit = ChineseUnits2[unitIdx % 2] + preUnit;
			System.out.println(unit);
			if (unitIdx % 2 == 1) {
				preUnit = unit;
			}
			unitIdx++;
			++i;
		}

		if (j >= 0) {
			i = 0;
			tmp = "";
			hasNotZero = false;
			if (zeroFlag) {
				unit = unit + ChineseNumbers[0];
				zeroFlag = false;
			}
			for (; j >= 0; --j) {
				if (intPart[j] == '0') {
					if (hasNotZero)
						zeroFlag = true;
				} else {
					hasNotZero = true;
					if (zeroFlag) {
						tmp = ChineseNumbers[0] + tmp;
						zeroFlag = false;
					}
					tmp = ChineseNumbers[intPart[j] - '0'] + ChineseUnits1[i] + tmp;
				}
				i++;
			}
			ret = tmp + unit + ret;
		}

		return ret;
	}

	private String convertDecimalPart(String decimal) {

		String ret = new String();
		char[] chDecimal = decimal.toCharArray();

		if (chDecimal[0] == '0' && chDecimal[1] == '0') {
			ret = ZHENG;
		} else if (chDecimal[0] == '0') {
			ret = ChineseNumbers[0] + ChineseNumbers[chDecimal[1] - '0'] + FEN;
		} else if (chDecimal[1] == '0') {
			ret = ChineseNumbers[chDecimal[0] - '0'] + JIAO;
		} else {
			ret = ChineseNumbers[chDecimal[0] - '0'] + JIAO + ChineseNumbers[chDecimal[1] - '0'] + FEN;
		}

		ret = YUAN + ret;

		return ret;
	}

	private boolean checkNumberValid(String ArabicNumerals) {

		if (ArabicNumerals == null || ArabicNumerals.equals(""))
			return false;

		int dotCount = 0;
		for (char ch : ArabicNumerals.toCharArray()) {
			if (((ch < '0' || ch > '9') && ch != '.') || dotCount > 1)
				return false;

			if (ch == '.')
				dotCount++;
		}
		return true;
	}

	public static void main(String[] args) {

		ArabicNumerals rnToC = new ArabicNumerals();

		String ChineseNumerals = null;

		String[] amt = new String[] {
				/*
				 * "0", "8", "10", "12", "99", "100", "102", "1000", "1023",
				 * "1203", "2129", "2220", "2300", "3001", "9999", "10000",
				 */ "10202", "10002", "30200", "301000", "3029128", "30200230", "890100000200.21", "89012300000101010101010059801.32",
				"10280201923210203.09" };

		for (String s : amt) {
			ChineseNumerals = rnToC.convertToChineseNumerals(s);
			System.out.println(s + " ==> " + ChineseNumerals);
		}
	}
}
