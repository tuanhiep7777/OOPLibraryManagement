/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author hiep.tt166077
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class testDate {
    
     public static void UpDownDate() {


        // Định dạng thời gian
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //"dd-MM-yyyy"


        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();


        // Định nghĩa mốc thời gian ban đầu là ngày 31-07-2011
        Date date = Date.valueOf("2011-07-31"); //"2011-07-31"


        c1.setTime(date);
        c2.setTime(date);


        System.out.println("Ngày ban đầu : " + dateFormat.format(c1.getTime()));
        
        c1.roll(Calendar.MONTH, 9);   //Tăng lên 2 tháng

        // Tăng ngày thêm 8 ngày -- Sử dụng phương thức roll()
        //-------------c1.roll(Calendar.DATE, 8);
        // c1.roll(Calendar.DATE, -8); // Giảm ngày 8 ngày ==> 23-07-2011
        System.out.println("Ngày được tăng thêm (Sử dụng Roll) : "
                + dateFormat.format(c1.getTime()));
        
        /* Các trường hợp khác
        c1.roll(Calendar.DATE, true); //Tăng 1 ngày -- Nếu muốn giảm một ngày truyền vào false
        c1.roll(Calendar.MONTH, 2);   //Tăng lên 2 tháng
        c1.roll(Calendar.YEAR, 2) ;      //Tăng lên 2 năm
        */


        // Tăng ngày thêm 8 ngày -- Sử dụng phương thức add()
        //-------c2.add(Calendar.DATE, 8);
        //c2.add(Calendar.DATE, -8); // Giảm ngày 8 ngày ==> 23-07-2011
        //---------System.out.println("Ngày được tăng thêm 8 ngày (Sử dụng add)  : "
                //---------+ dateFormat.format(c2.getTime()));


        /* Các trường hợp khác :
        c2.add(Calendar.MONTH, 2);   //Tăng lên 2 tháng
        c2.add(Calendar.YEAR, 2) ;      //Tăng lên 2 năm
        */
    }

     
     public static void ahihi(){
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-đ");

        Calendar c = Calendar.getInstance();
        c.setTime(java.sql.Date.valueOf("2018-05-10"));
        c.roll(Calendar.MONTH, 5);
         System.out.println(dateFormat.format(c.getTime()));
     }
    
    public static void main(String[] args){
        
//        Date d1 = new Date(2018, 1, 1);
//        Date d2 = new Date(2019, 1, 30);
//        long d = d2.getTime() - d1.getTime();
//        
//        long days_From_d1_to_d2 = d / 1000 / (3600 * 24) + 1;
//        System.out.println(days_From_d1_to_d2);
        
//        String str = "1999-09-09";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date d = new Date();//sdf.parse(str);
//        System.out.println(d);

          //java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
          //System.out.println(date.toString());
          
//          Date a = new Date(2010, 01, 01);
//          Date b = new Date(2010, 01, 02);
//          if (b.after(a))
//              System.out.println("ahihi");

            
            UpDownDate();
            //ahihi();
    }
}
