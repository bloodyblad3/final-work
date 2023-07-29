package AnimalApplication;

import AnimalApplication.animalregistry.AnimalRegistry;

public class Main {
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        registry.start();
    }
}
