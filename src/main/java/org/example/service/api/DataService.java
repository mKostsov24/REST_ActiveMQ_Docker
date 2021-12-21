package org.example.service.api;

import org.example.dto.OutputLogDataDTO;
import org.example.model.Data;

import java.time.Instant;
import java.util.List;

public interface DataService {
    List<OutputLogDataDTO> getLogData();
    Data getDataById(int id);
    List<Data> getDataByQueue(String queue);
    List<Data> getDataByDate(Instant dateFrom, Instant dateTo);
}
