package com.spring.example.controller;

import com.spring.example.model.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    private static final Logger logger = LoggerFactory.getLogger(JsonController.class);

    @RequestMapping("/doJson")
    @ResponseBody
    public ProductVO doJson() {
        ProductVO productVO = new ProductVO("surface pro", 300000);
        logger.info(String.valueOf(productVO));
        return productVO;
    }
}