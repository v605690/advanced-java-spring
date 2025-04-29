package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class StatusService {

    public String processStatus(PathType pathType) {
        return pathType.getFullPath();
    }
}