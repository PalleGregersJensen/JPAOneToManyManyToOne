package org.example.jpaonetomanymanytoone.service;

import org.example.jpaonetomanymanytoone.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApiServiceGetRegioner {
    List<Region> getRegioner();
}
