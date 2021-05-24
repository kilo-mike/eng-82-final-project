package refactor.components.pages.trainer.addpages;

public interface AddStreamPage {

    AddStreamPage enterStreamName(String streamName);

    AddStreamPage enterStreamDescription(String streamDescription);

    AddStreamPage enterStreamDuration(int weeks);

    ManageGroupPage createNewStream();

    boolean isStreamCreated();
}


