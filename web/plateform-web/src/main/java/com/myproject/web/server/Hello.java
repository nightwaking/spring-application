package com.myproject.web.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(basePath = "hello", value = "hello", description = "Hello",
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@RequestMapping(path = "/hello")
public class Hello {
    @ApiOperation(value = "Hello", notes = "Hello。")
    @RequestMapping(value="/world", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello World";
    }
}