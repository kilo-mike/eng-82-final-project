package com.sparta.eng82.interfaces.pages.navpages.trainer.addpages;

import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;

public interface AddStreamPage {

    AddStreamPage enterStreamName();

    AddStreamPage enterStreamDescription();

    AddStreamPage enterStreamDuration(int weeks);

    ManageGroupPage createNewStream();
}
