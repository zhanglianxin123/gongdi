package com.qrs.admin.onenet.mq.handler;


/**
 * @Author: kyg
 * @Description:
 * @Date: 2020-07-06 16:36
 **/

public interface MessageHandler {
    void handle(Long msgId, String msgBody);
}
