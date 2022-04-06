package com.codegym.service.impl;

import com.codegym.model.Medican;
import com.codegym.service.IMedicanService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MedicanService implements IMedicanService {
    private static final Map<Integer, Medican> medicanList;

    static {
        medicanList = new HashMap<>();
        medicanList.put(1,new Medican(1,"ngoc","1997-06-27","nữ",
                "Việt Nam","123456789","đhj","vn-12",12,"2022-08-09","2022-08-08","khong","hue","phu loc","hfhj","hfhjg","0987654321","ngoc@gmail.com"));
    }


    @Override
    public List<Medican> findAll() {
        return new ArrayList<>(medicanList.values());
    }
}


