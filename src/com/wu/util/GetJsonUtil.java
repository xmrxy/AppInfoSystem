package com.wu.util;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

public class GetJsonUtil {
    public static String getJson(Object list) {
        String data=JSONObject.toJSONStringWithDateFormat(list,"yyyy-MM-dd HH:mm:ss",
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect);
        return data;
    }


}
