package org.example;
import java.util.Scanner;

public class ConsoleGpay {
        public static void main(String[] args) {
            Gpay obj=new Gpay("Kirtan","143923","12345",2000.0f);
            System.out.println(obj.getName()+" "+obj.getAccnum()+" "+obj.getUpi()+" "+obj.getAccbal());
            System.out.println(obj.toString());
            obj.fundtransfer();
            obj.rechargemobile();
            obj.Fastagrecharge();
        }
    }
    class Gpay{
        private String name;
        private String accnum;
        private String upi;
        private Float accbal;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAccnum() {
            return accnum;
        }

        public void setAccnum(String accnum) {
            this.accnum = accnum;
        }

        public String getUpi() {
            return upi;
        }

        public void setUpi(String upi) {
            this.upi = upi;
        }

        public Float getAccbal() {
            return accbal;
        }

        public void setAccbal(Float accbal) {
            this.accbal = accbal;
        }

        public Gpay(String name,String accnum,String upi,Float accbal){
            this.name=name;
            this.accnum=accnum;
            this.upi=upi;
            this.accbal=accbal;

        }
        public void fundtransfer(){



            System.out.println("enter upi id");
            Scanner scanner = new Scanner(System.in);
            String Upi = scanner.nextLine();

            System.out.println("enter amount to be tranferred");
            Integer amt = scanner.nextInt();
            scanner.nextLine();
            System.out.println("enter name of the recipient");
            String reciver = scanner.nextLine();

            if (Upi.equals(this.upi)) {
                System.out.println(amt+" is transferred to "+reciver);
            }
            else{
                System.out.println("Invalid upi pin");
            }
        }

        @Override
        public String toString() {
            return "Gpay{" +
                    "name='" + name + '\'' +
                    ", accnum='" + accnum + '\'' +
                    ", upi='" + upi + '\'' +
                    ", accbal=" + accbal +
                    '}';
        }

        public void rechargemobile(){
            System.out.println("enter your mobile number:");
            Scanner scan = new Scanner(System.in);
            Long number = scan.nextLong();

            System.out.println("enter upi id");
            String Upi = scan.next();

            if (Upi.equals(this.upi))
                System.out.println(number+" is now recharged ");

            else System.out.println("Invalid upi pin");


        }
        public void Fastagrecharge(){
            System.out.println("enter your vehicle num:");
            Scanner scan = new Scanner(System.in);
            Integer number = scan.nextInt();

            System.out.println("enter upi id");
            String Upi = scan.next();

            if (Upi.equals(this.upi))
                System.out.println("recharged ");

            else System.out.println("Invalid upi pin");


        }


    }

