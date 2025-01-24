package com.example.Producer.Controller;

import com.example.Producer.DTO.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaTemplate<String,OrderDTO> kafkaTemplate;

    @Value("${spring.kafka.template.default-topic}")
    private String defaultTopic;

    @GetMapping("/orderPlaced")
    public String sendMessage(@RequestBody OrderDTO orderDTO)
    {
        kafkaTemplate.send(defaultTopic,orderDTO);
        return "Message sent to consumer";
    }
}
