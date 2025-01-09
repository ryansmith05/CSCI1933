import java.util.Arrays;
public class BinaryTree {

    // TODO complete this method
    public static boolean isValid(int[] arr) {
        int n = arr.length;
        // check if first element is root
        if (arr[0] != -1) {
            return false;
        }
        // check if all non-root nodes have parent nodes
        for (int i = 1; i < n; i++) {
            if (arr[i] != -1 && arr[(i-1)/2] == -1) {
                return false;
            }
        }
        // check if a non-leaf node has exactly two children
        for (int i = 0; i < n/2; i++) {
            if (arr[i] != -1) {
                if (2*i+1 < n && arr[2*i+1] == -1 && 2*i+2 < n && arr[2*i+2] == -1) {
                    return false;
                }
            }
        }
        // check if the tree is complete
        for (int i = n/2; i < n; i++) {
            if (arr[i] != -1) {
                return false;
            }
        }
        return true;
    }

    public static void main (String args[]) {
      // milestone 1
      int[] arr1 = new int[]{-1,7,4,10,3,6,8,15};
      int[] arr2 = new int[]{-1,20,12,32,5,18,25,38};
      int[] arr3 = new int[]{-1,11,3,33,2,8,10,44};
      int[] arr4 = new int[]{-1,55,44,77,33,48,54,95,22,34,45,57,53,70,85,98};

      System.out.println("arr1 valid: " + isValid(arr1));  // expected: true
      System.out.println("arr2 valid: " + isValid(arr2));  // expected: true
      System.out.println("arr3 valid: " + isValid(arr3));  // expected: false
      System.out.println("arr4 valid: " + isValid(arr4));  // expected: false
    }
}
