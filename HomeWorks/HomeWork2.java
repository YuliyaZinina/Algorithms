import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class HomeWork2 {
    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 2, 1, 2, 3, 4, 4, 4, 4, 2, 3, 3, 3, 2, 1, 3, 4, 1, 1, 2, 2, 2, 4, 4, 1, 1, 2,
                3 };

        countingSort(array);

    }

    static void countingSort(int[] array) {
        Map<Integer, Integer> countingMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            if (countingMap.containsKey(array[i])) {
                int count = countingMap.get(array[i]);
                count = count + 1;
                countingMap.put(array[i], count);
            } else {
                countingMap.putIfAbsent(array[i], 1);
            }
        }
        Set<Integer> uniqueElements = new TreeSet<>(countingMap.keySet());

        int ind = 0;
        for (Integer i : uniqueElements) {
            for (int j = 0; j < countingMap.get(i); j++) {
                array[ind] = i;
                ind++;
            }
        }

        System.out.println(Arrays.toString(array));

    }
}
