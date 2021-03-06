package com.zhuanjingkj.stpbe.common;

import com.zhuanjingkj.stpbe.data.dto.BmyDTO;
import com.zhuanjingkj.stpbe.data.dto.BrandDTO;
import com.zhuanjingkj.stpbe.data.dto.ModelDTO;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class BmyDao {
    public static BrandDTO getBrandDTOByCode(MongoTemplate mongoTemplate, String brandCode) {
        Query query = Query.query(Criteria.where("brand_code").is(brandCode));
        return mongoTemplate.findOne(query, BrandDTO.class);
    }

    public static BrandDTO getBrandDTOById(MongoTemplate mongoTemplate, int brandId) {
        Query query = Query.query(Criteria.where("brand_id").is(brandId));
        return mongoTemplate.findOne(query, BrandDTO.class);
    }

    public static ModelDTO getModelDTOByCode(MongoTemplate mongoTemplate, String modelCode) {
        Query modelQuery = Query.query(Criteria.where("model_code").is(modelCode));
        return mongoTemplate.findOne(modelQuery, ModelDTO.class);
    }

    public static ModelDTO getModelDTOById(MongoTemplate mongoTemplate, int modelId) {
        Query query = Query.query(Criteria.where("model_id").is(modelId));
        return mongoTemplate.findOne(query, ModelDTO.class);
    }

    public static BmyDTO getBmyDTOByCode(MongoTemplate mongoTemplate, String bmyCode) {
        Query bmyQuery = Query.query(Criteria.where("bmy_code").is(bmyCode + " "));
        BmyDTO bmyDTO = null;
        try {
            bmyDTO = mongoTemplate.findOne(bmyQuery, BmyDTO.class);
            if (null == bmyDTO) {
                bmyQuery = Query.query(Criteria.where("bmy_code").is(bmyCode));
                bmyDTO = mongoTemplate.findOne(bmyQuery, BmyDTO.class);
            }
            String[] arrs = bmyDTO.getBmyName().split("-");
            bmyDTO.setYearName(arrs[arrs.length - 1]);
        } catch (Exception ex) {
            System.out.println(bmyCode + " => Exception: " + ex.getMessage() + "!");
        }
        return bmyDTO;
    }

    public static BmyDTO getBmyDTOById(MongoTemplate mongoTemplate, int bmyId) {
        Query bmyQuery = Query.query(Criteria.where("bmy_id").is(bmyId));
        BmyDTO bmyDTO = mongoTemplate.findOne(bmyQuery, BmyDTO.class);
        String[] arrs = bmyDTO.getBmyName().split("-");
        bmyDTO.setYearName(arrs[arrs.length - 1]);
        return bmyDTO;
    }

    public static void demo(MongoTemplate mongoTemplate) {
        Query query = Query.query(Criteria.where("brand_code").is("1002"));
        BrandDTO brandDTO = mongoTemplate.findOne(query, BrandDTO.class);
        System.out.println("品牌模询结果：" + brandDTO.getBrandId() + "---" + brandDTO.getBrandName() + "!");
        Query modelQuery = Query.query(Criteria.where("model_code").is("1003100001"));
        ModelDTO modelDTO = mongoTemplate.findOne(modelQuery, ModelDTO.class);
        System.out.println("车型查询结果：" + modelDTO.getModelId() + "---" + modelDTO.getModelName() + "!");
        Query bmyQuery = Query.query(Criteria.where("bmy_code").is("1002100005101" + " "));
        BmyDTO bmyDTO = mongoTemplate.findOne(bmyQuery, BmyDTO.class);
        String[] arrs = bmyDTO.getBmyName().split("-");
        String yearName = arrs[arrs.length - 1];
        System.out.println("年款查询结果：" + bmyDTO.getBmyId() + "---" + bmyDTO.getBmyName() + "---" + yearName + "!");

    }
}
