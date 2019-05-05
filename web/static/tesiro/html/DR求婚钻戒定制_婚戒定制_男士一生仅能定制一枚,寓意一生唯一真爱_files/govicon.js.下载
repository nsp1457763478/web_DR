// JavaScript Document
// zengqingfeng_20130618 create
function GetRequest() {
    var d = document.getElementById("ebsgovicon").src.toLowerCase();
    //var theRequest = /govicon.js\?id=([0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12})&width=([0-9]+)&height=([0-9]+)/.test(d) ? RegExp.$1 : "error";
    //var iconwidth = /govicon.js\?id=([0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12})&width=([0-9]+)&height=([0-9]+)&type=([0-9]+)/.test(d) ? RegExp.$2 : "36"; //default height
    //var iconheight = /govicon.js\?id=([0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12})&width=([0-9]+)&height=([0-9]+)&type=([0-9]+)/.test(d) ? RegExp.$3 : "50"; //default width
    //var type = /govicon.js\?id=([0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12})&width=([0-9]+)&height=([0-9]+)&type=([0-9]+)/.test(d) ? RegExp.$4 : "1"; //default width
    var theRequest = GetParameter(d, "id=");
    var iconwidth = GetParameter(d, "width=");
    var iconheight = GetParameter(d, "height=");
    var type = GetParameter(d, "type=");
    var retstr = { "id": theRequest, "width": iconwidth, "height": iconheight, "type": type };
    return retstr;
}

function GetParameter(url, parameter)
{
    var indexStart = url.indexOf(parameter) + parameter.length;
    var indexEnd = url.indexOf("&", indexStart);
    if (indexEnd > 0) {
        return url.substring(indexStart, indexEnd);
    }
    else {
        return url.substring(indexStart);
    }
}

//var webprefix = "http://szcert.ebs.org.com/"
//var iconImageURL = "http://szcert.ebs.org.com/Images/govIcon.gif";
//var webprefix = "http://localhost:32005/";
//var iconImageURL = "http://localhost:32005/Images/govIcon.gif";
//var niconImageURL = "http://szcert.ebs.org.com/Images/newGovIcon.gif";
var webprefix = "https://szcert.ebs.org.cn/"
var iconImageURL = "https://szcert.ebs.org.cn/Images/govIcon.gif";
var niconImageURL = "https://szcert.ebs.org.cn/Images/newGovIcon.gif";
//var webCertAccessTraceURL = "http://szcert.ebs.org.cn/cert/CertAccessTrace";
var tempiconImageURL = "";

var params = GetRequest();
if (params.type == "1") {
    tempiconImageURL = iconImageURL;
}
if (params.type == "2") {
    tempiconImageURL = niconImageURL;
}
document.write('<a href="' + webprefix + params.id + '" target="_blank"><img src="' + tempiconImageURL + '" title="深圳市市场监督管理局企业主体身份公示" alt="深圳市市场监督管理局企业主体身份公示" width="' + params.width + '" height="' + params.height + '"border="0" style="border-width:0px;border:hidden; border:none;"></a>');

//在页面加载完成后，获取信息并且异步post到cert.gov.com
document.write('<script type="text/javascript" src="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js"></script>');

function crossDomainPost() {
	try{
	  // Add the iframe with a unique name
	  var iframe = document.createElement("iframe");
	  var uniqueString = "Gov";
	  document.body.appendChild(iframe);
	  iframe.style.display = "none";
	  iframe.contentWindow.name = uniqueString;

	  // construct a form with hidden inputs, targeting the iframe
//	  var form = document.createElement("form");
//	  form.target = uniqueString;
//	  form.action = webCertAccessTraceURL+"?remote_id=" + params.id +"&remote_ip="+remote_ip_info.end+"&remote_country="+remote_ip_info.country+"&remote_province="+remote_ip_info.province+"&remote_city="+remote_ip_info.city+"&remote_url="+window.location.href;
//	  form.method = "POST";
//	  document.body.appendChild(form);
//	  form.submit();  
	  }catch(ex) {
		//don't throw exception to client
	  }
}
document.write('<script id="dyamicGovScript" defer="defer" type="text/javascript">  window.onload=function( ){  crossDomainPost(); } </script>');