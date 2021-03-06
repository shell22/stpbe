package com.zhuanjingkj.stpbe.tebs.scs.obs;

import com.zhuanjingkj.stpbe.common.AppRegistry;
import com.zhuanjingkj.stpbe.common.mapper.DcHpMapper;
import com.zhuanjingkj.stpbe.data.dto.DcHpDTO;
import com.zhuanjingkj.stpbe.data.vo.VehicleVo;
import com.zhuanjingkj.stpbe.tebs.scs.ITvisStpObserver;
import com.zhuanjingkj.stpbe.tebs.util.PropUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DcHpObserver implements ITvisStpObserver {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DcHpMapper dcHpMapper;

    @Override
    public void notifyObserver(VehicleVo vo) {
        /**
         * 1.识别对象
         */
        String time = vo.getOccurTime() == null ? LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : vo.getOccurTime();
        String hphm = vo.getVehicleHptzVO().getHphm();
        long cameraId = vo.getCameraId();
        String ilType = "";
        String isIl = "0";
        String cllxzfl = vo.getVehicleCxtzVo().getCllxzflCode();
        long tvisJsonId = vo.getTvisJsonId();
        String tblName = AppRegistry.tvisJsonTblName;
        DcHpDTO dcHpDTO = null;
        String category = "0";
        String hphm_pre = PropUtil.getValue("hphm.native.prefix");
        if(!hphm.contains(hphm_pre)) {
            category = "1";
        }

        if(isViolation(vo.getVehicleJsxwtzVO().getZjsddh())) {
            ilType = "ZJSDDH";
            isIl = "1";
            dcHpDTO = new DcHpDTO(0,time,"" + cameraId,hphm,category,isIl,ilType,"");
            insertItfVehicle(dcHpDTO, tvisJsonId, tblName, cllxzfl);
            violation(category);
        }
        if(isViolation(vo.getVehicleJsxwtzVO().getFjsbjaqd())) {
            ilType = "FJSBJAQD";
            isIl = "1";
            dcHpDTO = new DcHpDTO(0,time,"" + cameraId,hphm,category,isIl,ilType,"");
            insertItfVehicle(dcHpDTO, tvisJsonId, tblName, cllxzfl);
            violation(category);
        }
        if(isViolation(vo.getVehicleJsxwtzVO().getFjszyb())) {
            ilType = "FJSZYB";
            isIl = "1";
            dcHpDTO = new DcHpDTO(0,time,"" + cameraId,hphm,category,isIl,ilType,"");
            insertItfVehicle(dcHpDTO, tvisJsonId, tblName, cllxzfl);
            violation(category);
        }
        if(isViolation(vo.getVehicleJsxwtzVO().getZjsbjaqd())) {
            ilType = "ZJSBJAQD";
            isIl = "1";
            dcHpDTO = new DcHpDTO(0,time,"" + cameraId,hphm,category,isIl,ilType,"");
            insertItfVehicle(dcHpDTO, tvisJsonId, tblName, cllxzfl);
            violation(category);
        }
        if(isViolation(vo.getVehicleJsxwtzVO().getZjscy())) {
            ilType = "ZJSCY";
            isIl = "1";
            dcHpDTO = new DcHpDTO(0,time,"" + cameraId,hphm,category,isIl,ilType,"");
            insertItfVehicle(dcHpDTO, tvisJsonId, tblName, cllxzfl);
            violation(category);
        }
        if(isViolation(vo.getVehicleJsxwtzVO().getZjsksj())) {
            ilType = "ZJSKSJ";
            isIl = "1";
            dcHpDTO = new DcHpDTO(0,time,"" + cameraId,hphm,category,isIl,ilType,"");
            insertItfVehicle(dcHpDTO, tvisJsonId, tblName, cllxzfl);
            violation(category);
        }
        if(isViolation(vo.getVehicleJsxwtzVO().getZjszyb())) {
            ilType = "ZJSZYB";
            isIl = "1";
            dcHpDTO = new DcHpDTO(0,time,"" + cameraId,hphm,category,isIl,ilType,"");
            insertItfVehicle(dcHpDTO, tvisJsonId, tblName, cllxzfl);
            violation(category);
        }
        if(isViolation(vo.getVehicleJsxwtzVO().getMtcbdtk())) {
            ilType = "MTCBDTK";
            isIl = "1";
            dcHpDTO = new DcHpDTO(0,time,"" + cameraId,hphm,category,isIl,ilType,"");
            insertItfVehicle(dcHpDTO, tvisJsonId, tblName, cllxzfl);
            violation(category);
        }

        if("0".equals(isIl)) {
            dcHpDTO = new DcHpDTO(0,time,"" + cameraId,hphm,category,isIl,ilType,"");
            insertItfVehicle(dcHpDTO, tvisJsonId, tblName, cllxzfl);
        }

        redisTemplate.opsForValue().increment("dchp_vehicle_identification"); //车辆识别数量

    }

    @Override
    public void initialize(Environment env) {

    }

    private static boolean isViolation(String str) {
        boolean flag = false;
        if(StringUtils.isNotBlank(str)) {
            String state = str.split("_")[0];
            String rb = str.split("_")[1];
            if("1".equals(state) && "80".compareTo(rb) == -1) { //违章
               flag = true;
            }
        }
        return flag;
    }

    private void  insertItfVehicle(DcHpDTO dcHpDTO, long tvisJsonId, String tvisJsonTbl, String cllxzfl) {
        dcHpMapper.insertItfVehicle(dcHpDTO, tvisJsonTbl, tvisJsonId, cllxzfl);
    }

    private void violation(String category) {
        redisTemplate.opsForValue().increment("dchp_vehicle_violation"); //车辆违章数量
        if("0".equals(category)) {
            redisTemplate.opsForValue().increment("dchp_vehicle_0_violation"); //本市车辆违章数量
        } else if("1".equals(category)) {
            redisTemplate.opsForValue().increment("dchp_vehicle_1_violation"); //外埠车辆违章数量
        }
    }

}
