package com.ksimeo.arsu.repository.controllers;

import com.ksimeo.arsu.entities.models.User;
import com.ksimeo.arsu.repository.dao.UserDao;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private UserDao userDao;
    private ObjectMapper objectMapper = new ObjectMapper();

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "getuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public User getUser(@RequestBody String jsonData) {
        try {
            Map<String, String> datamap = objectMapper.readValue(jsonData, new TypeReference<Map<String, String>>() { });
            String login = datamap.get("login");
            logger.debug("got login: {}", login);
            String passw = datamap.get("password");
            User res = userDao.getOne(login, passw);
            logger.debug("Send data:{}", res);
            return res;
        } catch (Exception e) {
            logger.error("getUser()");
            return null;
        }
    }

    @RequestMapping(value = "checkuser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public boolean checkUser(@RequestBody String jsonData) throws IOException {
        try {
            System.out.println(jsonData);
            Map<String, String> datamap = objectMapper.readValue(jsonData, new TypeReference<Map<String, String>>() { });
            System.out.println(datamap);
            String login = datamap.get("login");
            String passw = datamap.get("password");
            logger.debug("got login: {}", login);
            User res = userDao.getOne("login", "password");
            return res.isAdmin();
        } catch (Exception e) {
            logger.error("error checkUser()");
            return false;
        }
    }

    @RequestMapping(value = "/getallusers", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public List<User> getUsers() {
        logger.debug("getUsers()");
        return (List<User>) userDao.findAll();
    }
}