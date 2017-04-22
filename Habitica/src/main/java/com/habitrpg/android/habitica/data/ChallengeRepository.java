package com.habitrpg.android.habitica.data;

import com.magicmicky.habitrpgwrapper.lib.models.Challenge;
import com.magicmicky.habitrpgwrapper.lib.models.PostChallenge;
import com.magicmicky.habitrpgwrapper.lib.models.tasks.Task;
import com.magicmicky.habitrpgwrapper.lib.models.tasks.TaskList;

import java.util.List;

import rx.Observable;

public interface ChallengeRepository extends BaseRepository  {
    Observable<Challenge> getChallenge(String challengeId);
    Observable<TaskList> getChallengeTasks(String challengeId);

    Observable<Challenge> createChallenge(PostChallenge challenge, List<Task> taskList);

    /**
     *
     * @param challenge
     * @param fullTaskList lists all tasks of the current challenge, to create the taskOrders
     * @param addedTaskList only the tasks to be added online
     * @param updatedTaskList only the updated ones
     * @param removedTaskList tasks that has be to be removed
     * @return
     */
    Observable<Challenge> updateChallenge(PostChallenge challenge, List<Task> fullTaskList,
                                          List<Task> addedTaskList, List<Task> updatedTaskList, List<String> removedTaskList);
    Observable<Void> deleteChallenge(String challengeId);
}