package com.zhuanjingkj.stpbe.tmdp.dto.dm;

import com.alibaba.fastjson.annotation.JSONField;
import com.zhuanjingkj.stpbe.data.dto.BaseDTO;

public class DmDeviceDTO extends BaseDTO {
    @JSONField(name = "deviceNo")
    private String deviceNo; //设备编号
    @JSONField(name = "cityCode")
    private String cityCode; //城市编号
    @JSONField(name = "cityName")
    private String cityName; //城市名称
    @JSONField(name = "deviceType")
    private String deviceType; //设备类型
    @JSONField(name = "deviceNode")
    private String deviceNode; //所属节点
    @JSONField(name = "deviceDirection")
    private String deviceDirection; //朝向
    @JSONField(name = "vehicleDirection")
    private String vehicleDirection; //车辆方向
    @JSONField(name = "videoUrl")
    private String videoUrl; //视频流地址

    public DmDeviceDTO(String deviceNo, String cityCode, String cityName, String deviceType,
                       String deviceNode, String deviceDirection, String vehicleDirection, String videoUrl) {
        this.deviceNo = deviceNo;
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.deviceType = deviceType;
        this.deviceNode = deviceNode;
        this.deviceDirection = deviceDirection;
        this.vehicleDirection = vehicleDirection;
        this.videoUrl = videoUrl;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceNode() {
        return deviceNode;
    }

    public void setDeviceNode(String deviceNode) {
        this.deviceNode = deviceNode;
    }

    public String getDeviceDirection() {
        return deviceDirection;
    }

    public void setDeviceDirection(String deviceDirection) {
        this.deviceDirection = deviceDirection;
    }

    public String getVehicleDirection() {
        return vehicleDirection;
    }

    public void setVehicleDirection(String vehicleDirection) {
        this.vehicleDirection = vehicleDirection;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
