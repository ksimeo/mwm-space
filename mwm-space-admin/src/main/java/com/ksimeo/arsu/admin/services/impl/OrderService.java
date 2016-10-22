package com.ksimeo.arsu.admin.services.impl;

import com.ksimeo.arsu.admin.services.IOrderService;
import com.ksimeo.arsu.admin.services.impl.toSend.RestSender;
import com.ksimeo.arsu.core.models.Basket;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.util.List;

/**
 * Created by @author Ksimeo on 14.01.2016 at 16:28. For project: MArsMarketSpace.
 */
//@Service
public class OrderService implements IOrderService {
    private RestSender restSender;
    private ObjectMapper om;

    public OrderService() {
        this.restSender = new RestSender("http://localhost:9090");
        this.om = new ObjectMapper();
    }

    @Override
    public List<Basket> getNewOrders() throws Exception {
            String findings = restSender.doGET("/getneworders");
        if (findings == null) throw new Exception("Не отвечает REST-сервер");
            return om.readValue(findings, new TypeReference<List<Basket>>() {});
    }

    @Override
    public List<Basket> getOrderPage(int page) {
        try {
            String findings = restSender.doGET("/orderpage/" + page);
            return om.readValue(findings, new TypeReference<List<Basket>>(){});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Basket> getOrders(int from, int to) {
        return null;
    }

    @Override
    public void consider(int id) throws Exception {
//        try {
            restSender.doGET("/considered/" + id);
//        }

    }

    @Override
    public void delOrder(int id) {

    }

}