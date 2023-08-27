function login() {
    let username = document.getElementById("userNameLogin").value;
    let password = document.getElementById("passwordLogin").value;
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
        "url": "http://localhost:8080/accounts/login?username=" + username + "&password=" + password,
        "method": "Get",
        "timeout": 0,
        "headers": {
            "Authorization": "a",
            "Content-Type": "application/json"
        }
    };
    $.ajax(settings).done(function (response) {
        if (response !== "") {
            if (response.role.name === "admin") {
                window.location = "http://localhost:63343/demoAjax/demoAjax/src/home.html";
            } else {
                window.location = "http://localhost:63343/demoAjax/demoAjax/src/Login.html";
            }
        }else {
            window.location = "http://localhost:63343/demoAjax/demoAjax/src/Login.html";
        }
    });
}