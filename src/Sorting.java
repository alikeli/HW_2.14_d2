import java.util.Random;
import java.util.function.Consumer;

public class Sorting {
    private static final Random RAND = new Random();


    public static void main(String[] args) {
        double timeForBubbleSort = measureTime(10, Sorting::sortBubble);
        System.out.println( timeForBubbleSort);
        double timeForSelectionSort = measureTime(10, Sorting::sortSelection);
        System.out.println( timeForSelectionSort);
        double timeForInsertionSort= measureTime(10, Sorting::sortInsertion);
        System.out.println( timeForInsertionSort);

    }
    private static double measureTime(int iteration, Consumer<int[]> sort) {
        long time =0;
        for (int i = 0; i < iteration; i++) {
            int[] arr = generateArray(100000);
            long start = System.currentTimeMillis();
            sort.accept(arr);
            time += System.currentTimeMillis() - start;


            time=time+(System.currentTimeMillis()-start);
            
        }
        return time/(double) iteration;
    }



    private static int[] generateArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = RAND.nextInt(100);
        }
        return array;

    }
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    public static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }
    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
}
