import entities.NumberLottery;
import org.jsoup.helper.StringUtil;
import tools.NumberOperation;
import tools.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by XTR100 on 12/10/2016.
 */
public class MainClass {


    public static void main(String[] args) {
        System.out.println("Prueba de Programa");

        Scraping scraping = new Scraping();
        ArrayList<NumberLottery> listNumberLotery = scraping.getScraping();


        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        NumberOperation numberOperation = new NumberOperation();
//        ArrayList permutas = numberOperation.getPermutedNumber(listNumberLotery.get(0).getNumberNight().split("-"));
        ArrayList permutas = numberOperation.getPermutedNumber(input.split("-"));

        for (String numberInPermutas :
                (ArrayList<String>) permutas) {

            for (NumberLottery numberLotery :
                    listNumberLotery) {

                numberLotery.getNumberMorning().split("-");

               if(StringUtils.getStringFromArray((numberLotery.getNumberMorning().split("-"))).equals(numberInPermutas)
                        || StringUtils.getStringFromArray((numberLotery.getNumberNight().split("-"))).equals(numberInPermutas)  ){

                   System.out.println(numberLotery.toString());
               }

            }


        }

//        System.out.println("LOS NUMEROS: " + scraping.getScraping().get(0).getNumberMorning().toString());
//        System.out.println("LAS PERMUTAS: " + permuta.toString());

    }


}
