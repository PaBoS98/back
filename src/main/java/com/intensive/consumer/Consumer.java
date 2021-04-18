package com.intensive.consumer;

import com.google.gson.Gson;
import com.intensive.Repository.UsRepository;
import com.intensive.dto.UserDto;
import com.intensive.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Queue;

@Component
public class Consumer {

    @Autowired
    private UsRepository usRepository;

    private final Queue<UserDto> messages = new ArrayDeque<>();

    @KafkaListener(topics = "my-replicated-topic", groupId = "group1")
    public void listen(String message) {

        synchronized (messages) {
//            messages.add(new UserEntity(message.getAge(), message.getName()));
            Gson gson = new Gson();
            System.out.println(message);
            messages.add(gson.fromJson(message, UserDto.class));
            UserDto userDto = messages.poll();
            usRepository.addToDB(new UserEntity(userDto.getAge(), userDto.getName()));
        }
    }
}
