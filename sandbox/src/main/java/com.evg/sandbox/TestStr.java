package com.evg.sandbox;

/**
 * Created by evg on 11.11.16.
 */
public class TestStr {
    public static void main(String[] args) {
        String contact = "Evgeniy Olegovich Shestopalov";
        String find = "Olegovic";
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
//        System.out.println(txt);
        System.out.println(contact);
        System.out.println(txt.contains("evg@gmail.com"));
        System.out.println(txt.lastIndexOf(contact));
        System.out.println(contact.contains(find));

    }
}
