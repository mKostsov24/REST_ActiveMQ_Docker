package org.example.controller;

import org.example.amq.JmsProducer;
import org.example.dto.InputDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class InputController {

    private final JmsProducer jmsProducer;

    @Autowired
    public InputController(JmsProducer jmsProducer) {
        this.jmsProducer = jmsProducer;
    }

    @PostMapping
    public void addPost(@RequestBody List<InputDataDTO> dataDTO) {
        jmsProducer.send(dataDTO);
    }
}
