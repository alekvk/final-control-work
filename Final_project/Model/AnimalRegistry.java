package Model;

//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Base.Animal;
import Model.File.ReaderFile;
import Model.File.WriterFile;


public class AnimalRegistry {
    private List<Animal> animals;
       
    
    public AnimalRegistry() {

        Scanner scan = ReaderFile.readFile("registry_animals.txt");
        if (scan == null) {
            animals = new ArrayList<>();
        } else {
            animals  = SplitString(scan);
        }

    }

    public void displayAnimals() {

        System.out.println("Список животных");
        for (Animal a : animals) {
            System.out.println(a);
        }

    }


    public void addAnimal(Animal animal) {

        animals.add(animal);
        System.out.println(":Животное добавлено в реестр");
        StringBuilder sb = BuildString(animals);
        WriterFile.writeFile(sb, "registry_animals.txt");

    }

    
    public void removeAnimal(String idAnimal) {

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getIdAnimal().equals(idAnimal)) {
                animals.remove(i);
                StringBuilder sb = BuildString(animals);
                WriterFile.writeFile(sb, "registry_animals.txt");  
                return;
            }
        }
        System.out.println("Животное с идентификатором = " + idAnimal + "  отсутствует в реестре");

    }

   
    public void updateAnimal(String id, String type, String name, String datebirth, String commands) {

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getIdAnimal().equals(id)) {
                Animal a = animals.get(i);
                a.setIdAnimal(id);
                a.setAnimalType(type);
                a.setAnimalName(name);
                a.setDateBirth(datebirth);
                a.setCommands(commands);
                StringBuilder sb = BuildString(animals);
                WriterFile.writeFile(sb, "registry_animals.txt"); 
                return;
            }
        }
        System.out.println(": Животное не найдено");

    }

     
    public void searchById(String id) {

         List<Animal> result = new ArrayList<>();
        for (Animal a : animals) {
            if (a.getIdAnimal().equals(id)) {
                result.add(a);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Животное не найдено");
        } else {
            for (Animal a : result) {
                System.out.println(a);
            }
        }

    }

    public void searchByName(String name) {

        List<Animal> result = new ArrayList<>();
        for (Animal a : animals) {
            if (a.getAnimalName().equals(name)) {
                result.add(a);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Животное не найдено");
        } else {
            for (Animal a : result) {
                System.out.println(a);
            }
        }

    }

    public void addCommand (String id, String command){

        Animal result = null;
        boolean presenceID = false; 
        for (Animal a : animals) {
            if (a.getIdAnimal().equals(id)) {
                presenceID = true;
                result = a;
            }
        }    
        if (presenceID == false) {
            System.out.println("Животное с указанным идентификатором отсутствует в реестре");
            return; 
        }
        String listCommands = result.getCommands();
        if (!listCommands.contains(command)) {
            result.setCommands(listCommands + " " + command);
            StringBuilder sb = BuildString(animals);
            WriterFile.writeFile(sb, "registry_animals.txt"); 
            System.out.println("Kоманда " + command + " добавлена в перечень команд");
        } else {
            System.out.println("Введенная команда уже содержится в списке команд");
        }

    }
    
    
    public void importFromFile(String fileName) {

        Scanner scan = ReaderFile.readFile(fileName);
        List<Animal> animals2 = SplitString(scan);
        animals.addAll(animals2);
        StringBuilder sb = BuildString(animals);
        WriterFile.writeFile(sb, "registry_animals.txt"); 
        System.out.println("В регистр добавлены животные из файла " + fileName);

    }

   
    public void exportToFile(String fileName) {
    
        StringBuilder sb = BuildString(animals);
        WriterFile.writeFile(sb, fileName); 
        System.out.println("Реестр животных экспортирован в файл " + fileName);

    }

   
   
    public StringBuilder BuildString(List<Animal> animals) {
         
        StringBuilder sb = new StringBuilder();
        for (Animal a : animals) {
            sb.append(a.getIdAnimal()).append(",");
            sb.append(a.getAnimalType()).append(",");
            sb.append(a.getAnimalName()).append(",");
            sb.append(a.getDateBirth()).append(",");
            sb.append(a.getCommands()).append("\n");
        }  
        return sb;

    } 

    public List<Animal> SplitString(Scanner scanner) {

            List<Animal> animals = new ArrayList<>();
            while (scanner.hasNextLine()) {
               String[] fields = scanner.nextLine().split(",");
               // Integer.parseInt(fields[2]), Integer.parseInt(fields[3])
               Animal animal = new Animal(fields[0], fields[1], fields[2], fields[3], fields[4]);
               animals.add(animal);
        }
        return animals;

    }    
    
}
