package org.example.jpaonetomanymanytoone.repositories;

import org.example.jpaonetomanymanytoone.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, String> {

}
