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
                trHTML += "<tr>";
                trHTML += "<td>" + object["id"] + "</td>";
                trHTML += "<td>" + object["coordinaten"] + "</td>";
                trHTML += "<td>" + object["type"] + "</td>";
                trHTML += "<td>" + object["beschrijving"] + "</td>";
                trHTML +=
                    '<td><button type="button" class="btn btn-secondary" onclick="showUser(' +
                    object["id"] +
                    ')">Show</button>';
                trHTML +=
                    '<button type="button" class="btn btn-primary" onclick="showUserEditBox(' +
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
        title: "Create locatie",
        html:
            '<input id="id" type="hidden" required>' +
            '<input id="coordinaten" class="swal2-input" placeholder="coordinaten" required>' +
            '<input id="type" class="swal2-input" placeholder="type" required>' +
            '<input id="beschrijving" class="swal2-input" placeholder="beschrijving" required>' +
            '<div><select id="manager" required>\n' +
            '                    <option value="">locatie</option>\n' +
            '                </select></div>',
        focusConfirm: false,
        preConfirm: () => {
            userCreate();
        },
    });
    renderManger();
}

async function userCreate(){
    console.log("test");
    const coordinaten = document.getElementById("coordinaten").value;
    const naam = document.getElementById("type").value;
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
            coordinaten: coordinaten,
            beschrijving: beschrijving,
            manager: manager,
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
                    '<input id="coordinaten" required class="swal2-input" placeholder="coordinaten" value="' +
                    objects["coordinaten"] +
                    '">' +
                    '<input id="type" required class="swal2-input" placeholder="type" value="' +
                    objects["type"] +
                    '">' +
                    '<input id="beschrijving" required class="swal2-input" placeholder="beschrijving" value="' +
                    objects["beschrijving"] +
                    '">' +
                    '<div><select id="manager" required>\n' +
                    '                    <option value="">locatie</option>\n' +
                    '                </select></div>',
                focusConfirm: false,
                preConfirm: () => {
                    userEdit();
                },
            });
            renderManger();
        }
    };
    // xhttp.abort();
}

function userEdit() {
    const id = document.getElementById("id").value;
    const coordinaten = document.getElementById("coordinaten").value;
    const naam = document.getElementById("type").value;
    const beschrijving = document.getElementById("beschrijving").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("PATCH", "http://localhost:8080/tkeeps/api/locatie/update");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            id: id,
            coordinaten: coordinaten,
            naam: naam,
            beschrijving: beschrijving,
            manager: manager,
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            // const objects = JSON.parse(this.responseText);
            Swal.fire("Locatie edited");
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
    console.log("Locatie deleted");
    // Swal.fire("Manager deleted");
    // xhttp.abort();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4) {
            // const objects = JSON.parse(this.responseText);
            Swal.fire("Locatie deleted");
            loadTable();
        }
    };
}

/*--------------------------------------------------------------------------------*/
// Show Accomodatie
async function showUser(id) {
    console.log(id);

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/tkeeps/api/locatie/find");
    xhttp.setRequestHeader("Content-type", "application/json");
    var parameters = JSON.stringify({
        id: id,
    });
    xhttp.send(parameters);
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const objects = JSON.parse(this.responseText);
            console.log (objects);
            Swal.fire({
                title: "Show User",
                html:
                    '<input id="id" readonly value=' +
                    objects["id"] +
                    ">" +
                    '<input id="coordinaten" readonly class="swal2-input" placeholder="coordinaten" value="' +
                    objects["coordinaten"] +
                    '">' +
                    '<input id="type" readonly class="swal2-input" placeholder="type" value="' +
                    objects["type"] +
                    '">' +
                    '<input id="beschrijving" readonly class="swal2-input" placeholder="beschrijving" value="' +
                    objects["beschrijving"] +
                    '">' +
                    '<input id="managerId" readonly class="swal2-input" placeholder="managerId" value="' +
                    objects.manager["id"] +
                    '">' +
                    '<input id="managerNaam" readonly class="swal2-input" placeholder="managerNaam" value="' +
                    objects.manager["naam"] +
                    '">',
                focusConfirm: false,
                preConfirm: () => {
                },
            });
        }
    };
}

/*--------------------------------------------------------------------------------*/
// Locatie  & Categorie objects
async function renderManger() {
    const dropdown = document.getElementById("manager");
    fetch("http://localhost:8080/tkeeps/api/manager/retrieve")
        .then(response => response.json())
        .then(data =>{
            data.forEach(item => {
                let option = document.createElement("option");
                option.value = item.id;
                option.value = item.beschrijving;
                option.value = item.gebDatum;
                option.value = item.naam;
                option.text = item.naam;
                dropdown.appendChild(option);
            });
        });
    console.log(data);
}