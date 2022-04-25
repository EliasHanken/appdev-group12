package no.ntnu.gr12.krrr_project.DBClasses.dto;

public class UserProfileDto {
    private String bio;

    public UserProfileDto(String bio) {
        this.bio = bio;
    }

    public UserProfileDto() {
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
