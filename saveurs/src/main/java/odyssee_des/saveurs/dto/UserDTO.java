package odyssee_des.saveurs.dto;

import odyssee_des.saveurs.model.sql.User;

public class UserDTO {
    private String username;
    private String firstName;
    private String lastName;

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
