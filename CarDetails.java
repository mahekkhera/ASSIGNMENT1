package assign1;

import java.util.Scanner;

class Car{
    int model;
    String type;
    float costPrice;
    boolean insuranceType;

    Car(int model, String type, float costPrice, boolean insuranceType){
        this.model= model;
        this.type= type;
        this.costPrice= costPrice;
        this.insuranceType= insuranceType;

        System.out.println("Model No: "+this.model+", Price: "+this.costPrice+", Insurance:"+getTotalInsurance(this.type, this.costPrice, this.insuranceType));
    }

    float getTotalInsurance(String carType, float costPrice, boolean isPremium){
        float premium=0;
        if(carType.equalsIgnoreCase("hatchback")){
            premium= calculatePercent(costPrice, 5);
        }
        else if(carType.equalsIgnoreCase("sedan")){
            premium= calculatePercent(costPrice, 8);
        }
        else if(carType.equalsIgnoreCase("suv")){
            premium= calculatePercent(costPrice, 10);
        }

        if(isPremium){
            float res= calculatePercent(premium, 20);
            premium+= res;
        }

        return premium;
    }

    float calculatePercent(float costPrice, int percent){
        float res=0;
        try{
            res=(costPrice*percent)/100;
        }
        catch (Exception e){
            System.out.println("Issue occurred: "+e);
        }

        return res;
    }
}

public class CarDetails {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        boolean ch= true;

        do {
            // Enter info about the car
            try{
                System.out.print("Enter the car model number: ");
                int carModel= sc.nextInt();
                sc.nextLine();

                System.out.print("Enter the name of the car: ");
                String carType= sc.nextLine();

                System.out.print("Enter the cost of the car: ");
                float carPrice= sc.nextInt();
                sc.nextLine();

                System.out.print("Enter 0 for Basic and 1 for Premium: ");
                int InsuranceType=sc.nextInt();

                boolean type= false;

                if(InsuranceType==1){
                    type= true;
                }
                else if(InsuranceType!=0){
                    System.out.println("Please enter either 0 or 1 in Insurance section");
                    return;
                }

                if(!(carType.equalsIgnoreCase("hatchback")||
                        carType.equalsIgnoreCase("sedan")||carType.equalsIgnoreCase("suv"))){
                    System.out.println("The Car Type has not been registered yet in the system");
                    return;
                }

                // creating an object of the class
                Car c1= new Car(carModel, carType, carPrice, type);

                System.out.print("Do you want to enter details of any other car (y/n): ");
                char op= sc.next().charAt(0);

                if(op=='n' || op=='N'){
                    ch=false;
                }

                System.out.println();

            }
            catch (Exception e){
                ch=false;
                System.out.println("Issue occurred: "+ e);
            }

        }while(ch);
    }
}