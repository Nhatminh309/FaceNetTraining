package facenet.tranning.project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
//Class chứa các thuộc tính chung cho thông tin xe
public class CarDTO {
    private String licensePlate;
    private String model;
    private String year;
    private String color;
    private Date purchaseDate;
    private String ownerPhone;
    private String brandName;
}
