package org.example;

import org.apache.commons.lang3.StringUtils;

public class Application {
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        //if(name==null || name.equals(""))
        //if(name.length()==0)
        if (StringUtils.isEmpty(name)){
            throw new RuntimeException("Empty String is not allowed");
        }
        this.name = name;
    }
}
