package com.java.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class JsonUtil1{
    public static <T> JSONObject getJsonObject(List<T> list){
        JSONArray jsonArr=(JSONArray)JSONArray.toJSON(list);
        JSONObject array=new JSONObject();
        array.put("code",0);
        array.put("count",list.size());
        array.put("data",jsonArr);
        return  array;
    }

}