
var point = true;
// 点击 无则添加属性，有去掉属性
$('#menuHide').click(function () {
    if(point){
        //隐藏菜单
        $('#menu').hide(500);
        $('#marginOne').toggleClass('m-marginOne');
        $('#TrMini').css("width","60px");
        $('#TrMini').css("transition","1s");
        point = false;
    }else{
        $('#menu').show(1000);
        $('#marginOne').toggleClass('m-marginOne');
        $('#TrMini').css("width","240px");
        $('#TrMini').css("transition","1s");
        point = true;
    }
});

document.getElementById("TrDouble").onclick = function () {
    if(point){
        //隐藏菜单
        $('#menu').hide(600);
        $('#marginOne').toggleClass('m-marginOne');
        $('#TrMini').css("width","60px");
        $('#TrMini').css("transition","1s");
        console.log("隐藏了查询")
        point = false;
    }else{
        $('#menu').show(1000);
        $('#marginOne').toggleClass('m-marginOne');
        $('#TrMini').css("width","240px");
        $('#TrMini').css("transition","1s");
        point = true;
    }
};

var btnPoint = true;
$('#btnHi').click(function () {
    if(btnPoint){
        $('#selectHi').hide(600);
        $('#btnHi').text("查询");
        btnPoint = false;
    }else{
        $('#selectHi').show(600);
        $('#btnHi').text("隐藏");
        btnPoint = true;
    }
});