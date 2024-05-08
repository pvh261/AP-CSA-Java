public class Sort {
    public static void main(String[] args) {
        int[] a= {3, 1, 3, 5, 7, 3, 6, 12, 234 , 5};
        insertionSort(a);
        for(int i : a) {
            System.out.println(i);
        }
    }

    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            //find min
            int min_id = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min_id]) {
                    min_id = j;
                }
            }
            int swap = arr[i];
            arr[i] = arr[min_id];
            arr[min_id] = swap;
        }
    }

    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
        }
    }

    public static void mergeSort(int[] arr) {
        
    }
}