package facenet.tranning.project.mapper;

import facenet.tranning.project.dto.request.CarDTO;
import facenet.tranning.project.entity.CarEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarEntity mapCarDTOToCarEntity(CarDTO carDTO);
}
