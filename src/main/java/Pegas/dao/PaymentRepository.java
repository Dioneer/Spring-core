package Pegas.dao;

import Pegas.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query(value = "select p.amount from Payment p where p.receiver_id = :paymentId)", nativeQuery = true)
    List<Integer> findByReceiverId(Long paymentId);
}
