package com.yulong.gof23.state;

/**
 * 表示白天的状态
 */
public class DayState implements State {
    private static DayState singleton = new DayState();

    private DayState() {

    }

    public static State getIntance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour < 9 || 17 <= hour) {
            context.changeState(DayState.getIntance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("使用金库，白天");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSsecurityCenter("按下警铃，白天");
    }

    @Override
    public void doPhone(Context context) {
        context.callSsecurityCenter("正常通话，白天");
    }

    public String toString() {
        return "白天";
    }
}
