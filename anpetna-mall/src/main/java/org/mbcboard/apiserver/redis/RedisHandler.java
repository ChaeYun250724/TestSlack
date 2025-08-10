package org.mbcboard.apiserver.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RedisHandler {
    /*- RedisConfig로부터 Redis 설정정보를 받아서 구현하려는 데이터 타입에 따른 객체를 구성하거나 혹은 작업 내용에 따르는 예외처리를 하는 공통 컴포넌트입니다.
1. getListOperations()
- Redis의 리스트 타입 데이터에 접근하여 다양한 연산을 수행할 수 있는 ListOperations 객체를 반환합니다.
2. getValueOperations()
- Redis의 단일 값 데이터에 접근하여 다양한 연산을 수행할 수 있는 ValueOperations 객체를 반환합니다.
3. executeOperation(Runnable operation)
- Redis 작업 중 등록, 수정, 삭제에 대해 처리 및 예외처리를 수행합니다. 작업이 성공적으로 완료되면 1을 반환하고 오류가 발생하면 오류 메시지를 출력하고 0을 반환합니다.*/

    private final RedisConfig redisConfig;

    /**
     * 리스트에 접근하여 다양한 연산을 수행합니다.
     *
     * @return ListOperations<String, Object>
     */
    public ListOperations<String, Object> getListOperations() {
        return redisConfig.getRedisTemplate().opsForList();
    }

    /**
     * 단일 데이터에 접근하여 다양한 연산을 수행합니다.
     *
     * @return ValueOperations<String, Object>
     */
    public ValueOperations<String, Object> getValueOperations() {
        return redisConfig.getRedisTemplate().opsForValue();
    }


    /**
     * Redis 작업중 등록, 수정, 삭제에 대해서 처리 및 예외처리를 수행합니다.
     *
     * @param operation
     * @return
     */
    public int executeOperation(Runnable operation) {
        try {
            operation.run();
            return 1;
        } catch (Exception e) {
            System.out.println("Redis 작업 오류 발생 :: " + e.getMessage());
            return 0;
        }
    }


}
