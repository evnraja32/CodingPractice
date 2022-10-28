package practice.coding.leetcode;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

/**
 * 
 * @author veelluru
 *
 * @implSpec https://leetcode.com/problems/integer-to-roman/
 */

public class IntToRomanTest {

	HashMap<Integer, String> romanSeries = new HashMap<Integer, String>();

	@Test(description = "1 to 3999 numbers test")
	public void allNums() {
		for (int i = 1; i <= 3999; i++ ) {
//			System.out.println("Testing: " + i);
			assertEquals(romanToInt(intToRoman(i)), i);
		}
	}
	
	@Test
	public void testnum3() {
		assertEquals(intToRoman(3), "III");
		assertEquals(romanToInt("III"), 3);
	}
	
	@Test
	public void testnum5() {
		assertEquals(intToRoman(5), "V");
		assertEquals(romanToInt("V"), 5);
	}

	@Test
	public void testnum3238() {
		assertEquals(intToRoman(3238), "MMMCCXXXVIII");
	}

	@Test
	public void testnum3999() {
		assertEquals(intToRoman(3999), "MMMCMXCIX");
	}

	@Test
	public void testnum19() {
		assertEquals(intToRoman(19), "XIX");
	}

	public String intToRoman2(int num) {

		char[] ans = new char[15];

		int i = 0; // To keep track of the index

		// Add characters to array according to the number

		int n = num / 1000; // For Ms
		while (n-- > 0)
			ans[i++] = 'M';
		num %= 1000;

		if (num >= 900) { // For CMs
			ans[i++] = 'C';
			ans[i++] = 'M';
			num -= 900;
		}

		n = num / 500;
		while (n-- > 0)
			ans[i++] = 'D';
		num %= 500;

		if (num >= 400) {
			ans[i++] = 'C';
			ans[i++] = 'D';
			num -= 400;
		}

		n = num / 100;
		while (n-- > 0)
			ans[i++] = 'C';
		num %= 100;

		if (num >= 90) {
			ans[i++] = 'X';
			ans[i++] = 'C';
			num -= 90;
		}

		n = num / 50;
		while (n-- > 0)
			ans[i++] = 'L';
		num %= 50;

		if (num >= 40) {
			ans[i++] = 'X';
			ans[i++] = 'L';
			num -= 40;
		}

		n = num / 10;
		while (n-- > 0)
			ans[i++] = 'X';
		num %= 10;

		if (num >= 9) {
			ans[i++] = 'I';
			ans[i++] = 'X';
			num -= 9;
		}

		n = num / 5;
		while (n-- > 0)
			ans[i++] = 'V';
		num %= 5;

		if (num >= 4) {
			ans[i++] = 'I';
			ans[i++] = 'V';
			num -= 4;
		}

		while (num-- > 0)
			ans[i++] = 'I';

		return new String(ans, 0, i); // Using the constructor to convert part of array into string

	}

	public String intToRoman(int num) {
		String converted = "";

		HashMap<Integer, Integer> series = splitNum(num, 10);
//		System.out.println("Converted series: " + series.toString());
		for (Map.Entry<Integer, Integer> entry : series.entrySet()) {
			converted = getRomNumber(entry.getKey(), entry.getValue()) + converted;
		}

		return converted;
	}

	public String getRomNumber(int repeater, int numeric) {
		String sum = "";

		int position = 1;
		while (repeater-- > 0)
			position *= 10;

//		System.out.println("Position: " + position);
		String literal = romSeries().get(position);

		if (position >= 1000) {
			while (numeric-- > 0)
				sum += literal;

		} else {
			sum += getPositionLitrals(numeric, position, literal);
			
		}

		return sum;
	}

	public String getPositionLitrals(int numeric, int position, String literal) {
		String sum = "";
//		System.out.println("Numeric: " + numeric + " Position: " + position + " Literal: " + literal);
		if (numeric == 9) {
			sum = romSeries().get(position * numeric);
		} else if (numeric == 5) {
			sum = romSeries().get(position * numeric);
		} else if (numeric > 5) {
//			System.out.println("Numeric: " + numeric + " Position: " + position + " Literal: " + literal);
			sum = romSeries().get(position * 5);
			numeric -= 5;
//			System.out.println("Numeric: " + numeric + " Position: " + position + " Literal: " + literal + " Sum: " + sum);
			while (numeric-- > 0)
				sum += literal;
		} else if (numeric == 4) {
			sum = romSeries().get(position * numeric);
		} else {
			while (numeric-- > 0)
				sum += literal;
		}

		return sum;
	}

	public HashMap<Integer, Integer> splitNum(int num, int divisor) {
		HashMap<Integer, Integer> series = new HashMap<Integer, Integer>();
		int index = 0;
		while (num > 0) {
			series.put(index, num % divisor);
			num = num / divisor;
			++index;
		}
		return series;
	}

	public HashMap<Integer, String> romSeries() {
		romanSeries.put(1, "I");
		romanSeries.put(4, "IV");
		romanSeries.put(5, "V");
		romanSeries.put(9, "IX");
		romanSeries.put(10, "X");
		romanSeries.put(40, "XL");
		romanSeries.put(50, "L");
		romanSeries.put(90, "XC");
		romanSeries.put(100, "C");
		romanSeries.put(400, "CD");
		romanSeries.put(500, "D");
		romanSeries.put(900, "CM");
		romanSeries.put(1000, "M");
		return romanSeries;
	}

	public int romanToInt(String s) {

		HashMap<Character, Integer> romanNums = new HashMap<Character, Integer>();
		romanNums.put('I', 1);
		romanNums.put('V', 5);
		romanNums.put('X', 10);
		romanNums.put('L', 50);
		romanNums.put('C', 100);
		romanNums.put('D', 500);
		romanNums.put('M', 1000);

//		System.out.println("String: " + s + " Length: " + s.length());
		int sum = romanNums.get(s.charAt(0));
		int i = 1, j = s.length() - 1;
		int current, previous;

		while (i <= j) {
			previous = romanNums.get(s.charAt(i - 1));
			current = romanNums.get(s.charAt(i));
			if (current > previous) {
				sum += (current - (2 * previous));
			} else {
				sum += current;
			}
//			System.out.println(sum);
			i++;
		}

		return sum;
	}
	
	
}
