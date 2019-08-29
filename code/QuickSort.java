public class QuickSort {

    public static void main(String[] args){
        int[] arr = {2,4,8,6,9,3,1,7,5};

        //快排
//        quickSort(arr,0,arr.length -1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print("ssss: "+ arr[i]);
//        }

        //给一个无序数组arr和数组长度n，找出其中的中位数。
        int mid = findMid(arr, 9);
        System.out.print("mid: "+mid);
    }

    //快排
    public static void quickSort(int[] arr, int start, int end){
        if (start < end){
            int index = Partition(arr,start,end);
            quickSort(arr,start,index -1);
            quickSort(arr,index+ 1,end);
        }
    }

    private static int Partition(int[] arr, int start, int end) {
        int key = arr[start];
        while (start < end){
            while (arr[end] >= key && start < end){
                end--;
            }

            int t = arr[start];
            arr[start] = arr[end];
            arr[end] = t;

            while (arr[start] <= key && start< end){
                start++;
            }

            int x = arr[start];
            arr[start] = arr[end];
            arr[end] = x;

        }
        return start;
    }

    /**
     * 给一个无序数组arr和数组长度n，找出其中的中位数。
     * @param arr
     * @param n
     * @return
     * 进行快排，index 左边的都比右边的小， mid 跟index 比较，mid > index, 从index + 1 ,向右寻找 ；mid > index, 从index - 1 ,向左寻找
     */
    public static int findMid(int[] arr ,int n){
        int mid = (n - 1)/2;
        int start = 0, end = arr.length -1;
        int index = Partition(arr, start, end);
        while (index != mid){
            if (mid < index){
                index = Partition(arr,start,index - 1);
            }else {
                index = Partition(arr,index+ 1,end);
            }
        }
        return arr[index];
    }

}
