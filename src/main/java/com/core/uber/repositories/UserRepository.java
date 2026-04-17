package com.core.uber.repositories;

import com.core.uber.models.Rider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Rider, Long> {


   String  findByPhoneNumber(String phoneNumber);
}
