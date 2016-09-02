**联发地产开放接口规范说明书**
-----------


变更记录

|  版本号 | 修改原因/内容  | 修改人 | 修改时间   |
|------------|---------------------|------------|----------------|
| Ｖ1.0   | 初稿 | 肖兆   | 2015-07-15 |
| Ｖ1.1   | 销售sdfads机会上报和通知接口新增字段：居住区域、工作区域、来自区域、职业身份、置业次数、老业主、客户类别         | 余世明 | 2015-9-26|
| Ｖ1.2   | 新增通知接口： 客户描摹通知接口(cst\_attribute\_notify)  | 余世明 | 2015-10-04 |
| Ｖ1.3   | 新增了认购、签约同步通知的 状态和关闭原因的描述信息                                                    | 余世明 | 2015-10-05 |
| Ｖ2.0   | 规范了接口时间字段的定义，同享会按照int传输，案场按照datetime传输                                      | 余世明 | 2015-10-14 |
| Ｖ2.1   | 更新了跟进上报接口、跟进通知接口定义                                                                   | 余世明 | 2015-10-14 |
| Ｖ2.2   | 更新了机会上报接口、机会更新接口、机会查询接口、机会通知接口：是对购房意向字段的更新                   | 余世明 | 2015-10-16 |
| Ｖ3.0   | 1. 接口协议升级<br/>2. 接口所有projCode使用projGUID替换<br/>3. 更新4.2.1.G-CU-12特征模板查询(attribute\_template\_query)<br/>4. 更新4.2.2. P-CU-13客户特征描摹上报(cst\_attribute\_update)<br/>5. 删除4.2.3. G-CU-14客户特征描摹查询(cst\_attribute\_query)<br/>6. 其它接口字段调整| 余世明 | 2015/11/26 |
| Ｖ3.1   | 新增销控接口：<br/>    销控楼栋单元查询、   销控房产查询 | 余世明 | 2015/12/24 |
| Ｖ3.2   | 1. G-CU-01特征模板查询(attribute\_template\_query)已经过时，最新参见G-CU-08(proj\_attach\_list\_v2)<br/>2. P-CU-02客户特征描摹上报 (cst\_attribute\_update)已经过时，最新参见P-CU-09(cst\_attach\_create\_v2) <br/>3. N-NY-08客户描摹通知接口(cst\_attribute\_notify)已经过时，最新参见N-NY-09(notify\_cst\_attach\_v2)    | 余世明 | 2016/1/5   |
| Ｖ3.3   | 4.3.7 P-SA-07销售机会拍档更新(opportunity_partner_update)，partners改为非必须，partners为空时，做删除操作    | 周　亮 | 2016/02/17   |
| Ｖ3.4   | 新增请求历史数据同步接口和历史数据同步状态通知接口| 周　亮 | 2016/02/20  |
| Ｖ3.5   | 新增项目上线通知接口| 周　亮 | 2016/02/29  |
| Ｖ3.6   | 1.增加消息接口的消息来源说明；<br/>2.老版描摹接口已作废；| 周　亮 | 2016/03/17  |
| Ｖ3.7   | 废弃 客户推荐通知接口| 周　亮 | 2016/03/29  |
| Ｖ3.8   | 1.新增业务客户资料变更通知<br/>2.修改认购通知/签约通知的状态描述| 周　亮 | 2016/05/12  |
| Ｖ3.9  |  更新[4.2.9 G-CU-08项目特征查询（proj_attach_list_v2）](#4.2.9 G-CU-08项目特征查询（proj_attach_list_v2）)：<br>1、attachs/attachType必填改为否<br>2、修改attachs/attachLevel定义：1集团级，4项目级，16公司级<br>3、attachs/items/scopejGUID字段拼写有误，改为scopeGUID<br>4、attachs/category必填改为否，暂不支持 |  余世明  |  2016/05/17   |
| :star: Ｖ3.10  | 1.修正[客户鉴定请求](#4.5.1 G-AG-01客户鉴定请求（cst_identify）)followTime字段类型为yyyy-MM-dd HH:mm&#58;ss格式</br>2.修正[跟进信息上报](#4.2.8 P-CU-07跟进信息上报（cst_follow_update）)跟进类型为followType |  周　亮  |  2016/05/26   |

[TOC]
# 1. 前言
1.	前言
	本接口规范，数据中心2.0数据平台的业务功能开放接口。适用于包括但不限于经纪人平台、案场APP、微信案场等，接入数据中心所遵循的标准。
# 2. 总体规范
## 2.1 接口规范
* 接口采用HTTP+JSON，所有接口调用，均遵守HTTP协议，支持GET与POST两种方式，拒绝其它请求方式；统一使用UTF-8编码；包括消息内字段，及所有值。
* 所有上下行消息中，http协议头部分必须包含content-length和content-type两个字段，contnet-length即http协议body长度；content-type值固定为application/json；
* 所有返回消息或参数，均以文本格式进行返回，对于二进制数据，则通过其它模块，以资源管理形式进行库维护。
* 所有请求中，必须包含认证必须字段，否则视为无效请求，予以拒绝。
* 所有时间字段，均以年月日时分秒的长字符串表示，格式为:YYYY-MM-dd HH\:mm:ss
* 所有上行消息的JSON，必须包含header和data两部分。header包含接口调用参数，即非业务相关数据；data部分为实际的业务数据；data为结构化的json转成字符串后，根据数据中心分配appkey加密后的base64字符串，加密算法为RC4。格式示例：
		{
			“header”:{},
			“data”:””
		}
	header必须包含的信息有

|字段|说明|
|:---|:--|
|appid|数据中心分配给应用的标识|
|timestamp|时间戳，UTC秒值|
|sid|消息ID|
|authCode|认证校验码，即按自然排序后字符串拼接组合appid、sid、token、dataCode计算出的sha1散列码；其中token是数据中心分配给应用的校验码|
|cmd|调用命令，即接口名称|
|version|版本|
|dataCode|数据校验码，即结构化的json转成字符串后使用appkey加密后的数据，经Base64加密后计算出的sha1散列码。其中appkey是数据中心分配给应用的秘钥|


* 所有响应消息的JSON，data部分加密的密钥与算法同上行消息。格式示例：
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
* 所有响应消息中，除errcode和errmsg外，所有必须参数，均指在errcode为0(即成功)的情况下才是必须
## 2.2 系统编号（APPID）

| 系统分类	|APPID编号	|说明|
| :-------- | :--------|:--------|
|数据中心		|1XX	|所有数据中心模块或子系统APPID取值范围为100~199|
|经纪人平台	|2XX	|经纪人类平台系统，如带客通、同享会等APPID取值范围为200~299|
|案场系统	|3XX	|包括案场、微信等案场类系统APPID取值为300~399|
|ERP系统	|4XX	|指现有传统ERP系统，如明源、用友等APPID取值范围为400~499|
|会员类	|5XX	|包括统一会员平台或各业态的独有会员系统APPID的取值范围500~599|
|电商类	|6XX	|包括第三方或自有渠道应用，如京东、官微等APPID的取值范围为600~699|
## 2.3 接口编号规则 
接口名定义分3部分，示例：P1-P2-P3

- P1：表示接口接口处理方式。目前取值分别是
>    P:上报类接口
     G:查询类接口
     N:通知类接口

- P2：表示数据用途分类。目前取值分别是 
>    BA：基础资源类接口
     SA：销售类接口
     CU：客户类接口
     ME：会员类接口

- P3：表示在数据用途类范围内的接口编号

## 2.4 SID定义
对应head包中的 sid 定义：
数据中心与应用系统传输的每一条接口命令都有一个序列号，序列号由命令源系统产生并唯一标记一条命令；也就是说，数据中心系统中任何两个命令的序列号都不相同。对于数据中心主动推送到业务应用（经纪人平台、案场管理等）的消息，例如数据中心向案场发送一条推荐客户信息，此时序列号由数据中心生成（此时命令源节点为数据中心）。
序列号分成三部分，每部分为一个整数，第一部分表示命令源系统的编号，第二部分表示命令产生的日期和时间，格式为十进制的yymmddhhmm，比如14年11月20日20时32分25秒产生的消息，其第二部分为十进制141120203225；第三部分由0开始，最大值是99999，循环进位，直到进位满了之后再清零，重新开始计数, 不够5位，左补0
# 3. 接入认证
上下行接入认证，采用同样算法；数据取值不同；应用上行到数据中心的，采用数据中心分配给应用的appid和appkey进行解析认证；数据中心下行到应用的，采用数据中心的appid和数据中心分配给应用appkey进行解析认证

## 3.1 请求封装步骤
1. 首先根据SID生成规则，生成消息ID
2. 将业务数据转成结构化的json转成字符串后，用数据中心分配的appkey进行RC4加密，密文经base64加密后sha1，即dataCode
3. 把密文进行base64加密；作为data字段值
4. 把appid、sid、数据中心分配的token、dataCode按自然排序后字符串拼接组装后计算sha1,即authCode
5. 创建header，包括字段appid、sid、token、authCode、cmd、timestamp、version、dataCode
示例：
``` java
初始化数据：
appid = "123";
token = "52e41ab0d3eee56b725e3e29999762a8";
appkey = "S_+SFO!fH.7qj_CEIKgCoSRfYr&e%,zAL1-*UEW7D]V$o4Cc=Dd4kwSh%6Q<!?=!+_@H^,K*#Gdk/d.qp@nBjl:e^/,.ckVGC2<4OoZNS2JN5<IX[Uq0W0oI-Y(K[k-R";
sid = "2014123123123123";
data = {"hello":123};
cmd = "cst_identity";
``` 
1､ 根据data计算原始字节码：
``` 7B 22 68 65 6C 6C 6F 22 3A 31 32 33 7D ```
2､ 根据原始字节码计算密文：
``` 15 0C FC 96 18 A1 15 B0 47 F1 F5 78 3C ```
3､ 根据密文计算base64：
``` FQz8lhihFbBH8fV4PA== ```
4､ 根据base64计算sha1散列码，即dataCode：
``` a975283943d4be0d7cb355c2115f45d63b5dcc5d ```
5､ 将appid、sid、token、dataCode组合起来：
``` 123201412312312312352e41ab0d3eee56b725e3e29999762a8a975283943d4be0d7cb355c2115f45d63b5dcc5d ```
计算其sha1散列码，即authCode：
``` 8c694932bba5d137af13654ce5a875d30a267ec8 ```

计算结果：
```
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
## 3.2 接收验证步骤
1､ 首先根据http头部的content-length读取报文后，解析成json；
2､ 取header中的appid、sid、数据中心分配的token、dataCode，按自然排序后字符串拼接组装后计算sha1，与authCode比较判断接入认证
3､ 接入认证成功后，以base64解密算法，将data值还原成密文；
4､ 计算密文的sha1散列码，比较dataCode校验是否被篡改；
5､ 篡改校验通过后，再用数据中心分配的appkey为密钥，以RC4算法解密转成结构化的json字符串
接收报文：
``` 报文
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
1､ 拼接appid、sid、token、dataCode：
``` 123201412312312312352e41ab0d3eee56b725e3e29999762a8a975283943d4be0d7cb355c2115f45d63b5dcc5d ```
2､ 计算拼接后字符串的sha1散列码：
``` 8c694932bba5d137af13654ce5a875d30a267ec8 ```
3､ 计算data的sha1散列码：
``` a975283943d4be0d7cb355c2115f45d63b5dcc5d ```

经过以上三步计算，验证通过，则进行以下4､5两步：
4､ 以base64还原data为密文
``` 15 0C FC 96 18 A1 15 B0 47 F1 F5 78 3C ```
5､ 以appKey解密密文（如果是数据中心，appKey是以appid查找在数据中心配置的appKey，如果找不到，则不给任何响应数据；若是接入应用，则为数据中心分配的固定appKey）：
``` 7B 22 68 65 6C 6C 6F 22 3A 31 32 33 7D ```

# 4 开放接口
* 请求说明
> http请求方式: post


## 4.1 基础数据接口
　　案场定时请求基础数据接口同步基础数据。
### 4.1.1 G-BA-01代理公司查询(base_company_list)
* **接口说明**
· 案场同步代理公司
· 案场根据[置业顾问项目关系查询接口](#4.1.4 G-BA-04置业顾问项目关系查询（base_consultantProj_list）)查询到的关系，将置业顾问绑定到项目下的代理公司
· 一个项目对应多个代理公司
+ **请求参数说明**

|参数|是否必须|类型|长度|说明|
|:-------|:---------|:-------|:----|:---------|
|page    |否        |int     |4    |同步第几页|
|pageSize|否        |int     |4    |返回结果集大小|
|syncTime|否        |datetime|4    |记录的创建时间, 格式”yyyy-MM-ddHH:mm&#58;ss\[.SSS\]”|


+ **响应参数说明**

|参数                 |是否必须|类型  |长度|说明|
|:--------------------|:-------|:-----|:---|:---|
|errcode              |是      |int|10|错误码|
|errmsg               |是      |string|64|错误描述|
|data/lastSyncTime|否，支持排序时间时必须|datetime|20|最后创建时间，取本次同步数据的最大排序时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|data/totalPage       |是      |int   |4|记录总页数|
|data/page            |是      |int   |4|当前页码|
|data/list            |记录存在时必须|array||结果集|
|data/list/companyGUID|        |string|64|公司GUID|
|data/list/companyName|        |string|64|公司名称|
|data/list/projGUID   |        |string|64|项目GUID|

### 4.1.2 G-BA-02区域街道查询(base_areaStreet_list)
* **接口说明**
· 案场请求数据中心同步区域街道 
+ **请求参数说明**

|参数       |是否必须  |类型|长度|说明|
|:-------------------|:-|:-------|:--|:---------|
|page                |否|int     |4  |同步第几页|
|pageSize            |否|int     |4  |返回结果集大小|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|data/totalPage       |是|int   |4  |记录总页数|
|data/page            |是|int   |4  |当前页码|
|data/list            |记录存在时必须|array||结果集|
|data/list/areaGUID   |是|string|64 |区域ID|
|data/list/areaName   |是|string|50 |区域名称|
|data/list/streetName |是|string|500|街道名称|
|data/list/cityName   |是|string|50 |城市名称|
|data/list/provinceName|是|string|500|省份名称|

### 4.1.3 G-BA-03项目信息查询(base_project_list)
* **接口说明**
· 案场请求数据中心同步项目信息 
· 调用数据服务：项目分页查询(base_get_proj)

+ **请求参数说明**

|参数                   |是否必须         |类型|长度|说明|
|:------------|:-|:-------|:--|:---------|
|page         |否|int     |4  |同步第几页|
|pageSize     |否|int     |4  |返回结果集大小|
|syncTime	  |否|datetime|4    |记录的创建时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|

+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|data/lastSyncTime    |记录存在时必须|datetime|20|最后创建时间，取本次同步数据的最大排序时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|data/totalPage       |是|int   |4  |记录总页数|
|data/page            |是|int   |4  |当前页码|
|data/list            |记录存在时必须|array||结果集|
|data/list/projGUID   |是|string|64	|项目ID|
|data/list/projName	  |是|string|50	|项目名称|
|data/list/parentGUID |是|string|64	|父级项目ID|
|data/list/cityName   |是|string|50	|城市名称|
|data/list/status	  |是|int   |4  |状态：1有效0无效|
|data/list/lastModifyTime|是|datetime|32|最后修改时间,格式”yyyy-MM-ddHH:mm&#58;ss\[.SSS\]”|
|data/list/ifEnd      |是|int   |2	|是否最末级项目 0:否 1:是|
|data/list/buGUID 	  |是|String|64 |项目所属公司编码|
|data/list/level	  |是|Int   |2	|级别|

### 4.1.4 G-BA-04置业顾问项目关系查询（base_consultantProj_list）
* **接口说明**
· 案场请求置业顾问项目关系查询
· 案场同步项目和代理公司，将置业顾问绑定到项目下的代理公司

+ **请求参数说明**

|参数|是否必须|类型|长度|说明|
|:-------|:---------|:-------|:----|:---------|
|page    |否        |int     |4    |同步第几页|
|pageSize|否        |int     |4    |返回结果集大小|
|syncTime|否        |datetime|4    |记录的创建时间, 格式”yyyy-MM-ddHH:mm&#58;ss\[.SSS\]”|

+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|lastSyncTime|记录存在时必须|datetime|20|最后创建时间，取本次同步数据的最大排序时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|totalPage       |是|int   |4  |记录总页数|
|page            |是|int   |4  |当前页码|
|list            |记录存在时必须|array||结果集|
|list/userGUID   |是|String|64	|置业顾问编号|
|list/projGUID	  |是|String|64	|项目GUID||
|list/stationName|是|String|64	|置业顾问职务名称|
|list/stationGUID|是|String|64	|置业顾问职务编号|
|list/parentStationGUID|是|String|64|父级岗位GUID|
|list/parentStationName|是|String|64|父级岗位名称|
|list/createdOn |是|datetime|30|格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|

### 4.1.5 G-BA-05置业顾问获取(base_consultant_list)
* **接口说明**
· 案场同步置业顾问信息
· 置业顾问与代理公司关系由案场绑定

+ **请求参数说明**

|参数|是否必须|类型|长度|说明|
|:-------|:---------|:-------|:----|:---------|
|page    |否        |int     |4    |同步第几页|
|pageSize|否        |int     |4    |返回结果集大小|
|syncTime|否        |datetime|4    |记录的创建时间, 格式”yyyy-MM-ddHH:mm&#58;ss\[.SSS\]”|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|data/lastSyncTime|记录存在时必须|datetime|20|最后创建时间，取本次同步数据的最大排序时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|data/totalPage       |是|int   |4  |记录总页数|
|data/page            |是|int   |4  |当前页码|
|data/list            |记录存在时必须|array||结果集|
|data/list/userGUID   |是|String|64|置业顾问编号|
|data/list/userName   |是|String|64|置业顾问名称|
|data/list/userCode   |是|String|64|账号||
|data/list/password	  |是|string|64|密码|
|data/list/mobile	  |是|String|16|手机|
|data/list/isDisabled |是|int	|4 |是否禁用，0是有效 1无效|
|data/list/createdOn  |是|datetime|32|创建时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|

### 4.1.6 P-BA-06置业顾问上报(base_consultant_create)
* **接口说明**
· 案场上报置业顾问信息，数据中心写入明源库并调用数据服务入库
· 调用数据服务接口：置业顾问新增(cst_create_consultant)

+ **请求参数说明**

|参数      |是否必须|类型|长度|说明|
|:-------------|:-|:-----|:-|:------------|
|userName	   |是|String|64|置业顾问名称|
|userCode	   |是|String|64|账号|
|password      |是|string|64|密码|
|mobile	       |是|String|16|手机|
|isDisabeld	   |是|int	 |4	|是否禁用，0是有效|
|stationName   |是|String|64|置业顾问职务名称|
|stationGUID   |是|String|64|置业顾问职务编号|
|projGUID	   |是|String|64|项目编号|
|gender	       |是|int	 |2	|性别：1男，2女，0未知|
|userGUID	   |是|string|64|用户GUID|
|proxyCompanyId|是|string|64|代理公司GUID|


+ **响应参数说明**

|参数        |是否必须|类型|长度|说明|
|:-----------|:--|:----|:--|:---|
|errcode	 |是|int   |10 |错误码|
|errmsg	     |是|String|64 |错误描述|
|consultantId|是|String|64 |置业顾问ID|

### 4.1.7 P-BA-07区域街道上报(base_areaStreet_create)
* **接口说明**
· 案场上报区域街道信息，开放接口回写明源并调用数据服务入数据中心库
· 调用数据服务接口：区域街道上报（base_create_area_street）
· 拓客用（目前不用）

+ **请求参数说明**

|参数      |是否必须|类型|长度|说明|
|:-----------|:-|:----|:---|:-------|
|areaName	 |是|string|50 |区域名称|
|streetName	 |是|string|500|街道名称|
|cityName	 |是|string|50 |城市名称|
|provinceName|是|string|50 |省份名字|
|countryName |是|string|50 |国家名称|


+ **响应参数说明**

|参数        |是否必须|类型|长度|说明|
|:-----------|:--|:----|:--|:---|
|errcode	 |是|int   |10 |错误码|
|errmsg	     |是|String|64 |错误描述|
|areaGUID	 |成功时必须|string|64|区域编号，格式UUID|

### 4.1.8 G-BA-08销控楼栋单元查询(base_buildingUnit_list)
* **接口说明**
· 开放接口直接查询明源库
· 查询项目下的楼栋（p_Building）
· 查询楼栋下的单元（p_BuildUnit）

+ **请求参数说明**

|参数  |是否必须|类型|长度|说明|
|:-------|:-|:-----|:-|:-------|
|projGUID|是|string|64|项目GUID|


+ **响应参数说明**

|参数        |是否必须|类型|长度|说明|
|:-----------|:--|:----|:--|:---|
|errcode	 |是|int   |10 |错误码|
|errmsg	     |是|String|64 |错误描述|
|buildingList|是|array|	|楼栋列表|
|buildingList/bldGUID|是|String|64|楼栋编号|
|buildingList/bldName|是|String|64|楼栋名，如“5号楼”|
|buildingList/bldFullName|是|String|64|楼栋全称 如“联发新天地-二期-4号楼”|
|buildingList/buildUnit|是|array||单元列表|
|buildingList/buildUnit/unitGUID|是|String|64|单元GUID|
|buildingList/buildUnit/unitNo|是|int|4|单元编号、顺序编号|
|buildingList/buildUnit/unit|否|String|20|单元名称，可能为空|

### 4.1.9 G-BA-09销控房产查询(base_room_list)
* **接口说明**
· 开放接口直接查询明源库（p_Room表）
· unit非必须，如果不传，则查询该项目下所有房产
· 静态数据，目前【联发案场】从接口拿到数据之后直接展示，案场不存销控数据

+ **请求参数说明**

|参数  |是否必须|类型|长度|说明|
|:-------|:-|:-----|:-|:-------|
|projGUID|是|string|64|项目GUID|
|unit    |否|string|64|单元名称|


+ **响应参数说明**

|参数        |是否必须|类型|长度|说明|
|:-----------|:--|:----|:--|:---|
|errcode	 |是 |int   |10 |错误码|
|errmsg	     |是 |String|64|错误描述|
|roomList    |是|array| |房产列表|
|roomList/projGUID|是|String|64|项目GUID|
|roomList/bldGUID|是|String|64|楼栋GUID|
|roomList/unit|否|String|20|单元：楼栋就一个单元时为空；包含多个单元时，与p_BuildUnit字段unit相同|
|roomList/floor|是|String|20|楼层|
|roomList/room|是|String|20|房号|
|roomList/status|是|String|20|销售状态：销控 待售 签约 认购|
|roomList/bldArea|是|double|64|建筑面积|
|roomList/total|是|double|64|标准总价|
|roomList/roomStru|否|String|20|房间结构，例如：二房二厅一卫三阳台、3房2厅4卫2阳、车位|
|roomList/xkRow|否|string|32|销控Row|
|roomList/xkCol|否|string|32|销控col|

### 4.1.10 G-BA-10置业顾问岗位获取（base_consultantStation_list）
* **接口说明**
· 案场分页同步岗位信息

+ **请求参数说明**

|参数|是否必须|类型|长度|说明|
|:-------|:---------|:-------|:----|:---------|
|page    |否        |int     |4    |同步第几页|
|pageSize|否        |int     |4    |返回结果集大小|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|data/lastSyncTime|记录存在时必须|datetime|20|最后创建时间，取本次同步数据的最大排序时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|data/totalPage       |是|int   |4  |记录总页数|
|data/page            |是|int   |4  |当前页码|
|data/list            |记录存在时必须|array||结果集|
|data/list/stationGUID|是|String|64|岗位编号|
|data/list/stationName|是|String|64|岗位名称|
|data/list/projGUID   |是|String|64|项目编号|
|data/list/projCode   |是|string|64|项目code|
|data/list/parentStationGUID|否|string|64|父级岗位编号|



### 4.1.11.  G-BA-11 请求历史数据同步（sync_request）
* **接口说明**
· 案场上报一条同步任务
· 定时程序扫描任务表，根据dataType同步对应数据，并将同步结果发出通知
· 开放接口通过[历史数据同步状态通知](#4.4.10. N-NY-10历史数据同步状态通知（notify_request_result）)将同步结果通知给应用

+ **请求参数说明**

|参数|是否必须|类型|长度|说明|
|:-------|:---------|:-------|:----|:---------|
|createdBy 	|是 	|string 	|64 	|操作人|
|taskName 	|是 	|string 	|64 	|任务名称|
|projGUID 	|否 	|string 	|64 	|项目GUID|
|shopGUID 	|否 	|string 	|64 	|门店或商铺GUID|
|timeRangeStart |否 |string 	|32 	|开始时间，格式为：yyyy-MM-dd HH:mm&#58;ss|
|timeRangeEnd 	|否 |string 	|32 	|结束时间，格式为：yyyy-MM-dd HH:mm&#58;ss|
|dataType 	|是 |string 	|512 	|指定的数据范围，多个数据范围，通过&#124;分割，取值对应数据通知，如notify_cst_update、notify_agent_recommend等|



+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|content/taskID       |是|string|64|任务ID|



## 4.2 客户数据接口
### 4.2.1 G-CU-01特征模板查询(attribute_template_query)（作废）
最新参见[项目特征查询（proj_attach_list_v2）](#4.2.9 G-CU-08项目特征查询（proj_attach_list_v2）)
* **接口说明**
· 描摹模板定义查询

+ **请求参数说明**

|参数|是否必须|类型|长度|说明|
|:-------|:-|:-- --|:-|:---------|
|page    |否|int   |4 |同步第几页|
|pageSize|否|int   |4 |返回结果集大小|
|projGUID|否|string|32|项目code|



+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|data/lastSyncTime|记录存在时必须|datetime|20|最后创建时间，取本次同步数据的最大排序时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|data/totalPage       |是|int   |4  |记录总页数|
|data/page            |是|int   |4  |当前页码|
|attachs|否，结果存在时必须|array||特征项目定义|
|attachs/projGUID|是|sting|64|项目编号|
|attachs/attachCode|是|string|16|特征编号, 关联b_def_attach|
|attachs/attachName|是|string|32|特征名称|
|attachs/attachType|是|int|4|特征类别|
|attachs/input|是|int|2|1=手动输入，默认 2=单选 3=多选|
|attachs/attachKey|是|string|64|特征项目值|
|attachs/category|是|string|32|特征分类|
|attachs/label|是|string|128|特征项目值描述|
|attachs/parentCode|否|string|16|保留字段|
|attachs/remark|否|string|2000|备注|
|attachs/codeSeq|否|int|10|特征排序|
|attachs/state|是|int|10|描摹状态：1有效，0无效|
|attachs/keySeq|否|int|10|特征值排序|
|attachs/endTime|否|string|32|媒体活动结束时间|

### 4.2.2 P-CU-02客户特征描摹上报(cst_attribute_update)（<font color='red'>作废</font>）
最新参见[客户描摹上报(cst_attach_create_v2)](#4.2.10 P-CU-09客户描摹上报（cst_attach_create_v2）)
* **接口说明**
· 客户特征描摹上报，包含新增和修改操作
· 特征描摹指客户基础信息以外的所有信息，如户口、住址、工作等
· 一次可上报多个特征项信息，即以数组的形式上报
· 描摹分基本描摹和项目描摹，即上报时指定了项目编号，则认为是项目描摹，不指定则认为是基本信息描摹。
· 单次请求必须是同一个客户相同项目下的特征描摹


+ **请求参数说明**

|参数|是否必须|类型|说明|
|:-------|:-|:----:---------|
|attachs|是|array|特征数组
|attachs/cstGUID|是|long|客户ID
|attachs/projGUID|是|varchar(64)|项目编号
|attachs/attachCode|是|varchar(16)|特征编号
|attachs/value|否|varchar(2000)|特征值
|attachs/remark|否|varchar(2000)|备注
|attachs/sourceChannel|否|varchar(16)|来源渠道
|attachs/userId|是|varchar(32)|业务员编号
|attachs/createTime|是|varchar(32)|上报时间
|attachs/oppGUID|是|varchar(32)|机会GUID


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|



### 4.2.3 G-CU-14客户特征描摹查询 (cst_attribute_query)（未实现）
+ **接口说明**
· 客户特征描摹查询

+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|cstGUID|projCode不存在时必须|String|64|cst编号|
|projCode|cstGUID不存在时必须|String|64|项目code|
|page|是|int|4|第几页|
|pageSize|是|Int|4|返回结果集大小|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|data/totalPage       |是|int   |4  |记录总页数|
|data/page            |是|int   |4  |当前页码|
|cstAttributes|是|array||客户描摹集合|
|cstAttributes/attrType|是|int|2|客户标签类别：0 基础  1 线索  2 机会|
|cstAttributes/attrGUID|是|string|64|特征编号|
|cstAttributes/leadGUID|否|string|64|线索编号|
|cstAttributes/oppGUID|否|string|64|机会编号|
|cstAttributes/cstGUID|是|string|10|客户编号|
|cstAttributes/cstName|是|string|64|客户名称|
|cstAttributes/projCode|是|string|64|项目code|
|cstAttributes/projGUID|是|string|64|项目GUID|
|cstAttributes/items|是|array||特征集合|
|cstAttributes/items/itemGUID|是|string|64|特征项目编号|
|cstAttributes/items/itemValue|是|string|100|特征项目值|
|cstAttributes/items/parentItemGUID|是|string|32|父级特征项目编号|
|cstAttributes/items/parentItemValue|是|string|100|父级特性项目值|

### 4.2.4 P-CU-03催款信息上报(payment_info_create)
+ **接口说明**
· 催款信息上报
· 调用服务数据服务接口：催款新增(payment_info_create)
+ **请求参数说明**


|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|feeGUID|是|String|64|费用编号|
|tradeGUID|是|String|64|交易编号|
|createOn|是|String|64|催款时间|
|paramValue|是|string|64|欠款原因|
|ckMemo|是|string|100|备注|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|

### 4.2.5 G-CU-04客户资料查询(cst_info_get)
+ **接口说明**
· 根据手机号获取主档客户信息


+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|mobile|是|String|16|手机号码|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|cstGUID|是|string|64|数据中心ID|
|customerName|是|string|64|客户姓名|
|mobile|是|string|16|手机号码|
|phone|否|string|16|备用电话|
|gender|是|int|4|性别 1-男  2-女|
|birthday|是|datetime|64|出生日期 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|certType|否|Int|4|证据类别：<br/>1-身份证<br/> 2-军官证<br/> 3-护照<br/> 4-港澳通行证<br/> 5-台湾通行证<br/> 6-台湾身份证<br/> 7-港澳身份证<br/> 8-营业执照<br/> 9-组织机构码<br/> 10-税务登记证<br/> 9999-其他|
|certNum|否|String|64|证件号码|
|homeProvince|否|String|64|省|
|homeCity|否|String|64|市|
|homeRegion|否|String|64|区|
|address|否|String|200|家庭住址|
|workProvince|否|String|64|工作省|
|workCity|否|String|64|工作市|
|workRegion|否|String|64|工作区|
|custType|是|int|4|客户类型:<br/>1-个人客户<br/>2-公司客户|

### 4.2.6 P-CU-05客户资料新增(cst_info_create)
+ **接口说明**
· 地产客户新增


+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|projGUID|是|String|64|项目ID|
|customerName|是|String|64|客户名称|
|gender|是|int|4|性别:1、男2、女|
|mobile|是|String|16|手机|
|homeTel|否|String|64|家庭电话|
|certNum|否|String|64|身份证号|
|address|否|String|150|联系地址|
|certType|否|int|4|证件类型：<br/>1 身份证<br/>2 军官证<br/>3 护照<br/>4 港澳通行证<br/>5 台湾通行证<br/>6 台湾身份证<br/>7 港澳身份证<br/>8 营业执照<br/>9 组织机构码<br/>10 税务登记证<br/>9999 其他|
|userGUID|是|String|64|置业顾问帐号|
|homeArea|否|String|64|居住区域|
|homeCase|否|String|64|居住情况|
|workTrade|否|String|64|工作行业|
|workJob|否|String|64|职业身份：<br/>中层管理人员<br/>一般管理人员/职员/公务员<br/>核心业务技术人员<br/>其他<br/>个体<br/>党政军干部<br/>跨国企业领导者(老板/董事/股东)<br/>副总经理等高层管理人员<br/>国、央企领导者(老板/董事/股东)|
|workArea|否|String|64|工作区域|
|cstType|否|String|64|客户类型：个人/公司|
|fromArea|否|string|32|来自区域|
|zyNum|否|int|32|置业次数|
|oldOwner|否|string|32|老业主：是/否|
|cstClass|否|string|32|客户类别：<br/>员工<br/>老业主<br/>老带新<br/>关系户<br/>广告来访|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|cstGUID|是|string|64|数据中心ID|

### 4.2.7 P-CU-06客户资料更新(cst_info_update)
+ **接口说明**
· 地产客户更新


+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|cstGUID|是|String|16|数据中心客户编号|
|projGUID|否|String|64|项目ID|
|customerName|是|String|64|客户名称|
|gender|是|int|4|性别:1、男2、女|
|mobile|是|String|16|手机|
|homeTel|否|String|64|家庭电话|
|certNum|否|String|64|身份证号|
|address|否|String|150|联系地址|
|certType|否|int|4|证件类型：<br/>1 身份证<br/>2 军官证<br/>3 护照<br/>4 港澳通行证<br/>5 台湾通行证<br/>6 台湾身份证<br/>7 港澳身份证<br/>8 营业执照<br/>9 组织机构码<br/>10 税务登记证<br/>9999 其他|
|userGUID|是|String|64|置业顾问帐号|
|homeArea|否|String|64|居住区域|
|homeCase|否|String|64|居住情况|
|workTrade|否|String|64|工作行业|
|workJob|否|String|64|工作职务：<br/>中层管理人员<br/>一般管理人员/职员/公务员<br/>核心业务技术人员<br/>其他<br/>个体<br/>党政军干部<br/>跨国企业领导者(老板/董事/股东)<br/>副总经理等高层管理人员<br/>国、央企领导者(老板/董事/股东)|
|workArea|否|String|64|工作区域|
|cstType|否|String|64|客户类型：个人/公司|
|fromArea|否|string|32|来自区域|
|zyNum|否|int|32|置业次数|
|oldOwner|否|string|32|老业主：是/否|
|cstClass|否|string|32|客户类别：<br/>员工<br/>老业主<br/>老带新<br/>关系户<br/>广告来访|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|

### 4.2.8 P-CU-07跟进信息上报（cst_follow_update）
+ **接口说明**
· 跟进信息上报
1.根据projGUID调用服务中心base_query_proj接口判断projCode是否存在
2.根据cstGUID调用服务中心cst_estate_get_info判断客户是否存在
3.根据FollowPersonId调用服务中心base_get_consultant_list判断置业顾问是否存在
4.根据OppGUID调用服务中心s_get_opp判断是否存在
5.新增明源s_opp2gjjl表，更新明源s_Opportunity表
6.调用服务接口cst_create_follow入数据中心库

+ **消息流**
· 触发[客户状态通知](#4.5.14 N-BA-11客户状态通知（cst_status_notify）)，消息类型：dc.mq.cst.status

+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|cstGUID|是|string|20|客户ID|
|projGUID|是|string|64|项目GUID|
|followTime|是|datetime|32|跟进日期,格式”yyyy-MM-dd HH:mm&#58;ss”|
|followContent|否|string|200|跟进内容|
|followType|是|int|2|跟进方式：<br/>1 主动电访<br/>2 客户来电<br/>3现场接待<br/>4 短信<br/>5 邮件<br/>6 上门拜访<br/>7 其它|
|userGUID|是|string|64|跟进人的ID（置业顾问）|
|oppGUID|是|string|64|机会编号|
|nextDate|否|datetime|32|下次跟进时间, 格式”yyyy-MM-dd”|
|nextContent|否|string|200|下次跟进内容|
|cstWill|是|string|64|客户意向(单选),候选项:A B C D E  <br/> A的等级最高|
|keyActions|否|string|200|关键行为(多选)<br/>1 参观样板区<br/>2 做置业预算<br/>3 邀亲朋到访<br/>4 经他人推荐<br/>格式: <br/>用英文半角分号隔开<br/>如：“参观样板区;做置业预算”|
|remark|否|string|100|备注，不填默认值为“案场跟进上报“|

+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|followGUID|是|String|64|跟进记录主键id|

### 4.2.9 G-CU-08项目特征查询（proj_attach_list_v2）
+ **接口说明**
· 根据项目查询项目特征描摹配置
1. 数据服务接口需获取本项目、项目所属公司、所属集团scopeGUID全捞
2. category 联发案场的描摹类型为50
3. attachs/attachLeve，取自数据服务接口data/attachs/items/下的第一个的itemLevel。
4. attachs/scopeGUID，取自数据服务接口data/attachs/items/的scopeGUID去重后的并集，以字符串数组填充。

+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|projGUID|否|string|64|项目GUID，需获取本项目、项目所属公司、所属集团的特征定义全捞|
|page|是|int|4|页码，不填默认为1，根据attach进行分页|
|pageSize|是|int|4|分页大小，取值范围是［10，1000］，不填默认为10|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|totalPage|是|int|4|记录总页数|
|page|是|int|4|当前页码|
|attachs|是|array||特征集合|
|attachs/attachGUID|是|string|64|特征编号|
|attachs/attachCode|是|string|64|特征编码，全局唯一，详见数据中心描摹标准定义文档|
|attachs/attachName|是|string|64|特征名称|
|attachs/category|是|int|4|属于哪一类的特征定义，如身份定义、渠道定义、业态定义、<br>途径定义等；<br>10 渠道<br>20 身份<br>30 业态<br>40 客户描摹<br>50 机会描摹<br>60 途径定义<br>70 媒体活动定义<br>|
|attachs/attachLevel|是|int|4|特征级别<br/>1=全局系统级<br/>4=项目组织级<br/>16=公司级<br>取自数据服务接口data/attachs/items/下的第一个的itemLevel|
|attachs/attachType|否|int|4|暂不支持。<br>类型根据分类不同分不同的值表示，如分类值是20,即身份，则type可取值为<br/>1=自然人<br/>2=机构|
|attachs/scopeGUID|是|list|64|范围对象编号，例如attachLevel=4,scopeGUID取值为项目编号;<br/>attachLevel=16,scopeGUID取值为公司编号;<br>取自数据服务接口data/attachs/items/的scopeGUID去重后的并集|
|attachs/subGUID|否|string|64|外键subGUID，引用特征描摹定义表b_def_attach(attachGUID),作为特征联动使用。没有则默认不支持|
|attachs/input|是|int|4|输入方式<br/>1=手动输入（默认值）<br/>2=单选<br/>3=多选|
|attachs/showType|否|int|4|显示方式<br/>0：二级平面（默认值）<br/>1：树状分局
|attachs/requiredLevel|否|int|4|输入级别：<br/>0：否（默认值），非必需<br/>1：是，必填|
|attachs/items|否|jsonArray||候选项列表，attachs/input不等于1时是必须的|
|attachs/items/itemGUID|是|string|64|候选项编号|
|attachs/items/itemCode|是|string|64|候选项编码 (attachKey)|
|attachs/items/parentItemGUID|否|string|16|父级特征项编号|
|attachs/items/itemName|是|string|64|候选项名称(label)|
|attachs/items/sequence|否|int|10|候选项的顺序|
|attachs/items/state|是|int|4|状态：1有效，0无效|
|attachs/items/expireTime|否|datetime|32|过期时间，默认为空，表示永不过期|
|attachs/items/scopeGUID|是|string|64|范围对象编号，例如attachLevel=4,scopeGUID取值为项目编号;<br/>attachLevel=16,scopeGUID取值为公司编号;|
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
            "attachLevel": 4,
            "scopeGUID": ["xxxx1","xxxx2"],
            "input": 2,
            "sequence":1,
            "items": [
                {
                    "itemGUID": "111",
                    "itemCode": "10",
                    "itemName": "水平座",
                    "sequence": 1,
                    "state": 1,
                    "expireTime": null,
                    "scopeGUID": "xxxx1"
                },
                {
                    "itemGUID": "112",
                    "itemCode": "11",
                    "parentItemGUID": "",
                    "itemName": "双子座",
                    "sequence": 2,
                    "state": 1,
                    "expireTime": null,
                    "scopeGUID": "xxxx2"
                }
            ]
        }
    ]
}
```

### 4.2.10 P-CU-09客户描摹上报（cst_attach_create_v2）
+ **接口说明**
· 特征描摹指客户基础信息以外的所有信息，一次可上报多个特征项信息，即以数组的形式上报
· 单次请求只能是同一个客户相同项目下的特征描摹


+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|cstGUID|是|string|64|客户ID|
|oppGUID|是|string|64|机会编号|
|userGUID|是|string|32|业务员编号|
|attachs|是|array||特征列表|
|attachs/scopeGUID|否|string|64|	范围对象编号，例如attachLevel=4,scopeGUID取值为项目编号;<br/>attachLevel=16,scopeGUID取值为公司编号;<br/>传空，则该描摹为集团级|
|attachs/attachGUID|是|string|64|特征编号code|
|attachs/items|是|array||特征项列表|
|attachs/items/itemGUID|否|string|64|候选项编号，当attach的input=1时为空|
|attachs/items/itemValue|否|string|64|两种情况<br/>1、attach的input=1时，取候选项编码 (attachKey)；<br/>2、否则，则为输入值|
|attachs/items/parentItemGUID|否|string||父级特征项编号，attach的input=1时为空|
|attachs/items/remark|否|string|2000|备注|
|attachs/items/expireTime|否|datetime||过期时间，默认为空，表示永不过期|
|attachs/items/sourceChannel|否|string|16|来源渠道|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|

## 4.3	销售数据接口
### 4.3.1 G-SA-01线索判断(s_lead_identify)
+ **接口说明**
· 案场请求数据中心，判断客户销售线索是否存在
· 对应明源的线索表，此时用户还未创建，判断依据是，在同项目下+联系电话


+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|phone|是|string|32|电话|
|projGUID|是|string|64|项目编号|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|data/result|成功时必须|int|4|是否存在：<br/>0不存在<br/>1存在

### 4.3.2 P-SA-02线索上报 (s_lead_create)
+ **接口说明**
· 案场上报客户销售线索


+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|projGUID    |是|string|64|项目编号|
|consultantId|是|string|64|置业顾问编号|
|cstName     |是|string|64|客户姓名|
|cstTel		 |是|string|64|客户电话|
|cstType	 |是|string|32|客户类型：个人/公司|
|cstGender	 |是|int	   |2|客户性别：<br/>1男；2女；0未知|
|description |否|string|64|备注|
|leadSource	 |是|string|32|来源：来访/微信预约/来电/其他|
|topic		 |是|string|200|主题|
|cognizeAve	 |否|string|64|认知途径|
|appointTime |否|datetime|32|预约时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|leadType	 |否|String|32|类型：天使/微信<br/>使用signguid，默认微信|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|data/leadGUID|成功时必须|string|64|线索guid|

### 4.3.3 G-SA-03线索查询 (s_lead_query)
+ **接口说明**
· 查询客户销售线索


+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|leadGUID|否，phone和projCode不存在时必须|string|64|线索编号|
|phone|否，leadGUID不存在时必须|string|32|电话|
|projGUID|否,leadGUID不存在时必须|string|64|项目编号|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|data/list|是|array||线索数组|
|data/list/leadGUID|是|string|64|销售GUID|
|data/list/projGUID|是|string|64|项目编号|
|data/list/consultantId|是|string|64|置业顾问编号|
|data/list/cstName|是|string||客户姓名|
|data/list/cstTel|是|string||客户电话|
|data/list/cstType|是|string|32|客户类型：个人/公司|
|data/list/cstGender|是|int|2|客户性别：1男；2女；0未知|
|data/list/description|否|string|64|备注|
|data/list/leadSource|否|string|32|来源：来访/微信预约/来电/其他|
|data/list/topic|否|string|200|主题|
|data/list/cognizeAve|否|string|64|认知途径|
|data/list/appointTime|是|datetime|32|预约时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|

### 4.3.4 G-SA-04机会判断 (s_opportunity_identify)
+ **接口说明**
· 案场请求数据中心判断客户销售机会是否存在
· 此时用户已经创建，需要验证该号码的用户是否存在，根据电话号码或者证件ID（优先使用电话号码）查询客户
· 根据数据中心客户编号和项目GUID判断机会是否存在

+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|phone|否|string|32|电话|
|cardId|否|string|32|证件号|
|projGUID|是|string|64|项目编号|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|data/result|成功时必须|int|4|是否存在：0不存在 1存在|

### 4.3.5 P-SA-05销售机会上报(opportunity_info_create)
+ **接口说明**
· 销售机会上报，回写明源时购房意向对应首次购房意向

+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|cstGUID|是|String|64|客户ID|
|projGUID|是|String|64|项目code|
|userGUID|是|String|64|置业顾问ID|
|status|是|String|20|	状态（登记、丢失、激活、看房、签约、认购、问询、预约）|
|oppSource|否|String|100|机会来源|
|dsReason|否|String|64|流失原因|
|cstWill|是|string|64|客户意向(单选)<br/>候选项:  A B C D E<br/>A的等级最高|
|isLocalHouseHold|否|int|2|是否本地户口  0:是 1:否(其他都填否)|
|socialSecurityYear|否|int|10|社保年数|
|dsDate|否|datetime|64|丢失时间（ClosedOn关闭日期）, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|leadGUID|否|String|64|线索GUID|
|topic|否|string|100|主题|
|dlgs|否|string|100|代理公司|
|khly|否|string|32|客户来源|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|oppGUID|是|String|64|销售机会编号|

### 4.3.6 P-SA-06销售机会拍档上报(opportunity_partner_create)
+ **接口说明**
· 销售机会拍档上报，增量存在机会拍档字段

+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|partners|是|string|300|跟进拍档,多个用英文逗号分隔|
|oppGUID|是|String|64|机会GUID|

+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|

### 4.3.7 P-SA-07销售机会拍档更新(opportunity_partner_update)
+ **接口说明**
· 销售机会拍档更新，使用上报的partners更新机会拍档字段

+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|partners|否|string|300|跟进拍档，多个用英文逗号分隔，partners为空时做删除操作|
|oppGUID|是|String|64|机会GUID|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|

### 4.3.8 P-SA-08销售机会更新(opportunity_info_update)
+ **接口说明**
· 销售机会更新，回写明源时，购房意向只更新gfyx字段，不更新首次购房意向

+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|oppGUID|是|String|64|机会编号|
|cstGUID|是|String|64|客户ID|
|projGUID|是|String|64|项目GUID|
|userGUID|是|String|64|置业顾问GUID|
|status|是|String|20|状态（登记、丢失、激活、看房、签约、认购、问询、赢得、预约）|
|oppSource|否|String|100|机会来源|
|dsReason|否|String|64|流失原因|
|cstWill|是|string|64|客户意向(单选)<br/>候选项: A B C D E <br/>A的等级最高|
|isLocalHouseHold|否|int|2|是否本地户口  0:是 1:否(其他都填否)|
|socialSecurityYear|否|int|10|社保年数|
|dsDate|否|datetime|32|丢失时间（ClosedOn关闭日期）, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|leadGUID|否|String|64|线索GUID|
|topic|否|string|100|主题|
|dlgs|否|string|100|代理公司|
|khly|否|string|32|客户来源|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|

### 4.3.9 G-SA-09销售机会查询（opportunity_info_query)
+ **接口说明**
· 销售机会查询


+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|oppGUID|否，cstGUID和projCode不存在时必须|String|64|机会编号|
|cstGUID|否（oppGUID不存在时必须）|String|64|客户GUID|
|projGUID|否（oppGUID不存在时必须）|String|64|项目编码|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|data/list|是|String||机会json数组|
|oppGUID|是|String|64|机会编号|
|cstGUID|是|String|64|客户ID|
|projGUID|是|String|64|项目code|
|userGUID|是|String|64|置业顾问ID|
|status|是|String|20|状态（登记、丢失、激活、看房、签约、认购、问询、赢得、预约）|
|oppSource|否|String|100|机会来源|
|dsReason|否|String|64|流失原因|
|firstCstWill|否|string|64|首次购房意向|
|cstWill|否|string|64|客户意向(单选)<br/>候选项:  A B C D E <br/>A的等级最高|
|partner|否|string|300|跟进拍档|
|partnerGUIDList|否|string|300|跟进拍档GUIDList|
|isLocalHouseHold|是|int|2|是否本地户口  0:是 1:否(其他都填否)|
|socialSecurityYear|是|int|10|社保年数|
|dsDate|否|datetime|32|丢失时间（ClosedOn关闭日期）, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|leadGUID|否|String|64|线索GUID|

### 4.3.10 G-SA-10客户购房成交信息查询（trade_info_list)
+ **接口说明**
· 购房成交信息查询
· 调用服务中心接口trade_get_info查询


+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|tradeGUID|是|String|64|交易GUID|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|buidName|是|string|64|楼栋|
|roomNo|是|string|64|房号|
|orderDate|是|datetime|32|生成认购单日期, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|signDate|是|datetime|32|签约日期, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|intakeServiceDate|是|datetime|32|入伙服务时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|intakeService|是|string|100|入伙服务描述|
|contractSignDate|是|datetime|32|合同登记时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|contractSign|是|string|100|合同登记描述|
|mortgageLoanDate|是|datetime|32|按揭贷款时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|mortgageLoan|是|string|100|按揭贷款描述|
|rightServiceDate|是|datetime|32|产权服务时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|rightService|是|string|100|产权服务描述|

### 4.3.11 G-SA-11合同权益人查询（cst_originator_list)
+ **接口说明**
· 取明源视图表：rptvs_Tradecst
· 权益人取里面的cstguid1 cstguid2 .....等等就是认购单上的客户信息
1：根据tradeGUIDs字段拆开，分别调用服务中心接口trade_get_cst
2：对每次trade_get_cst返回list组装成一条数据
3：把上面所有组装的数据按照接口返回

+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|tradeGUIDs|是|String|500|交易GUID，多个用英文分号分隔|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|list|否|array||权益人数组对象列表|
|list/tradeGUID|是|string|64|交易GUID|
|list/cstGUID1|是|string|64|权益人GUID1|
|list/cstName1|是|string|64|权益人名称1|
|list/cstMobile1|是|string|64|权益人电话1|
|list/cstGUID2|是|string|64|权益人GUID2|
|list/cstName2|是|string|64|权益人名称2|
|list/cstMobile2|是|string|64|权益人电话2|
|list/cstGUID3|是|string|64|权益人GUID3|
|list/cstName3|是|string|64|权益人名称3|
|list/cstMobile3|是|string|64|权益人电话3|
|list/cstGUID4|是|string|64|权益人GUID4|
|list/cstName4|是|string|64|权益人名称4|
|list/cstMobile4|是|string|64|权益人电话4|

### 4.3.12 G-SA-12新增关联人上报（cst_opp2cst_create)
+ **接口说明**
1：根据oppGUID调用明源的isOpp2CstExit 判断关联机会是否存在。
2：根据cstGUID调用服务中心接口cst_get_info判断关联人是否存在。
3：根据cstGUID调用服务中心接口cst_get_id查找oriGUID
4：调用明源createOpp2Cst上报
5：使用新增后的明源客户编号cstGUID+OppGUID，插入s_Opp2Cst，cstNum递增

+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|oppGUID|是|String|64|机会的guid|
|cstGUID|是|String|64|客户id|


### 4.3.13.	G-SA-13线索更新 (s_lead_update)
+ **接口说明**
1：根据leadGUID修改明源的线索状态status；
2：根据leadGUID修改明源的状态原因statusReason；


+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|status|是|String|10|线索状态|
|statusReason|是|String|20|状态原因（流失原因）|
|leadGUID|是|String|64|线索GUID|

+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|

## 4.4 通知接口
### 4.4.1 N-NY-01客户信息通知接口(cst_info_notify)
+ **接口说明**
· 客户信息同步接口
> 消息类型：dc.mq.cst.update

+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|cstGUID|是|String|64|客户GUID|
|projGUID|是|String|64|项目code|
|customerName|是|String|64|客户名称|
|gender|是|int||性别：1、男，2、女|
|mobile|是|String|16|手机号|
|homeTel|是|String|16|家庭电话|
|certNum|是|String|64|身份证号码|
|address|是|String|64|详细地址|
|certType|是|Int||证件类别：<br/>1 身份证<br/>2 军官证<br/>3 护照<br/>4 港澳通行证<br/>5 台湾通行证<br/>6 台湾身份证<br/>7 港澳身份证<br/>8 营业执照<br/>9 组织机构码<br/>10 税务登记证<br/>9999 其他|
|userGUID|是|String|64|置业顾问编号|
|homeArea|否|String|64|居住区域|
|homeCase|否|String|64|居住情况|
|workTrade|否|String|64|工作行业|
|workJob|否|String|64|工作职务|
|workArea|否|String|64|工作区域|
|cstType|否|int|2|客户类型：1个人2 公司|
|fromArea|否|string|32|来自区域|
|zyNum|否|int|10|置业次数|
|oldOwner|否|string|32|老业主|
|cstClass|否|string|32|客户类别|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|

### 4.4.2 N-NY-02线索信息通知接口(s_lead_notify)
+ **接口说明**
案场更新客户销售线索
> 消息类型：dc.mq.cst.lead

+ 数据流
  由[客户推荐上报接口]（#4.5.6 P-AG-06客户推荐上报（agent_recommend）），service-message下发。

+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|leadGUID|是|string|64|销售GUID|
|projGUID|是|string|64|项目编号|
|userId|是|string|64|置业顾问编号|
|cstName|是|string|64|客户姓名|
|cstTel|是|string|64|客户电话|
|cstType|是|string|32|客户类型：个人/公司|
|cstGender|是|int|2|客户性别：1男；2女；0未知|
|leadType|是|String|32|类型：天使/微信使用signguid|
|description|否|string|64|备注|
|leadSource|否|string|32|来源：大客户拜访/业主拓展/陌生电话拜访/派单/外展/外部资源|
|topic|否|string|200|主题|
|cognizeAve|否|string|64|认知途径|
|appointTime|否|datetime|32|预约时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|status|是|string|32|状态|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|

### 4.4.3 N-NY-03机会信息通知接口(opportunity_info_notify)
+ **接口说明**
机会信息同步接口
> 消息类型：dc.mq.opp.update


+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|oppGUID|是|String|64|机会的guid|
|leadGUID|否|String|64|线索GUID|
|cstGUID|是|int|64|数据中心客户ID|
|projGUID|是|String|64|项目code|
|userGUID|是|String|64|置业顾问ID UserGUID|
|sourceType|是|String|64|客户来源（来电、来访、预约、推荐）OppSource|
|status|是|String|20|状态（登记、丢失、激活、看房、签约、认购、问询、赢得、预约）|
|content|是|String|200|意向说明Description|
|intentLevel|是|int||购房意向 3 高 2 中 1 底（Rating 1冷淡 3密切 2一般）|
|assignDate|是|String|64|分配时间 CreatedOn|
|nextFollowDate|是|datetime|32|下次跟进时间（FaithDate）, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|lastFollowDate|是|datetime|32|最后一次跟进时间（ReceiveDate）, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|dsReason|否|String|128|丢失原因(StatusReason)|
|yxYeTai|否|String|100|需求业态(IntentHx)|
|yxFangXing|否|String|100|需求户型（BuyHx）|
|yxArea|否|String|100|需求面积<br/>BuyMj~BuyMjOn，需要判断过滤以下数据：0.00 NULL|
|gfyt|否|String|100|购房用途（BuyPurpose）|
|isLocalHouseHold|是|int|10|是否本地户口  0:否 1:是(其他都填否)|
|socialSecurityYear|是|int|10|社保年数|
|dsDate|否|datetime|32|丢失时间（ClosedOn关闭日期）, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|firstCstWill|否|string|64|首次购房意向|
|cstWill|是|string|64|客户意向(单选) 候选项:  A B C D E <br/>A的等级最高|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|

### 4.4.4 N-NY-04跟进信息通知接口(cst_follow_notify)
+ **接口说明**
跟进信息同步接口
> 消息类型：dc.mq.cst.follow


+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|cstGUID|是|string|20|客户ID|
|projGUID|是|string|64|项目code|
|followTime|是|datetime|32|跟进日期,格式”yyyy-MM-dd HH:mm&#58;ss”|
|followContent|否|string|200|跟进内容|
|followType|是|int|2|跟进方式：<br/>1 主动电访<br/>2 客户来电<br/>3现场接待<br/>4 短信<br/>5 邮件<br/>6 上门拜访<br/>7 其它|
|userGUID|是|string|64|跟进人的ID（置业顾问）|
|oppGUID|是|string|64|机会编号|
|nextDate|否|datetime|32|下次跟进时间, 格式”yyyy-MM-dd”|
|nextContent|否|string|200|下次跟进内容|
|cstWill|是|string|64|客户意向(单选)<br/>候选项: A B C D E <br/>A的等级最高
|keyActions|否|string|200|关键行为(多选)<br/>1 参观样板区<br/>2 做置业预算<br/>3 邀亲朋到访<br/>4 经他人推荐<br/>格式: <br/>用英文半角分号隔开,如：“参观样板区;做置业预算”
|remark|否|string|100|备注，不填默认值为“案场跟进上报“|
|followGUID|是|string|64|跟进记录编号，对应明源s_opp2gjjl表中的GjjlGUID|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|

### 4.4.5 N-NY-05欠款消息通知接口 (cst_fee_notify)
+ **接口说明**
各款项明细信息
> 消息类型：dc.mq.sale.fee

+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|cstGUID|是|String|64|客户GUID|
|projGUID|是|String|64|项目code|
|feeGUID|是|string|32|欠款GUID|
|tradeGUID|是|string|32|交易编号|
|userGUID|是|String|64|置业顾问帐号ID|
|itemName|是|string|50|欠款款项名称|
|rmbYe|是|string|50|欠款余额|
|lastDate|是|datetime|32|付款日期, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|flag|是|String|50|状态√的为付款完成|
|amount|是|String|Float|欠款总金额|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|

### 4.4.6 N-NY-06认购信息通知接口(cst_order_notify)
+ **接口说明**
客户ID、oppguid、房间guid、房号、项目codeprojCode、付款方式（payformname）、认购时间，预计签约时间、认购金额、状态、关闭原因（新增、退房、换房、变更价格）
> 消息类型：dc.mq.sale.order


+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|id|是|String	64|记录标识|
|oppGUID|否|String|64|机会的guid|
|tradeGUID|是|string|64|交易GUID|
|cstGUID|是|String|64|客户ID|
|userGUID|否|String|64|置业顾问帐号|
|projGUID|是|String|64|项目code|
|roomGUID|否|String|64|认购房产|
|room|否|String|32|房号|
|money|否|String|32|认购金额|
|status|否|String|64|状态：<br/>230=认购退房<br/>231=认购作废<br/>232=认购变更<br/>233=认购换房<br/>234=认购变价<br/>235=认购变更付款方案|
|endDate|否|datetime|32|预计签约时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|payForm|否|String|64|付款方式(payformname)|
|orderTime|否|datetime|32|认购时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|closeReason|否|String|64|关闭原因：作废、转认购、换房、转签约 等等|
|buildName|否|String|64|认购房产对应楼栋名称|
|houseType|否|String|64|认购房产户型|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|

### 4.4.7 N-NY-07签约信息通知接口(cst_contract_notify)
+ **接口说明**
签约信息同步接口
> 消息类型：dc.mq.sale.contract


+ **请求参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|id|是|String|64|记录标识|
|oppGUID|否|String|64|机会的guid|
|tradeGUID|是|string|64|交易GUID|
|cstGUID|是|String|64|客户ID|
|userGUID|否|String|64|置业顾问GUID|
|projGUID|是|String|64|项目code|
|roomGUID|是|String|64|认购房产|
|room|是|String|32|房号|
|money|否|String|32|签约金额|
|status|否|String|64|状态：<br/>240=签约退房<br/>241=签约作废<br/>242=签约变更<br/>243=签约换房<br/>244=签约变价<br/>245=签约变更付款方案|
|payForm|否|String|64|付款方式(payformname)|
|qsDate|否|datetime|32|签约时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
|closeReason|否|String|64|关闭原因：作废、换房、退房 等等
|buildName|否|String|64|认购房产对应楼栋名称|
|houseType|否|String|64|认购房产户型|


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|

### 4.4.8 N-NY-08客户描摹通知接口(cst_attribute_notify)（作废），最新参见N-NY-09(notify_cst_attach_v2)
+ **接口说明**
ETL同步历史客户特征描摹和增量同步客户特征描摹，产生客户描摹通知到案场
> 消息类型：dc.mq.cst.attach


**请求参数说明**

| 参数          | 必须 | 类型          | 说明         |
|---------------|------|---------------|--------------|
| cstGUID       | 是   | long          | 客户ID       |
| projGUID      | 是   | varchar(64)   | 项目编号     |
| attachCode    | 是   | varchar(16)   | 特征编号     |
| value         | 否   | varchar(2000) | 特征值       |
| remark        | 否   | varchar(2000) | 备注         |
| sourceChannel | 否   | varchar(16)   | 来源渠道     |
| userId        | 是   | varchar(32)   | 业务员编号   |
| createTime    | 是   | varchar(32)   | 上报时间     |
| sourceApp     | 是   | varchar(32)   | 系统来源     |
| extRemark     | 否   | varchar(32)   | 系统来源备注 |


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|
|attrType|	是|	int	|	|客户标签类别：0 基础  1 线索  2 机会|
|attrGUID|	是|	string|	64|	特征编号|
|oppGUID|	否|	string|	64|	机会编号|
|cstGUID|	是|	string|	64|	客户编号|
|cstName|	是|	string|	64|	客户名称|
|projCode|	是|	string|	64|	项目code|
|projGUID|	是|	string|	64|	项目GUID|
|items|	是|	array||		特征集合|
|items/itemGUID|	是|	string|	64|	特征项目编号|
|items/itemValue|	是|	string|	64|	特征项目值|
|items/parentItemGUID|	是|	string|	64|	父级特征项目编号|
|items/parentItemValue|	是|	string|	100|	父级特性项目值|

### 4.4.9 N-NY-09客户描摹通知(notify_cst_attach_v2)

-   **接口说明**

 ETL同步历史客户特征描摹和增量同步客户特征描摹，产生客户描摹通知到案场
> 消息类型：dc.mq.cst.attach

-   **请求说明**

**请求参数说明**

| 参数                         | 必须 | 类型         | 说明                                                     |
|------------------------------|------|--------------|----------------------------------------------------------|
| cstGUID                      | 是   | string(64)   | 客户ID                                                   |
| oppGUID                      | 是   | string(64)   | 机会编号                                                 |
| userGUID                     | 是   | string(32)   | 业务员编号                                               |
| attachs                      | 是   | array        | 特征列表                                                 |
| attachs/scopeGUID            | 是   | string(64)   | 范围对象编号，例如attachLevel=4,scopeGUID取值为项目编号; attachLevel=16,scopeGUID取值为公司编号;                   |
| attachs/attachGUID           | 是   | string(64)   | 特征编号                                                 |
| attachs/items                | 是   | array        | 特征项列表                                               |
| attachs/items/itemGUID       | 否   | string(64)   | 候选项编号，当attach的input=1时为空 |
| attachs/items/itemCode       | 是   | string(64)   | 两种情况  1、attach的input=1时，取候选项编码 (attachKey)；2、否则，则为输入值|
| attachs/items/parentItemGUID | 否   | string       | 父级特征项编号，attach的input=1时为空                    |
| attachs/items/remark         | 否   | string(2000) | 备注                                                     |
| attachs/items/expireTime     | 否   | datetime     | 过期时间，默认为空，表示永不过期                         |
| attachs/items/sourceChannel  | 否   | string(16)   | 来源渠道  |


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|


### 4.4.10. N-NY-10历史数据同步状态通知（notify_request_result）
* **接口说明**
业务应用提供服务，数据中心进行推送
数据中心同步项目历史数据，并将同步完成状态通知到业务应用
> 消息类型：dc.mq.sync.request.result


+ **请求参数说明**

|参数|是否必须|类型|长度|说明|
|:-------|:---------|:-------|:----|:---------|
|taskID 	|是 	|string 	|64 	|任务编号|
|taskName 	|是 	|string 	|128 	|任务名称|
|startTime 	|是 	|datetime 	|32 	|开始时间YYYY-MM-dd HH:mm&#58;ss|
|finishTime 	|是 	|datetime 	|32 	|完成时间YYYY-MM-dd HH:mm&#58;ss|
|status 	|是 	|int 	|4 	|状态：1成功  2：失败|
|remark 	|是 	|string 	|100 	|备注|



+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|



### 4.4.11.   N-NY-11项目上线通知(notify_proj_publish)
* **接口说明**
项目上线通知，指项目上线时，通过数据中心管理后台，配置上线项目参数后，将项目信息通知到指定案场应用。
> 消息类型：dc.mq.proj.online


+ **请求参数说明**

|参数|是否必须|类型|长度|说明|
|:-------|:---------|:-------|:----|:---------|
|projInfos|是 |string 	||项目信息数组|
|projInfos/projGUID|是|string 	|64|项目编号|
|projInfos/projName|是|datetime 	|64|项目名称|
|projInfos/isOpen|是|datetime 	|10|是否开通移动案场：<br/>1 开通<br/>0 未开通|



+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|




### 4.4.12.   N-NY-12业务客户资料变更通知(notify_proj_cst_update)
* **接口说明**
业务客户资料变更信息通知。
> 消息类型: dc.mq.project.cst
> 应用方：案场

* ** 数据流 **


+ **请求参数说明**

|参数|是否必须|类型|长度|说明|
|:-------|:---------|:-------|:----|:---------|
|cstGUID 	|是 	|string 	|64 	|客户ID
|cstName 	|是 	|string 	|64 	|客户姓名
|gender 	|是 	|int 	|10 	|性别：<br/>1 男  <br/>2 女 <br/>3 未知
|birthDate 	|否 	|string 	|64 	|生日：yyyy-MM-dd HH:mm&#58;ss
|cstType 	|是 	|int 	|10 	|客户类型：<br/>1 个人<br/>2 公司
|mobileTel 	|否 	|string 	|64 	|手机
|officeTel 	|否 	|string 	|64 	|办公电话
|homeTel 	|否 	|string 	|64 	|家庭电话
|sourceApp 	|是 	|string 	|64 	|系统来源
|cardType 	|否 	|int 	|10 	|证件类型
|cardID 	|否 	|string 	|128 	|证件号码
|userGUID 	|否 	|string 	|64 	|业务员（新客户是对应登记人、老客户是 对应修改人）
|address 	|否 	|string 	|64 	|地址
|backupTel1 	|否 	|string 	|64 	|备用号码1
|backupTel2 	|否 	|string 	|64 	|备用号码2
|backupTel3 	|否 	|string 	|64 	|备用号码3
|backupTel4 	|否 	|string 	|64 	|备用号码4
|corporationPerson 	|否 	|string 	|64 	|企业法人
|corporationMobile 	|否 	|string 	|64 	|法人联系电话
|firstContact 	|否 	|string 	|64 	|首选联系人
|corporationScale 	|否 	|string 	|64 	|企业规模
|projGUID 	|是 	|string 	|32 	|项目编号
|extRemark 	|是 	|string 	|32 	|系统来源备注
|cognizeAve 	|否 	|string 	|64 	|认知途径
|fax 	|否 	|string 	|64 	|传真
|family 	|否 	|string 	|64 	|家庭结构<br/>0 未知 <br/>1 三口<br/>2 两口<br/>3 单身<br/>4 三代同堂 
|marriage 	|否 	|int 	|10 	|婚姻状况<br/>0 未知<br/>1 未婚<br/>2 已婚<br/>3 离异<br/>4 丧偶
|workArea 	|否 	|string 	|100 	|工作区域
|homeArea 	|否 	|string 	|100 	|居住区域
|userCode 	|是 	|string 	|64 	|置业顾问账号


+ **响应参数说明**

|参数       |是否必须|类型|长度|说明|
|:--------------------|:--|:-----|:---|:---|
|errcode              |是|int|10|错误码|
|errmsg               |是|string|64|错误描述|




## 4.5 经济人平台接口
### 4.5.1 G-AG-01客户鉴定请求（cst_identify）
-   **接口说明**
同享会中经纪人推荐客户时向数据中心发送校验客户是否有效请求。
 查询该客户在本项目的所有的跟进记录
1. 判断该项目中来自同享会的推荐关系是否存在，存在时exist=1,否则Exist=0。通过exist结合跟进可以判断出同享会推荐还是自然来访、来电客户
2. 不管是否存在，都会返回客户在该项目的所有跟进记录

+ **请求参数说明**

| 参数      | 是否必须 | 类型   | 长度 | 说明     |
|-----------|----------|--------|------|----------|
| cstMobile | 是       | string | 16   | 客户手机 |
| projGUID  | 是       | string | 64   | 项目code |


+ **响应参数说明**

| 参数          | 是否必须 | 类型   | 说明                                      |
|---------------|----------|--------|-------------------------------------------|
| errcode       | 是       | int    | 错误码                                    |
| errmsg        | 是       | string | 错误描述                                  |
| exist         | 是       | int    | 客户是否存在（1：是；0：否）              |
| isBlack       | 是       | int    | 是否黑白单（1：是；0：否）暂不支持，默认0 |
| isOwner       | 是       | Int    | 是否业主(0:否,1:是)                       |
| isStaff       | 是       | Int    | 是否员工(0:否,1:是)                       |
| isMember      | 是       | Int    | 是否会员(0:否,1:是)                       |
| data/list     | 否       | object | 跟进记录                                  |
| followTime    | 是       | string | 跟进时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”|
| followType   | 是       | String | 跟进类别                                  |
| followContent | 是       | string | 跟进内容                                  |
| projGUID      | 是       | string | 项目编码                                  |

### 4.5.2 N-AG-02客户资料合并通知(不实现)（cst_merge_notify）

-   **接口说明**

客户资料在数据中心合并后，将合并的两个客户ID通知经纪人平台。


+ **请求参数说明**

| 参数       | 必须 | 类型     | 长度 | 说明                                        |
|------------|------|----------|------|---------------------------------------------|
| cstRetain  | 是   | int      |      | 合并时保留继续使用的客户ID                  |
| cstDropped | 是   | int      |      | 合并时丢弃不再使用的客户ID                  |
| mergeTime  | 是   | datetime |      | 合并时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]” |


+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

### 4.5.3 G-AG-03经纪人鉴定请求（agent_identify）
-   **接口说明**

同享会中经纪人注册时向数据中心获取信息经纪人的身份信息，鉴定经纪人是否为业主、员工、会员。

+ **请求参数说明**

| 参数   | 是否必须 | 类型   | 长度 | 说明       |
|--------|----------|--------|------|------------|
| mobile | 是       | string | 16   | 手机号码   |
| name   | 否       | string | 15   | 姓名       |
| cardId | 否       | string | 18   | 身份证号码 |


+ **响应参数说明**

| 参数     | 是否必须 | 类型   | 说明                   |
|----------|----------|--------|------------------------|
| errcode  | 是       | int    | 错误码                 |
| errmsg   | 是       | string | 错误描述               |
| isOwner  | 是       | int    | 是否业主(1：是；0：否) |
| isStaff  | 是       | int    | 是否员工(1：是；0：否) |
| isMember | 是       | int    | 是否会员(1：是；0：否) |

### 4.5.4 P-AG-04经纪人新增（agent_create）

-   **接口说明**

同享会中经纪人注册成功时将经纪人信息上报到数据中心。

**请求参数说明**

| 参数            | 是否必须                | 类型       | 长度 | 说明                      |
|-----------------|-------------------------|------------|------|---------------------------|
| name            | 是                      | String     | 15   | 经纪人姓名                |
| Mobile          | 是                      | String     | 16   | 手机号码                  |
| areaCode        | 是                      | int        |      | 所在城市ID                |
| agentClasses    | 是                      | int        | 2    | 经纪人类别<br/>（代理公司 = 1, <br/>中介公司 = 2,<br/>3,万科员工 = 4,<br/>万科合作方 = 5, <br/>独立经纪人 = 6）           |
| proxyCompanyId  | 否，经纪人类型为1时必须 | string     | 64   | 所在代理公司              |
| agencyCompanyId | 否，经纪人为2时必须     | string     | 64   | 所在中介公司              |
| comment         | 否                      | String(50) | 50   | 中介公司经纪人：所在门店<br/>万科员工：所在部门<br/>万科业主：所在物业|
                                                                 
                                                                 
+ **响应参数说明**

| 参数      | 是否必须 | 类型   | 长度 | 说明                               |
|-----------|----------|--------|------|------------------------------------|
| errcode   | 是       | int    |      | 错误码                             |
| errmsg    | 是       | string |      | 错误描述                           |
| agentGUID | 是       | string | 64   | 成功后返回该经纪人在数据中心的GUID|

### 4.5.5 P-AG-05经纪人更新（agent_update）

-   **接口说明**

同享会将经纪人的更新信息（包括个人资料和积分信息）上报到数据中心


+ **请求参数说明**

| 参数            | 是否必须                | 类型       | 长度 | 说明                        |
|-----------------|-------------------------|------------|------|-----------------------------|
| agentGUID       | 是                      | string     | 20   | 经纪人ID                    |
| name            | 是                      | string     | 15   | 姓名                        |
| mobile          | 否                      | string     | 16   | 手机号码                    |
| agentClasses    | 否                      | Int        |      | 经纪人类别（代理公司= 1,<br/>中介公司 = 2, **粗体文本**万科业主 = 3, <br/>万科员工 = 4, <br/>万科合作方 = 5, <br/>独立经纪人 = 6）  |
| areaCode        | 否                      | int        |      | 所在城市ID                  |
| proxyCompanyId  | 否，经纪人类型是1时必须 | string     | 64   | 代理公司ID                  |
| agencyCompanyId | 否，经纪人类型是2时必须 | string     | 64   | 中介公司ID                  |
| totalPoint      | 否                      | int        |      | 累计积分                    |
| point           | 否                      | int        |      | 可用积分                    |
| level           | 否                      | Int        |      | 经纪人等级<br/>（普通经纪人 = 1,<br/>铜牌经纪人 = 2, <br/>银牌经纪人 = 3, <br/> 金牌经纪人 = 4,  <br/> 钻石经纪人 = 5）      |
| comment         | 否                      | String(50) | 100  |中介公司经纪人：所在门店  <br/>万科员工：所在部门   <br/>万科业主：所在物业|
| status          | 是                      | Int        |      | 1有效/0无效                 |


+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |


### 4.5.6 P-AG-06客户推荐上报（agent_recommend）

-   **接口说明**
同享会中经纪人成功推荐客户的推荐信息（经纪人、客户、项目）上报到数据中心，有可能指定代理公司、置业顾问、预约时间。
1.  如果手机号码没有关联客户，则新增客户和客户手机映射关系；否则使用已经存在的客户编号
2.  新增一条经纪人推荐客户关系记录
3.  返回同享会客户编号
4.  产生一线索信息通知消息

+ **消息流**
产生[线索信息消息](#4.4.2 N-NY-02线索信息通知接口(s_lead_notify))，消息类型：dc.mq.cst.lead

+ **请求参数说明**

| 参数           | 是否必须 | 类型   | 长度 | 说明                     |
|----------------|----------|--------|------|--------------------------|
| agentGUID      | 是       | string | 20   | 经纪人ID                 |
| cstName        | 是       | string | 15   | 客户姓名                 |
| cstMobile      | 是       | string | 16   | 客户手机号码             |
| projGUID       | 是       | string | 64   | 项目编号                 |
| productType    | 否       | string | 64   | 产品品类                 |
| proxyCompanyId | 否       | string | 64   | 代理公司ID               |
| consultantId   | 是       | string | 64   | 置业顾问ID               |
| comment        | 否       | string | 100  | 备注                     |
| appointTime    | 否       | int    | 10   | 预约上门日期，UTC时间戳（精确到秒）     |
| gender         | 否       | Int    | 2    | 1男 2 女                 |
| prizeRule      | 否       | String | 500  | 对结佣规则的描述         |
| isAccompany    | 否       | int    | 2    | 是否陪同上门（1是0否）   |
| reportTime     | 否       | int    | 10   | 推荐时间，UTC时间戳（精确到秒）     |
| expireTime     | 否       | int    | 10   | 过期时间，即何时过保护期 |


+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

### 4.5.7 G-BA-11城市列表获取（base_city_list）

1：调用服务中心base\_get\_city\_list接口

-   **接口说明**
 同享会定时向数据中心发送城市列表同步请求。

+ **请求参数说明**

| 参数     | 是否必须 | 类型 | 说明                             |
|----------|----------|------|----------------------------------|
| page     | 是       | int  | 页码                             |
| pageSize | 是       | int  | 分页大小，取值范围是［10，1000］ |


**响应参数说明**

| 参数           | 是否必须 | 类型   | 长度 | 说明             |
|----------------|----------|--------|------|------------------|
| errcode        | 是       | int    |      | 错误码           |
| errmsg         | 是       | string |      | 错误描述         |
| data/totalPage | 是       | int    |      | 记录总页数       |
| data/page      | 是       | int    |      | 本次查询页码     |
| data/list      | 否       | array  |      | 记录列表         |
| cityCode       | 是       | int    |      | 城市ID           |
| cityName       | 是       | string | 64   | 城市名称         |
| status         | 是       | int    |      | 状态，1有效0无效 |

### 4.5.8 G-BA-12置业顾问获取（base_proxyCompanysales_list）
-   **接口说明**
同享会定时向数据中心发送案场的置业顾问信息同步请求
1:调用服务中心接口base\_get\_consultant\_list\_v2

+ **请求参数说明**

| 参数     | 是否必须 | 类型 | 说明                             |
|----------|----------|------|----------------------------------|
| page     | 是       | int  | 页码                             |
| pageSize | 是       | int  | 分页大小，取值范围是［10，1000］ |


+ **响应参数说明**

| 参数           | 是否必须 | 类型   | 长度 | 说明         |
|----------------|----------|--------|------|--------------|
| errcode        | 是       | int    |      | 错误码       |
| errmsg         | 是       | string |      | 错误描述     |
| data/totalPage | 是       | int    |      | 记录总页数   |
| data/page      | 是       | int    |      | 本次查询页码 |
| data/list      | 否       | array  |      | 记录列表     |
| consultantId   | 是       | string | 64   | 销售人员ID   |
| consultantName | 是       | string | 15   | 销售人员姓名 |
| proxyCompanyId | 是       | int    | 64   | 代理公司GUID |
| enable         | 是       | int    | 2    | 1有效/0无效  |
| projGUID       | 是       | String | 64   | 所在项目code |
| mobile         | 是       | String | 16   | 手机号码     |

### 4.5.9 G-BA-13案场代理获取（base_proxyCompany_list）
-   **接口说明**
同享会定时向数据中心发送案场的代理公司信息同步请求
（调用服务中心接口base\_get\_company\_proj）

+ **请求参数说明**

| 参数         | 是否必须 | 类型     | 说明                                              |
|--------------|----------|----------|---------------------------------------------------|
| page         | 是       | int      | 页码                                              |
| pageSize     | 是       | int      | 分页大小，取值范围是［10，1000］                  |
| lastSyncTime |否        | datetime | 上一次同步时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]” |


+ **响应参数说明**

| 参数           | 是否必须 | 类型   | 长度 | 说明         |
|----------------|----------|--------|------|--------------|
| errcode        | 是       | int    |      | 错误码       |
| errmsg         | 是       | string |      | 错误描述     |
| data/totalPage | 是       | int    |      | 记录总页数   |
| data/page      | 是       | int    |      | 本次查询页码 |
| data/list      | 否       | array  |      | 记录列表     |
| companyId      | 是       | int    |      | 公司ID       |
| companyName    | 是       | string | 128  | 公司名称     |
| projGUID       | 是       | string | 64   | 所在项目GUID |
| enable         | 是       | int    | 2    | 1有效/0无效  |

### 4.5.10 P-BA-14中介代理上报(不实现)（base_agencyCompany_list）

-   **接口说明**
 经纪人平台将中介公司信息（包括新增和修改）实时上报给数据中心
1.  新增中介代理公司时，中介代理公司ID（uuid）由数据中心产生
2.  已经存在的判断依据：中介公司名称相同即表示已经存在


+ **请求参数说明**

| 参数      | 是否必须 | 类型       | 长度 | 说明                            |
|-----------|----------|------------|------|---------------------------------|
| name      | 是       | String(20) | 128  | 中介公司名称                    |
| cityCode  | 是       | String(20) | 10   | 中介公司所在城市ID              |
| opType    | 是       | int        | 2    | 操作类型:1 Add、2 Modi 3 delete |
| Type      | 是       | int        | 2    | 1中介、2代理                    |
| companyId | 否       | String     | 64   | 修改、删除时必须提供            |


+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明                |
|---------|----------|--------|---------------------|
| errcode | 是       | int    | 错误码              |
| errmsg  | 是       | string | 错误描述            |
| status  | 是       | int    | 状态码，成功：1，失败：2              |
| message | 是       | string | 附加信息<br/>状态1时：中介公司ID<br/>状态2时：已存在      |

### 4.5.11 P-BA-15同享会预约上报（agent_appoint）
-   **接口说明**
 同享会将客户预约看房的信息实时上报给数据中心


+ **请求参数说明**

| 参数        | 是否必须 | 类型   | 长度 | 说明                    |
|-------------|----------|--------|------|-------------------------|
| projGUID    | 是       | string | 64   | 项目code                |
| cstMobile   | 是       | string | 16   | 客户手机                |
| cstName     | 是       | string | 32   | 客户姓名                |
| comment     | 是       | string | 100  | 备注说明，中文100字以内 |
| appointTime | 是       | int    | 10   | 预约看房时间            |
| reportTime  | 是       | int    | 10   | 预约时间                |


+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

### 4.5.12 P-BA-16无效推荐上报(不实现)（agent_recommend_cancel）
-   **接口说明**
同享会将推荐客户失败的信息上报给数据中心。


+ **请求参数说明**

| 参数         | 是否必须 | 类型   | 长度 | 说明                      |
|--------------|----------|--------|------|---------------------------|
| mobile       | 是       | string | 16   | 客户手机                  |
| name         | 是       | String | 15   | 客户姓名                  |
| projGUID     | 是       | string | 64   | 项目code                  |
| cancelCause  | 是       | string | 500  | 无效原因                  |
| agentClasses | 是       | int    | 2    | 经纪人类型<br/>（代理公司 = 1,<br/>中介公司 = 2,<br/>万科业主 = 3, <br/>万科员工 = 4,<br/>万科合作方 = 5,<br/>独立经纪人 = 6）           |
| agentName    | 是       | string | 15   | 经纪人姓名                |
| agentMobile  | 是       | string | 16   | 经纪人电话                |
| reportTime   | 是       | int    | 10   | 推荐时间                  |


+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

### 4.5.13 N-BA-10分配置业顾问通知（consultant_assign_create_notify）
-   **接口说明**
数据中心将来自案场的为客户分配的分配置业顾问信息通知给同享会

+ **数据流**
由[分配置业顾问上报](#4.5.18 P-BA-18分配置业顾问上报（assign_create）)产生，由service-message下发。

+ **请求参数说明**

| 参数         | 是否必须 | 类型   | 长度 | 说明             |
|--------------|----------|--------|------|------------------|
| projGUID     | 是       | string | 64   | 转换后的项目code |
| oriProjGUID  | 是       | string | 32   | 原始项目code     |
| consultantId | 是       | String | 64   | 置业顾问ID       |
| cstGUID      | 是       | String | 20   | 客户ID           |


+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

### 4.5.14 N-BA-11客户状态通知（cst_status_notify）
-   **接口说明**
数据中心将客户的状态更新信息通知同享会，状态包括（预约、到访、认筹、认购、签约、回款）。

> 消息类型：dc.mq.cst.status

+ **数据流**
消息由[跟进上报接口](#4.2.8 P-CU-07跟进信息上报（cst_follow_update）)产生，由service-message下发。

+ **请求参数说明**

| 参数          | 是否必须 | 类型     | 长度 | 说明                                        |
|---------------|----------|----------|------|---------------------------------------------|
| cstGUID       | 是       | String   | 20   | 客户ID                                      |
| projGUID      | 是       | string   | 64   | 转换后的项目code                            |
| oriProjGUID   | 是       | string   | 32   | 原始项目code                                |
| followTime    | 是       | datetime | 32   | 跟进时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]” |
| followType    | 是       | int      | 2    | 跟进类别<br/>1=预约<br/>2=来电<br/>3=到访<br/>4=认筹 <br/>5=认购<br/>6=签约<br/>7=回款<br/>8=其他                                       |
| followContent | 否       | String   | 200  | 跟进内容                                    |
| mny           | 否       | float    |      | 认购金额、认筹金额、签约金额                |
| state         | 否       | int      | 10   | 状态：0:新增，1:退房，2:换房，3:作废，4:取消/撤消  |
| roomGUID      | 否       | string   | 64   | 房间GUID                                    |
| room          | 否       | string   | 128  | 楼栋号+”-”+房间号(车位号)                   |
| houseType     | 否       | string   | 64   | 房型(店铺、车位、户型)                      |
| followGUID    | 否       | String   | 64   | 跟进GUID |


+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

### 4.5.15 N-BA-12无效推荐通知(不实现)（cst_cancel_notify）
-   **接口说明**
数据中心将同享会新提交的无效推荐信息通知给案场


+ **请求参数说明**

| 参数          | 是否必须 | 类型     | 长度 | 说明                                        |
|---------------|----------|----------|------|-----------------|
| projGUID      | 是       | string   | 64   | 转换后的项目code|
| oriProjGUID   | 是       | string   | 32   | 原始项目code|
| recommandTime | 是       | datetime | 32   | 推荐时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]” |
| agentClasses  | 是       | int      | 2    | 经纪人类型<br/>（代理公司 = 1,<br/>中介公司 = 2,<br/>万科业主 = 3,<br/>万科员工 = 4,<br/>万科合作方 = 5,<br/>独立经纪人 = 6）                                  |
| agentName     | 是       | string   | 15   | 经纪人姓名|
| agentMobile   | 是       | string   | 16   | 经纪人电话|
| cstMobile     | 是       | string   | 16   | 客户电话  |
| cstName       | 否       | string   | 15   | 客户姓名  |
| cancelCause   | 是       | string   | 500  | 无效原因  |


+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

### 4.5.16 N-BA-13客户推荐通知（recommend_notify）（已作废）
-   **接口说明**
数据中心将同享会新提交的推荐客户信息、客户预约信息通知给案场。

+ **数据流**
通知消息由[客户推荐上报接口](#4.5.6 P-AG-06客户推荐上报（agent_recommend）
)产生，由service-message下发。

**请求参数说明**

| 参数               | 是否必须       | 类型       | 长度    | 说明                                            |
|--------------------|----------------|------------|---------|-------------------------------------------------|
| projGUID           | 是             | string     | 64      | 转换后的项目code                                |
| leadGUID           | 是             | string     | 64      | 线索GUID                                        |
| cstGUID            | 是             | string     | 20      | 客户ID                                          |
| cstName            | 是             | string     | 15      | 客户名字                                        |
| cstTel             | 是             | string     | 16      | 客户电话                                        |
| cstMobile          | 是             | string     | 16      | 客户电话                                        |
| recommendTime      | 是             | datetime   | 32      | 推荐时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”     |
| appointTime        | 否             | datetime   | 32      | 预约上门时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]” |
| comment            | 否             | string     | 100     | 推荐备注                                        |
| sources            | 否             | int        | 2       | 客户来源渠道（1同享会）                         |
| recommandType      | 是             | int        | 2       | 推荐客户类型（1推荐 2预约）                     |
| cstType            | 是             | int        | 2       | 客户类型                                        |
| cstGender          | 是             | int        | 2       | 客户性别                                        |
| leadType           | 是             | int        | 2       | 线索类型                                        |
| description        | 否             | String     | 64      | 线索描述                                        |
| leadSource         | 是             | int        | 2       | 线索来源                                        |
| topic              | 是             | String     | 64      | 线索主题                                        |
| cognizeAve         | 否             | String     | 64      |                                                 |
| status             | 是             | int        | 2       | 线索状态                                        |
| brokerName         | 否             | String     | 16      |经纪人姓名|
| brokerPhone        | 否             | String     | 16      |经纪人手机号|
| userId             | 否             | String     | 64      |置业顾问ID|


+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

### 4.5.17 P-BA-17干预状态上报(不实现)（intervene_create）
-   **接口说明**
同享会将认为干预的推荐信息状态（有效、无效）上报到数据中心。
1.  修改客户推荐关系状态enable字段
2.  记录干预状态记录
3.  产生干预状态通知消息


+ **请求参数说明**

| 参数       | 是否必须 | 类型   | 长度 | 说明                                   |
|------------|----------|--------|------|------------------|
| projGUID   | 是       | string | 64   | 项目code         |
| cstGUID    | 是       | string | 20   | 客户ID           |
| agentGUID  | 是       | String | 20   | 推荐经纪人GUID   |
| status     | 是       | int    |      | 状态，0为无效，1 为有效<br/>与成功和失败状态不同，需要两个字段区别  |
| comment    | 否       | string | 500  | 备注             |
| reportTime | 是       | int    | 10   | 干预上报时间     |
| expireTime | 否       | int    | 10   | 过期时间（保护期）|


+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

### 4.5.18 P-BA-18分配置业顾问上报（assign_create）
-   **接口说明**
案场将为来自同享会推荐的客户分配的置业顾问信息上报到数据中心。

+ **消息流**
触发[分配置业顾问通知](#4.5.13 N-BA-10分配置业顾问通知（consultant_assign_create_notify）)，消息类型：dc.mq.opp.assign

+ **请求参数说明**

| 参数         | 是否必须 | 类型   | 长度 | 说明       |
|--------------|----------|--------|------|------------|
| projGUID     | 是       | string | 64   | 项目code   |
| cstGUID      | 是       | string | 20   | 客户ID     |
| consultantId | 是       | string | 64   | 置业顾问id |


+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

### 4.5.19 N-BA-14干预状态通知(不实现)（intervene_notify）
-   **接口说明**
数据中心将来自案场的干预状态信息通知给案场


+ **请求参数说明**

| **参数**    | **是否必须** | **类型** | **长度** | **说明**                                              |
|-------------|--------------|----------|----------|-------------------------------------------------------|
| cstGUID     | 是           | string   | 20       | 客户ID                                                |
| projGUID    | 是           | string   | 64       | 转换后的项目code                                      |
| oriProjGUID | 是           | string   | 32       | 原始项目code                                          |
| updatetime  | 是           | datetime | 32       | 时间, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]”               |
| Status      | 是           | int      | 2        | 状态，0为无效，1为有效<br/>与成功和失败状态不同，需要两个字段区别                 |
| Comment     | 否           | String   | 500      | 备注                                                  |
| expireTime  | 否           | datetime | 32       | 过期时间（保护期）, 格式”yyyy-MM-dd HH:mm&#58;ss\[.SSS\]” |


+ **响应参数说明**

| **参数** | **是否必须** | **类型** | **说明** |
|----------|--------------|----------|----------|
| errcode  | 是           | int      | 错误码   |
| errmsg   | 是           | string   | 错误描述 |

# 5 错误码定义

## 5.1系统错误码
----------

| 错误码 | 描述                 |
|--------|----------------------|
| 0      | 成功                 |
| -1     | 未知错误             |
| 1001   | 缺少必须参数\[%s\]   |
| 1002   | 参数类型错误\[%s\]   |
| 1003   | 不支持的请求方式     |
| 1004   | 请求数据格式错误     |
| 1005   | 系统处理失败         |
| 1006   | 请求数据过大         |
| 1007   | 请求数据缺失         |
| 1008   | 不支持的接口请求     |
| 1009   | 接入验证失败         |
| 1010   | 接口权限验证失败     |
| 1011   | 未知业务应用         |
| 1012   | 查询的记录不存在     |
| 1013   | 消息序列号重复       |
| 1014   | 响应返回数据格式错误 |
| 1015   | 消息序列号格式错误   |

## 5.2 业务错误码
----------

业务错误码包含系统外的所有错误码，其中客户信息相关的错误码为2xxx段，经纪人相关错误码为3xxx段，基础数据错误码为4xxx段，客户行为服务类为5xx段。各业务可通用错误码为9xx段。

### 5.2.1 业务通用错误码

| 错误码 | 描述               |
|--------|--------------------|
| 9001   | 非法身份证号码     |
| 9002   | 非法手机号码       |
| 9003   | 销售机会编号不存在 |

### 5.2.2 客户类错误码

| 错误码 | 描述             |
|--------|------------------|
| 2001   | 客户不存在       |
| 2002   | 客户已经存在     |
| 2003   | 手机号码已被占用 |
| 2004   | 证件号码已被占用 |

### 5.2.3 经纪人类错误码

| 错误码 | 描述 |
|--------|------|
| 3001   |      |
| 3002   |      |
| 3003   |      |

### 5.2.4 基础数据类错误码

| 错误码 | 描述             |
|--------|------------------|
| 4001   | 项目不存在       |
| 4002   | 置业顾问不存在   |
| 4003   | 置业顾问已经存在 |
| 4004   | 代理公司已经存在 |
| 4005   | 代理公司不存在   |

### 5.2.5 客户行为服务类错误码

| 错误码 | 描述 |
|--------|------|
| 5001   |      |
| 5002   |      |
| 5003   |      |

### 5.2.6 推送通知类错误码

| 错误码 | 描述         |
|--------|--------------|
| 6001   | 消息推送失败 |
