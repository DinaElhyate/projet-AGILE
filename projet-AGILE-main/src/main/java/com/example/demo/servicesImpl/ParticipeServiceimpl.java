package com.example.demo.servicesImpl;

import com.example.demo.beans.Assistant;
import com.example.demo.repositories.ParticipeRepository;
import com.example.demo.services.ParticipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ParticipeServiceimpl implements ParticipeService {

    @Autowired
    private ParticipeRepository participeRepository;

    @Override
    public Assistant create(Assistant participe) {
        return participeRepository.save(participe);
    }

    @Override
    public Assistant  update(Assistant participe, Long id) {
        Assistant  existingParticipe = participeRepository.findById(id).orElse(null);

        if (existingParticipe != null) {
            // Mettez à jour toutes les propriétés de l'entité existante avec celles de la nouvelle entité
            existingParticipe.setFirstname(participe.getFirstname());
            existingParticipe.setLastname(participe.getLastname());
            existingParticipe.setEmail(participe.getEmail());
            existingParticipe.setResearchStructure(participe.getResearchStructure());
            existingParticipe.setUniversity(participe.getUniversity());
            existingParticipe.setStatus(participe.getStatus());


            return participeRepository.save(existingParticipe);
        } else {
            // Gérer le cas où la participe avec l'ID spécifié n'est pas trouvée
            return null;
        }
    }



    @Override
    public String delete(Long id) {
        participeRepository.deleteById(id);
        return "Participe has been deleted successfully";
    }

    @Override
    public Assistant  get(Long id) {
        return participeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Assistant > getAll() {
        return (List<Assistant >) participeRepository.findAll();
    }
}