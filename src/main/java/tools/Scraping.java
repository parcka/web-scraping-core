package tools;

import java.io.IOException;
import java.util.ArrayList;

import entities.NumberLottery;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

/**
 * Created by XTR100 on 12/10/2016.
 */

public class Scraping {


    public static final String url = "http://www.flalottery.com/site/winningNumberSearch?searchTypeIn=range&gameNameIn=PICK3&singleDateIn=&fromDateIn=09%2F01%2F2015&toDateIn=10%2F11%2F2016&n1In=&n2In=&n3In=&submitForm=Submit";


  /*  public static void main(String args[]) {

        // Compruebo si me da un 200 al hacer la petición
    *//*    if (getStatusConnectionCode(url) == 200) {

            // Obtengo el HTML de la web en un objeto Document
            Document document = getHtmlDocument(url);

            // Busco todas las historias de meneame que estan dentro de:
            Elements entradas = document.select("div.col-md-4.col-xs-12").not("div.col-md-offset-2.col-md-4.col-xs-12");

            Elements allNumberSection = document.getElementsByClass("winningNumbersResults");

            Elements tableWhitNumbers = allNumberSection.get(0).getElementsByTag("table");

            Elements bodyTable = tableWhitNumbers.get(0).getElementsByTag("tbody");
            Elements divDataElements = bodyTable.get(0).getElementsByTag("div");

            for (Element element :
                    bodyTable.get(0).getElementsByTag("div")) {
                TextNode textNode = (TextNode) element.childNode(0);
                textNode.attributes().get("text");
            }

            int count = 1;
            ArrayList allDayNumberList = new ArrayList();
            for (int i = 0; i < divDataElements.size() - 1; i++) {
                Element element = bodyTable.get(0).getElementsByTag("div").get(i);
                allDayNumberList.add(element.childNode(0).attributes().get("text"));

                if (count == 3) {
                    System.out.println("Numeros de la LOTERIA: " + allDayNumberList.toString());
                    count = 1;
                    allDayNumberList.clear();
                } else {
                    count++;
                }
            }


            Element elementFromBodyTable;




            // Paseo cada una de las entradas
            for (org.jsoup.nodes.Element elem : entradas) {
                String titulo = elem.getElementsByClass("tituloPost").text();
                String autor = elem.getElementsByClass("autor").toString();
                String fecha = elem.getElementsByClass("fecha").text();

                System.out.println(titulo + "\n" + autor + "\n" + fecha + "\n\n");

                // Con el método "text()" obtengo el contenido que hay dentro de las etiquetas HTML
                // Con el método "toString()" obtengo todo el HTML con etiquetas incluidas
            }

        } else
            System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(url));*//*

    }*/


    /**
     * Con esta método compruebo el Status code de la respuesta que recibo al hacer la petición
     * EJM:
     * 200 OK					300 Multiple Choices
     * 301 Moved Permanently	305 Use Proxy
     * 400 Bad Request			403 Forbidden
     * 404 Not Found			500 Internal Server Error
     * 502 Bad Gateway			503 Service Unavailable
     *
     * @param url
     * @return Status Code
     */
    public static int getStatusConnectionCode(String url) {

        Response response = null;

        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }
        return response.statusCode();
    }


    /**
     * Con este método devuelvo un objeto de la clase Document con el contenido del
     * HTML de la web que me permitirá parsearlo con los métodos de la librelia JSoup
     *
     * @param url
     * @return Documento con el HTML
     */
    public static Document getHtmlDocument(String url) {

        Document doc = null;

        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
        }

        return doc;

    }

    public ArrayList<NumberLottery> getScraping() {
        ArrayList<NumberLottery> allNumberLottery = new ArrayList<NumberLottery>();
        if (getStatusConnectionCode(url) == 200) {

            // Obtengo el HTML de la web en un objeto Document
            Document document = getHtmlDocument(url);

            // Busco todas las historias de meneame que estan dentro de:
            Elements entradas = document.select("div.col-md-4.col-xs-12").not("div.col-md-offset-2.col-md-4.col-xs-12");

            Elements allNumberSection = document.getElementsByClass("winningNumbersResults");

            Elements tableWhitNumbers = allNumberSection.get(0).getElementsByTag("table");

            Elements bodyTable = tableWhitNumbers.get(0).getElementsByTag("tbody");
            Elements divDataElements = bodyTable.get(0).getElementsByTag("div");

            for (Element element :
                    bodyTable.get(0).getElementsByTag("div")) {
                TextNode textNode = (TextNode) element.childNode(0);
                textNode.attributes().get("text");
            }

            int count = 1;
            NumberLottery numberLottery = null;
            ArrayList allDayNumberList = new ArrayList();
            for (int i = 0; i < divDataElements.size() - 1; i++) {

                Element element = bodyTable.get(0).getElementsByTag("div").get(i);
                String data = element.childNode(0).attributes().get("text");
                allDayNumberList.add(element.childNode(0).attributes().get("text"));


                if (count == 1) {
                    numberLottery = new NumberLottery();
                    numberLottery.setDate(data);
                    count++;
                } else if (count == 2) {
                    numberLottery.setNumberMorning(data);
                    count++;
                } else if (count == 3) {
                    numberLottery.setNumberNight(data);
                    System.out.println("Numeros de la LOTERIA: " + allDayNumberList.toString());
                    count = 1;
                    allDayNumberList.clear();
                    allNumberLottery.add(numberLottery);
                }


            }


            Element elementFromBodyTable;


            // Paseo cada una de las entradas


        } else
            System.out.println("El Status Code no es OK es: " + getStatusConnectionCode(url));
        return allNumberLottery;
    }
}


