import java.util.HashMap;
 /**
  * This class marks the very basic level of DSA solving adventure I have taken up.
  * This class deals with 3 famous DSA problems, Two Sums (Two different variations)
  * and Valid Anagram.
  *
  * I have solved these problems ensuring least time and space complexity. I have also added comments to explain the logic behind the code.
  *
  * */

 public class LevelFive {
    public static void main(String[] args)  {
        // int [] ans = optimizedTwoSum(new int [] {0,12,15,15,27,31}, 27);
        // if (ans.length == 0)
        // {
        //     System.out.println("{}");
        // }else {
        //     System.out.println("{"+ans[0]+"," +ans[1]+"}");
        // }


        String s="anandan";
        String t="nandana";
        System.out.println(isAnagram(s, t));

    }


    /**
     * Given an array of unsorted integers and a target value,
     * my goal was to find two such indices from the array, such that
     * the addition of the elements in those indices equals target value.
     *
     * @param arr - the array of unsorted integers
     * @param target - the target value to be achieved by adding two elements from the array
     *
     * Approach :-
     *               1. Brute force :  You can obviously iterate throughout the whole array with two pointers comparing each element
     *                                  with every other element to find the target value.
     *                                  This approach takes O(n^2) time complexity which is really bad on time dependent systems.
     *               2. The Space Complexity Sacrifice : Another way to solve this problem is to use a HashMap to store the elements of the array and their indices.
     *                                 Then for each element we come across in the array you check for the difference of target and the current index element's presence
     *                                  in the HashMap. If it is present, then you have found your answer and return the indices of the two elements.
     *                                   And if not then put the current index element into the hashmap.
     *
     *                                  This approach takes O(n) time complexity and O(n) space complexity which is a good trade off.
     *
     *               KEY LEARNINGS : 1. While Solving DSA problems you have to either sacrifice time for more space, or the other way round,
     *                                  there is nothing called as a balanced solution while getting the most out of both.
     *                               2. Here we sacrificed a little space for a great improvement in time complexity.
     *                               3. HashMaps are a great data structure to use when you want to store data in a key-value pair and retrieve it in O(1) time complexity.
     *                                  So from the next DSA problem onwards, if you want to retrieve something in almost O(n) time, HashMaps are always the way to go.
     *                                  But make sure that in such cases, ORDER is not a mandate.
     *                              4. HashMaps in Java have a initial capacity of 16 and a load factor of 0.75, which means that when the number of elements in the HashMap exceeds 75% of the capacity, the HashMap will be resized to double its current capacity.
     *                              5. From Java 8 onwards, HashMaps have been optimized to use a balanced tree structure (Red-Black Tree) for buckets that have more than 8 elements, which improves the worst-case time complexity of get() and put() operations from O(n) to O(log n).
     *                              6. HashMap's containsKey and get() usually returns a null if the key is not present in the map, so make sure to check for null before using the value. That said you do not have to check for map empty condition prior.
     *
     * */
    private static int [] twoSum (int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int result = target - arr[i];
            if (map.containsKey(result)) {
                return new int [] {map.get(result), i};
            }
            map.put(arr[i], i);
        }
        return  new int [] {};
    }


    /**
     * Same as above, this problem was to optimize the above approach I had used to solve the two-sum problem.
     * To use this approach it is mandatory to have a sorted (ASC/DESC) array, in such case this approach works like a charm.
     * You will use two pointers, both stationed at the extreme ends of the array, in a ascendingly sorted array
     * at every iteration you will perform "right - left == target ? return index : if lesser than target move the left
     * pointer forward or, move the right pointer one step backwards, and do this until they both meet.
     *
     * This is optimized cuz it uses O(1) space and works in O(n) time unlike  the other version where you had
     * to introduce O(n) space as well.
     *
     * @param arr
     * @param target
     * @return int [] of indices. 
     * */

    private static int [] optimizedTwoSum(int [] arr, int target) {
        int leftptr = 0;
        int rightptr = arr.length - 1;


        while (leftptr < rightptr) {
            if (arr[leftptr] + arr[rightptr] == target)
                return new int [] {leftptr+1, rightptr+1};
            if (arr[leftptr] + arr[rightptr] < target)
                leftptr++;
            else
                rightptr--;
        }
        return new int [] {};
    }



    /**
     * Given two strings s and t, my goal was to determine if t is an anagram of s.
     * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     * Safe to assume that the strings contain only lowercase alphabets.
     * Solutions :-
     *            1. Brute Force : You can obviously sort both the strings and compare them, if they are equal then t is an anagram of s. 
     *                             But this approach takes O(nlogn) time complexity and O(n) space complexity which is not optimal.
     *            2. HashMap : You can use a HashMap to store the frequency of each character in s and then iterate through t to check 
     *                         if the frequency of each character matches with the frequency in s. But this approach takes O(n) time complexity 
     *                          and O(n) space complexity which is not optimal.
     *            3. Array : Think of the fact that the characters in the strings are limited to 26 lowercase English letters. This makes it
     *                       capped to fixed size of 26. So we could probably use an Array of size 26, then you run through the first string 
     *                       and increment the frequency of each character in the array, then run through the second string and decrement the 
     *                       frequency of each character in the array. If at the end all the frequencies are 0, then t is an anagram of s.
     *                       This approach takes O(n) time complexity and O(1) space complexity which is optimal. 
     */

    private static boolean isAnagram(String s, String t){
        if (s.length() != t.length()) return false;
        
        int [] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            ++arr[s.charAt(i) - 'a'];
            --arr[t.charAt(i) - 'a'];
    
        }

        for (int i : arr) {
            if (i != 0) return false;
        }
        return true;

    }


}