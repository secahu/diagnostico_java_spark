package minsait.ttaa.datio.common.naming;

import java.io.FileReader;
import java.util.Properties;

public class configuracion {
    private String input;
    private String output;

    public configuracion(){

        try(FileReader reader = new FileReader("src/test/resources/data/configuracion.properties")) {
            Properties properties = new Properties();
            properties.load(reader);
            input = properties.getProperty("input");
            output= properties.getProperty("output");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }



}
