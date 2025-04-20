package implementation.sorting;

public class Bubble {
    public static void main(String[] args) {
        int arr[] = { 64, 25, 12, 22, 11 };
        bubbleSort(arr);
        System.out.println("Sorted array: ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) { // no of passes 1 to n-a
            for (int j = 0; j < n - i; j++) { // no of comparisons 0 to n-i
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

    }
}
