public class LC215_KthLargestElement {
        public int findKthLargest(int[] arr, int k) {
            quicksort(arr,0,arr.length-1);
            int ans = arr.length-k;
            return arr[ans];
        }
        static void quicksort(int[] arr, int first, int last){
            if(first >= last){
                return;
            }
            int start = first;
            int end = last;
            int mid = start + (end - start)/2;
            int pivot = arr[mid];
            while(start <= end){
                while(arr[start] < pivot){
                    start ++;
                }
                while(arr[end] > pivot){
                    end --;
                }
                if(start <= end){
                    int temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start ++;
                    end --;
                }
            }
            quicksort(arr, first , end );
            quicksort(arr, start , last);
        }
    }

