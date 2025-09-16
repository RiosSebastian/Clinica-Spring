package com.example.HospitalConSpring.repository;

import com.example.HospitalConSpring.entity.Doctores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface DoctoresRepository extends JpaRepository<Doctores, Long> {


}
