$(function () {
    $.get("header.html",function (data) {
        $("#wn__header").html(data);
    });
    $.get("footer.html",function (data) {
        $("#wn__footer").html(data);
    });
});
