package Chapter1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String input = "Mr John Smith    ";
        System.out.println(URLify(input, 13));
    }

    public static boolean isUnique(String input){
        boolean[] haveSeen = new boolean[128];
        for(int i = 0; i < input.length(); i++){
            char currChar = input.charAt(i);
            if(haveSeen[currChar]){
                return false;
            }
        }
        return true;
    }

    public static boolean isPermutation(String a, String b) {
        char[] inputAasArray = a.toCharArray();
        char[] inputBasArray = b.toCharArray();
        Arrays.sort(inputAasArray);
        Arrays.sort(inputBasArray);
        return inputAasArray.toString().equals(inputBasArray.toString());
    }

    public static char[] URLify(String input, int trueLength) {
        //work from right to left and then
        char[] inputAsCharArray = input.toCharArray();
        int targetIdx = input.length()-1;
        for(int i = trueLength-1; i > 0; i--) {
            if(inputAsCharArray[i] != ' ') {
                inputAsCharArray[targetIdx] = inputAsCharArray[i];
                targetIdx--;
            }else{
                inputAsCharArray[targetIdx] = '0';
                inputAsCharArray[targetIdx-1] = '2';
                inputAsCharArray[targetIdx-2] = '%';
                targetIdx-=3;
            }
        }
        return inputAsCharArray;
    }
}

