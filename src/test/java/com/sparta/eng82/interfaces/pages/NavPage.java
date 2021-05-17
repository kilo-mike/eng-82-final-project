package com.sparta.eng82.interfaces.pages;

import com.sparta.eng82.interfaces.Page;
import com.sparta.eng82.interfaces.pages.external.LoginPage;
import com.sparta.eng82.interfaces.pages.navpages.CompetenciesPage;
import com.sparta.eng82.interfaces.pages.navpages.ProfilePage;

public interface NavPage extends Page {

    Page goToHomePage();

    ProfilePage goToProfilePage();

    CompetenciesPage goToCompetenciesPage();

    LoginPage logOut();
}
