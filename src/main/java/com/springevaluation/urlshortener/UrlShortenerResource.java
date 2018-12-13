package com.springevaluation.urlshortener;

import Util.urlUtil;
import com.google.common.hash.Hashing;
import model.Response;
import model.urlmodel;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RequestMapping("/make")
@RestController
public class UrlShortenerResource {
    @Autowired
    StringRedisTemplate redisTemplate;
    @GetMapping("/{id}")
    public String getUrl(@PathVariable String id, HttpServletResponse resp) throws IOException{
        String url=redisTemplate.opsForValue().get(id);
     //   System.out.println("URL Retrieved: "+ url);
        if (url!=null){
            resp.sendRedirect(url);
        }
        else {
            resp.sendError(HttpServletResponse.SC_FOUND);
        }
        return url;
    }
    @PostMapping
    public Response create(@RequestBody urlmodel url){
        UrlValidator urlValidator = new UrlValidator(
             new String[]{"http","https"}
        );
        if (urlValidator.isValid(url.getUrl())){
           Response response = new Response("100", "Successful", null, "http://localhost:9000/make/" + urlUtil.generateShortUrl(url.getUrl()));
           String id= urlUtil.generateShortUrl(url.getUrl());
           redisTemplate.opsForValue().set(id,url.getUrl());
           return response;
        }
        throw new RuntimeException("URL Invalid:" + url.getUrl());
    }
}
