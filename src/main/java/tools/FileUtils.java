package tools;

import entities.NumberLottery;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by XTR100 on 09/11/2016.
 */
public class FileUtils {

    String path;

    public FileUtils(String path) {
        this.path = path;
    }

    public void createFile() {
        createFile(path);
    }

    public void createFile(String path) {
        try {
            File file = new File(path);

            BufferedWriter bw;
            if (file.exists()) {
                System.out.println("El fichero de texto ya estaba creado.");
            } else {
                file.createNewFile();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void writeNumberLotteryInFile(ArrayList<NumberLottery> numberLotteryArrayList) {
        try {
            File file = new File(path);


            if (file.exists()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(numberLotteryArrayList);
                objectOutputStream.close();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }finally {

        }



    }

    public ArrayList<NumberLottery> readNumberLotteryFromFile() {

        ArrayList<NumberLottery> numberLottery = new ArrayList<NumberLottery>();

        try {
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

            while (true) {
                numberLottery = (ArrayList<NumberLottery>) objectInputStream.readObject();
                System.out.println("EL OBJECTO ES: " + numberLottery);

            }


        } catch (EOFException eof) {
            System.out.println("EOF");
            return numberLottery;
        } catch (Exception e) {
            System.out.println("EOF");
        }

        return null;
    }


}
