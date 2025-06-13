package facenet.tranning.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "brand")
@Getter
@Setter
// Class thực hiện ánh xạ brand từ database sang object
public class BrandEntity {
    @Id
    // Database tự động tăng cho khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String country;
    @Column(name = "year_founded")
    private int yearFounded;
    private String headquarters;
    private String website;
    private String description;

}
