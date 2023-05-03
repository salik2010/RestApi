// const a=document.getElementById('Well')
//
// console.dir(a.textContent)
alert('eeeee')

// fetch('http://localhost:8080/admin')
//     .then(response=>response.text())
//     // .then(date=>document.getElementById('Well').innerHTML=JSON.stringify(date))
//     .then(response=>{
//         console.log(response)
//     })
async function fetchMovies() {
    const response = await fetch('api/admin');
    // ждем выполнения запроса
    console.log(response);
}

// fetch('http://localhost:8080/admin')
//     .then((response) => {
//         return response.json();
//     })
//     .then((data) => {
//         console.log(data);
//     });