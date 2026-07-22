package arrays;

public class LC283 {

    public void moveZeroes(int[] arr) {

        if(arr.length <= 1){
            return;
        }

        int slow = 0 ;

        for(int fast = 0 ; fast < arr.length; fast++){
            if(arr[fast] != 0){
                int temp = arr[fast];
                arr[fast] = arr[slow];
                arr[slow] = temp;

                slow++;
            }
        }

    }
}
