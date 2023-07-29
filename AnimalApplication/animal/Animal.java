package AnimalApplication.animal;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String name;
    private String animalClass;
    private List<String> commands;

    public Animal(String name, String animalClass) {
        this.name = name;
        this.animalClass = animalClass;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAnimalClass() {
        return animalClass;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void printCommands() {
        System.out.println("Список команд для " + name + ":");
        for (String command : commands) {
            System.out.println("- " + command);
        }
    }
}
