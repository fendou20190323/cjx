package com.fendou.moudle.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @Author: cjx
 * @Date: 2020-06-02 17:39
 * @Description;
 */
@Data
public class TestCjx {
    @NotNull(message = "id不能为空")
    private String id;
    @NotEmpty(message = "集合不能为空")
    @Size(min = 2,max = 4)
    private List<Integer> numList;
    @NotBlank(message = "name不能为空")
    private String name;
    @NotEmpty(message = "cjx2List集合不能为空")
    private List<TestCjx2> cjx2List;
}
