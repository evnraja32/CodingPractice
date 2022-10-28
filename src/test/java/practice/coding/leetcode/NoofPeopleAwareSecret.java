package practice.coding.leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-people-aware-of-a-secret/description/
 *
 * Example 1:
 *
 * Input: n = 6, delay = 2, forget = 4
 * Output: 5
 * Explanation:
 * Day 1: Suppose the first person is named A. (1 person)
 * Day 2: A is the only person who knows the secret. (1 person)
 * Day 3: A shares the secret with a new person, B. (2 people)
 * Day 4: A shares the secret with a new person, C. (3 people)
 * Day 5: A forgets the secret, and B shares the secret with a new person, D. (3 people)
 * Day 6: B shares the secret with E, and C shares the secret with F. (5 people)
 * Example 2:
 *
 * Input: n = 4, delay = 1, forget = 3
 * Output: 6
 * Explanation:
 * Day 1: The first person is named A. (1 person)
 * Day 2: A shares the secret with B. (2 people)
 * Day 3: A and B share the secret with 2 new people, C and D. (4 people)
 * Day 4: A forgets the secret. B, C, and D share the secret with 3 new people. (6 people)
 *
 *
 * Constraints:
 *
 * 2 <= n <= 1000
 * 1 <= delay < forget <= n
 */
public class NoofPeopleAwareSecret {

    @Test
    public void testMethod1(){
        System.out.println(new NoofPeopleAwareSecret().peopleAwareOfSecret(6, 2, 4)==5);
//        System.out.println(new NoofPeopleAwareSecret().peopleAwareOfSecret(6, 2, 4));
//        System.out.println(new NoofPeopleAwareSecret().peopleAwareOfSecret(6, 2, 4) == new NoofPeopleAwareSecret().peopleAwareOfSecret2(6, 2, 4));
    }

    @Test
    public void testMethod2(){
        System.out.println(new NoofPeopleAwareSecret().peopleAwareOfSecret(425, 81, 118));;
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int m = 1000000007;
        long ans = 0;

        // It represnts the timelime
        // i.e. for how many days a person will remeber the
        // secret and then forget
        int[] dayTracker = new int[forget];

        dayTracker[0] = 1;

        for(int day = 2; day <= n ; day++){
            for(int i = forget -1; i > 0 ; i--){
                dayTracker[i] = dayTracker[i-1];
            }
            dayTracker[0] = 0;
            // Share secret
            for(int i = delay; i < forget ; i++){
                dayTracker[0] = (dayTracker[0]+dayTracker[i]) % m;
            }
        }

        // Find total peoples
        for(int i  = 0; i < forget ; i++){
            ans+= dayTracker[i];
        }

        return (int)(ans % m);
    }

    public int peopleAwareOfSecret2(int n, int delay, int forget) {
        TreeMap<Integer, Integer> people = new TreeMap<>();
        if(!(2 <= n && n <= 1000) || !(1 <= delay && delay < forget && forget <= n)){
            return people.size();
        }

        people.put(1, 0);
        //System.out.println("secret is told to person 1");

        for (int i = 1 ; i <= n ; i++) {
            //System.out.println("Day - "+i + " | No.of people know secret: " + people.size());
            TreeMap<Integer, Integer> temp = (TreeMap<Integer, Integer>) people.clone();
            for(Map.Entry<Integer, Integer> entry : temp.entrySet()){
                people.put(entry.getKey(), entry.getValue() + 1);
                int daysPassed =  people.get(entry.getKey());
                //System.out.print("Person " + entry.getKey() + " - know secret, ");
                if(daysPassed > forget){
                    people.remove(entry.getKey());
                    //System.out.print("Person " + entry.getKey() + " got forget, ");
                    continue;
                }

                if (daysPassed > delay){
                    people.put(people.lastKey() + 1, 1);
                    //System.out.print("Person " + entry.getKey() + " - tells secret to, " + people.lastKey() + ",");
                }
            }
        }


        return (int)(people.size() % 1000000007);
    }


    public int peopleAwareOfSecret_observational(int n, int delay, int forget) {
        TreeMap<Integer, Integer> people = new TreeMap<>();
        if(!(2 <= n && n <= 1000) || !(1 <= delay && delay < forget && forget <= n)){
            return people.size();
        }

        people.put(1, 0);
        System.out.println("secret is told to person 1");

        for (int i = 1 ; i <= n ; i++) {
            System.out.println("Day - "+i + " | No.of people know secret: " + people.size());
            TreeMap<Integer, Integer> temp = (TreeMap<Integer, Integer>) people.clone();
            for(Map.Entry<Integer, Integer> entry : temp.entrySet()){
                people.put(entry.getKey(), entry.getValue() + 1);
                int daysPassed =  people.get(entry.getKey());
                System.out.print("Person " + entry.getKey() + " - know secret, ");
                if(daysPassed > forget){
                    people.remove(entry.getKey());
                    System.out.print("Person " + entry.getKey() + " got forgots, ");
                    continue;
                }

                if (daysPassed > delay){
                    people.put(people.lastKey() + 1, 1);
                    System.out.print("Person " + entry.getKey() + " - tells secret to, " + people.lastKey() + ",");
                }
            }
        }


        return people.size();
    }
}
