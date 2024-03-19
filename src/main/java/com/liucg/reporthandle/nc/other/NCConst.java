package com.liucg.reporthandle.nc.other;

public class NCConst {

    //	NC正式环境start
//	public static final String ws_url = "http://192.168.31.9:8080/service/XChangeServlet?account=01&groupcode=0";
	public static final String ws_url = "http://192.168.31.9:8080/service/XChangeServlet?account=01&groupcode=0&operator=0001A210000000000JEB";
//	NC测试环境start
    //ws地址
//    public static final String ws_url = "http://192.168.31.29:8080/service/XChangeServlet?account=nc6504&groupcode=0&operator=0001A210000000000JEB";


    //	NC测试环境end
    public static final String[] title = {"费用报销251","差旅费报销261","借款报销271","GI-3.5供方信息录入"};
    public static final String[] gf_title = {"供应商新增","供应商评价","供应商复评","一次性供方再次使用申请","供方信息变更申请"};

    public static final String ms_gs_str = ",23,0,1,6,4,2,5,19,3,12,22,25,26,";
    public static final String no_call_to_nc = "no_call_to_nc";
    public static final String no_call = "9";

    //部门类型费用
    public static final String type_01 = "01";
    //项目类型费用
    public static final String type_03 = "03";

    //调用NC接口返回结果 1-成功 0-失败
    public static final String flag_success = "1";
    public static final String flag_fail = "0";
    public static final String flag_other = "3";
    public static final String flag_other_mess = "无需调用接口";
    //是否调用NC接口 1-不调用 0-调用
    public static final String flag_sfdyjk_no = "1";
    public static final String flag_sfdyjk_yes = "0";
    //数据库sql是否查询到数据
    public static final String flag_data_yes = "y";
    public static final String flag_data_no = "n";

    //NC调用接口的xml文件中固定值 start
    public static final String nc_jkd_jk = "jk";
    public static final String nc_jkd_djlxbm = "2631";
    public static final String nc_pk_group = "0";
    public static final String nc_djdl = "bx";
    public static final String nc_djlxbm = "264X-Cxx-01";
    public static final String nc_djzt = "0";
    public static final String nc_paytarget = "员工";

    public static final String r_sendresult = "sendresult";
    public static final String r_resultdescription = "resultdescription";
    public static final String r_resultcode = "resultcode";
    public static final String r_content = "content";
    //NC调用接口的xml文件中固定值 end
    //2019-1-3 增加单据默认创建人 start
    public static final String sunpower = "sunpower";
    //2019-1-3 增加单据默认创建人 end

}
