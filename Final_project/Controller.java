
import java.util.Scanner;

import Base.Animal;
//import Base.Animal;
import Model.AnimalRegistry;

public class Controller {

    View v = new View();
    AnimalRegistry a = new AnimalRegistry();
    private Scanner scanner = new Scanner(System.in);
     
    public void AnimalRegistry() {
        boolean running = true;
        while (running) {
            v.printMenuAnimals();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    a.displayAnimals();
                    break;
                
                case 2:
                    // добавить метод генерации идентификатора
                    System.out.println("Введите id (любое число): ");
                    String id = scanner.nextLine();
                    System.out.println("Введите вид животного: ");
                    String type = scanner.nextLine();
                    System.out.println("Введите имя животного: ");
                    String name = scanner.nextLine();
                    // формат даты ???
                    System.out.println("Введите дату рождения животного в формате  : ");
                    String datebirth = scanner.nextLine();
                    System.out.println("Введите команды через пробел: ");
                    String commands = scanner.nextLine();
                    Animal animal = new Animal(id, type, name, datebirth, commands);
                    a.addAnimal(animal);
                    break;

                case 3:
                    System.out.println("Введите id удаляемого из реестра животного : ");
                    String idAnimalDelete = scanner.nextLine();
                    a.removeAnimal(idAnimalDelete);
                    break; 

                case 4:
                    System.out.println("Введите новое id (любое число): ");
                    String newId = scanner.nextLine();
                    System.out.println("Введите новый вид животного: ");
                    String newType = scanner.nextLine();
                    System.out.println("Введите новое имя животного: ");
                    String newName = scanner.nextLine();
                    // формат даты ???
                    System.out.println("Введите новую дату рождения животного в формате  : ");
                    String newDatebirth = scanner.nextLine();
                    System.out.println("Введите новые сведения о командах через пробел: ");
                    String newCommands = scanner.nextLine();
                    a.updateAnimal(newId, newType, newName, newDatebirth, newCommands);
                    break;
             
                case 5: 
                    System.out.println("Введите имя животного для поиска:");
                    String searchName = scanner.nextLine();
                    a.searchByName(searchName);
                    break; 

                case 6: 
                    System.out.println("Введите ID животного для поиска:");
                    String searchId = scanner.nextLine();
                    a.searchById(searchId);
                    break;  
                
                case 7: 
                    System.out.println("Введите ID животного, которому будет добавлена команда:");
                    String IdCommand = scanner.nextLine();
                    System.out.println("Введите новую команду :");
                    String newCommand = scanner.nextLine();
                    a.addCommand(IdCommand, newCommand);
                    break; 

                case 8:
                    System.out.println("Введите имя файла для импорта данных:");
                    String fileName = scanner.nextLine();
                    a.importFromFile(fileName);
                    break;  

                case 9:
                    System.out.println("Введите имя файла для экспорта данных:");
                    fileName = scanner.nextLine();
                    a.exportToFile(fileName);
                    break;  
                    
                case 0:
                    System.out.println("Работа программы завершена");
                    System.exit(0);
            }
        }
    }
}