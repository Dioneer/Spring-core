package Pegas.service;

import Pegas.dao.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@ToString
@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public void show(){
        System.out.println(paymentRepository.toString());
    }
}
