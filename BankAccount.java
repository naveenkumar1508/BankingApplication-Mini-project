import java.util.Scanner;

class BankAccount{
    int balance;
    int previousTransaction;

    String customerName;
    String customerId;

    BankAccount(String cname, String cId){
        customerName = cname;
        customerId = cId;
    }


    void deposit(int amount){
        if(amount > 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withDraw(int amount){
        if(amount > 0 && balance > amount){
            balance = balance - amount;
            previousTransaction = -amount;

        }else{
            System.out.println("Insfficent Balance");

        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);
        }
        else if(previousTransaction < 0){
            System.out.println("withdrawn: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("No Transaction is occured");
        }
    }

    void showMenu(){
        char option = '\0';
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome " +customerName);
        System.out.println("Your ID is: " + customerId);
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. withdraw");
        System.out.println("D. previous Transaction");
        System.out.println("E. Exit");


        do{
            System.out.println("******************************************************");
            System.out.println("Enter the option");
            System.out.println("******************************************************");
            option = sc.next().charAt(0);
            //problem here!!!   a b c d e
            option = Character.toUpperCase(option);

            switch(option){
                case 'A':
                    System.out.println("******************************************************");
                    System.out.println("Balance is: " +balance);
                    System.out.println("******************************************************");
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("******************************************************");
                    System.out.println("Enter the amount to Deposit: ");
                    System.out.println("******************************************************");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("******************************************************");
                    System.out.println("Enter the amount to withdraw: ");
                    System.out.println("******************************************************");
                    int amount2 = sc.nextInt();
                    withDraw(amount2);
                    System.out.println();
                    break;

                case 'D':
                    System.out.println("******************************************************");
                    getPreviousTransaction();
                    System.out.println("******************************************************");
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("******************************************************");
                    break;

                default:
                    System.out.println("Invalid Option! please try again");
                    break;

            }

        }while(option != 'E');

    }
}
