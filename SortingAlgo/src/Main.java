public class Main {
    public static void main(String[] args) {

        int [] arr = {55, 90, 34, 9, 68, 12, 29, 44, 50, 72};
        //Util.bubbleSort(arr);
        //Util.selectionSort(arr);
        //Util.insertionSort(arr);
        //Util.heapSort(arr);
        //Util.heapSort(arr, arr.length);
        //Util.quickSort(arr, 0, arr.length-1);
        Util.mergeSort(arr, 0, arr.length-1);


        for(int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();

    }
}
