import entities.NumberLottery;
import tools.FileUtils;

/**
 * Created by XTR100 on 09/11/2016.
 */
public class MainTest {

    public static void main(String[] args) {
        String path = "E:\\CARPETA_PRUEBAS\\prueba.txt";
        FileUtils fileUtils = new FileUtils(path);

        fileUtils.readNumberLotteryFromFile();

  /*      //fileUtils.createFile(path);

        NumberLottery numberLottery = new NumberLottery();
        numberLottery.setNumberNight("234");
        numberLottery.setNumberMorning("234");
        numberLottery.setDate("10-10-2016");

        fileUtils.writeNumberLotteryInFile(numberLottery);*/


    }
}
