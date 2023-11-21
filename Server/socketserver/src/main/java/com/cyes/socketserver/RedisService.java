package com.cyes.socketserver;



import com.cyes.socketserver.stomp.dto.SubmitRedis;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@Slf4j
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate StringRedisTemplate;
    private final ObjectMapper objectMapper;

    /**
     * key로 Redis에 저장된 값(String)을 조회하는 메서드 ( 문제 출제 시간 조회, 제출된 답안 조회 )
     * @param key
     * @return key에 대한 value
     */
    public String getDataFromRedis(String key) {
        return StringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 클라이언트가 보낸 답안 정보를 Redis에 기록하는 메소드
     * @param key
     * @param submitRedis (답안 제출 정보)
     * @param duration
     * @throws JsonProcessingException
     */
    public void setSubmitDateRedis(String key, SubmitRedis submitRedis, Duration duration) throws JsonProcessingException {

        ValueOperations<String, String> valueOperations = StringRedisTemplate.opsForValue();

        // SubmitRedis객체를 String으로 직렬화한다.
        String valueStr = objectMapper.writeValueAsString(submitRedis);
        // Redis에 답안 제출 정보(String) 데이터 저장
        valueOperations.set(key, valueStr, duration);
    }

}
