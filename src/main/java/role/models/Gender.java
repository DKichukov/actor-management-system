package role.models;

public enum Gender {
    MALE ("M"),
    FEMALE ("F");
    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
