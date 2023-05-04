const usersListUrl = 'http://localhost:8080/api/admin';
let output = '';
let roleLet;


const usersTable = document.getElementById('users-table')
const listAllUsers = (users) => {
    users.forEach(user => {
        roleLet = '';
        user.roles.forEach((role) => roleLet += role.nameToString + " ");
        output += `<tr>
                <th><p>${user.id} </p></th>
                <th><p>${user.username} </p></th>
                <th><p>${user.lastname} </p></th>
                <th><p>${user.age} </p></th>
                <th><p>${user.email} </p></th>
                <th><p>${roleLet}</p></th>                        
                <th>
                    <button type="button" class="btn btn-primary" data-toggle="modal"
                        data-target="#editModal" id="editButton" data-uid=${user.id}>Edit
                    </button>
                </th>
                <th>
                    <button type="button" class="btn btn-danger" data-toggle="modal"
                        data-target="#deleteModal" id="deleteButton" data-uid=${user.id}>Delete
                    </button>
                </th>
        </tr>`;
    });
    usersTable.innerHTML = output;
}
fetch(usersListUrl)
    .then(res => res.json())
    .then(data => listAllUsers(data));