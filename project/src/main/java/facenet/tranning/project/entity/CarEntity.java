package facenet.tranning.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "car")
@Getter
@Setter
// Class thực hiện ánh xạ car từ database sang object
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "license_plate")
    private String licensePlate;
    private String model;
    private String year;
    private String color;
    @Column(name = "purchase_date")
    private Date purchaseDate;
    @Column(name = "owner_id")
    private int ownerId;
    @Column(name = "brand_id")
    private int brandId;
}
