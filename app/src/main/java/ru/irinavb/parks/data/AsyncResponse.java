package ru.irinavb.parks.data;

import java.util.List;

import ru.irinavb.parks.model.Park;

public interface AsyncResponse {
    void processPark(List<Park> parks);
}
