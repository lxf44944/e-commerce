<!--
document.writeln("<STYLE type=\"text/css\">");
document.writeln("#siderIMchat_main {");
document.writeln("	MARGIN:0; WIDTH: 110px;color:#333");
document.writeln("}");
document.writeln("#siderIMchat_main img{");
document.writeln("border:0;/*background:url(http://localhost:8096/EEpro/kf/images/top.gif) no-repeat center center*/");
document.writeln("}");
document.writeln("#siderIMchat_main a{");
document.writeln("color:#036");
document.writeln("}");
document.writeln("#siderIMchat_main a:hover{");
document.writeln("color:#f30");
document.writeln("}");
document.writeln("#siderIMchat_main .top {");
document.writeln("	BACKGROUND: url(http://localhost:8096/EEpro/kf/images/top.gif); HEIGHT: 76px");
document.writeln("}");
document.writeln("#siderIMchat_main .infobox {");
document.writeln("	TEXT-ALIGN: center; PADDING-BOTTOM: 5px; LINE-HEIGHT: 14px; PADDING-LEFT: 5px; PADDING-RIGHT: 5px; BACKGROUND: url(http://localhost:8096/EEpro/kf/images/middle.gif) #bdc5cb no-repeat; COLOR: #000; FONT-WEIGHT: 700; PADDING-TOP: 5px");
document.writeln("}");
document.writeln("#siderIMchat_main .bg {");
document.writeln("	PADDING-BOTTOM: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; BACKGROUND: url(http://localhost:8096/EEpro/kf/images/middle.gif); PADDING-TOP: 0px");
document.writeln("}");
document.writeln("#siderIMchat_main UL {");
document.writeln("	MARGIN:0;");
document.writeln("}");
document.writeln("#siderIMchat_main UL LI {");
document.writeln("list-style:none;");
document.writeln("text-align:center;");
document.writeln("line-height:20px;");
document.writeln("}");
document.writeln(".qqkf{");
document.writeln("background:#ccc;height:22px;line-height:22px");
document.writeln("}");

document.writeln("#siderIMchat_main .close {");
document.writeln("width:100%;");
document.writeln("text-align:center");
document.writeln("}");
document.writeln("#siderIMchat_main .bottom {");
document.writeln("	BACKGROUND: url(http://localhost:8096/EEpro/kf/images/bottom.gif); HEIGHT: 51px; OVERFLOW: hidden");
document.writeln("}");
document.writeln("</STYLE>");
document.writeln("");
//-->



document.writeln("<div id=\'QuickMenu\' style=\'right:3px;top:230px;position:absolute;\'>");

document.writeln("<div id=\'RightMenu'\ style=\'float:right;overflow: hidden;display:none;\'>");

document.writeln("<div style=\'margin:0;padding:0px;border:0px;overflow: hidden;\'>");


document.writeln("<DIV id=siderIMchat_main>");
document.writeln("");
document.writeln("<DIV class=top></DIV>");
document.writeln("");

document.writeln("<!-- 中间开始-->");
document.writeln("<DIV class=\"bg \">");
document.writeln("<UL>");
document.writeln("</li>");



document.writeln("<table width=\"100%\" border=\"0\">");

document.write('</td></tr><tr><td height=0>')
document.write("&nbsp;<img src=http://wpa.qq.com/pa?p=1:271850264:17 height=17 border=0 align=middle>&nbsp;&nbsp;<a class='qqa' target=blank href='tencent://message/?uin=807788969&Site=http://localhost:8096/EEpro&Menu=yes' title='在线即时交谈[客服]'><font color=#000000>魏先生</font></a>");

document.write('</td></tr><tr><td height=25>')

document.write("&nbsp;<img src=http://wpa.qq.com/pa?p=1:262369840:17 height=17 border=0 align=middle>&nbsp;&nbsp;<a class='qqa' target=blank href='tencent://message/?uin=630930869&Site=http://localhost:8096/EEpro&Menu=yes' title='在线即时交谈[客服]'><font color=#000000>魏先生</font></a>");



document.writeln("<\/table>")

document.writeln("</LI>");
document.writeln("  </UL>");
document.writeln("</DIV>");
document.writeln("<!--中间结束-->");
document.writeln("");
document.writeln("<DIV class=bottom></DIV>");
document.writeln("");
document.writeln("</DIV>");
document.writeln("  </div></div>");
document.writeln("<div style=\'float:right;width:24px;margin:9px 0 0 0;border: 0px;\'><img id=menutop onMouseOver=\"javascript:ChangeMenu('RightMenu',115,500)\" border=0 height=100 src=http://localhost:8096/EEpro/kf/images/kefu.gif width=24></div>");
document.writeln("  </div></div>")


var QuickScrollYLast=0;
var QuickMenu=document.getElementById("QuickMenu")
window.setInterval("LoadMenu()",1);

function LoadMenu(){
    var QuickScrollYDefault;
    if(document.documentElement&&document.documentElement.scrollTop){
        QuickScrollYDefault=document.documentElement.scrollTop;
    }else if(document.body){
        QuickScrollYDefault=document.body.scrollTop;
    }else{
    }
    QuickPercent=.1*(QuickScrollYDefault-QuickScrollYLast);
    if(QuickPercent>0){
        QuickPercent=Math.ceil(QuickPercent);
    }else{
        QuickPercent=Math.floor(QuickPercent);
    }
    QuickMenu.style.top=parseInt(QuickMenu.style.top)+QuickPercent+"px";
    QuickScrollYLast=QuickScrollYLast+QuickPercent;
}

var MenuX;
var MenuY;
var MenuCloseX;
var MenuCloseY;
function ChangeMenu(id,menuwidth,menuheight){
    clearInterval(MenuX);
    clearInterval(MenuY);
    clearInterval(MenuCloseX);
    clearInterval(MenuCloseY);
    var o = document.getElementById(id);
    if(o.style.display == "none"){
        o.style.display = "block";
        o.style.width = "1px";
        o.style.height = "1px"; 
        MenuX = setInterval(function(){menuopenx(o,menuwidth,menuheight)},30);
        document.getElementById("menutop").src="http://localhost:8096/EEpro/kf/images/close.gif";
    }else{
        document.getElementById("menutop").src="http://localhost:8096/EEpro/kf/images/kefu.gif";
        MenuCloseY = setInterval(function(){menuclosex(o)},30);
    }
}
function menuopenx(o,x,y){/*--打开x--*/
    var menucx = parseInt(o.style.width);
    if(menucx < x){
        o.style.width = (menucx + Math.ceil((x-menucx)/5)) +"px";
    }else{
        clearInterval(MenuX);
        //MenuY = setInterval(function(){menuopeny(o,y)},30);
    }
    var menucy = parseInt(o.style.height);
    if(menucy < y){
        o.style.height = (menucy + Math.ceil((y-menucy)/5)) +"px";
    }else{
        clearInterval(MenuY); 
    }
}

function menuopeny(o,y){/*--打开y--*/ 
    var menucy = parseInt(o.style.height);
    if(menucy < y){
        o.style.height = (menucy + Math.ceil((y-menucy)/5)) +"px";
    }else{
        clearInterval(MenuY); 
    }
} 

function menuclosex(o){/*--打开x--*/
    var menucx = parseInt(o.style.width);
    if(menucx > 0){
        o.style.width = (menucx - Math.ceil(menucx/5)) +"px";
    }else{
        clearInterval(MenuCloseX);
        //MenuCloseX = setInterval(function(){menuclosey(o)},30);
    }
    var menucy = parseInt(o.style.height);
    if(menucy > 0){
        o.style.height = (menucy - Math.ceil(menucy/5)) +"px";
    }else{
        clearInterval(MenuCloseY); 
        o.style.display = "none";
    }
} 
function menuclosey(o){/*--打开y--*/ 
    var menucy = parseInt(o.style.height);
    if(menucy > 0){
        o.style.height = (menucy - Math.ceil(menucy/5)) +"px";
    }else{
        clearInterval(MenuCloseY); 
        o.style.display = "none";
    }
} 

