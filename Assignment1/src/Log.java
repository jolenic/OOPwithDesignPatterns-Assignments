import java.sql.Timestamp;
import java.util.Scanner;

public class Log {
    private Timestamp timestamp;
    private String name;
    private String description;
    private String idCode;
    
    public Log(String name, String description) {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.name = name;
        this.description = description;
        this.idCode = "abc-abc-abc"; //placeholder for generated code
    }
    
    public Log(String name) {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.name = name;
        this.description = null;
        this.idCode = "abc-abc-abc"; //placeholder for generated code
    }
    
    public Log() {
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.name = "Log created at " + timestamp;
        this.description = null;
        this.idCode = "abc-abc-abc"; //placeholder for generated code
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }
    
    public String getIdCode() {
        return idCode;
    }
    
    public Timestamp getTimestamp() {
        return timestamp;
    }
    
    public Log create() {
        System.out.println("Enter log name: ");
        Scanner input = new Scanner(System.in);
        String newName = input.nextLine();
        System.out.println("Enter log description: ");
        String newDesc = input.nextLine();
        input.close();
        System.out.println("Log created!");
        return new Log(newName, newDesc);
    }
    
    public void read() {
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        //idCode not included in read because it's an internal measurement
    }
    
    public void update() {
        System.out.println("New name: ");
        Scanner input = new Scanner(System.in);
        String newName = input.nextLine();
        System.out.println("New description: ");
        String newDesc = input.nextLine();
        this.name = newName;
        this.description = newDesc;
        input.close();
        System.out.println("New Log: ");
        this.read();
    }
    
    public void delete() {
        this.timestamp = null;
        this.name = null;
        this.description = null;
        this.idCode = null;   
        System.out.println("Log deleted");
        }
}
