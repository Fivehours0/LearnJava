package NoteCreateObj.anotherWay;

public class PetAnotherWay {
    private String petName;
    private int petAge;

    public PetAnotherWay() {

    }

    public PetAnotherWay(String petName, int petAge) {
        this.petName = petName;
        this.petAge = petAge;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }
}
