package br.com.nubr.tax.application.entity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Foo {

    public static void foo(List<Map<String, List<JSONObject>>> result, StringBuilder sb) {
        JSONArray jsonArray = new JSONArray(sb.toString());
        Map<String, List<JSONObject>> map = new HashMap<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String operation = jsonObject.getString("operation");
            if (!map.containsKey(operation)) {
                map.put(operation, new ArrayList<>());
            }
            map.get(operation).add(jsonObject);
        }
        result.add(map);
        System.out.println("Menino:" + result);
    }
}
