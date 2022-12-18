import java.util.ArrayList;

public class Logic
{
    private ArrayList<Person> santas = new ArrayList<>();
    private final ArrayList<Person> santasBackup = new ArrayList<>();
    private ArrayList<Person> recipients = new ArrayList<>();
    private final ArrayList<Person> recipientsBackup = new ArrayList<>();

    public Logic()
    {
        ReadFile read = new ReadFile(santas);
        santasBackup.addAll(santas);
        recipients.addAll(santas);
        recipientsBackup.addAll(santas);
        runCompute();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        santas.forEach(person -> System.out.println(person.getEmail()+": "+person.getRecipient().getEmail()));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //santas.forEach(this::sendEmail);
        sendEmail(santas.get(0));
    }
    public void sendEmail(Person person)
    {
        SendEmail send = new SendEmail(person,"fwthaaidqgwyeasr");
    }
    public void runCompute()
    {
        try { santas.forEach(this::computeRecipient); }
        catch(StackOverflowError e)
        {
            System.out.println("ERROR RUN - RECALCULATING");
            santas = santasBackup;
            recipients = recipientsBackup;
            runCompute();
        }
    }
    public void computeRecipient(Person giver)
    {
        int random = (int) (Math.random()* recipients.size());
        if(giver.checkRecipient(recipients.get(random)))
        {
            // System.out.println(giver.getEmail()+": "+recipients.get(random).getEmail()+"---- TRUE");
            giver.setRecipient(recipients.get(random));
            recipients.remove(random);
        }
        else
        {
            // System.out.println(giver.getEmail()+": "+recipients.get(random).getEmail()+"---- FALSE");
            computeRecipient(giver);
        }
    }
}
