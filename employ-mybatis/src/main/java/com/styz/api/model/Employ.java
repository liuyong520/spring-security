package com.styz.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
* Created by Mybatis Generator 2019/07/11
*/
@Data
@ApiModel(value = "员工信息")
@ToString
@Accessors(chain = true)
public class Employ {
    /**
	* 员工编号
	*/

    private Long id;

    /**
	* 名字
	*/

    @NotNull(message = "用户名为空")
    @ApiModelProperty(notes = "用户名, 不能为空, 否则后端抛出异常")
    private String name;

    /**
	* 部门编号
	*/
    @NotNull(message = "数据长度错误")
    @ApiModelProperty(notes = "不能为空, 否则后端抛出异常")
    private Long departmentid;

    /**
	* 数据存储位置
	*/
    private String datasourceid;
}