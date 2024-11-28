package com.fag.infra.utils;

    import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonUtils {

    public static Map<String, Object> srtToMap(String strJson) {

        Pattern pattern = Pattern.compile("\"(\\w+)\"\\s*:\\s*(\"[^\"]*\"|\\d+|true|false|null)");
        Matcher matcher = pattern.matcher(strJson);

        Map<String, Object> jsonData = new HashMap<>();

        while (matcher.find()) {
            String key = matcher.group(1);
            String value = matcher.group(2);

            jsonData.put(key, value.replace("\"", ""));
        }

        return jsonData;
    }

    public static String getField(String json, String field) {
        Map<String, Object> jsonMap = srtToMap(json);

        String fieldValue = jsonMap.get(field).toString();

        return fieldValue;
    }

}
    
