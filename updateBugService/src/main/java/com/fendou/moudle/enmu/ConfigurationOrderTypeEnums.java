package com.fendou.moudle.enmu;

public enum ConfigurationOrderTypeEnums {

    /**
     * 订单来源枚举
     */
    SUPPLY_CHAIN("02001", "SCB平台"),
    /**
     * 销售订单类型枚举
     */
    TO_CUSTOMER("03001", "2C销售单"),
    TO_BUSINESS("03002", "2B销售单"),
    /**
     * 出库单类型
     */
    SALE_OUTBOUND_ORDER("04001", "销售出库单"),
    PURCHASE_RETURN_OUTBOUND_ORDER("04002", "采购退货出库单"),
    OTHER_OUTBOUND_ORDER("04003", "其他出库单"),
    /**
     * 入库单类型
     */
    PURCHASE_INBOUND_ORDER("05001", "采购入库单"),
    RETURN_INBOUND_ORDER("05002", "销售退货入库单"),
    OTHER_INBOUND_ORDER("05003", "其他入库单");

    private String type;

    private String name;

    ConfigurationOrderTypeEnums(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
