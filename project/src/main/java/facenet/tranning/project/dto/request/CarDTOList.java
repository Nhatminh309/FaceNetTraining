package facenet.tranning.project.dto.request;

import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Setter
@Getter
// Class chứa thông tin hiển thị thông tin xe
public class CarDTOList extends CarDTO {
    private int id;
    private String ownerName;
    public CarDTOList(int id,String licensePlate, String model, String year, String color,
                      Date purchaseDate, String brandName, String ownerName, String ownerPhone) {
        super(licensePlate, model, year, color, purchaseDate, ownerPhone, brandName);
        this.id = id;
        this.ownerName = ownerName;
    }
}
