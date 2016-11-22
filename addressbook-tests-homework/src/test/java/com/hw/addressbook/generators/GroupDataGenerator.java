package com.hw.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hw.addressbook.model.GroupData;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by evg on 14.11.16.
 */
public class GroupDataGenerator {
    @Parameter(names = "-c", description = "Group count")
    public int count;
    @Parameter(names = "-f", description = "Target file")
    public String file;
    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        GroupDataGenerator generator = new GroupDataGenerator();
        JCommander jCommander= new JCommander(generator);
        try{
            jCommander.parse(args);
        }catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<GroupData> groups = generateGroups(count);
        if (format.equals("csv")){
            saveAsCav(groups, new File(file));
        }else if( format.equals("xml") ){
            saveAsXml(groups, new File(file));
        }else if( format.equals("json") ) {
            saveAsJson(groups, new File(file));
        }
        else {
            System.out.println("unregnized format " + format);
        }
    }

    private void saveAsXml(List<GroupData> groups, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(GroupData.class);
        //xstream.alias("group", GroupData.class);
        String xml = xstream.toXML(groups);
        Writer writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }

    private void saveAsCav(List<GroupData> groups, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        Writer writer = new FileWriter(file);
        for(GroupData group : groups){
            writer.write(String.format("%s;%s;%s\n", group.getName(), group.getHeader(), group.getComment()));
        }
        writer.close();
    }

    private void saveAsJson(List<GroupData> groups, File file) throws IOException {
//      Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        String json = gson.toJson(groups);
        Writer writer = new FileWriter(file);
        writer.write(json);
        writer.close();
    }

    private List<GroupData> generateGroups(int count){
        List<GroupData> groups = new ArrayList<GroupData>();
        for(int i = 0; i < count; i++){
            groups.add(new GroupData()
                    .withName(String.format("test %s" , i))
                    .withHeader(String.format("header %s" , i))
                    .withComment(String.format("comment %s" , i)));
        }
        return groups;
    }
}
