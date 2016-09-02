**建发地产开放接口规范说明书**
-----------
#变更记录
| 版本号	 | 修改原因/内容  | 修改人	| 修改时间	|
| -------- |:----------------------------|:--------------------|:----------|
| V1.0		 | 初稿 |   余世明   |2015/7/1|
| V1.1		| 补充修订通知接口|余世明|2015/7/1|
| V2.0		| 升级协议规范 			|   余世明  |2015/7/1|
| V2.1		| 全新调整 			|   余世明  |2015/7/1|
| V2.1		| 增加4.1.13用户鉴权接口 	|   余世明  |2015/8/17|
| V2.1		| 增加分配置业顾问通知接口(notify_ sale_opp_assign)|余世明|2015/8/18|
| V2.1		| 增加客户查询接口(cst_info_get)| 余世明    |2015/8/18|
| V2.2		| 增加历史数据通知接口：<br>1､历史客户通知(notify_history_cst)<br>2､历史机会通知(notify_history_opp)<br>3､历史跟进通知(notify_history_follow) 			|   余世明  |2015/8/22|
| V2.3		| 增加EAS接口：<br>1、4.2.2指标金额完成情况查询<br>2、4.2.3客户未达标情况查询 			|   余世明  |2015/8/23|
| V2.4		| 4.1.5.	置业顾问查询（user_query）增加响应字段:手机号码 			|   余世明  |2015/8/23|
| V2.5		| 增加EAS销售系统类接口：<br>4.2.4 签约预计完成时间查询<br>4.2.5合同全额预计到账时间查询			|   余世明  |2015/9/10|
| V2.6		| 1、客户资料新增(cst_info_create)请求参数删除来源业态、媒体活动，<br>新增通信地址address字段<br>2、客户资料更新(cst_info_update)请求参数新增通信地址、项目编号、<br>业务员字段 客户资料变<br>3、更通知(notify_cst_update)请求参数增加证件字段、业务员字段<br>4、新增客户描摹通知接口(notify_cst_attach)  			|   余世明  |2015/9/10|
| V2.7		| 1、案场调用分配置业顾问上报(sale_opp_assign)增加修改人字段<br> 2、N-NY-09分配置业顾问通知(notify_sale_opp_assign)<br>也增加修改人字段 			|   余世明  |2015/9/25|
| V2.8		| 1、P-CU-04客户变更通知接口增加字段：address、userGUID<br>2、N-NY-16配置变更通知接口增加字段：teams/status 团队状态<br>3、N-NY-02 客户状态通知增加字段：userGUID、address<br>4、历史客户通知增加字段：sourceApp、cardType、cardID、<br>userGUID、address<br>5、历史跟进通知：sourceApp、activitySource、remark、userGUID 			|   余世明  |2015/10/4|
| V2.9		| 4.5.1.	N-NY-01项目上线通知，增加一个请求字段：<br>isOpen描述：是否开通移动案场1：开通 0：未开通 			|   余世明  |2015/10/13|
| V3.0		| 1、G-BA-03项目特征查询（proj_attach_list）新增4个返回参数：<br>codeSeq	否	int		特征排序<br>state	是	int		描摹状态<br>keySeq	否	int		特征值排序<br>endTime	否	string		媒体活动结束时间<br>2、通知接口N-NY-16配置变更通知(notify_proj_configed)，<br>attachs部分新增3个字段（endTime放置到remark）：<br>state	是	int		描摹状态<br>keySeq	否	int		特征值排序 			|   余世明  |2015/10/17|
| V3.1		| EAS销售系统类接口新增4个接口：<br>4.2.6.	G-TH-05房产情况列表查询<br>4.2.7.	G-TH-05房产预留信息查询<br>4.2.8.	P-TH-05房产预留设置<br>4.2.9.	P-TH-05房产取消预约设置		|   余世明  |2015/11/23|
| V3.2		| 1、G-BA-03项目特征查询（proj_attach_list）已经过时，<br>最新参见4.1.13 (proj_attach_list_v2)<br>2、P-CU-07客户描摹上报(cst_attach_create) 已经过时，<br>最新参见P-CU-09(cst_attach_create_v2)<br>3、N-NY-10客户描摹通知(notify_cst_attach)已经过时，<br>最新参见N-NY-21(notify_cst_attach_v2)<br>4、增加APP应用相关接口：<br>1）P-SA-12线索分配置业顾问上报(sale_lead_assign)<br>2）P-SA-13新增关联人(sale_opp2cst_create)<br>3）P-SA-14销售机会拍档上报(opportunity_partner_create)<br>4）P-SA-15销售机会拍档更新(opportunity_partner_update)<br>5）N-NY-15客户机会跟进通知(notify_cst_followRecord)<br>5）交易通知类接口 		|   余世明  |2016/1/5|
| V3.3		| 建发二期经纪人接口变更:<br>1、	新增机构上报接口（org_create）<br>2、客户状态通知接口(notify_cst_status)<br>请求参数增加roomType字段<br>3、客户推荐上报（agent_recommend）<br>请求参数增加cstMobile2备用手机号码 			|   余世明  |2016/1/7|
| V4.0		| 新增以下接口：<br>1、G-BA-15 请求历史数据同步（sync_request）<br>2、N-NY-22历史数据同步状态通知（notify_request_result）<br>3、P-CU-10 企业客户上报(ecst_info_create)<br>4、P-CU-11 企业客户查询(ecst_info_list)<br>5、项目特征通知、置业顾问变更通知接口<br>6、客户状态通知拆分：成交前的跟进通知、<br>交易数据的变更通知的拆分改造<br>7、配置变更通知接口的拆分（包括项目特征、置业顾问变更）<br> 			|   余世明  |2016/1/11|
| V4.0		| 新增以下接口：<br>1、N-NY-24置业顾问状态变更通知（notify_user）<br>2、N-NY-25项目特征变更通知（notify_proj_attach）<br>3、N-NY-26代理公司信息变更通知（notify_org_list）<br>4、N-NY-27销售团队信息查询（notify_team_list）			|   余世明  |2016/1/12|
| V4.1		| 删除企业客户上报、查询接口 			|   余世明  |2016/1/12|
|V4.2		    | 新增以下接口：<br> [客户查询接口（cst_info_get）增加客户类型字段（cstType)](#4.4.8.	G-CU-08客户查询接口（cst_info_get）)|   余世明   | 2016/01/19</font>|
|V4.3	|  增加性别字段（gender)：<br>1、[G-BA-05置业顾问查询（user_query）](#4.1.5. G-BA-05置业顾问查询（user_query）)<br>2、[N-NY-24置业顾问状态变更通知（notify_user）](#4.5.22.	N-NY-24置业顾问状态变更通知（notify_user）)<br>|余世明|2016/1/20|
|V4.4	|  新增以下接口：<br>1、[G-TH-10销售报表获取（sale_report_get）](#4.2.10.	G-TH-10销售报表获取（sale_report_get）)<br>2、[G-TH-11销售榜单数据获取](#4.2.11.	G-TH-11销售榜单数据获取（sale_rank_get）)<br>|余世明|2016/2/22|
|V4.5	|  [4.4.3.	P-CU-03客户资料新增（cst_info_create）](#4.4.3.	P-CU-03客户资料新增（cst_info_create）)<br>为兼容企业客户上报增加字段|胡旭红|2016/2/24|
|V4.6	|  增加通知接口的数据流|胡旭红|2016/2/25|
|V4.7	|  [4.4.4.    P-CU-04客户资料更新（cst_info_update）](#4.4.4.    P-CU-04客户资料更新（cst_info_update）)、<br/>[4.4.8.    G-CU-08客户查询接口（cst_info_get）](#4.4.8.    G-CU-08客户查询接口（cst_info_get）)、<br/>[4.5.3.    N-NY-03客户资料变更通知（notify_cst_update）](#4.5.3.    N-NY-03客户资料变更通知（notify_cst_update）)<br>为兼容企业客户上报增加字段|胡旭红|2016/2/25|
|V4.8	|  修改[G-BA-12城市查询（city_list）](#4.1.12.    G-BA-12城市查询（city_list）)接口，<br>page、pageSize改为非必填<br/>修改[P-BA-11经纪人更新（agent_update）](#4.1.11.    P-BA-11经纪人更新（agent_update）)接口，<br>agentGUID为必填|胡旭红|2016/2/29|
|V4.9	|  [4.5.11.1.	N-NY-11历史客户通知（notify_history_cst）](#4.5.11.1.	N-NY-11历史客户通知（notify_history_cst）)<br>为兼容企业客户增加字段|胡旭红|2016/3/1|
|V5.0	|  [4.3.11. P-SA-11跟进上报（sale_follow_create）](#4.3.11.    P-SA-11跟进上报（sale_follow_create）)<br>projGUID、oppGUID字段修改为必须|胡旭红|2016/3/16|
|V5.1	|  4.1.3. G-BA-03项目特征查询（proj_attach_list）<br>4.4.7. P-CU-07客户描摹上报(cst_attach_create)<br>4.5.10. N-NY-10客户描摹通知(notify_cst_attach)<br>4.5.12. N-NY-14配置变更通知(notify_proj_configed)<br> 接口作废|胡旭红|2016/3/17|
|V5.2	|  新增加[业务客户资料变更通知](#4.5.26. N-NY-28业务客户资料变更通知（notify_proj_cst_update）) |胡旭红|2016/3/31|
|V5.3	|  新增加以下接口<br>4.2.12. G-TH-12签约回款跟进提醒明细查询（followRemind_get）<br>4.2.13. G-TH-13签约回款跟进提醒总数查询（followRemindCount_get）<br>4.2.14.	G-TH-14用户密码修改接口（password_maintain） |易陈|2016/4/27|
|V5.4	|  新增接口字段:公司简称(orgShortName)<br>4.1.6. G-BA-06代理公司信息查询（org_list）<br>4.1.14. P-BA-14机构上报(org_create)<br>4.5.24. N-NY-26代理公司信息变更通知（notify_org_list） |易陈|2016/4/28|
|V5.5	|  新增字段:特征顺序(sequence	)<br>4.1.13. G-BA-13项目特征查询（proj_attach_list_v2）<br> 4.5.23. N-NY-25项目特征变更通知（notify_proj_attach） |易陈|2016/4/28|
|V5.6	| 以下接口projGUID必填修改为否：<br>4.5.12. N-NY-14配置变更通知(notify_proj_configed)<br> 4.5.24. N-NY-26代理公司信息变更通知（notify_org_list）<br>4.5.25. N-NY-27销售团队变更通知（notify_team_list） |余世明|2016/5/9|
|V5.7	|新增接口字段：reveivedTaget 回款指标金额、<br>subscribeTaget 认购指标金额、signTaget签约指标金额<br>影响接口:4.2.2.	G-TH-02指标金额完成情况查询（sales_target_query） |易陈|2016/5/16|
|V5.8	|新增加以下接口：<br>4.2.15. G-TH-15	查询已合同备案客户列表（contractPutOnList_get）<br>4.2.16. G-TH-16	查询已合同备案客户总数（contractPutOnCount_get） |易陈|2016/5/18|
|V5.9	|修改字段userGUID类型：String修改成JSONArray<br>影响接口：<br>4.2.12. G-TH-12签约回款跟进提醒明细查询（followRemind_get）<br>4.2.13. G-TH-13签约回款跟进提醒总数查询（followRemindCount_get）<br>4.2.15. G-TH-15	查询已合同备案客户列表（contractPutOnList_get）<br>4.2.16. G-TH-16	查询已合同备案客户总数（contractPutOnCount_get） |易陈|2016/5/25|
|V6.0	|新增字段：tradeGUID<br>影响接口：<br>4.4.1.	G-CU-01客户查询鉴定（cst_identify）|易陈|2016/6/3|
|V6.1	|新增字段：orgFormat<br>影响接口：<br>4.1.6. G-BA-06代理公司信息查询（org_list）<br>修改shopType字段类型：int修改成string<br>影响接口：<br>4.1.17.	P-BA-17商铺查询（shop_list）<br>新增接口：<br>4.1.18.	G-BA-18商铺业态查询（shopType_list）<br>4.1.19.	G-BA-19楼层查询（floor_list）|熊凯|2016/6/8|
|V6.2	|1、4.1.6. G-BA-06代理公司信息查询（org_list）新增返回字段：projShortCode（项目短编码）<br>2、4.1.16. P-BA-16 商场项目查询（marketProj_list）新增返回字段：cityShortCode（城市短码）,<br>shortCode（项目短码）,orgGUID（组织ID）<br>3、4.1.17. P-BA-17商铺查询（shop_list）<br>新增返回字段：floorID（商铺楼层ID）|熊凯|2016/6/14|
|V6.3	|新增字段：marketID<br>影响接口：<br>4.1.19.G-BA-19楼层查询（floor_list）|熊凯|2016/6/21|
|V6.4	|1、新增接口：<br>4.1.20.	G-BA-20盒子查询（box_list）<br>2、客户状态通知，认购、签约通知接口增加跟进类型:<br>2321 认购变更新增<br>2322 认购变更除名<br>2421 签约变更新增<br>2422 签约变更除名|熊凯|2016/6/22|
|V6.5	|1、4.1.18.G-BA-18商铺业态查询（shopType_list）<br>新增返回字段：status（状态）<br>2、4.1.19.G-BA-19楼层查询（floor_list）<br>新增返回字段：status（状态）|熊凯|2016/7/7|
|:star: V6.6	|1、4.1.13. G-BA-13项目特征查询（proj_attach_list_v2）<br>新增返回字段：<br>customerType（客户状态）<br>2、4.5.22. N-NY-24置业顾问状态变更通知（notify_user）<br>新增返回字段：<br>userStatus(置业顾问状态)<br>loginName(置业顾问登陆名)<br>3、4.5.22. N-NY-24置业顾问状态变更通知（notify_user）<br>更新返回字段：<br>status(置业顾问团队中的状态)|熊凯|2016/8/2|



#1. 前言
本接口规范，数据中心2.0数据平台的业务功能开放接口。适用于包括但不限于经纪人平台、案场APP、微信案场等，接入数据中心所遵循的标准。

#2. 总体规范
##2.1. 接口规范
*	接口采用`HTTP+JSON`，所有接口调用，均遵守`HTTP`协议，支持`GET`与`POST`两种方式，拒绝其它请求方式；统一使用UTF-8编码；包括消息内字段，及所有值。
*	所有上下行消息中，HTTP协议头部分必须包含`Content-Length`和`Content-Type`两个字段，`contnet-length`即`http`协议`body`长度；`content-type`值固定为`application/json`；
*	所有返回消息或参数，均以文本格式进行返回，对于二进制数据，则通过其它模块，以资源管理形式进行库维护。
*	所有请求中，必须包含认证必须字段，否则视为无效请求，予以拒绝。
*	所有时间字段，均以年月日时分秒的长字符串表示，格式为:*YYYY-MM-dd HH:mm&#58;ss*
*	所有上行消息的`JSON`，必须包含`header`和`data`两部分。`header`包含接口调用参数，即非业务相关数据；`data`部分为实际的业务数据；`data`为结构化的`json`转成字符串后，根据数据中心分配`appkey`加密后的`base64`字符串，加密算法为`RC4`。格式示例：
```json
		{
			"header":{},
			"data":""
		}
```
+ `header`必须包含的信息有

| 字段      |   说明  |
| :-------- | :--------| 
|appid	|	数据中心分配给应用的标识|
|timestamp	|时间戳，UTC秒值
|sid		|消息ID
|authCode	|认证校验码，即按自然排序后字符串拼接组合`appid`、`sid`、`token`、` dataCode`计算出的`sha1`散列码；其中`token`是数据中心分配给应用的校验码
|cmd	|调用命令，即接口名称
|version	|版本
|dataCode	|数据校验码，即结构化的`json`转成字符串后使用`appkey`加密后的数据，经`Base64`加密后计算出的`sha1`散列码。其中`appkey`是数据中心分配给应用的秘钥

*	所有响应消息的JSON，`data`部分加密的密钥与算法同上行消息。格式示例：
``` json
{
	"header":{},
	"data":""
}
```
其中data部分的原文格式为：
``` json
	{
		"errcode":0,
		"errmsg":"",
		"content":{}
	}
```
* 所有响应消息中，除`errcode`和`errmsg`外，所有必须参数，均指在`errcode`为0(即成功)的情况下才是必须

##2.2. 系统编号（appid）

| 系统分类	|appid编号	|说明|
| :--------	| :---------- | :-------- |
| 字段      |   说明  | ss |
|数据中心		|1XX	|所有数据中心模块或子系统`appid`取值范围为100~199|
|经纪人平台	|2XX	|经纪人类平台系统，如带客通、同享会等`appid`取值范围为200~299|
|案场系统	|3XX	|包括案场、微信等案场类系统`appid`取值为300~399|
|ERP系统	|4XX	|指现有传统ERP系统，如明源、用友等`appid`取值范围为400~499|
|会员类	|5XX	|包括统一会员平台或各业态的独有会员系统`appid`的取值范围500~599|
|电商类	|6XX	|包括第三方或自有渠道应用，如京东、官微等`appid`的取值范围为600~699|

##2.3. 接口编号规则
接口名定义分3部分，示例：`P1-P2-P3`

-	`P1`：表示接口接口处理方式。目前取值分别是
P:上报类接口
      G:查询类接口
      N:通知类接口
-	`P2`：表示数据用途分类。目前取值分别是 
	 BA：基础资源类接口
   SA：销售类接口
   CU：客户类接口
   ME：会员类接口
-	`P3`：表示在数据用途类范围内的接口编号

##2.4. SID定义
对应`head`包中的 `sid`定义：
数据中心与应用系统传输的每一条接口命令都有一个序列号，序列号由命令源系统产生并唯一标记一条命令；也就是说，数据中心系统中任何两个命令的序列号都不相同。对于数据中心主动推送到业务应用（经纪人平台、案场管理等）的消息，例如数据中心向案场发送一条推荐客户信息，此时序列号由数据中心生成（此时命令源节点为数据中心）。
序列号分成三部分，每部分为一个整数，第一部分表示命令源系统的编号，第二部分表示命令产生的日期和时间，格式为十进制的*yymmddhhmm*，比如14年11月20日20时32分25秒产生的消息，其第二部分为十进制*141120203225*；第三部分由0开始，最大值是99999，循环进位，直到进位满了之后再清零，重新开始计数, 不够5位，左补0

#3. 接入认证
上下行接入认证，采用同样算法；数据取值不同；应用上行到数据中心的，采用数据中心分配给应用的`appid`和`appkey`进行解析认证；数据中心下行到应用的，采用数据中心的`appid`和数据中心分配给应用`appkey`进行解析认证

##3.1. 请求步骤封装
1. 首先根据`SID`生成规则，生成消息ID
2. 将业务数据转成结构化的JSON转成字符串后，用数据中心分配的appkey进行`RC4`加密，密文经`base64`加密后`sha1`，即`dataCode`
3. 把密文进行`base64`加密；作为`data`字段值
4. 把`appid`、`sid`、数据中心分配的`token`、`dataCode`按自然排序后字符串拼接组装后计算`sha1`,即`authCode`
5. 创建`header`，包括字段`appid`、`sid`、`token`、`authCode`、`cmd`、`timestamp`、`version`、`dataCode`
6. 示例：

``` java
//初始化数据：
appid = "123";
token = "52e41ab0d3eee56b725e3e29999762a8";
appkey = "S_+SFO!fH.7qj_CEIKgCoSRfYr&e%,zAL1-*UEW7D]V$o4Cc=Dd4kwSh%6Q<!?=!+_@H^,K*#Gdk/d.qp@nBjl:e^/,.ckVGC2<4OoZNS2JN5<IX[Uq0W0oI-Y(K[k-R";
sid = "2014123123123123";
data = "{\"hello\":123}";
cmd = "cst_identity";
```
> **1.**根据`data`计算原始字节码：

``` html
7B 22 68 65 6C 6C 6F 22 3A 31 32 33 7D
```

> **2.**根据原始字节码计算密文：

``` html
15 0C FC 96 18 A1 15 B0 47 F1 F5 78 3C
```

> **3.**根据密文计算`base64`：

``` html
FQz8lhihFbBH8fV4PA==
```
> **4.**根据`base64`计算`sha1`散列码，即`dataCode`：

``` html
a975283943d4be0d7cb355c2115f45d63b5dcc5d
```
> **5.**将`appid`、`sid`、`token`、`dataCode`组合起来：

``` html
123201412312312312352e41ab0d3eee56b725e3e29999762a8a975283943d4be0d7cb355c2115f45d63b5dcc5d
```
> **6.**计算其`sha1`散列码，即`authCode`：

``` html
8c694932bba5d137af13654ce5a875d30a267ec8
```
> **7.**计算结果：

``` json
{
    "header": {
        "timestamp": 1436782123,
        "dataCode": "a975283943d4be0d7cb355c2115f45d63b5dcc5d",
        "authCode": "8c694932bba5d137af13654ce5a875d30a267ec8",
        "sid": "2014123123123123",
        "cmd": "cst_identity",
        "appid": "123",
        "version": "2.0"
    },
    "data": "FQz8lhihFbBH8fV4PA=="
}
```
##3.2. 接收验证步骤
1. 首先根据`http`头部的`content-length`读取报文后，解析成JSON；
2. 取header中的`appid`、`sid`、数据中心分配的`token`、`dataCode`，按自然排序后字符串拼接组装后计算`sha1`，与`authCode`比较判断接入认证
3. 接入认证成功后，以`base64`解密算法，将`data`值还原成密文；
4. 计算密文的`sha1`散列码，比较`dataCode`校验是否被篡改；
5. 篡改校验通过后，再用数据中心分配的`appkey`为密钥，以`RC4`算法解密转成结构化的JSON字符串
6. 示例：
``` json
//接收报文：
{
    "header": {
        "timestamp": 1436782123,
        "dataCode": "a975283943d4be0d7cb355c2115f45d63b5dcc5d",
        "authCode": "8c694932bba5d137af13654ce5a875d30a267ec8",
        "sid": "2014123123123123",
        "appid": "123",
        "version": "2.0"
    },
    "data": "FQz8lhihFbBH8fV4PA=="
}
```

> **1.**拼接`appid`、`sid`、`token`、`dataCode`：

``` html
123201412312312312352e41ab0d3eee56b725e3e29999762a8a975283943d4be0d7cb355c2115f45d63b5dcc5d
```
> **2.**计算拼接后字符串的`sha1`散列码：

``` html
8c694932bba5d137af13654ce5a875d30a267ec8
```
> **3.**计算`data`的`sha1`散列码：

``` html
a975283943d4be0d7cb355c2115f45d63b5dcc5d
```
> **4.** 经过以上三步计算，验证通过，则进行以下5､6两步：
> **5.** 以`base64`还原`data`为密文

``` html
15 0C FC 96 18 A1 15 B0 47 F1 F5 78 3C
```
> **6.**以`appKey`解密密文（如果是数据中心，`appKey`是以`appid`查找在数据中心配置的`appKey`，如果找不到，则不给任何响应数据；若是接入应用，则为数据中心分配的固定`appKey`）：

``` html
7B 22 68 65 6C 6C 6F 22 3A 31 32 33 7D
```
#4. 开放接口
##4.1. 基础资源类接口
###4.1.1. G-BA-01楼栋查询（building_query）
+ **接口说明**
 根据项目查询所有楼栋。
+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|projGUID|是|string|64|项目编号|
|page|是|int|10|页码|
|pageSize|是|int|10|分页大小，取值范围是［10，1000］|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|totalPage|是|int|10|记录总页数|
|page|是|int|10|本次查询页码|
|list|记录存在时必须|jsonArray|N/A|记录列表|
|list/buildingGUID|是|string|64|楼栋|
|list/buildingName|是|string|64|楼栋名称|
|list/unit|是|string|64|楼栋单元|

###4.1.2. G-BA-02楼栋单元查询（building_unit_query）
+ **接口说明**
 根据项目查询所有楼栋单元。
+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|bldGUID|是|string|64|项目编号|
|page|是|int|10|页码|
|pageSize|是|int|10|分页大小，取值范围是［10，1000］|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|totalPage|是|int|10|记录总页数|
|page|是|int|10|本次查询页码|
|list|记录存在时必须|jsonArray|N/A|记录列表|
|list/unitGUID|是|string|64|单元编号（数据中心编号）|
|list/buildingGUID|是|string|64|楼栋编号|
|list/unitName|是|string|64|单元名称|

###4.1.3. G-BA-03项目特征查询（proj_attach_list）（作废）
> [已经过时，最新参见4.1.13 G-BA-13项目特征查询(proj_attach_list_v2)](#4.1.13.	G-BA-13项目特征查询（proj_attach_list_v2）)

+ **接口说明**
 根据项目查询项目特征配置。
+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|projGUID|是|string|64|项目编号|
|page|是|int|10|页码|
|pageSize|是|int|10|分页大小，取值范围是［10，1000］|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|totalPage|是|int|10|记录总页数|
|page|是|int|10|本次查询页码|
|attachs|是|jsonArray|N/A|特征项目定义|
|attachs/projGUID|是|string|64|项目编号|
|attachs/attachCode|是|string|64|特征编号，关联b_def_attach|
|attachs/attachName|是|string|32|特征名称|
|attachs/attachType|是|int|4|特征类别|
|attachs/input|是|int|2|1=手动输入,默认<br>2=单选<br>3=多选|
|attachs/attachKey|是|string|64|特征项目值|
|attachs/category|是|string|32|特征分类|
|attachs/label|是|string|128|特征项目值描述|
|attachs/parentCode|否|string|16|保留字段|
|attachs/remark|否|string|200|备注|
|attachs/codeSeq|否|int|10|特征排序|
|attachs/state|是|int|10|描摹状态：<br>1有效<br>0无效|
|attachs/keySeq|否|int|10|特征值排序|
|attachs/endTime|否|string|32|媒体活动结束时间|

###4.1.4. G-BA-04房产查询（room_query）
+ **接口说明**
 根据项目或楼栋查询房产信息列表;项目和楼栋都不是必须参数，如果只传项目，则按项目查询；如果只传楼栋，则按楼栋查询；如果都传，则查询项目下某模楼栋的房产；都不传，则为非法查询。
	未推盘的房产不返回

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|projGUID|否，building不存在时必须时|string|64|项目编号|
|buildingGUID|否，projGUID不存在时必须|string|40|楼栋|
|page|是|int|10|页码|
|pageSize|是|int|10|分页大小，取值范围是［10，1000］|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|totalPage|是|int|10|记录总页数|
|page|是|int|10|本次查询页码|
|list|记录存在时必须|jsonArray|N/A|记录列表|
|list/roomGUID|是|string|64|房间GUID|
|list/huxing|是|string|64|户型|
|list/roomNo|是|string|64|房号|
|list/area|是|float|64|建筑面积|
|list/saleStatus|是|int|64|销控状态:<br>0=待售<br>1=预留<br>2=已售<br>|
|list/projGUID|是|string|64|项目编号|
|list/projName|是|string|64|项目名称|
|list/buildingGUID|是|string|64|楼栋|
|list/buildingName|是|string|64|楼栋名称|
|list/unit|是|string|64|楼栋单元|

###4.1.5. G-BA-05置业顾问查询（user_query）
+ **接口说明**
 查询某代理公司或项目下的所有置业顾问；项目和公司都不是必须参数，如果只传项目，则按项目查询；如果只传公司，则按公司查询；如果都传，则查询项目下某公司的置业顾问；都不传，则为非法查询。
	未推盘的房产不返回

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|projGUID|否,teamGUID不存在时必须|string|64|项目编号|
|teamGUID|否，projGUID不存在时必须|string|40|销售团队编号|

***备注：projGUID、teamGUID至少存在一个，否则请求无效***
+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|list|记录存在时必须|jsonArray|N/A|记录列表|
|list/userGUID|是|string|64|用户GUID|
|list/userName|是|string|64|用户名称|
|list/teamGUID|是|string|64|团队编号|
|list/projGUID|是|string|64|所属项目|
|list/attachCode|是|string|64|角色|
|list/status|是|int|64|状态:<br>0=无效<br>1=有效<br>2=离职|
|list/statusReason|是|string|64|状态原因|
|list/mobile|是|string|64|手机号码|
|<font color="red">list/gender</font>|<font color="red">是|<font color="red">int	|<font color="red">4|<font color="red">性别：0=未知，1=男，2=女|


###4.1.6. G-BA-06代理公司信息查询（org_list）
+ **接口说明**
 组织查询。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|page|否|int|10|页码|
|pageSize|否|int|10|分页大小，取值范围是［10，1000］|
|orgType|否|int|10|组织类型<br>1=代理公司<br>2=中介公司<br>3=区域公司/事业部<br>4=商场<br>5=商铺<br>6=门店<br>|
|subType|否|int|10|子类型,orgType=3 时有效，默认为0 <br>0 无效 <br>1 集团 <br>2 区域公司 <br>3 地市公司 <br>4 部门 <br>5 业态公司<br>|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|totalPage|是|int|10|记录总页数|
|page|是|int|10|本次查询页码|
|list|是|jsonArray|N/A|记录列表|
|list/orgGUID|是|string|64|公司GUID|
|list/orgName|是|string|64|公司名称|
|list/orgShortName|否|string|32|公司简称|
|list/status|否|string|64|状态|
|list/cityCode|是|int|10|城市代码|
|list/cityShortCode|是|int|10|城市短代码|
|list/parentOrgCode|否|string|64|上级组织ID|
|list/orgFullCode|否|string|100|组织长编码|
|list/orgType|是|int|10|组织类型|
|list/orgFormat|是|string|10|组织业态|
|list/projShortCode|否|string|64|项目短编码|

###4.1.7. G-BA-07销售团队信息查询（team_list）
+ **接口说明**
 查询销售团队信息，支持分页查询。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|page|是|int|4|页码|
|pageSize|是|int|4|分页大小，取值范围是［10，1000］|
|projGUID|是|string|64|项目编号|
|orgGUID|否|string|64|代理公司编号|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|totalPage|是|int|10|记录总页数|
|page|是|int|10|本次查询页码|
|list|是|jsonArray|N/A|记录列表|
|list/teamGUID|是|string|64|团队编号|
|list/teamName|是|string|64|团队名称|
|list/orgGUID|是|string|64|公司编号|



###4.1.8. G-BA-08置业顾问状态更新（user_status_update）
+ **接口说明**
 置业顾问状态更新上报数据中心，指定销售团队，则为在某个销售团队离场；若不指定，则为彻底离职，即所有销售团队或项目上均为离职状态。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|userGUID|是|string|64|置业顾问编号|
|companyGUID|是|string|64|销售团队|
|status|是|int|10|状态：<br>0=无效<br>1=有效<br>2=离职|
|statusReason|是|string|64|状态原因|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|consultantGUID|是|string|64|置业顾问GUID|

###4.1.9. G-BA-09经纪人鉴定请求（agent_identify）
+ **接口说明**
 同享会中经纪人注册时向数据中心获取信息经纪人的身份信息，鉴定经纪人是否为业主、员工、会员。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|mobile|否，手机为空时，身份证号码不能为空|string|16|手机号码|
|name|否|string|32|姓名，暂不支持|
|cardId|否,身份证号码为空时，手机号码不能为空|string|18|身份证号码|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|identitys|是|jsonArray|N/A|身份列表，如业主、建发房产员工、<br>建发集团员工、会员等：<br>20101	曾经业主<br>20102	当前业主<br>20103	租客<br>20201会员<br>20301	经纪人<br>20302	置业顾问<br>20401	员工<br>20402	房产员工<br>20501	供应商<br>20502	企业客户<br>|


###4.1.10. G-BA-10经纪人新增（agent_create）
+ **接口说明**
 同享会中经纪人注册成功时将经纪人信息上报到数据中心。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|name|是|string|32|经纪人姓名|
|mobile|是|string|32|手机号码|
|areaCode|是|int|10|所在城市ID|
|agentClasses|是|int|4|经纪人类别：<br>1 合作方<br>2 中介公司 <br>3 业主<br>4 非房产员工<br>5 外部代理公司<br>6 独立经纪人<br>7 企业用户<br>8 无佣金经纪人|
|proxyCompanyId|否|string|64|所在代理公司|
|agencyCompanyId|否|string|64|所在中介公司|
|totalPoint|否|int|10|累计积分，暂不支持|
|point|否|int|10|可用积分，暂不支持|
|level|否|int|10|所在中介公司：<br>1 经纪人等级（普通经纪人<br>2 铜牌经纪人<br>3 银牌经纪人<br>4 金牌经纪人<br>5 钻石经纪人<br>**暂不支持**|
|comment|否|string|50|中介公司经纪人：所在门店<br>员工：所在部门<br>业主：所在物业<br>|
|status|否|int|4|状态：<br>1 有效<br>0 无效|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|agentGUID|是|string|64|经纪人GUID|

###4.1.11.	P-BA-11经纪人更新（agent_update）
+ **接口说明**
 同享会将经纪人的更新信息（包括个人资料和积分信息）上报到数据中心

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|agentGUID|是|string|16|手机号码|
|name|是|string|32|经纪人姓名|
|mobile|是|string|32|手机号码|
|areaCode|是|int|10|所在城市ID|
|agentClasses|是|int|4|经纪人类别：<br>1 合作方<br>2 中介公司 <br>3 业主<br>4 非房产员工<br>5 外部代理公司<br>6 独立经纪人<br>7 企业用户<br>8 无佣金经纪人|
|proxyCompanyId|否|string|64|所在代理公司|
|agencyCompanyId|否|string|64|所在中介公司|
|comment|否|string|50|中介公司经纪人：所在门店<br>员工：所在部门<br>业主：所在物业<br>|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|agentGUID|是|string|64|经纪人GUID|

###4.1.12.	G-BA-12城市查询（city_list）
+ **接口说明**
 城市信息、支持分页查询

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|page|否|int|4|页码，不填默认为1|
|pageSize|否|int|4|分页大小，取值范围是［10，1000］，不填默认为10|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|totalPage|是|int|10|记录总页数|
|page|是|int|10|本次查询页码|
|list|是|jsonArray|N/A|记录列表|
|list/cityCode|是|string|64|城市编号|
|list/cityName|是|string|64|城市名称|


###4.1.13.	G-BA-13项目特征查询（proj_attach_list_v2）
+ **接口说明**
 根据项目查询项目特征描摹配置。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|projGUID|是|string|64|项目编号|
|category|否|int|4|途径分类:<br>10 渠道<br>20 身份<br>30 业态<br>40 客户描摹<br>50 机会描摹<br>60 途径定义<br>70 媒体活动定义|
|page|是|int|4|页码，不填默认为1，根据attach进行分页|
|pageSize|是|int|4|分页大小，取值范围是［10，1000］|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|totalPage|是|int|10|记录总页数|
|page|是|int|10|本次查询页码|
|attachs|是|jsonArray|N/A|记录列表|
|attachs/attachGUID|是|string|64|特征编号|
|attachs/attachCode|是|string|64|特征编码，全局唯一<br>10101 经纪人平台<br>10102 地产销售<br>10103 物业<br>20101 业主<br>20102 会员<br>20103 合伙人<br>20104 租客<br>其它见标准定义文档|
|attachs/attachName|是|string|64|特征名称|
|attachs/category|是|int|4|属于哪一类的特征定义，如身份定义、渠道定义、业态定义、<br>途径定义等；<br>10 渠道<br>20 身份<br>30 业态<br>40 客户描摹<br>50 机会描摹<br>60 途径定义<br>70 媒体活动定义<br>|
|attachs/attachLevel|是|int|4|特征级别<br>1 全局系统级<br>2 业态系统级<br>4 项目组织级<br>8 渠道应用级<br>16 公司级<br>|
|attachs/attachType|是|int|4|类型根据分类不同分不同的值表示，如分类值是20,即身份，则type可取值为<br>1 自然人<br>2 机构|
|attachs/scopeGUID|是|string|64|范围对象编号，例如：<br>attachLevel=4,scopeGUID取值为项目编号;<br>attachLevel=16,scopeGUID取值为公司编号;|
|attachs/subGUID|是|string|64|外键subGUID，引用特征描摹定义表b_def_attach(attachGUID),作为特征联动使用。<br>没有则默认不支持|
|attachs/input|是|int|4|输入方式<br>1 手动输入（默认值）<br>2 单选<br>3 多选|
|attachs/showType|是|int|4|显示方式<br>0 二级平面（默认值）<br>1 树状分局|
|attachs/requiredLevel|是|int|4|输入级别：<br>0 否,非必需（默认值）<br>1 是，必填|
|attachs/sequence|否|int|10|特征顺序|
|attachs/items|是|jsonArray|N/A|候选项列表|
|attachs/items/itemGUID|是|string|64|候选项编号|
|attachs/items/itemCode|是|string|64|候选项编码 (attachKey)|
|attachs/items/parentItemGUID|是|string|64|父级特征项编号|
|attachs/items/itemName|是|string|64|候选项名称(label)|
|attachs/items/sequence|是|int|10|候选项的顺序|
|attachs/items/state|是|int|4|状态：<br>1有效<br>0无效|
|attachs/items/expireTime|是|datetime|32|过期时间，默认为空，表示永不过期|
|attachs/items/scopejGUID|是|string|64|范围对象编号，例如：<br>attachLevel=4,scopeGUID取值为项目编号<br>attachLevel=16,scopeGUID取值为公司编号|
|attachs/items/customerType|是|int|4|客户类型 默认为0<br>0：通用 <br>1：个人 <br>2：企业|

+ **响应数据示例**
```  json
{
    "page": 1,
    "pageSize": 1,
    "attachs": [
        {
            "attachGUID": "123",
            "attachCode": "cst_constellation",
            "attachName": "星座",
            "category": "50",
            "attachLevel": 4,
            "attachType": 2,
            "scopeGUID": "xxxx",
            "subGUID": null,
            "input": 2,
            "showType": 0,
            "requiredLevel": 0,
            "sequence":1,
            "items": [
                {
                    "itemGUID": "111",
                    "itemCode": "10",
                    "parentItemGUID": "",
                    "itemName": "水平座",
                    "sequence": 1,
                    "state": 1,
                    "expireTime": null,
                    "scopeGUID": "xxxx"
                },
                {
                    "itemGUID": "112",
                    "itemCode": "11",
                    "parentItemGUID": "",
                    "itemName": "双子座",
                    "sequence": 2,
                    "state": 1,
                    "expireTime": null,
                    "scopeGUID": "xxxx"
                }
            ]
        }
    ]
}
```

###4.1.14.	P-BA-14机构上报(org_create)
+ **接口说明**
 应用新增或编辑机构，上报数据中心

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|orgGUID|否|string|64|组织机构标识，如果带上表示更新|
|orgName|是|string|64|公司名称|
|orgShortName|否|string|32|公司简称|
|orgType|是|int|4|组织类型：<br>1 代理公司<br>2 中介公司|
|contact|是|string|64|联系人|
|tel|是|string|32|联系电话|
|status|是|int|4|状态:<br>1有效<br>0无效|
|parentGUID|否|string|64|上级组织|
|cityCode|是|string|32|城市编码|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|orgGUID|否|string|64|组织机构标识,成功时返回|

###4.1.15.	P-BA-15请求历史数据同步（sync_request）
+ **接口说明**
 数据中心提供服务
业务应用请求数据中心同步历史数据

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|createdBy|是|string|64|操作人|
|taskName|是|string|64|任务名称|
|projGUID|否|string|64|项目GUID|
|shopGUID|否|string|64|门店或商铺GUID|
|timeRangeStart|否|string|32|开始时间，格式为：*yyyy-MM-dd HH:mm&#58;ss*|
|timeRangeEnd|否|string|32|结束时间，格式为：*yyyy-MM-dd HH:mm&#58;ss*|
|dataType|是|string|512|指定的数据范围，多个数据范围，通过 &#124; 分割，取值对应数据通知，如notify_cst_update、notify_agent_recommend等|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|taskID|是|string|64|任务编号|

###4.1.16.	P-BA-16 商场项目查询（marketProj_list）
+ **接口说明**
商场或项目查询，调用项目查询接口

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|articleType|否|int|10|类型：不传时默认全部<br>1 项目<br>2 商场|
|articleGUID|否|string|64|编号|
|page|否|int|10|page，默认1|
|pageSize|否|int|10|分页大小，取值范围是［10，1000 ]<br>pageSize，默认100|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|totalPage|是|int|10|记录总页数|
|page|是|int|10|本次查询页码|
|list|否|jsonArray|N/A|结果集|
|list/articleGUID|是|string|64|项目ID|
|list/articleName|是|string|64|项目名称|
|list/parentGUID|是|string|64|父级项目ID|
|list/cityCode|是|string|64|城市编码|
|list/status|是|int|4|状态：1有效0无效|
|list/lastModifyTime|是|datetime|32|最后修改时间,格式*yyyy-MM-dd HH:mm&#58;ss[.SSS]*|
|list/ifEnd|是|int|4|是否最末级项目：<br>0 否<br>1 是|
|list/buGUID|是|string|64|项目所属公司编码|
|list/level|是|int|4|级别|
|list/articleType|是|int|10|项目类型：<br>1 项目<br>2 商场|
|list/cityShortCode|是|string|64|城市短码|
|list/shortCode|是|string|64|项目短码|
|list/orgGUID|是|string|64|组织ID|

###4.1.17.	P-BA-17商铺查询（shop_list）
+ **接口说明**
商铺查询接口

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|shopGUID|否|string|64|编号|
|page|否|int|10|page，默认1|
|pageSize|否|int|10|分页大小，取值范围是［10，1000 ]<br>pageSize，默认100|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|totalPage|是|int|10|记录总页数|
|page|是|int|10|本次查询页码|
|list|否|jsonArray|N/A|结果集|
|list/shopGUID|是|string|64|业态商铺主键GUID|
|list/orgGUID|是|string|64|关联b_org表中的orgGUID|
|list/projGUID|是|string|64|所属项目/商场，关联b_proj表（如果是商场,取金蝶EAS商场ID）|
|list/shopName|是|string|64|商铺名称|
|list/address|是|string|64|地址|
|list/status|是|int|4|门店状态：<br>0 已关店<br>1 正常营业<br>2 暂停营业<br>3 未开业|
|list/weekOpen|是|string|128|每周营业日期：<br>即周一到周日（对应1〜7）哪几天营业，以逗号分割<br>如：1,3,5,7；默认为全部|
|list/shopType|是|string|64|经营种类或品牌等|
|list/contractGUID|是|string|64|级别|
|list/signDate|是|datetime|32|注册时间, 格式为：*YYYY-MM-dd HH:mm&#58;ss*|
|list/beginDate|是|datetime|32|开始时间, 格式为：*YYYY-MM-dd HH:mm&#58;ss*|
|list/endDate|是|datetime|32|关闭时间, 格式为：*YYYY-MM-dd HH:mm&#58;ss*|
|list/ywy|否|string|64|办理业务员|
|list/myGUID|否|string|64|签约人|
|list/floorID|否|string|64|商铺楼层ID|

###4.1.18.	G-BA-18商铺业态查询（shopType_list）
+ **接口说明**
商铺业态查询接口

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|page|否|int|10|page，默认1|
|pageSize|否|int|10|分页大小，取值范围是［10，1000 ]<br>pageSize，默认100|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|totalPage|是|int|10|记录总页数|
|page|是|int|10|本次查询页码|
|list|否|jsonArray|N/A|结果集|
|list/classGUID|是|string|64|分类ID|
|list/classID|是|string|20|源端分类ID|
|list/classCore|是|string|20|分类编码|
|list/className|是|string|20|分类名称|
|list/level|是|int|5|层级|
|list/parentID|是|string|20|父级ID|
|list/createTime|是|string|32|记录创建时间, 格式为：*YYYY-MM-dd HH:mm&#58;ss*|
|list/modifyTime|是|string|32|记录修改时间, 格式为：*YYYY-MM-dd HH:mm&#58;ss*|
|list/status|否|string|16|状态：<br>enabled 启用<br>disabled 禁用|

###4.1.19.	G-BA-19楼层查询（floor_list）
+ **接口说明**
楼层查询接口

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|page|否|int|10|page，默认1|
|pageSize|否|int|10|分页大小，取值范围是［10，1000 ]<br>pageSize，默认100|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|totalPage|是|int|10|记录总页数|
|page|是|int|10|本次查询页码|
|list|否|jsonArray|N/A|结果集|
|list/floorGUID|是|string|64|楼层ID|
|list/floorID|是|string|20|源端系统楼层ID|
|list/floorCore|是|string|20|楼层编号|
|list/floorName|是|string|20|楼层名称|
|list/type|是|int|5|类别|
|list/createTime|是|string|32|记录创建时间, 格式为：*YYYY-MM-dd HH:mm&#58;ss*|
|list/modifyTime|是|string|32|记录修改时间, 格式为：*YYYY-MM-dd HH:mm&#58;ss*|
|list/marketID|是|string|64|商场ID|
|list/status|否|string|16|状态：<br>using 使用中<br>deleted 已删除|

###4.1.20.	G-BA-20盒子查询（box_list）
+ **接口说明**
会员系统根据积分规则需要商铺和盒子的关联关系，目前只有"商铺ID"(数据中心已提供)
猫酷盒子生成的二维码信息，只有"盒子ID"，无法与积分规则匹配
因此需要数据中心抽取海鼎系统中的"猫酷盒子信息"，并提供开放服务给会员系统。
+ **应用方**
会员系统

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|page|否|int|10|page，默认1|
|pageSize|否|int|10|分页大小，取值范围是［10，1000 ]<br>pageSize，默认100|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|totalPage|是|int|10|记录总页数|
|page|是|int|10|本次查询页码|
|list|否|jsonArray|N/A|结果集|
|list/boxGUID|是|string|64|盒子ID|
|list/boxCode|是|string|64|盒子Code|
|list/boxName|是|string|64|盒子名称|
|list/boxStatus|是|int|4|状态：<br>1 启用<br>2 删除|
|list/projGUID|是|string|64|所属商场ID,取金蝶EAS商场ID|
|list/shopID|是|string|64|所属商铺ID,取源系统（海鼎）|

##4.2. EAS销售系统类接口
###4.2.1.	G-TH-01用户鉴权（cst_checkLogin）
+ **接口说明**
 案场用户鉴权

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|userName|是|string|64|用户名|
|password|是|string|64|用户密码|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|loginState|是|int|4|状态：<br>0：不通过<br>1：通过|
|userGUID|通过时必须|string|32|用户编号|

###4.2.2.	G-TH-02指标金额完成情况查询（sales_target_query）
+ **接口说明**
 案场查询指标金额完成情况

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|projGUID|是|string|64|项目GUID|
|companyGUIDS|否|array|N/A|代理公司ID列表，JSON数组|
|startTime|否|string|32|开始时间|
|endTime|否|string|32|结束时间|

+ **请求参数格式参考**

```  json
"data":{
		"projGUID":"vH42OZUZQfW92R/Cv00fmC/75aw="，
		"companyGUIDS":["dC23eaQhR/OG0XahLTZ3TDfGffw=", "11"],
		"startTime":"2015-01-11 00:00:00",
		"endTime":"2015-08-11 00:00:00"
	}

```
+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|list|存在时必须|array|N/A|记录列表|
|companyGUID|是|string|32|代理公司ID|
|reveivedAmount|是|double|32|回款金额|
|subscribeAmount|是|double|32|认购金额|
|signAmount|是|double|32|签约金额|
|reveivedTaget|是|double|32|回款指标金额|
|subscribeTaget|是|double|32|认购指标金额|
|signTaget|是|double|32|签约指标金额|


###4.2.3.	G-TH-03客户未达标情况查询（unPayAmount_query）
+ **接口说明**
 案场首页查询项目指定范围的客户未达款情况

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|customers|是|array|N/A|客户列表|
|customers/customerGUID|是|string|32|客户ID（数据中心）|
|customers/roomGUID|是|array|N/A|房间ID列表，JSON数组|

+ **请求参数格式参考**

```  json
"data":{
		" customers ":[{
			"customerGUID ":"1121",
			"roomGUID":[" yD21gUYnSmKYpeXiFBA98ZA+AjY= ", "11"]
			}
		]
	}

```


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|list|存在时必须|array||结果列表|
|customerGUID|是|string|32|客户ID|
|unPayAmount|是|double|32|未达款金额|

###4.2.4.	G-TH-04签约预计完成时间查询（constractSignDate_get）
+ **接口说明**
 获取合同签约应完成时间
 > 应用方：案场

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|roomGUID|是|string|32|房产编号|

+ **请求参数格式参考**
```  json
"data":{
		"roomGUID":"121212"
	}
```
+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|date|是|string|32|签约完成时间|

###4.2.5.	G-TH-05合同全额预计到账时间查询（constractReviDate_get）
+ **接口说明**
查询合同全额到账应完成时间
> 应用方：案场

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|roomGUID|是|string|32|房产编号|


+ **请求参数格式参考**
```  json
"data":{
		"roomGUID":"121212"
	}
```

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|date|是|string|32|全额到账日期|

###4.2.6.	G-TH-06房产情况列表查询（saleControlList_get）
+ **接口说明**
通过查询条件获取房间信息列表。
> 应用方：案场

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|projectGUID|是|string|64|项目ID|
|buildingGUID|是|string|64|楼栋ID|
|unitGUID|否|string|64|单元ID（数据中心编号），请求EAS时要进行转换|
|roomName|否|string|32|房号|
|page|是|int|10|页码，每页10条|

+ **请求参数格式参考**
```  json
"data":{
		" projectGUID ":"13t1341f1",
		" buildingGUID ":"12fr1ff4g4",
		" unitGUID ":"12f12f12f",
		"roomName":"101",
		"page":1
	}
```

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|page|是|int|10|页码|
|total|是|int|10|总条数|
|list|是|array|||
|list/unitName|是|string|32|单元号|
|list/roomGUID|是|string|64|房间ID|
|list/roomName|是|string|32|房间号|
|list/roomModel|是|string|32|户型|
|list/roomArea|是|float|32|面积|
|list/sellState|是|int|4|状态：<br>0 未售<br>1 预留<br>2 已售|

+ **响应参数格式参考**

```  json
"data":{
	"errcode ":0,
	"errmsg ":"",
	"content ":{
		"page":1,
		"total":16,
		"list":[
			{
				"unitName":"一单元",
				"roomGUID":"3j23kj2k3",
				"roomName":"1栋101号",
				"roomModel":"三房一厅",
				"roomArea":"面积",
				"sellState":0,
			}
		]
	}
}

```

###4.2.7.	G-TH-07房产预留信息查询 (saleControlDetail_get）
+ **接口说明**
获取房间预留信息列表
> 应用方：案场

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|roomGUID|是|string|64|房产编号|
|userGUID|是|string|64|操作人ID|

+ **请求参数格式参考**
```  json
" data":{
		" roomGUID ":"13t1341f1",
		"userGUID":"afaf1f1f"
	}
```

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|isPermission|是|int|4|预留查看权限：<br>0 没有权限<br>1 有权限|
|list|是|array||预留历史列表|
|list/userName|是|string|32|预留人名称|
|list/reason|是|string|32|预留原因|
|list/date|是|string|32|预留日期|
|list/type|是|int|4|类型：1、预留，2、取消预留|

+ **响应参数格式参考**
```  json
"data":{
	"errcode ":0,
	"errmsg ":"",
	"content ":{
		" isPermission ":1
		"list":[
			{
				"userName":"张三",
				"reason":"原因",
				"date":"2015-11-11 11:11:11",
				"type":1
			}
		]
	}
}
```

###4.2.8.	P-TH-08房产预留设置（keepSaleControl_set）
+ **接口说明**
对房间做预留操作。
> 应用方：案场

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|roomGUID|是|string|64|房间ID|
|userGUID|是|string|64|操作人ID|
|reason|是|string|100|原因|

+ **请求参数格式参考**
```  json
" data":{
		" roomGUID ":"13t1341f1",
		"userGUID":"afaf1f1f",
		"reason":"原因"
	}
```

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|state|是|int|10|结果：<br>0 预留失败<br>1 预留成功|
|message|是|string|64|提示信息|

+ **响应参数格式参考**
```  json
" data":{
	"errcode ":0,
	"errmsg ":"",
	"content ":{
		"state":0
		"message":"房间已被预留"
	}
}
```

###4.2.9.	P-TH-09房产取消预约设置（seelSaleControl_set）
+ **接口说明**
对房间做取消预留操作。
> 应用方：案场

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|roomGUID|是|string|32|房间ID|
|userGUID|是|string|32|操作人ID|

+ **请求参数格式参考**
```  json
"data":{
		" roomGUID ":"13t1341f1",
		"userGUID":"afaf1f1f"
	}
```

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|state|是|int|10|结果：<br>0 预留失败<br>1 预留成功|
|message|是|string|64|提示信息|

+ **响应参数格式参考**
```  json
" data":{
	"errcode ":0,
	"errmsg ":"",
	"content ":{
		"state ":0
		"message":"无法取消预留"
	}
}
```

###4.2.10.	G-TH-10销售报表获取（sale_report_get）
+ **接口说明**
通过项目ID及时间范围查询销售报表情况，返回信息包含：{类别名称、[{团队，销售金额/销售套数，百分比}]}。
数据由EAS提供，服务接口只进行转发。
> 应用方：案场

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|projectGUID|是|string|32|项目编号|
|startDate|是|string|32|时间范围开始时间，格式为:*YYYY-MM-dd HH:mm&#58;ss*|
|endDate|是|string|32|时间范围结束时间，格式为:*YYYY-MM-dd HH:mm&#58;ss*|
+ **请求参数格式参考**
```  json
    "data": {
        "projectGUID": "13t1341f1",
        "startDate": "2016-01-01 00:00:00",
        "endDate": "2016-01-01 00:00:00"
    }
```

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|list|存在时必须|array|N/A|跟进记录|
|list/projectGUID|是|string|32|项目ID|
|list/type|是|string|32|类别名称|
|list/total|是|double|64|总金额/套数|
|list/varList|存在时必须|array|N/A|数据|
|list/varList/teamGUID|是|string|64|团队ID|
|list/varList/teamName|是|string|64|团队名称|
|list/varList/var|是|int|10|金额/套数|
|list/varList/percent|是|double|32|百分比|

+ **响应参数格式参考**
```  json
{
    "errcode ": 0,
    "errmsg ": "成功",
    "content ": {
        "list": [
            {
                "projectGUID": "13t1341f1",
                "type": "认购金额",
                "total": 100000,
                "varList": [
                    {
                        "teamGUID": "123",
                        "teamName": "团队1",
                        "var": 30000,
                        "percent": 30
                    },
                    {
                        "teamGUID": "124",
                        "teamName": "团队2",
                        "var": 70000,
                        "percent": 70
                    }
                ]
            },
            {
                "projectGUID": " 13t1341f1",
                "type": "认购套数",
                "total": 60,
                "varList": [
                    {
                        "teamGUID": "123",
                        "teamName": "团队1",
                        "var": 30,
                        "percent": 50
                    },
                    {
                        "teamGUID": "124",
                        "teamName": "团队2",
                        "var": 30,
                        "percent": 50
                    }
                ]
            }
        ]
    }
}
```

###4.2.11.	G-TH-11销售榜单数据获取（sale_rank_get）
+ **接口说明**
当前自然月截止至当日的项目下每个置业顾问完成的认购金额。
数据由EAS提供，服务接口只进行转发。
> 应用方：案场

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|projectGUID|是|string|32|项目ID|
|consultantGUID|是|string|32|用户（..经理\置业顾问）ID|
+ **请求参数格式参考**
```  json
    "data": {
        "projectGUID ": "13t1341f1",
        "consultantGUID": "123123123ede"
    }
```

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|list|存在时必须|array|N/A|跟进记录|
|list/projectGUID|是|string|32|项目ID|
|list/teamGUID|是|string|32|团队ID|
|list/teamName|是|string|32|团队名称|
|list/saleAmount|是|double|32|总认购金额|
|list/saleMan|是|string|32|销售人员姓名|

+ **响应参数格式参考**
```  json
{
    "errcode": 0,
    "errmsg": "成功",
    "content": {
        "list": [
            {
                "projectGUID": " 13t1341f1",
                "teamGUID": "123",
                "teamName": "团队1",
                "saleAmount": 1000000,
                "saleMan": "张三"
            },
            {
                "projectGUID": " 13t1341f1",
                "teamGUID": "321",
                "teamName": "团队2",
                "saleAmount": 1090000,
                "saleMan": "李四"
            }
        ]
    }
}
```
###4.2.12.	G-TH-12签约回款跟进提醒明细查询（followRemind_get）
+ **接口说明**
查询客户需要跟进的到期或逾期客户信息。
数据由EAS提供，服务接口只进行转发。
> 应用方：案场

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|projectGUID|是|string|32|项目ID|
|userGUID|是|jsonArray|64|操作人ID集合|
|day|是|int|10|规则天数|
|type|是|int|2|规则类型1、未签约2、逾期签约3、未缴款4、逾期缴款|
|pageIndex|是|int|10|当前页|
|pageSize|是|int|10|每页条数|



+ **请求参数格式参考**
```  json
     "data":{
		"projectGUID":"13t1341f1",
		"userGUID":["afaf1f1f","qwqwqqw"],
		"day":3,
		"type":1,
		"pageIndex":3,
		"pageSize":10
	   }
```

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|page|是|int|10|当前页码|
|total|是|int|10|总条数|
|list|是|array|N/A|客户天数提醒列表|
|list/cstGUID|是|string|32|客户EASID，需要数据中心外部接口转换为移动案场cstGUID|
|list/day|是|int|10|预计或逾期天数|
|list/payName|是|string|32|款项类型名称|
|list/dateTime|是|string|32|应完成时间|
|list/money|是|double|32|金额|




+ **响应参数格式参考**
```  json
     "data":{
	 "errcode":0,
	 "errmsg":"",
	 "content":{
		"page":1,
		"total":47,
		"list":[
			{
				"cstGUID":"Idfafjk23k12j1k2=",
				"day":5,
				"payName":"全额到账",
				"dateTime":"2016-04-01 00:00:00",
				"money":10000
           },
			{
				"cstGUID":"Idfafds3k12j1k2=",
				"day":3,
				"payName":"首期款",
				"dateTime":"2016-04-03 00:00:00",
				"money":13000
            }
           ]
	     }
       }
```


###4.2.13.	G-TH-13签约回款跟进提醒总数查询（followRemindCount_get）
+ **接口说明**
查询客户有需要跟进的到期或逾期客户总条数。
数据由EAS提供，服务接口只进行转发。
> 应用方：案场

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|projectGUID|是|string|32|项目ID|
|userGUID|是|jsonArray|64|操作人ID集合|
|day|是|int|10|规则天数|
|type|是|int|2|规则类型1、未签约2、逾期签约3、未缴款4、逾期缴款|


+ **请求参数格式参考**
```  json
     "data":{
		"projectGUID":"13t1341f1",
		"userGUID":["afaf1f1f","qwqwqwqw"],
		"day":5,
		"type":1
	 }
```

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|total|是|int|10|需跟进条数|


+ **响应参数格式参考**
```  json
     "data":{
		"errcode":0,
		"errmsg":"",
		"content":{
          "total":20
		}
      }
```

###4.2.14.	G-TH-14用户密码修改接口（password_maintain）
+ **接口说明**
修改用户的登陆密码。
修改由EAS执行，服务接口只进行转发修改请求。
> 应用方：案场

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|userGUID|是|string|64|操作人ID|
|oldPassword|是|string|32|原密码|
|newPassword|是|String|32|新密码|
|confirmPassword|是|String|32|新密码确认|

+ **请求参数格式参考**
```  json
     "data":{
		"userGUID":"13t1341f1",
		"oldPassword":"123",
		"newPassword":"321",
		"confirmPassword":"321"
	 }
```

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|state|是|int|10|状态：0=不成功，1=修改成功|
|message|是|String|100|错误原因|


+ **响应参数格式参考**
```  json
     "data":{
		"errcode":0,
		"errmsg":"",
	    "content":{
		    "state":1,
		    "message":"修改成功"
	    }
      }
```

###4.2.15.	G-TH-15	查询已合同备案客户列表（contractPutOnList_get）
+ **接口说明**
查询已经完成合同备案的客户列表。
> 应用方：案场

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|projectGUID|是|string|64|项目ID|
|userGUID|是|jsonArray|64|操作人ID集合|
|pageIndex|是|String|10|当前页码|
|pageSize|是|String|10|每页条数|


+ **请求参数格式参考**
```  json
     "data":{
		"projectGUID":"13t1341f1",
		"userGUID":["afaf1f1f","wewwewwq"],
		"pageIndex":3,
		"pageSize":10
	}
```

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|page|是|int|10|当前页码|
|total|是|String|10|总条数|
|list|记录存在时必须 |jsonArray|N/A|客户已备案列表|
|list.cstGUID|是|String|64|客户EASID，需要数据中心外部接口转换为移动案场cstGUID|
|list.dateTime|是|String|32|合同备案时间|

+ **响应参数格式参考**
```  json
    "data": {
        "errcode": 0,
        "errmsg": "",
        "content": {
            "page": 1,
            "total": 47,
            "list": [
                {
                    "cstGUID": "Idfafjk23k12j1k2=",
                    "dateTime": "2016-04-01 00:00:00"
                },
                {
                    "cstGUID": "Idfafds3k12j1k2=",
                    "dateTime": "2016-04-03 00:00:00"
                }
            ]
        }
    }
```

###4.2.16.	G-TH-16	查询已合同备案客户总数（contractPutOnCount_get）
+ **接口说明**
查询已经完成合同备案的客户总数。
> 应用方：案场

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|projectGUID|是|string|64|项目ID|
|userGUID|是|jsonArray|64|操作人ID集合|



+ **请求参数格式参考**
```  json
     "data":{
		"projectGUID":"13t1341f1",
		"userGUID":["afaf1f1f","wewewewq"]
	}
```

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|total|是|String|10|总条数|

+ **响应参数格式参考**
```  json
    "data": {
        "errcode": 0,
        "errmsg": "",
        "content": {
            "total": 47         
        }
    }
```


##4.3. 销售进程类接口
###4.3.1.	P-SA-01客户推荐上报（agent_recommend）
+ **接口说明**
同享会中经纪人成功推荐客户的推荐信息（经纪人、客户、项目）上报到数据中心，有可能指定代理公司、置业顾问、预约时间。<br>1.	如果手机号码没有关联客户，则新增客户和客户手机映射关系；否则使用已经存在的客户编号<br>2.	新增一条经纪人推荐客户关系记录和线索记录<br>3.	返回同享会客户编号<br>4.	产生一条客户推荐通知消息
+ **消息流**
触发[客户推荐通知](#4.5.5.	N-NY-05客户推荐通知（notify_agent_recommend）)，消息类型：dc.mq.cst.recommend。



+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|agentGUID|是|string|64|经纪人ID|
|cstName|是|string|64|客户姓名|
|cstMobile|是|string|64|客户手机号码|
|cstMobile2|否|string|64|备用手机号码,备用号码只作为查看地和联系使用，<br>不参与任何业务逻辑处理|
|projGUID|是|string|64|项目code|
|productType|是|string|64|产品品类|
|proxyCompanyId|否|string|64|代理公司ID|
|consultantId|否|string|64|置业顾问ID|
|remark|否|string|64|备注|
|appointTime|否|string|64|预约上门时间|
|gender|否|int|10|1男 2 女|
|prizeRule|否|string|64|对结佣规则的描述|
|isAccompany|是|int|10|是否陪同上门：<br>1 是<br>0 否|
|recommendTime|是|string|64|上报，格式：*yyyy-MM-dd HH:MM&#58;ss*|
|expireTime|否|string|64|过期时间，格式：*yyyy-MM-dd HH:MM&#58;ss*|
|enable|是|int|10|推荐状态1：有效0：无效|
|cardType|否|int|10|证件类型(暂不支持)|
|cardID|否|string|64|证件号码(暂不支持)|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|cstGUID|否|string|64|成功后返回客户在数据中心的唯一ID|
|leadID|否|string|64|成功后返回对应推荐线索的ID|


###4.3.2.	P-SA-02推荐状态更新（agent_recommend_update）
+ **接口说明**
经纪人平台对推荐状态人工干预后，上报数据中心

+ **消息流**
触发[推荐状态通知](#4.5.7.	N-NY-07推荐状态通知（notify_recommend_status）)，消息类型：dc.mq.recommend.status。


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|leadID|是|string|64|经纪人ID|
|status|是|int|10|0=无效1=有效|
|remark|是|string|64|状态原因|
|expireTime|否|string|64|过期时间，格式：*yyyy-MM-dd HH:MM&#58;ss*|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|

###4.3.3.	P-SA-03机会新增(sale_opp_create)
+ **接口说明**
新增销售机会

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|cstGUID|是|string|64|客户ID|
|userGUID|是|string|64|当前置业顾问帐号|
|projGUID|是|string|64|项目编码|
|leadGUID|否|string|64|线索GUID|
|oppSource|是|string|64|机会来源|
|probability|否|int|10|意向等级：<br>1 A级<br>2 B级<br>3 C级<br>4 D级|
|status|否|string|64|状态：<br>0 新增（默认值）<br>101 关闭<br>102 激活|
|statusReason	|是|string|64|状态原因|
|statusTime|是|string|64|状态日期|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|oppGUID|否|string|64|销售机会GUID，成功时返回|

###4.3.4.	P-SA-04机会更新（sale_opp_update）
+ **接口说明**
更新销售机会


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|leadGUID|否|string|64|线索GUID|
|oppGUID|是|string|64|机会GUID|
|userGUID|是|string|64|机会GUID|
|projGUID|是|string|64|项目编码|
|cstGUID|是|string|64|客户编码|
|oppSource|否|string|64|机会来源|
|probability|是|int|64|意向等级：<br>1 A级<br>2 B级<br>3 C级<br>4 D级|
|status|是|int|64|状态：<br>0 新增（默认值）<br>102 激活|
|statusReason|否|string|64|状态原因|
|statusTime|否|string|64|状态日期|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.3.5.	P-SA-05机会合并（sale_opp_merge）
+ **接口说明**
合并两个机会，即直系关系的两个机会合并，客户主档不合并。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|droppedOppGUID|是|string|64|机会1的ID，即合并后丢弃不用的ID|
|retainOppGUID|是|string|64|机会2的ID，即合并后保留使用的ID|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|oppGUID|是|long|10|合并后保留的机会ID|

###4.3.6.	P-SA-06分配置业顾问上报（sale_opp_assign）
+ **接口说明**
销售机会分配给置业顾问后上报数据中心

+ **消息流**
触发[分配置业顾问通知](#4.5.9.	N-NY-09分配置业顾问通知（notify_sale_opp_assign）)，消息类型：dc.mq.opp.assign。



+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|cstGUID|是|long|10|客户ID|
|oppGUID|是|string|64|机会|
|projGUID|是|string|64|项目编号|
|modifyBy|是|string|64|修改人（置业顾问编号）|
|userGUID|是|string|64|置业顾问编号|
|userType|是|int|10|修改人的置业顾问类型：1置业顾问|
|assignType|是|int|10|分配方式：<br>1 自动轮巡<br>2 手动分配<br>3 自主抢客<br>4 转交|
|remark|否|string|64|备注说明|
|assignTime|是|string|64|分配时间，格式：*yyyy-MM-dd HH:MM&#58;ss*|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|assignGUID|是|string|64|分配标识|


###4.3.7.	P-SA-07机会流失(sale_opp_lose)
+ **接口说明**
销售机会流失后上报数据中心

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|oppGUID|是|string|64|机会|
|statusReason|是|string|64|流失原因|
|statusTime|是|string|64|流失时间|
|statusType|是|int|10|流失方式：<br>1 自动流失<br>2 人工流失|
|userGUID|是|string|64|流失人|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.3.8.	G-SA-08机会查询(sale_opp_query)
+ **接口说明**
新增销售机会

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|cstGUID|否|string|64|客户ID|
|oppGUID|否，|int|10|机会编号|
|projGUID|否|string|64|项目编码|
> 当cstGUID、projGUID都不存在时，oppGUID必须存在，否则请求无效

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|oppGUID|是|string|64|机会编号|
|cstGUID|是|string|64|客户编号|
|companyGUID|是|int|10|公司GUID|
|projGUID|是|string|64|项目编码|
|leadGUID|否|string|64|线索GUID|
|oppSource|否|string|64|机会来源|
|cognizePath|否|string|64|认知途径|
|process|否|string|64|跟进阶段|
|estRevenue|否|string|64|估计价值|
|probability|是|int|10|意向等级：<br>1 A级<br>2 B级<br>3 C级<br>4 D级|
|estCloseDate|否|string|64|估计关闭日期|
|followLevel|否|string|64|跟进级别|
|visitStatus|否|int|10|到访状态|
|tradeStatus|否|int|10|成交状态|
|status|否|int|10|状态|
|statusReason|否|string|64|状态原因|
|statusTime|否|string|64|状态日期|
|competitor|否|string|64|竞争对手|
|realTotal|否|string|64|实际价值|
|description|否|string|64|描述|
|partnerGUIDList|否|string|64|拍档列表|

###4.3.9.	P-SA-09客户预约(sale_appoint)
+ **接口说明**
	预约看房上报数据中心；数据中心根据手机和项目判断预约是否存在，若存在则比较预约看房时间是否在当前时间之前；若不存，则新增销售线索，预约成功；若存在，且预约看房时间比当前时间早或预约取消，则预约成功，不增线索；若存在，且预约看房时间比当前时间晚，则预约失败，不增线索；
暂不适用


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|mobile|是|string|64|客户手机|
|cstName|是|string|64|客户姓名|
|appointTime|是|string|64|预约看房时间|
|projGUID|是|string|64|项目code|
|userGUID|否|string|64|置业顾问ID|
|appintType|是|int|10|预约类型：<br>1 主动<br>2 被动预约|
|remark|是|string|64|备注说明|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|appointCode|否|string|64|预约号，成功时返回|


###4.3.10.	P-SA-10取消预约(sale_appoint_cancel)
+ **接口说明**
预约取消上报数据中心


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|appointCode|是|string|64|预约号|
|cancelReason|是|string|64|取消原因|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|

###4.3.11.	P-SA-11跟进上报（sale_follow_create）
+ **接口说明**
新增跟进信息上报数据中心

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|cstGUID|是|int|10|客户ID|
|projGUID|是|string|64|项目编号|
|type|是|int|10|类型：<br>1 线索跟进<br>2 机会跟进|
|rate|是|int|10|意向等级：<br>1 A级<br>2 B级<br>3 C级<br>4 D级|
|oppGUID|是|string|64|销售机会GUID|
|followDate|是|string|64|跟进时间|
|userGUID|是|string|64|置业顾问GUID|
|followType|是|int|10|跟进类型:<br>1 预约<br>2 来电<br>2001 首次来电(暂不支持)<br>2002 多次来电(暂不支持)<br>3 到访<br>3001 首次到访(暂不支持)<br>3002 多次到访(暂不支持)<br>4 认筹<br>5 认购<br>6 签约<br>7 回款<br>8 其它<br>09 转机会<br>21 入伙|
|followContent|否|string|64|跟进内容|
|nextFollowTime|否|string|64|下次跟进时间|
|nextFollowContnet|否|string|64|下次跟进内容|
|activitySource|否|string|64|媒体活动|
|remark|否|string|64|备注|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|followRecordID|成功时必须|string|64|跟进的唯一标识|

###4.3.12.	P-SA-12新增关联人(sale_opp2cst_create)
+ **接口说明**
机会新增关联人，增加机会关联客户

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|oppGUID|是|string|64|机会编号|
|cstGUID|是|string|64|客户编号|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|priority|成功时必须|int|10|客户优先级：<br>第一个客户0<br>第二个客户1<br>依次类推|

###4.3.13.	P-SA-13销售机会拍档更新(opportunity_partner_update)
+ **接口说明**
销售机会拍档更新，使用上报的partners更新机会拍档字段


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|partners|否|string|300|跟进拍档，多个用英文逗号分隔|
|oppGUID|是|string|64|机会GUID|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

##4.4. 客户汇聚类接口
###4.4.1.	G-CU-01客户查询鉴定（cst_identify）
+ **接口说明**
客户身份鉴定查询与跟进信息查询

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|mobile|是|string|64|手机|
|projGUID|否|string|300|项目编号，主要面向地产行业|
|cardId|否|string|300|身份证|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|exist|是|int|10|客户是否存在：<br>1 是<br>0 否|
|identitys|存在时必须|array||客户身份列表:<br>20101	曾经业主<br>20102	当前业主<br>20103	租客<br>20201	会员<br>20301	经纪人<br>20302	置业顾问<br>20401	员工<br>20402	房产员工<br>20501	供应商<br>20502	企业客户|
|list|存在时必须|array||跟进记录|
|list/followTime|是|string|64|跟进时间|
|list/followType|是|int|10|跟进类别：<br>1 预约<br>2 来电<br>3 到访<br>4 认筹<br>5 认购<br>6 签约<br>7 回款<br>8 其它|
|list/followContent|是|string|64|跟进内容|
|list/tradeGUID|否|string|64|交易GUID，当followType是认购、签约时必须|
###4.4.2.	P-CU-02客户主档合并(cst_merge)
+ **接口说明**
合并两个客户主档。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|droppedCstGUID|是|long|10|客户1的ID，即合并后丢弃不用的ID|
|retainCstGUID|是|long|10|客户2的ID，即合并后保留使用的ID|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|long|10|合并后保留的客户ID|
|cstName|否|string|64|客户名称|
|cardId|否|string|64|身份证|
|mobile|否|string|64|手机，多个手机，以逗号分割|
|address|否|string|64|地址|
|batchNo|否|string|64|本次合并的批次号,暂不支持|


###4.4.3.	P-CU-03客户资料新增（cst_info_create）
+ **接口说明**
新增客户信息上报数据中心

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstName|是|string|64|客户姓名/企业名称|
|gender|是|int|10|性别 1 男 2女 企业客户上报时传：0|
|birthDate|否|string|64|生日|
|cstType|是|int|10|客户类型：<br>1 个人，<br>2 公司|
|cardType|是|string|64|证件类型|
|cardID|否|string|128|证件号码|
|mobileTel|是|string|64|手机/联系电话|
|officeTel|否|string|64|办公电话|
|homeTel|否|string|64|家庭电话|
|address|否|string|100|通信地址/公司地址|
|backupTel1|否|string|64|备用号码1|
|backupTel2|否|string|64|备用号码2|
|backupTel3|否|string|64|备用号码3|
|backupTel4|否|string|64|备用号码4|
|corporationPerson|否|string|64|企业法人|
|corporationMobile|否|string|64|法人联系电话|
|firstContact|否|string|64|首选联系人|
|corporationScale|否|string|64|企业规模|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|否|string|64|成功时返回|

###4.4.4.	P-CU-04客户资料更新（cst_info_update）
+ **接口说明**
案场修改客户资料上报数据中心。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstName|是|string|64|客户姓名/企业名称|
|gender|是|int|10|性别|
|birthDate|否|datetime||生日|
|cstType|否|int|10|客户类型：<br>1 个人<br>2 公司|
|officeTel|否|string|64|办公电话|
|homeTel|否|string|64|家庭电话|
|cstGUID|是|string|64|客户编号|
|address|否|string|64|通信地址/公司地址|
|projGUID|是|string|64|项目编号|
|cardType|否|int|10|证件类型|
|cardID|否|string|128|证件号码|
|userId|是|string|64|业务员，即登记人|
|backupTel1|否|string|64|备用号码1|
|backupTel2|否|string|64|备用号码2|
|backupTel3|否|string|64|备用号码3|
|backupTel4|否|string|64|备用号码4|
|corporationPerson|否|string|64|企业法人|
|corporationMobile|否|string|64|法人联系电话|
|firstContact|否|string|64|首选联系人|
|corporationScale|否|string|64|企业规模|
|mobileTel|否|string|64|手机/联系电话|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.4.5.	P-CU-05客户手机新增（cst_mobile_add）
+ **接口说明**
(暂不支持)客户新增手机号码，即多个手机；如果手机存在，则新增失败

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|long|10|客户id|
|mobile|是|string|64|手机|
|type|是|int|10|号码类型，不填默认为手机<br>1 手机<br>2 家庭电话<br>3 办公电话|
|userId|否|string|64|业务员，即登记人|
|projGUID|是|string|64|项目编号|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.4.6.	P-CU-06客户手机更新(cst_mobile_update)
+ **接口说明**
(暂不支持)客户更新手机号码，即替换现有手机；如果手机存在，则新增失败

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|long|10|客户id|
|mobile|是|string|64|手机|
|type|是|int|10|号码类型，不填默认为手机<br>1 手机<br>2 家庭电话<br>3 办公电话|
|userId|否|string|64|业务员，即登记人|
|projGUID|是|string|64|项目编号|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.4.7.	P-CU-07客户描摹上报(cst_attach_create) （作废）
> [已经过时，最新参见P-CU-09(cst_attach_create_v2)](#4.4.9.	P-CU-09客户描摹上报（cst_attach_create_v2）)

+ **接口说明**
特征描摹指客户基础信息以外的所有信息，如户口、住址、工作等；一次可上报多个特征项信息，即以数组的形式上报。
描摹分基本描摹和项目描摹，即上报时指定了项目编号，则认为是项目描摹，不指定则认为是基本信息描摹。
单次请求必须是同一个客户相同项目下的特征描摹


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|attachs|是|array||特征数组|
|attachs/cstGUID|是|long|10|客户ID|
|attachs/projGUID|是|string|64|项目编号|
|attachs/attachCode|是|string|64|特征编号|
|attachs/value|否|string|2000|特征值|
|attachs/remark|否|string|2000|备注|
|attachs/sourceChannel|否|string|64|来源渠道|
|attachs/userId|是|string|32|业务员编号|
|attachs/createTime|是|string|32|上报时间|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.4.8.	G-CU-08客户查询接口（cst_info_get）
+ **接口说明**
客户信息查询


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|mobile|是|string|64|手机|
|cardId|否|string|64|身份证|
|<font color="red">cstType</font>|<font color="red">否|<font color="red">int|<font color="red">4|<font color="red">客户类型：<br>1 个人（默认值）<br>2 公司|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|string|64|客户编号|
|cstName|是|string|64|客户姓名/企业名称|
|gender|是|int|10|性别 1 男 2女|
|birthDate|否|string|64|生日|
|cstType|是|int|10|客户类型：<br>1 个人<br>2 公司|
|cardType|是|int|10|证件类型|
|cardID|否|string|128|证件号码|
|mobileTel|是|string|64|手机/联系电话|
|officeTel|否|string|64|办公电话|
|homeTel|否|string|64|家庭电话|
|sourceBiz|否|string|64|来源业态|
|activitySource|否|string|64|媒体活动|
|address|否|string|100|住址/公司地址|
|backupTel1|否|string|64|备用号码1|
|backupTel2|否|string|64|备用号码2|
|backupTel3|否|string|64|备用号码3|
|backupTel4|否|string|64|备用号码4|
|corporationPerson|否|string|64|企业法人|
|corporationMobile|否|string|64|法人联系电话|
|firstContact|否|string|64|首选联系人|
|corporationScale|否|string|64|企业规模|

###4.4.9.	P-CU-09客户描摹上报（cst_attach_create_v2）
+ **接口说明**
特征描摹指客户基础信息以外的所有信息，一次可上报多个特征项信息，即以数组的形式上报。
描摹分基本描摹和项目描摹，即上报时指定了项目编号，则认为是项目描摹，不指定则认为是基本信息描摹。
单次请求只能是同一个客户相同项目下的特征描摹



+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|string|64|客户ID|
|oppGUID|否|string|64|机会编号|
|userGUID|是|string|32|业务员编号|
|attachs|是|array||特征列表|
|attachs/scopeGUID|是|string|64|范围对象编号，例如：<br>attachLevel=4,scopeGUID取值为项目编号<br>attachLevel=16,scopeGUID取值为公司编号|
|attachs/attachGUID|是|string|64|特征编号|
|attachs/items|是|array||特征项列表|
|attachs/items/itemGUID|否|string|64|候选项编号，当attach的input=1时为空|
|attachs/items/itemValue|是|string|64|两种情况：<br>1 attach的input=1时，取候选项编码 (attachKey)<br>2 否则，则为输入值|
|attachs/items/parentItemGUID|否|string|64|父级特征项编号，attach的input=1时为空|
|attachs/items/remark|否|string|2000|备注|
|attachs/items/expireTime|否|datetime||过期时间，默认为空，表示永不过期|
|attachs/items/sourceChannel|否|string|16|来源渠道|


+ **请求格式示例**
```  json
{
    "cstGUID": "13333",
    "oppGUID": "xxxx",
    "userGUID": "xxxx",
    "attachs": [
        {
            "attachGUID": "123",
            "scopeGUID": "xxxx",
            "items": [
                {
                    "itemGUID": "111",
                    "itemValue": "10",
                    "parentItemGUID": "",
                    "remark": "",
                    "sourceChannel": "",
                    "expireTime": null
                }
            ]
        }
    ]
}
```
###4.4.10.	G-CU-10客户查询接口（cst_info_get_v2）
+ **接口说明**
客户信息查询，需要进行多次查询进行组装，
查客户+查描摹接口（微信、QQ、邮箱）+查会员接口 （会员编号、会员卡号）
> 应用方：会员系统

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|mobile|否|string|64|手机|
|cardId|否|string|64|身份证|
|cstGUID|否|string|64|客户编号|

> mobile、cardId、cstGUID至少存在一个，否则请求无效

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|string|64|客户编号|
|cstName|是|string|64|客户姓名|
|gender|是|int|10|性别 1 男 2女|
|birthDate|否|string|64|生日|
|cstType|是|int|10|客户类型：<br>1 个人<br>2 公司|
|cardType|是|int|10|证件类型|
|cardID|否|string|128|证件号码|
|mobileTel|是|string|64|手机|
|officeTel|否|string|64|办公电话|
|homeTel|否|string|64|家庭电话|
|sourceBiz|否|string|64|来源业态|
|activitySource|否|string|64|媒体活动|
|address|否|string|100|住址|
|wechat|否|string|64|微信|
|qq|否|string|64|QQ|
|email|否|string|64|邮箱|
|memGUID|否|string|64|会员编号|
|memCardId|否|string|64|会员卡号|

###4.4.11.	P-CU-11客户资料新增(cst_info_create_v2)
+ **接口说明**
新增客户信息上报数据中心，该接口是客户上报+客户描摹上报合并后的接口。
其中微信、QQ、邮箱需要转换到描摹进行上报，会员编号、会员卡号需要调用会员新增接口
> 应用方：会员系统

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstName|是|string|64|客户姓名|
|gender|是|int|10|性别 1 男 2女|
|birthDate|否|string|64|生日|
|cstType|是|int|10|客户类型：<br>1 个人，<br>2 公司|
|cardType|是|string|64|证件类型|
|cardID|否|string|128|证件号码|
|mobileTel|是|string|64|手机|
|officeTel|否|string|64|办公电话|
|homeTel|否|string|64|家庭电话|
|address|否|string|100|通信地址|
|wechat|否|string|100|微信|
|qq|否|string|100|QQ|
|email|否|string|100|邮箱|
|memGUID|否|string|100|会员编号|
|memCardId|否|string|100|会员卡号|
|oppGUID|否|string|64|机会编号|
|userGUID|否|string|32|业务员编号|
|attachs|否|array||特征列表|
|attachs/scopeGUID|是|string|64|范围对象编号，例如：<br>attachLevel=4,scopeGUID取值为项目编号<br>attachLevel=16,scopeGUID取值为公司编号|
|attachs/attachGUID|是|string|64|特征编号|
|attachs/items|是|array||特征项列表|
|attachs/items/itemGUID|否|string|64|候选项编号，当attach的input=1时为空|
|attachs/items/itemValue|是|string|64|两种情况：<br>1 attach的input=1时，取候选项编码 (attachKey)<br>2 否则，则为输入值|
|attachs/items/parentItemGUID|否|string|64|父级特征项编号，attach的input=1时为空|
|attachs/items/remark|否|string|2000|备注|
|attachs/items/expireTime|否|datetime||过期时间，默认为空，表示永不过期|
|attachs/items/sourceChannel|否|string|16|来源渠道|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|否|string|64|成功时返回|

##4.5. 通知推送类接口
###4.5.1.	N-NY-01项目上线通知(notify_proj_publish)
+ **接口说明**
项目上线通知，指项目上线时，通过数据中心管理后台，配置上线项目参数后，将项目信息通知到指定案场应用。
> 消息类型：dc.mq.proj.online

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|projInfos|是|array||项目信息数组|
|projInfos/projGUID|是|string|64|项目编号|
|projInfos/projName|是|string|64|项目名称|
|projInfos/isOpen|是|int|10|是否开通移动案场：<br>1 开通<br>0 未开通|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.2.	N-NY-02客户状态通知(notify_cst_status)
+ **接口说明**
客户状态通知指数据中心客户最后一次跟进状态通知到各应用，包括预约、来电、到访、认筹、认购、签约等。
> 消息类型：dc.mq.cst.status

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|string|64|客户ID|
|projGUID|是|string|64|项目编号|
|oriProjGUID|是|string|64|原始项目编号，即如果存在项目映射配置时，projGUID是转换后的推广项目，oriProjGUID指转换前的项目编号|
|followTime|是|string|64|跟进时间:yyyy-MM-dd HH:mm&#58;ss|
|followType|是|int|10|跟进类型：<br>1 预约<br>2 来电<br>2001 首次来电(暂不支持)<br>2002 多次来电(暂不支持)<br>3 到访<br>3001 首次到访(暂不支持)<br>3002 多次到访(暂不支持)<br>4 认筹<br>5 认购<br>6 签约<br>7 回款<br>8 其它<br>09 转机会<br>21 入伙<br>220 退筹<br>230 认购退房<br>231 认购作废<br>232 认购变更<br>2321 认购变更新增<br>2322 认购变更除名<br>233 认购换房<br>234 认购变价<br>235 认购变更付款方案<br>240 签约退房<br>241 签约作废<br>242 签约变更<br>2421 签约变更新增<br>2422 签约变更除名<br>243 签约换房<br>244 签约变价<br>245 签约变更付款方案<br>30 已交楼<br>31 产权出证<br>32 已入伙<br>33 跟踪<br>34 投诉|
|followContent|否|string|64|跟进内容|
|nextFollowTime|否|string|64|下次跟进时间*YYYY-MM-dd HH:mm&#58;ss*|
|nextFollowContent|否|string|64|下次跟进内容|
|money|是|double||认筹、认购或签约等成交类的金额|
|room|否|object||认购、签约等成交时的房产|
|room/roomGUID|是|string|64|房间GUID|
|room/huxing|是|string|64|户型|
|room/roomNo|是|string|64|房号|
|room/houseType|是|string|64|产品类型(业态代码)|
|followRecordID|是|string|64|唯一编号|
|sourceApp|是|string|64|系统来源|
|activitySource|否|string|64|媒体活动|
|remark|否|string|64|备注|
|userGUID|否|string|64|置业顾问|
|rate|否|int|10|意向等级：<br>1 A级<br>2 B级<br>3 C级<br>4 D级|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.3.	N-NY-03客户资料变更通知（notify_cst_update）
+ **接口说明**
客户资料变更包括新增和修改，如果是更新则只有当基本信息发生更新时才通知，即姓名、性别、生日、手机（包括家话电话和办公电话）、客户类型发生更新时才通知，通知内容不含证件类型和证件号
> 消息类型：dc.mq.cst.update

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|string|64|客户ID|
|cstName|是|string|64|客户姓名|
|gender|是|int|10|性别：<br>1 男<br>2 女<br>3 未知|
|birthDate|否|string|64|生日：*yyyy-MM-dd HH:mm&#58;ss*|
|cstType|是|int|10|客户类型：<br>1 个人<br>2 公司|
|mobileTel|否|string|64|手机|
|officeTel|否|string|64|办公电话|
|homeTel|否|string|64|家庭电话|
|sourceApp|是|string|64|系统来源|
|cardType|否|int|10|证件类型|
|cardID|否|string|128|证件号码|
|userGUID|否|string|64|业务员（新客户是对应登记人、老客户是 对应修改人）|
|address|否|string|64|地址|
|backupTel1|否|string|64|备用号码1|
|backupTel2|否|string|64|备用号码2|
|backupTel3|否|string|64|备用号码3|
|backupTel4|否|string|64|备用号码4|
|corporationPerson|否|string|64|企业法人|
|corporationMobile|否|string|64|法人联系电话|
|firstContact|否|string|64|首选联系人|
|corporationScale|否|string|64|企业规模|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.4.	N-NY-04客户资料合并通知(notify_cst_merge)
+ **接口说明**
客户主档在数据中心发生合并时，通知到各应用做相应变更
> 消息类型：dc.mq.cst.merge

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|retainCst|是|string|64|合并时保留继续使用的客户ID|
|dropedCst|是|string|64|合并时丢弃不再使用的客户ID|
|mergeTime|是|string|64|合并时间：*yyyy-MM-dd HH:mm&#58;ss*|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.5.	N-NY-05客户推荐通知（notify_agent_recommend）
+ **接口说明**
客户推荐通知即推荐线索通知	
> 消息类型：dc.mq.cst.recommend

+ **数据流**
通知消息由[客户推荐上报](#4.3.1.    P-SA-01客户推荐上报（agent_recommend）)开放接口产生，由service-message下发。


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|leadID|是|string|64|线索GUID|
|agentGUID|是|string|64|经纪人ID|
|agentClasses|是|int|10|经纪人类别：<br>1 合作方<br>2 中介公司 <br>3 业主<br>4 非房产员工<br>5 外部代理公司<br>6 独立经纪人<br>7 企业用户<br>8 无佣金经纪人|
|cstName|是|string|64|客户姓名|
|cstMobile|是|string|64|客户手机号码|
|cstMobile2|否|string|64|备用手机号码, 备用号码只作为查看地和联系使用，不参与任何业务逻辑处理|
|projGUID|是|string|64|项目|
|productType|是|string|64|产品品类|
|proxyCompanyId|否|string|64|代理公司ID|
|consultantId|否|string|64|置业顾问ID|
|remark|否|string|64|备注|
|appointTime|否|string|64|预约上门日期|
|gender|否|int|10|性别：<br>1男<br>2 女|
|prizeRule|否|string|64|对结佣规则的描述|
|isAccompany|是|int|10|是否陪同上门：<br>1 是<br>0 否|
|recommendTime|是|string|64|上报时间，*yyyy-MM-dd HH:mm&#58;ss*	|
|expireTime|否|string|64|过期时间，*yyyy-MM-dd HH:mm&#58;ss*|
|cstGUID|否|string|64|成功后返回客户在数据中心的唯一ID|
|sourceApp|是|string|64|系统来源|
|enable|是|int|10|推荐状态：<br>1：有效<br>0：无效|
|cardType|否|int|10|证件类型(暂不支持)|
|cardId|否|string|128|证件号码(暂不支持)|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.6.	N-NY-06客户预约通知(notify_appoint)（未实现）
+ **接口说明**
客户预约通知即预约线索通知
未实现


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|mobile|是|string|64|客户手机|
|cstName|是|string|64|客户姓名|
|appointTime|是|string|64|预约看房时间|
|projGUID|是|string|64|项目code|
|userGUID|否|string|64|置业顾问ID|
|appintType|是|int|10|预约类型：<br>1 主动<br>2 被动预约|
|remark|是|string|64|备注说明|
|appointCode|否|string|64|预约号，成功时返回|
|sourceApp|是|string|64|系统来源|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.7.	N-NY-07推荐状态通知（notify_recommend_status）
+ **接口说明**
经纪人平台对推荐状态人工干预上报数据中心后，数据中心通知到案场或其它应用
> 消息类型：dc.mq.recommend.status

+ **数据流**
通知消息由[推荐状态更新](#4.3.2.    P-SA-02推荐状态更新（agent_recommend_update）)开放接口产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|leadID|是|string|64|线索ID|
|status|是|int|10|状态：<br>0 无效<br>1 有效|
|remark|是|string|64|状态原因|
|expireTime|否|string|64|过期时间，*yyyy-MM-dd HH:MM&#58;ss*|
|sourceApp|是|string|64|系统来源|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.8.	N-NY-08机会更新通知（notify_opp_update）
+ **接口说明**
更新销售机会通知
> 消息类型：dc.mq.opp.update

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|leadGUID|否|string|64|线索GUID|
|oppGUID|否|string|64|机会GUID|
|oppSource|否|string|64|机会来源|
|probability|是|int|10|意向等级：<br>1 A级<br>2 B级<br>3 C级<br>4 D级|
|status|否|int|64|状态：<br>0 新增（默认值）<br>101 关闭<br>102 激活|
|statusReason|否|string|64|状态原因|
|statusTime|否|string|64|状态日期|
|sourceApp|是|string|64|系统来源|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.9.	N-NY-09分配置业顾问通知（notify_sale_opp_assign）
+ **接口说明**
使用场景一：案场分配置业顾问，通知到同享会
使用场景二：同步售楼系统主档时，当有关联职业顾问发送变化时，会修改数据中心机会分配置业顾问关系，会产生通知到案场
> 消息类型：dc.mq.opp.assign

+ **数据流**
通知消息由数据服务模块和[分配置业顾问上报](#4.3.6.	P-SA-06分配置业顾问上报（sale_opp_assign）)开放接口分别产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|long||客户ID|
|oppGUID|是|string|64|机会|
|leadGUID|否|string|64|线索编号|
|projGUID|是|string|64|项目编号|
|userGUID|是|string|64|分配的置业顾问编号|
|userType|是|int|10|分配的置业顾问类型|
|modifyBy|是|string|64|修改人(置业顾问编号)|
|assignType|是|int|10|分配方式：<br>1 自动轮巡<br>2 手动分配<br>3 自主抢客<br>4 转交|
|remark|否|string|64|备注说明|
|assignTime|是|string|64|分配时间，*yyyy-MM-dd HH:MM:&#58;ss*|
|sourceApp|是|string|64|系统来源|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.10.	N-NY-10客户描摹通知(notify_cst_attach) （作废）
> [已经过时，最新参见N-NY-21(notify_cst_attach_v2)](#4.5.9.	N-NY-22客户描摹通知（notify_cst_attach_v2）)

+ **接口说明**
ETL同步历史客户特征描摹和增量同步客户特征描摹，产生客户描摹通知到案场
> 消息类型：dc.mq.cst.attach

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|long||客户ID|
|projGUID|是|string|64|项目编号|
|attachCode|是|string|16|特征编号|
|value|否|string|2000|特征值|
|remark|否|string|2000|备注|
|sourceChannel|否|string|16|来源渠道|
|userId|是|string|32|业务员编号|
|createTime|是|string|32|上报时间|
|sourceApp|是|string|32|系统来源|
|extRemark|是|string|32|系统来源备注|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.11.	历史数据接口
####4.5.11.1.	N-NY-11历史客户通知（notify_history_cst）
+ **接口说明**
案场项目上线时，历史客户资料推送到案场
> 消息类型：dc.mq.history.cst

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|string|64|客户ID|
|cstName|是|string|64|客户姓名|
|gender|是|int|10|性别：<br>1 男<br>2 女<br>3 未知|
|birthDate|否|string|64|生日：*yyyy-MM-dd HH:mm&#58;ss*|
|cstType|是|int|10|客户类型：<br>1 个人<br>2 公司|
|mobileTel|否|string|64|手机|
|officeTel|否|string|64|办公电话|
|homeTel|否|string|64|家庭电话|
|extRemark|否|string|64|额外说明，即历史客户通知|
|sourceApp|是|string|64|系统来源|
|cardType|否|int|10|证件类型|
|cardID|否|string|128|证件号码|
|userGUID|否|string|64|业务员（新客户是对应登记人、老客户是 对应修改人）|
|address|否|string|64|地址|
|backupTel1|否|string|64|备用号码1|
|backupTel2|否|string|64|备用号码2|
|backupTel3|否|string|64|备用号码3|
|backupTel4|否|string|64|备用号码4|
|corporationPerson|否|string|64|企业法人|
|corporationMobile|否|string|64|法人联系电话|
|firstContact|否|string|64|首选联系人|
|corporationScale|否|string|64|企业规模|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

####4.5.11.2.	N-NY-12历史机会通知(notify_history_opp)
+ **接口说明**
历史机会全部重新推送
> 消息类型：dc.mq.history.opp

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|oppGUID|是|string|64|机会标识|
|cstGUID|是|string|64|客户ID|
|companyGUID|否|int|10|公司GUID|
|userGUID|是|string|64|当前置业顾问帐号|
|projGUID|是|string|64|项目编码|
|leadGUID|否|string|64|线索GUID|
|oppSource|是|string|64|机会来源|
|cognizePath|否|string|64|认知途径|
|process|否|string|64|跟进阶段|
|estRevenue|否|double||估计价值|
|probability|否|int|10|意向等级：<br>1 A级<br>2 B级<br>3 C级<br>4 D级|
|estCloseDate|否|string|64|估计关闭日期|
|followLevel|否|string|64|跟进级别|
|visitStatus|否|int|10|到访状态：<br>1 预约<br>2 来电<br>3 到访<br>4 认筹<br>8 其它|
|tradeStatus|否|int|10|成交状态：<br>3 到访<br>4 认筹<br>5 认购<br>6 签约<br>7 回款<br>8 其它<br>09 转机会<br>21 入伙<br>220 退筹<br>230 认购退房<br>231 认购作废<br>232 认购变更<br>2321 认购变更新增<br>2322 认购变更除名<br>233 认购换房<br>234 认购变价<br>235 认购变更付款方案<br>240 签约退房<br>241 签约作废<br>242 签约变更<br>2421 签约变更新增<br>2422 签约变更除名<br>243 签约换房<br>244 签约变价<br>245 签约变更付款方案<br>30 已交楼<br>31 产权出证<br>32 已入伙<br>33 跟踪<br>34 投诉|
|status|否|int|10|状态：<br>0 新增（默认值）<br>101 关闭<br>102 激活<br>103 逾期流失<br>104 人工流失|
|statusReason|是|string|64|状态原因|
|statusTime|是|string|64|状态日期|
|competitor|否|string|64|竞争对手|
|realTotal|否|double||实际价值|
|description|否|string|64|描述|
|myGUID|否|string|64|明源台帐ID|
|partnerGUIDList|否|string|64|拍档|
|extRemark|否|string|64|额外说明，即历史客户通知|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

####4.5.11.3.	N-NY-13历史跟进通知(notify_history_follow)
+ **接口说明**
客户在销售系统的历史跟进状态通知到各应用，包括预约、来电、到访、认筹、认购、签约等。
> 消息类型：dc.mq.history.follow

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|string|64|客户ID|
|projGUID|是|string|64|项目编号|
|oriProjGUID|是|string|64|原始项目编号，即如果存在项目映射配置时，projGUID是转换后的推广项目，oriProjGUID指转换前的项目编号|
|followTime|是|string|64|跟进时间:yyyy-MM-dd HH:mm&#58;ss|
|followType|是|int|10|跟进类型：<br>1 预约<br>2 来电<br>3 到访<br>4 认筹<br>5 认购<br>6 签约<br>7 回款<br>8 其它<br>09 转机会<br>21 入伙<br>220 退筹<br>230 认购退房<br>231 认购作废<br>232 认购变更<br>2321 认购变更新增<br>2322 认购变更除名<br>233 认购换房<br>234 认购变价<br>235 认购变更付款方案<br>240 签约退房<br>241 签约作废<br>242 签约变更<br>2421 签约变更新增<br>2422 签约变更除名<br>243 签约换房<br>244 签约变价<br>245 签约变更付款方案<br>30 已交楼<br>31 产权出证<br>32 已入伙<br>33 跟踪<br>34 投诉|
|followContent|是|string|64|跟进内容|
|nextFollowTime|否|string|64|下次跟进时间*YYYY-MM-dd HH:mm&#58;ss*|
|nextFollowContent|否|string|64|下次跟进内容|
|money|否|double||认筹、认购或签约等成交类的金额|
|room|否|object||认购、签约等成交时的房产|
|room/roomGUID|是|string|64|房间GUID|
|room/huxing|是|string|64|户型|
|room/roomNo|是|string|64|房号|
|followRecordID|是|string|64|唯一编号|
|extRemark|否|string|64|额外说明，即历史客户通知|
|sourceApp|是|string|64|系统来源|
|activitySource|否|string|64|媒体活动|
|remark|否|string|64|备注|
|userGUID|否|string|64|置业顾问|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.12.	N-NY-14配置变更通知(notify_proj_configed)（作废）
+ **接口说明**
上线项目置业顾问及团队配置、项目特征项定义发生变化时，通知指定应用。通知只包含新增或更新的数据，如果接收应用用缓存通知数据的话，需要根据通知数据的标识判断本地是否已存在，如根据userGUID判断置业顾问是否存在，根据attachCode判断特征是否已存在
    - 触发通知包括：
	1､ 销售团队新增或更新时，针对团队所在项目触发通知
	2､ 置业顾问新增或更新时，针对置顾问所在的所有团队对应的所有项目触发通知
	3､ 项目特征定义新增或更新时，针对所有上线项目触发能耐
	4､ 特征定义的预选值新增或更新时，针对所有上线项目触发通知；如果预选值是针对项目的，则只触发此项目的变更通知

    - 注意
	1拆分为N-NY-27销售团队变更通知（notify_team_list）
	2拆分为N-NY-24置业顾问状态变更通知（notify_user）
	3、4拆分为N-NY-25项目特征变更通知（notify_proj_attach）
	代理公司部分拆分为：N-NY-26代理公司信息变更通知（notify_org_list）

 > 消息类型：dc.mq.proj.configed

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|projGUID|否|string|64|项目编号|
|settings|否|jsonArray|N/A|置业顾问配置|
|settings/userGUID|是|string|64|置业顾问编号|
|settings/cstGUID|是|string|64|客户ID|
|settings/userName|是|string|64|用户名称|
|settings/companyGUID|是|string|64|所属公司|
|settings/role|是|string|64|角色|
|settings/roleName|是|string|64|角色名称|
|settingsstatus/|是|string|64|状态：<br>0 无效<br>1 有效<br>2 离职|
|attachs|否|jsonArray|N/A|特征项目定义|
|attachs/attachCode|是|string|64|特征编号|
|attachs/attachName|是|string|64|特征名称|
|attachs/value|否|string|64|特征项值|
|attachs/parentCode|是|string|64|父级特征项|
|attachs/remark|否|string|64|备注|
|attachs/state|是|int|4|描摹状态：<br>1有效<br>0无效|
|attachs/keySeq|否|int|10|特征值排序|
|attachs/codeSeq|是|int|10|特征项排序|
|attachs/category|是|string|64|特征分类|
|proxyCompanys|否|jsonArray|N/A|代理公司|
|proxyCompanys/orgGUID|是|string|64|公司GUID|
|proxyCompanys/orgName|是|string|64|公司名称|
|teams|否|jsonArray|N/A|销售团队|
|teams/teamGUID|是|string|64|团队编号|
|teams/teamName|是|string|64|团队名称|
|teams/orgGUID|是|string|64|公司编号|
|teams/projGUID|是|string|64|项目编号|
|teams/status|是|string|64|状态：<br>0=无效<br>1=有效|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.13.	N-NY-15客户跟进通知(notify_cst_followRecord) 
+ **接口说明**
客户状态通知指数据中心客户机会跟进状态通知到案场，包括预约、来电、到访等。
> 消息类型：dc.mq.cst.follow

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
| followGUID	|是	|string|32|跟进编号|
| cstGUID	|是	|string|32|客户ID|
| projGUID	|是	|string|32|项目编号|
| oriProjGUID	|是	|string|32|原始项目编号，即如果存在项目映射配置时，<br>projGUID是转换后的推广项目，<br>oriProjGUID指转换前的项目编号|
| followTime	|是	|string|32|跟进时间:yyyy-MM-dd HH:mm&#58;ss|
| followType	|是	|int|32|跟进类型：<br>1=预约<br>2=来电<br>3=到访<br>4=认筹<br>8=其它<br>33=跟踪<br>34=投诉|
| followContent	|否	|string|32|跟进内容|
| nextFollowTime	|否	|string|32|下次跟进时间*YYYY-MM-dd HH:mm&#58;ss*|
| nextFollowContent	|否	|string|32|下次跟进内容|
| sourceApp	|是	|string|32|系统来源|
| activitySource	|否	|string|32|媒体活动|
| remark	|否	|string|32|备注|
| userGUID	|否|string|32|置业顾问|
| probability	|否	|int|32|成交几率：<br>1=A级<br>2=B级<br>3=C级<br>4=D级|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.14.	N-NY-16客户交易通知(notify_cst_trade)
+ **接口说明**
指数据中心客户交易状态通知到案场，包括交易、交易客户信息。
> 消息类型：dc.mq.sale.trade

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
| tradeGUID|是|string|64|交易GUID|
| roomGUID|是|string|64|房间编号|
| oppGUID|是|string|64|销售机会GUID|
| tradeStatus|是|int|10|最终交易状态：<br>1关闭<br>2激活|
| closeReason|否|string|64|关闭原因|
| orderGUID|否|string|64|认购编号|
| contractGUID|否|string|64|合同编号|
| userGUID|是|string|64|置业顾问|
| cstGUID|是|string|64|客户编号|
| sequence|否|int|10|序号|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.15.	N-NY-17客户认购通知(notify_cst_order) 
+ **接口说明**
指数据中心客户认购通知到案场
> 消息类型：dc.mq.sale.order

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|orderGUID |是|string|64|认购Id|
|buGUID |否|string|64|公司Id|
|projGUID |是|string|64|项目Id|
|tradeGUID |是|string|64|交易Id|
|roomGUID |否|string|64|房间Id|
|lastSaleGUID |否|string|64|上次销售单Id|
|lastSaleType |否|string|64|上次销售单类型|
|qsDate |是|datetime|32|认购日期, 格式为:yyyy-MM-dd HH:mm&#58;ss|
|htTotal |是|float|32|认购总价|
|status |是|int|10|状态：<br>230=认购退房<br>231=认购作废<br>232=认购变更<br>2321 认购变更新增<br>2322 认购变更除名<br>233=认购换房<br>234=认购变价<br>235=认购变更付款方案|
|closeDate |否|datetime|32|关闭日期, 格式为:yyyy-MM-dd HH:mm&#58;ss|
|closeReason |否|string|64|关闭原因|
|userGUID |是|string|64|置业顾问|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.16.	N-NY-18客户签约通知(notify_cst_contract)
+ **接口说明**
指数据中心客户签约通知到案场
> 消息类型：dc.mq.sale.contract

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
| contractGUID|是|string|64|合同Id|
| buGUID|否|string|64|公司Id|
| projGUID|是|string|64|项目Id|
| tradeGUID|是|string|64|交易Id|
| roomGUID|否|string|64|房间Id|
| lastSaleGUID|否|string|64|上次销售单Id|
| lastSaleType|否|string|64|上次销售单类型|
| qsDate|是|string|64|签约日期, 格式为:yyyy-MM-dd HH:mm&#58;ss|
| htTotal|是|string|64|合同总价|
| status|是|string|64|状态：<br>240=签约退房<br>241=签约作废<br>242=签约变更<br>2421 签约变更新增<br>2422 签约变更除名<br>243=签约换房<br>244=签约变价<br>245=签约变更付款方案|
| closeDate|否|string|64|关闭日期, 格式为:yyyy-MM-dd HH:mm&#58;ss|
| closeReason|否|string|64|关闭原因|
| userGUID|是|string|64|置业顾问|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.17.	N-NY-19客户欠款通知(notify_cst_fee)
+ **接口说明**
指数据中心客户欠款通知到案场
> 消息类型：dc.mq.sale.fee

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|feeGUID |是|string|64|应收Id|
|tradeGUID |是|string|64|交易GUID|
|flag |是|int|10|状态标识：<br>1已付<br>2未付|
|itemName |是|string|64|款项名称|
|itemType |是|string|64|款项类型|
|lastDate |是|datetime|32|付款期限, 格式为:yyyy-MM-dd HH:mm&#58;ss|
|rmbAmount |是|float|32|金额|
|rmbDsAmount |否|float|32|多收金额|
|rmbYe |否|float|32|余额|
|sequence |否|int|4|序号|
|userGUID |是|string|64|置业顾问|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.18.	N-NY-20客户回款明细通知(notify_cst_getin) 
+ **接口说明**
指数据中心客户回款明细通知到案场
> 消息类型：dc.mq.sale.getin

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|getinGUID |是|string|64|实收Id|
|status |是|int|4|状态：<br>1有效<br>2作废|
|sequence |否|int|4|序号|
|saleType |否|string|64|销售单类型|
|tradeGUID |是|string|64|交易GUID|
|contractGUID |是|string|64|合同GUID|
|rmbAmount |是|float|32|金额|
|itemType |是|string|64|款项类型|
|itemName |是|string|64|款项名称|
|getForm |是|string|64|支付方式|
|getDate |是|datetime|32|收款日期, 格式为：*yyyy-MM-dd HH:mm&#58;ss*|
|userGUID |是|string|64|置业顾问|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.19.	N-NY-21销售进程通知(notify_cst_saleProcess) 
+ **接口说明**
指数据中心销售进程通知到案场
> 消息类型：dc.mq.sale.process

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
| followGUID|是|string|64|跟进编号|
| tradeGUID|是|string|64|交易编号|
| followTime|是|string|64|跟进时间：*yyyy-MM-dd HH:mm&#58;ss*|
| followType|是|int|64|进程类型：<br>30=已交楼<br>31=产权出证<br>32=已入伙|
| followContent|否|string|64|跟进内容|
| nextFollowTime|否|string|64|下次跟进时间*YYYY-MM-dd HH:mm&#58;ss*|
| sourceApp|是|string|64|系统来源|
| remark|否|string|64|备注|
| userGUID|是|string|64|置业顾问|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.20.	N-NY-22客户描摹通知（notify_cst_attach_v2）
+ **接口说明**
ETL同步历史客户特征描摹和增量同步客户特征描摹，产生客户描摹通知到案场
> 消息类型：dc.mq.cst.attach

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID |是|string|64|客户ID|
|oppGUID |否|string|64|机会编号|
|userGUID |是|string|64|业务员编号|
|attachs |是|jsonArray|N/A|特征列表|
|attachs/scopeGUID |是|string|64|范围对象编号，例如：<br>attachLevel=4,scopeGUID取值为项目编号<br>attachLevel=16,scopeGUID取值为公司编号|
|attachs/attachGUID |是|string|64|特征编号|
|attachs/items |是|jsonArray|N/A|特征项列表|
|attachs/items/itemGUID |否|string|64|候选项编号，当attach的input=1时为空|
|attachs/items/itemCode |是|string|64|两种情况：<br>1、attach的input=1时，取候选项编码 (attachKey)<br>2、否则，则为输入值|
|attachs/items/parentItemGUID |否|string|64|父级特征项编号，attach的input=1时为空|
|attachs/items/remark |否|string|200|备注|
|attachs/items/expireTime |否|datetime|64|过期时间，默认为空，表示永不过期|
|attachs/items/sourceChannel |否|string|16|来源渠道|
+ **请求数据示例**

``` json
{
    "cstGUID": "13333",
    "oppGUID": "xxxx",
    "userGUID": "xxxx",
    "attachs": [
        {
            "attachGUID": "123",
            "scopeGUID": "xxxx",
            "items": [
                {
                    "itemGUID": "111",
                    "itemValue": "10",
                    "parentItemGUID": "",
                    "remark": "",
                    "sourceChannel": "",
                    "expireTime": null
                }
            ]
        }
    ]
}
```
+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.21.	N-NY-23历史数据同步状态通知（notify_request_result）
+ **接口说明**
业务应用提供服务，数据中心进行推送
数据中心同步项目历史数据，并将同步完成状态通知到业务应用
> 消息类型：messageType：dc.mq.sync.request.result

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|taskID|是|string|64|任务编号|
|taskName |是|string|128|任务名称|
|startTime|是|datetime|32|开始时间*YYYY-MM-dd HH:mm&#58;ss*|
|finishTime |是|datetime|32|完成时间*YYYY-MM-dd HH:mm&#58;ss*|
|status|是|int|4|状态：<br>1成功<br>2：失败|
|remark|是|string|100|备注|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.22.	N-NY-24置业顾问状态变更通知（notify_user）
+ **接口说明**
1､ 销售团队新增或更新时，针对团队所在项目触发通知
2､ 置业顾问新增或更新时，针对置顾问所在的所有团队对应的所有项目触发通知
> 消息类型：dc.mq.proj.config.user

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
| userGUID|是|string|64|用户GUID|
| userName|是|string|64|用户名称|
| teamGUID|是|string|64|团队编号|
| projGUID|是|string|64|所属项目|
| attachCode|是|string|64|角色|
| status|是|int|64|置业顾问在这个团队中的状态：<br>0=无效<br>1=有效<br>2=离职|
| statusReason|是|string|64|状态原因|
|mobile |是|string|64|手机号码|
|<font color="red">gender|<font color="red">是|<font color="red">int|<font color="red">4|<font color="red">性别：0：未知，1=男，2=女</font>|
|userStatus |是|int|4|置业顾问状态：<br>0=无效<br>1=有效<br>2=离职|
|loginName |是|string|64|置业顾问登陆名|
+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.23.	N-NY-25项目特征变更通知（notify_proj_attach）
+ **接口说明**
1､ 项目特征定义新增或更新时
2､ 特征定义的预选值新增或更新时 
> 消息类型：dc.mq.proj.config.attach

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|attachs|是|jsonArray|N/A|记录列表|
|attachs/attachGUID|是|string|64|特征编号|
|attachs/attachCode|是|string|64|特征编码，全局唯一<br>10101 经纪人平台<br>10102 地产销售<br>10103 物业<br>20101 业主<br>20102 会员<br>20103 合伙人<br>20104 租客<br>其它见标准定义文档|
|attachs/attachName|是|string|64|特征名称|
|attachs/category|是|int|4|属于哪一类的特征定义，如身份定义、渠道定义、业态定义、<br>途径定义等；<br>10 渠道<br>20 身份<br>30 业态<br>40 客户描摹<br>50 机会描摹<br>60 途径定义<br>70 媒体活动定义<br>|
|attachs/attachLevel|是|int|4|特征级别<br>1 全局系统级<br>2 业态系统级<br>4 项目组织级<br>8 渠道应用级<br>16 公司级<br>|
|attachs/attachType|是|int|4|类型根据分类不同分不同的值表示，如分类值是20,即身份，则type可取值为<br>1 自然人<br>2 机构|
|attachs/scopeGUID|是|string|64|范围对象编号，例如：<br>attachLevel=4,scopeGUID取值为项目编号;<br>attachLevel=16,scopeGUID取值为公司编号;|
|attachs/subGUID|否|string|64|外键subGUID，引用特征描摹定义表b_def_attach(attachGUID),作为特征联动使用。<br>没有则默认不支持|
|attachs/input|是|int|4|输入方式<br>1 手动输入（默认值）<br>2 单选<br>3 多选|
|attachs/showType|否|int|4|显示方式<br>0 二级平面（默认值）<br>1 树状分局|
|attachs/requiredLevel|否|int|4|输入级别：<br>0 否,非必需（默认值）<br>1 是，必填|
|attachs/sequence|否|int|10|特征顺序|
|attachs/items|是|jsonArray|N/A|候选项列表|
|attachs/items/itemGUID|是|string|64|候选项编号|
|attachs/items/itemCode|是|string|64|候选项编码 (attachKey)|
|attachs/items/parentItemGUID|否|string|64|父级特征项编号|
|attachs/items/itemName|是|string|64|候选项名称(label)|
|attachs/items/sequence|否|int|10|候选项的顺序|
|attachs/items/state|是|int|4|状态：<br>1有效<br>0无效|
|attachs/items/expireTime|否|datetime|32|过期时间，默认为空，表示永不过期|
|attachs/items/scopejGUID|是|string|64|范围对象编号，例如：<br>attachLevel=4,scopeGUID取值为项目编号<br>attachLevel=16,scopeGUID取值为公司编号|

+ **响应数据示例**
```  json
{
    "page": 1,
    "pageSize": 1,
    "attachs": [
        {
            "attachGUID": "123",
            "attachCode": "cst_constellation",
            "attachName": "星座",
            "category": "50",
            "attachLevel": 4,
            "attachType": 2,
            "scopeGUID": "xxxx",
            "subGUID": null,
            "input": 2,
            "showType": 0,
            "requiredLevel": 0,
            "sequence":1,
            "items": [
                {
                    "itemGUID": "111",
                    "itemCode": "10",
                    "parentItemGUID": "",
                    "itemName": "水平座",
                    "sequence": 1,
                    "state": 1,
                    "expireTime": null,
                    "scopeGUID": "xxxx"
                },
                {
                    "itemGUID": "112",
                    "itemCode": "11",
                    "parentItemGUID": "",
                    "itemName": "双子座",
                    "sequence": 2,
                    "state": 1,
                    "expireTime": null,
                    "scopeGUID": "xxxx"
                }
            ]
        }
    ]
}
```

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.24.	N-NY-26代理公司信息变更通知（notify_org_list）
+ **接口说明**
代理公司信息变更通知。
> 消息类型：dc.mq.proj.config.org

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
| projGUID|否|string|64|项目编号|
| list|记录存在时必须|jsonArray|64|记录列表|
| list/orgGUID|是|string|64|公司GUID|
| list/orgName|是|string|64|公司名称|
| list/orgShortName|否|string|32|公司简称|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.5.25. N-NY-27销售团队变更通知（notify_team_list）
+ **接口说明**
销售团队变更信息通知。
> 消息类型：dc.mq.proj.config.team

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
| projGUID|否|string|64|项目编号|
| list|记录存在时必须|jsonArray|64|记录列表|
| list/teamGUID|是|string|64|团队编号|
| list/teamName|是|string|64|团队名称|
| list/orgGUID|是|string|64|公司编号|
| list/projGUID|是|string|64|项目编号|
| list/status|是|int|10|状态：<br>0=无效<br>1=有效|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|


###4.5.26. N-NY-28业务客户资料变更通知（notify_proj_cst_update）
+ **接口说明**
业务客户资料变更信息通知。
> 消息类型：dc.mq.project.cst
> 应用方：案场

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|string|64|客户ID|
|cstName|是|string|64|客户姓名|
|gender|是|int|10|性别：<br>1 男<br>2 女<br>3 未知|
|birthDate|否|string|64|生日：*yyyy-MM-dd HH:mm&#58;ss*|
|cstType|是|int|10|客户类型：<br>1 个人<br>2 公司|
|mobileTel|否|string|64|手机|
|officeTel|否|string|64|办公电话|
|homeTel|否|string|64|家庭电话|
|sourceApp|是|string|64|系统来源|
|cardType|否|int|10|证件类型|
|cardID|否|string|128|证件号码|
|userGUID|否|string|64|业务员（新客户是对应登记人、老客户是 对应修改人）|
|address|否|string|64|地址|
|backupTel1|否|string|64|备用号码1|
|backupTel2|否|string|64|备用号码2|
|backupTel3|否|string|64|备用号码3|
|backupTel4|否|string|64|备用号码4|
|corporationPerson|否|string|64|企业法人|
|corporationMobile|否|string|64|法人联系电话|
|firstContact|否|string|64|首选联系人|
|corporationScale|否|string|64|企业规模|
|projGUID|是|string|32|项目编号|
|extRemark|是|string|32|系统来源备注|
|cognizeAve|否|string|64|认知途径|
|fax|否|string|64|传真|
|family|否|string|64|家庭结构<br>0 未知<br>1 三口<br>2 两口<br>3 单身<br>4 三代同堂|
|marriage|否|int|10|婚姻状况<br>0 未知<br>1 未婚<br>2 已婚<br>3 离异<br>4 丧偶|
|workArea|否|string|100|工作区域|
|homeArea|否|string|100|居住区域|
|userCode|是|string|64|置业顾问账号|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

##4.6. 会员类接口
###4.6.1.	G-ME-01客户投诉查询（member_complaint_list）
+ **接口说明**
1､ 通过回执上报的投诉不再抽取
2､ 增加投诉回执上报，由会员系统上报后结抽取要过滤的记录ID
3、增加按组织过滤字段，同一组织内已上报的过滤不再抽，如果是集团级，可再次抽
 > 应用方：会员系统
 
+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
| complaintType|是|string|32|待回访类型，可取值为：交房、签约、精装、投诉|
| projGUID|是|string|64|项目编号|
| count|是|int|10|抽取条数，最大9999|
| percent|是|int|10|抽取比率,百分数：0~100|
| startTime|是|datetime|32|开始时间, 格式为:YYYY-MM-dd|
| endTime|是|datetime|32|结束时间, 格式为:YYYY-MM-dd|
| filterOrg|否|string|64|过滤组织，即对应组织下的已抽取的投诉是否过滤|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|complaintList|是|array||信息列表，json数组|
|complaintGUID|是|string|64|投诉记录的GUID|
|roomCode|是|string|64|房号|
|phone|是|string|32|电话|
|cstGUID|是|string|32|客户编号|
|cstName|是|string|32|客户名称|
|complaintNature|是|string|32|投诉性质，保留原始值|
|operDate|是|datetime|32|操作日期（投诉，交房，签约，售后等）,格式为:YYYY-MM-dd|
|complaintContent|是|string|200|投诉简介|



###4.6.2.	P-ME-02客户回执上报（member_complaint_create）
+ **接口说明**
会员系统按组织上报已抽取的投诉，后续抽取时不再抽取
 > 应用方：会员系统
 
+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
| orgGUID|是|string|64|项目编号|
| complaintGUIDs|是|jsonArray|N/A|最多2000|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

###4.6.3.	P-ME-03会员资料修改(member_update)
+ **接口说明**
调用数据服务修改会员表
 > 应用方：会员系统
+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
| memGUID| 	是	| string|64	| 会员GUID| 
| cstGUID| 	是	|  string|64		| 客户GUID| 
| buGUID| 	否	|  string|64		| 单位GUID| 
| memCode| 	否	|  string|64		| 会员卡号| 
| logpwd	| 否| 	 string|64		| 查询密码| 
| memStation	| 否	|  string|64		| 会员身份| 
| specialType	| 否	|  string|64		| 特殊人士类别| 
| joinPath	| 否	|  string|64		| 入会途径| 
| joinDate	| 否	| datetime| 32|	入会日期| 
| isSendJoinNote| 	否| 	int|4	| 是否发送入会通知| 
| ljPoint	| 否| 	double|32| 	累计积分| 
| applyDate| 	否| 	datetime| 32|	申请日期| 
| shr	| 否	|  string|64		| 入会审核人| 
| shDate	| 否	| datetime| 32|	入会审核日期| 
| cardStatus| 	否| 	 string|64		| 制卡状态| 
| makeCardReason	| 否	|  string|128	| 制卡原因| 
| postCardDate| 	否	| datetime|32	| 寄卡日期| 
| tjr	| 否	| string|64		| 推荐人| 
| tjrMemCode	| 否	|  string|64		| 推荐人会员卡号| 
| tjrRelation| 	否| 	 string|64		| 推荐人与会员关系| 
| tjRemark	| 否| 	 string|256		| 推荐信息备注| 
| projName| 	否| 	 string|64		| 项目名称| 
| xckID	| 否| 	 string|64		| 携程卡号| 
| xckPwd	| 否| 	 string|64	| 	携程密码| 
| saler	| 否	| string|64		| 销售代表| 
| getMemLevelWay	| 否	| string|64		| 获得级别方式| 
| holdLevelBeginDate	| 否	| datetime|32	| 级别权益起始日期| 
| holdLevelEndDate	| 否| 	datetime|32	| 级别权益截止日期| 
| oldMemCode	| 否	| string|64	| 原系统会员卡号| 
| makeCardDate| 	否 |	datetime|64	| 制卡日期| 
| memLevel	| 否	|  string|64		| 当前会员级别| 
| maxMemLevel	| 否	|  string|64		| 历史最高会员级别| 
| memStatus	| 否	| int	| 10|会员状态| 
| statusDate	|	否	| datetime|64	| 状态日期| 
| statusReason	|	否| 	 string|512	| 	状态原因| 
| statusHr	| 否	|  string|64	| 	状态人力资源| 
| oldStatus| 	否	|  string|64	| 	旧状态| 
| telList	| 否	|  string|256		| 电话列表| 

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

#5. 错误码定义

##5.1. 系统错误码

| 错误码|描述|
| :---    | :----|
| 0   |成功|
| -1   |未知错误|
| 1001   |成缺少必须参数|
| 1002   |参数类型错误|
| 1003   |不支持的请求方式|
| 1004   |请求数据格式错误|
| 1005   |系统处理失败|
| 1006   |请求数据过大|
| 1007   |请求数据缺失|
| 1008   |不支持的接口请求|
| 1009   |接入验证失败|
| 1010   |接口权限验证失败|
| 1011   |未知业务应用|
| 1012   |查询的记录不存在|
| 1013   |消息序列号重复|
| 1014   |响应返回数据格式错误|
| 1015   |消息序列号格式错误|
| 1016   |没有操作该项目的权限|
| 1017   |不支持的消息协议版本|
| 1018   |通信消息被非法篡改|
| 1019   |不支持的数据服务接口|
| 1020   |不支持的content-type|
| 1021   |调用数据服务接口失败|
| 1022  |调用EAS服务接口失败|

##5.2. 业务错误码
业务错误码包含系统外的所有错误码，其中客户信息相关的错误码为2xxx段，销售类相关的错误码为3xxx段，基础数据错误码为4xxx段，推送通知类6xxx段，各业务可通用错误码为9xxx段。
- 客户类错误码

| 错误码|描述|
| :---    | :----|
| 2001   |客户不存在|
| 2002   |客户已经存在|
| 2003   |手机号码已被占用|
| 2004   |证件号码已被占用|
| 2005   |加锁失败[该客户已被加锁]|
| 2006   |解锁失败|
| 2007   |修改失败[该客户存在认购或者签约]|

- 销售类错误码

| 错误码|描述|
| :---    | :----|
|3001  |预约不存在|
|3002  |线索不存在|
|3003  |机会不存在|
|3004  |机会已经存在|

- 基础数据类错误码

| 错误码|描述|
| :---    | :----|
|4001  |项目不存在|
|4002  |置业顾问不存在|
|4003  |置业顾问已经存在|
|4004  |代理公司已经存在|
|4005  |代理公司不存在|
|4006  |指定项目没有开通|
|4007  |经纪人不存在|
|4008  |经纪人已经存在|
|4009  |经纪人身份不明|

- 推送通知类错误码

| 错误码|描述|
| :---    | :----|
|6001  |消息推送失败|

- 业务通用错误码

| 错误码|描述|
| :---    | :----|
|9001  |非法身份证号码|
|9002  |非法手机号码|
