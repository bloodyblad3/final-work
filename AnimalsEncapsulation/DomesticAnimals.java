package AnimalsEncapsulation;

public class DomesticAnimals extends ParentClass {
    private String command;
    private String birthDate;

    public DomesticAnimals(String name, String command, String birthDate) {
        super(name);
        this.command = command;
        this.birthDate = birthDate;
    }
    
    public String getCommand() {
        return command;
    }

    public void setName(String command) {
        this.command = command;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
