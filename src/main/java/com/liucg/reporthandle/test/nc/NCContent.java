package com.liucg.reporthandle.test.nc;

public class NCContent {

    public String formatXml2() {
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding='UTF-8'?>\n" +
                "<ufinterface account=\"20231109\" billtype=\"45\" filename=\"\" groupcode=\"global\" isexchange=\"Y\" replace=\"Y\" roottag=\"bill\" sender=\"04\">\n" +
                "    <bill id=\"\">\n" +
                "        <billhead>\n" +
                "            <!--集团,最大长度为20,类型为:String-->\n" +
                "            <pk_group>0</pk_group>\n" +
                "            <!--按实际，库存组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <pk_org>23</pk_org>\n" +
                "\n" +
                "            <cgeneralbid>\n" +
                "                <item>\n" +
                "                    <!--必填 固定0 集团,最大长度为20,类型为:String-->\n" +
                "                    <pk_group>0</pk_group>\n" +
                "                    <!--必填，实际值 公司编码,最大长度为20,类型为:String-->\n" +
                "                    <corpoid>23</corpoid>\n" +
                "                    <!--必填 行号,最大长度为20,类型为:String-->\n" +
                "                    <crowno>10</crowno>                    \n" +
                "                    <!--必填 物料编码OA同步推送MIS,最大长度为20,类型为:String-->\n" +
                "                    <cmaterialoid>0-070401-0002</cmaterialoid>\n" +
                "                    <!--必填 物料版本,最大长度为20,类型为:String-->\n" +
                "                    <cmaterialvid>0-070401-0007</cmaterialvid>                    \n" +
                "                    <!--必填 ，固定值，主单位,最大长度为20,类型为:String-->\n" +
                "                    <cunitid>mt</cunitid>\n" +
                "                    <!--必填，固定值 单位,最大长度为20,类型为:String-->\n" +
                "                    <castunitid>mt</castunitid>                    \n" +
                "                    <!--必填，固定值， 换算率,最大长度为60,类型为:String-->\n" +
                "                    <vchangerate>1.00/1.00</vchangerate>                  \n" +
                "                    <!--必填 ，实际值，每车重量，应收数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nshouldassistnum>60</nshouldassistnum>\n" +
                "                    <!--必填 实际值，每车重量，应收主数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nshouldnum>60</nshouldnum>\n" +
                "                    <!--必填 实际值，每车重量，实收数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nassistnum>59.1</nassistnum>\n" +
                "                    <!--必填 实际值，每车重量，实收主数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nnum>59.1</nnum>                \n" +
                "                     <!--单价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ncostprice>\n" +
                "                    </ncostprice>\n" +
                "                    <!--金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ncostmny>\n" +
                "                    </ncostmny>                \n" +
                "                    <!--计划单价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nplannedprice>\n" +
                "                    </nplannedprice>\n" +
                "                    <!--计划金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nplannedmny>\n" +
                "                    </nplannedmny>                   \n" +
                "                    <!--必填 货位编码,OA同步推送MIS，最大长度为20,类型为:String-->\n" +
                "                    <clocationid>\n" +
                "                    </clocationid>                 \n" +
                "                    <!--必填 ，实际入库日期,注意结账后当月改下月1号，最大长度为19,类型为:UFDate-->\n" +
                "                    <dbizdate>2024-01-19 </dbizdate>                   \n" +
                "                    <!--项目,最大长度为20,类型为:String-->\n" +
                "                    <cprojectid>\n" +
                "                    </cprojectid>\n" +
                "                    <!--对应入库单表头主键-->\n" +
                "                    <ccorrespondhid>\n" +
                "                    </ccorrespondhid>\n" +
                "                    <!--对应入库单据表体主键-->\n" +
                "                    <ccorrespondbid>\n" +
                "                    </ccorrespondbid>              \n" +
                "                    <!--必填，采购订单表头主键，OA推送MIS，来源单据表头主键-->\n" +
                "                    <csourcebillhid>1001A4100000003I6P9C</csourcebillhid>\n" +
                "                    <!--必填，采购订单表体行主键，OA推送MIS，来源单据表体行主键-->\n" +
                "                    <csourcebillbid>1001A4100000003I6P9D</csourcebillbid>\n" +
                "                    <!--必填 采购订单号，来源单据号,最大长度为40,类型为:String-->\n" +
                "                    <vsourcebillcode>1111122222</vsourcebillcode>\n" +
                "                    <!--必填 采购订单行号，来源单据行号,最大长度为20,类型为:String-->\n" +
                "                    <vsourcerowno>10</vsourcerowno>    \n" +
                "                    <!--必填，采购订单表头主键，源头单据表头主键,类型为:char-->\n" +
                "                    <cfirstbillhid>1001A4100000003I6P9C</cfirstbillhid>\n" +
                "                    <!--必填，采购订单表头主键，源头单据表体主键-->\n" +
                "                    <cfirstbillbid>1001A4100000003I6P9D</cfirstbillbid>\n" +
                "                    <!--必填 采购订单号,最大长度为40,类型为:String-->\n" +
                "                    <vfirstbillcode></vfirstbillcode>\n" +
                "                    <!--必填 采购订单行号,最大长度为20,类型为:String-->\n" +
                "                    <vfirstrowno>10</vfirstrowno>\n" +
                "                    <!--必填 ，固定21 来源单据类型,最大长度为20,类型为:String-->\n" +
                "                    <csourcetype>21</csourcetype>\n" +
                "                    <!--必填 ，固定21-01来源单据交易类型,最大长度为20,类型为:String-->\n" +
                "                    <csourcetranstype>21-01</csourcetranstype>\n" +
                "                     <!--必填 ，固定21 源头单据类型,最大长度为20,类型为:String-->\n" +
                "                    <cfirsttype>21</cfirsttype>\n" +
                "                    <!--必填 ，固定21-01 源头单据交易类型,最大长度为20,类型为:String-->\n" +
                "                    <cfirsttranstype>21-01</cfirsttranstype>\n" +
                "                    <!--必填，供应商编码,最大长度为20,类型为:String-->\n" +
                "                    <cvendorid>91120113MA05P7LA29</cvendorid>\n" +
                "                    <!--必填，固定值45-01 出入库类型,最大长度为20,类型为:String-->\n" +
                "                    <cbodytranstypecode>45-01</cbodytranstypecode>\n" +
                "                    <!--必填 ，实际值，组织编码库存组织最新版本,最大长度为20,类型为:String-->\n" +
                "                    <pk_org>23</pk_org>\n" +
                "                    <!--必填 ，实际值，组织编码库存组织,最大长度为20,类型为:String-->\n" +
                "                    <pk_org_v>23</pk_org_v>\n" +
                "                    <!--必填 ，OA同步推送MIS，仓库编码，库存仓库,最大长度为20,类型为:String-->\n" +
                "                    <cbodywarehouseid>1002</cbodywarehouseid>\n" +
                "                    <!--必填 需求库存组织最新版本,最大长度为20,类型为:String-->\n" +
                "                    <creqstoorgoid>23</creqstoorgoid>\n" +
                "                    <!--必填 需求库存组织,最大长度为20,类型为:String-->\n" +
                "                    <creqstoorgvid>23</creqstoorgvid>\n" +
                "                    <!--必填 币种,最大长度为20,类型为:String-->\n" +
                "                    <corigcurrencyid>CNY</corigcurrencyid>\n" +
                "                    <!--必填 折本汇率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nchangestdrate>1.00000000</nchangestdrate>\n" +
                "                    <!--必填 本位币,最大长度为20,类型为:String-->\n" +
                "                    <ccurrencyid>CNY</ccurrencyid>\n" +
                "                    <!--必填 主无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norignetprice>144.2478</norignetprice>\n" +
                "                    <!--必填 主无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norigtaxnetprice>163</norigtaxnetprice>\n" +
                "                    <!--必填 主本币无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nnetprice>144.2478</nnetprice>\n" +
                "                    <!--必填 无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtorignetprice>144.2478</nqtorignetprice>\n" +
                "                    <!--本币无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtnetprice>144.2478</nqtnetprice>            \n" +
                "                    <!--含税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtorigtaxnetprice>163</nqtorigtaxnetprice>\n" +
                "                    <!--必填 主本币含税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntaxnetprice>163</ntaxnetprice>\n" +
                "                    <!--本币含税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqttaxnetprice>163</nqttaxnetprice>\n" +
                "                    <!--必填，本币无税合计,最大长度为28,类型为:UFDouble-->                    \n" +
                "                    <norigmny>8525.04</norigmny>\n" +
                "                    <!--必填，价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norigtaxmny>9633.3</norigtaxmny>\n" +
                "                    <!--税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norigtax>\n" +
                "                    </norigtax>\n" +
                "                    <!--本币无税金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nmny>8525.04</nmny>\n" +
                "                    <!--本币价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntaxmny>9633.3</ntaxmny>\n" +
                "                    <!--本币税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntax>1108.26</ntax>\n" +
                "                   <!--必填，实际值，税率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntaxrate>13</ntaxrate>\n" +
                "                    <!--固定，扣税类别,最大长度为0,类型为:Integer-->\n" +
                "                    <ftaxtypeflag>1</ftaxtypeflag>\n" +
                "                    <!--空，累计开票主数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nsignnum></nsignnum>\n" +
                "                    <!--固定，全局本位币,最大长度为20,类型为:String-->\n" +
                "                    <cglobalcurrencyid>CNY</cglobalcurrencyid>\n" +
                "                    <!--全局本币无税金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nglobalmny>\n" +
                "                    </nglobalmny>\n" +
                "                    <!--全局本币价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nglobaltaxmny>\n" +
                "                    </nglobaltaxmny>\n" +
                "                    <!--全局本位币汇率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nglobalexchgrate>\n" +
                "                    </nglobalexchgrate>\n" +
                "                    <!--集团本位币,最大长度为20,类型为:String-->\n" +
                "                    <cgroupcurrencyid>\n" +
                "                    </cgroupcurrencyid>\n" +
                "                    <!--集团本币无税金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ngroupmny>\n" +
                "                    </ngroupmny>\n" +
                "                    <!--集团本币价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ngrouptaxmny>\n" +
                "                    </ngrouptaxmny>\n" +
                "                    <!--集团本位币汇率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ngroupexchgrate>\n" +
                "                    </ngroupexchgrate>\n" +
                "                   <!--已生成设备卡片,最大长度为1,类型为:UFBoolean-->\n" +
                "                    <bassetcard>N</bassetcard>\n" +
                "                    <!--已转固,最大长度为1,类型为:UFBoolean-->\n" +
                "                    <bfixedasset>N</bfixedasset>\n" +
                "                   <!--来源物料编码,最大长度为20,类型为:String-->\n" +
                "                    <csrcmaterialoid>0-070401-0002</csrcmaterialoid>\n" +
                "                    <!--来源物料版本,最大长度为20,类型为:String-->\n" +
                "                    <csrcmaterialvid>0-070401-0002</csrcmaterialvid>\n" +
                "                    <!--项目任务,最大长度为20,类型为:String-->\n" +
                "                    <cprojecttaskid>\n" +
                "                    </cprojecttaskid>\n" +
                "                    <!--必填，OA推送MIS，税码,最大长度为20,类型为:String-->\n" +
                "                    <ctaxcodeid>CN01</ctaxcodeid>\n" +
                "                    <!--不可抵扣税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nnosubtax>\n" +
                "                    </nnosubtax>\n" +
                "                    <!--计税税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ncaltaxmny>8525.04</ncaltaxmny>\n" +
                "                   <!--逆向征税标志,最大长度为1,类型为:UFBoolean-->\n" +
                "                    <bopptaxflag>N</bopptaxflag>\n" +
                "                    <!--计成本金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ncalcostmny>8525.04</ncalcostmny>\n" +
                "                </item>\n" +
                "            </cgeneralbid>\n" +
                "            <!--按实际，公司最新版本,最大长度为20,类型为:String-->\n" +
                "            <corpoid>23</corpoid>\n" +
                "            <!--按实际，公司,最大长度为20,类型为:String-->\n" +
                "            <corpvid>23</corpvid>\n" +
                "            <!--固定，业务流程,最大长度为20,类型为:String-->\n" +
                "            <cbiztype>PU01</cbiztype>\n" +
                "            <!--空，单据号,最大长度为40,类型为:String-->\n" +
                "            <vbillcode></vbillcode>\n" +
                "            <!--按实际，仓库,最大长度为20,类型为:String-->\n" +
                "            <cwarehouseid>1002</cwarehouseid>\n" +
                "            <!--按实际，单据日期,最大长度为19,类型为:UFDate-->\n" +
                "            <dbilldate>2024-01-19 </dbilldate>\n" +
                "            <!--固定，出入库类型编码,最大长度为20,类型为:String-->\n" +
                "            <vtrantypecode>45-01</vtrantypecode>\n" +
                "            <!--MIS固定值,最大长度为20,类型为:String-->\n" +
                "            <cwhsmanagerid>03150</cwhsmanagerid>\n" +
                "            <!--总数量,最大长度为28,类型为:UFDouble-->\n" +
                "            <ntotalnum>137.75</ntotalnum>\n" +
                "            <!--固定，采购退库,最大长度为1,类型为:UFBoolean-->\n" +
                "            <freplenishflag>N</freplenishflag>\n" +
                "             <!--备注,最大长度为181,类型为:String-->\n" +
                "            <vnote>按实际到货入库</vnote>\n" +
                "            <!--固定值2，单据状态,最大长度为0,类型为:Integer-->\n" +
                "            <fbillflag>2</fbillflag>\n" +
                "            <!--必填，创建人,最大长度为20,类型为:String-->\n" +
                "            <creator>03150</creator>\n" +
                "            <!--必填，制单人,最大长度为20,类型为:String-->\n" +
                "            <billmaker>03150</billmaker>\n" +
                "            <!--必填，制单时间，推送日期，最大长度为19,类型为:UFDateTime-->\n" +
                "            <creationtime>2022-12-28 16:36:15</creationtime>\n" +
                "            <!--默认，空，签字人,最大长度为20,类型为:String-->\n" +
                "            <approver></approver>\n" +
                "            <!--默认，空，签字时间,最大长度为19,类型为:UFDateTime-->\n" +
                "            <taudittime></taudittime>\n" +
                "              <!--实际值，应付财务组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <cpayfinorgoid>23</cpayfinorgoid>\n" +
                "            <!--实际值，应付财务组织,最大长度为20,类型为:String-->\n" +
                "            <cpayfinorgvid>23</cpayfinorgvid>\n" +
                "            <!--实际值，结算财务组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <cfanaceorgoid>23</cfanaceorgoid>\n" +
                "            <!--实际值，结算财务组织,最大长度为20,类型为:String-->\n" +
                "            <cfanaceorgvid>23</cfanaceorgvid>\n" +
                "            <!--实际值，采购组织,最大长度为20,类型为:String-->\n" +
                "            <cpurorgoid>23</cpurorgoid>\n" +
                "            <!--实际值，采购组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <cpurorgvid>23</cpurorgvid>\n" +
                "            <!--必填，供应商编码,最大长度为20,类型为:String-->\n" +
                "            <cvendorid>91120113MA05P7LA29</cvendorid>\n" +
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

    public String formatXml3() {
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding='UTF-8'?>\n" +
                "<ufinterface account=\"20231109\" billtype=\"45\" filename=\"\" groupcode=\"global\" isexchange=\"Y\" replace=\"Y\" roottag=\"bill\" sender=\"04\">\n" +
                "    <bill id=\"\">\n" +
                "        <billhead>\n" +
                "            <pk_group>0</pk_group>\n" +
                "            <pk_org>23</pk_org>\n" +
                "            <cgeneralbid>\n" +
                "                <item>\n" +
                "                    <pk_group>0</pk_group>\n" +
                "                    <corpoid>23</corpoid>\n" +
                "                    <crowno>10</crowno>\n" +
                "                    <cmaterialoid>0-070401-0002</cmaterialoid>\n" +
                "                    <cmaterialvid>0-070401-0007</cmaterialvid>\n" +
                "                    <cunitid>mt</cunitid>\n" +
                "                    <castunitid>mt</castunitid>\n" +
                "                    <vchangerate>1.00/1.00</vchangerate>\n" +
                "                    <nshouldassistnum>60</nshouldassistnum>\n" +
                "                    <nshouldnum>60</nshouldnum>\n" +
                "                    <nassistnum>59.1</nassistnum>\n" +
                "                    <nnum>59.1</nnum>\n" +
                "                    <ncostprice>\n" +
                "                    </ncostprice>\n" +
                "                    <ncostmny>\n" +
                "                    </ncostmny>\n" +
                "                    <nplannedprice>\n" +
                "                    </nplannedprice>\n" +
                "                    <nplannedmny>\n" +
                "                    </nplannedmny>\n" +
                "                    <clocationid>\n" +
                "                    </clocationid>\n" +
                "                    <dbizdate>2024-01-19 </dbizdate>\n" +
                "                    <cprojectid>\n" +
                "                    </cprojectid>\n" +
                "                    <ccorrespondhid>\n" +
                "                    </ccorrespondhid>\n" +
                "                    <ccorrespondbid>\n" +
                "                    </ccorrespondbid>\n" +
                "                    <csourcebillhid>1001A4100000003I6P9C</csourcebillhid>\n" +
                "                    <csourcebillbid>1001A4100000003I6P9D</csourcebillbid>\n" +
                "                    <vsourcebillcode>1111122222</vsourcebillcode>\n" +
                "                    <vsourcerowno>10</vsourcerowno>    \n" +
                "                    <cfirstbillhid>1001A4100000003I6P9C</cfirstbillhid>\n" +
                "                    <cfirstbillbid>1001A4100000003I6P9D</cfirstbillbid>\n" +
                "                    <vfirstbillcode></vfirstbillcode>\n" +
                "                    <vfirstrowno>10</vfirstrowno>\n" +
                "                    <csourcetype>21</csourcetype>\n" +
                "                    <csourcetranstype>21-01</csourcetranstype>\n" +
                "                    <cfirsttype>21</cfirsttype>\n" +
                "                    <cfirsttranstype>21-01</cfirsttranstype>\n" +
                "                    <cvendorid>91120113MA05P7LA29</cvendorid>\n" +
                "                    <cbodytranstypecode>45-01</cbodytranstypecode>\n" +
                "                    <pk_org>23</pk_org>\n" +
                "                    <pk_org_v>23</pk_org_v>\n" +
                "                    <cbodywarehouseid>1002</cbodywarehouseid>\n" +
                "                    <creqstoorgoid>23</creqstoorgoid>\n" +
                "                    <creqstoorgvid>23</creqstoorgvid>\n" +
                "                    <corigcurrencyid>CNY</corigcurrencyid>\n" +
                "                    <nchangestdrate>1.00000000</nchangestdrate>\n" +
                "                    <ccurrencyid>CNY</ccurrencyid>\n" +
                "                    <norignetprice>144.2478</norignetprice>\n" +
                "                    <norigtaxnetprice>163</norigtaxnetprice>\n" +
                "                    <nnetprice>144.2478</nnetprice>\n" +
                "                    <nqtorignetprice>144.2478</nqtorignetprice>\n" +
                "                    <nqtnetprice>144.2478</nqtnetprice>            \n" +
                "                    <nqtorigtaxnetprice>163</nqtorigtaxnetprice>\n" +
                "                    <ntaxnetprice>163</ntaxnetprice>\n" +
                "                    <nqttaxnetprice>163</nqttaxnetprice>                  \n" +
                "                    <norigmny>8525.04</norigmny>\n" +
                "                    <norigtaxmny>9633.3</norigtaxmny>\n" +
                "                    <norigtax>\n" +
                "                    </norigtax>\n" +
                "                    <nmny>8525.04</nmny>\n" +
                "                    <ntaxmny>9633.3</ntaxmny>\n" +
                "                    <ntax>1108.26</ntax>\n" +
                "                    <ntaxrate>13</ntaxrate>\n" +
                "                    <ftaxtypeflag>1</ftaxtypeflag>\n" +
                "                    <nsignnum></nsignnum>\n" +
                "                    <cglobalcurrencyid>CNY</cglobalcurrencyid>\n" +
                "                    <nglobalmny>\n" +
                "                    </nglobalmny>\n" +
                "                    <nglobaltaxmny>\n" +
                "                    </nglobaltaxmny>\n" +
                "                    <nglobalexchgrate>\n" +
                "                    </nglobalexchgrate>\n" +
                "                    <cgroupcurrencyid>\n" +
                "                    </cgroupcurrencyid>\n" +
                "                    <ngroupmny>\n" +
                "                    </ngroupmny>\n" +
                "                    <ngrouptaxmny>\n" +
                "                    </ngrouptaxmny>\n" +
                "                    <ngroupexchgrate>\n" +
                "                    </ngroupexchgrate>\n" +
                "                    <bassetcard>N</bassetcard>\n" +
                "                    <bfixedasset>N</bfixedasset>\n" +
                "                    <csrcmaterialoid>0-070401-0002</csrcmaterialoid>\n" +
                "                    <csrcmaterialvid>0-070401-0002</csrcmaterialvid>\n" +
                "                    <cprojecttaskid>\n" +
                "                    </cprojecttaskid>\n" +
                "                    <ctaxcodeid>CN01</ctaxcodeid>\n" +
                "                    <nnosubtax>\n" +
                "                    </nnosubtax>\n" +
                "                    <ncaltaxmny>8525.04</ncaltaxmny>\n" +
                "                    <bopptaxflag>N</bopptaxflag>\n" +
                "                    <ncalcostmny>8525.04</ncalcostmny>\n" +
                "                </item>\n" +
                "            </cgeneralbid>\n" +
                "            <corpoid>23</corpoid>\n" +
                "            <corpvid>23</corpvid>\n" +
                "            <cbiztype>PU01</cbiztype>\n" +
                "            <vbillcode></vbillcode>\n" +
                "            <cwarehouseid>1002</cwarehouseid>\n" +
                "            <dbilldate>2024-01-19 </dbilldate>\n" +
                "            <vtrantypecode>45-01</vtrantypecode>\n" +
                "            <cwhsmanagerid>03150</cwhsmanagerid>\n" +
                "            <ntotalnum>137.75</ntotalnum>\n" +
                "            <freplenishflag>N</freplenishflag>\n" +
                "            <vnote>按实际到货入库</vnote>\n" +
                "            <fbillflag>2</fbillflag>\n" +
                "            <creator>03150</creator>\n" +
                "            <billmaker>03150</billmaker>\n" +
                "            <creationtime>2022-12-28 16:36:15</creationtime>\n" +
                "            <approver></approver>\n" +
                "            <taudittime></taudittime>\n" +
                "            <cpayfinorgoid>23</cpayfinorgoid>\n" +
                "            <cpayfinorgvid>23</cpayfinorgvid>\n" +
                "            <cfanaceorgoid>23</cfanaceorgoid>\n" +
                "            <cfanaceorgvid>23</cfanaceorgvid>\n" +
                "            <cpurorgoid>23</cpurorgoid>\n" +
                "            <cpurorgvid>23</cpurorgvid>\n" +
                "            <cvendorid>91120113MA05P7LA29</cvendorid>\n" +
                "            <ctrantypeid>45-01</ctrantypeid>\n" +
                "            <csendcountryid>CN</csendcountryid>\n" +
                "            <crececountryid>CN</crececountryid>\n" +
                "            <ctaxcountryid>CN</ctaxcountryid>\n" +
                "        </billhead>\n" +
                "    </bill>\n" +
                "</ufinterface>\n");

        return sb.toString().replaceAll("<br>", "").replaceAll("</br>", "").replaceAll("&nbsp;", "").replaceAll("&",
                "&amp;");
    }

    public String formatXml4() {
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding='UTF-8'?>\n" +
                "<ufinterface account=\"20231109\" billtype=\"45\" filename=\"\" groupcode=\"global\" isexchange=\"Y\" replace=\"Y\" roottag=\"bill\" sender=\"04\">\n" +
                "    <bill id=\"\">\n" +
                "        <billhead>\n" +
                "            <!--集团,最大长度为20,类型为:String-->\n" +
                "            <pk_group>0</pk_group>\n" +
                "            <!--按实际，库存组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <pk_org>23</pk_org>\n" +
                "            <cgeneralbid>\n" +
                "                <item>\n" +
                "                    <!--必填 固定0 集团,最大长度为20,类型为:String-->\n" +
                "                    <pk_group>0</pk_group>\n" +
                "                    <!--必填，实际值 公司编码,最大长度为20,类型为:String-->\n" +
                "                    <corpoid>23</corpoid>\n" +
                "                    <!--必填 行号,最大长度为20,类型为:String-->\n" +
                "                    <crowno>1</crowno>                    \n" +
                "                    <!--必填 物料编码OA同步推送MIS,最大长度为20,类型为:String-->\n" +
                "                    <cmaterialoid>0-070401-0002</cmaterialoid>\n" +
                "                    <!--必填 物料版本,最大长度为20,类型为:String-->\n" +
                "                    <cmaterialvid>0-070401-0002</cmaterialvid>                    \n" +
                "                    <!--必填 ，固定值，主单位,最大长度为20,类型为:String-->\n" +
                "                    <cunitid>mt</cunitid>\n" +
                "                    <!--必填，固定值 单位,最大长度为20,类型为:String-->\n" +
                "                    <castunitid>mt</castunitid>                    \n" +
                "                    <!--必填，固定值， 换算率,最大长度为60,类型为:String-->\n" +
                "                    <vchangerate>1.00/1.00</vchangerate>\n" +
                "                    <!--必填 ，实际值，每车重量，应收数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nshouldassistnum></nshouldassistnum>\n" +
                "                    <!--必填 实际值，每车重量，应收主数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nshouldnum></nshouldnum>\n" +
                "                    <!--必填 实际值，每车重量，实收数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nassistnum></nassistnum>\n" +
                "                    <!--必填 实际值，每车重量，实收主数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nnum></nnum>           \n" +
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
                "                    <clocationid>\n" +
                "</clocationid>\n" +
                "                    <!--必填 ，实际入库日期,注意结账后当月改下月1号，最大长度为19,类型为:UFDate-->\n" +
                "                    <dbizdate></dbizdate>\n" +
                "                    <!--项目,最大长度为20,类型为:String-->\n" +
                "                    <cprojectid>\n" +
                "                    </cprojectid>\n" +
                "                    <!--对应入库单表头主键-->\n" +
                "                    <ccorrespondhid>\n" +
                "                    </ccorrespondhid>\n" +
                "                    <!--对应入库单据表体主键-->\n" +
                "                    <ccorrespondbid>\n" +
                "1001A4100000003I6P9D</ccorrespondbid>\n" +
                "                    <!--必填，采购订单表头主键，OA推送MIS，来源单据表头主键-->\n" +
                "                    <csourcebillhid>1001A4100000003I6P9C</csourcebillhid>\n" +
                "                    <!--必填，采购订单表体行主键，OA推送MIS，来源单据表体行主键-->\n" +
                "                    <csourcebillbid>1001A4100000003I6P9D</csourcebillbid>\n" +
                "                    <!--必填 采购订单号，来源单据号,最大长度为40,类型为:String-->\n" +
                "                    <vsourcebillcode></vsourcebillcode>\n" +
                "                    <!--必填 采购订单行号，来源单据行号,最大长度为20,类型为:String-->\n" +
                "                    <vsourcerowno>1</vsourcerowno>    \n" +
                "                    <!--必填，采购订单表头主键，源头单据表头主键,类型为:char-->\n" +
                "                    <cfirstbillhid>1001A4100000003I6P9C</cfirstbillhid>\n" +
                "                    <!--必填，采购订单表头主键，源头单据表体主键-->\n" +
                "                    <cfirstbillbid>1001A4100000003I6P9D</cfirstbillbid>\n" +
                "                    <!--必填 采购订单号,最大长度为40,类型为:String-->\n" +
                "                    <vfirstbillcode></vfirstbillcode>\n" +
                "                    <!--必填 采购订单行号,最大长度为20,类型为:String-->\n" +
                "                    <vfirstrowno>1</vfirstrowno>\n" +
                "                    <!--必填 ，固定21 来源单据类型,最大长度为20,类型为:String-->\n" +
                "                    <csourcetype>21</csourcetype>\n" +
                "                    <!--必填 ，固定21-01来源单据交易类型,最大长度为20,类型为:String-->\n" +
                "                    <csourcetranstype>21-01</csourcetranstype>\n" +
                "                     <!--必填 ，固定21 源头单据类型,最大长度为20,类型为:String-->\n" +
                "                    <cfirsttype>21</cfirsttype>\n" +
                "                    <!--必填 ，固定21-01 源头单据交易类型,最大长度为20,类型为:String-->\n" +
                "                    <cfirsttranstype>21-01</cfirsttranstype>\n" +
                "                    <!--必填，供应商编码,最大长度为20,类型为:String-->\n" +
                "                    <cvendorid>91120113MA05P7LA29</cvendorid>\n" +
                "                    <!--必填，固定值45-01 出入库类型,最大长度为20,类型为:String-->\n" +
                "                    <cbodytranstypecode>45-01</cbodytranstypecode>\n" +
                "                    <!--必填 ，实际值，组织编码库存组织最新版本,最大长度为20,类型为:String-->\n" +
                "                    <pk_org>23</pk_org>\n" +
                "                    <!--必填 ，实际值，组织编码库存组织,最大长度为20,类型为:String-->\n" +
                "                    <pk_org_v>23</pk_org_v>\n" +
                "                    <!--必填 ，OA同步推送MIS，仓库编码，库存仓库,最大长度为20,类型为:String-->\n" +
                "                    <cbodywarehouseid>1002</cbodywarehouseid>\n" +
                "                    <!--必填 需求库存组织最新版本,最大长度为20,类型为:String-->\n" +
                "                    <creqstoorgoid>23</creqstoorgoid>\n" +
                "                    <!--必填 需求库存组织,最大长度为20,类型为:String-->\n" +
                "                    <creqstoorgvid>23</creqstoorgvid>\n" +
                "                    <!--必填 币种,最大长度为20,类型为:String-->\n" +
                "                    <corigcurrencyid>CNY</corigcurrencyid>\n" +
                "                    <!--必填 折本汇率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nchangestdrate>1.00000000</nchangestdrate>\n" +
                "                    <!--必填 本位币,最大长度为20,类型为:String-->\n" +
                "                    <ccurrencyid>CNY</ccurrencyid>\n" +
                "                    <!--必填 主无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norignetprice></norignetprice>\n" +
                "                    <!--必填 主无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norigtaxnetprice></norigtaxnetprice>\n" +
                "                    <!--必填 主本币无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nnetprice></nnetprice>\n" +
                "                    <!--必填 无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtorignetprice></nqtorignetprice>\n" +
                "                    <!--本币无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtnetprice></nqtnetprice>            \n" +
                "                    <!--含税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtorigtaxnetprice></nqtorigtaxnetprice>\n" +
                "                    <!--必填 主本币含税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntaxnetprice></ntaxnetprice>\n" +
                "                    <!--本币含税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqttaxnetprice></nqttaxnetprice>\n" +
                "                    <!--必填，本币无税合计,最大长度为28,类型为:UFDouble-->                    \n" +
                "                    <norigmny></norigmny>\n" +
                "                    <!--必填，价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norigtaxmny></norigtaxmny>\n" +
                "                    <!--税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norigtax>\n" +
                "0</norigtax>\n" +
                "                    <!--本币无税金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nmny></nmny>\n" +
                "                    <!--本币价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntaxmny></ntaxmny>\n" +
                "                    <!--本币税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntax>0</ntax>\n" +
                "                    <!--必填，实际值，税率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntaxrate></ntaxrate>\n" +
                "                    <!--固定，扣税类别,最大长度为0,类型为:Integer-->\n" +
                "                    <ftaxtypeflag>1</ftaxtypeflag>\n" +
                "                    <!--空，累计开票主数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nsignnum></nsignnum>\n" +
                "                    <!--固定，全局本位币,最大长度为20,类型为:String-->\n" +
                "                    <cglobalcurrencyid>CNY</cglobalcurrencyid>\n" +
                "                    <!--全局本币无税金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nglobalmny>\n" +
                "</nglobalmny>\n" +
                "                    <!--全局本币价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nglobaltaxmny>\n" +
                "</nglobaltaxmny>\n" +
                "                    <!--全局本位币汇率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nglobalexchgrate>\n" +
                "                    </nglobalexchgrate>\n" +
                "                    <!--集团本位币,最大长度为20,类型为:String-->\n" +
                "                    <cgroupcurrencyid>\n" +
                "                    </cgroupcurrencyid>\n" +
                "                    <!--集团本币无税金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ngroupmny>\n" +
                "</ngroupmny>\n" +
                "                    <!--集团本币价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ngrouptaxmny>\n" +
                "</ngrouptaxmny>\n" +
                "                    <!--集团本位币汇率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ngroupexchgrate>\n" +
                "                    </ngroupexchgrate>\n" +
                "                    <!--已生成设备卡片,最大长度为1,类型为:UFBoolean-->\n" +
                "                    <bassetcard>N</bassetcard>\n" +
                "                    <!--已转固,最大长度为1,类型为:UFBoolean-->\n" +
                "                    <bfixedasset>N</bfixedasset>\n" +
                "                    <!--来源物料编码,最大长度为20,类型为:String-->\n" +
                "                    <csrcmaterialoid>0-070401-0002</csrcmaterialoid>\n" +
                "                    <!--来源物料版本,最大长度为20,类型为:String-->\n" +
                "                    <csrcmaterialvid>0-070401-0002</csrcmaterialvid>\n" +
                "                    <!--项目任务,最大长度为20,类型为:String-->\n" +
                "                    <cprojecttaskid>\n" +
                "                    </cprojecttaskid>\n" +
                "                    <!--必填，OA推送MIS，税码,最大长度为20,类型为:String-->\n" +
                "                    <ctaxcodeid>CN01</ctaxcodeid>\n" +
                "                    <!--不可抵扣税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nnosubtax>\n" +
                "                    </nnosubtax>\n" +
                "                    <!--计税税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ncaltaxmny></ncaltaxmny>\n" +
                "                    <!--逆向征税标志,最大长度为1,类型为:UFBoolean-->\n" +
                "                    <bopptaxflag>N</bopptaxflag>\n" +
                "                    <!--计成本金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ncalcostmny></ncalcostmny>\n" +
                "                </item>\n" +
                "            </cgeneralbid>\n" +
                "            <!--按实际，公司最新版本,最大长度为20,类型为:String-->\n" +
                "            <corpoid>23</corpoid>\n" +
                "            <!--按实际，公司,最大长度为20,类型为:String-->\n" +
                "            <corpvid>23</corpvid>\n" +
                "            <!--固定，业务流程,最大长度为20,类型为:String-->\n" +
                "            <cbiztype>PU01</cbiztype>\n" +
                "            <!--空，单据号,最大长度为40,类型为:String-->\n" +
                "            <vbillcode></vbillcode>\n" +
                "            <!--按实际，仓库,最大长度为20,类型为:String-->\n" +
                "            <cwarehouseid>1002</cwarehouseid>\n" +
                "            <!--按实际，单据日期,最大长度为19,类型为:UFDate-->\n" +
                "            <dbilldate></dbilldate>\n" +
                "            <!--固定，出入库类型编码,最大长度为20,类型为:String-->\n" +
                "            <vtrantypecode>45-01</vtrantypecode>\n" +
                "            <!--MIS固定值,最大长度为20,类型为:String-->\n" +
                "            <cwhsmanagerid>03150</cwhsmanagerid>\n" +
                "            <!--总数量,最大长度为28,类型为:UFDouble-->\n" +
                "            <ntotalnum></ntotalnum>\n" +
                "            <!--固定，采购退库,最大长度为1,类型为:UFBoolean-->\n" +
                "            <freplenishflag>N</freplenishflag>\n" +
                "             <!--备注,最大长度为181,类型为:String-->\n" +
                "            <vnote>按实际到货入库</vnote>\n" +
                "            <!--固定值2，单据状态,最大长度为0,类型为:Integer-->\n" +
                "            <fbillflag>2</fbillflag>\n" +
                "            <!--必填，创建人,最大长度为20,类型为:String-->\n" +
                "            <creator>03150</creator>\n" +
                "            <!--必填，制单人,最大长度为20,类型为:String-->\n" +
                "            <billmaker>03150</billmaker>\n" +
                "            <!--必填，制单时间，推送日期，最大长度为19,类型为:UFDateTime-->\n" +
                "            <creationtime>2024-01-23 11:24:41</creationtime>\n" +
                "            <!--默认，空，签字人,最大长度为20,类型为:String-->\n" +
                "            <approver></approver>\n" +
                "            <!--默认，空，签字时间,最大长度为19,类型为:UFDateTime-->\n" +
                "            <taudittime></taudittime>\n" +
                "            <!--实际值，应付财务组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <cpayfinorgoid>23</cpayfinorgoid>\n" +
                "            <!--实际值，应付财务组织,最大长度为20,类型为:String-->\n" +
                "            <cpayfinorgvid>23</cpayfinorgvid>\n" +
                "            <!--实际值，结算财务组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <cfanaceorgoid>23</cfanaceorgoid>\n" +
                "            <!--实际值，结算财务组织,最大长度为20,类型为:String-->\n" +
                "            <cfanaceorgvid>23</cfanaceorgvid>\n" +
                "            <!--实际值，采购组织,最大长度为20,类型为:String-->\n" +
                "            <cpurorgoid>23</cpurorgoid>\n" +
                "            <!--实际值，采购组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <cpurorgvid>23</cpurorgvid>\n" +
                "            <!--必填，供应商编码,最大长度为20,类型为:String-->\n" +
                "            <cvendorid>91120113MA05P7LA29</cvendorid>\n" +
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
                "</ufinterface>");

        return sb.toString().replaceAll("<br>", "").replaceAll("</br>", "").replaceAll("&nbsp;", "").replaceAll("&",
                "&amp;");
    }

    /**
     * 测试模板
     * @return
     */
    public String formatXml5() {
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding='UTF-8'?>\n" +
                "<ufinterface account=\"20231109\" billtype=\"45\" filename=\"\" groupcode=\"global\" isexchange=\"Y\" replace=\"Y\" roottag=\"bill\" sender=\"04\">\n" +
                "    <bill id=\"\">\n" +
                "        <billhead>\n" +
                "            <!--集团,最大长度为20,类型为:String-->\n" +
                "            <pk_group>0</pk_group>\n" +
                "            <!--按实际，库存组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <pk_org>23</pk_org>\n" +
                "            <cgeneralbid>\n" +
                "                <item>\n" +
                "                    <!--必填 固定0 集团,最大长度为20,类型为:String-->\n" +
                "                    <pk_group>0</pk_group>\n" +
                "                    <!--必填，实际值 公司编码,最大长度为20,类型为:String-->\n" +
                "                    <corpoid>23</corpoid>\n" +
                "                    <!--必填 行号,最大长度为20,类型为:String-->\n" +
                "                    <crowno>10</crowno>                    \n" +
                "                    <!--必填 物料编码OA同步推送MIS,最大长度为20,类型为:String-->\n" +
                "                    <cmaterialoid>0-070401-0002</cmaterialoid>\n" +
                "                    <!--必填 物料版本,最大长度为20,类型为:String-->\n" +
                "                    <cmaterialvid>0-070401-0007</cmaterialvid>                    \n" +
                "                    <!--必填 ，固定值，主单位,最大长度为20,类型为:String-->\n" +
                "                    <cunitid>mt</cunitid>\n" +
                "                    <!--必填，固定值 单位,最大长度为20,类型为:String-->\n" +
                "                    <castunitid>mt</castunitid>                    \n" +
                "                    <!--必填，固定值， 换算率,最大长度为60,类型为:String-->\n" +
                "                    <vchangerate>1.00/1.00</vchangerate>                  \n" +
                "                    <!--必填 ，实际值，每车重量，应收数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nshouldassistnum>60</nshouldassistnum>\n" +
                "                    <!--必填 实际值，每车重量，应收主数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nshouldnum>60</nshouldnum>\n" +
                "                    <!--必填 实际值，每车重量，实收数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nassistnum>59.1</nassistnum>\n" +
                "                    <!--必填 实际值，每车重量，实收主数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nnum>59.1</nnum>                \n" +
                "                     <!--单价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ncostprice>\n" +
                "                    </ncostprice>\n" +
                "                    <!--金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ncostmny>\n" +
                "                    </ncostmny>                \n" +
                "                    <!--计划单价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nplannedprice>\n" +
                "                    </nplannedprice>\n" +
                "                    <!--计划金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nplannedmny>\n" +
                "                    </nplannedmny>                   \n" +
                "                    <!--必填 货位编码,OA同步推送MIS，最大长度为20,类型为:String-->\n" +
                "                    <clocationid>\n" +
                "                    </clocationid>                 \n" +
                "                    <!--必填 ，实际入库日期,注意结账后当月改下月1号，最大长度为19,类型为:UFDate-->\n" +
                "                    <dbizdate>2024-01-19 </dbizdate>                   \n" +
                "                    <!--项目,最大长度为20,类型为:String-->\n" +
                "                    <cprojectid>\n" +
                "                    </cprojectid>\n" +
                "                    <!--对应入库单表头主键-->\n" +
                "                    <ccorrespondhid>\n" +
                "                    </ccorrespondhid>\n" +
                "                    <!--对应入库单据表体主键-->\n" +
                "                    <ccorrespondbid>\n" +
                "                    </ccorrespondbid>              \n" +
                "                    <!--必填，采购订单表头主键，OA推送MIS，来源单据表头主键-->\n" +
                "                    <csourcebillhid>1001A4100000003I6P9C</csourcebillhid>\n" +
                "                    <!--必填，采购订单表体行主键，OA推送MIS，来源单据表体行主键-->\n" +
                "                    <csourcebillbid>1001A4100000003I6P9D</csourcebillbid>\n" +
                "                    <!--必填 采购订单号，来源单据号,最大长度为40,类型为:String-->\n" +
                "                    <vsourcebillcode>1111122222</vsourcebillcode>\n" +
                "                    <!--必填 采购订单行号，来源单据行号,最大长度为20,类型为:String-->\n" +
                "                    <vsourcerowno>10</vsourcerowno>    \n" +
                "                    <!--必填，采购订单表头主键，源头单据表头主键,类型为:char-->\n" +
                "                    <cfirstbillhid>1001A4100000003I6P9C</cfirstbillhid>\n" +
                "                    <!--必填，采购订单表头主键，源头单据表体主键-->\n" +
                "                    <cfirstbillbid>1001A4100000003I6P9D</cfirstbillbid>\n" +
                "                    <!--必填 采购订单号,最大长度为40,类型为:String-->\n" +
                "                    <vfirstbillcode></vfirstbillcode>\n" +
                "                    <!--必填 采购订单行号,最大长度为20,类型为:String-->\n" +
                "                    <vfirstrowno>10</vfirstrowno>\n" +
                "                    <!--必填 ，固定21 来源单据类型,最大长度为20,类型为:String-->\n" +
                "                    <csourcetype>21</csourcetype>\n" +
                "                    <!--必填 ，固定21-01来源单据交易类型,最大长度为20,类型为:String-->\n" +
                "                    <csourcetranstype>21-01</csourcetranstype>\n" +
                "                     <!--必填 ，固定21 源头单据类型,最大长度为20,类型为:String-->\n" +
                "                    <cfirsttype>21</cfirsttype>\n" +
                "                    <!--必填 ，固定21-01 源头单据交易类型,最大长度为20,类型为:String-->\n" +
                "                    <cfirsttranstype>21-01</cfirsttranstype>\n" +
                "                    <!--必填，供应商编码,最大长度为20,类型为:String-->\n" +
                "                    <cvendorid>91120113MA05P7LA29</cvendorid>\n" +
                "                    <!--必填，固定值45-01 出入库类型,最大长度为20,类型为:String-->\n" +
                "                    <cbodytranstypecode>45-01</cbodytranstypecode>\n" +
                "                    <!--必填 ，实际值，组织编码库存组织最新版本,最大长度为20,类型为:String-->\n" +
                "                    <pk_org>23</pk_org>\n" +
                "                    <!--必填 ，实际值，组织编码库存组织,最大长度为20,类型为:String-->\n" +
                "                    <pk_org_v>23</pk_org_v>\n" +
                "                    <!--必填 ，OA同步推送MIS，仓库编码，库存仓库,最大长度为20,类型为:String-->\n" +
                "                    <cbodywarehouseid>1002</cbodywarehouseid>\n" +
                "                    <!--必填 需求库存组织最新版本,最大长度为20,类型为:String-->\n" +
                "                    <creqstoorgoid>23</creqstoorgoid>\n" +
                "                    <!--必填 需求库存组织,最大长度为20,类型为:String-->\n" +
                "                    <creqstoorgvid>23</creqstoorgvid>\n" +
                "                    <!--必填 币种,最大长度为20,类型为:String-->\n" +
                "                    <corigcurrencyid>CNY</corigcurrencyid>\n" +
                "                    <!--必填 折本汇率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nchangestdrate>1.00000000</nchangestdrate>\n" +
                "                    <!--必填 本位币,最大长度为20,类型为:String-->\n" +
                "                    <ccurrencyid>CNY</ccurrencyid>\n" +
                "                    <!--必填 主无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norignetprice>144.2478</norignetprice>\n" +
                "                    <!--必填 主无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norigtaxnetprice>163</norigtaxnetprice>\n" +
                "                    <!--必填 主本币无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nnetprice>144.2478</nnetprice>\n" +
                "                    <!--必填 无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtorignetprice>144.2478</nqtorignetprice>\n" +
                "                    <!--本币无税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtnetprice>144.2478</nqtnetprice>            \n" +
                "                    <!--含税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqtorigtaxnetprice>163</nqtorigtaxnetprice>\n" +
                "                    <!--必填 主本币含税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntaxnetprice>163</ntaxnetprice>\n" +
                "                    <!--本币含税净价,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nqttaxnetprice>163</nqttaxnetprice>\n" +
                "                    <!--必填，本币无税合计,最大长度为28,类型为:UFDouble-->                    \n" +
                "                    <norigmny>8525.04</norigmny>\n" +
                "                    <!--必填，价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norigtaxmny>9633.3</norigtaxmny>\n" +
                "                    <!--税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <norigtax>\n" +
                "                    </norigtax>\n" +
                "                    <!--本币无税金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nmny>8525.04</nmny>\n" +
                "                    <!--本币价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntaxmny>9633.3</ntaxmny>\n" +
                "                    <!--本币税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntax>1108.26</ntax>\n" +
                "                   <!--必填，实际值，税率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ntaxrate>13</ntaxrate>\n" +
                "                    <!--固定，扣税类别,最大长度为0,类型为:Integer-->\n" +
                "                    <ftaxtypeflag>1</ftaxtypeflag>\n" +
                "                    <!--空，累计开票主数量,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nsignnum></nsignnum>\n" +
                "                    <!--固定，全局本位币,最大长度为20,类型为:String-->\n" +
                "                    <cglobalcurrencyid>CNY</cglobalcurrencyid>\n" +
                "                    <!--全局本币无税金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nglobalmny>\n" +
                "                    </nglobalmny>\n" +
                "                    <!--全局本币价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nglobaltaxmny>\n" +
                "                    </nglobaltaxmny>\n" +
                "                    <!--全局本位币汇率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nglobalexchgrate>\n" +
                "                    </nglobalexchgrate>\n" +
                "                    <!--集团本位币,最大长度为20,类型为:String-->\n" +
                "                    <cgroupcurrencyid>\n" +
                "                    </cgroupcurrencyid>\n" +
                "                    <!--集团本币无税金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ngroupmny>\n" +
                "                    </ngroupmny>\n" +
                "                    <!--集团本币价税合计,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ngrouptaxmny>\n" +
                "                    </ngrouptaxmny>\n" +
                "                    <!--集团本位币汇率,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ngroupexchgrate>\n" +
                "                    </ngroupexchgrate>\n" +
                "                   <!--已生成设备卡片,最大长度为1,类型为:UFBoolean-->\n" +
                "                    <bassetcard>N</bassetcard>\n" +
                "                    <!--已转固,最大长度为1,类型为:UFBoolean-->\n" +
                "                    <bfixedasset>N</bfixedasset>\n" +
                "                   <!--来源物料编码,最大长度为20,类型为:String-->\n" +
                "                    <csrcmaterialoid>0-070401-0002</csrcmaterialoid>\n" +
                "                    <!--来源物料版本,最大长度为20,类型为:String-->\n" +
                "                    <csrcmaterialvid>0-070401-0002</csrcmaterialvid>\n" +
                "                    <!--项目任务,最大长度为20,类型为:String-->\n" +
                "                    <cprojecttaskid>\n" +
                "                    </cprojecttaskid>\n" +
                "                    <!--必填，OA推送MIS，税码,最大长度为20,类型为:String-->\n" +
                "                    <ctaxcodeid>CN01</ctaxcodeid>\n" +
                "                    <!--不可抵扣税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <nnosubtax>\n" +
                "                    </nnosubtax>\n" +
                "                    <!--计税税额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ncaltaxmny>8525.04</ncaltaxmny>\n" +
                "                   <!--逆向征税标志,最大长度为1,类型为:UFBoolean-->\n" +
                "                    <bopptaxflag>N</bopptaxflag>\n" +
                "                    <!--计成本金额,最大长度为28,类型为:UFDouble-->\n" +
                "                    <ncalcostmny>8525.04</ncalcostmny>\n" +
                "                </item>\n" +
                "            </cgeneralbid>\n" +
                "            <!--按实际，公司最新版本,最大长度为20,类型为:String-->\n" +
                "            <corpoid>23</corpoid>\n" +
                "            <!--按实际，公司,最大长度为20,类型为:String-->\n" +
                "            <corpvid>23</corpvid>\n" +
                "            <!--固定，业务流程,最大长度为20,类型为:String-->\n" +
                "            <cbiztype>PU01</cbiztype>\n" +
                "            <!--空，单据号,最大长度为40,类型为:String-->\n" +
                "            <vbillcode></vbillcode>\n" +
                "            <!--按实际，仓库,最大长度为20,类型为:String-->\n" +
                "            <cwarehouseid>1002</cwarehouseid>\n" +
                "            <!--按实际，单据日期,最大长度为19,类型为:UFDate-->\n" +
                "            <dbilldate>2024-01-19 </dbilldate>\n" +
                "            <!--固定，出入库类型编码,最大长度为20,类型为:String-->\n" +
                "            <vtrantypecode>45-01</vtrantypecode>\n" +
                "            <!--MIS固定值,最大长度为20,类型为:String-->\n" +
                "            <cwhsmanagerid>03150</cwhsmanagerid>\n" +
                "            <!--总数量,最大长度为28,类型为:UFDouble-->\n" +
                "            <ntotalnum>137.75</ntotalnum>\n" +
                "            <!--固定，采购退库,最大长度为1,类型为:UFBoolean-->\n" +
                "            <freplenishflag>N</freplenishflag>\n" +
                "             <!--备注,最大长度为181,类型为:String-->\n" +
                "            <vnote>按实际到货入库</vnote>\n" +
                "            <!--固定值2，单据状态,最大长度为0,类型为:Integer-->\n" +
                "            <fbillflag>2</fbillflag>\n" +
                "            <!--必填，创建人,最大长度为20,类型为:String-->\n" +
                "            <creator>03150</creator>\n" +
                "            <!--必填，制单人,最大长度为20,类型为:String-->\n" +
                "            <billmaker>03150</billmaker>\n" +
                "            <!--必填，制单时间，推送日期，最大长度为19,类型为:UFDateTime-->\n" +
                "            <creationtime>2022-12-28 16:36:15</creationtime>\n" +
                "            <!--默认，空，签字人,最大长度为20,类型为:String-->\n" +
                "            <approver></approver>\n" +
                "            <!--默认，空，签字时间,最大长度为19,类型为:UFDateTime-->\n" +
                "            <taudittime></taudittime>\n" +
                "              <!--实际值，应付财务组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <cpayfinorgoid>23</cpayfinorgoid>\n" +
                "            <!--实际值，应付财务组织,最大长度为20,类型为:String-->\n" +
                "            <cpayfinorgvid>23</cpayfinorgvid>\n" +
                "            <!--实际值，结算财务组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <cfanaceorgoid>23</cfanaceorgoid>\n" +
                "            <!--实际值，结算财务组织,最大长度为20,类型为:String-->\n" +
                "            <cfanaceorgvid>23</cfanaceorgvid>\n" +
                "            <!--实际值，采购组织,最大长度为20,类型为:String-->\n" +
                "            <cpurorgoid>23</cpurorgoid>\n" +
                "            <!--实际值，采购组织最新版本,最大长度为20,类型为:String-->\n" +
                "            <cpurorgvid>23</cpurorgvid>\n" +
                "            <!--必填，供应商编码,最大长度为20,类型为:String-->\n" +
                "            <cvendorid>91120113MA05P7LA29</cvendorid>\n" +
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
}
