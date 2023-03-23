/*--------------------------------------------------------------------------------*/
// Show Managers
async function loadTable() {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/tkeeps/api/locatie/retrieve");
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            var trHTML = "";
            const objects = JSON.parse(this.responseText);
            for (let object of objects) {
                // trHTML += "<tr>";
                trHTML += "<td>" + object["id"] + "</td>";
                trHTML += "<td>" + object["naam"] + "</td>";
                trHTML += "<td>" + object["beschrijving"] + "</td>";
                // trHTML += "<td>" + object["username"] + "</td>";
                trHTML +=
                    '<td><button type="button" class="btn btn-primary" onclick="showUserEditBox(' +
                    object["id"] +
                    ')">Edit</button>';
                trHTML +=
                    '<button type="button" class="btn btn-danger btn-outline-danger" onclick="userDelete(' +
                    object["id"] +
                    ')">Delete</button></td>';
                trHTML += "</tr>";
            }
            document.getElementById("mytable").innerHTML = trHTML;
        }
    };
    // xhttp.abort();
}

loadTable();

/*--------------------------------------------------------------------------------*/
// Create Manager
function showUserCreateBox() {
    Swal.fire({
        title: "Create manager",
        html:
            '<input id="id" type="hidden">' +
            '<input id="naam" class="swal2-input" placeholder="naam">' +
            '<input id="gebDatum" class="swal2-input" placeholder="gebDatum">' +
            '<input id="beschrijving" class="swal2-input" placeholder="beschrijving">',
        // '<input id="email" class="swal2-input" placeholder="Email">',
        focusConfirm: false,
        preConfirm: () => {
            userCreate();
        },
    });
}

async function userCreate(){
    console.log("test");
    const naam = document.getElementById("naam").value;
    const gebDatum = document.getElementById("gebDatum").value;
    const beschrijving = document.getElementById("beschrijving").value;

    // const response = await fetch('http://localhost:8080/tkeeps/api/manager/add', {
    //     method: 'POST',
    //     headers: {
    //         'Content-Type': 'application/json'
    //     },
    //     body: JSON.stringify({
    //         naam: naam,
    //         gebDatum: gebDatum,
    //         beschrijving: beschrijving,
    //     }),

    // });
    // const myJson = await response.json(); //extract JSON from the http response
    // do something with myJson
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/tkeeps/api/locatie/add");
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(
        JSON.stringify({
            naam: naam,
            gebDatum: gebDatum,
            beschrijving: beschrijving,
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const objects = JSON.parse(this.responseText);
            Swal.fire("Manager created");
            loadTable();
        }
    };
    // xhttp.abort();
}

/*--------------------------------------------------------------------------------*/
// Update Manager
async function showUserEditBox(id) {
    console.log(id);
    // const response = await fetch('http://localhost:8080/tkeeps/api/manager/find', {
    //     method: 'GET',
    //     body: JSON.stringify({
    //         id: id,
    //     }),
    // });
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/tkeeps/api/locatie/find");
    xhttp.setRequestHeader("Content-type", "application/json");
    var parameters = JSON.stringify({
        id: id,
    });
    xhttp.send(parameters);
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            const objects = JSON.parse(this.responseText);
            console.log (objects);
            // const manager = objects["manager"];
            // console.log(manager);
            Swal.fire({
                title: "Edit User",
                html:
                    '<input id="id" type="hidden" value=' +
                    objects["id"] +
                    ">" +
                    '<input id="naam" class="swal2-input" placeholder="naam" value="' +
                    objects["naam"] +
                    '">' +
                    '<input id="gebDatum" class="swal2-input" placeholder="gebDatum" value="' +
                    objects["gebDatum"] +
                    '">' +
                    '<input id="beschrijving" class="swal2-input" placeholder="beschrijving" value="' +
                    objects["beschrijving"] +
                    '">',
                // '<input id="email" class="swal2-input" placeholder="Email" value="' +
                // user["email"] +
                // '">',
                focusConfirm: false,
                preConfirm: () => {
                    userEdit();
                },
            });
        }
    };
    // xhttp.abort();
}

function userEdit() {
    const id = document.getElementById("id").value;
    const naam = document.getElementById("naam").value;
    const gebDatum = document.getElementById("gebDatum").value;
    const beschrijving = document.getElementById("beschrijving").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("PATCH", "http://localhost:8080/tkeeps/api/locatie/update");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            id: id,
            naam: naam,
            gebDatum: gebDatum,
            beschrijving: beschrijving,
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            // const objects = JSON.parse(this.responseText);
            Swal.fire("Mannager edited");
            loadTable();
        }
    };
    // xhttp.abort();
}

/*--------------------------------------------------------------------------------*/
// Delete Manager
function userDelete(id) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/tkeeps/api/locatie/remove");
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(
        JSON.stringify({
            id: id,
        })
    );
    console.log("Manager deleted");
    // Swal.fire("Manager deleted");
    // xhttp.abort();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4) {
            // const objects = JSON.parse(this.responseText);
            Swal.fire("Manager deleted");
            loadTable();
        }
    };
}