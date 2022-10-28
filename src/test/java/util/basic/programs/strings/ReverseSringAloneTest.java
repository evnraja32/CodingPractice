package util.basic.programs.strings;

import org.testng.annotations.Test;

public class ReverseSringAloneTest {
  @Test
  public void reverseStringAlone() {
	  
	    String s = "Java19pappy4578Python344";
        String output = "";
        String temp = "";
        
        for (char c : s.toCharArray()){
//            System.out.println((int)'A' + " <= " + (int)c + " <= " + (int)'z');
            if((int)'A' <= (int)c && (int)'z' >= (int)c){
                temp = c + temp;
            } else{
                temp += c;
//                System.out.println(temp);
                output += temp;
                temp = "";
            }
        }
        output += temp;
        System.out.println("final output: " + output);
  }
}
