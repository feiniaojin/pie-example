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
public class ArticleModifyContentHandler implements ChannelHandler {

    private Logger logger = LoggerFactory.getLogger(ArticleModifyContentHandler.class);

    @Override
    public void channelProcess(ChannelHandlerContext ctx,
                               Object in,
                               Object out) throws Exception {

        logger.info("修改正文:进入修改正文的Handler");
        ArticleTitleModifyCmd cmd = (ArticleTitleModifyCmd) in;
        logger.info("修改正文,content={}", cmd.getContent());
        logger.info("修改正文:执行完成,即将进入下一个Handler");
        ctx.fireChannelProcess(in, out);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause,
                                Object in,
                                Object out) throws Exception {
        logger.info("修改正文的异常处理逻辑:不处理直接向后传递");
        ctx.fireExceptionCaught(cause, in, out);
    }
}
