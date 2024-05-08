public class A {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 6, 1, 5, 9, 0, 3};
        insertionSort(arr);
        for(int i : arr) {
            System.out.println(i);
        }
    }

    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length-1; i++) {
            int min_idx = i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            int swap = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = swap;
        }
    }

    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}