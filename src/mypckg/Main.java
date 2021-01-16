package mypckg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    //task#1
    static List<Integer>  getIntegersFromList(List input){
        List output = new ArrayList();
        for (Object o:
             input) {

            if(o.getClass().getName().equals("java.lang.Integer")){
                output.add(o);
            }
        }
        return output;
    }
    //task#2
    static Character first_non_repeating_letter(String input){
        input =input.toUpperCase();

        for (Character ch : input.toCharArray()) {
            if (input.indexOf(ch) == input.lastIndexOf(ch)) {
                return ch;
            }

        }
        return ' ';
    }
    //task#3
    static int digitalRoot(Integer num) {
        int sum = 0;
        char[] arr_num = num.toString().toCharArray();
        for (Character d : arr_num) {
            sum += Character.getNumericValue(d);
        }
        if (sum >= 10) {
            return digitalRoot(sum);
        }
        return sum;
    }


    //task#4
    static int countPairsFor(Integer[] arr_n, int target) {
        int pairs = 0;
        for (int i = 0; i < arr_n.length; i++) {
            for (int j = i + 1; j < arr_n.length; j++)
                if (arr_n[i] + arr_n[j] == target) {
                    pairs += 1;
                }
        }
        return pairs;
    }

    static long countPairsStream(Integer[] arr_n, int target) {
        LinkedList<Object> arr = new LinkedList();
        IntStream.range(0,  arr_n.length)
                .forEach(i -> IntStream.range(0,  arr_n.length)
                        .filter(j -> i != j && arr_n[i]+ arr_n[j]== target)
                        .forEach(j -> arr.add(1)));
        return arr.size()/2;
    }
    //task#5
    static String sortedName(String names) {
        String[] up_names = names.toUpperCase().split(";");
        for (int i = 0; i < up_names.length; i++) {
            String[] a = up_names[i].split(":");
            up_names[i] = a[1] + ", " + a[0];
        }
        Arrays.sort(up_names);
        String res = "";
        for (String s : up_names) {
            res += '(' + s + ')';
        }
        return res;
    }
    //exta task#1
    static void swap(int ar[], int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    static int[] findNext(int ar[], int n) {
        int i;
        for (i = n - 1; i > 0; i--) {
            if (ar[i] > ar[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            System.out.println("Not possible");
        } else {
            int x = ar[i - 1], min = i;
            for (int j = i + 1; j < n; j++) {
                if (ar[j] > x && ar[j] < ar[min]) {
                    min = j;
                }
            }
            swap(ar, i - 1, min);
            Arrays.sort(ar, i, n);
        }
        return ar;
    }

    //exta task#2
    static String ip_address(Long h_ip){
        String ip_2 = Long.toBinaryString(h_ip);
        String res = "";
        for (int i =0; i<ip_2.length();i+=8){
            res += Integer.parseInt((ip_2.substring(i, i+8)), 2) + ".";
        }
        return res.substring(0, res.length()-1);
    }
    public static void main(String[] args) {


        System.out.println("TASK №1");
        Object[] a = new Object[]{1, 2, "a", "b"};
        Object arr = getIntegersFromList(Arrays.asList(a));
        System.out.println(arr);

        System.out.println("TASK №2");
        String str = "sTreSS";
        Character chr = first_non_repeating_letter(str);
        System.out.println(chr);

        System.out.println("TASK №3");
        Integer num = 132189;
        int sum = digitalRoot(num);
        System.out.println(sum);

        System.out.println("TASK №4");
        Integer [] arr_n = new Integer[]{1, 3, 6, 2, 2, 0, 4, 5};
        int target = 5;
        int count1 = countPairsFor(arr_n, target);
        System.out.println("first way (via for): "+ count1);
        long count2 = countPairsStream(arr_n, target);
        System.out.println("second way (via stream): "+count2);

        System.out.println("TASK №5");
        String name_surname = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        String sort_name = sortedName(name_surname);
        System.out.println(sort_name);

        System.out.println("EXTRA TASK №1");
        Integer numb = 2017;
        char[] arr2 = numb.toString().toCharArray();
        int[] arr_num = new int[arr2.length];
        for (int i = 0; i < arr2.length; i++){
            arr_num[i] = Character.getNumericValue(arr2[i]);
        }
        int min_numb[] = findNext(arr_num, arr_num.length);
        String ress = "";
        for(int i:min_numb){
            ress+= i;
        }
        System.out.println(Integer.valueOf(ress));

        System.out.println("EXTRA TASK №2");
        Long h_ip = 2149583361L;
        String ip  = ip_address(h_ip);
        System.out.println(ip);


    }

}
