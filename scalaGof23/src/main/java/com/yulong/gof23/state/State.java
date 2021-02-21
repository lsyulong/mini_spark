package com.yulong.gof23.state;

/**
 * 定义了事件对应的接口
 * 设置时间
 * 使用金库
 * 按下警铃
 * 正常通话
 */
public interface State {
    public abstract void doClock(Context context, int hour); //设置时间

    public abstract void doUse(Context context);  //使用金库

    public abstract void doAlarm(Context context); //按下警铃

    public abstract void doPhone(Context context); //正常通话
}

