package com.training.projectlogistics.constants;

public interface RegexContainer {
    String REGEX_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String REGEX_NAME_ENG = "^[A-Z][a-z]{1,20}$";

    String REGEX_SURNAME_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    String REGEX_SURNAME_ENG = "^[A-Z][a-z]{1,20}$";

    String REGEX_EMAIL = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";

    String REGEX_PASSWORD = "^.{3,20}$";

    String REGEX_STREET_UKR = "^[А-ЩЬЮЯҐІЇЄ][-А-ЩЬЮЯҐІЇЄа-щьюяґіїє' ]{1,40}$";
    String REGEX_STREET_ENG = "^[A-Z][-A-Za-z ]{1,40}$";

    String REGEX_HOUSE_UKR = "^\\d{1,5}([-А-ЩЬЮЯҐІЇЄа-щьюяґіїє'/0-9]{1,10})?$";
    String REGEX_HOUSE_ENG = "^\\d{1,5}([-A-Za-z'/0-9]{1,10})?$";

    String REGEX_APARTMENT = "\\d{1,5}";
}
