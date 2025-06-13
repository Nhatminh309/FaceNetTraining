package facenet.tranning.project.repository;

import facenet.tranning.project.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Class thao tác với cơ sở dữ liệu bảng Owner
@Repository
public interface OwnerRepo extends JpaRepository<OwnerEntity, Integer> {
    Optional<Object> findByPhone(String phone);


    boolean existsByPhone(String phone);
}
