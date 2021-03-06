package com.zhuanjingkj.stpbe.tmdp.controller;

import com.alibaba.fastjson.JSON;
import com.zhuanjingkj.stpbe.data.dto.ResultDTO;
import com.zhuanjingkj.stpbe.tmdp.dto.*;
import com.zhuanjingkj.stpbe.tmdp.service.impl.*;
import com.zhuanjingkj.stpbe.tmdp.service.VehicleStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * author by guoqiang
 * date on 2020.11.20
 **/

@RestController
@RequestMapping("/vehicle/statistic")
@CrossOrigin(origins = "*")
public class VehicleStatisticController {

    @Autowired
    private VehicleStatisticService vehicleStatisticService;
    @Autowired
    private DkVtieService dkVtieService;
    @Autowired
    private DkVtpService dkVtpService;
    @Autowired
    private DkTitfService dkTitfService;
    @Autowired
    private DkVttfService dkVttfService;
    @Autowired
    private DkHtfsService dkHtfsService;
    @Autowired
    private DkTjrsService dkTjrsService;
    @Autowired
    private DkDctfService dkDctfService;
    @GetMapping()
    public ResultDTO<DkMainDTO> getVehicleStatisticInfo() {
        DkMainDTO mainDto = new DkMainDTO();
        mainDto.setDkHtfs(getDkHtfsDTO_exp()); // 中间上部过车量统计
        // 本地外地车辆占比
        DkVtieDTO vtie = getDkVtie();
        mainDto.setDkVtie(vtie);
        // 车辆类型占比
        List<DkVtpDTO> vtps = getDkVtpDTOs_exp();
        mainDto.setDkVtps(vtps);
        // 分时段过车统计
        DkTitfDTO titf = getDkTitfDTO_exp();
        mainDto.setDkTitf(titf);
        ResultDTO<DkMainDTO> dto = new ResultDTO<>();
        dto.setData(mainDto);
        // 车辆类型流量
        List<DkVttfSeriesDTO> vttfs = getDkVttfSeriesDTOs_exp();
        mainDto.setDkVttf(vttfs);
        // 拥堵路段过车量
        List<DkTjrsItemDTO> tjrss = getDkTjrsItemDTOs_exp();
        mainDto.setDkTjrss(tjrss);
        // 区县过车量
        List<DkDctfItemDTO> dctfs = getDkDctfItemDTOs_exp();
        mainDto.setDkDctfs(dctfs);
        return dto;
    }

    private DkHtfsDTO getDkHtfsDTO_exp() {
        return dkHtfsService.getDkHtfsDTO_exp();
    }

    private DkVtieDTO getDkVtie() {
        return dkVtieService.getDkVtie();
    }

    private List<DkVtpDTO> getDkVtpDTOs_exp() {
        return dkVtpService.getDkVtpDTOs_exp();
    }

    private DkTitfDTO getDkTitfDTO_exp() {
        return dkTitfService.getDkTitfDTO_exp();
    }

    private List<DkVttfSeriesDTO> getDkVttfSeriesDTOs_exp() {
        return dkVttfService.getDkVttfSeriesDTOs_exp();
    }

    private List<DkTjrsItemDTO> getDkTjrsItemDTOs_exp() {
        return dkTjrsService.getDkTjrsItemDTOs_exp();
    }

    private List<DkDctfItemDTO> getDkDctfItemDTOs_exp() {
        return dkDctfService.getDkDctfItemDTOs_exp();
    }


    private String bk() {

//        List<VehicleDistributionDTO> vehicleDistributionList = vehicleStatisticService.getVehicleDistribution();
//
//        List<VehicleTypeDTO> vehicleTypeList = vehicleStatisticService.getVehicleType();
//
//        List<TimeFrameNumberDTO> timeFrameNumberList = vehicleStatisticService.getTimeFrameNumber();
//
//        List<VehicleTypeNumberDTO> vehicleTypeNumberList = vehicleStatisticService.getVehicleTypeNumber();
//
//        List<VehicleStatisticDTO> streetList = vehicleStatisticService.getVehicleStatisticByStreet();
//
//        List<VehicleStatisticDTO> regionList = vehicleStatisticService.getVehicleStatisticByRegion();
//
//        VehiclePassedNumberDTO vehiclePassedNumber = vehicleStatisticService.getVehiclePassedNumber();
//
//        VehicleStatisticListDTO vehicleDistributionListDTO = new VehicleStatisticListDTO();
//        vehicleDistributionListDTO.setVehicleDistributionList(vehicleDistributionList);
//        vehicleDistributionListDTO.setVehicleTypeList(vehicleTypeList);
//        vehicleDistributionListDTO.setTimeFrameNumberList(timeFrameNumberList);
//        vehicleDistributionListDTO.setVehicleTypeNumberList(vehicleTypeNumberList);
//        vehicleDistributionListDTO.setStreetList(streetList);
//        vehicleDistributionListDTO.setRegionList(regionList);
//        vehicleDistributionListDTO.setVehiclePassedNumber(vehiclePassedNumber);


        String s = "{\n" +
                "        \"vehiclePassedNumber\": {\n" +
                "            \"todayPassedNumber\": 555612345,\n" +
                "            \"dailyMean\": 5556123459,\n" +
                "            \"currentMonthPassedNumber\": 555612345988,\n" +
                "            \"sevenDayPassedNumber\": 55561234598\n" +
                "        },\n" +
                "        \"vehicleTypeNumberList\": [\n" +
                "            {\n" +
                "                \"vehicleNumber\": 100,\n" +
                "                \"id\": 1,\n" +
                "                \"vehicleTypeName\": \"小型车\",\n" +
                "                \"timeFrame\": 2\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 80,\n" +
                "                \"id\": 2,\n" +
                "                \"vehicleTypeName\": \"小型车\",\n" +
                "                \"timeFrame\": 4\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 100,\n" +
                "                \"id\": 3,\n" +
                "                \"vehicleTypeName\": \"小型车\",\n" +
                "                \"timeFrame\": 6\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 260,\n" +
                "                \"id\": 4,\n" +
                "                \"vehicleTypeName\": \"小型车\",\n" +
                "                \"timeFrame\": 8\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 500,\n" +
                "                \"id\": 5,\n" +
                "                \"vehicleTypeName\": \"小型车\",\n" +
                "                \"timeFrame\": 10\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 200,\n" +
                "                \"id\": 6,\n" +
                "                \"vehicleTypeName\": \"小型车\",\n" +
                "                \"timeFrame\": 12\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 160,\n" +
                "                \"id\": 7,\n" +
                "                \"vehicleTypeName\": \"小型车\",\n" +
                "                \"timeFrame\": 14\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 320,\n" +
                "                \"id\": 8,\n" +
                "                \"vehicleTypeName\": \"小型车\",\n" +
                "                \"timeFrame\": 16\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 600,\n" +
                "                \"id\": 9,\n" +
                "                \"vehicleTypeName\": \"小型车\",\n" +
                "                \"timeFrame\": 18\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 360,\n" +
                "                \"id\": 10,\n" +
                "                \"vehicleTypeName\": \"小型车\",\n" +
                "                \"timeFrame\": 20\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 280,\n" +
                "                \"id\": 11,\n" +
                "                \"vehicleTypeName\": \"小型车\",\n" +
                "                \"timeFrame\": 22\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 190,\n" +
                "                \"id\": 12,\n" +
                "                \"vehicleTypeName\": \"小型车\",\n" +
                "                \"timeFrame\": 24\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 100,\n" +
                "                \"id\": 13,\n" +
                "                \"vehicleTypeName\": \"中型车\",\n" +
                "                \"timeFrame\": 2\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 120,\n" +
                "                \"id\": 14,\n" +
                "                \"vehicleTypeName\": \"中型车\",\n" +
                "                \"timeFrame\": 4\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 140,\n" +
                "                \"id\": 15,\n" +
                "                \"vehicleTypeName\": \"中型车\",\n" +
                "                \"timeFrame\": 6\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 180,\n" +
                "                \"id\": 16,\n" +
                "                \"vehicleTypeName\": \"中型车\",\n" +
                "                \"timeFrame\": 8\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 150,\n" +
                "                \"id\": 17,\n" +
                "                \"vehicleTypeName\": \"中型车\",\n" +
                "                \"timeFrame\": 10\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 130,\n" +
                "                \"id\": 18,\n" +
                "                \"vehicleTypeName\": \"中型车\",\n" +
                "                \"timeFrame\": 12\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 100,\n" +
                "                \"id\": 19,\n" +
                "                \"vehicleTypeName\": \"中型车\",\n" +
                "                \"timeFrame\": 14\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 125,\n" +
                "                \"id\": 20,\n" +
                "                \"vehicleTypeName\": \"中型车\",\n" +
                "                \"timeFrame\": 16\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 130,\n" +
                "                \"id\": 21,\n" +
                "                \"vehicleTypeName\": \"中型车\",\n" +
                "                \"timeFrame\": 18\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 115,\n" +
                "                \"id\": 22,\n" +
                "                \"vehicleTypeName\": \"中型车\",\n" +
                "                \"timeFrame\": 20\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 120,\n" +
                "                \"id\": 23,\n" +
                "                \"vehicleTypeName\": \"中型车\",\n" +
                "                \"timeFrame\": 22\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 125,\n" +
                "                \"id\": 24,\n" +
                "                \"vehicleTypeName\": \"中型车\",\n" +
                "                \"timeFrame\": 24\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 300,\n" +
                "                \"id\": 25,\n" +
                "                \"vehicleTypeName\": \"大型车\",\n" +
                "                \"timeFrame\": 2\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 500,\n" +
                "                \"id\": 26,\n" +
                "                \"vehicleTypeName\": \"大型车\",\n" +
                "                \"timeFrame\": 4\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 600,\n" +
                "                \"id\": 27,\n" +
                "                \"vehicleTypeName\": \"大型车\",\n" +
                "                \"timeFrame\": 6\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 200,\n" +
                "                \"id\": 28,\n" +
                "                \"vehicleTypeName\": \"大型车\",\n" +
                "                \"timeFrame\": 8\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 100,\n" +
                "                \"id\": 29,\n" +
                "                \"vehicleTypeName\": \"大型车\",\n" +
                "                \"timeFrame\": 10\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 120,\n" +
                "                \"id\": 30,\n" +
                "                \"vehicleTypeName\": \"大型车\",\n" +
                "                \"timeFrame\": 12\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 100,\n" +
                "                \"id\": 31,\n" +
                "                \"vehicleTypeName\": \"大型车\",\n" +
                "                \"timeFrame\": 14\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 90,\n" +
                "                \"id\": 32,\n" +
                "                \"vehicleTypeName\": \"大型车\",\n" +
                "                \"timeFrame\": 16\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 100,\n" +
                "                \"id\": 33,\n" +
                "                \"vehicleTypeName\": \"大型车\",\n" +
                "                \"timeFrame\": 18\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 105,\n" +
                "                \"id\": 34,\n" +
                "                \"vehicleTypeName\": \"大型车\",\n" +
                "                \"timeFrame\": 20\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 180,\n" +
                "                \"id\": 35,\n" +
                "                \"vehicleTypeName\": \"大型车\",\n" +
                "                \"timeFrame\": 22\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleNumber\": 230,\n" +
                "                \"id\": 36,\n" +
                "                \"vehicleTypeName\": \"大型车\",\n" +
                "                \"timeFrame\": 24\n" +
                "            }\n" +
                "        ],\n" +
                "        \"regionList\": [\n" +
                "            {\n" +
                "                \"passedNumber\": 2890,\n" +
                "                \"regionName\": \"海淀区\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"passedNumber\": 1620,\n" +
                "                \"regionName\": \"丰台区\"\n" +
                "            },\n" +

                "            {\n" +
                "                \"passedNumber\": 1680,\n" +
                "                \"regionName\": \"石景山区\"\n" +
                "            },\n" +

                "            {\n" +
                "                \"passedNumber\": 989,\n" +
                "                \"regionName\": \"门头沟区\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"passedNumber\": 1022,\n" +
                "                \"regionName\": \"房山区\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"passedNumber\": 1989,\n" +
                "                \"regionName\": \"顺义区\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"passedNumber\": 1820,\n" +
                "                \"regionName\": \"昌平区\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"passedNumber\": 1780,\n" +
                "                \"regionName\": \"大兴区\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"passedNumber\": 1120,\n" +
                "                \"regionName\": \"怀柔区\"\n" +
                "            },\n" +

                "            {\n" +
                "                \"passedNumber\": 990,\n" +
                "                \"regionName\": \"平谷区\"\n" +
                "            },\n" +

                "            {\n" +
                "                \"passedNumber\": 900,\n" +
                "                \"regionName\": \"密云区\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"passedNumber\": 890,\n" +
                "                \"regionName\": \"延庆区\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"passedNumber\": 3210,\n" +
                "                \"regionName\": \"东城区\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"passedNumber\": 3620,\n" +
                "                \"regionName\": \"西城区\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"passedNumber\": 3200,\n" +
                "                \"regionName\": \"朝阳区\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"passedNumber\": 2998,\n" +
                "                \"regionName\": \"通州区\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"timeFrameNumberList\": [\n" +
                "            {\n" +
                "                \"date\": \"2020-11-26 11:51:55\",\n" +
                "                \"vehicleNumber\": 1230000,\n" +
                "                \"id\": 1,\n" +
                "                \"timeFrame\": 4\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2020-11-26 11:53:50\",\n" +
                "                \"vehicleNumber\": 2080000,\n" +
                "                \"id\": 2,\n" +
                "                \"timeFrame\": 8\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2020-11-26 11:54:01\",\n" +
                "                \"vehicleNumber\": 1598888,\n" +
                "                \"id\": 3,\n" +
                "                \"timeFrame\": 12\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2020-11-26 11:54:11\",\n" +
                "                \"vehicleNumber\": 1982222,\n" +
                "                \"id\": 4,\n" +
                "                \"timeFrame\": 16\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2020-11-26 11:54:32\",\n" +
                "                \"vehicleNumber\": 1120000,\n" +
                "                \"id\": 5,\n" +
                "                \"timeFrame\": 20\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2020-11-26 11:54:49\",\n" +
                "                \"vehicleNumber\": 980000,\n" +
                "                \"id\": 6,\n" +
                "                \"timeFrame\": 24\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2020-11-25 11:55:02\",\n" +
                "                \"vehicleNumber\": 1280000,\n" +
                "                \"id\": 7,\n" +
                "                \"timeFrame\": 4\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2020-11-25 11:55:15\",\n" +
                "                \"vehicleNumber\": 2030000,\n" +
                "                \"id\": 8,\n" +
                "                \"timeFrame\": 8\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2020-11-25 11:55:27\",\n" +
                "                \"vehicleNumber\": 1660000,\n" +
                "                \"id\": 9,\n" +
                "                \"timeFrame\": 12\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2020-11-25 11:55:37\",\n" +
                "                \"vehicleNumber\": 2050000,\n" +
                "                \"id\": 10,\n" +
                "                \"timeFrame\": 16\n" +
                "            },\n" +
                "            {\n" +
                "                \"date\": \"2020-11-25 11:55:37\",\n" +
                "                \"vehicleNumber\": 1028888,\n" +
                "                \"id\": 11,\n" +
                "                \"timeFrame\": 20\n" +
                "            },\n" +

                "            {\n" +
                "                \"date\": \"2020-11-25 11:55:48\",\n" +
                "                \"vehicleNumber\": 660000,\n" +
                "                \"id\": 12,\n" +
                "                \"timeFrame\": 24\n" +
                "            }\n" +
                "        ],\n" +
                "        \"streetList\": [\n" +
                "            {\n" +
                "                \"streetName\": \"上地街十字\",\n" +
                "                \"passedNumber\": 10\n" +
                "            },\n" +
                "            {\n" +
                "                \"streetName\": \"清华大学正门\",\n" +
                "                \"passedNumber\": 8\n" +
                "            },\n" +

                "            {\n" +
                "                \"streetName\": \"国家大剧院十字\",\n" +
                "                \"passedNumber\": 20\n" +
                "            },\n" +

                "            {\n" +
                "                \"streetName\": \"西华门十字\",\n" +
                "                \"passedNumber\": 15\n" +
                "            },\n" +

                "            {\n" +
                "                \"streetName\": \"天安门广场\",\n" +
                "                \"passedNumber\": 18\n" +
                "            },\n" +

                "            {\n" +
                "                \"streetName\": \"朝阳大街十字\",\n" +
                "                \"passedNumber\": 12\n" +
                "            },\n" +

                "            {\n" +
                "                \"streetName\": \"中关村十字\",\n" +
                "                \"passedNumber\": 11\n" +
                "            },\n" +

                "            {\n" +
                "                \"streetName\": \"上地西里十字\",\n" +
                "                \"passedNumber\": 15\n" +
                "            },\n" +

                "            {\n" +
                "                \"streetName\": \"上地东里十字\",\n" +
                "                \"passedNumber\": 16\n" +
                "            },\n" +

                "            {\n" +
                "                \"streetName\": \"西二旗街十字\",\n" +
                "                \"passedNumber\": 19\n" +
                "            }\n" +

                "        ],\n" +
                "        \"vehicleDistributionList\": [\n" +
                "            {\n" +
                "                \"vehicleDistributionPercntage\": \"0.62\",\n" +
                "                \"id\": 1,\n" +
                "                \"vehicleDistributionName\": \"本市车辆\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleDistributionPercntage\": \"0.38\",\n" +
                "                \"id\": 2,\n" +
                "                \"vehicleDistributionName\": \"外埠\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"vehicleTypeDTOList\": [\n" +
                "            {\n" +
                "                \"vehicleTypePercentage\": \"0.41\",\n" +
                "                \"id\": 1,\n" +
                "                \"vehicleTypeName\": \"小汽车\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleTypePercentage\": \"0.23\",\n" +
                "                \"id\": 2,\n" +
                "                \"vehicleTypeName\": \"SUV\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleTypePercentage\": \"0.11\",\n" +
                "                \"id\": 3,\n" +
                "                \"vehicleTypeName\": \"MPV\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleTypePercentage\": \"0.06\",\n" +
                "                \"id\": 4,\n" +
                "                \"vehicleTypeName\": \"面包车\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleTypePercentage\": \"0.09\",\n" +
                "                \"id\": 5,\n" +
                "                \"vehicleTypeName\": \"罐式货车\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"vehicleTypePercentage\": \"0.1\",\n" +
                "                \"id\": 6,\n" +
                "                \"vehicleTypeName\": \"普通货车\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }" ;
        Object j = JSON.parse(s);
        return s;
        //return ResultDTO.success(j);
    }

}
