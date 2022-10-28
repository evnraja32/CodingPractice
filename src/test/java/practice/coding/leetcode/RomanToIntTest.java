package practice.coding.leetcode;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

/**
 * 
 * @author veelluru
 * 
 * @implSpec https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToIntTest {
	@Test
	public void testNum5() {
		assertEquals(romanToInt("V"), 5);
	}

	@Test
	public void testNum6() {
		assertEquals(romanToInt("VI"), 6);
	}

	@Test
	public void testNum7() {
		assertEquals(romanToInt("VII"), 7);
	}

	@Test
	public void testNum8() {
		assertEquals(romanToInt("VIII"), 8);
	}

	@Test
	public void testNum9() {
		assertEquals(romanToInt("IX"), 9);
	}

	@Test
	public void testNum10() {
		assertEquals(romanToInt("X"), 10);
	}

	@Test
	public void testNum11() {
		assertEquals(romanToInt("XI"), 11);
	}

	@Test
	public void testNum914() {
		assertEquals(romanToInt("CMXIV"), 914);
	}

	@Test
	public void testNum21() {
		assertEquals(romanToInt("XXI"), 21);
	}

	@Test
	public void testNum3999() {
		assertEquals(romanToInt("MMMCMXCIX"), 3999);
	}

	@Test
	public void testNum888() {
		assertEquals(romanToInt("DCCCLXXXVIII"), 888);
	}

	// This solution will ran in 5ms and consumes 42.7MB
	public int romanToInt1(String s) {

		HashMap<Character, Integer> romanNums = new HashMap<Character, Integer>();
		romanNums.put('I', 1);
		romanNums.put('V', 5);
		romanNums.put('X', 10);
		romanNums.put('L', 50);
		romanNums.put('C', 100);
		romanNums.put('D', 500);
		romanNums.put('M', 1000);

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
			System.out.println(sum);
			i++;
		}

		return sum;
	}

	// This solution will ran in 6ms and consumes 45.1MB
	public int romanToInt(String s) {

		char[] romonNums = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		int[] numericValues = { 1, 5, 10, 50, 100, 500, 1000 };

		int sum = numericValues[indexOfChar(romonNums, s.charAt(0))];
		int i = 1, j = s.length() - 1;
		int current, previous;

		while (i <= j) {
			previous = numericValues[indexOfChar(romonNums, s.charAt(i - 1))];
			current = numericValues[indexOfChar(romonNums, s.charAt(i))];
			if (current > previous) {
				sum += (current - (2 * previous));
			} else {
				sum += current;
			}
			i++;
		}

		return sum;
	}

	public int indexOfChar(char[] arr, char k) {
		int index = -1;
		int i = 0, j = arr.length - 1;
		while (i <= j) {
			if (arr[i] == k) {
				index = i;
				break;
			}
			i++;
		}
		return index;
	}
}
