package com.feiniaojin.ddd.ecosystem.pie.example3.handlers;

import com.feiniaojin.ddd.ecosystem.pie.ChannelHandlerAdapter;
import com.feiniaojin.ddd.ecosystem.pie.ChannelHandlerContext;
import com.feiniaojin.ddd.ecosystem.pie.example3.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO:Add the description of this class.
 */
public class ExceptionHandler extends ChannelHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause,
                                Object in,
                                Object out) throws Exception {

        logger.error("异常处理器中的异常处理逻辑");

        Result re = (Result) out;
        re.setCode(500);
        re.setMsg("系统异常");
    }
}
