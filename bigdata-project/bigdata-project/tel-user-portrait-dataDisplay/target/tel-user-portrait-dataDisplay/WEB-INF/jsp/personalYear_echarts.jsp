<%--
  Created by IntelliJ IDEA.
  User: QingXin
  Date: 2020/5/15
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>用 户 画 像</title>

    <!-- 引入 echarts.js -->
    <script src="/my/echarts.js"></script>
    <script src="/my/echarts.min.js"></script>
    <script src="/my/bmap.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=YCIdHfIrHbzagb6UyqAEGkv05O79wh5D"></script>
    <script src="/my/china.js"></script>
    <script src="/my/echarts-wordcloud.min.js"></script>

    <!-- Bootstrap -->
    <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/vendors/nprogress/nprogress.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/build/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>用 户 画 像</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic">
                        <img src="/images/img.jpg" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>欢迎,</span>
                        <h2>吴清鑫</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br />


                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>通用</h3>
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i>   概览与查询 <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/tablesDynamic">总体概览</a></li>
                                    <li><a href="/totalForm">总体查询</a></li>
                                    <li><a href="/personalForm">个体查询</a></li>
                                </ul>
                            </li>

                            <li><a><i class="fa fa-bar-chart-o"></i>   大数据展示<span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/totalForm">总体数据展示</a></li>

                                    <li><a href="/personalForm">个体数据展示</a></li>

                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- /sidebar menu -->


                <!-- /menu footer buttons -->
                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="Settings">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Lock">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
                <!-- /menu footer buttons -->
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <nav>
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>个体年数据展示</h3>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>个人信息词云</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">设置 1</a>
                                            </li>
                                            <li><a href="#">设置 2</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">

                                <div id="personalData" style="height:500px;"></div>

                            </div>
                        </div>
                    </div>



                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>各个月的通话次数、时长（小时）</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">设置 1</a>
                                            </li>
                                            <li><a href="#">设置 2</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">

                                <div id="personalYearTel" style="height:500px;"></div>

                            </div>
                        </div>
                    </div>


                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>年度通话呼出男女占比</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">设置 1</a>
                                            </li>
                                            <li><a href="#">设置 2</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">

                                <div id="personalYearCaller" style="height:500px;"></div>

                            </div>
                        </div>
                    </div>

                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>年度通话呼入男女占比</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">设置 1</a>
                                            </li>
                                            <li><a href="#">设置 2</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">

                                <div id="personalYearCallee" style="height:500px;"></div>

                            </div>
                        </div>
                    </div>

                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>亲密通话对象</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">设置 1</a>
                                            </li>
                                            <li><a href="#">设置 2</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">

                                <div id="intimacy" style="height:500px;"></div>

                            </div>
                        </div>
                    </div>

                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>年度通话线路展示</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">设置 1</a>
                                            </li>
                                            <li><a href="#">设置 2</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">

                                <div id="perCallPath" style="height:500px;"></div>

                            </div>
                        </div>
                    </div>






                </div>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div>

<!-- jQuery -->
<script src="/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="/vendors/nprogress/nprogress.js"></script>
<!-- ECharts -->

<script src="/vendors/echarts/map/js/world.js"></script>

<!-- Custom Theme Scripts -->
<script src="/build/js/custom.min.js"></script>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart2 = echarts.init(document.getElementById('personalData'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '',
            link: 'https://www.baidu.com/s?wd=' + encodeURIComponent('ECharts'),
            x: 'center',
            textStyle: {
                fontSize: 23
            }

        },
        backgroundColor: '#fff',
        tooltip: {
            show: true
        },
        toolbox: {
            feature: {
                saveAsImage: {
                    iconStyle: {
                        normal: {
                            color: '#FFFFFF'
                        }
                    }
                }
            }
        },
        series: [{
            name: '信息分析',
            type: 'wordCloud',
            //size: ['9%', '99%'],
            sizeRange: [46, 66],
            //textRotation: [0, 45, 90, -45],
            rotationRange: [-45, 90],
            //shape: 'circle',
            textPadding: 0,
            autoSize: {
                enable: true,
                minSize: 6
            },
            textStyle: {
                normal: {
                    color: function() {
                        return 'rgb(' + [
                            Math.round(Math.random() * 160),
                            Math.round(Math.random() * 160),
                            Math.round(Math.random() * 160)
                        ].join(',') + ')';
                    }
                },
                emphasis: {
                    shadowBlur: 10,
                    shadowColor: '#333'
                }
            },
            data: [{
                name: "Jayfee",
                value: 666
            }, {
                name: "Nancy",
                value: 520
            }]
        }]
    };

    var JosnList = [];

    JosnList.push(
        <c:forEach items="${contacts}" var="contact">
        {
            name: "${contact.getName()}",
            value: 666
        },
        {
            name: "${contact.getGender()}性",
            value: 600
        },
        {
            name: "${contact.getAge()}岁",
            value: 555
        },
        {
            name: "归属地：${contact.getAddress()}省（市）",
            value: 500
        },
        {
            name: "手机号码：${contact.getTel()}",
            value: 100
        },
        </c:forEach>

    );

    option.series[0].data = JosnList;


    myChart2.setOption(option);



</script>


<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('personalYearTel'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '',
            subtext: ''
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['通话次数', '通话时长']
        },
        toolbox: {
            show: true,
            feature: {
                dataView: {
                    show: true,
                    readOnly: false
                },
                magicType: {
                    show: true,
                    type: ['line', 'bar']
                },
                restore: {
                    show: true
                },
                saveAsImage: {
                    show: true
                }
            }
        },
        calculable: true,
        xAxis: [{
            type: 'category',
            data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
        }],
        yAxis: [{
            type: 'value'
        }],
        series: [{
            name: '通话次数',
            type: 'bar',
            data: [
                <c:forEach items="${perTels}" var="perTel">
                ${perTel.getSumCall()},
                </c:forEach>
            ],

        },
            {
                name: '通话时长',
                type: 'bar',
                data: [
                    <c:forEach items="${perTels}" var="perTel">
                    ${perTel.getSumDuration()},
                    </c:forEach>
                ],

            }
        ]
    };// 使用刚指定的配置项和数据显示图表。
    myChart1.setOption(option);
</script>


<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart3 = echarts.init(document.getElementById('personalYearCaller'));

    // 指定图表的配置项和数据

    var xData = function() {
        var data = [];
        for (var i = 1; i < 13; i++) {
            data.push(i + "月份");
        }
        return data;
    }();

    var option = {
        backgroundColor: "#fff",
        "title": {
            "text": "",
            "subtext": "",
            x: "4%",

            textStyle: {
                color: '#000',
                fontSize: '22'
            },
            subtextStyle: {
                color: '#000000',
                fontSize: '16',

            },
        },
        "tooltip": {
            "trigger": "axis",
            "axisPointer": {
                "type": "shadow",
                textStyle: {
                    color: "#000000"
                }

            },
        },
        "grid": {
            "borderWidth": 0,
            "top": 110,
            "bottom": 95,
            textStyle: {
                color: "#000000"
            }
        },
        "legend": {
            x: '4%',
            top: '11%',
            textStyle: {
                color: '#000000',
            },
            "data": ['女', '男', '平均']
        },


        "calculable": true,
        "xAxis": [{
            "type": "category",
            "axisLine": {
                lineStyle: {
                    color: '#000000'
                }
            },
            "splitLine": {
                "show": false
            },
            "axisTick": {
                "show": false
            },
            "splitArea": {
                "show": false
            },
            "axisLabel": {
                "interval": 0,

            },
            "data": xData,
        }],
        "yAxis": [{
            "type": "value",
            "splitLine": {
                "show": false
            },
            "axisLine": {
                lineStyle: {
                    color: '#000000'
                }
            },
            "axisTick": {
                "show": false
            },
            "axisLabel": {
                "interval": 0,

            },
            "splitArea": {
                "show": false
            },

        }],
        "dataZoom": [{
            "show": true,
            "height": 30,
            "xAxisIndex": [
                0
            ],
            bottom: 30,
            "start": 10,
            "end": 80,
            handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
            handleSize: '110%',
            handleStyle:{
                color:"rgba(255,144,128,1)",

            },
            textStyle:{
                color:"#000000"},
            borderColor:"#000000"


        }, {
            "type": "inside",
            "show": true,
            "height": 15,
            "start": 1,
            "end": 35
        }],
        "series": [{
            "name": "女",
            "type": "bar",
            "stack": "总量",
            "barMaxWidth": 35,
            "barGap": "10%",
            "itemStyle": {
                "normal": {
                    "color": "rgba(255,144,128,1)",
                    "label": {
                        "show": true,
                        "textStyle": {
                            "color": "#fff"
                        },
                        "position": "insideTop",
                        formatter: function(p) {
                            return p.value > 0 ? (p.value) : '';
                        }
                    }
                }
            },
            "data": [
                <c:forEach items="${callerWomans}" var="callerWoman">
                ${callerWoman.getSumCall()},
                </c:forEach>
            ],
        },

            {
                "name": "男",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(0,191,183,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": true,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": [
                    <c:forEach items="${callerMans}" var="callerMan">
                    ${callerMan.getSumCall()},
                    </c:forEach>
                ]
            }, {
                "name": "总数",
                "type": "line",
                "stack": "总量",
                symbolSize:10,
                symbol:'circle',
                "itemStyle": {
                    "normal": {
                        "color": "rgba(252,230,48,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": true,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": [
                    <c:forEach items="${callerHumans}" var="callerHuman">
                        ${callerHuman},
                    </c:forEach>
                ]
            },
        ]
    }


    myChart3.setOption(option);
</script>


<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart4 = echarts.init(document.getElementById('personalYearCallee'));

    // 指定图表的配置项和数据

    var xData = function() {
        var data = [];
        for (var i = 1; i < 13; i++) {
            data.push(i + "月份");
        }
        return data;
    }();

    var option = {
        backgroundColor: "#fff",
        "title": {
            "text": "",
            "subtext": "",
            x: "4%",

            textStyle: {
                color: '#fff',
                fontSize: '22'
            },
            subtextStyle: {
                color: '#90979c',
                fontSize: '16',

            },
        },
        "tooltip": {
            "trigger": "axis",
            "axisPointer": {
                "type": "shadow",
                textStyle: {
                    color: "#000000"
                }

            },
        },
        "grid": {
            "borderWidth": 0,
            "top": 110,
            "bottom": 95,
            textStyle: {
                color: "#000000"
            }
        },
        "legend": {
            x: '4%',
            top: '11%',
            textStyle: {
                color: '#000000',
            },
            "data": ['女', '男', '平均']
        },


        "calculable": true,
        "xAxis": [{
            "type": "category",
            "axisLine": {
                lineStyle: {
                    color: '#000000'
                }
            },
            "splitLine": {
                "show": false
            },
            "axisTick": {
                "show": false
            },
            "splitArea": {
                "show": false
            },
            "axisLabel": {
                "interval": 0,

            },
            "data": xData,
        }],
        "yAxis": [{
            "type": "value",
            "splitLine": {
                "show": false
            },
            "axisLine": {
                lineStyle: {
                    color: '#000000'
                }
            },
            "axisTick": {
                "show": false
            },
            "axisLabel": {
                "interval": 0,

            },
            "splitArea": {
                "show": false
            },

        }],
        "dataZoom": [{
            "show": true,
            "height": 30,
            "xAxisIndex": [
                0
            ],
            bottom: 30,
            "start": 10,
            "end": 80,
            handleIcon: 'path://M306.1,413c0,2.2-1.8,4-4,4h-59.8c-2.2,0-4-1.8-4-4V200.8c0-2.2,1.8-4,4-4h59.8c2.2,0,4,1.8,4,4V413z',
            handleSize: '110%',
            handleStyle:{
                color:"rgba(255,144,128,1)",

            },
            textStyle:{
                color:"#000000"},
            borderColor:"#000000"


        }, {
            "type": "inside",
            "show": true,
            "height": 15,
            "start": 1,
            "end": 35
        }],
        "series": [{
            "name": "女",
            "type": "bar",
            "stack": "总量",
            "barMaxWidth": 35,
            "barGap": "10%",
            "itemStyle": {
                "normal": {
                    "color": "rgba(255,144,128,1)",
                    "label": {
                        "show": true,
                        "textStyle": {
                            "color": "#fff"
                        },
                        "position": "insideTop",
                        formatter: function(p) {
                            return p.value > 0 ? (p.value) : '';
                        }
                    }
                }
            },
            "data": [
                <c:forEach items="${calleeWomans}" var="calleeWoman">
                ${calleeWoman.getSumCall()},
                </c:forEach>
            ],
        },

            {
                "name": "男",
                "type": "bar",
                "stack": "总量",
                "itemStyle": {
                    "normal": {
                        "color": "rgba(0,191,183,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": true,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": [
                    <c:forEach items="${calleeMans}" var="calleeMan">
                    ${calleeMan.getSumCall()},
                    </c:forEach>
                ]
            }, {
                "name": "总数",
                "type": "line",
                "stack": "总量",
                symbolSize:10,
                symbol:'circle',
                "itemStyle": {
                    "normal": {
                        "color": "rgba(252,230,48,1)",
                        "barBorderRadius": 0,
                        "label": {
                            "show": true,
                            "position": "top",
                            formatter: function(p) {
                                return p.value > 0 ? (p.value) : '';
                            }
                        }
                    }
                },
                "data": [
                    <c:forEach items="${calleeHumans}" var="calleeHuman">
                    ${calleeHuman},
                    </c:forEach>
                ]
            },
        ]
    }


    myChart4.setOption(option);
</script>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart5 = echarts.init(document.getElementById('intimacy'));

    // 指定图表的配置项和数据
    var option = {
        backgroundColor: '#fff',
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data:['通话时长','通话数量']
        },
        xAxis: [
            {
                type: 'category',
                data: [
                    <c:forEach items="${intimacies}" var="intimacy">
                    '${intimacy.getMonth()}月(${intimacy.getName()})',
                    </c:forEach>
                ],
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '时长',
                min: 0,
                max: 10,
                interval: 1,
                axisLabel: {
                    formatter: '{value} 小时'
                }
            },
            {
                type: 'value',
                name: '数量',
                min: 0,
                max: 10,
                interval: 1,
                axisLabel: {
                    formatter: '{value} '
                }
            }
        ],
        series: [
            {
                name:'通话时长',
                type:'bar',
                data:[
                    <c:forEach items="${intimacies}" var="intimacy">
                    ${intimacy.getSumDuration()},
                    </c:forEach>
                ]
            },
            {
                name:'通话数量',
                type:'line',
                yAxisIndex: 1,
                data:[
                    <c:forEach items="${intimacies}" var="intimacy">
                    ${intimacy.getSumCall()},
                    </c:forEach>
                ]
            }
        ]
    };




    // 使用刚指定的配置项和数据显示图表。
    myChart5.setOption(option);
</script>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart4 = echarts.init(document.getElementById('perCallPath'));

    var geoData = {
        '北京':[116.42,39.92],
        '上海':[121.48,31.22],
        '天津':[117.20,39.13],
        '香港':[114.10,22.20],
        '广东':[113.30,23.20],
        '浙江':[120.20,30.27],
        '重庆':[106.45,29.57],
        '甘肃':[103.73,36.03],
        '贵州':[106.72,26.57],
        '湖南':[113.00,28.22],
        '江苏':[118.78,32.05],
        '江西':[115.90,28.68],
        '辽宁':[123.38,41.80],
        '山西':[112.53,37.87],
        '四川':[104.07,30.67],
        '西藏':[91.11,29.97],
        '新疆':[87.68,43.77],
        '云南':[102.73,25.05],
        '陕西':[108.95,34.27],
        '青海':[101.75,36.57],
        '宁夏':[106.27,38.47],
        '黑龙江':[126.63,45.75],
        '吉林':[125.35,43.88],
        '湖北':[114.32,30.52],
        '河南':[113.65,34.77],
        '河北':[114.48,38.03],
        '海南':[110.35,20.02],
        '澳门':[113.50,22.20],
        '福建':[119.3,26.08],
        '安徽':[117.17,31.51],
        '广西':[108.19,22.48],
        '台湾':[121.30,25.03],
        '山东':[116.98,36.67],
        '内蒙古':[111.73,40.83]

    };




    // 指定图表的配置项和数据
    var allData = {
        "citys": [
            {
                "name": "北京",
                "value": [116.42, 39.92, 2],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "上海",
                "value": [121.48, 31.22, 2],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "天津",
                "value": [117.20, 39.13, 4],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "香港",
                "value": [114.10, 22.20, 1],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "广东",
                "value": [113.30,23.20, 1],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "浙江",
                "value": [120.20,30.27, 1],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "重庆",
                "value": [106.45,29.57, 32],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "甘肃",
                "value": [103.73,36.03, 10],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "贵州",
                "value": [106.72,26.57, 1],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "湖南",
                "value": [113.00,28.22, 2],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "江苏",
                "value": [118.78,32.05, 3],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "江西",
                "value": [115.90,28.68, 2],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "辽宁",
                "value": [123.38,41.80, 9],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "山西",
                "value": [112.53,37.87, -19],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#58B3CC"
                    }
                }
            },
            {
                "name": "四川",
                "value": [104.07,30.67, 14],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "西藏",
                "value": [91.11,29.97, 1],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "新疆",
                "value": [87.68,43.77, 1],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "云南",
                "value": [102.73,25.05, -364],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#58B3CC"
                    }
                }
            },
            {
                "name": "陕西",
                "value": [108.95,34.27, -2],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#58B3CC"
                    }
                }
            },
            {
                "name": "青海",
                "value": [101.75,36.57, 1],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "宁夏",
                "value": [106.27,38.47, 1],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "黑龙江",
                "value": [126.63,45.75, 2],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "吉林",
                "value": [125.35,43.88, 1],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "湖北",
                "value": [114.32,30.52, -2],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#58B3CC"
                    }
                }
            },
            {
                "name": "河南",
                "value": [113.65,34.77, 2],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "河北",
                "value": [114.48,38.03, 1],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "海南",
                "value": [110.35,20.02, -14],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#58B3CC"
                    }
                }
            },
            {
                "name": "澳门",
                "value": [113.50,22.20, 2],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "福建",
                "value": [119.3,26.08, 1],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "安徽",
                "value": [117.17,31.51, 1],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "广西",
                "value": [108.19,22.48, 1],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "台湾",
                "value": [121.30,25.03, 1],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            },
            {
                "name": "山东",
                "value": [116.98,36.67, -5],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#58B3CC"
                    }
                }
            },
            {
                "name": "内蒙古",
                "value": [111.73,40.83, 2],
                "symbolSize": 14,
                "itemStyle": {
                    "normal": {
                        "color": "#F58158"
                    }
                }
            }
        ],
        "moveLines": [
            <c:forEach items="${perCallPaths}" var="callPath">
            {
                "fromName": "${callPath.getAddress1()}",
                "toName": "${callPath.getAddress2()}",
                "coords": [
                    geoData["${callPath.getAddress1()}"],
                    geoData["${callPath.getAddress2()}"]
                ]
            },
            </c:forEach>
        ]
    };

    var option = {
        backgroundColor:'#fff',
        title: {
            text: '',
            left: 'center',
            textStyle: {
                color: '#fff'
            }
        },
        legend: {
            show: false,
            orient: 'vertical',
            top: 'bottom',
            left: 'right',
            data: ['地点', '线路'],
            textStyle: {
                color: '#fff'
            }
        },
        geo: {
            map: 'china',
            label: {
                emphasis: {
                    show: false
                }
            },
            roam: true,
            itemStyle: {
                normal: {
                    areaColor: '#A1232B',
                    borderColor: '#111'
                },
                emphasis: {
                    areaColor: '#5E2028'
                }
            }
        },
        series: [{
            name: '地点',
            type: 'effectScatter',
            coordinateSystem: 'geo',
            zlevel: 2,
            rippleEffect: {
                brushType: 'stroke'
            },
            label: {
                emphasis: {
                    show: true,
                    position: 'right',
                    formatter: '{b}'
                }
            },
            symbolSize: 2,
            showEffectOn: 'render',
            itemStyle: {
                normal: {
                    color: '#46bee9'
                }
            },
            data: allData.citys
        }, {
            name: '线路',
            type: 'lines',
            coordinateSystem: 'geo',
            zlevel: 2,
            large: true,
            effect: {
                show: true,
                constantSpeed: 30,
                symbol: 'pin',
                symbolSize: 3,
                trailLength: 0,
            },
            lineStyle: {
                normal: {
                    color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0, color: '#58B3CC'
                    }, {
                        offset: 1, color: '#F58158'
                    }], false),
                    width: 1,
                    opacity: 0.2,
                    curveness: 0.1
                }
            },
            data: allData.moveLines
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart4.setOption(option);
</script>

</body>
</html>

