package practice.coding.leetcode;

import org.testng.annotations.Test;

import java.util.HashSet;

public class UniqueEmailsTest {
  @Test
  public void f() {
  }
  
  
  public int numUniqueEmails(String[] emails) {
      HashSet<String> acceptedEmails = new HashSet<String>();
      String firstHalf, secondHalf;
      for(String email : emails){
          String localName = email.split("@")[0];
          String domainName = email.split("@")[1];
      }

      return 0;
  }
}
