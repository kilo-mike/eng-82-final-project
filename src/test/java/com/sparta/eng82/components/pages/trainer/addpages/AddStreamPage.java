package com.sparta.eng82.components.pages.trainer.addpages;

import com.sparta.eng82.components.pages.trainer.ManageGroupPage;

public interface AddStreamPage {

    AddStreamPage enterStreamName(String streamName);

    AddStreamPageImpl enterStreamDescription(String streamDescription);

    AddStreamPageImpl enterStreamDuration(int weeks);

    ManageGroupPage createNewStream();

}


