package com.foxconn.license.service;

import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.*;

//https://github.com/jwtk/jjwt


public class License {
    Date GetExpDate(int year,int month,int date,int minute){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.getInstance().get(Calendar.YEAR)+year,
                Calendar.getInstance().get(Calendar.MONTH)+month,
                Calendar.getInstance().get(Calendar.DATE)+date,
                0,Calendar.getInstance().get(Calendar.MINUTE)+minute);//hours,minute,second
        Date expDate = new Date(cal.getTimeInMillis());
        //System.out.println(formatter.format(expDate));
        return  expDate;
    }
    String GetToken(Date expDate,Map map,Key key){

        JwtBuilder jw = Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(expDate)
                .signWith(key);

        for(Object entryKey:map.keySet()){
            jw.claim(entryKey.toString(),map.get(entryKey));
        }

        String jwt = jw.compact();
        return jwt;
    }
    Map VerifyKey(Key key,String jwt){
        try {
            Jws<Claims> data;
            data = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt);
            Map<String, Object> payload = new HashMap<>(data.getBody());
            return payload;
        }
        catch (JwtException e) {
            System.out.println(e);
            return new HashMap();
        }
    }
    Map VerifyStringKey(String key,String jwt){
        try {
            SecretKey secretKey =new SecretKeySpec(key.getBytes(), "HmacSHA256");
            Jws<Claims> data;
            data = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(jwt);
            Map<String, Object> payload = new HashMap<>(data.getBody());
            return payload;
        }
        catch (JwtException e) {
            return null;
        }
    }
    boolean WriteTokenFile (String jwt,String path){
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(jwt);
            fileWriter.write("\n");
            fileWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println("WriteTokenFile fail");
            return false;
        }
    }
    String ReadTokenFile(String path){
        try {
            FileReader fileReader = new FileReader(path);
            char [] chars = new char[1024];
            fileReader.read(chars);
            fileReader.close();

            StringBuilder sb = new StringBuilder();
            for(char c:chars){
                if(c!=0)
                    sb.append(c);
            }
            String token = sb.toString();
            return token;
        } catch (Exception e) {
            System.out.println("ReadTokenFile fail");
            return null;
        }
    }
    public static void main(String[] args) throws IOException {
        License license = new License();
        // Produce by FXN
        Date date = license.GetExpDate(1,6,0,0);
        //number of switch, controller mac
//        ArrayList hosts = new ArrayList<String>();
//        hosts.add("mac1");
//        hosts.add("mac2");
//        hosts.add("mac3");
        HashMap hm = new HashMap();
//        hm.put("hosts", hosts);
        hm.put("Mac", "08:00:27:ce:50:33");
        hm.put("switchNum", "10");



        // create new key
        //SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        // create with exit key
        //fy6RBaOK9sRj7vXiw7aKxCPMhNikbPRO+5LcAsPhwic=

        SecretKey key =new SecretKeySpec("fy6RBaOK9sRj7vXiw7aKxCPMhNikbPRO+5LcAsPhwic=".getBytes(), "HmacSHA256");

        // get base64 encoded version of the key
        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());

        //System.out.println("Key: "+encodedKey);
        String jwt = license.GetToken(date,hm,key);
        license.WriteTokenFile(jwt,"License.txt");



        // Consume by Client ONOS

        String token = license.ReadTokenFile("License.txt");

        Map payload = license.VerifyKey(key,token);
        System.out.println(payload);
        //String[] command = { "cmd", "/c", "java -jar VerifyStringKey.jar "+key+" "+token};
//        String[] command = { "cmd", "/c", "echo "+token};
//
//        try {
//            Process proc = Runtime.getRuntime().exec(command);
//            InputStream in = proc.getInputStream();
//            String payload = new String(in.readAllBytes());
//            System.out.println("payload: "+payload);
//        }catch (Exception e){
//            System.out.println("error");
//        }




    }
}
