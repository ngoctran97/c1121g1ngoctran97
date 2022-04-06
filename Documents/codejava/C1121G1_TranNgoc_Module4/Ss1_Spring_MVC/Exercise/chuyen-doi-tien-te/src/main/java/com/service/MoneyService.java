package com.service;

import org.springframework.stereotype.Service;

@Service
public class MoneyService implements IMoneyService {
    @Override
    public int convert(int usd) {
        int result = usd * 23000;
        return result;
    }
}
