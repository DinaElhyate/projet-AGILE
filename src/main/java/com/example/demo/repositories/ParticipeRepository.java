package com.example.demo.repositories;

import com.example.demo.beans.Assistant;
import com.example.demo.beans.Assistant ;

import com.example.demo.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ParticipeRepository extends JpaRepository<Assistant , Long>

{ public Assistant findUserById(Long id);
}