package com.sparta.eng82.interfaces.pages.navpages.trainer.addpages;

import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;

public interface AddGroupPage {

    void selectStream(String streamName);

    void enterGroupName(String groupName);

    /**
     * @param startDate string in format dd/mm/yyyy
     */

    void enterGroupStartDate(String startDate);

    ManageGroupPage createNewGroup();

    boolean isGroupCreated(String groupName);

    boolean isDuplicateGroupNameAllowed();

    boolean isPastStartingDateAllowed();

    boolean isEmptyStreamNameAllowed();

    boolean isEmptyGroupNameAllowed();

    boolean isGroupNameCharacterLimited();
}
