package com.itsvenkis.blogspot.conrollers;

import com.itsvenkis.blogspot.jacoco.domain.IUser;
import com.itsvenkis.blogspot.service.UserService;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author: itsvenkis
 * @since: 13/4/14
 */
@Controller
@RequestMapping(value = "/user-management")
public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/save-users", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String saveUsers(@RequestBody List<IUser> users) {
        userService.saveUsers(users);
        return "Saved users successfully";
    }

}
