package refactor.components.pages.trainer.addpages;

import refactor.components.pages.trainer.ManageGroupPage;

public interface AddStreamPage {

    AddStreamPage enterStreamName(String streamName);

    AddStreamPage enterStreamDescription(String streamDescription);

    AddStreamPage enterStreamDuration(int weeks);

    ManageGroupPage createNewStream();

    boolean isStreamCreated();
}


