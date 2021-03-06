package com.zhuanjingkj.stpbe.common.tvis;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhuanjingkj.stpbe.common.AppConst;
import com.zhuanjingkj.stpbe.common.BmyDao;
import com.zhuanjingkj.stpbe.common.net.HttpUtil;
import com.zhuanjingkj.stpbe.data.dto.BmyDTO;
import com.zhuanjingkj.stpbe.data.dto.BrandDTO;
import com.zhuanjingkj.stpbe.data.dto.ModelDTO;
import com.zhuanjingkj.stpbe.data.vo.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TvisUtil {
    public final static String ERROR_RESPONSE = "ERROR";

    /**
     * 上传图片返回图片JSON格式识别结果
     * @param map
     * @param f
     * @return
     */
    public static String recognizeImageFile(Map<String, Object> map, File f) {
        String type = "file";
        String url = AppConst.TVIS_SERVER_URL;
        return processTvisImage(url, type, map, f);
    }

    /**
     * 提交抓拍机图片，只返回成功失败处理结果
     * @param map
     * @param f
     * @return
     */
    public static String submitTvisImage(Map<String, Object> map, File f) {
        String type = "file";
        String url = AppConst.TVIS_SUBMIT_IMAGE_URL;
        return processTvisImage(url, type, map, f);
    }

    private static String processTvisImage(String url, String type, Map<String, Object> map, File f) {
        boolean sendName = true;

        String response = null;
        try {
            if ("file".equals(type)) {
                map.put("TPXX", f);
                map.put("TPLX", "1");
                System.out.println("recognizeImageFile.recognizeImageFile 1");
                response = HttpUtil.postFile(url, map);
                System.out.println("recognizeImageFile.recognizeImageFile 2 response:" + response + "!");
            } else {
                map.put("TPLX", "2");
                map.put("TPXX", Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(f)));
                response = HttpUtil.postString(url, map);
            }
            map.clear();
            map = null;
        } catch (IOException ex) {
            return ERROR_RESPONSE;
        }
        if (isSuccessRequest(response)) {
            return response;
        } else {
            return ERROR_RESPONSE;
        }
    }

    private static boolean isSuccessRequest(String response) {
        try {
            JSONObject json = JSONObject.parseObject(response); //JSONUtil.parseObj(response);
            Integer code = json.getIntValue("CODE"); //json.getInt("CODE");
            if (Integer.valueOf(1).equals(code)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static List<VehicleVo> parseTvisJson(long cameraId, String json) {
        JSONObject rstJson = JSONObject.parseObject(json);
        long streamId = rstJson.getLong("StreamID");

        // 获取特征向量
        JSONArray vehs = rstJson.getJSONArray("VEH");
        JSONObject vehJson = null;
        JSONObject cxtzJson = null;
        JSONObject wztzJson = null;
        JSONObject jsxwtzJson = null;
        JSONObject gxhtzJson = null;
        List<VehicleVo> vos = new ArrayList<>();
        VehicleVo vo = null;
        VehicleWztzVo vehicleWztzVo = null;
        VehicleHptzVO hptzVO = null;
        VehicleCxtzVo vehicleCxtzVo = null;
        VehicleCltzxlVo vehicleCltzxlVo = null;
        VehicleJsxwtzVO vehicleJsxwtzVO = null;
        VehicleGxhtzVO vehicleGxhtzVO = null;
        for (Object veh : vehs) {
            vehJson = (JSONObject) veh;
            vo = new VehicleVo();
            vo.setOccurTime(vehJson.getString("OCCUR_TIME"));
            vo.setCameraId(cameraId);
            vo.setStreamId(streamId);
            vo.setTrackId(vehJson.getLong("TRACK_ID"));
            // 位置特征解析
            vehicleWztzVo = new VehicleWztzVo();
            wztzJson = vehJson.getJSONObject("WZTZ");
            vehicleWztzVo.setPsfx(wztzJson.getString("PSFX"));
            vehicleWztzVo.setClwz(wztzJson.getString("CLWZ"));
            vo.setVehicleWztzVo(vehicleWztzVo);
            // 解析号牌特征
            vo.setVehicleHptzVO(parseHptzJson(vehJson.getJSONObject(AppConst.TJ_HPTZ)));
            // 车型特征
            vehicleCxtzVo = new VehicleCxtzVo();
            cxtzJson = vehJson.getJSONObject("CXTZ");
            vehicleCxtzVo.setCllxflCode(cxtzJson.getString("CLLXFL"));
            vehicleCxtzVo.setCllxzflCode(cxtzJson.getString("CLLXZFL"));
            vehicleCxtzVo.setClppCode(cxtzJson.getString("CLPP"));
            vehicleCxtzVo.setPpcxCode(cxtzJson.getString("PPCX"));
            vehicleCxtzVo.setCxnkCode(cxtzJson.getString("CXNK"));
            vehicleCxtzVo.setPpxhmsCode(cxtzJson.getString("PPXHMS"));
            vehicleCxtzVo.setCsysCode(cxtzJson.getString("CSYS"));
            vo.setVehicleCxtzVo(vehicleCxtzVo);
            // 车辆特征向量
            vehicleCltzxlVo = new VehicleCltzxlVo();
            vehicleCltzxlVo.setCltzxl(generateTzxl(vehJson.getString("CLTZXL")));
            vo.setVehicleCltzxlVo(vehicleCltzxlVo);
            // 驾驶行为特征
            vehicleJsxwtzVO = new VehicleJsxwtzVO();
            jsxwtzJson = vehJson.getJSONObject("JSXWTZ");
            vehicleJsxwtzVO.setFjsbjaqd(jsxwtzJson.getString("FJSBJAQD"));
            vehicleJsxwtzVO.setFjszyb(jsxwtzJson.getString("FJSZYB"));
            vehicleJsxwtzVO.setMtcbdtk(jsxwtzJson.getString("MTCBDTK"));
            vehicleJsxwtzVO.setZjsbjaqd(jsxwtzJson.getString("ZJSBJAQD"));
            vehicleJsxwtzVO.setZjscy(jsxwtzJson.getString("ZJSCY"));
            vehicleJsxwtzVO.setZjsddh(jsxwtzJson.getString("ZJSDDH"));
            vehicleJsxwtzVO.setZjsksj(jsxwtzJson.getString("ZJSKSJ"));
            vehicleJsxwtzVO.setZjszyb(jsxwtzJson.getString("ZJSZYB"));
            vo.setVehicleJsxwtzVO(vehicleJsxwtzVO);
            // 个性化特征
            vehicleGxhtzVO = new VehicleGxhtzVO();
            gxhtzJson = vehJson.getJSONObject("GXHTZ");
            vehicleGxhtzVO.setCcztw(gxhtzJson.getString("CCZTW"));
            vehicleGxhtzVO.setBj(gxhtzJson.getString("BJ"));
            vehicleGxhtzVO.setGj(gxhtzJson.getString("GJ"));
            vehicleGxhtzVO.setTc(gxhtzJson.getString("TC"));
            vehicleGxhtzVO.setXlj(gxhtzJson.getString("XLJ"));
            vehicleGxhtzVO.setDcjqs(gxhtzJson.getString("DCJQS"));
            vehicleGxhtzVO.setCszt(gxhtzJson.getString("CSZT"));
            vehicleGxhtzVO.setCsps(gxhtzJson.getString("CSPS"));
            vehicleGxhtzVO.setCsgh(gxhtzJson.getString("CSGH"));
            vehicleGxhtzVO.setCsch(gxhtzJson.getString("CSCH"));
            vo.setVehicleGxhtzVO(vehicleGxhtzVO);

            vos.add(vo);
        }
        return vos;
    }

    private static VehicleHptzVO parseHptzJson(JSONObject hptzJson) {
        VehicleHptzVO hptzVO = new VehicleHptzVO(
                hptzJson.getString(AppConst.TJ_HPTZ_HPZT),
                hptzJson.getString(AppConst.TJ_HPTZ_HPWZ),
                hptzJson.getString(AppConst.TJ_HPTZ_HPZL),
                hptzJson.getString(AppConst.TJ_HPTZ_HPYS),
                hptzJson.getString(AppConst.TJ_HPTZ_HPGG),
                hptzJson.getString(AppConst.TJ_HPTZ_HPHM),
                hptzJson.getString(AppConst.TJ_HPTZ_HPKXD),
                hptzJson.getString(AppConst.TJ_HPTZ_MWHPKXD),
                hptzJson.getString(AppConst.TJ_HPTZ_YWLSHP)
        );
        return hptzVO;
    }



    private static List<Float> generateTzxl(String vecStr) {
        List<Float> tzxl = new ArrayList<>();
        String[] arrs = vecStr.split(",");
        for (String item : arrs) {
            try {
                tzxl.add(Float.parseFloat(item));
            } catch (Exception ex) {
                tzxl.add(0.0f);
            }
        }
        return tzxl;
    }
}
