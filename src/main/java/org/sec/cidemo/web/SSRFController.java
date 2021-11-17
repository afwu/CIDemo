package org.sec.cidemo.web;

import org.sec.cidemo.service.SSRFService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ssrf")
public class SSRFController {
    private final SSRFService ssrfService;

    public SSRFController(SSRFService ssrfService) {
        this.ssrfService = ssrfService;
    }

    @RequestMapping(path = "/test1")
    @ResponseBody
    public String ssrf1(@RequestParam(name = "url") String data) {
        return ssrfService.ssrf1(data);
    }

    @RequestMapping(path = "/test2")
    @ResponseBody
    public String ssrf2(@RequestParam(name = "url") String data) {
        return ssrfService.ssrf2(data);
    }

    @RequestMapping(path = "/test3")
    @ResponseBody
    public String ssrf3(@RequestParam(name = "host") String host,
                        @RequestParam(name = "port") int port) {
        return ssrfService.ssrf3(host, port);
    }

    @RequestMapping(path = "/test4")
    @ResponseBody
    public String ssrf4(@RequestParam(name = "url") String data) {
        return ssrfService.ssrf4(data);
    }
}
