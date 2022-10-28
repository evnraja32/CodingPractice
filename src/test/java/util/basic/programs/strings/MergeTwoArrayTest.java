package util.basic.programs.strings;

import java.util.*;

import org.testng.annotations.Test;

public class MergeTwoArrayTest {
  @Test
  public void method1() {
	  
	  int[] arr1 = {1,2,3,4,5,5};
      int[] arr2 = {6,6,7,2,3,4,1,2,4};
      int[] arr3 = new int[arr1.length + arr2.length];
   
      System.arraycopy(arr1, 0, arr3, 0, arr1.length);
      System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
      
      TreeSet<Integer> output = new TreeSet<Integer>();
      HashMap<Integer, Integer> numCountTracker = new HashMap<Integer, Integer>();
      
      for(int i : arr3){
          if(numCountTracker.containsKey(i)){
              numCountTracker.put(i, numCountTracker.get(i) + 1);  
              output.add(i);
          } else {
              numCountTracker.put(i, 1);
          }
      }
      
      System.out.println(output);
  }
}
