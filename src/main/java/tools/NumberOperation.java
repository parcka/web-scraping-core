package tools;

import java.util.ArrayList;

/**
 * Created by XTR100 on 15/10/2016.
 */
public class NumberOperation {

    private ArrayList permutedList = new ArrayList();

    public ArrayList getPermutedNumber(String[] inputNumber) {
        permutedList = new ArrayList();


        String[] elementos = "a,b,c,d,e".split(",");
        int n = 3;                  //Tipos para escoger
        int r = inputNumber.length;   //Elementos elegidos
        permute(inputNumber, "", n, r);


        return permutedList;
    }

    private void permute(String[] elem, String act, int n, int r) {

        if (n == 0) {
            System.out.println(act);
            permutedList.add(act);
        } else {
            for (int i = 0; i < r; i++) {
                elem[i] = elem[i].trim();
               if (!act.contains(elem[i])) { // Controla que no haya repeticiones
                    permute(elem, act + elem[i], n - 1, r);
                }
            }
        }

    }
}
