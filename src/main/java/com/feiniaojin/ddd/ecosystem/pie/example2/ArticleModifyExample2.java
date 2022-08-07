package com.feiniaojin.ddd.ecosystem.pie.example2;

import com.feiniaojin.ddd.ecosystem.pie.BootStrap;
import com.feiniaojin.ddd.ecosystem.pie.example2.handlers.ArticleModifyContentHandler;
import com.feiniaojin.ddd.ecosystem.pie.example2.handlers.ArticleModifyTitleHandler;
import com.feiniaojin.ddd.ecosystem.pie.example2.handlers.CheckParameterHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO:Add the description of this class.
 *
 * @author: <a href=mailto:943868899@qq.com>Yujie</a>
 */
public class ArticleModifyExample2 {

    private final static Logger logger = LoggerFactory.getLogger(ArticleModifyExample2.class);

    public static void main(String[] args) {
        //入参
        ArticleTitleModifyCmd dto = new ArticleTitleModifyCmd();
        dto.setArticleId("articleId_001");
        dto.setTitle("articleId_001_title");
        dto.setContent("articleId_001_content");
        //创建引导类
        BootStrap bootStrap = new BootStrap();

        Result result = (Result) bootStrap
                .inboundParameter(dto)//入参
                .outboundFactory(new ResultFactory())//出参工厂
                .channel(new ArticleModifyChannel())//自定义channel
                .addChannelHandlerAtLast("checkParameter", new CheckParameterHandler())//第一个handler
                .addChannelHandlerAtLast("modifyTitle", new ArticleModifyTitleHandler())//第二个handler
                .addChannelHandlerAtLast("modifyContent", new ArticleModifyContentHandler())//第三个handler
                .process();//执行
        //result为执行结果
        logger.info("result:code={},msg={}", result.getCode(),result.getMsg());
    }
}
