package ch19.sec06;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

public class ParseJsonExample {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader("/Users/th/Desktop/member.json", Charset.forName("UTF-8")));
        String json = br.readLine();
        br.close();

        // JSON 파싱
        JSONObject root = new JSONObject(json);

        System.out.println("id: " + root.getString("id"));

        JSONObject tel = root.getJSONObject("tel");
        System.out.println(tel.getString("home"));

        JSONArray skill = root.getJSONArray("skill");
        System.out.println("skill: ");
        for(int i =0 ; i<skill.length(); i++) {
            System.out.println(skill.get(i) + ", ");
        }
    }

}
