package util.basic.programs.searching;

import org.testng.annotations.Test;

public class BinarySearchTest {
  @Test
  public void binarySearch() {
	  int[] arr = {1, 2, 3, 4, 5, 6}; // 5
	  int low = 0, high = arr.length - 1, mid = (low + high) / 2;
	  int expectedValue = 5;
	  
	  System.out.println(search(arr, expectedValue, low, high, mid));
  }
  
  public int search(int[] arr, int expectedValue, int low, int high, int mid) {
	  if (expectedValue > arr[mid]) {
		  low = mid + 1;
	  } else if(expectedValue < arr[mid]) {
		  high = mid - 1;
	  } else {
		return mid;  
	  }
	  
	  return search(arr, expectedValue, low, high, ((low + high) / 2));
  }
}
