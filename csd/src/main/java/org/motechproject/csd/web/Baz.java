package org.motechproject.csd.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Baz {
    @RequestMapping(value = "/baz", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "Hello, world.";
    }
}
