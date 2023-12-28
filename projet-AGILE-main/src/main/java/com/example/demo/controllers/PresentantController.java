package com.example.demo.controllers;

import com.example.demo.beans.Presentant;
import com.example.demo.services.PresentantService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/presentants")
public class PresentantController {

    @Autowired
    private PresentantService presentantService;

    @PostMapping("/add")
    public ResponseEntity<Presentant> addPresentant(
            @RequestParam("file") MultipartFile file,
            @RequestParam("presentant") String presentantJson
    ) {
        try {
            // Convertir la représentation JSON du présentant en objet Presentant
            ObjectMapper objectMapper = new ObjectMapper();
            Presentant presentant = objectMapper.readValue(presentantJson, Presentant.class);

            // Vérifier si un fichier PDF est attaché
            if (!file.isEmpty()) {
                byte[] pdfBytes = file.getBytes();
                presentant.setPdfFile(pdfBytes);
            }

            Presentant addedPresentant = presentantService.addPresentant(presentant);

            return new ResponseEntity<>(addedPresentant, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<List<Presentant>> getAllPresentants() {
        List<Presentant> presentants = presentantService.getAllPresentants();

        if (presentants.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(presentants, HttpStatus.OK);
        }
    }
    //cette methode pour visualiser le pdf
    @GetMapping("/pdf/{id}")
    public ResponseEntity<byte[]> getPdfById(@PathVariable Long id) {
        Presentant presentant = presentantService.getPresentantById(id);

        if (presentant == null || presentant.getPdfFile() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.builder("inline").filename("presentation.pdf").build());

        return new ResponseEntity<>(presentant.getPdfFile(), headers, HttpStatus.OK);
    }

    // Ajoutez d'autres méthodes pour la mise à jour, la suppression, la récupération, etc.
}