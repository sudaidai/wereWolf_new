package com.example.werewolfs.wereWolfDev.model.job;

import com.example.werewolfs.R;
import com.example.werewolfs.wereWolfDev.constant.Action;

public class Role {
    public int openSound = -1;
    public int skillSound = -1;
    public int closeSound = -1;
    private int seat = 0;
    public Action stage;

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public boolean unChecked(){
        return seat == 0;
    }
}