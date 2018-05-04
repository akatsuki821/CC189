//Implement an algorithm to determine if a string has all unique characters. What if you cannot use
//additional data structures?

//use int as array (int type has 32 bit), ASCII code for characters (255), bit manipulation
public class IsUnique {
    public static boolean isUnique(String input) {
        int[] matrix = new int[8]; //8 * 32 = 256
        for (int i = 0; i < input.length(); i++) {
            int character = input.charAt(i);
            int row = character / 32;
            int col = character % 32;
            if (((matrix[row] >>> col) & 1) == 1) {
                return false;
            }
            matrix[row] |= (1 << col);
        }
        return true;
    }

    public static void main(String[] args) {
        //test
        String input1 = "abca";
        System.out.println(isUnique(input1));
        String input2 = "abcde";
        System.out.println(isUnique(input2));
    }
}
