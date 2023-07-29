package AnimalApplication.animalregistry;

import AnimalApplication.counter.Counter;
import AnimalApplication.animal.Animal;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnimalRegistry {
    private Map<String, Animal> animals;
    private Counter counter;
    private Scanner scanner;

    public AnimalRegistry() {
        this.animals = new HashMap<>();
        this.counter = new Counter();
    }

    public void start() {

        final Counter counter = new Counter();
        try (counter) {
            while (true) {
                System.out.println("===== Меню реестра домашних животных =====");
                System.out.println("1. Завести новое животное");
                System.out.println("2. Определить животное в правильный класс");
                System.out.println("3. Увидеть список команд животного");
                System.out.println("4. Обучить животное новым командам");
                System.out.println("5. Выйти из программы");
                System.out.print("Введите номер операции: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addNewAnimal();
                        break;
                    case 2:
                        classifyAnimal();
                        break;
                    case 3:
                        printAnimalCommands();
                        break;
                    case 4:
                        teachAnimalCommands();
                        break;
                    case 5:
                        System.out.println("Программа завершена.");
                        return;
                    default:
                        System.out.println("Ошибка: некорректный выбор.");
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private void addNewAnimal() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите класс животного: ");
        String animalClass = scanner.nextLine();

        Animal animal = new Animal(name, animalClass);
        animals.put(name, animal);
        counter.add();
        System.out.println(name + " добавлено в реестр.");
    }

    private void classifyAnimal() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animal animal = animals.get(name);
        if (animal == null) {
            System.out.println("Животное с именем " + name + " не найдено.");
            return;
        }
        System.out.println(name + " относится к классу " + animal.getAnimalClass());
    }

    private void printAnimalCommands() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animal animal = animals.get(name);
        if (animal == null) {
            System.out.println("Животное с именем " + name + " не найдено.");
            return;
        }
        animal.printCommands();
    }

    private void teachAnimalCommands() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animal animal = animals.get(name);
        if (animal == null) {
            System.out.println("Животное с именем " + name + " не найдено.");
            return;
        }

        System.out.println("Введите новые команды для " + name + " (для завершения введите 'exit'):");
        while (true) {
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                break;
            }
            animal.addCommand(command);
        }
        System.out.println("Команды для " + name + " обновлены.");
    }
}
