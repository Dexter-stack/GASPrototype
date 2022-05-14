/*
 * To change this license heactioner, choose License Heactioners in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author the owner
 */
public class inventory {

    String filename = "current.txt";
    private double totalFee = 0;
    private double aveYearly = 0;
    private int totalNumberOfSubscription = 0;
    private double bronze = 0, gold = 0, silver = 0;
    private int jan = 0, Feb = 0, Mar = 0, Apr = 0, May = 0, Jun = 0, Jul = 0, Aug = 0, Sep = 0, Oct = 0, Nov = 0, Dec = 0;
    private int monthTotSub = 0;
    private double monthAveSub = 0;
    private Action action;
    private String file = "";
    private String fileS="";
    private String keyword="";

    public String getFileS() {
        return fileS;
    }

    public void setFileS(String fileS) {
        this.fileS = fileS;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    
    
    
    

    public Action getaction() {
        return action;
    }

    public void setaction(Action action) {
        this.action = action;
    }

    // this method get file name 
    public String getFile() {
        return filename;
    }

    // this method get bronze 
    public double getBronze() {
        return bronze;
    }

    // this method get silver
    public double getSilver() {
        return silver;
    }
    //this method get gold 

    public double getGold() {
        return gold;
    }

    /**
     *
     * @param filename
     * @param Date
     * @param name
     * @param pkg
     * @param DiscountCode
     * @param term
     * @param duration
     * @param amount
     * @return
     * @throws IOException
     *
     * this function takes in all the parameters and save them into the text
     * file
     */
    public String getSave(String filename, String Date, String name, String pkg, String DiscountCode, String term, String duration, double amount) throws IOException {
        int dur;
        String Dis;
        try {

            switch (duration) {
                case "one":
                    dur = 1;
                    break;
                case "three":
                    dur = 3;
                    break;
                case "six":
                    dur = 6;
                    break;
                case "twelve":
                    dur = 12;
                    break;
                default:
                    dur = 0;

            }

            if (DiscountCode.equals("")) {
                Dis = "-";
            } else {
                Dis = DiscountCode;
            }

//      File fle = new File(filename);
            //this open the file and write to it 
            PrintWriter outputFile = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
            outputFile.println(Date + "," + pkg.toUpperCase().charAt(0) + "," + dur + "," + Dis + "," + term.toUpperCase().charAt(0) + "," + amount + "," + name);
            outputFile.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;
    }

    // this display Subscripion Summary by reading the text file 
    public String getSubscription() {

        try {
//            System.out.println("hello ooo");
            Scanner fileName = new Scanner(new File(filename));
            while (fileName.hasNext()) {

                String amt = fileName.nextLine().split(",")[5];

                totalFee += Double.parseDouble(amt);
                totalNumberOfSubscription++;

            }

        } catch (IOException e) {

        }

        System.out.println("Total Subscription fee : " + totalFee);
        aveYearly = totalNumberOfSubscription / totalFee;
//         System.out.println("Total Subscriptions : " + totalNumberOfSubscription);

        return null;
    }

    // this method get total package subscriptions in year
    public int getTotalSubYearly() {
        return totalNumberOfSubscription;
    }

    // this method get Average Subscription in a year
    public double getAveYearly() {
        return aveYearly;
    }

    /**
     *
     * @return the method getPkgPercentage() open file and calculate the
     * percentage of each package in a year
     */
    public String getPkgPercentage() {

        try {

            Scanner fileName = new Scanner(new File(filename));
            while (fileName.hasNext()) {

                String amt = fileName.nextLine().split(",")[1];

                switch (amt) {
                    case "B":
                        bronze++;
                        break;
                    case "S":
                        silver++;
                        break;
                    case "G":
                        gold++;
                        break;
                    default:

                }

            }

        } catch (IOException e) {

        }

        bronze = (bronze * 100) / totalNumberOfSubscription;
        silver = (silver * 100) / totalNumberOfSubscription;
        gold = (gold * 100) / totalNumberOfSubscription;

        return null;
    }

    /**
     *
     * @return
     *
     * this function processed and display each month package subscription
     */
    public String getMonthlySub() {

        try {
            // +[A-Za-z]+-+\\d{4}
            Scanner fileName = new Scanner(new File(filename));
            while (fileName.hasNextLine()) {
                String yr = (fileName.nextLine().replaceAll("\\d{2}+-", "").split(",")[0]);
                String month = (yr.replaceAll("-+\\d{4}", "").split(",")[0]);
//                  System.out.println(month);

                switch (month) {
                    case "Jan":
                        jan++;
                        break;
                    case "Feb":
                        Feb++;
                        break;
                    case "Mar":
                        Mar++;
                        break;
                    case "Apr":
                        Apr++;
                        break;
                    case "May":
                        May++;
                        break;
                    case "Jun":
                        Jun++;
                        break;
                    case "Jul":
                        Jul++;
                        break;
                    case "Aug":
                        Aug++;
                        break;
                    case "Sep":
                        Sep++;
                        break;
                    case "Oct":
                        Oct++;
                        break;
                    case "Nov":
                        Nov++;
                        break;
                    case "Dec":
                        Dec++;
                        break;
                    default:

                }

            }
        } catch (IOException e) {

        }

        return null;
    }

    public int getJan() {
        return jan;
    }

    public int getFeb() {
        return Feb;
    }

    public int getMar() {
        return Mar;
    }

    public int getApr() {
        return Apr;
    }

    public int getMay() {
        return May;
    }

    public int getJun() {
        return Jun;
    }

    public int getJul() {
        return Jul;
    }

    public int getAug() {
        return Aug;
    }

    public int getSep() {
        return Sep;
    }

    public int getOct() {
        return Oct;
    }

    public int getNov() {
        return Nov;
    }

    public int getDec() {
        return Dec;
    }

    /**
     *
     * @param file
     * @param mth
     * @return
     *
     * this function read file and calculate the number of Subscriptions of a
     * certain months ,monthly average subscription and percentage of each
     * package in that certain month
     *
     */
    public String monthlySub(String file, String mth) {

        try {
            // +[A-Za-z]+-+\\d{4}
            //System.out.println("hhhhhhh");
            Scanner fileName = new Scanner(new File(file));
            while (fileName.hasNextLine()) {
//           String  yr = (fileName.nextLine().split(",")[5]);
//             String mt = fileName.nextLine().split(",")[0];
                //String month = (mt.replaceAll("-+\\d{4}", "").split(",")[0]);
//                  System.out.println(month);
                String[] yr = (fileName.nextLine().split(","));
                Action act = new Action();

                if (act.checkPackage(yr, mth)) {

                    totalFee += Double.parseDouble(yr[5]);
                    totalNumberOfSubscription += 1;

                }

                switch (yr[1]) {
                    case "B":
                        bronze++;
                        break;
                    case "S":
                        silver++;
                        break;
                    case "G":
                        gold++;
                        break;
                    default:

                }

//                  switch(month){
//                      case "Jan":
//                          jan++;
//                          break;
//                      case "Feb":
//                          Feb++;
//                          break;
//                      case "Mar":
//                          Mar++;
//                          break;
//                      case "Apr":
//                          Apr++;
//                          break;
//                      case "May":
//                          May++;
//                          break;
//                      case "Jun":
//                          Jun++;
//                          break;
//                      case "Jul":
//                          Jul++;
//                          break;
//                      case "Aug":
//                          Aug++;
//                          break;
//                      case "Sep":
//                          Sep++;
//                          break;
//                      case "Oct":
//                          Oct++;
//                          break;
//                      case "Nov":
//                          Nov++;
//                          break; 
//                      case "Dec":
//                          Dec++;
//                          break;
//                      default:
//                          
//                          
//                       
//                          
//                  }
//             
            }

        } catch (IOException e) {

        }

        monthTotSub = totalNumberOfSubscription;
        monthAveSub = totalFee / totalNumberOfSubscription;
        bronze = (bronze * 100) / totalNumberOfSubscription;
        silver = (silver * 100) / totalNumberOfSubscription;
        gold = (gold * 100) / totalNumberOfSubscription;

        return null;
    }

    //this function get month total package subscription
    public int getMonthTotSub() {
        return (monthTotSub);
    }

    // this function get month average package subscription 
    public double getMonthAveSub() {
        return monthAveSub;
    }

    /**
     *
     * @param key
     * @param file
     * @return this function search for any name from the file that matches the
     * key
     */
    public String findName(String key, String file) {
        try {

            Scanner fileName = new Scanner(new File(file));
            while (fileName.hasNextLine()) {
//           String  yr = (fileName.nextLine().split(",")[5]);
//             String mt = fileName.nextLine().split(",")[0];
                //String month = (mt.replaceAll("-+\\d{4}", "").split(",")[0]);
//                  System.out.println(month);
                Action act = new Action();
                String[] yr = (fileName.nextLine().split(","));

                if (act.checkPackage(yr, key)) {

//                          System.out.println(yr[6]);
                    //this create Action object to access displaySummary Function
                    //this diplay the summary subscription of Searched words
                    act.displaySummary(yr[6], yr[1], yr[3], yr[4], yr[2], Double.parseDouble(yr[5]), yr[0]);

                }
            }

        } catch (IOException e) {

        }
        return null;
    }

    public String getFileName() {
        return file;
    }

    public void setFileName(String file) {
        this.file = file;
    }

}
