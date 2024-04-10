package Pegas.service;

import Pegas.dao.PaymentRepository;
import Pegas.entity.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public List<Integer> findByReceiverId(Long id){
        List<Integer>arr = paymentRepository.findByReceiverId(id);
        return arr;
    }
}
