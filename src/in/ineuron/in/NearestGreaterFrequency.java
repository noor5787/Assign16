package in.ineuron.in;
import java.util.*;

public class NearestGreaterFrequency {
    public static int[] findNearestGreaterFrequency(int[] arr) {
        int[] result = new int[arr.length];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
            int nearestGreaterFrequency = -1;

            for (int j = i + 1; j < arr.length; j++) {
                if (frequencyMap.get(arr[j]) > frequencyMap.get(arr[i])) {
                    nearestGreaterFrequency = arr[j];
                    break;
                }
            }

            result[i] = nearestGreaterFrequency;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 3, 4, 2, 1};
        int[] result1 = findNearestGreaterFrequency(arr1);
        System.out.println(Arrays.toString(result1));

        int[] arr2 = {1, 1, 1, 2, 2, 2, 2, 11, 3, 3};
        int[] result2 = findNearestGreaterFrequency(arr2);
        System.out.println(Arrays.toString(result2));
    }
}
