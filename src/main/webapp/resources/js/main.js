

function addToCart(id) {
        $.ajax({
            method: "POST",
            url: "/addToCart/"+id,
            data: id,
        })
    };


function goToCart(){
    window.location.href='/cart';
};

function toDelete() {
        var data = {'toDelete[]': []};
        $(":checked").each(function () {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/delete", data, function (data, status) {
            window.location.reload();
        });
}
