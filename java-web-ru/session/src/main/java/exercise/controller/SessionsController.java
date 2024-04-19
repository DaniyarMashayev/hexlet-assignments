package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import com.mifmif.common.regex.Main;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import org.checkerframework.checker.units.qual.N;

import java.util.Collections;

public class SessionsController {

    // BEGIN
    public static void loginPage(Context ctx) {
        LoginPage page = new LoginPage("", null);
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void login(Context ctx) {
        String userName = ctx.formParam("name");
        String password = ctx.formParam("password");
        User user = UsersRepository.findByName(userName);
        if (user != null && user.getPassword().equals(encrypt(password))) {
            ctx.sessionAttribute("currentUser", userName);
            ctx.redirect(NamedRoutes.rootPath());
        } else {
            String errorMessage = "Wrong username or password";
            LoginPage page = new LoginPage(userName, errorMessage);
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }

    public static void mainPage(Context ctx) {
        String name = ctx.sessionAttribute("currentUser");
        MainPage page = new MainPage(ctx.sessionAttribute("currentUser"));
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
    // END
}
