package facenet.tranning.project.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import java.sql.Date;

@Getter
public class OwnerRequest {
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    private String name;
    private String phone;
    private String email;
    private String address;
    private Date dateOfBirth;
    private String gender;
}
