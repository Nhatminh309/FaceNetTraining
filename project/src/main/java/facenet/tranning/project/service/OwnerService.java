package facenet.tranning.project.service;

import facenet.tranning.project.dto.request.OwnerRequest;
import facenet.tranning.project.entity.CarEntity;
import facenet.tranning.project.entity.OwnerEntity;
import facenet.tranning.project.repository.CarRepo;
import facenet.tranning.project.repository.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Class thực hiện các bussiness logic của brand
public class OwnerService {
    @Autowired
    private OwnerRepo ownerRepo;
    @Autowired
    private CarRepo carRepo;

    // Lấy ra danh sách tất cả người dùng
    public List<OwnerEntity> ownerList(){
        return ownerRepo.findAll();
    }

    // Lấy ra người dùng theo ownerId
    public OwnerEntity getOwnerById(Integer ownerId) {
        return ownerRepo.findById(ownerId).
                orElseThrow(() -> new RuntimeException("Owner not found"));
    }

    // Hàm match các trường ownerRequest sang ownerEntity
    private void mapOwnerFields(OwnerEntity ownerEntity, OwnerRequest ownerRequest) {
        ownerEntity.setName(ownerRequest.getName());
        ownerEntity.setEmail(ownerRequest.getEmail());
        ownerEntity.setPhone(ownerRequest.getPhone());
        ownerEntity.setAddress(ownerRequest.getAddress());
        ownerEntity.setDateOfBirth(ownerRequest.getDateOfBirth());
        ownerEntity.setGender(ownerRequest.getGender());
    }

    // Tạo một người dùng mới
    public OwnerEntity createOwner(OwnerRequest ownerRequest) {

        OwnerEntity ownerEntity = new OwnerEntity();
        mapOwnerFields(ownerEntity, ownerRequest);
        return ownerRepo.save(ownerEntity);
    }

    // Cập nhật một người dùng
    public OwnerEntity updateOwner(Integer ownerId, OwnerRequest ownerRequest) {
        OwnerEntity ownerEntity = getOwnerById(ownerId);
        mapOwnerFields(ownerEntity, ownerRequest);
        return ownerRepo.save(ownerEntity);
    }

    // Tìm người dùng theo số điện thoại
    public OwnerEntity findOwnerByPhone(String phone) {
        return (OwnerEntity) ownerRepo.findByPhone(phone).
                orElseThrow(() -> new RuntimeException("Phone not found in owner"));

    }

    // Kiểm tra số điện thoại người dùng đã tồn tại chưa
    public boolean isPhoneNotExist(String phone) {
        return !ownerRepo.existsByPhone(phone);
    }

    // Xoá một chủ xe
    public void deleteOwner(Integer ownerId) {
        // Xóa chủ xe
        ownerRepo.deleteById(ownerId);
        // Xoá các xe tương ứng
        List<CarEntity> carEntities = carRepo.findAllByOwnerId(ownerId);
        for (CarEntity carEntity : carEntities) {
            carRepo.deleteById(carEntity.getId());
        }
    }

}
