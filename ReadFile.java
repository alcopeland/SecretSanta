import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile
{
    public ReadFile(ArrayList<Person> people)
    {
        try
        {
            // String fileName = "people.txt"
            String fileName = "people2.txt";
            File peopleInfo = new File(fileName);
            Scanner scanner = new Scanner(peopleInfo);
            int target=0;
            while(scanner.hasNextLine())
            {
                String[] personInfo = scanner.nextLine().split(",");
                people.add(new Person(personInfo[0], personInfo[1], personInfo[2]));
                personInfo = scanner.nextLine().split(",");
                for(String s : personInfo) { people.get(target).addToNoList(s); }
                personInfo = scanner.nextLine().split(",");
                for(String s : personInfo) { people.get(target).addToHobbies(s); }
                target++;
            }
        }
        catch(FileNotFoundException e) { System.out.println("File not found."); }
    }
}
