package com.wenky.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-12 21:43
 */
public class GsonFileTest {
    public static void main(String[] args) {
        //
        GsonFileTest test = new GsonFileTest();
        try {
            Student student = new Student();
            student.setAge(23);
            student.setName("wenky");
            test.writeJSON(student);
            Student student1 = test.readJSON();
            System.out.println(student1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(underLineToCamel("1_22_fwd_DD"));
    }

    private void writeJSON(Student student) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter("/Users/huwenqi/Desktop/student.json");
        writer.write(gson.toJson(student));
        writer.close();
    }

    private Student readJSON() throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader bufferedReader =
                new BufferedReader(new FileReader("/Users/huwenqi/Desktop/student.json"));
        Student student = gson.fromJson(bufferedReader, Student.class);
        return student;
    }

    private static Pattern pattern = Pattern.compile("_(\\w)");

    private static String underLineToCamel(String source) {
        Matcher matcher = pattern.matcher(source);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
