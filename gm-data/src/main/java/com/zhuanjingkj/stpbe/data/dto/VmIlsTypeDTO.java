package com.zhuanjingkj.stpbe.data.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.zhuanjingkj.stpbe.data.dto.BaseDTO;

public class VmIlsTypeDTO extends BaseDTO {
    @JSONField(name = "typeId")
    private long typeId;
    @JSONField(name = "typeName")
    private String typeName;

    public VmIlsTypeDTO() {
        super();
    }

    public VmIlsTypeDTO(long typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
