package org.mbcboard.apiserver.redis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("lcytest")
public class RedisConfigTests {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    void redisTemplateString() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String key = "name";
        valueOperations.set(key, "giraffe");
        String value = valueOperations.get(key);
        Assertions.assertEquals(value, "giraffe");
    }

    @Autowired
    private PersonRepository personRepository;

    @Test
    void test() {
        Person person = new Person("Giraffe", "Kim");
        personRepository.save(person);

        Person person2 = new Person("turtle", "Kim");
        personRepository.save(person2);

        personRepository.findById(person.getId());
//        personRepository.delete(person);
    }
}
