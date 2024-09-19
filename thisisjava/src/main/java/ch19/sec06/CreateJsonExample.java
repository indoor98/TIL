package ch19.sec06;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

public class CreateJsonExample {
    public static void main(String[] args) throws IOException {
        // JSON 객체 생성
        JSONObject root = new JSONObject();

        root.put("id", "winter");

        JSONObject tel = new JSONObject();
        tel.put("home", "02-123-1234");
        tel.put("mobile", "010-1234-1234");
        root.put("tel", tel);

        JSONArray skill = new JSONArray();
        skill.put("java");
        skill.put("c");
        root.put("skill", skill);

        // get Json
        String json = root.toString();


        // console print
        System.out.println(json);

        // save as a file
        Writer writer = new FileWriter("/Users/th/Desktop/member.json", Charset.forName("UTF-8"));
        writer.write(json);
        writer.flush();
        writer.close();
    }
}
