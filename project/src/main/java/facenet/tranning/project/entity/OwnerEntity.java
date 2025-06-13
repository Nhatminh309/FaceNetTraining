package facenet.tranning.project.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "owner")
@Setter
@Getter
// Class thực hiện ánh xạ owner từ database sang object
public class OwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    private String gender;
}
