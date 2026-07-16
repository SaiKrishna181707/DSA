public class LC154_FindMinInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] arr ={18,14,18,18};
        int ans = findMin(arr);
        System.out.println(ans);
    }
        static int findMin(int[] arr) {
            int start = 0;
            int end = arr.length - 1;

            while (start < end) {
                int mid = start + (end - start) / 2;

                if (arr[mid] > arr[end]) {
                    // Minimum is in right half
                    start = mid + 1;
                }
                else if (arr[mid] < arr[end]) {
                    // Minimum is in left half including mid
                    end = mid;
                }
                else {
                    // arr[mid] == arr[end] → cannot decide
                    end--;
                }
            }

            // start == end → minimum element
            return arr[start];
        }
    }

