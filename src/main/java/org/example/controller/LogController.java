package org.example.controller;

import org.example.dto.OutputLogDataDTO;
import org.example.model.Data;
import org.example.service.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/")
public class LogController {

    private final DataServiceImpl dataService;

    @Autowired
    public LogController(DataServiceImpl dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public List<OutputLogDataDTO> getLogData() {
        return dataService.getLogData();
    }

    @GetMapping("{id}")
    public Data getLogDataById(@PathVariable("id") int id) {
        return dataService.getDataById(id);
    }

    @GetMapping("/byQueue")
    public List<Data> getLogDataById(@RequestParam(name = "queue", defaultValue = "queue-1") String queue) {
        return dataService.getDataByQueue(queue);
    }

    @GetMapping("/byDate")
    public List<Data> getLogDataByDate(@RequestParam("from") Instant dateFrom,
                                       @RequestParam("to") Instant dateTo) {
        return dataService.getDataByDate(dateFrom, dateTo);
    }
}