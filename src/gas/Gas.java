/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author the owner
 */
public class Gas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("********************************GAS***********************************");
        System.out.println("You are welcome here ");
        System.out.println("Please go through the menu display below and follow the instruction carefully ");
        System.out.println("Select a menu by entering the figure before them");

        String select = "";
        do {
            Scanner input = new Scanner(System.in);
            Action act = new Action();
            System.out.println("Select your Menu by Entering the number in figure e.g 1 ");
            DisplayMenu();
            System.out.println("enter your menu number");
            select = input.nextLine();

            while (select.isEmpty()) {
                System.out.println("enter your menu number");
                select = input.nextLine();

            }

            char key = select.charAt(0);
            switch (key) {
                case '1':
                    //enter new Subscription
                    UserInput();

                    break;
                case '2':
                    //Display Summary of Subscription 

                    summaryOfSubscription();

                    break;
                case '3':
                    //Display Summary of Subscription for selected  month
                    SummaryByMonth();
                    break;
                case '4':
                    //Find and Display Subscription 
                    findDisplay();
                    break;
                case '5':
                    //exit 
                    System.out.println("Thank you for using this App BYE!!!!");
                    System.exit(0);
                    break;

                default:

                    System.out.println("Invalid number");

            }

        } while (!(select.contentEquals("5")));

//
//        DisplayMenu();
//
//        //Accept user input
//        UserInput();
//        System.out.println(act.getUsername());
//        //validation
//       String Sub = input.nextLine();
        //user name
    }

    //this function display Menu to the Screen
    public static void DisplayMenu() {

        System.out.println("1. Enter new Subscription");
        System.out.println("2. Display Summary of subscription");
        System.out.println("3. Display Summary of subscription for selected Month");
        System.out.println("4. Find and Display Subscription");
        System.out.println("5. Exit");

    }

    //This function allows user to create new subscription and process it 
    public static void UserInput() {

        //        String [] bronze ={"","6","","5","","4","","3"};
//     String [] Silver ={"","8","","7","","6","","5"};
//      String [] Gold ={"","9.99","","8.99","","7.99","","6.99"};
//
//        String [] Package1 ={"Bronze","Silver","Gold"};
        //creating new object
        Action act = new Action();

        //creates Scanner object
        Scanner inp = new Scanner(System.in);

        System.out.println("Please enter your full name");
        //this initialise username 
        act.setUsername(inp.nextLine());
        //checks if username input is empty
        while (act.getUsername().isEmpty()) {
            System.out.println("Your name is empty pls enter your name ");
            act.setUsername(inp.nextLine());

        }
        //checks if name length is not greter than 25
        while (!(act.NameValidation(act.getUsername()))) {
            System.out.println("The name you enter is greater than 25");
            act.setUsername(inp.nextLine());
        }

        // this set user package
        System.out.println("Please enter your Package");
        act.setPackage(inp.nextLine());
        //this check if package input is empty
        while (act.getPackage().isEmpty()) {
            System.out.println("Package is empty Please enter your package");
            act.setPackage(inp.nextLine());
        }
        //validate package 
        while (!((act.getPackage().equalsIgnoreCase("Bronze") || (act.getPackage().equalsIgnoreCase("Silver")) || (act.getPackage().equalsIgnoreCase("Gold"))))) {
            System.out.println("You have entered wrong package \n Please re-enter the package below");
            act.setPackage(inp.nextLine());
        }

        //this set user  discount code
        System.out.println("Please enter your Discount code");
        act.setDiscountCode(inp.nextLine());
        //this set the user payment term
        System.out.println("Please enter your full Payment Term One-off Subscription / Monthly Subscription");
        act.setPaymentTerm(inp.nextLine());
        //this  set the duration

        System.out.println("Please enter your Duration");
        act.setDuration(inp.nextLine());
        // this checks if duration input is empty
        while (act.getDuration().isEmpty()) {
            System.out.println("You have not entered Subscription Duration\nPlease enter your Subscription Duration");
            act.setDuration(inp.nextLine());
        }
        //validate Duration
        while (!((act.getDuration().equalsIgnoreCase("one") || (act.getDuration().equalsIgnoreCase("three")) || (act.getDuration().equalsIgnoreCase("six")) || (act.getDuration().equalsIgnoreCase("twelve"))))) {
            System.out.println("The Duration you entered is not available \n Please re-enter the Subscription Duration below");
            act.setDuration(inp.nextLine());
        }
        //this initialise subscription fee and validate 
        act.Validate(act.getPackage(), act.getDuration());
        //this validate payment term
        if ((act.paymentTermVal(act.paymentTerm))) {
            act.setPaymentTerm("one-off Subscription");
            act.setAmount(act.getAmount() * act.discount);
        } else {
            act.setPaymentTerm("monthly Subscription");
            act.setAmount(act.getAmount());
        }

//validate  package
//valdate name
//if( act.NameValidation(act.getUsername())){
//    act.setUsername(act.getUsername());
//    act.setPackage(act.getPackage());
//    act.Validate(act.getPackage(), act.getDuration());
//    act.setDuration(act.getDuration());
//    act.setDiscountCode(act.getDiscountCode());
        //System.out.println("amount  : " + act.getAmount());
//}else if(!(act.NameValidation(act.getUsername()))){
//    System.out.println("The name length is greater than 25");
//    System.out.println("Please enter your full name again");
//}
//         System.out.println("Customer's name : " + act.getUsername() );
//          System.out.println("Package's name : " + act.getPackage());
//           System.out.println("Discount code : " + act.getDiscountCode());
//            System.out.println("Term  : " + act.getPaymentTerm());
//            System.out.println("Duration  : " + act.getDuration());
//            System.out.println( act.getPaymentTerm()+" : " + act.getAmount());
        //this initialize date
        String date = getDate();
        //displays Summary to screen
        act.displaySummary(act.getUsername(), act.getPackage(), act.getDiscountCode(), act.getPaymentTerm(), act.getDuration(), act.getAmount(), date);
        //creates an inventory object 
        inventory inv = new inventory();
        //this get file name 
        String fileName = inv.getFile();
        //this set the object act and access its functions
        inv.setaction(act);
        try {
            //this save data to the text file
            inv.getSave(fileName, date, inv.getaction().getUsername(), inv.getaction().getPackage(), inv.getaction().getDiscountCode(), inv.getaction().getPaymentTerm(), inv.getaction().getDuration(), inv.getaction().getAmount());
        } catch (IOException e) {

        }

//            act.setUsername(inp.nextLine());
//           System.out.println("");
//           System.out.println( act.Validate(act.getPackage(), act.getDuration()));
//       }else if(!(act.NameValidation(act.getUsername()))){
//           System.out.println("The name length is greater than 25");
//           System.out.println("Please enter your full name again");
//            act.setUsername(inp.nextLine());
//       }else if((act.PackageVal(act.getPackage()))){
//           System.out.println("package name is not given ");
//           System.out.println("please enter package name ");
//           act.setPackage(inp.nextLine());
//       }else if(act.duration.equalsIgnoreCase("")){
//           System.out.println("duration is empty \n please enter duration below");
//        act.setDuration(inp.nextLine());
//       }else if(act.discountCode.equalsIgnoreCase("")){
//           System.out.println("Discount code is empty \n please enter discount code");
//        act.setDiscountCode(inp.nextLine());
//
//    }
//       else if(act.paymentTermVal(act.paymentTerm)){
//           act.setPaymentTerm("one-off Subscription");
//
//
//       }else{
//           act.setPaymentTerm("monthly subscription");
//           System.out.println(act.paymentTerm);
//       }
//
////             act.Validate(act.Package, act.duration );
//             System.out.println(act.getDuration());
//       // validate package
//       if(act.getPackage().equalsIgnoreCase("Bronze")){
//
//           if(act.getDuration().equalsIgnoreCase("one")){
//              act.setAmount(6.00);
//
//           }else if(act.getDuration().equalsIgnoreCase("three")){
//               act.setAmount(6.00-1.00);
//                System.out.println(act.getAmount());
//
//           }else if(act.getDuration().equalsIgnoreCase("six")){
//               act.setAmount(6.00-2.00);
//
//
//           }else if(act.getDuration().equalsIgnoreCase("twelve")){
//
//               act.setAmount(6.00-3.00);
//           }
//
//       }else if(act.getPackage().equalsIgnoreCase("Silver")){
//
//            if(act.getDuration().equalsIgnoreCase("one")){
//              act.setAmount(8.00);
//
//           }else if(act.getDuration().equalsIgnoreCase("three")){
//               act.setAmount(8.00-1.00);
//                System.out.println(act.getAmount());
//
//           }else if(act.getDuration().equalsIgnoreCase("six")){
//               act.setAmount(8.00-2.00);
//
//
//           }else if(act.getDuration().equalsIgnoreCase("twelve")){
//
//               act.setAmount(8.00-3.00);
//           }
//
//
//       }else if(act.getPackage().equalsIgnoreCase("Gold")){
//
//            if(act.getDuration().equalsIgnoreCase("one")){
//              act.setAmount(9.99);
//
//           }else if(act.getDuration().equalsIgnoreCase("three")){
//               act.setAmount(9.99-1.00);
//                System.out.println(act.getAmount());
//
//           }else if(act.getDuration().equalsIgnoreCase("six")){
//               act.setAmount(9.99-2.00);
//
//
//           }else if(act.getDuration().equalsIgnoreCase("twelve")){
//
//               act.setAmount(9.99-3.00);
//           }
//
//       }else{
//           System.out.println("Not Available");
//
//       }
    }
    //this method get date

    public static String getDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        return sdf.format(cal.getTime());
    }

    //this function the summary of subscription in yaer
    public static void summaryOfSubscription() {
        //creates object
        inventory inv = new inventory();

        System.out.println("Total number of Subscriptions: " + inv.getTotalSubYearly());
        System.out.println("Average Monthly Subscription : " + inv.getAveYearly());
        inv.getSubscription();
        inv.getPkgPercentage();
        System.out.println("Percentage of Subscriptions:");
        System.out.println("Bronze : " + inv.getBronze());
        System.out.println("Silver " + inv.getSilver());
        System.out.println("Gold " + inv.getGold());
        inv.getMonthlySub();
        System.out.println("Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec ");
        System.out.print(inv.getJan() + "   " + inv.getFeb() + "   " + inv.getMar() + "   " + inv.getApr() + "    " + inv.getMay() + "    " + inv.getJun() + "   " + inv.getJul() + "   " + inv.getAug() + "    " + inv.getSep() + "    " + inv.getOct() + "     " + inv.getNov() + "     " + inv.getDec());

    }

    //this function display summary of subscription of a certain month
    public static void SummaryByMonth() {
      //create an object of inventory
        inventory inv = new inventory();
        Scanner inp = new Scanner(System.in);
        System.out.println("Please enter the month in this format e.g 'Jan' ");
        inv.setKeyword(inp.nextLine());
         while (!((inv.getKeyword().equalsIgnoreCase("Jan"))||(inv.getKeyword().equalsIgnoreCase("Feb")) ||(inv.getKeyword().equalsIgnoreCase("Mar"))||(inv.getKeyword().equalsIgnoreCase("Apr"))|| (inv.getKeyword().equalsIgnoreCase("May"))|| (inv.getKeyword().equalsIgnoreCase("Jul"))|| (inv.getKeyword().equalsIgnoreCase("Aug"))|| (inv.getKeyword().equalsIgnoreCase("Sep"))||(inv.getKeyword().equalsIgnoreCase("Oct"))||(inv.getKeyword().equalsIgnoreCase("Nov"))||(inv.getKeyword().equalsIgnoreCase("Dec")))) {
            System.out.println("You have enter wrong info please try again");
            inv.setKeyword(inp.nextLine());
        }
        System.out.println("Select text file you want to search ");
        System.out.println("Enter 'S' for sample.txt or 'C' for current.txt ");
        inv.setFileS(inp.nextLine());
        while (inv.getFileS().isEmpty()) {
            System.out.println("You have not entered the file name");
             inv.setFileS(inp.nextLine());
        }
        
        while (!(inv.getFileS().equalsIgnoreCase("C")||(inv.getFileS().equalsIgnoreCase("S")))) {
            System.out.println("You have entered wrong format");
             inv.setFileS(inp.nextLine());
        }
        

        

        //validate file name
        switch (inv.getFileS()) {
            case "S":
                inv.setFileS("sample.txt");
                break;
            case "C":
                inv.setFileS("current.txt");
                break;
            default:
                System.out.println("Invalid key word");

        }

        //this open file and process the data
        inv.monthlySub(inv.getFileS(), inv.getKeyword());
        System.out.println("Total number of subscription " + inv.getMonthTotSub() + " for " + inv.getKeyword());
        System.out.println("Average Subscription fee : " + inv.getMonthAveSub());

//4

        System.out.println("Percentage of Subscriptions:");
        System.out.println("Bronze : " + inv.getBronze());
        System.out.println("Silver " + inv.getSilver());
        System.out.println("Gold " + inv.getGold());
    }
    //this displays summary of subscription of  data which match the given key

    public static void findDisplay() {
    //String  inv.getKeyword() ="";
      // String  file ="";
        inventory inv = new inventory();
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the keyword you want to search");
         inv.setKeyword(inp.nextLine());
        
        while(inv.getKeyword().isEmpty()) {
            System.out.println("You have not entered the Keyword yet");
            inv.setKeyword(inp.nextLine());
        }
        
         System.out.println("Select text file you want to search ");
        System.out.println("Enter 'S' for sample.txt or 'C' for current.txt ");
         inv.setFileS(inp.nextLine());
        while (inv.getFileS().isEmpty()) {
            System.out.println("You have not entered the file name");
             inv.setFileS(inp.nextLine());
        }
        
        while (!(inv.getFileS().equalsIgnoreCase("C")||(inv.getFileS().equalsIgnoreCase("S")))) {
            System.out.println("You have entered wrong format");
             inv.setFileS(inp.nextLine());
        }

        switch (inv.getFileS()) {
            case "S":
                inv.setFileName("sample.txt");
                break;
            case "C":
                inv.setFileName("current.txt");
            default:
                System.out.println("Invalid key word");
        }

        inv.findName(inv.getKeyword(), inv.getFileName());

    }

}
