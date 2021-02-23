package com.wasiya.will;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";

    //Field attributes index
    private static final int Field_ID_IDX = 0;
    private static final int Field_FNAME_IDX = 1;
    private static final int Field_LNAME_IDX = 2;
    private static final int Field_GENDER = 3;
    private static final int Field_AGE = 4;

    public static void readCsvFile(String fileName) {

        BufferedReader fileReader = null;

        try {

            //Create a new list of Field to be filled by CSV file data
            List fields = new ArrayList();

            String line = "";

            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileName));

            //Read the CSV file header to skip it
            fileReader.readLine();

            //Read the file line by line starting from the second line
            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(COMMA_DELIMITER);
                if (tokens.length > 0) {
                    //Create a new field object and fill his  data
                    Field field = new Field(Long.parseLong(tokens[Field_ID_IDX]), tokens[Field_FNAME_IDX], tokens[Field_LNAME_IDX], tokens[Field_GENDER], Integer.parseInt(tokens[Field_AGE]));
                    fields.add(field);
                }
            }

            //Print the new Field list
            for (Field field : fields) {
                System.out.println(field.toString());
            }
        }
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }

    }

}



