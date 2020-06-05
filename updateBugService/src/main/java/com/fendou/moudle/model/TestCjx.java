package com.fendou.moudle.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @Author: cjx
 * @Date: 2020-06-02 17:39
 * @Description;
 */
@Data
public class TestCjx {
    @NotBlank(message = "id不能为空")
    private String id;
    @NotEmpty(message = "集合不能为空")
    private List<Integer> numList;
    @NotEmpty(message = "name不能为空")
    private String name;
    @NotEmpty(message = "cjx2List集合不能为空")
    private List<TestCjx2> cjx2List;
}
