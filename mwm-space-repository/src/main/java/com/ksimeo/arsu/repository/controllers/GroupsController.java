package com.ksimeo.arsu.repository.controllers;

import com.ksimeo.arsu.repository.dao.GroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Ksimeo 12.10.2015.
 */
@Controller
public class GroupsController {

    @Autowired
    private GroupDao groupDao;

    
}
