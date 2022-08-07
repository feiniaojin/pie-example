package com.feiniaojin.ddd.ecosystem.pie.example1.handlers;

import com.feiniaojin.ddd.ecosystem.pie.ChannelHandler;
import com.feiniaojin.ddd.ecosystem.pie.ChannelHandlerContext;
import com.feiniaojin.ddd.ecosystem.pie.example1.ArticleTitleModifyCmd;
import com.feiniaojin.ddd.ecosystem.pie.example1.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * TODO:Add the description of this class.
 */
public class CheckParameterHandler implements ChannelHandler {

    private Logger logger = LoggerFactory.getLogger(CheckParameterHandler.class);

    @Override
    public void channelProcess(ChannelHandlerContext ctx,
                               Object in,
                               Object out) throws Exception {

        logger.info("参数校验:开始执行");

        if (in instanceof ArticleTitleModifyCmd) {
            ArticleTitleModifyCmd cmd = (ArticleTitleModifyCmd) in;
            String articleId = cmd.getArticleId();
            Objects.requireNonNull(articleId, "articleId不能为空");
            String title = cmd.getTitle();
            Objects.requireNonNull(title, "title不能为空");
            String content = cmd.getContent();
            Objects.requireNonNull(content, "content不能为空");
        }
        logger.info("参数校验:校验通过,即将进入下一个Handler");
        ctx.fireChannelProcess(in, out);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause,
                                Object in,
                                Object out) throws Exception {
        logger.error("参数校验:异常处理逻辑", cause);
        Result re = (Result) out;
        re.setCode(400);
        re.setMsg("参数异常");
    }
}
