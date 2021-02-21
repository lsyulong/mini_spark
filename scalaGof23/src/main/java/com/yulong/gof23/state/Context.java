package com.yulong.gof23.state;

public interface Context {
    public abstract void changeState(State state);

    public abstract void setClock(int hour);

    public abstract void callSsecurityCenter(String msg);

    public abstract void recordLog(String msg);
}

