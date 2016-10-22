package com.ksimeo.arsu.admin.services.test;

import com.ksimeo.arsu.admin.services.ITypeService;
import com.ksimeo.arsu.core.models.ProdType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @author Ksimeo on 17.11.2015 at 16:25. For project: MArsMarketSpace.
 */
@Service
public class TypeServiceMock implements ITypeService {

    private List<ProdType> types;

    public TypeServiceMock() {
        types = new ArrayList<>();
        types.add(new ProdType(1, "Кофеварки"));
        types.add(new ProdType(2, "Электрочайники"));
        types.add(new ProdType(3, "Микроволновки"));
    }

    public void addType(ProdType prodType) {
        types.add(prodType);
    }

    public ProdType getType(int id) {
        return types.get(id - 1);
    }

    public List<ProdType> getAllTypes() {
        return types;
    }
}
