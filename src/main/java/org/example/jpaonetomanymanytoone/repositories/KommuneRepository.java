package org.example.jpaonetomanymanytoone.repositories;

import org.example.jpaonetomanymanytoone.model.Kommune;
import org.example.jpaonetomanymanytoone.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KommuneRepository extends JpaRepository<Kommune, String> {

}
