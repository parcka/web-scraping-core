import entities.NumberLottery;
import org.jsoup.helper.StringUtil;
import tools.FileUtils;
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

        //CARGO MI ARCHIVO CON MI LISTA DE NUMEROS
        String path = "E:\\CARPETA_PRUEBAS\\prueba.txt";
        FileUtils fileUtils = new FileUtils(path);

       ArrayList<NumberLottery> numberLotteryArrayList = fileUtils.readNumberLotteryFromFile();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

  /*      for (NumberLottery number :
                numberLotteryArrayList) {
            System.out.println("NUMERO: "+ number);
        }*/




       NumberOperation numberOperation = new NumberOperation();

        ArrayList permutas = numberOperation.getPermutedNumber(input);

        for (String numberInPermutas :
                (ArrayList<String>) permutas) {

            for (NumberLottery numberLotery :
                    numberLotteryArrayList) {

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
