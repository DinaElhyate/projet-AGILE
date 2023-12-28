package com.example.demo.servicesImpl;

import com.example.demo.beans.Presentant;
import com.example.demo.repositories.PresentantRepository;
import com.example.demo.services.PresentantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentantServiceImpl implements PresentantService {

    @Autowired
    private PresentantRepository presentantRepository;

    @Override
    public Presentant addPresentant(Presentant presentant) {
        return presentantRepository.save(presentant);
    }
    @Override
    public List<Presentant> getAllPresentants() {
        return presentantRepository.findAll();
    }

    @Override
    public Presentant getPresentantById(Long id) {
        return presentantRepository.findById(id).orElse(null);
    }



    // Ajoutez d'autres méthodes pour la mise à jour, la suppression, la récupération, etc.
}
