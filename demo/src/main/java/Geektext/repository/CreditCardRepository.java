package Geektext.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geektext.controller.CreditCard;


public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}

