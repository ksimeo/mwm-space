package com.ksimeo.arsu.admin.services.impl;

import com.ksimeo.arsu.admin.services.IUserService;
import com.ksimeo.arsu.admin.services.impl.toSend.RestSender;
import com.ksimeo.arsu.entities.models.User;
import org.codehaus.jackson.map.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by @author Ksimeo on 15.01.2016 at 17:26. For project: MArsMarketSpace.
 */
//@Service
public class UserService implements IUserService {
    private RestSender restSender;

    private ObjectMapper om;

    public UserService() {
        restSender = new RestSender("http://localhost:9090");
        om = new ObjectMapper();
    }

    @Override
    public User getUser(String login, String password) throws Exception {
        Map<String,String> logPassw = new HashMap<>();
        logPassw.put("login", login);
        logPassw.put("password", password);
        String recivedData = restSender.doPOST("/getuser", om.writeValueAsString(logPassw));
        return om.readValue(recivedData, User.class);
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void addUser(User newUser) {

    }

    @Override
    public void delUser(int id) {

    }

    @Override
    public boolean isPasswCorrect(String passw) {
        return false;
    }

    @Override
    public void setNewPassw(String passw) {

    }

    @Override
    public void saveUser(User user) {

    }

    public static void main(String[] args) {
//        Map<String,String> logPassw = new HashMap<>();
//        System.out.println("готовимся!");
//        logPassw.put("login", "Ars");
//        logPassw.put("password", "#1234");
//        RestSender rs = new RestSender("http://localhost:9090");
//        try {
//            ObjectMapper objMap = new ObjectMapper();
//            System.out.println("маппим!");
//            String data = objMap.writeValueAsString(logPassw);
//            System.out.println("пытаемся отправить!");
//            String recivedData = rs.doGET("/test");
//            System.out.println("полученный ответ:" + recivedData);
////            User user = objMap.readValue(recivedData, User.class);
//        } catch (Exception e) {
//            System.out.println("неудача!");
//            e.printStackTrace();
//        }
        Map<String,String> logPassw = new HashMap<>();
        System.out.println("готовимся!");
        logPassw.put("login", "Арсен");
        logPassw.put("password", "#1234");
        ObjectMapper objMap = new ObjectMapper();
        RestSender rs = new RestSender("http://localhost:9090");
        try {
            String data = objMap.writeValueAsString(logPassw);
            String recData = rs.doPOST("/checkuser", data);
//            String recData = rs.doGET("/user");
            System.out.println("входящий поток:" + recData);
//            User usr =  objMap.readValue(recData, User.class);
//            System.out.println("Полученный пользователь: " + usr);
        } catch (Exception e) {
            System.out.println("Неудача!");
            e.printStackTrace();
        }

    }

//    private String sendGet(String url) throws Exception {
//        URL obj = new URL(url);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//        // optional default is GET
//        con.setRequestMethod("GET");
//        int responseCode = con.getResponseCode();
//        System.out.println("\nSending 'GET' request to URL : " + url);
//        System.out.println("Response Code : " + responseCode);
//        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//        String inputLine;
//        StringBuffer response = new StringBuffer();
//        while ((inputLine = in.readLine()) != null) {
//            response.append(inputLine);
//        }
//        in.close();
//        return response.toString();
//    }
}
