package com.example.softdevforum.util;

public interface ErrorCode {

    //USER
    int USER_ALREADY_REGISTERED = 100;
    int USER_DELETING_UNSUCCESSFUL = 101;
    int USER_NOT_FOUND = 102;

    //POST
    int POST_NOT_FOUND = 200;
    int POST_DELETING_UNSUCCESSFUL = 201;

    //COMMENT
    int COMMENT_NOT_FOUND = 300;
    int COMMENT_DELETING_UNSUCCESSFUL = 301;

    //CATEGORY
    int CATEGORY_NOT_FOUND = 351;
    int CATEGORY_DELETING_UNSUCCESSFUL = 352;
}
