package com.reqres;

import com.util.RequestFormatter;
import com.util.RequestHelper;
import com.model.AddUser;
import com.util.RequestStatusHelper;
import com.util.UrlFormatter;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.io.IOException;

public class CRUDTest extends BaseTest {

    private String id = null;

    @Test
    public void createUser() throws IOException {

        String NAME = "Santhosh";
        String JOB  = "Tech Lead";


        AddUser addUserRequestModel = new RequestHelper().getAddUser(JOB,NAME);
        String addUserRequest = RequestFormatter.requestFormatter().objectToString(addUserRequestModel, AddUser.class);
        HttpResponse response = postRequest(addUserRequest);


        RequestStatusHelper.createStatusCodeValidation(response);
        AddUser addUser = (AddUser) RequestFormatter.responseToObject(response, AddUser.class);
        id = addUser.getId();
        System.out.println("Id : " + id);


        Assert.assertEquals(addUser.getJob(),JOB , "AddUser -> Mismatched job");
        Assert.assertEquals(addUser.getName(),NAME, "AddUser -> Mismatched name");
        Assert.assertNotNull(addUser.getId(),"AddUser -> User Id null, its shouldn't null");
        Assert.assertNotNull(addUser.getCreatedAt(),"AddUser -> Create At null, its shouldn't null");
    }

    @Test(dependsOnMethods = "createUser")
    public void updateUser() throws IOException {
        String NAME = "Eswaran";
        String JOB  = "Tech Lead";

        if(id == null)
          new SkipException("Without user id cannot proceed updateUser case ");


        AddUser addUserRequestModel = new RequestHelper().getAddUser(JOB,NAME);
        String addUserRequest = RequestFormatter.requestFormatter().objectToString(addUserRequestModel, AddUser.class);
        HttpResponse response = putRequest(UrlFormatter.updateUrlFormat(id),addUserRequest);

        RequestStatusHelper.updatetatusValidation(response);
        AddUser addUser = (AddUser) RequestFormatter.responseToObject(response, AddUser.class);

        Assert.assertEquals(addUser.getJob(),JOB , "AddUser -> Mismatched job");
        Assert.assertEquals(addUser.getName(),NAME, "AddUser -> Mismatched name");
        Assert.assertNotNull(addUser.getUpdatedAt(),"AddUser -> Create At null, its shouldn't null");


    }

    @Test(dependsOnMethods = "createUser")
    public void readUser() throws IOException {

        if(id == null)
            new SkipException("Without user id cannot proceed updateUser case ");

        HttpResponse response = getRequest(UrlFormatter.readUserUrlFormat(id));
        RequestStatusHelper.getStatusValidation(response);

    }

    @Test
    public void deleteUser() throws IOException {

        HttpResponse response = deleteRequest(UrlFormatter.deleteUserUrlFormat(id));
        RequestStatusHelper.deleteStatusValidation(response);


    }




}
