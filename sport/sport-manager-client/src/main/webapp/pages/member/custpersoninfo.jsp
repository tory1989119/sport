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
        <!--定义操作列按钮模板-->
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
                        d.realName = $("#srealName").val();
                        d.startdate = $("#startdate").val();
                        d.enddate = $("#enddate").val();
                        $("#showdig").css("display","block");//遮罩层开启
                    },
                	"dataType": "json",
                    "url": '<%=request.getContextPath()%>/custpersoninfo/getlist.do'
                },
                "serverSide": true,
                "columns": [
                    {"data": "id"},
                    {"data": "acctId"},
                    {"data": "realName"},
                    {"data": "perSex"},
                    {"data": "perAge"},
                    {"data": "perEmail"},
                    {"data": "perTel"},
                    {"data": "perMobile"},
                    {"data": "regTime"},
                    {"data": null},
                   	{"data": "cardId"},
                   	{"data": "perWechat"},
                   	{"data": "perQq"},
                   	{"data": "perHobby"},
                   	{"data": "perAddr"}
                ],
                "columnDefs": [
                    {
                        "targets": 9,
                        "render": function (a, b, c, d) {
                            var html = "<button type=\"button\" class=\"btn btn-primary btn-smg\" onclick=\"detail('" + c.id +"','"+ c.acctId +"','"+ c.realName +"','"+ c.cardId +"','"+ c.perEmail +"','"+ c.perTel +"','"+ c.perMobile +"','"+ c.perSex +"','"+ c.perWechat +"','"+ c.perQq +"','"+ c.perHobby +"','"+ c.perAge +"','"+ c.perAddr +"','"+ c.regTime + "')\">详情</button>";
                            return html;
                        }
                    },
                    {
          	          "targets": 3, //隐藏第六列，从第0列开始   
	          	       "render": function (a, b, c, d) {
	          	        	var name = '';
	          	        	<c:forEach items="${sexlist}" var="sex">
	          	        		var sexid = '${sex.dataid}';	          	        		
	          	        		if(sexid == c.perSex){
	          	        			name = '${sex.dataname}';
	          	        		}
	            			</c:forEach>
	                        return name;
	                    }    
	          	    },
                    {    
	          	          "targets": [ 10,11,12,13,14 ], //隐藏第六列，从第0列开始   
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
        function detail(id,acctId,realName,cardId,perEmail,perTel,perMobile,perSex,perWechat,perQq,perHobby,perAge,perAddr,regTime){
        	$("#realName").val(realName).attr("disabled",true);
        	$("#cardId").val(cardId).attr("disabled",true);
        	$("#perEmail").val(perEmail).attr("disabled",true);
        	$("#perTel").val(perTel).attr("disabled",true);
        	$("#perMobile").val(perMobile).attr("disabled",true);
        	$("#perSex").val(perSex).attr("disabled",true);
        	$("#perWechat").val(perWechat).attr("disabled",true);
        	$("#perQq").val(perQq).attr("disabled",true);
        	$("#perHobby").val(perHobby).attr("disabled",true);
        	$("#perAge").val(perAge).attr("disabled",true);
        	$("#perAddr").val(perAddr).attr("disabled",true);
        	$("#regTime").val(regTime).attr("disabled",true);
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
                   <h1>会员管理</h1>
                   <ol class="breadcrumb">
                       <li><a href="javascript:void(0)"><i class="fa fa-dashboard"></i> 会员管理</a></li>
                       <li >会员管理</li>
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
							                    <input id="startdate" name="startdate" class="form-control" size="16" type="text" value="" readonly placeholder="开始日期">
												<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
												<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							                </div>
							            </div>
							            <div class="col-xs-3">
							                <div id="dend" class="input-group date form_datetime col-md-12">
							                    <input id="enddate" name="enddate" class="form-control" size="16" type="text" value="" readonly placeholder="结束日期">
												<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
												<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
							                </div>
							            </div>
					                    <div class="col-xs-2">
					                      <input type="text" class="form-control" id="sid" name="sid" placeholder="会员编号">
					                    </div>
					                    <div class="col-xs-2">
					                      <input type="text" class="form-control" id="srealName" name="srealName" placeholder="会员名称">
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
							        	<th width="8%">会员编号</th>
							            <th width="7%">账号编号</th>
							            <th width="10%">会员名称</th>
							            <th width="5%">性别</th>
							            <th width="5%">年龄</th>
							            <th width="15%">邮箱</th>
							            <th width="15%">电话</th>
							            <th width="15%">手机</th>
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
		                         	<label class="col-lg-2 control-label">姓名</label>
		                            <div class="col-lg-4">
			                    		<input type="text" class="form-control" id="realName" name="realName">
		                            </div>
		                            
		                            <label class="col-lg-2 control-label">性别</label>
		                            <div class="col-lg-4">
		                            	<select class="form-control" id="perSex" name="perSex">
		                            	<c:forEach items="${sexlist}" var="sex">
					          	        	<option value="${sex.dataid}">${sex.dataname}</option>
				            			</c:forEach>
										</select>
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                            <label class="col-lg-2 control-label">身份证号</label>
		                            <div class="col-lg-10">
			                    		<input type="text" class="form-control" id="cardId" name="cardId">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                        	<label class="col-lg-2 control-label">年龄</label>
		                            <div class="col-lg-4">
			                    		<input type="text" class="form-control" id="perAge" name="perAge">
		                            </div>
		                            
		                            <label class="col-lg-2 control-label">电话</label>
		                            <div class="col-lg-4">
			                    		<input type="text" class="form-control" id="perTel" name="perTel">
		                            </div>
		                        </div>
		                        
		                         <div class="form-group">
		                         	<label class="col-lg-2 control-label">手机</label>
		                            <div class="col-lg-4">
			                    		<input type="text" class="form-control" id="perMobile" name="perMobile">
		                            </div>
		                            
		                            <label class="col-lg-2 control-label">微信号</label>
		                            <div class="col-lg-4">
			                    		<input type="text" class="form-control" id="perWechat" name="perWechat">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                        	<label class="col-lg-2 control-label">QQ号</label>
		                            <div class="col-lg-4">
			                    		<input type="text" class="form-control" id="perQq" name="perQq">
		                            </div>
		                            <label class="col-lg-2 control-label">邮件</label>
		                            <div class="col-lg-4">
			                    		<input type="text" class="form-control" id="perEmail" name="perEmail">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                        	<label class="col-lg-2 control-label">注册时间</label>
		                            <div class="col-lg-4">
			                    		<input type="text" class="form-control" id="regTime" name="regTime">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                        	<label class="col-lg-2 control-label">地址</label>
		                            <div class="col-lg-10">
			                    		<input type="text" class="form-control" id="perAddr" name="perAddr">
		                            </div>
		                        </div>
		                        
		                        <div class="form-group">
		                            <label class="col-lg-2 control-label">爱好</label>
		                            <div class="col-lg-10">
		                            	<textarea class="form-control" id="perHobby" name="perHobby" style="width: 400px" ></textarea>
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