

function addToCart(id){ // задаем функцию при нажатиии на элемент <button>
        $.ajax({
            method: "POST", // метод HTTP, используемый для запроса
            url: "/addToCart/"+id, // строка, содержащая URL адрес, на который отправляется запрос
            data: id,
        })
        console.log(id);
    };


function goToCart(){
    window.location.href='/cart';
};

function delFromCart(id){
    $.ajax({
        method: "POST", // метод HTTP, используемый для запроса
        url: "/delFromCart/"+id, // строка, содержащая URL адрес, на который отправляется запрос
        data: id,
    })
    console.log(id);
};

function deleteFromCart(data) {
    var URL = "/delFromCart/"+data ;
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", URL, true);
    xhttp.send(data);
    console.log(data);
    window.location.reload();
}

