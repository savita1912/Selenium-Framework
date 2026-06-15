package com.framework.utils;

import java.io.InputStream;
import java.util.Scanner;

import org.json.JSONObject;

public class JSONReader {
	public static JSONObject getTestData(String userType) {

        InputStream is = JSONReader.class
                .getClassLoader()
                .getResourceAsStream("testdata/login.json");

        Scanner scanner = new Scanner(is).useDelimiter("\\A");

        String jsonData = scanner.hasNext() ? scanner.next() : "";

        scanner.close();

        JSONObject jsonObject = new JSONObject(jsonData);

        return jsonObject.getJSONObject(userType);
    }


}


