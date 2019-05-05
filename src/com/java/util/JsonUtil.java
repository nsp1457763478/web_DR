package com.java.util;

import com.alibaba.fastjson.JSONObject;

import java.util.List;


public class JsonUtil {
    public static <T> JSONObject getJsonObject(List<T> list, PageBean pageBean) {
        JSONObject table = new JSONObject();
        table.put("code", 0);
        table.put("msg", "");
        table.put("count", pageBean.getCount());
        table.put("data", list);
        return table;
    }
}
