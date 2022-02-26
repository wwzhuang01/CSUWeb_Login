function checktelcaptcha(){

    var userid = document.querySelector("#userid").value;
    var usertel = document.querySelector("#usertel").value;
    var captcha = document.querySelector("#captcha").value;
    console.log(usertel + " " + captcha);
    //发送异步请求
    //1.创建核心对象
    var xmlhttp;
    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.open("GET","ForgetServlet?usertel="+usertel+"&&captcha="+captcha + "&&userid=" + userid,true);

    //3.发送请求
    xmlhttp.send();

    xmlhttp.onreadystatechange=function()
    {
        //判断readyState就绪状态是否为4，判断status响应状态码是否为200
        if (xmlhttp.readyState==4 )
        {
            if(xmlhttp.status==200){
                //获取服务器的响应结果
                var responseText = xmlhttp.responseText;
                document.querySelector("#showWarnTip").innerText = responseText;
            }

        }
    }

}

function freshVCode(){
    var CImg = document.querySelector("#captcha-img");
    var date = new Date().getTime();
    CImg.src = "/LoginPro_war_exploded/CreateCode?" + date;
}


window.addEventListener("load",function (){

    var getCodeText = document.querySelector("#getCodeText");
    getCodeText.addEventListener("click",checktelcaptcha);      // 获取动态码

    var captchaImg = document.querySelector("#captcha-img");
    captchaImg.addEventListener("click",freshVCode);        // 刷新验证码

    var newpsw1 = document.querySelector("#newpsw1");
    var newpsw2 = document.querySelector("#newpsw2");


    newpsw1.addEventListener("blur",checkSamepsw);
    newpsw2.addEventListener("blur",checkSamepsw);
})