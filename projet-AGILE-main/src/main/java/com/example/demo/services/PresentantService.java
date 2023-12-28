package com.example.demo.services;

import com.example.demo.beans.Presentant;

import java.util.List;

public interface PresentantService {
    Presentant addPresentant(Presentant presentant);

    List<Presentant> getAllPresentants();

    Presentant getPresentantById(Long id);
}