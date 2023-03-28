//package com.wyj.test.data.po;
//
//import lombok.Data;
//import org.springframework.data.annotation.CreatedDate;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.util.Date;
//
//@Data
//public class StrategyPO implements Serializable {
//    /**
//     * 主键
//     * 所属表字段 price_adjustment_strategy_detail.id
//     */
//    private Long id;
//
//    /**
//     * 策略id
//     * 所属表字段 price_adjustment_strategy_detail.strategy_id
//     */
//    private Long strategyId;
//
//    /**
//     * 策略模板（冗余），1-平台加减价，2-折上折
//     * 所属表字段 price_adjustment_strategy_detail.strategy_type
//     */
//    private Integer strategyType;
//
//    /**
//     * 调整的值，加减价的绝对值，或折上折的折扣值, strategyType=5时，存储降至发改委价的百分比
//     * 所属表字段 price_adjustment_strategy_detail.adjust_value
//     */
//    private BigDecimal adjustValue;
//
//    /**
//     * 开始时间（冗余）
//     * 所属表字段 price_adjustment_strategy_detail.start_time
//     */
//    @CreatedDate
//    private Date startTime;
//
//    /**
//     * 结束时间（冗余）
//     * 所属表字段 price_adjustment_strategy_detail.end_time
//     */
//    @CreatedDate
//    private Date endTime;
//
//    /**
//     * 门店id
//     * 所属表字段 price_adjustment_strategy_detail.store_id
//     */
//    private Long storeId;
//
//    /**
//     * 渠道id
//     * 所属表字段 price_adjustment_strategy_detail.channel_id
//     */
//    private Long channelId;
//
//    /**
//     * 商品id
//     * 所属表字段 price_adjustment_strategy_detail.item_id
//     */
//    private Long itemId;
//
//    /**
//     * 门店名称
//     * 所属表字段 price_adjustment_strategy_detail.store_name
//     */
//    private String storeName;
//
//    /**
//     * 定价类型（
//     * 所属表字段 price_adjustment_strategy_detail.pricing_type
//     */
//    private Integer pricingType;
//
//    /**
//     * 折扣值
//     * 所属表字段 price_adjustment_strategy_detail.discount_value
//     */
//    private Long discountValue;
//
//    /**
//     * 线上价格
//     * 所属表字段 price_adjustment_strategy_detail.online_price
//     */
//    private BigDecimal onlinePrice;
//
//    /**
//     * 策略后价格
//     * 所属表字段 price_adjustment_strategy_detail.strategy_price
//     */
//    private BigDecimal strategyPrice;
//
//    /**
//     * 操作人
//     * 所属表字段 price_adjustment_strategy_detail.operator
//     */
//    private String operator;
//
//    /**
//     * 创建时间
//     * 所属表字段 price_adjustment_strategy_detail.create_time
//     */
//    @CreatedDate
//    private Date createTime;
//
//    /**
//     * 更新时间
//     * 所属表字段 price_adjustment_strategy_detail.update_time
//     */
//    @CreatedDate
//    private Date updateTime;
//
//    /**
//     * 享受优惠需要满足的条件：订单维度的联合满减需要满足的订单金额
//     */
//    private BigDecimal satisfyValue;
//
//    /**
//     * 调价成本商家承担比例
//     */
//    private BigDecimal merchantRatio;
//}
