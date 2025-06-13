package facenet.tranning.project.service;

import facenet.tranning.project.dto.request.CarDTO;
import facenet.tranning.project.dto.request.CarDTOList;
import facenet.tranning.project.dto.request.CarRequest;
import facenet.tranning.project.entity.BrandEntity;
import facenet.tranning.project.entity.CarEntity;
import facenet.tranning.project.entity.OwnerEntity;
import facenet.tranning.project.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Class thực hiện các bussiness logic của car
public class CarService {
    @Autowired
    private CarRepo carRepo;
    @Autowired
    private BrandService brandService;
    @Autowired
    private OwnerService ownerService;

    // Hiển thị tất cả các xe
    public List<CarDTOList> carList(){
        return carRepo.getCarList();
    }

    // Lấy ra xe theo carId
    public CarEntity getCarById(int carId) {
        return carRepo.findById(carId).
                orElseThrow(() -> new RuntimeException("Car not found"));
    }

    // Map carDTO sang carEntity
    public void mapCarFields(CarEntity carEntity, CarDTO carDTO) {
        carEntity.setLicensePlate(carDTO.getLicensePlate());
        carEntity.setModel(carDTO.getModel());
        carEntity.setYear(carDTO.getYear());
        carEntity.setColor(carDTO.getColor());
        carEntity.setPurchaseDate(carDTO.getPurchaseDate());
    }

    // Map carDTO sang carEntity
    public void mapCarRequestToCarEntity(CarEntity carEntity, CarRequest carRequest) {
        mapCarFields(carEntity, carRequest);
    }

    // Map carDTOList sang carEntity
    public void mapCarDTOListToCarEntity(CarEntity carEntity, CarDTOList carDTOList) {
        BrandEntity brandEntity = brandService.getBrandByName(carDTOList.getBrandName());
        OwnerEntity ownerEntity = ownerService.findOwnerByPhone(carDTOList.getOwnerPhone());
        carEntity.setOwnerId(ownerEntity.getId());
        carEntity.setBrandId(brandEntity.getId());
        mapCarFields(carEntity, (CarDTO) carDTOList);
    }

    // Tạo mới một car
    public CarEntity createCar(CarRequest carRequest) {
        //Kiểm tra số điện thoại chủ xe đã tồn tại chưa
        String phone = carRequest.getOwnerPhone();
        String licensePlate = carRequest.getLicensePlate();
        String brandName = carRequest.getBrandName();

        // Tìm chủ sở hữu qua số điện thoại
        if(ownerService.isPhoneNotExist(phone)) {
            throw new RuntimeException("Phone not found in owner");
        }

        // Kiểm tra biển số xe đã tồn tại chưa
        if(isExistByLicensePlate(licensePlate)){
            throw new RuntimeException("License plate already exist");
        }

        // Kiểm tra hãng xe có tồn tại không
        if (brandService.isNotExistsBrandName(brandName)) {
            throw new RuntimeException("Brand name not found");
        }
        OwnerEntity ownerEntity = ownerService.findOwnerByPhone(phone);
        BrandEntity brandEntity = brandService.getBrandByName(brandName);

        CarEntity carEntity = new CarEntity();
        carEntity.setBrandId(brandEntity.getId());
        carEntity.setOwnerId(ownerEntity.getId());

        mapCarRequestToCarEntity(carEntity, carRequest);

        return carRepo.save(carEntity);
    }

    // Cập nhật một car
    public CarEntity updateCar(int carId, CarDTOList carDTOList) {
        String phone = carDTOList.getOwnerPhone();
        String licensePlate = carDTOList.getLicensePlate();

        // Tìm chủ sở hữu qua số điện thoại
        if(ownerService.isPhoneNotExist(phone)) {
            throw new RuntimeException("Phone not found in owner");
        }

        // Kiểm tra biển số xe đã tồn tại chưa
        if(isExistByLicensePlate(licensePlate)){
            throw new RuntimeException("License plate already exist");
        }

        CarEntity carEntity = getCarById(carId);
        mapCarDTOListToCarEntity(carEntity, carDTOList);
        return carRepo.save(carEntity);
    }

    // Xóa một car
    public void deleteCar(int carId) {
        CarEntity carEntity = getCarById(carId);
        carRepo.delete(carEntity);
    }

    // Kiểm tra biển số xe đã tồn tại chưa
    public boolean isExistByLicensePlate(String licensePlate) {
        return carRepo.existsByLicensePlate(licensePlate);
    }
}
