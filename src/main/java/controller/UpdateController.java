package controller;

import entities.NumberLottery;
import tools.Scraping;

import java.util.ArrayList;

/**
 * Created by XTR100 on 11/11/2016.
 */
public class UpdateController {

    Scraping scraping = new Scraping();
    ArrayList<NumberLottery> listNumberLotery = scraping.getScraping();


}
