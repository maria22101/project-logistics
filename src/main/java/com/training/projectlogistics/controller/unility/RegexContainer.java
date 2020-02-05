package com.training.projectlogistics.controller.unility;

public interface RegexContainer {
    String REGEX_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String REGEX_NAME_ENG = "^[A-Z][a-z]{1,20}$";

    String REGEX_SURNAME_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String REGEX_SURNAME_ENG = "^[A-Z][a-z]{1,20}$";

    String REGEX_EMAIL = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";

    String REGEX_PASSWORD = "^.{6,20}$";
}
