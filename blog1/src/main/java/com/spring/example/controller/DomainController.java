package com.spring.example.controller;

import com.spring.example.model.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DomainController {
    private static final Logger logger = LoggerFactory.getLogger(DomainController.class);

    @RequestMapping("/doD")
    public String doD(Model model){
        ProductVO productVO = new ProductVO("desktop", 10000);
        logger.info("/doD called");
        model.addAttribute(productVO);
        return "product_detail";
    }

}
