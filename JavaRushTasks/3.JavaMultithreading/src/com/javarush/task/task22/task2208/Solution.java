package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));
    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder("\"");
        for (Map.Entry<String, String> pair : params.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (value != null) {
                builder.append(key + " = '" + value + "' and ");
            }
        }
        builder.delete(builder.length() - 5, builder.length());
        builder.append("\"");
        return builder.toString();
    }
}
