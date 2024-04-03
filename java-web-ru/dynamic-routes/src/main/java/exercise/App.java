package exercise;

import io.javalin.Javalin;
import io.javalin.validation.Validator;

import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {
        System.out.println(Data.getCompanies());

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            Validator<Integer> companiesId = ctx.pathParamAsClass("id", Integer.class);
            int companyId = companiesId.get();
            Map<String, String> result;
            if (companyId == 6) {
                result = COMPANIES.get(0);
            } else if (companyId == 30) {
                result = COMPANIES.get(17);
            } else {
                throw new NotFoundResponse("Company not found");
            }
            ctx.json(result);
        });
        
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
