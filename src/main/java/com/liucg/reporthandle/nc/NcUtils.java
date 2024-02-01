package com.liucg.reporthandle.nc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class NcUtils {
    public static String organizations_qjny = "100,70,80,90,91,92,94,95,96,97,98,99,81,82";
    //	static BaseBean baseBean = new BaseBean();
    public static String doAdd(String a, String b){
        return (new BigDecimal(a)).add((new BigDecimal(b))).setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }
    public static String doAdd(String a, String b,String c, String d){
        BigDecimal result = new BigDecimal(0);
//		baseBean.writeLog("aaaaaaaaaa" + a + "===8888");
        if(a != null && !("").equals(a))
//			baseBean.writeLog("aaaaaaaaaa" + a + "===" + new BigDecimal(a));
            result = result.add(new BigDecimal(a));
        if(b != null && !("").equals(b))
            result = result.add(new BigDecimal(b));
        if(c != null && !("").equals(c))
            result = result.add(new BigDecimal(c));
        if(d != null && !("").equals(d))
            result = result.add(new BigDecimal(d));

        return result.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
    }


    public static String txt2String(String file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File(file)));
            String s = null;
            while((s = br.readLine())!=null){
                result.append(s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
    //获取当前日期
    @SuppressWarnings("static-access")
    public static String getNowDate(int day){
        Date date=new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,day);
        date=calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        return dateString;
    }
    //获取本年日期
    public static String getOaApprovedDate(){
        Format f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar curr = Calendar.getInstance();
        Date thisdate = curr.getTime();
        curr.set(Calendar.YEAR, curr.get(Calendar.YEAR) + 1);
        return  f.format(thisdate);
    }
    public static String getOaNextApproveDate(){
        String OaApprovedDate = getOaApprovedDate();
        String OaNextApproveDate = "";
        int year = Integer.parseInt(OaApprovedDate.substring(0, 4));
        OaNextApproveDate = String.valueOf((year + 1)) + "-09-30";
        return OaNextApproveDate;
    }


}
