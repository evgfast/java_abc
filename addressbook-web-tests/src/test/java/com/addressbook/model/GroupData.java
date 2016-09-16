package com.addressbook.model;

public class GroupData {
    private final String group_name;
    private final String header;
    private final String comment;

    public GroupData(String group_name, String header, String comment) {
        this.group_name = group_name;
        this.header = header;
        this.comment = comment;
    }

    public String getGroup_name() {
        return group_name;
    }

    public String getHeader() {
        return header;
    }

    public String getComment() {
        return comment;
    }
}
