package com.example.Consumer.Service;

import com.example.Consumer.DTO.OrderDTO;
import com.example.Consumer.DTO.OrderItemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final JavaMailSender mailSender;

    @KafkaListener(topics="Order-Placed",groupId="consumer-group")
    public void consumeOrder(OrderDTO order)
    {
        int totalBill=0;
        List<OrderItemDTO> items=order.getItems();
        for(OrderItemDTO item: items)
        {
            totalBill+=item.getQuantity()*item.getPrice();
        }
        UUID orderId=UUID.randomUUID();

        sendMail(order.getEmail(),orderId,totalBill);
    }

    public void sendMail(String email,UUID orderId,int totalBill)
    {
        String body=String.format("Your order has been placed successfully, order-id is %s and the total bill is $%d", orderId, totalBill);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Order placed");
        message.setText(body);
        message.setFrom("20cs156.shreyas@sjec.ac.in");
        mailSender.send(message);
    }
}
