import java.util.ArrayList;

public class Person
{
    private final String forename;
    private final String surname;
    private final String email;
    private Person recipient;
    private final ArrayList<String> noList = new ArrayList<>();
    private final ArrayList<String> hobbies = new ArrayList<>();

    public Person(String forename, String surname, String email)
    {
        this.email=email;
        this.forename=forename;
        this.surname=surname;
    }
    public boolean checkRecipient(Person person)
    {
        for (String s : noList) { if (s.equals(person.getEmail()) || person.getEmail().equals(email)) { return false; } }
        return true;
    }
    public String getEmail() { return email; }
    public String getForename() { return forename; }
    public String getSurname() { return surname; }
    public Person getRecipient() { return recipient; }

    public void setRecipient(Person recipient) { this.recipient = recipient; }
    public void addToNoList(String targetEmail) { this.noList.add(targetEmail); }
    public void addToHobbies(String hobby) {this.hobbies.add(hobby); }
    public String getHobbies()
    {
        String hobbiesString = String.join(", ", hobbies);
        return hobbiesString;
    }
}
