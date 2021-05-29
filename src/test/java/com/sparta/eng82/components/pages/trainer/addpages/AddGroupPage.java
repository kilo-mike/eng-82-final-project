package com.sparta.eng82.components.pages.trainer.addpages;

import com.sparta.eng82.components.pages.trainer.ManageGroupPage;

public interface AddGroupPage {

    AddGroupPage selectStream(String streamName);

    AddGroupPage enterGroupName(String groupName);

    /**
     * @param startDate string in format dd/mm/yyyy
     */

    AddGroupPage enterGroupStartDate(String startDate);

    ManageGroupPage createNewGroup();

    boolean isGroupCreated(String groupName);

}
