package com.evg.sandbox;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

/**
 * Created by evg on 13.11.16.
 */
public class RegexTest {
    public static void main(String[] args){
//        one_example();
        two_example();
        List<String> list_email = new ArrayList<String>();
        list_email.add("e1");
        list_email.add("e2");
        list_email.add("e3");
        String email = list_email.get(0);
        String email2 =  list_email.get(1);
        String email3 = list_email.get(2);
        for(int i = 0; i < list_email.size(); i++){
            System.out.println(list_email.get(i));
        }
        System.out.println(list_email.size());
    }
    public static void one_example(){
        String pattern = "[a-z]+";
        String txt =  "code 2 learn java tutorial";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(txt);
        while(m.find()){
            System.out.println(txt.substring(m.start(),m.end()));
        }
    }
    public static void two_example(){
        String txt = "Evgeniy Olegovich Shestopalov\n" +
                "evg\n" +
                "Inc\n" +
                "Saratov 64 Moscowskay 17 07\n" +
                "\n" +
                "H: 222266\n" +
                "M: 88888\n" +
                "W: 99999\n" +
                "\n" +
                "evg@gmail.com (www.gmail.com)\n" +
                "evg2@mail.com (www.mail.com)\n" +
                "evg3@gmail.com (www.gmail.com)\n" +
                "\n" +
                "\n" +
                "Second address\n" +
                "\n" +
                "Notes\n" +
                "\n" +
                "\n" +
                "Member of: group_name";
        String pattern = "(H):\\s\\d+";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(txt);
        m.find();
        System.out.println(txt.substring(m.start(), m.end()));
        System.out.println(txt.substring(m.start()+3, m.end()));
    }
}
