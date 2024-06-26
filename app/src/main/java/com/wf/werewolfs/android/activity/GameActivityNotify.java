package com.wf.werewolfs.android.activity;

import com.wf.werewolfs.android.constant.Action;
import com.wf.werewolfs.android.model.Role;
import com.wf.werewolfs.android.model.job.Seer;
import com.wf.werewolfs.android.model.job.TombKeeper;

import java.util.List;

public interface GameActivityNotify {

    void notifyRepeatSelect();

    void notifySeerAsk(boolean isWolf, int seat, Seer seer);

    void notifyDaybreak(String message);

    void notifyFirstDaybreak(String message, List<Integer> dieList);

    void notifyVoteCheck(int seat);

    void notifyGameEnd(String endTitle, String endMessage);

    /**
     * 告訴隱狼誰是他的隊友
     *
     * @param wolfGroup
     */
    void notifyWolfFriend(List<Integer> wolfGroup);

    /**
     * 提示狼美人死亡，帶走她的戀人
     *
     * @param lover
     */
    void notifyPrettyWolfDead(int lover);

    /**
     * 看某個座位真實身分的結果
     *
     * @param identity
     * @param seat
     */
    void notifySeeThrough(Action identity, int seat, Role role);

    /**
     * 守墓人看被投票身分
     *
     * @param identity
     */
    void notifyInGrave(boolean identity, TombKeeper tombKeeper);
}
