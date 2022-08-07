package com.feiniaojin.ddd.ecosystem.pie.example1;

import com.feiniaojin.ddd.ecosystem.pie.BootStrap;
import com.feiniaojin.ddd.ecosystem.pie.example1.handlers.ArticleModifyContentHandler;
import com.feiniaojin.ddd.ecosystem.pie.example1.handlers.ArticleModifyTitleHandler;
import com.feiniaojin.ddd.ecosystem.pie.example1.handlers.CheckParameterHandler;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO:Add the description of this class.
 *
 * @author: <a href=mailto:943868899@qq.com>Yujie</a>
 */
public class ArticleModifyExample1 {

    private final static Logger logger = LoggerFactory.getLogger(ArticleModifyExample1.class);

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

    /**
     * 参数校验阶段异常
     */
    @Test
    public void test1() {

        //入参
        ArticleTitleModifyCmd dto = new ArticleTitleModifyCmd();
        dto.setArticleId("articleId_001");
        //注释掉title的赋值，使入参title字段为空
//        dto.setTitle("articleId_001_title");
        dto.setContent("articleId_001_content");
        //创建引导类
        BootStrap bootStrap = new BootStrap();

        Result result = (Result) bootStrap
                .inboundParameter(dto)//入参
                .outboundFactory(new ResultFactory())//出参工厂
                .channel(new ArticleModifyChannel())//自定义channel
                .addChannelHandlerAtLast("checkParameter", new CheckParameterHandler())//第一个handler
                .addChannelHandlerAtLast("modifyTitle", new ArticleModifyTitleHandler())//第二个handler
                .addChannelHandlerAtLast("modifyContent", new ArticleModifyContentHandler())//第二个handler
                .process();//执行
        //result为执行结果
        logger.info("result:code={},msg={}", result.getCode(),result.getMsg());
    }

    /**
     * ArticleModifyTitleHandler执行阶段发生异常
     * 手工在其channelProcess中抛出异常进行模拟
     */
    @Test
    public void test2() {

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
