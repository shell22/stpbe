package com.zhuanjingkj.stpbe.tebs.scs;

import com.zhuanjingkj.stpbe.data.vo.VehicleVo;
import org.springframework.core.env.Environment;

public interface ITvisStpObserver {
    public void notifyObserver(VehicleVo vo);
    public void initialize(Environment env);
}
