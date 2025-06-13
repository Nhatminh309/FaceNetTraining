package facenet.tranning.project.repository;

import facenet.tranning.project.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Class thao tác với cơ sở dữ liệu bảng Brand
@Repository
public interface BrandRepo extends JpaRepository<BrandEntity, Integer> {
    Optional<Object> findByName(String name);

    boolean existsByName(String brandName);
}
