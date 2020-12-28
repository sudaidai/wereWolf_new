package com.example.werewolfs.wereWolfDev.model.job;

import com.example.werewolfs.R;
import com.example.werewolfs.wereWolfDev.constant.Action;
import com.example.werewolfs.wereWolfDev.model.Role;

public class Hunter extends Role {

    public Hunter(){
        stage = Action.獵人;
        openSound = R.raw.hunter4;
        closeSound = R.raw.hunter2;
    }
}
