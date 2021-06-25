import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class KYC {

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat sdformat= new SimpleDateFormat("dd-MM-yyyy");

    public String rangeOfDatesForKYC(Date signUpDate,Date currentDate){
        calendar.setTime(currentDate);
        int currentYear = calendar.get(Calendar.YEAR);
        calendar.setTime(signUpDate);
        calendar.set(Calendar.YEAR, currentYear);
        Date currentAnniversary = calendar.getTime();
        calendar.add(Calendar.MONTH,1);
        Date maxDate = calendar.getTime();
        calendar.add(Calendar.MONTH,-2);
        Date minDate = calendar.getTime();
        return sdformat.format(minDate)+ " " + (currentDate.compareTo(maxDate)>0? sdformat.format(maxDate):sdformat.format(currentDate));
    }
    public static void main(String[] args) {
	// write your code here
        try{
            SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");
            Scanner sc = new Scanner(System.in);
            KYC obj = new KYC();
            int n = sc.nextInt();
            sc.nextLine();
            while (n-- >0){
                String date[] = sc.nextLine().split(" ");
                Date signUpDate = sdformat.parse(date[0]);
                Date currentDate = sdformat.parse(date[1]);
                if(currentDate.compareTo(signUpDate)<=0){
                    System.out.println("No range");
                }
                else {
                    System.out.println(obj.rangeOfDatesForKYC(signUpDate, currentDate));
                }
            }
        }
        catch (Exception e){
            System.out.println("Error Occured at reading Input");
            e.printStackTrace();
        }
    }
}
