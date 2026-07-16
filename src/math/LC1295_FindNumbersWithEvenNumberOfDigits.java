public class LC1295_FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {

        int[] nums = {12, 345, 2, 6, 7896};

        int result = findNumbers(nums);

        System.out.println(result);
    }

    static int findNumbers(int[] nums) {
        return EvenDigitNumbers(nums);
    }

    static int EvenDigitNumbers(int[] arr) {

        int count = 0;

        for(int i = 0; i < arr.length; i++){

            int number = arr[i];
            int digits = 0;

            if (number == 0){
                digits = 1;
            }

            while(number > 0){
                number = number / 10;
                digits++;
            }

            if(digits % 2 == 0){
                count++;
            }
        }

        return count;
    }
}