package com.higherAchievers.repository;

import com.higherAchievers.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {


}
