package com.sparta.eng82.interfaces.pages.navpages.trainer.addpages;

import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;

public interface AddGroupPage {

    AddGroupPage selectStream(String streamName);

    AddGroupPage enterGroupName(String groupName);

    /**
     * @param startDate string in format dd/mm/yyyy
     */

    AddGroupPage enterGroupStartDate(String startDate);

    ManageGroupPage createNewGroup();

    boolean isGroupCreated();

    boolean isDuplicateGroupNameAllowed();

    boolean isPastStartingDateAllowed();

    boolean isEmptyStreamNameAllowed();

    boolean isEmptyGroupNameAllowed();

    boolean isGroupNameCharacterLimited();
}
