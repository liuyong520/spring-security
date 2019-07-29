package com.styz.securtiy.controller;

import com.styz.api.model.Employ;
import com.styz.securtiy.aop.WebLogger;
import com.styz.securtiy.dto.SimpleResponse;
import com.styz.securtiy.service.Employservice;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * <b>creat date(创建时间):2019-07-11 19:45</b>
 * <b>author(作者):</b>xxydliuyss</br>
 * <b>note(备注)):</b>
 * If you want to change the file header,please modify zhe File and Code Templates.
 */
@RestController
@Api("员工服务")
@Slf4j
public class EmployController {
    /**
     * swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。
     *
     * @Api：修饰整个类，描述Controller的作用
     * @ApiOperation：描述一个类的一个方法，或者说一个接口
     * @ApiParam：单个参数描述
     * @ApiModel：用对象来接收参数
     * @ApiProperty：用对象接收参数时，描述对象的一个字段
     * @ApiResponse：HTTP响应其中1个描述
     * @ApiResponses：HTTP响应整体描述
     * @ApiIgnore：使用该注解忽略这个API
     * @ApiError ：发生错误返回的信息
     * @ApiImplicitParam：一个请求参数
     * @ApiImplicitParams：多个请求参数
     */

    @Autowired
    private Employservice employservice;
    @ApiOperation(value="获取员工详细信息", notes="根据url的id来获取用户详细信息",response = ResponseEntity.class)
    @ApiImplicitParam(name = "id", value = "员工Id", required = true, dataType = "Integer", paramType = "path")
    @ApiResponses(
            {
            @ApiResponse(code =HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION,message = "接口位授权"),
            @ApiResponse(code = HttpServletResponse.SC_OK,message = "成功")
            }
    )

    @GetMapping("/get/{id}")
    @WebLogger(value = "获取员工信息")
    public ResponseEntity<Employ> get(@PathVariable Long id){
        return new ResponseEntity(employservice.get(id),HttpStatus.OK);
    }

    @ApiOperation(value="更新员工详细信息", notes="根据员工信息修改",response = ResponseEntity.class)
    @ApiResponses({
        @ApiResponse(code =HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION,message = "接口位授权"),
        @ApiResponse(code = HttpServletResponse.SC_OK,message = "成功",response = Employ.class)
    })
    @PostMapping("/update")
    @WebLogger(value = "更新员工信息")

    public ResponseEntity update( @RequestBody Employ employ){
        employservice.update(employ);
        return new ResponseEntity(HttpStatus.OK);
    }
    @ApiOperation(value="删除员工信息", notes="根据Id删除员工信息",response = SimpleResponse.class)
    @ApiResponses({
            @ApiResponse(code =HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION,message = "接口位授权"),
            @ApiResponse(code = HttpServletResponse.SC_OK,message = "成功")
    })
    @GetMapping("/delete/{id}")
    @WebLogger(value = "删除员工信息")
    public SimpleResponse delete(@PathVariable Long id){

        return new SimpleResponse(employservice.delete(id));
    }
    @ApiOperation(value="新增员工信息", notes="保存员工",response = SimpleResponse.class)
    @ApiResponses({
            @ApiResponse(code =HttpServletResponse.SC_NON_AUTHORITATIVE_INFORMATION,message = "接口位授权"),
            @ApiResponse(code = HttpServletResponse.SC_OK,message = "成功")
    })
    @PostMapping("/save")
    @WebLogger(value = "新增员工信息")
    public SimpleResponse save(@Valid @RequestBody Employ employ){
        log.info("employ:" +employ);
        return new SimpleResponse(employservice.save(employ));
    }

    @ApiOperation(value="测试用接口", notes="测试用接口" ,httpMethod="POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name="name", value="用户姓名", dataType = "String", required=true, paramType="form"),
            @ApiImplicitParam(name="id", value="id", dataType = "int", required=false, paramType="form")
    })
    @RequestMapping("word")
    public String HelloWord(String name,Integer id) {
        return "Hello Word";
    }


}
