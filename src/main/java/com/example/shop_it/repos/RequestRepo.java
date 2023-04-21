package com.example.shop_it.repos;

import com.example.shop_it.models.RequestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository<RequestModel, Long> {
}
