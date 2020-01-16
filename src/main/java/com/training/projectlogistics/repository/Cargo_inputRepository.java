package com.training.projectlogistics.repository;

import com.training.projectlogistics.model.Cargo_input;
import com.training.projectlogistics.model.enums.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Cargo_inputRepository extends JpaRepository<Cargo_input, Long> {
    Optional<Cargo_input> getCargo_inputByCargo(Cargo cargo);
}
