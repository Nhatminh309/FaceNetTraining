package facenet.tranning.project.controller;

import facenet.tranning.project.dto.request.CarDTO;
import facenet.tranning.project.dto.request.CarDTOList;
import facenet.tranning.project.dto.request.CarRequest;
import facenet.tranning.project.entity.CarEntity;
import facenet.tranning.project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    // Hiển thị danh sách tất cả các car
    @GetMapping("/cars")
    public List<CarDTOList> getCars() {
        return carService.carList();
    }

    // Tạo mới một car
    @PostMapping("/cars")
    public CarEntity createCar(@RequestBody CarRequest carRequest) {
        return carService.createCar(carRequest);
    }

    // Chỉnh sửa một car
    @PutMapping("/cars/{carId}")
    public CarEntity updateCar(@PathVariable int carId, @RequestBody CarDTOList carDTOList) {
        return carService.updateCar(carId, carDTOList);
    }

    // Xóa một car
    @DeleteMapping("/cars/{carId}")
    public void deleteCar(@PathVariable int carId) {
        carService.deleteCar(carId);
    }
}
