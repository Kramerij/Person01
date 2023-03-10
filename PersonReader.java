import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        ArrayList<String> lines = new ArrayList<>();
        final int FIELDS_LENGTH = 5;
/* making an array of persons */
       ArrayList<String> PersonArray = new ArrayList<>();
        String ID = "";
        String firstname = "";
        String lastname = "";
        String personTitle = "";
        int YOB = 0;

try {
    File workingDirectory = new File(System.getProperty("user.dir"));
    chooser.setCurrentDirectory(workingDirectory);
    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        selectedFile = chooser.getSelectedFile();
        Path file = selectedFile.toPath();

        InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        int line = 0;
        while (reader.ready()) {
            rec = reader.readLine();
            lines.add(rec);

            line++;
        }
        reader.close();
        //file has been read

        //making the output table
        System.out.println("ID     Firstname       Lastname     Title     YOB");
        System.out.println("===================================================");
        String[] fields;
        for (String a : lines) {
            fields = a.split(",", 0);

            if (fields.length == FIELDS_LENGTH) {
                ID = fields[0].trim();
                firstname = fields[1].trim();
                lastname = fields[2].trim();
                personTitle = fields[3].trim();
                YOB = Integer.parseInt(fields[4].trim());
               // System.out.printf("\n%-8s%-15s%-15s%-6s%6d", ID, firstname, lastname, personTitle, YOB);
                PersonArray.add((new Person(ID, firstname, lastname, personTitle, YOB).toCSVRecord()));
            } else {
                System.out.println("File was corrupt");
                System.out.println(a);
            }
        }
        Iterator itr=PersonArray.iterator();
        while(itr.hasNext())
        {
            Object Person = itr.next();
            String formattedString = Person.toString()
                    .replace(",", "      ");

            System.out.println(formattedString);

        }
    }
}
catch (FileNotFoundException e)
{
    System.out.println("File not found");
    e.printStackTrace();
}
catch (IOException e)
{
    e.printStackTrace();
}
}

}


