@import exercise.dto.users.UserPage
@param UserPage page

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>User</title>
    </head>
    <body>
        <h2>${page.getUser().getId()}</h2>

        <table>
            <tr>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Email</th>
            </tr>
            <tr>
                <td>${page.getUser().getFirstName()}</td>
                <td>${page.getUser().getLastName()}</td>
                <td>${page.getUser().getEmail()}</td>
            </tr>
        </table>
    </body>
</html>
