import java.time.Year;

/**
 * @author Isabelle Kramer kramerij@mail.uc.edu
 *
 * @return
 */
public class Person {

    private String firstname;
    private String lastname;
    private String title;
    private String ID;
    private int YOB;

    public Person(String firstname, String lastname, String title, String ID, int YOB) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.ID = ID;
        this.YOB = YOB;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", title='" + title + '\'' +
                ", ID='" + ID + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    /**Method to get full name
     *
     * @return return first and lastnames as full name string
     */
    public String getFullName() {
        return firstname + " " + lastname;
    }
    /**Method to get formal name
     *
     * @return return first and lastnames as formal name strings     */
    public String getFormalName(){
        return title + " " + firstname + " " + lastname;
    }

    /**
     * Get age as an int assuming that it is for the current year
     * @return age as an int
     */
    public int getAge(){
        return Integer.parseInt(Year.now().toString() ) -YOB;

    }
    /**
     * Get age as an int assuming that it is for calculating age of previous years
     * @return age as an int for selected year
     * @param year
     */
     public int getAge(int year){
         return year - YOB;
     }

    /**
     * @return object data in CSV format
     */
    public String toCSVRecord(){
        return firstname + "," + lastname + "," + title + "," + ID + "," + YOB;
    }

}

