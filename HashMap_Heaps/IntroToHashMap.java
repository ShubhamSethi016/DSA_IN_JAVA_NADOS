import java.util.HashMap;
import java.util.Set;

public class IntroToHashMap {

  public static void main(String[] args)
  {
    // creation of hashmap
    HashMap< String, Integer> hm = new HashMap< >();

    //1. put() => addition of key-value pairs into map
    // O(1) operation
    hm.put("India", 1391);
    hm.put("China", 1398);
    hm.put("USA", 329);
    hm.put("Indonesia", 268);

    //2. Get()=> O(1) operation
    System.out.println("Value for India " + hm.get("India"));
    // output = 1391

    //Printing the get(key) when key doesn't exist
    System.out.println("Value for Utopia " + hm.get("Utopia"));
    // output = null

    //3. containsKey() => O(1) operation
    System.out.println("HashMap contains India" + hm.containsKey("India"));
    // output = true

    System.out.println("HashMap contains Pakistan" + hm.containsKey("Pakistan"));
    // output = false 
    
    //4. keySet()=> O(1) operation
    // a. to store only keys , keySet() is used to store into Set collection. O(1) operation
    Set< String> keys = hm.keySet();
    System.out.println(keys);
    // b. Using keySet() to iterate through the hashmap O(1) operation
    for (String key : hm.keySet())
    {
      Integer val = hm.get(key);
      System.out.print(key + ":" + val + "  ");
    }
  }
}