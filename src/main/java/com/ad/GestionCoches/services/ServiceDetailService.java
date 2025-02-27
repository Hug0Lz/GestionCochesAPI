package com.ad.GestionCoches.services;

import com.ad.GestionCoches.models.ServiceDetail;
import com.ad.GestionCoches.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDetailService {

    @Autowired
    ServiceRepository serviceRepository;

    public List<ServiceDetail> getAllService(){
        return serviceRepository.findAll();
    }

    public ServiceDetail getServiceById(long id){
        return serviceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el servicio con id " + id));
    }

    public ServiceDetail addService(ServiceDetail serviceDetail){
        return serviceRepository.save(serviceDetail);
    }

    public ServiceDetail updateService(ServiceDetail serviceDetail){
        ServiceDetail sd = serviceRepository.findById(serviceDetail.getId()).orElseThrow(() -> new IllegalArgumentException(("No se ha encontrado el servicio con el id " + serviceDetail.getId())));
        sd.setName(serviceDetail.getName());
        sd.setDescription(serviceDetail.getDescription());
        sd.setPrice(serviceDetail.getPrice());

        return serviceRepository.save(sd);
    }

    public void DeleteService(Long id){
        ServiceDetail serviceDetail = serviceRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el servicio con id " + id));
        serviceRepository.delete(serviceDetail);
    }

}
