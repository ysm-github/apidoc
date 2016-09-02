**富力地产开放接口规范说明书**
-----------
### 变更记录
| 版本号      |    修改原因/内容 | 修改人  | 修改时间  |
| -------- | ------------- : | -----: | -----: |
| V1.0		| 初稿 			|  余世明   |2015/11/13|
| v1.1		| 增量了接口说明：明确了协议双方通信方向的定义 			|  余世明   |2015/12/2|
| V1.2		| 分页查询去掉了时间过滤条件 			|  余世明   |2015/12/8|
| V1.3		| 销售进程类接口、客户汇聚类接口、通知推送类接口在userGUID基础上新增userCode字段 			|  余世明   |2015/12/9|
| V1.4		| P-CU-01客户资料新增、P-CU-02客户资料更新接口，新增projGUID字段 			|  余世明   |2015/12/14|
| V1.5		| N-NY-03客户交易通知更新，删除contractGUID、userGUID字段。交易客户列表tradeCst改成单个多次发送			|  胡旭红   |2015/12/25|
| V1.6		| G-BA-03房产查询（room_query）floorNo和unitNo字段改成非必须 			|  胡旭红   |2015/12/28|
| V1.7		| N-NY-03 notify_cst_trade 通知：sequence字段改成非必须 <br> N-NY-04 notify_cst_order 通知：lastSaleType字段改成非必须 <br> N-NY-05 notify_cst_contract 通知：lastSaleType字段改成非必须 			|  胡旭红   |2016/01/27|
| V1.8		| N-NY-06 notify_cst_fee 通知：<br>rmbDsAmount字段改成非必须 <br> rmbYe字段改成非必须 <br> 增加rmbRealAmount 实收金额字段			|  胡旭红   |2016/01/27|
| V1.9		| N-NY-06 notify_cst_fee 通知：<br> sequence字段改成非必须 <br> N-NY-07 notify_cst_getin 通知：<br>sequence、itemType、getForm字段改成非必须			|  胡旭红   |2016/01/27|
| V2.0		| [N-NY-01 notify_cst_update 客户变更通知](#4.4.1.	N-NY-01客户变更通知（notify_cst_update）)：<br>对应消息类型由dc.mq.project.cst改成dc.mq.cst.update			|  胡旭红   |2016/02/19|
| V2.1		| 增加[4.1.5.	P-BA-15请求历史数据同步（sync_request）](#4.1.5.	P-BA-15请求历史数据同步（sync_request）)接口<br>增加[4.4.8.	N-NY-23历史数据同步状态通知（notify_request_result）](#4.4.8.	N-NY-23历史数据同步状态通知（notify_request_result）)通知			|  胡旭红   |2016/02/20|
| V2.2		| [N-NY-01 notify_cst_update 客户变更通知](#4.4.1.	N-NY-01客户变更通知（notify_cst_update）)<br>[P-CU-02客户资料更新(cst_info_update)](#4.3.2.    P-CU-02客户资料更新（cst_info_update）)<br>[P-CU-01客户资料新增(cst_info_create)](#4.3.1.    P-CU-01客户资料新增（cst_info_create）)<br>cognizeAve 认知途径类型改成String			|  胡旭红   |2016/03/04|
| V2.3		| [P-SA-03跟进上报(sale_followRecord_create)](#4.2.3.    P-SA-03跟进上报（sale_followRecord_create）)<br>[N-NY-02客户机会跟进通知(notify_cst_followRecord)](#4.4.2.    N-NY-02客户机会跟进通知（notify_cst_followRecord）)<br>的followType字段增加，8：其它			|  胡旭红   |2016/03/17|
| V2.4		| 1、[4.4.3. N-NY-03客户交易通知(notify_cst_trade)](#4.4.3.	N-NY-03客户交易通知（notify_cst_trade）)<br>tradeStatus 最终交易状态 改为int，（1关闭 2激活）<br>2、[4.4.4. N-NY-04客户认购通知(notify_cst_order)](#4.4.4.	N-NY-04客户认购通知（notify_cst_order）)<br>status 状态 改为 int <br>5 认购<br>230 认购退房<br>231 认购作废<br>232 认购变更<br>233 认购换房<br>234 认购变价<br>235 认购变更付款方案<br>3、[4.4.5. N-NY-05客户签约通知(notify_cst_contract)](#4.4.5.	N-NY-05客户签约通知（notify_cst_contract）)<br>status	状态 改为int<br>6 签约<br>240 签约退房<br>241 签约作废<br>242 签约变更<br>243 签约换房<br>244 签约变价<br>245 签约变更付款方案<br>4、[4.4.6. N-NY-06客户欠款通知(notify_cst_fee)](#4.4.6.	N-NY-06客户欠款通知（notify_cst_fee）)<br>flag 改为int<br>0 新建<br>1 催款中<br>2 已缴清<br>3 延期<br>5、[4.4.7. N-NY-07客户回款通知(notify_cst_getin)](#4.4.7.	N-NY-07客户回款通知（notify_cst_getin）)<br>status 是否必须改为 否|  胡旭红   |2016/03/28|
| V2.5		| [4.4.6.	N-NY-06客户欠款通知（notify_cst_fee）](#4.4.6.	N-NY-06客户欠款通知（notify_cst_fee）)<br>lastDate字段描述改为应收日期<br>itemType字段String改成int<br>款项类型增加描述（1=房贷 2=非房贷房款 3=物业费 4=代收费，如税款、水电费等）|  胡旭红   |2016/03/29|
| V2.6    | [4.3.1. P-CU-01客户资料新增（cst_info_create）](#4.3.1. P-CU-01客户资料新增（cst_info_create）)<br>响应参数说明中加cstName，gender等字段。<br>删除接口--N-NY-23历史数据同步状态通知和 P-BA-15请求历史数据同步（sync_request）</br>|刘海军|2016/05/19|




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


##开放接口
###基础资源类接口
####4.1.1.	G-BA-01项目查询（project_query）
+ **接口说明**
数据中心作为服务端，云客主动拉取。
分页查询所有项目信息。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|page|是|int|4|页码，不填默认为1|
|pageSize|是|int|4|分页大小，取值范围是［10，1000］，不填默认10|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|totalPage|是|int|4|记录总页数|
|page|是|int|4|本次查询页码|
|list|存在时必须|array||记录列表|
|list/projGUID|是|String|64|项目GUID|
|list/projCode|是|String|64|项目全代码|
|list/projName|是|String|64|项目名称|
|list/parentCode|是|String|64|父级代码|
|list/level|是|int|2|项目级数<br>2：一级项目<br>3：分期项目|
|list/buGUID|是|String|64|单位GUID|
|list/ifEnd|是|int|2|是否最末级项目<br>0：否<br>1：是|
|list/modifyTime|否|datetime|32|修改时间, 格式为:yyyy-MM-dd HH:mm&#58;ss|

####4.1.2.	G-BA-02置业顾问查询（user_query）
+ **接口说明**
数据中心作为服务端，云客应用主动拉取。
分页查询所有置业顾问信息。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|page|是|int|4|页码，不填默认为1|
|pageSize|是|int|4|分页大小，取值范围是［10，1000］，不填默认10|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|totalPage|是|int|4|记录总页数|
|page|是|int|4|本次查询页码|
|list|存在时必须|array||记录列表|
|list/userGUID|是|String|64|用户编号|
|list/userCode|是|String|64|用户账号|
|list/userName|是|String|64|用户名称|
|list/mobileTel|是|String|32|联系电话|
|list/modifyTime|否|datetime|32|修改时间, 格式为:yyyy-MM-dd HH:mm&#58;ss|

####4.1.3.	G-BA-03房产查询（room_query）
+ **接口说明**
数据中心作为服务端，云客应用主动拉取。
分页查询所有房产信息。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|page|是|int|4|页码，不填默认为1|
|pageSize|是|int|4|分页大小，取值范围是［10，1000］，不填默认10|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|totalPage|是|int|4|记录总页数|
|page|是|int|4|本次查询页码|
|list|存在时必须|array||记录列表|
|list/roomGUID|是|String|64|房间GUID|
|list/projGUID|是|String|64|项目GUID|
|list/bldGUID|是|String|64|楼栋GUID|
|list/floor|是|String|10|楼层|
|list/floorNo|否|int|4|实际楼层序号|
|list/unit|是|String|10|单元|
|list/unitNo|否|int|4|单元序号|
|list/no|是|String|10|号码|
|list/room|是|String|20|房号|
|list/roomInfo|是|String|250|房间全名|
|list/status|是|int|10|销售状态<br>0：待售<br>1：已认购<br>2：已签约<br>3：已交楼<br>4：产权出证<br>6：已入伙<br>7：停售|
|list/isPreControl|是|int|4|是否预销控<br>1：是<br>0：否|
|list/huxing|是|String|10|户型|
|list/roomStru|是|String|30|房间结构|
|list/west|是|String|20|朝向|
|list/bldArea|是|float|64|建筑面积|
|list/tnArea|是|float|64|套内面积|
|list/price|是|float|64|建筑单价|
|list/tnPrice|是|float|64|套内单价|
|list/total|是|float|64|标准总价|
|list/modifyTime|是|datetime|32|修改时间, 格式为:yyyy-MM-dd HH:mm&#58;ss|

####4.1.4.	G-BA-04楼栋查询（building_query）
+ **接口说明**
数据中心作为服务端，云客应用主动拉取。
分页查询所有楼栋信息

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|page|是|int|4|页码，不填默认为1|
|pageSize|是|int|4|分页大小，取值范围是［10，1000］，不填默认10|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|totalPage|是|int|4|记录总页数|
|page|是|int|4|本次查询页码|
|list|存在时必须|array||记录列表|
|list/projGUID|是|String|64|项目GUID|
|list/bldGUID|是|String|64|楼栋GUID|
|list/bldCode|是|String|30|楼栋编码|
|list/bldName|是|String|30|楼栋名称|
|list/parentCode|是|String|60|父级编码|
|list/bldFullName|是|String|200|楼栋全称|
|list/modifyTime|否|datetime|32|修改时间, 格式为:yyyy-MM-dd HH:mm&#58;ss|



###销售进程类接口
####4.2.1.	P-SA-01机会新增(sale_opp_create)
+ **接口说明**
数据中心作为服务端，云客应用主动上报。	
新增销售机会

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|projGUID|是|String|64|项目Id|
|cstGUID|是|String|64|客户Id|
|homeArea|否|String|256|居住区域|
|buyPurpose|否|int|4|购房用途<br>0	其它<br>10	投资<br>20	自住（首次）<br>30	自住（改善）<br>40	婚房<br>50	度假<br>60	养老<br>70	父母养老<br>80	方便工作<br>90	方便读书|
|huxingIntent|否|int|4|意向户型<br>0:	不限 <br>10:	一居室 <br>20:	二居室 <br>30：	三居室 <br>40：	四居室 <br>50：	五居以上|
|roomAreaIntent|否|int|4|意向面积<br>0：不限 <br>10： 50平米以下 <br>20： 50-70平米 <br>30： 70-90平米 <br>40： 90-110平米 <br>50： 110-130平米 <br>60： 130-150平米 <br>70： 150-200平米 <br>80： 200-300平米 <br>90： 300平米以上|
|createdOn|是|datetime|32|创建时间，格式为:yyyy-MM-dd HH:mm&#58;ss|
|status|否|int|4|机会状态<br>0=新增(默认值)<br>101=关闭<br>102=激活<br>103=逾期流失<br>104=人工流失|
|statusReason|否|String|64|状态原因|
|userGUID|否|String|64|置业顾问编号|
|userCode|是|String|64|置业顾问账号|
|oppSource|否|String|100|机会来源|
|topic|否|String|64|机会主题|
|liveStatus|否|int|4|居住状态<br>0	未知<br>10	租房<br>20	自购住房<br>30	与父母同住|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|oppGUID|是|String|64|机会编号|


####4.2.2.	P-SA-02机会更新上报(sale_opp_update)
+ **接口说明**
数据中心作为服务端，云客应用主动上报。
更新销售机会

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|oppGUID|是|String|64|机会编号|
|projGUID|是|String|64|项目Id|
|cstGUID|是|String|64|客户Id|
|homeArea|否|String|256|居住区域|
|buyPurpose|否|int|4|购房用途<br>0	其它<br>10	投资<br>20	自住（首次）<br>30	自住（改善）<br>40	婚房<br>50	度假<br>60	养老<br>70	父母养老<br>80	方便工作<br>90	方便读书|
|huxingIntent|否|int|4|意向户型<br>0:	不限 <br>10:	一居室 <br>20:	二居室 <br>30：	三居室 <br>40：	四居室 <br>50：	五居以上|
|roomAreaIntent|否|int|4|意向面积<br>0：不限 <br>10： 50平米以下 <br>20： 50-70平米 <br>30： 70-90平米 <br>40： 90-110平米 <br>50： 110-130平米 <br>60： 130-150平米 <br>70： 150-200平米 <br>80： 200-300平米 <br>90： 300平米以上|
|createdOn|是|datetime|32|创建时间，格式为:yyyy-MM-dd HH:mm&#58;ss|
|status|否|int|4|机会状态<br>0=新增(默认值)<br>101=关闭<br>102=激活<br>103=逾期流失<br>104=人工流失|
|statusReason|否|String|64|状态原因|
|userGUID|否|String|64|置业顾问编号|
|userCode|是|String|64|置业顾问账号|
|oppSource|否|String|100|机会来源|
|topic|否|String|64|机会主题|
|liveStatus|否|int|4|居住状态<br>0	未知<br>10	租房<br>20	自购住房<br>30	与父母同住|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|

####4.2.3.	P-SA-03跟进上报（sale_followRecord_create）
+ **接口说明**
数据中心作为服务端，云客应用主动上报。
跟进上报

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|String|20|客户编号|
|projGUID|是|String|64|项目编号|
|followTime|是|String|32|跟进时间, 格式为:yyyy-MM-dd HH:mm&#58;ss|
|followContent|是|String|mediumtext|跟进内容|
|followType|是|int|2|跟进阶段：<br>1=预约<br>2=来电<br>3=到访<br>8=其他|
|userGUID|否|String|64|跟进人的ID（置业顾问）|
|userCode|是|String|64|置业顾问账号|
|oppGUID|是|String|64|机会编号|
|gjfs|是|String|100|跟进方式|
|nextDate|否|String|40|下次跟进时间，格式为:yyyy-MM-dd HH:mm&#58;ss|

+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|followGUID|是|String|64|跟进记录编号|

###客户汇聚类接口
####4.3.1.	P-CU-01客户资料新增（cst_info_create）
+ **接口说明**
1、新增存在的客户，返回存在的客户ID、客户详细资料。 
2、同时开放接口触发通知消息，查询历史数据（跟进、交易、认购、签约、欠款、回款）按先后顺序下行推送到云客，通知消息推送时间距离本次请求应答时间间隔默认1分钟（可配）。（云客只需新增存在客户时，使用数据中心返回客户资料更新本地客户即可）。
3、如果NC和云客同时录入客户资料，由于数据同步NC时差，可能出现该客户在NC已经存在，但在数据中心不存在，此时接口返回异常错误码2010(客户数据未同步)
4、判定规则：a)新增客户以项目+手机号码为判定规则，手机号码一致判定为重复客户。
b)当根据项目+手机号码匹配NC存在多个客户记录时，接口返回存在交易的客户；如果多个客户都未存在交易，随机返回其中一个客户即可。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstName|是|String|64|客户姓名|
|gender|是|int|2|性别 1 男 2女|
|birthDate|否|String|32|生日,格式为:yyyy-MM-dd|
|cstType|是|int|2|客户类型<br>1：个人<br>2：公司|
|homeArea|否|String|100|居住区域|
|workArea|否|String|100|工作区域|
|marriage|否|int|4|婚姻状况<br>0	未知<br>1	未婚<br>2	已婚<br>3	离异<br>4	丧偶|
|family|否|int|4|家庭结构<br>0 未知<br>1 三口<br>2 两口<br>3 单身<br>4 三代同堂|
|mobileTel|是|String|32|手机|
|officeTel|否|String|32|办公电话|
|homeTel|否|String|32|家庭电话|
|fax|否|String|32|传真|
|cognizeAve|否|String|64|认知途径|
|cardType|否|int|4|证件类型：<br>1 身份证<br>2 军官证<br>3 护照<br>4 港澳通行证<br>5 台湾通行证<br>6 台湾身份证<br>7 港澳身份证<br>8 营业执照<br>9 组织机构码<br>10 税务登记证<br>9999 其他|
|cardId|否|String|64|证件号码|
|userGUID|否|String|64|置业顾问编号|
|userCode|是|String|64|置业顾问账号|
|address|否|String|150|联系地址|
|projGUID|是|String|64|项目编号|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|String|64|客户编号|
|cstName|是|String|64|客户姓名,错误码是2002，客户存在返回。|
|gender|是|int|2|性别 1 男 2女,错误码是2002，客户存在返回。|
|birthDate|否|String|32|生日,格式为:yyyy-MM-dd,错误码是2002，客户存在返回。|
|cstType|是|int|2|客户类型<br>1：个人<br>2：公司,错误码是2002，客户存在返回。|
|homeArea|否|String|100|居住区域,错误码是2002，客户存在返回。|
|workArea|否|String|100|工作区域,错误码是2002，客户存在返回。|
|marriage|否|int|4|婚姻状况<br>0	未知<br>1	未婚<br>2	已婚<br>3	离异<br>4	丧偶,错误码是2002，客户存在返回。|
|family|否|int|4|家庭结构<br>0 未知<br>1 三口<br>2 两口<br>3 单身<br>4 三代同堂,错误码是2002，客户存在返回。|
|mobileTel|是|String|32|手机,错误码是2002，客户存在返回。|
|officeTel|否|String|32|办公电话,错误码是2002，客户存在返回。|
|homeTel|否|String|32|家庭电话,错误码是2002，客户存在返回。|
|fax|否|String|32|传真,错误码是2002，客户存在返回。|
|cognizeAve|否|String|64|认知途径,错误码是2002，客户存在返回。|
|cardType|否|int|4|证件类型：<br>1 身份证<br>2 军官证<br>3 护照<br>4 港澳通行证<br>5 台湾通行证<br>6 台湾身份证<br>7 港澳身份证<br>8 营业执照<br>9 组织机构码<br>10 税务登记证<br>9999 其他,错误码是2002，客户存在返回。|
|cardId|否|String|64|证件号码,错误码是2002，客户存在返回。|
|userGUID|否|String|64|置业顾问编号,错误码是2002，客户存在返回。|
|userCode|是|String|64|置业顾问账号,错误码是2002，客户存在返回。|
|address|否|String|150|联系地址,错误码是2002，客户存在返回。|
|projGUID|是|String|64|项目编号,错误码是2002，客户存在返回。|

####4.3.2.	P-CU-02客户资料更新（cst_info_update）
+ **接口说明**
数据中心作为服务端，云客应用主动上报
1、修改客户信息上报数据中心。
2、如果客户存在交易，返回错误码2011(禁止修改交易客户资料)，不更新数据中心客户资料。         

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|String|64|客户编号|
|cstName|是|String|64|客户姓名|
|gender|是|int|2|性别 1 男 2女|
|birthDate|否|String|32|生日,格式为:yyyy-MM-dd|
|cstType|是|int|2|客户类型1：个人2：公司|
|homeArea|否|String|100|居住区域|
|workArea|否|String|100|工作区域|
|marriage|否|int|4|婚姻状况<br>0	未知<br>1	未婚<br>2	已婚<br>3	离异<br>4	丧偶|
|family|否|int|4|家庭结构<br>0 未知<br>1 三口<br>2 两口<br>3 单身<br>4 三代同堂|
|mobileTel|是|String|32|手机|
|officeTel|否|String|32|办公电话|
|homeTel|否|String|32|家庭电话|
|fax|否|String|32|传真|
|cognizeAve|否|String|64|认知途径|
|cardType|否|int|4|证件类型：<br>1 身份证<br>2 军官证<br>3 护照<br>4 港澳通行证<br>5 台湾通行证<br>6 台湾身份证<br>7 港澳身份证<br>8 营业执照<br>9 组织机构码<br>10 税务登记证<br>9999 其他|
|cardId|否|String|64|证件号码|
|userGUID|否|String|64|置业顾问编号|
|userCode|是|String|64|置业顾问账号|
|address|否|String|150|联系地址|
|projGUID|是|String|64|项目编号|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|

###通知推送类接口
####4.4.1.	N-NY-01客户变更通知（notify_cst_update）
+ **接口说明**
云客应用作为服务端，数据中心主动上报。
数据中心同步客户资料变更包括新增和修改，如果是更新则只有当基本信息发生更新时才通知，即姓名、性别、生日、手机（包括家话电话和办公电话）、客户类型发生更新时才通知
> 消息类型：<font color="red">dc.mq.cst.update</font>

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。


+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|cstGUID|是|String|64|客户编号|
|cstName|是|String|64|客户姓名|
|gender|是|int|2|性别 1 男 2女|
|birthDate|否|String|32|生日,格式为:yyyy-MM-dd|
|cstType|是|int|2|客户类型1：个人2：公司|
|homeArea|否|String|100|居住区域|
|workArea|否|String|100|工作区域|
|marriage|否|int|2|婚姻状况<br>0	未知<br>1	未婚<br>2	已婚<br>3	离异<br>4	丧偶|
|family|否|int|4|家庭结构<br>1 三口<br>2 两口<br>3 单身<br>4 三代同堂|
|mobileTel|是|String|32|手机|
|officeTel|否|String|32|办公电话|
|homeTel|否|String|32|家庭电话|
|fax|否|String|32|传真|
|cognizeAve|否|String|64|认知途径|
|cardType|否|int|4|证件类型：<br>1 身份证<br>2 军官证<br>3 护照<br>4 港澳通行证<br>5 台湾通行证<br>6 台湾身份证<br>7 港澳身份证<br>8 营业执照<br>9 组织机构码<br>10 税务登记证<br>9999 其他|
|cardId|否|String|64|证件号码|
|userGUID|否|String|64|置业顾问编号|
|userCode|是|String|64|置业顾问账号|
|address|否|String|150|联系地址|
|projGUID|是|String|64|项目编号|

####4.4.2.	N-NY-02客户机会跟进通知（notify_cst_followRecord）
+ **接口说明**
云客应用作为服务端，数据中心主动上报。
客户状态通知指数据中心客户机会跟进状态通知到云客，包括预约、来电、到访。
> 消息类型：dc.mq.cst.follow

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|followGUID|是|String|64|跟进记录编号|
|cstGUID|是|String|20|客户编号|
|projGUID|是|String|64|项目编号|
|followTime|是|String|32|跟进时间, 格式为:yyyy-MM-dd HH:mm&#58;ss|
|followContent|是|String|mediumtext|跟进内容|
|followType|是|int|4|跟进阶段：<br>1=预约<br>2=来电<br>3=到访<br>8=其他|
|userGUID|否|String|64|跟进人的ID（置业顾问）|
|userCode|是|String|64|置业顾问账号|
|oppGUID|是|String|64|机会编号|
|gjfs|是|String|100|跟进方式|
|nextDate|否|String|40|下次跟进时间，格式为:yyyy-MM-dd HH:mm&#58;ss|

####4.4.3.	N-NY-03客户交易通知（notify_cst_trade）
+ **接口说明**
云客应用作为服务端，数据中心主动上报。
指数据中心客户交易状态通知到云客，包括交易、交易客户信息。
> 消息类型：dc.mq.sale.trade

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|tradeGUID|是|String|64|交易GUID|
|roomGUID|是|String|64|房间编号|
|oppGUID|否|String|64|销售机会GUID|
|tradeStatus|是|int|10|1关闭 2激活|
|closeReason|否|String|30|关闭原因|
|userGUID|否|String|64|置业顾问|
|userCode|是|String|64|置业顾问账号|
|cstGUID|是|String|64|客户编号|
|sequence|否|int|4|序号|

####4.4.4.	N-NY-04客户认购通知（notify_cst_order）
+ **接口说明**
云客应用作为服务端，数据中心主动上报。
指数据中心客户认购通知到云客
> 消息类型：dc.mq.sale.order

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|orderGUID|是|String|64|认购Id|
|buGUID|是|String|64|公司Id|
|projGUID|是|String|64|项目Id|
|tradeGUID|是|String|10|交易Id|
|roomGUID|是|String|30|房间Id|
|lastSaleGUID|否|String|64|上次销售单Id|
|lastSaleType|否|String|10|上次销售单类型|
|qsDate|是|datetime|64|认购日期, 格式为:yyyy-MM-dd HH:mm&#58;ss|
|htTotal|是|float|64|认购总价|
|status|是|int|10|状态<br>5 认购<br>230 认购退房<br>231 认购作废<br>232 认购变更<br>233 认购换房<br>234 认购变价<br>235 认购变更付款方案|
|closeDate|否|datetime|32|关闭日期, 格式为:yyyy-MM-dd HH:mm&#58;ss|
|closeReason|否|String|30|关闭原因|
|userGUID|否|String|64|置业顾问|
|userCode|是|String|64|置业顾问账号|
	

####4.4.5.	N-NY-05客户签约通知（notify_cst_contract）
+ **接口说明**
云客应用作为服务端，数据中心主动上报。
指数据中心客户签约通知到云客
> 消息类型：dc.mq.sale.Contract

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|contractGUID|是|String|64|合同Id|
|buGUID|是|String|64|公司Id|
|projGUID|是|String|64|项目Id|
|tradeGUID|是|String|10|交易Id|
|roomGUID|是|String|30|房间Id|
|lastSaleGUID|否|String|64|上次销售单Id|
|lastSaleType|否|String|10|上次销售单类型|
|qsDate|是|datetime|32|签约日期, 格式为:yyyy-MM-dd HH:mm&#58;ss|
|htTotal|是|float|64|合同总价|
|status|是|int|10|状态<br>6 签约<br>240 签约退房<br>241 签约作废<br>242 签约变更<br>243 签约换房<br>244 签约变价<br>245 签约变更付款方案
|
|closeDate|否|datetime|32|关闭日期, 格式为:yyyy-MM-dd HH:mm&#58;ss|
|closeReason|否|String|30|关闭原因|
|userGUID|否|String|64|置业顾问|
|userCode|是|String|64|置业顾问账号|

####4.4.6.	N-NY-06客户欠款通知（notify_cst_fee）
+ **接口说明**
云客应用作为服务端，数据中心主动上报。
指数据中心客户欠款通知到云客
> 消息类型：dc.mq.sale.fee

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|feeGUID|是|String|64|应收Id|
|flag|是|int|10|状态标识<br>0 新建<br>1 催款中<br>2 已缴清<br>3 延期|
|itemName|是|String|30|款项名称|
|itemType|是|int|10|款项类型<br>1=房贷 <br>2=非房贷房款 <br>3=物业费 <br>4=代收费，如税款、水电费等|
|lastDate|是|datetime|32|应收日期, 格式为:yyyy-MM-dd HH:mm&#58;ss|
|rmbAmount|是|float|64|金额|
|rmbDsAmount|否|float|64|多收金额|
|rmbYe|否|float|64|余额|
|sequence|否|int|4|序号|
|tradeGUID|是|String|64|交易GUID|
|userGUID|否|String|64|置业顾问|
|userCode|是|String|64|置业顾问账号|
|rmbRealAmount|是|float|64|实收金额 |


####4.4.7.	N-NY-07客户回款通知（notify_cst_getin）
+ **接口说明**
云客应用作为服务端，数据中心主动上报。
指数据中心客户回款通知到云客
> 消息类型：dc.mq.sale.getin

+ **数据流**
通知消息由数据服务模块产生，由service-message下发。

+ **请求参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|getinGUID|是|String|64|实收Id|
|status|否|String|10|状态(暂不处理)|
|sequence|否|int|4|序号|
|saleType|是|String|10|销售单类型|
|tradeGUID|是|String|64|交易GUID|
|rmbAmount|是|float|64|金额|
|itemType|否|String|20|款项类型|
|itemName|是|String|30|款项名称|
|getForm|否|String|10|支付方式|
|getDate|是|datetime|32|收款日期, 格式为:yyyy-MM-dd HH:mm&#58;ss|
|userGUID|否|String|64|置业顾问|
|userCode|是|String|64|置业顾问账号|


+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|--:|
|errcode|是|int|10|错误码|
|errmsg|是|string|100|错误描述|

##错误码定义
###系统错误码
| 错误码	|描述	|
| :-------- | :--------|
|0|成功|
|-1|未知错误|
|1001|缺少必须参数[%s]|
|1002|参数类型错误[%s]|
|1003|不支持的请求方式|
|1004|请求数据格式错误|
|1005|系统处理失败|
|1006|请求数据过大|
|1007|请求数据缺失|
|1008|不支持的接口请求|
|1009|接入验证失败|
|1010|接口权限验证失败|
|1011|未知业务应用|
|1012|查询的记录不存在|
|1013|消息序列号重复|
|1014|响应返回数据格式错误|
|1015|消息序列号格式错误|
|1016|没有操作该项目的权限|
|1017|不支持的消息协议版本|
|1018|通信消息被非法篡改|
|1019|不支持的数据服务接口|
|1020|不支持的content-type|
|1021|调用数据服务接口失败|
###业务错误码

业务错误码包含系统外的所有错误码，其中客户信息相关的错误码为2xxx段，基础数据错误码为4xxx段，推送通知类6xxx段，各业务可通用错误码为9xxx段。


#####客户类错误码
| 错误码	|描述	|
| :-------- | :--------|
|2001|客户不存在|
|2002|客户已经存在|
|2003|手机号码已被占用|
|2004|证件号码已被占用|
|2005|加锁失败[该客户已被加锁]|
|2006|解锁失败|
|2007|修改失败[该客户存在认购或者签约]|


#####销售类错误码
| 错误码	|描述	|
| :-------- | :--------|
|3001|预约不存在|
|3002|线索不存在|
|3003|机会不存在|
|3004|机会已经存在|


#####基础数据类错误码
| 错误码	|描述	|
| :-------- | :--------|
|4001|项目不存在|
|4002|置业顾问不存在|
|4003|置业顾问已经存在|
|4004|代理公司已经存在|
|4005|代理公司不存在|
|4006|指定项目没有开通|
|4007|经纪人不存在|
|4008|经纪人已经存在|
|4009|经纪人身份不明|


#####推送通知类错误码
| 错误码	|描述	|
| :-------- | :--------|
|6001|消息推送失败|
	
	
#####业务通用错误码
| 错误码	|描述	|
| :-------- | :--------|
|9001|非法身份证号码|
|9002|非法手机号码|