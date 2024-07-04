public class Util {

    public static void bubbleSort(int[] arr) {
        int passes = arr.length - 1;
        int comps = arr.length - 1;

        for (int i = 0; i < passes; i++) {
            int count = 0;
            for (int j = 0; j < (comps - i); j++) {
                if (arr[j] > arr[j + 1]) {
                    count++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (count == 0) {
                System.out.println("Passes: " + (i + 1));
                return;
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void heapSort(int[] arr) {
        for(int i = arr.length - 1; i > 0; i--) {
            for(int j = i; j > 0; j--) {
                if(arr[j] > arr[(j-1)/2]) {
                    int temp = arr[j];
                    arr[j] = arr[(j-1)/2];
                    arr[(j-1)/2] = temp;
                }
            }
            //final swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
        }
    }

    public static void heapSort(int [] arr, int length) {

        if(length == 1) {
            return;
        }

        for(int j = length-1; j > 0; j--) {
            if(arr[j] > arr[(j-1)/2]) {
                int temp = arr[j];
                arr[j] = arr[(j-1)/2];
                arr[(j-1)/2] = temp;
            }
        }
        //final swap
        int temp = arr[0];
        arr[0] = arr[length - 1];
        arr[length - 1] = temp;

        heapSort(arr, length-1);
    }

    public static void quickSort(int [] arr, int left, int right) {
        if(left >= right) {
            return;
        }

        int pivotLocation = partition(arr, left, right);
        quickSort(arr, left, pivotLocation-1);
        quickSort(arr, pivotLocation+1, right);
    }

    private static int partition(int [] arr, int left, int right) {
        int pivot = arr[left];

        while( left != right) {
            //if right element is greater than pivot shift right
            while (arr[right] > pivot && left != right) {
                right--;
            }
             /*if(left == right) {
                break;
            }*/
            //right element is less than pivot, so shift it to left
            if(left != right) {
                arr[left] = arr[right];
                left++;
            }

            while (arr[left] < pivot && left != right) {
                left++;
            }
            /*if(left == right) {
                break;
            }*/
            if(left != right) {
                arr[right] = arr[left];
                right--;
            }
        }

        arr[left] = pivot; //position the pivot element at it's exact position in sorted array
        return right; //return the pivot location
    }

    public static void mergeSort(int [] arr, int left, int right) {
        if(left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, mid+1, right);
    }

    private static void merge(int [] arr, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int numElements = rightEnd - leftStart + 1;
        int [] resArr = new int[numElements];
        int resIndex = -1;

        //both arrays have elements
        while(leftStart <= leftEnd && rightStart <= rightEnd) {
            if (arr[leftStart] < arr[rightStart]) {
                //shift left start element to res array
                resArr[++resIndex] = arr[leftStart];
                leftStart++;
            } else {
                //shift right start element to res array
                resArr[++resIndex] = arr[rightStart];
                rightStart++;
            }
        }

        //true - means left array still has some elements, false - right array has elements
        if(leftStart <= leftEnd) {
            while(leftStart <= leftEnd) {
                resArr[++resIndex] = arr[leftStart];
                leftStart++;
            }
        }
        else {
            while(rightStart <= rightEnd) {
                resArr[++resIndex] = arr[rightStart];
                rightStart++;
            }

        }

        for(int i = 1; i <= numElements; i++) {
            arr[rightEnd] = resArr[resIndex];
            rightEnd--;
            resIndex--;
        }
    }

}
