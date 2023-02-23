package org.example;





import com.sun.org.apache.xpath.internal.objects.XString;


public class Encapsulation {

        public static void main(String[] args) {

            customer deposits=new customer();

            deposits.openDeposits();

        }

    }


// Inner Class as local member

    class customer{

        public void openDeposits(){

            //int loanNumber=123;

            class request{

                private String customerName;

                private int PAN;

                private long Aadhaar;

                private String profession;

                private int cibil;

                private long contact;


                public String request() {

                    return customerName;


                }


                public void setCustomerName(String customerName) {

                    this.customerName = customerName;

                }


                public String getCustomerName() {

                    return customerName;

                }


                public void setProfession(String profession ) {

                    this.profession = profession;

                }

                public String getProfession(){

                    return profession;

                }


                public  long getAadhaar() {

                    return Aadhaar;

                }


                public void setAadhaar(int Aadhaar) {

                    this.Aadhaar = Aadhaar;

                }

                public void setCibil(int cibil){

                    this.cibil=cibil;

                }

                public int getCibil(){

                    return cibil;

                }


                public int getPAN() {

                    return PAN;

                }


                public void setPAN(int PAN) {

                    this.PAN = PAN;

                }


                // constructor overloading


                // default constructor

                public request(){}

                // parameterized constructor

                public request(String customerName,  int PAN,int Aadhaar,String profession,int cibil,int contact)

                {

                    this.customerName=customerName;

                    this.PAN=PAN;

                    this.Aadhaar=Aadhaar;

                    this.profession=profession;

                    this.cibil=cibil;

                    this.contact=contact;

                }

            }

            request fixed=new request();

            fixed.setCustomerName("Kirthan");

            fixed.setPAN(12345678);

            fixed.setAadhaar(719623);

            fixed.setProfession("doctor");


            System.out.println(fixed.getCustomerName()+" "+fixed.getAadhaar()+"  "+fixed.getCibil());


            request fde=new request("Arun",12345678,719623,"doctor",74884,5984);


            System.out.println(fde.getAadhaar()+" "+fde.getPAN()+" "+fde.getCustomerName());

            System.out.println("request for loan received");

        }

    }



