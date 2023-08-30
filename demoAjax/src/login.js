function login() {
    let username = document.getElementById("userNameLogin").value;
    let password = document.getElementById("passwordLogin").value;
    let accountlogin = {username, password};
    // $.ajax({
    //         type: "Get",
    //         headers: {
    //             'Content-Type': 'application/json',
    //         },
    //         url: "http://localhost:8080/accounts/login",
    //         data: JSON.stringify(accountlogin),
    //         success: function (data) {
    //             console.log(data);
    //         },
    //         error: function (err) {
    //             console.log(err)
    //             // lỗi
    //         }
    //     });
    var settings = {
        "url": "http://localhost:8080/login",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Authorization": "a",
            "Content-Type": "application/json"
        },
        data: JSON.stringify(accountlogin),
    };
    $.ajax(settings).done(function (response) {
        console.log(response);
        for (const r of response.roles) {
            if (r.name === "ROLE_ADMIN") {
                console.log(response.token);
                localStorage.setItem("token", response.token);
                location.href = "Account.html";
            } else if (r.name === "ROLE_User") {
                location.href = "login.html";
            }
        }
    });
}