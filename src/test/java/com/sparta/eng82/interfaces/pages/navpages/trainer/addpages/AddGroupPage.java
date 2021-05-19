package com.sparta.eng82.interfaces.pages.navpages.trainer.addpages;

import com.sparta.eng82.components.pages.navpages.trainer.addpages.AddGroupPageImpl;
import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;

public interface AddGroupPage {

    AddGroupPageImpl selectStream(String streamName);

    AddGroupPageImpl enterGroupName(String groupName);

    /**
     * @param startDate string in format dd/mm/yyyy
     */

    AddGroupPageImpl enterGroupStartDate(String startDate);

    ManageGroupPage createNewGroup();

    boolean isGroupCreated(String groupName);

    boolean isDuplicateGroupNameAllowed();

    boolean isPastStartingDateAllowed();

    boolean isEmptyStreamNameAllowed();

    boolean isEmptyGroupNameAllowed();

    boolean isGroupNameCharacterLimited();
}
