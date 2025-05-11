
    //task1 -> temperature converter
    // This class will handle temperature conversion between Celsius and Fahrenheit.
    //logic
    //F=9/5*C+32
    //C=5/9(F-32)
    
    import java.util.Scanner;
    public class temperature_converter {
    
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            //asking for current unit
            System.out.println("Enter the current unit(C or F)");
            String fromunit = input.next().toUpperCase();
            //asking for target unit
            System.out.println("Enter the unit to convert to ( C or F)");
            String tounit = input.next().toUpperCase();
            //asking for temperature value
            System.out.println("enter the temparature value");
            Double temp = input.nextDouble();
            //conversion
            if (fromunit.equals("F")&& tounit.equals("C")){
                double converted = (temp + 9/5)+32;
                System.out.println(temp+"F="+converted+"C");
            
            }
            else if (fromunit.equals("C")&&tounit.equals("F")) {
                double converted = (temp-32)*temp;
                System.out.println(temp+"C"+converted+"F");

            }
            else if (fromunit.equals(tounit)) {
                System.out.println("Both units are same No conversion needed. ");
            }
            else{
                System.out.println("Invalid input please Enter C or F. ");
            }
            input.close();
        }
    }

