<%--
  Created by IntelliJ IDEA.
  User: QingXin
  Date: 2020/5/15
  Time: 19:27
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

    <!-- Bootstrap -->
    <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

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
                        <h3>总体概览   <small>包括：用户的具体信息、地域分布和年龄分布</small></h3>
                    </div>


                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>具体信息 <small>所有用户</small></h2>
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
                                <table id="datatable" class="table table-striped table-bordered">
                                    <thead>
                                    <tr>
                                        <th>编号</th>
                                        <th>手机号码</th>
                                        <th>姓名</th>
                                        <th>性别</th>
                                        <th>年龄</th>
                                        <th>归属地</th>
                                    </tr>
                                    </thead>


                                    <tbody>
                                    <c:forEach items="${contacts}" var="contact" >
                                        <tr>
                                            <td>${contact.id}</td>
                                            <td>${contact.tel}</td>
                                            <td>${contact.name}</td>
                                            <td>${contact.gender}</td>
                                            <td>${contact.age}</td>
                                            <td>${contact.address}</td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>


                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>地域分布 <small>所有用户</small></h2>
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
                                <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
                                <div id="main" style="width: 800px;height:600px;"></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-7 col-sm-7 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>年龄分布 <small>所有用户</small></h2>
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
                                <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
                                <div id="nianling" style="width: 600px;height:500px;"></div>



                            </div>
                        </div>
                    </div>


                    <div class="col-md-5 col-sm-5 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>年龄分布 <small>所有用户</small></h2>
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

                                <div id="nianling2" style="height:500px;" ></div>

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
<!-- iCheck -->
<script src="/vendors/iCheck/icheck.min.js"></script>
<!-- Datatables -->
<script src="/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="/vendors/jszip/dist/jszip.min.js"></script>
<script src="/vendors/pdfmake/build/pdfmake.min.js"></script>
<script src="/vendors/pdfmake/build/vfs_fonts.js"></script>
<!-- Custom Theme Scripts -->
<script src="/build/js/custom.min.js"></script>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    var name_title = "所有用户的地域分布"
    var subname = ''
    var nameColor = " rgb(55, 75, 113)"
    var name_fontFamily = '等线'
    var subname_fontSize = 15
    var name_fontSize = 18
    var mapName = 'china'
    var data = [
        <c:forEach items="${addresses}" var="address" >
        {
            name: "${address.address}",
            value: ${address.num}
        },
        </c:forEach>
    ];

    var geoCoordMap = {};
    var toolTipData = [
        <c:forEach items="${addressGenders}" var="addressGender" >
        {
            name: "${addressGender.address}",
            value: [{
                name: "${addressGender.gender1}",
                value: ${addressGender.num1}
            }, {
                name: "${addressGender.gender2}",
                value: ${addressGender.num2}
            }]
        },
        </c:forEach>

    ];

    /*获取地图数据*/
    myChart.showLoading();
    var mapFeatures = echarts.getMap(mapName).geoJson.features;
    myChart.hideLoading();
    mapFeatures.forEach(function(v) {
        // 地区名称
        var name = v.properties.name;
        // 地区经纬度
        geoCoordMap[name] = v.properties.cp;

    });

    // console.log("============geoCoordMap===================")
    // console.log(geoCoordMap)
    // console.log("================data======================")
    console.log(data)
    console.log(toolTipData)
    var max = 480,
        min = 9; // todo
    var maxSize4Pin = 100,
        minSize4Pin = 20;

    var convertData = function(data) {
        var res = [];
        for(var i = 0; i < data.length; i++) {
            var geoCoord = geoCoordMap[data[i].name];
            if(geoCoord) {
                res.push({
                    name: data[i].name,
                    value: geoCoord.concat(data[i].value),
                });
            }
        }
        return res;
    };
    option = {
        title: {
            text: name_title,
            subtext: subname,
            x: 'center',
            textStyle: {
                color: nameColor,
                fontFamily: name_fontFamily,
                fontSize: name_fontSize
            },
            subtextStyle: {
                fontSize: subname_fontSize,
                fontFamily: name_fontFamily
            }
        },
        tooltip: {
            trigger: 'item',
            formatter: function(params) {
                if(typeof(params.value)[2] == "undefined") {
                    var toolTiphtml = ''
                    for(var i = 0; i < toolTipData.length; i++) {
                        if(params.name == toolTipData[i].name) {
                            toolTiphtml += toolTipData[i].name + ':<br>'
                            for(var j = 0; j < toolTipData[i].value.length; j++) {
                                toolTiphtml += toolTipData[i].value[j].name + ':' + toolTipData[i].value[j].value + "<br>"
                            }
                        }
                    }
                    console.log(toolTiphtml)
                    // console.log(convertData(data))
                    return toolTiphtml;
                } else {
                    var toolTiphtml = ''
                    for(var i = 0; i < toolTipData.length; i++) {
                        if(params.name == toolTipData[i].name) {
                            toolTiphtml += toolTipData[i].name + ':<br>'
                            for(var j = 0; j < toolTipData[i].value.length; j++) {
                                toolTiphtml += toolTipData[i].value[j].name + ':' + toolTipData[i].value[j].value + "<br>"
                            }
                        }
                    }
                    console.log(toolTiphtml)
                    // console.log(convertData(data))
                    return toolTiphtml;
                }
            }
        },
        // legend: {
        //     orient: 'vertical',
        //     y: 'bottom',
        //     x: 'right',
        //     data: ['credit_pm2.5'],
        //     textStyle: {
        //         color: '#fff'
        //     }
        // },
        visualMap: {
            show: true,
            min: 0,
            max: 10,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'], // 文本，默认为数值文本
            calculable: true,
            seriesIndex: [1],
            inRange: {
                // color: ['#3B5077', '#031525'] // 蓝黑
                // color: ['#ffc0cb', '#800080'] // 红紫
                // color: ['#3C3B3F', '#605C3C'] // 黑绿
                // color: ['#0f0c29', '#302b63', '#24243e'] // 黑紫黑
                // color: ['#23074d', '#cc5333'] // 紫红
                color: ['#00467F', '#A5CC82'] // 蓝绿
                // color: ['#1488CC', '#2B32B2'] // 浅蓝
                // color: ['#00467F', '#A5CC82'] // 蓝绿
                // color: ['#00467F', '#A5CC82'] // 蓝绿
                // color: ['#00467F', '#A5CC82'] // 蓝绿
                // color: ['#00467F', '#A5CC82'] // 蓝绿

            }
        },
        /*工具按钮组*/
        // toolbox: {
        //     show: true,
        //     orient: 'vertical',
        //     left: 'right',
        //     top: 'center',
        //     feature: {
        //         dataView: {
        //             readOnly: false
        //         },
        //         restore: {},
        //         saveAsImage: {}
        //     }
        // },
        geo: {
            show: true,
            map: mapName,
            label: {
                normal: {
                    show: false
                },
                emphasis: {
                    show: false,
                }
            },
            roam: true,
            itemStyle: {
                normal: {
                    areaColor: '#031525',
                    borderColor: '#3B5077',
                },
                emphasis: {
                    areaColor: '#2B91B7',
                }
            }
        },
        series: [{
            name: '散点',
            type: 'scatter',
            coordinateSystem: 'geo',
            data: convertData(data),
            symbolSize: function(val) {
                return val[2] / 10;
            },
            label: {
                normal: {
                    formatter: '{b}',
                    position: 'right',
                    show: true
                },
                emphasis: {
                    show: true
                }
            },
            itemStyle: {
                normal: {
                    color: '#05C3F9'
                }
            }
        },
            {
                type: 'map',
                map: mapName,
                geoIndex: 0,
                aspectScale: 0.75, //长宽比
                showLegendSymbol: false, // 存在legend时显示
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: false,
                        textStyle: {
                            color: '#fff'
                        }
                    }
                },
                roam: true,
                itemStyle: {
                    normal: {
                        areaColor: '#031525',
                        borderColor: '#3B5077',
                    },
                    emphasis: {
                        areaColor: '#2B91B7'
                    }
                },
                animation: false,
                data: data
            },
            {
                name: '点',
                type: 'scatter',
                coordinateSystem: 'geo',
                symbol: 'pin', //气泡
                symbolSize: function(val) {
                    var a = (maxSize4Pin - minSize4Pin) / (max - min);
                    var b = minSize4Pin - a * min;
                    b = maxSize4Pin - a * max;
                    return a * val[2] + b;
                },
                label: {
                    normal: {
                        show: true,
                        textStyle: {
                            color: '#fff',
                            fontSize: 9,
                        }
                    }
                },
                itemStyle: {
                    normal: {
                        color: '#F62157', //标志颜色
                    }
                },
                zlevel: 6,
                data: convertData(data),
            },
            {
                name: 'Top 5',
                type: 'effectScatter',
                coordinateSystem: 'geo',
                data: convertData(data.sort(function(a, b) {
                    return b.value - a.value;
                }).slice(0, 5)),
                symbolSize: function(val) {
                    return val[2] / 10;
                },
                showEffectOn: 'render',
                rippleEffect: {
                    brushType: 'stroke'
                },
                hoverAnimation: true,
                label: {
                    normal: {
                        formatter: '{b}',
                        position: 'right',
                        show: true
                    }
                },
                itemStyle: {
                    normal: {
                        color: 'yellow',
                        shadowBlur: 10,
                        shadowColor: 'yellow'
                    }
                },
                zlevel: 1
            },

        ]
    };
    myChart.setOption(option);
</script>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart2 = echarts.init(document.getElementById('nianling'));

    var option2 = {
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
            data:['女性','男性']
        },
        xAxis: [
            {
                type: 'category',
                data: ['20岁以下','20-30岁','30-40岁','40-50岁','50-60岁','60岁以上'],
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '人数',
                min: 0,
                max: 20,
                interval: 2,
                axisLabel: {
                    formatter: '{value}'
                }
            }
        ],
        series: [
            {
                name:'女性',
                type:'bar',
                data:[
                    <c:forEach items="${womenLists}" var="womenList" >
                    ${womenList},
                    </c:forEach>

                ]
            },
            {
                name:'男性',
                type:'bar',
                data:[
                    <c:forEach items="${menLists}" var="menList" >
                    ${menList},
                    </c:forEach>
                ]
            }
        ]
    };




    // 使用刚指定的配置项和数据显示图表。
    myChart2.setOption(option2);
</script>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart3 = echarts.init(document.getElementById('nianling2'));

    var option3 = {
        title : {
            text: '',
            subtext: '',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['20岁以下','20-30岁','30-40岁','40-50岁','50-60岁','60岁以上']
        },
        series : [
            {
                name: '人数',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:${humanLists.get(0)}, name:'20岁以下'},
                    {value:${humanLists.get(1)}, name:'20-30岁'},
                    {value:${humanLists.get(2)}, name:'30-40岁'},
                    {value:${humanLists.get(3)}, name:'40-50岁'},
                    {value:${humanLists.get(4)}, name:'50-60岁'},
                    {value:${humanLists.get(5)}, name:'60岁以上'}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };


    // 使用刚指定的配置项和数据显示图表。
    myChart3.setOption(option3);
</script>

</body>
</html>
