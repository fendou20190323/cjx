package com.fendou.modle;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
//通过这个注解，可以不用写gettersetter方法
@Data
//通过这个注解可以声明一个文档，指定其所在的索引库和type
@Document(indexName = "testdoct", type = "testbean")
public class TestBean implements Serializable {
    public TestBean() {
    }

    public TestBean(String id, String name, Integer age, String sex, String desc,BigDecimal abc,String brandName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.desc = desc;
        this.abc=abc;
        this.brandName=brandName;
    }

	// 必须指定一个id，
    @Id
    private String id;
    // 这里配置了分词器，字段类型，可以不配置，默认也可
    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String name;
    private Integer age;
    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String sex;
	@Field(analyzer = "ik_smart", type = FieldType.Text)
    private String desc;

    private BigDecimal abc;
    @Field( type = FieldType.Text)
    private String brandName;
}
