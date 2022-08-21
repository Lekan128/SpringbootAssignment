package com.example.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Controls everything to do with the payload
@Service
public class PayloadService {
    @Autowired
    private PayloadRepository payloadRepository;

    public List<Payload> getAllPayloads() {
        List<Payload> payloads = new ArrayList<>();
        payloadRepository.findAll().forEach(payloads::add);
        return payloads;
    }

    public Payload getPayloadWithShipperId(String shipperId) {
        return payloadRepository.findById(shipperId).orElseGet(Payload::new);

    }


    public String addToPayloads(Payload payload) {
        payloadRepository.save(payload);
        return "loads details added successfully \n";

    }

    public void updatePayload(String shipperId, Payload payloadUpdate) {
        payloadUpdate.setShipperId(shipperId);
        payloadRepository.save(payloadUpdate);

        return;
    }

    public void deletePayload(String shipperId) {
        payloadRepository.deleteById(shipperId);
    }

}
