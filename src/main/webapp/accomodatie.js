/*--------------------------------------------------------------------------------*/
// Show Managers
async function loadTable() {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/tkeeps/api/accomodatie/retrieve");
    xhttp.send();
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            console.log(this.responseText);
            var trHTML = "";
            const objects = JSON.parse(this.responseText);
            for (let object of objects) {
                // trHTML += "<tr>";
                trHTML += "<td>" + object["id"] + "</td>";
                trHTML += "<td>" + object["beschrijving"] + "</td>";
                trHTML += "<td>" + object["ruimteCode"] + "</td>";
                trHTML += "<td>" + object["ruimteType"] + "</td>";
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
// setTimeout(renderLocaties(),500); // run donothing after 0.5 seconds

/*--------------------------------------------------------------------------------*/
// Create Manager
function showUserCreateBox() {
    Swal.fire({
        title: "Create manager",
        html:
            // '<input id="id" type="hidden">' +
            '<input id="beschrijving" class="swal2-input" placeholder="beschrijving">' +
            '<input id="ruimteCode" class="swal2-input" placeholder="ruimte code">' +
            '<input id="ruimteType" class="swal2-input" placeholder="ruimte type">' +
            '<input id="prijs" class="swal2-input" placeholder="prijs">' +
            '<div><select id="catacc">\n' +
            '                    <option value="">categorie</option>\n' +
            '                </select></div>' +
            '<div><select id="locacc">\n' +
            '                    <option value="">locatie</option>\n' +
            '                </select></div>',
        focusConfirm: false,
        preConfirm: () => {
            userCreate();
        },
    });
    renderLocaties();
    setTimeout(1000);
    renderCategorie();
}

async function userCreate(){
    console.log("test");
    const beschrijving = document.getElementById("beschrijving").value;
    const ruimteCode = document.getElementById("ruimteCode").value;
    const ruimteType = document.getElementById("ruimteType").value;
    const prijs = document.getElementById("prijs").value;
    const catacc = document.getElementById("catacc").value;
    const locacc = document.getElementById("locacc").value;
    // do something with myJson
    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/tkeeps/api/accomodatie/add");
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(
        JSON.stringify({
            beschrijving: beschrijving,
            ruimteCode: ruimteCode,
            ruimteType: ruimteType,
            prijs: prijs,
            catacc: catacc,
            locacc: locacc,
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            Swal.fire("Accomodatie created");
            loadTable();
        }
    };
    // xhttp.abort();
}

/*--------------------------------------------------------------------------------*/
// Update Manager
async function showUserEditBox(id) {
    console.log(id);

    const xhttp = new XMLHttpRequest();
    xhttp.open("POST", "http://localhost:8080/tkeeps/api/accomodatie/find");
    xhttp.setRequestHeader("Content-type", "application/json");
    var parameters = JSON.stringify({
        id: id,
    });
    xhttp.send(parameters);
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const objects = JSON.parse(this.responseText);
            console.log (objects);
            // const manager = objects["manager"];
            // console.log(manager);
            Swal.fire({
                title: "Edit User",
                html:
                    '<input id="id" readonly value=' +
                    objects["id"] +
                    ">" +
                    '<input id="beschrijving" class="swal2-input" placeholder="beschrijving" value="' +
                    objects["beschrijving"] +
                    '">' +
                    '<input id="ruimteCode" class="swal2-input" placeholder="ruimteCode" value="' +
                    objects["ruimteCode"] +
                    '">' +
                    '<input id="ruimteType" class="swal2-input" placeholder="ruimteType" value="' +
                    objects["ruimteType"] +
                    '">' +
                    '<input id="prijs" class="swal2-input" placeholder="prijs" value="' +
                    objects["prijs"] +
                    '">' +
                    '<div><select id="catacc">\n' +
                    '                    <option value="">categorie</option>\n' +
                    '                </select></div>' +
                    '<div><select id="locacc">\n' +
                    '                    <option value="">locatie</option>\n' +
                    '                </select></div>',
                focusConfirm: false,
                preConfirm: () => {
                    userEdit();
                },
            });
            renderLocaties();
            setTimeout(500);
            renderCategorie();
        }
    };
    // xhttp.abort();
}

function userEdit() {
    const beschrijving = document.getElementById("beschrijving").value;
    const ruimteCode = document.getElementById("ruimteCode").value;
    const ruimteType = document.getElementById("ruimteType").value;
    const prijs = document.getElementById("prijs").value;
    const catacc = document.getElementById("catacc").value;
    const locacc = document.getElementById("locacc").value;

    const xhttp = new XMLHttpRequest();
    xhttp.open("PATCH", "http://localhost:8080/tkeeps/api/accomodatie/update");
    xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhttp.send(
        JSON.stringify({
            beschrijving: beschrijving,
            ruimteCode: ruimteCode,
            ruimteType: ruimteType,
            prijs: prijs,
            catacc: catacc,
            locacc: locacc,
        })
    );
    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            // const objects = JSON.parse(this.responseText);
            Swal.fire("Accomodatie edited");
            loadTable();
        }
    };
    // xhttp.abort();
}

/*--------------------------------------------------------------------------------*/
// Delete Accomodatie
function userDelete(id) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/tkeeps/api/accomodatie/remove");
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
        if (this.readyState === 4) {
            // const objects = JSON.parse(this.responseText);
            Swal.fire("Accomodatie deleted");
            loadTable();
        }
    };
}

/*--------------------------------------------------------------------------------*/
// Locatie  & Categorie objects
async function renderLocaties() {
    const dropdown = document.getElementById("locacc");
    fetch("http://localhost:8080/tkeeps/api/locatie/retrieve")
        .then(response => response.json())
        .then(data =>{
            data.forEach(item => {
                let option = document.createElement("option");
                option.value = item.id;
                option.value = item.coordinaten;
                option.value = item.naam;
                option.text = item.naam;
                dropdown.appendChild(option);
            });
        });
}

async function renderCategorie() {
    const dropdown = document.getElementById("catacc");
    fetch("http://localhost:8080/tkeeps/api/categorie/retrieve")
        .then(response => response.json())
        .then(data =>{
            data.forEach(item => {
                let option = document.createElement("option");
                option.value = item.id;
                option.value = item.beschrijving;
                option.value = item.code;
                option.text = item.code;
                dropdown.appendChild(option);
            });
        });
}
