package controller;

import entities.NumberLottery;
import tools.FileUtils;
import tools.NumberOperation;
import tools.StringUtils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by XTR100 on 11/11/2016.
 */
public class ProcessController {

    public ArrayList<NumberLottery> getListNumberFromNumber(String Number) {
        ArrayList<NumberLottery> numberLotteryPermutedList = new ArrayList<NumberLottery>();
        String path = "E:\\CARPETA_PRUEBAS\\prueba.txt";
        FileUtils fileUtils = new FileUtils(path);

        ArrayList<NumberLottery> numberLotteryFromFileList = fileUtils.readNumberLotteryFromFile();

        //Scanner scanner = new Scanner(System.in);
        String input = Number;

        NumberOperation numberOperation = new NumberOperation();

        ArrayList permutas = numberOperation.getPermutedNumber(input);

        for (String numberInPermutas :
                (ArrayList<String>) permutas) {

            for (NumberLottery numberLotery :
                    numberLotteryFromFileList) {

                numberLotery.getNumberMorning().split("-");

                if (StringUtils.getStringFromArray((numberLotery.getNumberMorning().split("-"))).equals(numberInPermutas)
                        || StringUtils.getStringFromArray((numberLotery.getNumberNight().split("-"))).equals(numberInPermutas)) {
                    numberLotteryPermutedList.add(numberLotery);
                    System.out.println(numberLotery.toString());
                }

            }


        }

        return numberLotteryPermutedList;
    }

    public ArrayList<NumberLottery> getAllNumbers() {
        ArrayList<NumberLottery> numberLotteryPermutedList = new ArrayList<NumberLottery>();
        String path = "E:\\CARPETA_PRUEBAS\\prueba.txt";
        FileUtils fileUtils = new FileUtils(path);

        ArrayList<NumberLottery> numberLotteryFromFileList = fileUtils.readNumberLotteryFromFile();

        return numberLotteryFromFileList;
    }


}
