package com.ksimeo.arsu.repository.controllers;

import com.ksimeo.arsu.core.models.User;
import com.ksimeo.arsu.repository.services.IUserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Ksimeo 09.11.2015.
 */
@Controller
public class UserController {
    @Autowired
    private IUserService userService;
    private ObjectMapper objectMapper = new ObjectMapper();


//    @RequestMapping(value = "/getuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE +
//            ";charset=UTF-8", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
//    @ResponseBody
//    public User getUserById(@RequestBody String jsonData) {
//        try {
//            ObjectMapper om = new ObjectMapper();
//            Map<String, String> usermap = om.readValue(jsonData, new TypeReference<Map<String, String>>() { });
//            System.out.println(usermap);
//            return new User(1, "Ars", "#1234", "Арсен", "Тумоян", true);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    @RequestMapping(value = "getuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public User getUser(@RequestBody String jsonData) {
        try {
            Map<String, String> datamap = objectMapper.readValue(jsonData, new TypeReference<Map<String, String>>() { });
            String login = datamap.get("login");
            String passw = datamap.get("password");
            User result = userService.getOne(login, passw);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "checkuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String checkUser(@RequestBody String jsonData) throws IOException {
        try {
            System.out.println(jsonData);
            Map<String, String> datamap = objectMapper.readValue(jsonData, new TypeReference<Map<String, String>>() { });
            System.out.println(datamap);
            String login = datamap.get("login");
            String passw = datamap.get("password");
            String res = userService.checkStatus("login", "password");
            System.out.println("Отправляемые данные:" + res);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        System.out.println("запрос получен!");
        return "NULL";
    }

    @RequestMapping(value = "/getallusers", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public List<User> getUsers() {
        return userService.getAll();
    }

//    @RequestMapping(value = "getuser", method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
//    @ResponseBody
//    public User getUser() throws IOException {
//        try {
//            ObjectMapper om = new ObjectMapper();
////            Map<String, String> datamap = om.readValue(jsonData, new TypeReference<Map<String, String>>() { });
////            String login = datamap.get("login");
////            String passw = datamap.get("password");
//            User res = userService.getOne("login", "passw");
////            String data = om.writeValueAsString(res);
//            System.out.println(res);
//            return res;
////            System.out.println(usermap);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}