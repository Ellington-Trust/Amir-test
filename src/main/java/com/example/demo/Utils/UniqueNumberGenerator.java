package com.example.demo.Utils;
import java.util.UUID;

public class UniqueNumberGenerator {
    public static UUID generateUUID() {
        return UUID.randomUUID();
    }
    public static String generateUUIDString() {
        return UUID.randomUUID().toString();
    }
}
