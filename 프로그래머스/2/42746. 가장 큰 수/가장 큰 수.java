import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        List<Integer> arr1 = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
//            arr[i] = String.valueOf(numbers[i]);
            arr1.add(numbers[i]);
        }

//        Arrays.sort(arr, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));
        Collections.sort(arr1, (a, b ) -> {
            String as = String.valueOf(a), bs = String.valueOf(b);
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });

        if (arr1.get(0).equals(0)) {
            return "0";
        }

//        if (arr[0].equals("0")) {
//            return "0";
//        }
        StringBuilder sb = new StringBuilder();
        for (Integer a : arr1) {
            sb.append(String.valueOf(a));
        }
        return sb.toString();
    }
}