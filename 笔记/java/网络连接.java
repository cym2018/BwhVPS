package xyz.cym2018.Tools;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class Connect {
    public static String CheckIn(String username, String password){
        String token= Login(username, password);
        if(token==null){return null;}
        String rec=Connect.Get("http://seat.ujn.edu.cn/rest/v2/checkIn?token="+token);
        assert rec != null;// TODO:处理null
        rec=rec.substring(rec.indexOf("message\"")+10);
        rec=rec.substring(0,rec.indexOf("\""));
        return username.substring(username.length()-3)+" "+rec;
    }
    public static String Login(String username, String password){
        String rec=Connect.Get("http://seat.ujn.edu.cn/rest/auth?username=" + username + "&password=" + password);
        if(rec==null){
            return null;
        }
        int start = rec.indexOf("token");
        if(start>0){
            return rec.substring(start + 8, start + 26);
        }
        return null;
    }
    public static String Get(String sUrl) {
        try {
            URL uUrl = new URL(sUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) uUrl.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            if (inputStream == null) {return null;}
            OutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[10240];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            return outputStream.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static  String Post(String form){
        try {
            URL url=new URL("http://seat.ujn.edu.cn/rest/v2/freeBook");
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length", ""+form.length());
            OutputStream outputStream=httpURLConnection.getOutputStream();
            outputStream.write(form.getBytes());
            outputStream.flush();
            InputStream inputStream=httpURLConnection.getInputStream();
            if (inputStream == null) {return null;}
            outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[10240];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            return outputStream.toString();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String GetSeat(String username,String password,String seat,String start,String end){
        String token=Login(username, password);
        String rec=Post("token=" + token + "&startTime=" + start + "&endTime=" + end + "&seat=" + seat + "&date=" + Time_Cal.getNextDate());
        if(rec==null)return null;
        if(rec.indexOf("message")>0){
            rec=rec.substring(rec.indexOf("message")+10);
            rec=rec.substring(0,rec.indexOf("\""));
            rec=username.substring(username.length()-3,username.length())+" "+rec;
        }
        //TODO:格式处理
        return rec;
    }
}
