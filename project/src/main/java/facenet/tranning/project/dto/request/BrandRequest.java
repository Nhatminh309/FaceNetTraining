package facenet.tranning.project.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
// Class nhận thông tin thêm một brand mới
public class BrandRequest {
    private String name;
    private String country;
    @Min(value = 1900, message = "Year founded must be greater than or equal to 1900")
    private int yearFounded;
    private String headquarters;
    private String website;
    private String description;
}
