package tools;

import java.util.ArrayList;

/**
 * Created by XTR100 on 15/10/2016.
 */
public class NumberOperation {

    private ArrayList<String> permutedList = new ArrayList();
    private String repeatedNumber = "";

    public ArrayList<String> getPermutedNumber(String number) {
        permutedList = new ArrayList();


        String[] inputNumber = number.split("");
        getRepeatedNumber(inputNumber);
        int n = 3;                  //Tipos para escoger
        int r = inputNumber.length;   //Elementos elegidos
        permute(inputNumber, "", n, r);


        return permutedList;
    }

    private void getRepeatedNumber(String[] inputNumber) {
        String temp = "";
        for (String str :
                inputNumber) {
            if (str.equals(temp)) {
                repeatedNumber = str;
                temp = "";
            }
            temp = str;
        }
    }

    private void permute(String[] elem, String act, int n, int r) {

        if (n == 0) {
            System.out.println(act);
            if (!permutedList.contains(act))
                permutedList.add(act);
        } else {
            for (int i = 0; i < r; i++) {
                elem[i] = elem[i].trim();
                if (!act.contains(elem[i])) { // Controla que no haya repeticiones
                    permute(elem, act + elem[i], n - 1, r);
                } else if (!repeatedNumber.equals("") & repeatedNumber.equals(elem[i])) {
                    permute(elem, act + elem[i], n - 1, r);
                }
            }
        }

    }
}
