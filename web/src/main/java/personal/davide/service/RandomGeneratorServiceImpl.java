package personal.davide.service;

import org.springframework.stereotype.Service;

@Service
public class RandomGeneratorServiceImpl implements  RandomGeneratorService {
    @Override
    public int generateRandom() {
        return (int)(Math.random() * 100);
    }
}
