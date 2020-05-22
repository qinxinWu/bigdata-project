<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="/bootstrap/css/bootstrap.css" rel="stylesheet">

</head>
<body>

<form>
    <div class="form-group">
        <label for="tel">电话号码</label>
        <input type="text" class="form-control" id="tel" placeholder="请输入电话号码">
    </div>
    <div class="form-group">
        <label for="calltime">查询时间</label>
        <input type="text" class="form-control" id="calltime" placeholder="请输入查询时间">
    </div>
    <button type="button" class="btn btn-default" onclick="queryData()">查询</button>
</form>

<div id="main" ></div>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/jquery/jquery-2.1.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="/bootstrap/js/bootstrap.js"></script>

<script src="/jquery/echarts.min.js"></script>
<script>
    //声明方法
    function queryData() {
        window.location.href = "/view?tel=" + $("#tel").val() + "&calltime=" + $("#calltime").val();
        
    }
</script>

<script>
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));



    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);


</script>

</body>
</html>