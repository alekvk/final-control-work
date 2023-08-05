package Base;

// import java.time.LocalDate;


public class Animal {
    private String idAnimal;
    private String animaltype;
    private String animalname;
    private String datebirth;
    private String commands;


    public Animal(String idAnimal, String animaltype, String animalname, String datebirth, String commands) {
        this.idAnimal = idAnimal;
        this.animaltype = animaltype;
        this.animalname = animalname;
        this.datebirth = datebirth;
        this.commands = commands;
    }

       
    // Setters

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }
        
    public void setAnimalType(String animaltype) {
        this.animaltype = animaltype;
    }

    public void setAnimalName(String animalname) {
        this.animalname = animalname;
    }

    public void setDateBirth(String datebirth)  {
        this.datebirth = datebirth;
    }
    
    public void setCommands (String commands) {
        this.commands = commands;
    }
    
      
    // Getters

    public String getIdAnimal() {
        return idAnimal;
    }

    public String getAnimalType() {
        return animaltype;
    }

    public String getAnimalName() {
        return animalname;
    }
    
    public String getDateBirth() {
        return datebirth;
    }

    public String getCommands() {
        return commands;
    }

    @Override
    public String toString() {
        return  "ID записи - " + idAnimal + 
                ", Вид животного - " + animaltype + 
                ", Имя - " + animalname  + 
                ", Дата рождения - " + datebirth + 
                ", Команды: " + commands;   
        }
    
}







