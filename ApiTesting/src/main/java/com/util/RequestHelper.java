package com.util;

import com.model.AddUser;

public class RequestHelper {

    public AddUser getAddUser(String job, String name){

        AddUser addUserRequest = new AddUser();
        addUserRequest.setJob(job);
        addUserRequest.setName(name);

        return addUserRequest;
    }
}
