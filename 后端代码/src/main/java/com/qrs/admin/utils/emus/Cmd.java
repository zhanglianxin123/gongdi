package com.qrs.admin.utils.emus;

/**
 * @author yuanweimin
 * @date 19/06/11 10:56
 * @description 下发命令枚举
 */
@SuppressWarnings("unused")
public enum Cmd {
    /**
     * 电机相关
     */
    MOTOR_STOP("11", "电机静止"),
    MOTOR_FORWARD("12", "电机正转"),
    MOTOR_REVERSE("13", "电机反转"),
    MOTOR_FAST("23", "电机速度: 快"),
    MOTOR_MIDDLE("22", "电机速度: 中"),
    MOTOR_SLOW("21", "电机速度: 慢");


    private String code;
    private String msg;

    Cmd(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Cmd{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }}
