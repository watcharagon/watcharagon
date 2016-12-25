package testexam.dev;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
public class test_salsry {
    public static void main(String[] args) throws IOException, FileNotFoundException, UnsupportedEncodingException, ParseException {
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream("F:\\Exam-DEV\\1.working_time.log"), "TIS-620"));
        try {
            BufferedReader br = new BufferedReader(file);
            String line;
            int n = 1;
            while ((line = br.readLine()) != null) {
                String[] l = line.split("\\|");
                if (l.length == 5) {
                    System.out.println("ลำดับ : " + n++);
                    System.out.println("ชื่อ : " + l[0]);
                    try {
                        DateFormat Dateft = new SimpleDateFormat("hh:mm");
                        DateFormat Datefd = new SimpleDateFormat("dd/mm/yyyy");

                        Date date = Dateft.parse(l[2]);
                        Date date2 = Dateft.parse(l[4]);
                        Date date3 = Datefd.parse(l[1]);
                        Date date4 = Datefd.parse(l[3]);
                        String dayin = Datefd.format(date3);
                        String dayout = Datefd.format(date4);
                        System.out.println("วันที่เข้าทำงาน : " + dayin);
                        String timein = Dateft.format(date);
                        System.out.println("เวลาเข้างาน " + timein + " น.");
                        System.out.println("วันที่ออกทำงาน : " + dayout);
                        String timeout = Dateft.format(date2);
                        System.out.println("เวลาออกงาน " + timeout + " น.");
                        double   d = money(date, date2);
                        System.out.println("ค่าแรง/วัน : " + d + " บาท");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("******************************");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static double money(Date date, Date date2) {
        double time = date2.getTime() - date.getTime();
        double sum =0;
        double Money_D2 = 290/8;
        
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(0);
        nf.setRoundingMode(RoundingMode.HALF_UP);
        int hour = Integer.parseInt(nf.format(time/(1000*60*60)));
        
        sum = sum + (hour/24)*290;
        if(hour >= 8){
        hour = (hour-1)%24;
        }
        if(hour <= 8) sum = hour*Money_D2;
        else sum = hour*Money_D2;
        System.out.println("ชั่วโมงทำงาน : "+hour+" ชั่วโมง");
        return sum;
    }
}