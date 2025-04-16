package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class StatusService {
    private static final String BASE_PATH = "spring fundamentals/";
    
    private enum PathType {
        HELLO("hello"),
        GOODBYE("goodbye"),
        SUCCESS("succeeded");
        
        private final String path;
        
        PathType(String path) {
            this.path = BASE_PATH + path;
        }
        
        public String getFullPath() {
            return path;
        }
    }

    public String processStatus(PathType pathType) {
        return pathType.getFullPath();
    }
}