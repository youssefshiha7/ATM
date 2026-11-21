import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        System.out.println("Dear Customer kindly enter your pin to access your account");
        while (true) {
            Scanner sc = new Scanner(System.in);
            int pin = sc.nextInt();
            if(pin ==1234){
                double balance = 2500.75;
                do {
                    System.out.println("""
                        ========= ATM =========
                        1. Check Balance
                        2. Deposit
                        3. Withdraw
                        4. Show Account Status
                        5. Exit
                        =======================""");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1 -> {
                            System.out.println("Your current balance is: " + balance);
                        }
                        case 2 -> {
                            System.out.println("Enter the amount to deposit: ");
                            double depositAmount = sc.nextDouble();
                            if(depositAmount > 0){
                                balance += depositAmount;
                                System.out.println("Deposit successful. New balance: " + balance);
                            }else{
                                System.out.println("Invalid deposit amount");
                            }
                        }
                        case 3 -> {
                            System.out.println("Enter the amount to withdraw: ");
                            double withdrawAmount = sc.nextDouble();
                            if(withdrawAmount > 0){
                                if(balance >= withdrawAmount){
                                    balance -= withdrawAmount;
                                    if(balance ==0){
                                        System.out.println("Warning: Your account is empty");
                                    }
                                    System.out.println("Withdraw successful. New balance: " + balance);
                                }else{
                                    System.out.println("insufficient balance");
                                }
                            }else{
                                System.out.println("Invalid withdraw amount");
                            }

                        }
                        case 4 -> {
                            if(balance >= 5000){
                                System.out.println("Your account status is: VIP Customer");
                            } else if (1000 <= balance && balance < 5000) {
                                System.out.println("Your account status is: Regular Customer");
                            } else {
                                System.out.println("Your account status is: Low Balance");
                            }
                        }
                        case 5 -> {
                            System.out.println("Exiting...");
                            count=5;
                        }
                    }
                }while (count!=5);
                System.out.println("Thank you for using our ATM.");
                break;


            }else{
                count++;
                if(count >= 3){
                    System.out.println("Your account has been Blocked");
                    break;
                }else{
                    System.out.println("Invalid pin. Please try again.");
                }
            }
        }
    }
}
