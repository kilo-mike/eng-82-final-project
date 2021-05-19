package com.sparta.eng82.components.pages.navpages.trainer;

import com.sparta.eng82.interfaces.pages.navpages.trainer.ManageGroupPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddGroupPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddStreamPage;
import com.sparta.eng82.interfaces.pages.navpages.trainer.addpages.AddTraineePage;
import org.openqa.selenium.WebDriver;

public class ManageGroupPageImpl implements ManageGroupPage {
    public ManageGroupPageImpl(WebDriver driver) {

    }

    @Override
    public ManageGroupPage removeTrainee(String traineeName) {
        return null;
    }

    @Override
    public AddTraineePage addTrainee() {
        return null;
    }

    @Override
    public AddGroupPage addGroup() {
        return null;
    }

    @Override
    public AddStreamPage addStream() {
        return null;
    }

    @Override
    public boolean isTraineeRemoved(String traineeName) {
        return false;
    }
}
