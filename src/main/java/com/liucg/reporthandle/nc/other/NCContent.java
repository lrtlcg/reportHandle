package com.liucg.reporthandle.nc.other;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class NCContent {
    /**
     * MIS中生物质数据同步至NC系统，格式化成xml格式
     *
     * @param json MIS生物质数据
     * @return xml格式
     */
    public String fromatXml(JSONObject json) {
//        JSONObject json = JSON.parseObject(misJson);
        /**
         * 'NCDate', 'RLName', 'RlNCBM', 'BDH', 'ID', 'GYSMC', 'GYSBM', 'JZ', 'CKBM',
         * 	'KWBM', 'WSDJ', 'HSDJ', 'SL', 'HSJE', 'WSJE', 'ZZ', 'CJR', 'ZDR', 'SM', 'CGDDH', 'DDTZJ', 'DDHZJ','SE'
         */
        String NCDate = json.getString("NCDate"); // NC 日期
        String RLName = json.getString("RLName"); // 燃料名称
        String RlNCBM = json.getString("RlNCBM"); // 燃料NC编码
        String BDH = json.getString("BDH"); //磅单号
        String ID = json.getString("ID"); //唯一编码
        String GYSMC = json.getString("GYSMC"); //供应商名称
        String GYSBM = json.getString("GYSBM"); //供应商编码
        String JZ = json.getString("JZ"); //净重
        String CKBM = json.getString("CKBM"); //库存编码
        String KWBM = json.getString("KWBM"); //库位编码
        String WSDJ = json.getString("WSDJ"); //未税单价
        String HSDJ = json.getString("HSDJ"); //含税单价
        String SL = json.getString("SL"); //税率

        String HSJE = json.getString("HSJE"); //含税金额
        String WSJE = json.getString("WSJE"); //未税金额
        float wsje = changeSl2Ws(HSJE, WSJE, SL); // 未税金额
        float wsdj = changeSl2Ws(HSDJ, WSDJ, SL); // 未税单价
        float hsje = changeSl2Hs(HSJE, WSJE, SL); //含税金额
        float hsdj = changeSl2Hs(HSDJ, WSDJ, SL); // 含税单价
        //        String SE = json.getString("SE"); //税额
        float se = hsje - wsje;//税额(计算出来的)
        se=Math.round(se*100)/100.00f;
        String SE = Float.toString(se);//税额(计算出来的)
        WSJE = Float.toString(wsje); //未税金额(计算出来的)
        WSDJ = Float.toString(wsdj); //未税单价(计算出来的)
        HSJE = Float.toString(hsje); // 含税金额
        HSDJ = Float.toString(hsdj); // 含税单价
        String ZZ = json.getString("ZZ"); //组织结构
        String CJR = json.getString("CJR"); //创建人
        String ZDR = json.getString("ZDR"); //制单人
        String SM = json.getString("SM"); //税码
        String CGDDH = json.getString("CGDDH"); //采购单编号
        String DDTZJ = json.getString("DDTZJ"); //订单头主键
        String DDHZJ = json.getString("DDHZJ"); //订单行主键
        String HH = json.getString("HH");//订单行号
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding='UTF-8'?>\n" +
                "<ufinterface account=\"20231109\" billtype=\"45\" filename=\"\" groupcode=\"global\" isexchange=\"Y\" replace=\"Y\" roottag=\"bill\" sender=\"04\">\n" +
                "    <bill id=\"\">\n" +
                "        <billhead>\n" +
                "            <!--集团,最大长度为20,类型为:String-->\n" +
                "            <pk_group>0</pk_group>\n" +
                "            <!--按实际，库存组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <pk_org>" + ZZ + "</pk_org>\n" +
                "            <cgeneralbid>\n" +
                "                <item>\n" +
                "                    <!--必填 固定0 集团,最大长度为20,类型为:String-->\n" +
                "                    <pk_group>0</pk_group>\n" +
                "                    <!--必填，实际值 公司编码,最大长度为20,类型为:String-->\n" +
                "                    <corpoid>" + ZZ + "</corpoid>\n" +
                "                    <!--必填 行号,最大长度为20,类型为:String-->\n" +
                "                    <crowno>1</crowno>                    \n" +
                "                    <!--必填 物料编码OA同步推送MIS,最大长度为20,类型为:String-->\n" +
                "                    <cmaterialoid>" + RlNCBM + "</cmaterialoid>\n" +
                "                    <!--必填 物料版本,最大长度为20,类型为:String-->\n" +
                "                    <cmaterialvid>" + RlNCBM + "</cmaterialvid>                    \n" +
                "                    <!--必填 ，固定值，主单位,最大长度为20,类型为:String-->\n" +
                "                    <cunitid>mt</cunitid>\n" +
                "                    <!--必填，固定值 单位,最大长度为20,类型为:String-->\n" +
                "                    <castunitid>mt</castunitid>                    \n" +
                "                    <!--必填，固定值， 换算率,最大长度为60,类型为:String-->\n" +
                "                    <vchangerate>1.00/1.00</vchangerate>\n" +
                "                    <!--必填 ，实际值，每车重量，应收数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nshouldassistnum>" + JZ + "</nshouldassistnum>\n" +
                "                    <!--必填 实际值，每车重量，应收主数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nshouldnum>" + JZ + "</nshouldnum>\n" +
                "                    <!--必填 实际值，每车重量，实收数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nassistnum>" + JZ + "</nassistnum>\n" +
                "                    <!--必填 实际值，每车重量，实收主数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nnum>" + JZ + "</nnum>           \n" +
                "                    <!--单价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ncostprice>\n" +
                "                    </ncostprice>\n" +
                "                    <!--金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ncostmny>\n" +
                "                    </ncostmny>\n" +
                "                    <!--计划单价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nplannedprice>\n" +
                "                    </nplannedprice>\n" +
                "                    <!--计划金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nplannedmny>\n" +
                "                    </nplannedmny>\n" +
                "                    <!--必填 货位编码,OA同步推送MIS，最大长度为20,类型为:String-->\n" +
                "                    <clocationid>\n" + KWBM + "</clocationid>\n" +
                "                    <!--必填 ，实际入库日期,注意结账后当月改下月1号，最大长度为19,类型为:UFDate-->\n" +
                "                    <dbizdate>" + NCDate + "</dbizdate>\n" +
                "                    <!--项目,最大长度为20,类型为:String-->\n" +
                "                    <cprojectid>\n" +
                "                    </cprojectid>\n" +
                "                    <!--对应入库单表头主键-->\n" +
                "                    <ccorrespondhid>\n" +
                "                    </ccorrespondhid>\n" +
                "                    <!--对应入库单据表体主键-->\n" +
                "                    <ccorrespondbid></ccorrespondbid>\n" +
                "                    <!--必填，采购订单表头主键，OA推送MIS，来源单据表头主键-->\n" +
                "                    <csourcebillhid>" + DDTZJ + "</csourcebillhid>\n" +
                "                    <!--必填，采购订单表体行主键，OA推送MIS，来源单据表体行主键-->\n" +
                "                    <csourcebillbid>" + DDHZJ + "</csourcebillbid>\n" +
                "                    <!--必填 采购订单号，来源单据号,最大长度为40,类型为:String-->\n" +
                "                    <vsourcebillcode>" + CGDDH + "</vsourcebillcode>\n" +
                "                    <!--必填 采购订单行号，来源单据行号,最大长度为20,类型为:String-->\n" +
                "                    <vsourcerowno>" + HH + "</vsourcerowno>    \n" +
                "                    <!--必填，采购订单表头主键，源头单据表头主键,类型为:char-->\n" +
                "                    <cfirstbillhid>" + DDTZJ + "</cfirstbillhid>\n" +
                "                    <!--必填，采购订单表头主键，源头单据表体主键-->\n" +
                "                    <cfirstbillbid>" + DDHZJ + "</cfirstbillbid>\n" +
                "                    <!--必填 采购订单号,最大长度为40,类型为:String-->\n" +
                "                    <vfirstbillcode>" + CGDDH + "</vfirstbillcode>\n" +
                "                    <!--必填 采购订单行号,最大长度为20,类型为:String-->\n" +
                "                    <vfirstrowno>" + HH + "</vfirstrowno>\n" +
                "                    <!--必填 ，固定21 来源单据类型,最大长度为20,类型为:String-->\n" +
                "                    <csourcetype>21</csourcetype>\n" +
                "                    <!--必填 ，固定21-01来源单据交易类型,最大长度为20,类型为:String-->\n" +
                "                    <csourcetranstype>21-01</csourcetranstype>\n" +
                "                     <!--必填 ，固定21 源头单据类型,最大长度为20,类型为:String-->\n" +
                "                    <cfirsttype>21</cfirsttype>\n" +
                "                    <!--必填 ，固定21-01 源头单据交易类型,最大长度为20,类型为:String-->\n" +
                "                    <cfirsttranstype>21-01</cfirsttranstype>\n" +
                "                    <!--必填，供应商编码,最大长度为20,类型为:String-->\n" +
                "                    <cvendorid>" + GYSBM + "</cvendorid>\n" +
                "                    <!--必填，固定值45-01 出入库类型,最大长度为20,类型为:String-->\n" +
                "                    <cbodytranstypecode>45-01</cbodytranstypecode>\n" +
                "                    <!--必填 ，实际值，组织编码库存组织最新版本,最大长度为20,类型为:String-->\n" +
                "                    <pk_org>" + ZZ + "</pk_org>\n" +
                "                    <!--必填 ，实际值，组织编码库存组织,最大长度为20,类型为:String-->\n" +
                "                    <pk_org_v>" + ZZ + "</pk_org_v>\n" +
                "                    <!--必填 ，OA同步推送MIS，仓库编码，库存仓库,最大长度为20,类型为:String-->\n" +
                "                    <cbodywarehouseid>" + CKBM + "</cbodywarehouseid>\n" +
                "                    <!--必填 需求库存组织最新版本,最大长度为20,类型为:String-->\n" +
                "                    <creqstoorgoid>" + ZZ + "</creqstoorgoid>\n" +
                "                    <!--必填 需求库存组织,最大长度为20,类型为:String-->\n" +
                "                    <creqstoorgvid>" + ZZ + "</creqstoorgvid>\n" +
                "                    <!--必填 币种,最大长度为20,类型为:String-->\n" +
                "                    <corigcurrencyid>CNY</corigcurrencyid>\n" +
                "                    <!--必填 折本汇率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nchangestdrate>1.00000000</nchangestdrate>\n" +
                "                    <!--必填 本位币,最大长度为20,类型为:String-->\n" +
                "                    <ccurrencyid>CNY</ccurrencyid>\n" +

                "<!--主无税单价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norigprice>" + WSDJ + "</norigprice>\n" +
                "                    <!--主本币无税单价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nprice>" + WSDJ + "</nprice>\n" +
                "                    <!--无税单价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtorigprice>" + WSDJ + "</nqtorigprice>\n" +
                "                    <!--本币无税单价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtprice>" + WSDJ + "</nqtprice>\n" +
                "                    <!--本币含税单价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqttaxprice>" + HSDJ + "</nqttaxprice>\n" +
                "                    <!--含税单价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtorigtaxprice>" + HSDJ + "</nqtorigtaxprice>\n" +
                "                    <!--主本币含税单价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntaxprice>" + HSDJ + "</ntaxprice>\n" +
                "                    <!--主含税单价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norigtaxprice>" + HSDJ + "</norigtaxprice>" +

                "                    <!--必填 主无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norignetprice>" + WSDJ + "</norignetprice>\n" +
                "                    <!--必填 主无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norigtaxnetprice>" + WSDJ + "</norigtaxnetprice>\n" +
                "                    <!--必填 主本币无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nnetprice>" + WSDJ + "</nnetprice>\n" +
                "                    <!--必填 无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtorignetprice>" + WSDJ + "</nqtorignetprice>\n" +
                "                    <!--本币无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtnetprice>" + WSDJ + "</nqtnetprice>            \n" +
                "                    <!--含税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtorigtaxnetprice>" + HSDJ + "</nqtorigtaxnetprice>\n" +
                "                    <!--必填 主本币含税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntaxnetprice>" + HSDJ + "</ntaxnetprice>\n" +
                "                    <!--本币含税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqttaxnetprice>" + HSDJ + "</nqttaxnetprice>\n" +
                "                    <!--必填，本币无税合计,最大长度为28,类型为:UFDouble-->                    \n" +
                "                    <norigmny>" + WSJE + "</norigmny>\n" +
                "                    <!--必填，价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norigtaxmny>" + HSJE + "</norigtaxmny>\n" +
                "                    <!--税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norigtax>\n" + SE + "</norigtax>\n" +
                "                    <!--本币无税金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nmny>" + WSJE + "</nmny>\n" +
                "                    <!--本币价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntaxmny>" + HSJE + "</ntaxmny>\n" +
                "                    <!--本币税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntax>" + SE + "</ntax>\n" +
                "                    <!--必填，实际值，税率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntaxrate>" + SL + "</ntaxrate>\n" +
                "                    <!--固定，扣税类别,最大长度为0,类型为:Integer-->\n" +
                "                    <ftaxtypeflag>1</ftaxtypeflag>\n" +
                "                    <!--空，累计开票主数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nsignnum></nsignnum>\n" +
                "                    <!--固定，全局本位币,最大长度为20,类型为:String-->\n" +
                "                    <cglobalcurrencyid>CNY</cglobalcurrencyid>\n" +
                "                    <!--全局本币无税金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nglobalmny>\n" + WSJE + "</nglobalmny>\n" +
                "                    <!--全局本币价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nglobaltaxmny>\n" + HSJE + "</nglobaltaxmny>\n" +
                "                    <!--全局本位币汇率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nglobalexchgrate>\n" +
                "                    </nglobalexchgrate>\n" +
                "                    <!--集团本位币,最大长度为20,类型为:String-->\n" +
                "                    <cgroupcurrencyid>\n" +
                "                    </cgroupcurrencyid>\n" +
                "                    <!--集团本币无税金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ngroupmny>\n" + WSJE + "</ngroupmny>\n" +
                "                    <!--集团本币价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ngrouptaxmny>\n" + HSJE + "</ngrouptaxmny>\n" +
                "                    <!--集团本位币汇率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ngroupexchgrate>\n" +
                "                    </ngroupexchgrate>\n" +
                "                    <!--已生成设备卡片,最大长度为1,类型为:UFBoolean-->\n" +
                "                    <bassetcard>N</bassetcard>\n" +
                "                    <!--已转固,最大长度为1,类型为:UFBoolean-->\n" +
                "                    <bfixedasset>N</bfixedasset>\n" +
                "                    <!--来源物料编码,最大长度为20,类型为:String-->\n" +
                "                    <csrcmaterialoid>" + RlNCBM + "</csrcmaterialoid>\n" +
                "                    <!--来源物料版本,最大长度为20,类型为:String-->\n" +
                "                    <csrcmaterialvid>" + RlNCBM + "</csrcmaterialvid>\n" +
                "                    <!--项目任务,最大长度为20,类型为:String-->\n" +
                "                    <cprojecttaskid>\n" +
                "                    </cprojecttaskid>\n" +
                "                    <!--必填，OA推送MIS，税码,最大长度为20,类型为:String-->\n" +
                "                    <ctaxcodeid>" + SM + "</ctaxcodeid>\n" +
                "                    <!--不可抵扣税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nnosubtax>\n" +
                "                    </nnosubtax>\n" +
                "                    <!--计税税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ncaltaxmny>"+WSJE+"</ncaltaxmny>\n" +
                "                    <!--逆向征税标志,最大长度为1,类型为:UFBoolean-->\n" +
                "                    <bopptaxflag>N</bopptaxflag>\n" +
                "                    <!--计成本金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ncalcostmny>"+WSJE+"</ncalcostmny>\n" +
                "                    <!--磅单号-->\n" +
                "                    <vbdef12>" + BDH + "</vbdef12>\n" +
                "                    <!--MIS唯一编码-->\n" +
                "                    <vbdef13>" + ID + "</vbdef13>\n" +
                "                </item>\n" +
                "            </cgeneralbid>\n" +
                "            <!--按实际，公司最新版本,最大长度为20,类型为:String-->\n" +
                "            <corpoid>" + ZZ + "</corpoid>\n" +
                "            <!--按实际，公司,最大长度为20,类型为:String-->\n" +
                "            <corpvid>" + ZZ + "</corpvid>\n" +
                "            <!--固定，业务流程,最大长度为20,类型为:String-->\n" +
                "            <cbiztype>PU01</cbiztype>\n" +
                "            <!--空，单据号,最大长度为40,类型为:String-->\n" +
                "            <vbillcode></vbillcode>\n" +
                "            <!--按实际，仓库,最大长度为20,类型为:String-->\n" +
                "            <cwarehouseid>" + CKBM + "</cwarehouseid>\n" +
                "            <!--按实际，单据日期,最大长度为19,类型为:UFDate-->\n" +
                "            <dbilldate>" + NCDate + "</dbilldate>\n" +
                "            <!--固定，出入库类型编码,最大长度为20,类型为:String-->\n" +
                "            <vtrantypecode>45-01</vtrantypecode>\n" +
                "            <!--MIS固定值,最大长度为20,类型为:String-->\n" +
                "            <cwhsmanagerid>03150</cwhsmanagerid>\n" +
                "            <!--总数量,最大长度为28,类型为:UFDouble-->\n" +
                "            <ntotalnum>" + JZ + "</ntotalnum>\n" +
                "            <!--固定，采购退库,最大长度为1,类型为:UFBoolean-->\n" +
                "            <freplenishflag>N</freplenishflag>\n" +
                "             <!--备注,最大长度为181,类型为:String-->\n" +
                "            <vnote>按实际到货入库</vnote>\n" +
                "            <!--固定值2，单据状态,最大长度为0,类型为:Integer-->\n" +
                "            <fbillflag>2</fbillflag>\n" +
                "            <!--必填，创建人,最大长度为20,类型为:String-->\n" +
                "            <creator>" + CJR + "</creator>\n" +
                "            <!--必填，制单人,最大长度为20,类型为:String-->\n" +
                "            <billmaker>" + ZDR + "</billmaker>\n" +
                "            <!--必填，制单时间，推送日期，最大长度为19,类型为:UFDateTime-->\n" +
                "            <creationtime>" + dft.format(System.currentTimeMillis()) + "</creationtime>\n" +
                "            <!--默认，空，签字人,最大长度为20,类型为:String-->\n" +
                "            <approver></approver>\n" +
                "            <!--默认，空，签字时间,最大长度为19,类型为:UFDateTime-->\n" +
                "            <taudittime></taudittime>\n" +
                "            <!--实际值，应付财务组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <cpayfinorgoid>" + ZZ + "</cpayfinorgoid>\n" +
                "            <!--实际值，应付财务组织,最大长度为20,类型为:String-->\n" +
                "            <cpayfinorgvid>" + ZZ + "</cpayfinorgvid>\n" +
                "            <!--实际值，结算财务组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <cfanaceorgoid>" + ZZ + "</cfanaceorgoid>\n" +
                "            <!--实际值，结算财务组织,最大长度为20,类型为:String-->\n" +
                "            <cfanaceorgvid>" + ZZ + "</cfanaceorgvid>\n" +
                "            <!--实际值，采购组织,最大长度为20,类型为:String-->\n" +
                "            <cpurorgoid>" + ZZ + "</cpurorgoid>\n" +
                "            <!--实际值，采购组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <cpurorgvid>" + ZZ + "</cpurorgvid>\n" +
                "            <!--必填，供应商编码,最大长度为20,类型为:String-->\n" +
                "            <cvendorid>" + GYSBM + "</cvendorid>\n" +
                "            <!--固定值，出入库类型,最大长度为20,类型为:String-->\n" +
                "            <ctrantypeid>45-01</ctrantypeid>\n" +
                "            <!--固定值，发货国,最大长度为20,类型为:String-->\n" +
                "            <csendcountryid>CN</csendcountryid>\n" +
                "            <!--固定值，收货国,最大长度为20,类型为:String-->\n" +
                "            <crececountryid>CN</crececountryid>\n" +
                "            <!--固定值，报税国,最大长度为20,类型为:String-->\n" +
                "            <ctaxcountryid>CN</ctaxcountryid>\n" +
                "        </billhead>\n" +
                "    </bill>\n" +
                "</ufinterface>\n");
        return sb.toString().replaceAll("<br>", "").replaceAll("</br>", "").replaceAll("&nbsp;", "").replaceAll("&",
                "&amp;");
    }

    /**
     * 数据转换成未税
     *
     * @param hs 含税
     * @param ws 未税
     * @param sl 税率
     * @return 未税数据
     */
    private float changeSl2Ws(String hs, String ws, String sl) {
        float result = 0.0f;
        float sl1 = 0.0f;
        if (StringUtils.isNotEmpty(sl)) {//税率取值
            sl1 = Float.parseFloat(sl);
        }
        if ((StringUtils.isEmpty(hs) || Float.parseFloat(hs)==0.00) && StringUtils.isNotEmpty(ws)) {
            float hs1 = Math.round(Float.parseFloat(ws) * (1 + (sl1 / 100)) * 100) /100.00f;//含税=未税*税率
            result = Math.round((hs1 / (1 + (sl1 / 100))) * 100) /100.00f;
        } else {
            float hs1 = Float.parseFloat(hs);
            result = Math.round((hs1 / (1 + (sl1 / 100))) * 100) /100.00f; //转换成未税
        }
        return result;
    }

    /**
     * 数据转成含税的
     *
     * @param hs
     * @param ws
     * @param sl
     * @return  含税数据
     */
    private float changeSl2Hs(String hs, String ws, String sl) {
        float result = 0.0f;
        float sl1 = 0.0f;
        if (StringUtils.isNotEmpty(sl)) {//税率取值
            sl1 = Float.parseFloat(sl);
        }
        if ((StringUtils.isEmpty(hs) || Float.parseFloat(hs)==0.00)  && StringUtils.isNotEmpty(ws)) {
            result = Math.round((Float.parseFloat(ws) * (1 + (sl1 / 100))) * 100) /100.00f; //含税为空，含税=未税*税率
        } else {
            result = Float.parseFloat(hs); //含税不为空
        }
        return result;
    }

}
