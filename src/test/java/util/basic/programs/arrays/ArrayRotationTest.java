package util.basic.programs.arrays;

import java.util.Arrays;

import org.testng.annotations.Test;

public class ArrayRotationTest {
	@Test
	public void arrayRotate() {
		int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7 };
		// o/p : 3, 4, 5, 6, 1, 2

//		int rotationConstant = 2;

//		System.out.println(Arrays.toString(leftRotate(arr1, 4)));
		System.out.println(Arrays.toString(leftRotate(arr1, arr1.length, 8)));
	}

	public int[] leftRotate(int[] arr, int rotationConstant) {

		if (rotationConstant > 0) {
			int firstEle = arr[0];
			for (int i = 1; i < arr.length; i++) {
				arr[i - 1] = arr[i];
			}
			arr[arr.length - 1] = firstEle;
			leftRotate(arr, --rotationConstant);
		}

		return arr;
	}

	public int[] leftRotate(int[] arr, int n, int d) {

		if (d > 0) {
			int firstEle = arr[0];
			for (int i = 1; i < n; i++) {
				arr[i - 1] = arr[i];
			}
			arr[n - 1] = firstEle;
			leftRotate(arr, --d);
		}

		return arr;
	}
	
	@Test
	public void timeCalculation(){
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7,1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7 };
		int d = 1200;
		double st = System.currentTimeMillis();
		for (int i = 1; i <= d; i++ ){
		    for(int j = 0; j < arr.length - 1; j++){
		        int temp = arr[j];
		        arr[j] = arr[j+1];
		        arr[j+1] = temp;
		    }
		}
		double v1 = System.currentTimeMillis() - st;
		st = System.currentTimeMillis();
		leftRotate2(arr, d);
		double v2 = System.currentTimeMillis() - st;
		System.out.println("\nNested Loop time: " + v1);
		System.out.println("\nRecurssion time: " + v2);
		String s = (v1 > v2) ? "\nNested loop is slower" : "\nNested loop is faster";
		System.out.println(s);
		
		st = System.currentTimeMillis();
		leftRotate(arr, d);
		double v3 = System.currentTimeMillis() - st;
		System.out.println("\nrotate logic one: " + v3);
	}
	

	@Test
	public void arrRotateRight() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
	    int d = 2;
	    
	    System.out.println(Arrays.toString(rightRotate(arr, d)));
	}
	
	public int[] leftRotate2(int arr[], int d){
	    if(d > 0){
	        for(int j = 0; j < arr.length - 1; j++){
		        int temp = arr[j];
		        arr[j] = arr[j+1];
		        arr[j+1] = temp;
		    }
		    leftRotate(arr, --d);
	    }
	    return arr;
	}
	
	public int[] rightRotate(int[] arr, int d){
        if(d > 0){
            for(int i = arr.length - 1; i >= 1; i--){
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
            }
            rightRotate(arr, --d);
        }
        return arr;
    }
	
}
