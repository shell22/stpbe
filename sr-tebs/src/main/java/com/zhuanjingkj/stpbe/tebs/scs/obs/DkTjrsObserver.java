package com.zhuanjingkj.stpbe.tebs.scs.obs;

import com.zhuanjingkj.stpbe.data.vo.VehicleVo;
import com.zhuanjingkj.stpbe.tebs.scs.ITvisStpObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 首页路段过车统计
 */
@Component
public class DkTjrsObserver implements ITvisStpObserver {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void notifyObserver(VehicleVo vo) {
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000001", 1);
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000002", 2);
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000003", 3);
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000004", 4);
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000005", 5);
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000006", 6);
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000007", 7);
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000008", 8);
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000009", 9);
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000010", 10);
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000011", 11);
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000012", 12);
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000013", 13);
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000014", 14);
        redisTemplate.opsForHash().increment("dk_tjrs_road", "C0000015", 10);
    }

    @Override
    public void initialize(Environment env) {

    }
}
