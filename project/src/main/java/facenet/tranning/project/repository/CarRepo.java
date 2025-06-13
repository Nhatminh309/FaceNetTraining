package facenet.tranning.project.repository;

import facenet.tranning.project.dto.request.CarDTOList;
import facenet.tranning.project.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// Class thao tác với cơ sở dữ liệu bảng Car
@Repository
public interface CarRepo extends JpaRepository<CarEntity, Integer> {
    @Query("SELECT c.id, c.licensePlate, c.model, c.year, c.color, c.purchaseDate, b.name, o.name, o.phone \n" +
            "FROM CarEntity c\n" +
            "JOIN OwnerEntity o ON c.ownerId = o.id\n" +
            "JOIN BrandEntity b ON c.brandId = b.id")
    List<CarDTOList> getCarList();

    List<CarEntity> findAllByOwnerId(Integer ownerId);

    boolean existsByLicensePlate(String licensePlate);
}
