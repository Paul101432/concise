

/**
 * 返回客户端的ip跟所在城市  需要引用js:
 * <script src="http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js" ></script>
 * <script src="http://pv.sohu.com/cityjson?ie=utf-8"></script>
 * @returns {{province: *, city: *, ip: *}}
 */
function getIpPlace() {
    var json = {
        "province":remote_ip_info.province,
        "city":remote_ip_info.city,
        "ip":returnCitySN.cip
    };
    $.post("/log",{"log.ip":json.ip,"log.ip":json.province+"_"+json.city},function (re) {
        console.log(re);
    },"json");
    return json;
}