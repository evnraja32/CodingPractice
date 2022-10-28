package practice.coding.leetcode;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

/**
 * 
 * @author veelluru
 * @implSpec - https://leetcode.com/problems/integer-to-english-words/
 *
 */
public class IntegerToEnglishWordsTest {

	@Test
	public void allNum() {
		assertEquals(numberToWords(123), "One Hundred Twenty Three");
		assertEquals(numberToWords(12345), "Twelve Thousand Three Hundred Forty Five");
		assertEquals(numberToWords(1234567), "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven");
		assertEquals(numberToWords(2147483647),
				"Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven");
		assertEquals(numberToWords(1), "One");
		assertEquals(numberToWords(1123456789),
				"One Billion One Hundred Twenty Three Million Four Hundred Fifty Six Thousand Seven Hundred Eighty Nine");
		assertEquals(numberToWords(94001), "Ninety Four Thousand One");
		assertEquals(numberToWords(0), "Zero");
		assertEquals(numberToWords(111), "One Hundred Eleven");
		assertEquals(numberToWords(1111), "One Thousand One Hundred Eleven");
		assertEquals(numberToWords(11111), "Eleven Thousand One Hundred Eleven");
		assertEquals(numberToWords(111111), "One Hundred Eleven Thousand One Hundred Eleven");
		assertEquals(numberToWords(9), "Nine");
		assertEquals(numberToWords(99), "Ninety Nine");
		assertEquals(numberToWords(999), "Nine Hundred Ninety Nine");
		assertEquals(numberToWords(9999), "Nine Thousand Nine Hundred Ninety Nine");
		assertEquals(numberToWords(99999), "Ninety Nine Thousand Nine Hundred Ninety Nine");
		assertEquals(numberToWords(999999), "Nine Hundred Ninety Nine Thousand Nine Hundred Ninety Nine");
		assertEquals(numberToWords(1000010), "One Million Ten");
		assertEquals(numberToWords(1000000001), "One Billion One");
	}

	public String numberToWords(int num) {
		
		if (num == 0)
			return "Zero";
		
		StringBuilder sb = new StringBuilder();
		int billion =  (num / 1000000000);
		num = num % 1000000000;
		
		int million =  (num / 1000000);
		num = num % 1000000;
		
		int thousand =  (num / 1000);
		num = num % 1000;
				
		if(billion != 0) {
			sb.append(getPlaces(billion));
            sb.append(" Billion ");
		}
		
		if(million != 0) {
			sb.append(getPlaces(million));
            sb.append(" Million ");
		}
		
		if(thousand != 0) {
			sb.append(getPlaces(thousand));
            sb.append(" Thousand ");
		}
		
		if(num != 0) {
			sb.append(getPlaces(num));
		}
		
		return sb.toString();
	}

	public String getPlaces(int num) {
		StringBuilder sb = new StringBuilder();

		if ((num / 100) != 0) {
			sb.append(get2Digits((num / 100)));
            sb.append(" Hundred ");
			num = num % 100;
		}

		// not a teen number
		if (num != 0 && num > 19) {
			sb.append(get2Digits((num / 10) * 10));
            sb.append(" ");
			num = num % 10;
		}

		if (num != 0) {
			sb.append(get2Digits(num));
		}

		return sb.toString();
	}

	private String get2Digits(int num) {
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            case 20: return "Twenty";
            case 30: return "Thirty";
            case 40: return "Forty";
            case 50: return "Fifty";
            case 60: return "Sixty";
            case 70: return "Seventy";
            case 80: return "Eighty";
            case 90: return "Ninety";
        }
        return null;
    }
	public String getPlaces1(int num) {
		String place = "";

		if (num > 99) {
			place = getOnes(num / 100) + " Hundred " + getPlaces(num % 100);
		} else if (num > 19 && num <= 99) {
			place = getTens(num / 10) + " " + getPlaces(num % 10);
		} else if (num > 10 && num <= 19) {
			place = getTens(num);
		} else {
			place = getOnes(num);
		}

		return place;
	}

	HashMap<Integer, Integer> splitMap = new HashMap<Integer, Integer>();

	public String numberToWords1(int num) {
		String finalString = "";
		if (num == 0)
			return "Zero";
		splitMap = new HashMap<Integer, Integer>();
		splitNum(num);
		for (Map.Entry<Integer, Integer> entry : splitMap.entrySet()) {
			String place = getPlaces(entry.getValue());
			if (place != "") {
				finalString = getPosition(entry.getKey()) + " " + finalString;
			}
			finalString = place + " " + finalString;
		}

		return finalString.replace("  ", " ").replace("  ", " ").trim();
	}

	public void splitNum(int num) {

		if (num == 0)
			return;

		splitMap.put(splitMap.size(), num % 1000);
		splitNum(num / 1000);
	}

	public String getPosition(int i) {
		return new String[] { "", "Thousand", "Million", "Billion" }[i];
	}

	public String getTens(int i) {
		return new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety",
				"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
				"Nineteen" }[i];
	}

	public String getOnes(int i) {
		return new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten" }[i];
	}
}
