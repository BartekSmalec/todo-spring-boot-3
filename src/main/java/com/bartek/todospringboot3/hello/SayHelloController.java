package com.bartek.todospringboot3.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class SayHelloController {

    @GetMapping("say-hello")
    @ResponseBody
    public String sayHello(){
        return "Hello! What are you learning today";
    }

    @GetMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml(){
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My first HTMl Page </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<b> My first html page with body </b>");
        sb.append("</body>");
        sb.append("</html>");

        return sb.toString();
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp(@RequestParam String name, ModelMap model){
        model.put("name",name);
        log.debug("Request param is: {}", name);
        return "sayHello";
    }
}
