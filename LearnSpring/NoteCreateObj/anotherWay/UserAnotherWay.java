package NoteCreateObj.anotherWay;

public class UserAnotherWay {
    private String name;
    private PetAnotherWay pet;

    public UserAnotherWay() {
    }

    public UserAnotherWay(String name, PetAnotherWay pet) {
        this.name = name;
        this.pet = pet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetAnotherWay getPet() {
        return pet;
    }

    public void setPet(PetAnotherWay pet) {
        this.pet = pet;
    }
}
