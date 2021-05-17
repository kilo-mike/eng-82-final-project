package com.sparta.eng82.interfaces;

import com.sparta.eng82.interfaces.pages.CompetenciesPage;
import com.sparta.eng82.interfaces.pages.LoginPage;
import com.sparta.eng82.interfaces.pages.ProfilePage;

public interface NavPage extends Page{

    Page goToHomePage();

    ProfilePage goToProfilePage();

    CompetenciesPage goToCompetenciesPage();

    LoginPage logOut();
}
