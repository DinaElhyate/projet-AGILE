package com.example.demo.services;

import com.example.demo.beans.Assistant;
import com.example.demo.beans.Assistant ;

import java.util.List;

public interface ParticipeService {
    Assistant create(Assistant  participe);
    Assistant  update(Assistant  participe, Long id);
    String delete(Long id);
    Assistant  get(Long id);
    List<Assistant > getAll();
}
