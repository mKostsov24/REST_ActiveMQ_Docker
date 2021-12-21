package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.OutputLogDataDTO;
import org.example.model.Data;
import org.example.repository.DataRepository;
import org.example.service.api.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataServiceImpl implements DataService {

    private final DataRepository repository;

    @Override
    public List<OutputLogDataDTO> getLogData() {
        List<OutputLogDataDTO> logDataDTO = new ArrayList<>();
        repository.getAll().forEach(
                data -> logDataDTO.add(new OutputLogDataDTO(data)));
        return logDataDTO;
    }

    @Override
    public Data getDataById(int id) {
        return repository.getById(id);
    }

    @Override
    public List<Data> getDataByQueue(String queue) {
        return repository.getAllByQueueName(queue);
    }

    @Override
    public List<Data> getDataByDate(Instant dateFrom, Instant dateTo) {
        return repository.getAllByDate(dateFrom, dateTo);
    }
}
