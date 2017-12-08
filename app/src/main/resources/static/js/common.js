/**
 * Created by ItFunly on 2017/5/16.
 */
var rootPath ='http://192.168.30.3:8080'
function $$(path){
    return rootPath +path;
}

function addFavorite2() {
    var url = window.location;
    var title = document.title;
    var ua = navigator.userAgent.toLowerCase();
    if (ua.indexOf("360se") > -1) {
        alert("由于360浏览器功能限制，请按 Ctrl+D 手动收藏�?");
    }
    else if (ua.indexOf("msie 8") > -1) {
        window.external.AddToFavoritesBar(url, title); //IE8
    }
    else if (document.all) {
        try{
            window.external.addFavorite(url, title);
        }catch(e){
            alert('您的浏览器不支持,请按 Ctrl+D 手动收藏!');
        }
    }
    else if (window.sidebar) {
        window.sidebar.addPanel(title, url, "");
    }
    else {
        alert('您的浏览器不支持,请按 Ctrl+D 手动收藏!');
    }
}

function SetHome(obj,vrl){

    try{
        obj.style.behavior='url(#default#homepage)';obj.setHomePage(vrl);
    }
    catch(e){
        if(window.netscape) {
            try {
                netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
            }
            catch (e) {
                alert("此操作被浏览器拒绝！\n请在浏览器地�?栏输入�?�about:config”并回车\n然后�? [signed.applets.codebase_principal_support]的�?�设置为'true',双击即可�?");
            }
            var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
            prefs.setCharPref('browser.startup.homepage',vrl);
        }
    }
}
function formatDateNow(date){
    /**
     * YYYY�?
     * MM�?
     * DD�?
     * HH�?
     * MI�?
     * SS�?
     * WW�?
    */

    var now = new Date();
    var week = ['星期�?','星期�?','星期�?','星期�?','星期�?','星期�?','星期�?']
    var y = now.getFullYear();
    var mm = now.getMonth()+1;
    var dd = paddLeft(now.getDate(),2,'0');
    var hh = now.getHours();
    var mi = paddLeft(now.getMinutes(),2,'0');
    var ss = paddLeft(now.getSeconds(),2,'0');
    var ww =week[now.getDay()];
    var res =  date.replace(/yyyy|mm|dd|hh|mi|ss|ww/gi,function(m){
        var rem;
        switch (m){
            case 'yyyy':rem=y; break;
            case 'mm':rem=mm; break;
            case 'dd':rem=dd; break;
            case 'hh':rem=hh; break;
            case 'mi':rem=mi; break;
            case 'ss':rem=ss; break;
            case 'ww':rem=ww; break;
            default: rem=m;
        }
        return rem;
    })
    return res;
}


function paddLeft(str,len,pstr){
    var ts = str.toString();
    var tl = ts.length;
    var tarr =[]
    if(len>tl){
        for(;len>tl;len--){
            tarr.push(pstr)
        }
    }
    tarr.push(str);

    return tarr.join("")
}

var tplFunction = function (fn) {
    var arr = fn.toString().split('\n');
    return arr.slice(1, arr.length - 1).join('\n');
};
function generateUUID() {
    var d = new Date().getTime();
    var uuid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
        var r = (d + Math.random()*16)%16 | 0;
        d = Math.floor(d/16);
        return (c=='x' ? r : (r&0x3|0x8)).toString(16);
    });
    return uuid;
};

function GetUrlParms(){
    var args=new Object();
    var query=location.search.substring(1);
    var pairs=query.split("&");
    for(var i=0;i<pairs.length;i++)
    {
        var pos=pairs[i].indexOf('=');
        if(pos==-1) continue;
        var argname=pairs[i].substring(0,pos);
        var value=pairs[i].substring(pos+1);
        args[argname]=value;
    }
    return args;
}

function xmlLoad(file){
    var xmlDoc;
    try //Internet Explorer
    {
        xmlDoc=new ActiveXObject("Microsoft.XMLDOM");
        xmlDoc.async=false;
        xmlDoc.load(file);
    }
    catch(e)
    {
        try //Firefox, Mozilla, Opera, etc.
        {
            xmlDoc=document.implementation.createDocument("","",null);
            xmlDoc.async=false;
            xmlDoc.load(file);
        }
        catch(e)
        {
            try //Google Chrome
            {
                var xmlhttp = new window.XMLHttpRequest();
                xmlhttp.open("GET",file,false);
                xmlhttp.send(null);
                xmlDoc = xmlhttp.responseXML.documentElement;
            }
            catch(e)
            {
                error=e.message;
            }
        }
    }
    return xmlDoc
}




function toJson(xmlDoc){


    var clen = xmlDoc.childElementCount;
    var nodeName = xmlDoc.nodeName;
    var nodeValue = xmlDoc.childNodes[0].nodeValue;
    var  roo="";
    if(clen>0){
        roo={};
        for(var i=0;i<clen;i++){
            var childNode = xmlDoc.children[i];
            var nodeName = childNode.nodeName;
            if(!!roo[nodeName]){
                if(roo[nodeName] instanceof Array){
                    roo[nodeName].push(toJson(childNode))
                }else{
                    roo[nodeName]=Array(roo[nodeName]);
                    roo[nodeName].push(toJson(childNode))
                }
            }else{
                roo[nodeName] =toJson(childNode)
            }

        }
    }else{
        roo= nodeValue
    }

    return roo
}



function xmlToJson(xmlDoc,roo){
    roo=roo||{}
    var clen = xmlDoc.childElementCount;
    var nodeName = xmlDoc.nodeName;
    var nodeValue = xmlDoc.childNodes[0].nodeValue;
    if(clen>0){
        if( !!roo[nodeName]){
           if(roo[nodeName] instanceof Array){
               roo[nodeName].push({})
           }else{
               roo[nodeName]=Array(roo[nodeName]);
               roo[nodeName].push({})

           }
            var idex = roo[nodeName].length -1;

            for(var i=0;i<clen;i++){
                var node = xmlDoc.children[i];
                xmlToJson(node, roo[nodeName][idex])
            }
        }else{
            roo[nodeName]={}
            for(var i=0;i<clen;i++){
                var node = xmlDoc.children[i];
                xmlToJson(node, roo[nodeName])
            }
        }



    }else{
        roo[nodeName] = nodeValue
    }
    return roo
}
