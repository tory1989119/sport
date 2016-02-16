<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>报名俱乐部</title>
    	<!-- bootstrap 3.0.2 -->
        <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- DATA TABLES -->
        <link href="<%=request.getContextPath()%>/css/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="<%=request.getContextPath()%>/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="<%=request.getContextPath()%>/css/MyAdminLTE.css" rel="stylesheet" type="text/css" />
        <!-- daterangepicker -->
        <link href="<%=request.getContextPath()%>/css/daterangepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
        
         <!-- jQuery 2.0.2 -->
        <script src="<%=request.getContextPath()%>/js/jquery.js" type="text/javascript"></script>
        <!-- Bootstrap -->
        <script src="<%=request.getContextPath()%>/js/bootstrap.min.js" type="text/javascript"></script>
        <!-- DATA TABES SCRIPT -->
        <script src="<%=request.getContextPath()%>/js/plugins/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/js/plugins/datatables/dataTables.bootstrap.js" type="text/javascript"></script>
    	<!-- daterangepicker -->
    	<script src="<%=request.getContextPath()%>/js/plugins/daterangepicker/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
    	<script src="<%=request.getContextPath()%>/js/plugins/daterangepicker/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
    
        <!-- page script -->
        <script type="text/javascript">
        var table;
        $(function () {
        	$('#dstart').datetimepicker({
        		minView: "month", //选择日期后，不会再跳转去选择时分秒 
        		format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
        		language: 'zh-CN', //汉化 
        		autoclose:true //选择日期后自动关闭 
            });
        	$('#dend').datetimepicker({
        		minView: "month", //选择日期后，不会再跳转去选择时分秒 
        		format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式 
        		language: 'zh-CN', //汉化 
        		autoclose:true //选择日期后自动关闭 
            });
        	
            table = $('#example').DataTable({
            	"bLengthChange": false,
            	"bFilter": false,
            	"ordering": false,
                "ajax": {
                	"type": "POST",
                	"data": function ( d ) {
                        //添加额外的参数传给服务器
                        d.id = $("#sid").val();
                        d.comName = $("#scomName").val();
                        d.startdate = $("#startdate").val();
                        d.enddate = $("#enddate").val();
                        $("#showdig").css("display","block");//遮罩层开启
                    },
                	"dataType": "json",
                    "url": '<%=request.getContextPath()%>/custcominfo/getlist.do'
                },
                "serverSide": true,
                "columns": [
                    {"data": "id"},
                    {"data": "acctId"},
                    {"data": "comName"},
                    {"data": "comEmail"},
                    {"data": "comMobile"},
                    {"data": "comTel"},
                    {"data": "comPerson"},
                    {"data": "regTime"},
                    {"data": null},
                    {"data": "comLicenseCode"},
                    {"data": "comLicensePic"},
                    {"data": "comAuthorizePic"},
                    {"data": "comLogo"},
                    {"data": "comRemark"},
                    {"data": "comAddr"}
                ],
                "columnDefs": [
                     {
                         "targets": 8,
                         "render": function (a, b, c, d) {
                             var html = "<button type=\"button\" class=\"btn btn-primary btn-smg\" onclick=\"detail('"+ c.id +"','"+ c.acctId +"','"+ c.comName +"','"+ c.comEmail +"','"+ c.comLicenseCode +"','"+ c.comLicensePic +"','"+ c.comMobile +"','"+ c.comTel +"','"+ c.comPerson +"','"+ c.comAuthorizePic +"','"+ c.comLogo +"','"+ c.comRemark +"','"+ c.comAddr +"','"+ c.strregtime +"')\">详情</button>";
                             return html;
                         }
                     },
                     {    
	          	          "targets": [ 9,10,11,12,13,14 ], //从第0列开始   
		          		  "visible": false    
		          	}
                ],
                "language": {
                    "lengthMenu": "_MENU_ 条记录每页",
                    "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                    "zeroRecords": "没有找到记录",
                    "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
                    "infoEmpty": "无记录",
                    "infoFiltered": "(从 _MAX_ 条记录过滤)",
                    "paginate": {
                        "previous": "上一页",
                        "next": "下一页"
                    }
                },
                "preDrawCallback":function( oSettings ) {
                	$("#showdig").css("display","none");//遮罩层关闭
                } 
            });
            
        });
        
        /**
         * 查找
         */
        function search(){
        	table.ajax.reload();
        }
        
        /**
         * 详情
         */
        function detail(id,acctId,comName,comEmail,comLicenseCode,comLicensePic,comMobile,comTel,comPerson,comAuthorizePic,comLogo,comRemark,comAddr,strregtime){
        	$("#comName").val(comName).attr("disabled",true);
        	$("#comEmail").val(comEmail).attr("disabled",true);
        	$("#comLicenseCode").val(comLicenseCode).attr("disabled",true);
        	$("#comLicensePic").attr('src',comLicensePic).attr("disabled",true);
        	$("#comMobile").val(comMobile).attr("disabled",true);
        	$("#comTel").val(comTel).attr("disabled",true);
        	$("#comPerson").val(comPerson).attr("disabled",true);
        	$("#comAuthorizePic").attr('src',comAuthorizePic).attr("disabled",true);
        	$("#comLogo").attr('src',comLogo).attr("disabled",true);
        	$("#comRemark").val(comRemark).attr("disabled",true);
        	$("#comAddr").val(comAddr).attr("disabled",true);
        	$("#strregtime").val(strregtime).attr("disabled",true);
            $("#myModal").modal({backdrop: 'static'});
        }
        
      //关闭弹出框
        function closeDiv(){
        	$("#myModal").modal("hide");
        }
        </script>
</head>
<body class="skin-blue">
           <aside class="right-side">
               <section class="content-header">
                   <h1>主办方管理</h1>
                   <ol class="breadcrumb">
                       <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 会员管理</a></li>
                       <li >主办方管理</li>
                   </ol>
               </section>
               
               <section class="content">
                   <div class="row">
                       <div class="col-xs-12">
                           <div class="box">
	                           <div id="showdig" class="overlay" style="display: none">
								  <i class="fa fa-refresh fa-spin"></i>
								</div>
				                <div class="box-body">
				                  	<div class="row">
					                  	<div class="col-xs-3">
							                <div id="dstart" class="input-group date form_datetime col-md-12">
							                    <input id="startdate" name="startdate" class="form-control" size="16" type="text" value="" readonly placeholder="注册开始日期">
												<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
												<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							                </div>
							            </div>
							            <div class="col-xs-3">
							                <div id="dend" class="input-group date form_datetime col-md-12">
							                    <input id="enddate" name="enddate" class="form-control" size="16" type="text" value="" readonly placeholder="注册结束日期">
												<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
												<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							                </div>
							            </div>
					                    <div class="col-xs-2">
					                      <input type="text" class="form-control" id="sid" name="sid" placeholder="主办方编号">
					                    </div>
					                    <div class="col-xs-2">
					                      <input type="text" class="form-control" id="scomName" name="scomName" placeholder="主办方名称">
					                    </div>
					                    <div class="col-xs-1">
						                   <button type="button" class="btn btn-primary" onclick="search();">查询</button>
						                </div>
				                  	</div>
				                </div><!-- /.box-body -->
                               
                               <div class="box-body table-responsive">
                                   <table id="example" class="table table-striped table-bordered">
							        <thead>
							        <tr>
							        	<th width="8%">主办方编号</th>
							            <th width="7%">账户编号</th>
							            <th width="20%">主办方名称</th>
							            <th width="15%">邮件</th>
							            <th width="10%">手机</th>
							            <th width="10%">电话</th>
							            <th width="10%">联系人</th>
							            <th width="15%">注册时间</th>
							            <th width="5%">操作</th>
							        </tr>
							        </thead>
							        <tbody></tbody>
							        <!-- tbody是必须的 -->
							    </table>
                               </div>
                           </div>
                       </div>
                   </div>
               </section>
           </aside>
           
           <!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			    <div class="modal-dialog">
			        <div class="modal-content">
			            <div class="modal-header">
			                <button type="button" class="close" onclick="closeDiv();"><span aria-hidden="true">&times;</span></button>
			                <h4 class="modal-title" id="myModalLabel">详情</h4>
			            </div>
			            <form id="defaultForm"  class="form-horizontal">
				            <div class="modal-body">
		                        <div class="form-group">
		                         	<label class="col-lg-2 control-label">公司名称</label>
		                            <div class="col-lg-4">
			                    		<input type="text" class="form-control" id="comName" name="comName">
		                            </div>
		                            
		                            <label class="col-lg-2 control-label">联系人</label>
		                            <div class="col-lg-4">
			                    		<input type="text" class="form-control" id="comPerson" name="comPerson">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                         	<label class="col-lg-2 control-label">手机号码</label>
		                            <div class="col-lg-4">
			                    		<input type="text" class="form-control" id="comMobile" name="comMobile">
		                            </div>
		                            
		                            <label class="col-lg-2 control-label">座机号码</label>
		                            <div class="col-lg-4">
			                    		<input type="text" class="form-control" id="comTel" name="comTel">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                            <label class="col-lg-2 control-label">邮箱地址</label>
		                            <div class="col-lg-4">
		                            	<input type="text" class="form-control" id="comEmail" name="comEmail">
		                            </div>
		                            
		                            <label class="col-lg-2 control-label">注册时间</label>
		                            <div class="col-lg-4">
			                    		<input type="text" class="form-control" id="strregtime" name="strregtime">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                        	<label class="col-lg-2 control-label">地址</label>
		                            <div class="col-lg-10">
			                    		<input type="text" class="form-control" id="comAddr" name="comAddr">
		                            </div>
		                        </div>
		                        
		                        
		                        <div class="form-group">
		                            <label class="col-lg-2 control-label">公司简介</label>
		                            <div class="col-lg-10">
		                            	<textarea class="form-control" id="comRemark" name="comRemark" style="width: 400px" ></textarea>
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                        	<label class="col-lg-3 control-label">营业执照编号</label>
		                            <div class="col-lg-9">
			                    		<input type="text" class="form-control" id="comLicenseCode" name="comLicenseCode">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">    
		                            <label class="col-lg-3 control-label">营业执照图片</label>
		                            <div class="col-lg-9">
			                    		<img src="" class="img-thumbnail" id="comLicensePic" name="comLicensePic">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                        	<label class="col-lg-3 control-label">授权书图片</label>
		                            <div class="col-lg-9">
		                            	<img src="" class="img-thumbnail" id="comAuthorizePic" name="comAuthorizePic">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                        	<label class="col-lg-3 control-label">公司logo</label>
		                            <div class="col-lg-9">
		                            <img src="" class="img-thumbnail" id="comLogo" name="comLogo">
		                            </div>
		                        </div>
				            </div>
			            </form>
			            <div class="modal-footer">
			                <button type="button" class="btn btn-default" onclick="closeDiv();">关闭</button>
			            </div>
			        </div>
			    </div>
			</div>
    </body>
</html>