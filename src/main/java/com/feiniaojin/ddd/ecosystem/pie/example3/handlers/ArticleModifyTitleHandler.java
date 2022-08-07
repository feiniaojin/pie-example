package com.feiniaojin.ddd.ecosystem.pie.example3.handlers;

import com.feiniaojin.ddd.ecosystem.pie.ChannelHandler;
import com.feiniaojin.ddd.ecosystem.pie.ChannelHandlerContext;
import com.feiniaojin.ddd.ecosystem.pie.example3.ArticleTitleModifyCmd;
import com.feiniaojin.ddd.ecosystem.pie.example3.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO:Add the description of this class.
 */
public class ArticleModifyTitleHandler implements ChannelHandler {

    private Logger logger = LoggerFactory.getLogger(ArticleModifyTitleHandler.class);

    @Override
    public void channelProcess(ChannelHandlerContext ctx,
                               Object in,
                               Object out) throws Exception {

        logger.info("修改标题:进入修改标题的Handler");

        ArticleTitleModifyCmd cmd = (ArticleTitleModifyCmd) in;

        String title = cmd.getTitle();
        //此处的异常用于模拟执行过程中出现异常的场景，正常情况下注释掉
        throw new RuntimeException("修改title发生异常");
        //修改标题的业务逻辑
//        logger.info("修改标题:title={}", title);

//        logger.info("修改标题:执行完成,即将进入下一个Handler");
//        ctx.fireChannelProcess(in, out);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause,
                                Object in,
                                Object out) throws Exception {
        logger.info("修改标题的异常处理逻辑:不处理直接向后传递");
        ctx.fireExceptionCaught(cause, in, out);
    }
}
