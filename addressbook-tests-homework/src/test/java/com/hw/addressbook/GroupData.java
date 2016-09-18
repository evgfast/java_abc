package com.hw.addressbook;

public class GroupData {
    private final String name;
    private final String header;
    private final String comment;

    public GroupData(String name, String header, String comment) {
        this.name = name;
        this.header = header;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getComment() {
        return comment;
    }
}
