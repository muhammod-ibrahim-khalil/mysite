package com.mysite.core.models.impl;

import com.mysite.core.models.MyList;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;

import java.util.ArrayList;
import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class, adapters = MyList.class)
public class MyListImpl implements MyList {
    @Override
    public List<String> getList() {
        List<String> list = new ArrayList<String>();
        list.add("aam");
        list.add("pata");
        list.add("jora");
        list.add("jora");
        return list;
    }
}
