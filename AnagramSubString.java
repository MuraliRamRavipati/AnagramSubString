import java.util.Arrays;
import java.util.Scanner;

public class AnagramSubString {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the string for anagarams");
    String T = scanner.next();
    System.out.println("Enter the sub-string to check");
    String S = scanner.next();
    if (T.contains(S)) {
      System.out.println(true);
    } else {
      char arr[] = T.toCharArray();
      Arrays.sort(arr);
      AnagramSubString anagramSubString = new AnagramSubString();
      anagramSubString.anagram(arr, S);
    }
  }

 private void anagram(char arr[], String s)  // arr= Array Name ; n = Size of the array
  {
    int n = arr.length;
    while (true){    // Infinite loop
      int i = (n - 1), j;
      char temp;
      while (i > 0 && arr[i - 1] >= arr[i])   // Finding the largest suffix start position
        i--;
      if (i == 0) {  // Check for final permutation case
        System.out.println(false);
        return;
      }
      j = n - 1;
      while (arr[j] <= arr[i - 1])  // Getting the element which is larger the pivot and the smallest element in the suffix set.
        j--;
      temp = arr[i - 1];			// Swap logic.
      arr[i - 1] = arr[j];
      arr[j] = temp;
      j = n - 1;
      while (i < j){				// Reverse suffix
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
      if (String.valueOf(arr).contains(s)) {
        System.out.println(true);
        return;
      }
    }
  }
}
