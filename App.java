
//import java.math.BigInteger;
import java.util.*;
// in this code admin and customer details are seperated .
// admin can login and enter the electricity or units consumed.
// user or customer can login to pay the bill or to check the remaining balance to pay
class  Values{
    private static double Amount;
    private static double Amountpaid;
    private static int Units;

    public  double getAmount() {
        return Amount;
    }

    public  void setAmount(double amount) {
        Amount = amount;
    }

    public  double getAmountpaid() {
        return Amountpaid;
    }

    public  void setAmountpaid(double amountpaid) {
        Amountpaid = amountpaid;
    }

    public int getUnits() {
        return Units;
    }

    public void setUnits(int units) {
        Units = units;
    }
}
public class App {
    public static void main(String[] args) throws Exception {


        Scanner sc = new Scanner(System.in);
        int value = 0;
        while (value != 3) {
            System.out.println("""
                    1)adminlogin
                    2)customerlogin in
                    3)cancel/exit
                    enter 1,2,3:\s""");
            value = Integer.parseInt(sc.nextLine());
            switch (value) {
                case 1 -> {
                    System.out.println("Adminlogin");
                    Admin admin = new Admin();
                    Admin.Adminlogin();
                }
                case 2 -> {
                    System.out.println("customerlogin");
                    Customer c = new Customer();
                    c.customerlogin();
                }
                case 3 -> System.out.println("exit");
                default -> System.out.println("invalid number");
            }
        }
    }

}
class Admin{
    public static void Adminlogin() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the User Name : ");
        String UserName = sc.nextLine();
        System.out.println("Enter the Password: ");
        String Password = sc.nextLine();

        if (UserName.equals("admin") && Password.equals("123")) {
            System.out.println("login completed");
            Adminpage();
        } else if (UserName.equals("admin2") && Password.equals("1234")) {
            System.out.println("login customer 2");
            Adminpage();
        } else if (UserName.equals("admin3") && Password.equals("12345")) {
            System.out.println("login customer 2");
            Adminpage();
        } else if (UserName.equals("admin4") && Password.equals("123456")) {
            System.out.println("login customer 2");
            Adminpage();
        } else {
            System.out.println("Incorrect Username or passowrd\n");
            System.out.println("Enter 1 to reenter password and username or any to back");
            int x = Integer.parseInt(sc.nextLine());
            if (x == 1) {
                Adminlogin();
            }

        }

    }
    public static void Adminpage() {
        System.out.println("Enter the units consumets for user");
        Values v=new Values();
        Bill b=new Bill();
        Scanner sc = new Scanner(System.in);
        int units = Integer.parseInt(sc.nextLine());
        v.setUnits(units);
        double Amount = b.BillAmount(units);
        v.setAmount(Amount);

    }
}
class Customer{
    public static void customerlogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the User Name : ");
        String UserName = sc.nextLine();
        System.out.println("Enter the Password: ");
        String Password = sc.nextLine();

        if (UserName.equals("user1") && Password.equals("123")) {
            System.out.println("login completed");
            customerpage();
        } else if (UserName.equals("user2") && Password.equals("1234")) {
            System.out.println("login customer 2");
            customerpage();
        } else if (UserName.equals("user3") && Password.equals("12345")) {
            System.out.println("login customer 2");
            customerpage();
        } else if (UserName.equals("user4") && Password.equals("123456")) {
            System.out.println("login customer 2");
            customerpage();
        } else if (UserName.equals("user5") && Password.equals("1234567")) {
            System.out.println("login customer 2");
            customerpage();
        } else {
            System.out.println("Incorrect Username or passowrd\n");
            System.out.println("Enter 1 to reenter password and username or any to back");
            int x = Integer.parseInt(sc.nextLine());
            if (x == 1) {
                Admin admin = new Admin();
                admin.Adminlogin();
            }

        }
    }

    public static void customerpage() {
        Values v=new Values();
        int units = v.getUnits();
        double Amount =v.getAmount();
        System.out.println("The electricity bill for " + units + " is : " + Amount);
        System.out.println("Enter you amount");
        Scanner sc = new Scanner(System.in);
        double Amountpaid = Integer.parseInt(sc.nextLine());
        v.setAmountpaid(Amountpaid);
        double balance = Amount - Amountpaid;
        Amount = balance;
        System.out.println("current balabce to pay" + balance);

    }
}

class Bill{
    public static double BillAmount(int units) {
        // declare and initialize variable units
        Values v=new Values();
        double Amount =v.getAmount();
        double Amountpaid = v.getAmountpaid();
        // variable to calculate electricity bill to pay
        double billToPay = 0;
        // check whether units are less than 100
        if (units < 100) {
            billToPay = units * 1.20;
        }
        // check whether the units are less than 300
        else if (units < 300) {
            billToPay = 100 * 10 + (units - 100) * 20;
        }
        // check whether the units are greater than 300
        else if (units > 300) {
            billToPay = 100 * 10 + 200 * 20 + (units - 300) * 32;
        }
        System.out.println("The electricity bill for " + units + " is : " + billToPay);
        try {
            if (Amount < Amountpaid) {
                throw new Exception("Current reading cannot be less than previous reading");
            }
            return billToPay;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}