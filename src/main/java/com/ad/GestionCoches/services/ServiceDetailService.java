package com.ad.GestionCoches.services;

import com.ad.GestionCoches.models.CarDetailDTO;
import com.ad.GestionCoches.models.ServiceDetail;
import com.ad.GestionCoches.repositories.CarDetailRepository;
import com.ad.GestionCoches.repositories.ServiceDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDetailService {

    @Autowired
    ServiceDetailRepository serviceDetailRepository;


    public List<ServiceDetail> getAllService(){
        return serviceDetailRepository.findAll();
    }

    public ServiceDetail getServiceById(long id){
        return serviceDetailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el servicio con id " + id));
    }


    public ServiceDetail addService(ServiceDetail serviceDetail){
        return serviceDetailRepository.save(serviceDetail);
    }

    public ServiceDetail updateService(ServiceDetail serviceDetail){
        ServiceDetail sd = serviceDetailRepository.findById(serviceDetail.getId()).orElseThrow(() -> new IllegalArgumentException(("No se ha encontrado el servicio con el id " + serviceDetail.getId())));
        sd.setName(serviceDetail.getName());
        sd.setDescription(serviceDetail.getDescription());
        sd.setPrice(serviceDetail.getPrice());

        return serviceDetailRepository.save(sd);
    }

    public void DeleteService(Long id){
        ServiceDetail serviceDetail = serviceDetailRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el servicio con id " + id));
        serviceDetailRepository.delete(serviceDetail);
    }

}
