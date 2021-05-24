package refactor.components.pages.trainer.addpages;

public interface AddGroupPage {

    AddGroupPage selectStream(String streamName);

    AddGroupPage enterGroupName(String groupName);

    /**
     * @param startDate string in format dd/mm/yyyy
     */

    AddGroupPage enterGroupStartDate(String startDate);

    ManageGroupPage createNewGroup();

    boolean isGroupCreated(String groupName);

    boolean isDuplicateGroupNameAllowed();

    boolean isPastStartingDateAllowed();

    boolean isEmptyStreamNameAllowed();

    boolean isEmptyGroupNameAllowed();

    boolean isGroupNameCharacterLimited();
}
