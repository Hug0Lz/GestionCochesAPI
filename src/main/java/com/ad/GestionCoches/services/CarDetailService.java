package com.ad.GestionCoches.services;

import com.ad.GestionCoches.models.CarDetail;
import com.ad.GestionCoches.models.CarDetailDTO;
import com.ad.GestionCoches.models.CarService;
import com.ad.GestionCoches.models.CarServiceDTO;
import com.ad.GestionCoches.repositories.CarDetailRepository;
import com.ad.GestionCoches.repositories.CarServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarDetailService {

    @Autowired
    private CarDetailRepository carDetailRepository;

    @Autowired
    private ServiceDetailService serviceDetailService;

    @Autowired
    private CarServiceService carServiceService;

    public List<CarDetailDTO> getAllCarDetail() {
        List<CarDetailDTO> carDetailDTOList = new ArrayList<>();
        carDetailRepository.findAll().forEach(carDetail -> carDetailDTOList.add(new CarDetailDTO(carDetail)));
        return carDetailDTOList;
    }

    public CarDetailDTO getCarDetailById(Long id) {
        return new CarDetailDTO(carDetailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el detalle del coche con el id " + id)));
    }

    public CarDetailDTO  updateCarDetail(Long id, CarDetail carDetail) {
        CarDetail cd = carDetailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el detalle del coche con el id " + carDetail.getId()));

        cd.setVin(cd.getVin());
        cd.setColor(cd.getColor());
        cd.setExtras(cd.getExtras());
        cd.setCarModel(carDetail.getCarModel());
        cd.setEngine(carDetail.getEngine());
        cd.setCarServices(carDetail.getCarServices());
        carDetailRepository.save(cd);
        return new CarDetailDTO(cd);
    }

    public void deleteCarDetail(Long id) {
        CarDetail carDetail = carDetailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el id " + id));
        carDetailRepository.delete(carDetail);
    }


    public CarDetailDTO addServiceToCar(Long idCar, CarServiceDTO carServiceDTO) {
        carServiceService.addService(new CarService(
                carDetailRepository.findById(idCar).orElseThrow(() -> new RuntimeException("Error al encontrar el ID {"+ idCar +"} del coche para añadirle un servicio")),
                serviceDetailService.getServiceById(carServiceDTO.getIdService()),
                carServiceDTO.getStartDate(),
                carServiceDTO.getStartDate()));

    return  new CarDetailDTO(carDetailRepository.findById(idCar).orElseThrow(() -> new IllegalArgumentException("Error al encontrar el coche para crear el CarDetailDTO")));
    }
}
