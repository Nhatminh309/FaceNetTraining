package facenet.tranning.project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
// Class chứa thông tin thêm một xe mới
public class CarRequest extends CarDTO {
    public CarRequest(String licensePlate, String model, String year, String color, Date purchaseDate,String ownerPhone, String brandName) {
        super(licensePlate, model, year, color, purchaseDate, ownerPhone, brandName);
    }
}
