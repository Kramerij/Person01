import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<String> personCSVData = new ArrayList<>();
        ArrayList<String> personOData = new ArrayList<>();
        String id = "";
        String firstname = "";
        String lastname = "";
        String title = "";
        String CSVPersonRecord = "";
        int YOB = 0;

        Boolean done = false;
        Boolean enteringDone = false;
        Scanner input = new Scanner(System.in);
        do{
        do {
            id = SafeInput.getNonZeroLenString(input, "Please enter your ID");
            System.out.println("ID is:" + id);
            firstname = SafeInput.getNonZeroLenString(input, "What is your firstname name?");
            System.out.println("Your firstname name is " + firstname);
            lastname = SafeInput.getNonZeroLenString(input, "What is your lastname name?");
            System.out.println("Your lastname name is " + lastname);
            title = SafeInput.getNonZeroLenString(input, "What is your preferred title (ms., mr, dr, etc)?");
            System.out.println("Your title is " + title);
            YOB = SafeInput.getRangedInt(input, "What is your year of birth", 1000, 9999);
            System.out.println("Your birthday is " + YOB);
           /* CSVPersonRecord = id + "," + firstname + "," + lastname + "," + title + "," + YOB;
            personCSVData.add(CSVPersonRecord);*/

            personOData.add(new Person(id, firstname, lastname, title, YOB).toCSVRecord());

            enteringDone = SafeInput.getYNConfirm(input, "have you finished entering the person's data?");
        } while (!enteringDone);
            done = SafeInput.getYNConfirm(input, "Are you done entering persons?");
        }
        while (!done);
        for (String p : personOData)
            System.out.println(p);
        System.out.println(personOData);
//* Writing the CVS file *//
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonData.txt");

        try
        {

            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(String rec : personOData)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

