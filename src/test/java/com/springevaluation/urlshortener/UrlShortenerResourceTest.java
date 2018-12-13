package com.springevaluation.urlshortener;
        import model.urlmodel;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UrlShortenerResourceTest {
    @Autowired
    UrlShortenerResource urlShortenerResource;
    Util.urlUtil urlUtil;
    @Test
    public void TestCreate(){
         urlmodel Q =new urlmodel();
        Q.setUrl("https://mail.google.com");
    }
    @Test
    public void TestGenerateShortUrl(){
        String LongUrl="https://mail.google.com/mail/u/0/#inbox/FMfcgxvzLrJVGvLnXkKmsFGBTTSCtzTl";
        System.out.println(urlUtil.generateShortUrl(LongUrl));
    }
}
