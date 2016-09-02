**万科地产开放接口规范说明书**
-----------
### 变更记录
| 版本号      |    修改原因/内容 | 修改人  | 修改时间  |
| --------	| ------------- :  | :----- | -----:|
| V1.1		| 编写接入认证接口、<br>同享会和案场接口定义、<br>全局错误码定义 			|  余世明   |2014-07-08|
| V1.2		| 格式调整，认证与流程内容补充 			|  余世明   |2014-07-08|
| V1.3		| 分类调整与接口编号 			|  余世明   |2014-07-08|
| V1.4		| P-CU-04客户资料更新、<br>P-CU-05来访客户新增接口增加了证件及联系地址字段 			|  余世明   |2014-07-08|
| V1.5		| p-BA-02项目信息获取更新、N-BS-09客户状态通知更新、<br>P-BA-10项目上线情况上报接口新增 			|  余世明   |2014-07-08|
| V1.6		| 去掉总体规范中接入认证未实现的echo 			|  余世明   |2014-07-08|
| V1.7		| 修订变更接口，以及新增接口：<br>一、4.1.2 P-CU-04客户资料更新（cst_mobile_update），<br>增加证件类型，增加客户类型字段<br>二、增加4.1.4 P-CU-05-v2来访客户新增V2版(cst_reception_create_v2)<br>三、4.1.5 N-CU-06客户主档新增(cst_account_create)，<br>增加证件类型，增加客户类型字段<br>四、4.1.6 N-CU-07客户主档更新（cst_account_update），<br>增加证件类型，增加客户类型字段<br>五、增加4.1.10 N-CU-10-v2 客户资料修改通知V2版（cst_changeInfo_notify_v2）<br>六、增加4.1.11 N-CU-11客户资料新增结果通知（cst_reception_create_notify）<br>七、增加4.1.12 N-CU-12客户资料合并通知（cst_merge_notify）暂未上线<br>八、4.2.4 P-AG-04客户推荐上报（agent_recommend）增加expireTime字段<br>九、4.4.11 P-BS-12干预状态上报（intervene_create）增加expireTime字段<br>十、4.4.13 N-BS-14干预状态通知（intervene_notify）增加expireTime字段<br>十一、增加4.4.15 P-BS-16销售机会新增(sales_leads_create)<br>十二、增加4.4.16 P-BS-17销售机会更新上报(sales_leads_update_report)| 余世明  |2014-07-08|
| V1.8		| 一、在明源与同享会间【登记客户】和【更新客户】接口中<br>增加字段“OfficeTel”、“HomeTel”、“Nationality”，<br>分别对应明源系统p_Customer 表中的“OfficeTel”、“HomeTel”、“Nationality”<br>二、所有数据中心通知给应用接口增加oriProjCode字段，<br>表示转换前的原始项目code,之前存在的projCode表示转换后的 项目code<br>三、数据中心调用明源接口协议升级|  余世明  |2014-07-08|
| V1.9		| 4.1.1	客户状态通知接口：N-BS-09客户状态通知（cst_status），增加字段followGUID，<br>表示跟进记录的唯一标识，应用可以根据它来做唯一判断 			|  余世明   |2014-07-08|
| V2.0		| 现在接口：4.1.11	N-CU-13客户机会资料查询接口（cst_cstOpp_list） 			|  余世明   |2014-07-08|
| V2.1		| 1、	客户鉴定接口，请求参数projcode支持多个项目，多个时以逗号分开，<br>获取多个项目的跟进信息<br>2、	客户状态通知接口：增加cstinfo 字段对象，即通知消息中增加了认购、<br>签约时的客户主档信息。 			|  余世明   |2014-07-08|
| V2.2		| 4.1.2	N-BS-09客户状态通知（cst_status）<br>接口之前是：room=bldName+"-"+room.getRoom()<br>改为：room=bldName+"-" + room.getUnit()+"-"+room.getRoom()<br>注意：房产数据没有单元数据时忽略处理 			|  余世明   |2014-07-08|
| V2.3		| 4.1.2	P-CU-04客户资料更新接口,新增置业顾问编号：<br>consultantId	是	string	64	置业顾问人员ID,暂没实现 			|  余世明   |2014-07-08|
|:star: V2.4	|  [P-BS-02中介代理上报（base_agencyCompany_list）<br>扩展一个公司类型:3 企业用户](#4.4.2	P-BS-02中介代理上报（base_agencyCompany_list）)|余世明|2016/1/25|

#1 前言
本接口规范，适用于也仅适用于万科数据中心项目，业务功能开放接口。适用于包括但不限于同享会、案场APP、万客会等，接入数据中心所遵循的标准。
	本文描述的所有接口，数据来源主要有明源数据的清洗导入、案场应用通过接口上报、管理员维护，因此，对于不是系统产生的数据，不承诺所有接口返回数据准确性。
#2 总体规范
##2.1 接口规范
* 所有接口调用，均遵守`HTTP`和`HTTPS`协议，支持`GET`与`POST`两种方式，拒绝其它请求方式；统一使用`UTF-8`编码；包括消息内字段，及所有值。
* 所有返回消息或参数，均以JSON格式进行返回，对于二进制数据，则通过其它模块，以资源管理形式进行库维护。
* 所有查询类接口，一次返回记录数不超过*1000*条,数据大小不超过*5M*。
* 所有请求中，必须包含认证必须字段，否则视为无效请求，予以拒绝。
* 所有时间字段，均以UTC秒值传输；所有数字均以十进制表示。 编程示例：
       Java：System.currentTimeMillis() / 1000
       C/C++：time(NULL)
* 所有上行消息的JSON，必须包含`header`、`cmd`和`data`三大部分，其中头部包含业务应用的身份验证字段。格式示例：
``` json
{
    "header": {},
    "cmd": {},
    "data": {}
}
```
* 所有接口的请求地址格式，均为`http://server_uri/datacenter/api`，其中`server_uri`为数据中心部署地址
* 所有响应消息中，除`errcode`和`errmsg`外，所有必须参数，均指在`errcode`为0(即成功)的情况下才是必须

##2.2 名词定义
- 业务应用
	指接入数据中心的任何第三方应用，包括但不限于同享会、万客会、案场APP等
- `appid`
数据中心相关系统的唯一标示
- `appkey`
	数据中心系统分配给业务应用的密钥
- `token`
	数据中心系统分配给业务应用的签名，用于双方接入认证使用
##2.3 系统编号（appid）
- 数据中心：*100*
- 经纪人平台：*201*
- 案场系统：*20x*
##2.4 序列号的定义
- 对应`head`包中的`sid`定义：
数据中心与应用系统传输的每一条接口命令都有一个序列号，序列号由命令源系统产生并唯一标记一条命令；也就是说，数据中心系统中任何两个命令的序列号都不相同。对于数据中心主动推送到业务应用（经纪人平台、案场管理等）的消息，例如数据中心向案场发送一条推荐客户信息，此时序列号由数据中心生成（此时命令源节点为数据中心）。
序列号分成三部分，每部分为一个整数：
    + 第一部分表示命令源系统的编号
    + 第二部分表示命令产生的日期和时间，格式为十进制的*yymmddhhmm*，比如14年11月20日20时32分25秒产生的消息，其第二部分为十进制*141120203225*
    + 第三部分由0开始，最大值是99999，循环进位，直到进位满了之后再清零，重新开始计数, 不够5位，左补0
![](images/msgid.png)

#3 接入认证
##3.1 推送认证（数据中心->业务应用）

```seq
数据中心->业务应用: 推送 
Note right of 业务应用: 验证\n处理 
业务应用->数据中心: 返回响应
业务应用-->数据中心: 返回超时
```
- 认证说明
系统为每个业务应用分配帐号信息，包括但不限于`appid`、`token`、`appkey`，其中`appid`和`appkey`每个应用唯一，`token`则用于双方接入认证使用的验证码，可随意更改。
	通信双方每次发起请求必须先认证用户合法性，系统每次推送时JSON包体必须带上header部分，如果认证通过，返回请求处理的结果数据；如果认证不通过，返回空或其它描述信息。
	数据中心推送时，header会包含`timestamp`、`signature`、`nonce`、`echostr`和`sid`五个参数，业务应用接收到请求后，根据`token`、`timestamp`、`nonce`这三个参数进行计算验证，验证成功后响应本次通知的响应结果，数据中心即认为本次推送成功；若响应内容不是接口规范的结构化数据或*5秒*内没有返回，数据中心则认为本次推送失败。
	sid则用于服务器重传和业务应用去重参考，即一次推送失败后，系统会每间隔5秒重新推送一次，最多尝试三次。业务应用则可根据`sid`判断是否为同一消息，即判断是否因网络环境等异常而发生重复推送。
- 加密/校验流程如下
    + 将`token`、`timestamp`、`nonce`三个参数进行字典序排序
    + 将三个参数字符串拼接成一个字符串进行`sha1`加密
    + 开发者获得加密后的字符串可与`signature`对比，标识该请求来源于数据中心
- 请求示例说明
``` javascript
//   http请求方式: POST
{
    "header": {
        "signature": "13756789045",
        "nonce": "str",
        "sid": "20114072612151200001"
    },
    "cmd": {
        "name": "newUserNotify"
    },
    "data": {
        "mobile": "15812345678"
    }
}
``` 
+ **请求参数说明**

| 参数	|必须	|类型|说明|
| :-------- | :--------|:--------|:--|
|header/signature|是|string|加密签名，`signature`结合开发者填写的`token`参数和请求中的`timestamp`、`nonce`两个参数。|
|header/timestamp|是|string|时间戳|
|header/nonce|是|string|随机数|
|header/echostr|是|string|随即字符串，业务应用验证后原样返回|
|header/sid|是|string|消息序列号|
+ **响应参数说明**

| 参数	|必须	|类型|说明|
| :-------- | :--------|:--------|:--|
|errcode|是|int|错误码|
|errmsg|是|string|错误描述|

##3.2 业务调用认证（业务应用->数据中心）
```seq
业务应用->数据中心: 推送 
Note right of 数据中心: 验证\n处理 
数据中心->业务应用: 返回响应
```
- 认证说明
通信双方每次发起请求必须先认证用户合法性，每次请求时JSON包体必须带上`header`部分，数据加密算法和接入认证相同，认证通过返回请求数据；如果认证不通过，返回错误信息。
- 请求示例说明
``` javascript
//   http请求方式: POST
{
    "header": {
        "appid": 123456789,
        "signature": "13756789045",
        "nonce": "20114072612151200001"
    },
    "cmd": {
        "name": "queryUser"
    },
    "data": {
        "mobile": "15812345678"
    }
}
``` 
+ **请求参数说明**

| 参数	|必须	|类型|说明|
| :-------- | :--------|:--------|:--|
|header/appid|是|string|业务应用的`appid`|
|header/signature|是|string|加密签名，`signature`结合开发者填写的`token`参数和请求中的`timestamp`、`nonce`两个参数。|
|header/timestamp|是|string|时间戳|
|header/nonce|是|string|随机数|
|header/sid|是|string|消息序列号|
+ **响应参数说明**
接口会返回下述JSON数据包给客户端
``` json
{
    "errcode": 0,
    "errmsg": "成功",
    "data": {
        "name": "zhangsan",
        "cardid": "368412190001013030",
        "cardtype": 1
    }
}
``` 
> 若`errcode`不为0,即成功；则`data`无效，或不包含`data`,`errcode`参见后文全局错误码定义。

#4	开放接口
（为减少篇幅冗余，所有接口中示例消息体，均省略header部分）
##4.1	客户接口
###4.1.1	G-CU-01客户鉴定请求(cst_identify)
+ **接口说明**
同享会中经纪人推荐客户时向数据中心发送校验客户是否有效请求。
查询该客户在请求的多个项目下的所有的跟进记录
  - `1.`判断该项目中来自同享会的推荐关系是否存在，存在时exist=1,否则
Exist=0。通过exist结合跟进可以判断出同享会推荐还是自然来访、来电客户
  - `2.`不管是否存在，都会返回客户在该项目的所有跟进记录。
  - `3.`包含实时叛客和本地叛客：
      - `a)`实时叛客：数据中心实时查询请求项目下的明源数据库的跟进、认筹、认购、签约
      - `b)`本地叛客：查询数据中心请求项目及其分期项目下的的所有跟进记录；如果请求项目是推广项目，查询所有的真实项目，以分期项目返回。
+ **请求格式说明**
``` json
{
    "cmd": {
        "name": "cst_identify"
    },
    "data": {
        "cstMobile": "13611112222",
        "projCode": "1000000"
    }
}
```
+ **请求参数说明**

| 参数	|必须	|类型|长度|说明1|
| :-------- | :--------|:--------|:--------|:--|
|cstMobile|是|string|16|客户手机|
|projCode|是|string|64|项目code,支持多个项目code，多个时，以逗号分隔|

+ **响应格式说明**
``` json
{
    "errcode": 0,
    "errmsg": "成功",
    "data": {
        "exist": 1,
        "isBlack": 0,
        "isOwner": 0,
        "isStaff": 0,
        "isMember": 0,
        "list": [
            {
                "followTime": 1404691200,
                "followType": 1,
                "followContent": "预约"
            },
            {
                "followTime": 1404691200,
                "followType": 2,
                "followContent": "到访"
            }
        ]
    }
}
```
+ **响应参数说明**

| 参数	|必须	|类型|长度|说明|
| :-------- | :--------|:--------|:--------|:--|
|exist|是|int|10|记客户是否存在（1：是；0：否）|
|isBlack|是|int|10|是否黑白单（1：是；0：否）|
|isOwner|是|int|10|是否业主(0:否,1:是)|
|isStaff|是|int|10|是否员工(0:否,1:是)|
|isMember|是|int|10|是否会员(0:否,1:是)|
|list|否|jsonArray|N/A|跟进记录,json数组|
|list/followTime|是|int|64|楼跟进时间|
|list/followType|是|int|4|跟进类别：<br>1=预约<br>2=来电<br>3=到访<br>4=认筹<br>5=认购<br>6=签约<br>7=回款|
|list/followContent|是|string|200|跟进内容|
|list/projCode|是|string|64|项目编号|

###4.1.2	P-CU-02客户资料更新（cst_mobile_update）

+ **接口说明**
电话号码更新改成客户资料更新；案场更新的客户资料上报到数据中心（一期只实现电话号码的修改）
  - 1.判断新号码是否存在，存在返回系统处理失败\[新号码已经被其他用户绑定\]
  - 2.如果是操作类型是新增，新增用户和手机映射关系，并修改客户表的手机号码字段
  - 3.如果是修改，删除旧的用户手机映射关系，新增新的手机映射关系，并修改用户名（如果存在）

+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_mobile_update"
    },
    "data": {
        "cstGUID": "1000000",
        "oldMobile": 15800000000,
        "newMobile": 15811111111,
        "newcstname": "客户新名字",
        "cardType": 1,
        "cardId": "证件号码",
        "contactAddress": "通信地址",
        "opType": 1
    }
}
```

+ **请求参数说明**

| 参数           | 是否必须           | 类型   | 长度 | 说明                                               |
|----------------|--------------------|--------|------|----------------------------------------------------|
| cstGUID        | 是                 | string | 20   | 客户ID                                             |
| oldMobile      | 更新电话时必须     | string | 16   | 原电话号码                                         |
| newMobile      | 是                 | string | 16   | 新电话号码                                         |
| newcstname     | 否，更新姓名时必须 | String | 15   | 客户姓名中文15个字以内                             |
| cardType       | 否                 | int    |  10    | 证件类型：<br>1身份证,<br>2 军官证 ,<br>3 护照,<br>4 港澳通行证,<br>5 台湾通行证,<br>6 台湾身份证,<br>7 港澳身份证,<br>8 营业热照,<br>9 组织机构代码,<br>10 税务登记证号,<br>99其它 |
| cardId         | 否                 | string | 18   | 证件号码                                           |
| officeTel      | 否                 | string | 32   | 办公电话                                           |
| homeTel        | 否                 | string | 32   | 家庭电话                                           |
| nationality    | 否                 | string | 32   | 国籍                                               |
| contactAddress | 否                 | string | 100  | 通讯地址                                           |
| opType         | 是                 | int    | 4     | 操作类型（1新增 2更新）                            |
| cstType        | 否                 | int    | 4     | 客户类型：<br>1 个人，2公司                                     |
| consultantId   | 否                 | string | 64   | 置业顾问人员ID（调用明源接口时转换为置业顾问账号）,暂没实现                                            |
                                                       
+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.1.3	P-CU-03来访客户新增
+ **接口说明**
客户第一次来电或者到访案场时案场登记的客户资料信息上报到数据中心。
  - 1.如果客户编号不存在，并且手机号码不被占用，新增客户；否则返回手机号码已经存在、并返回已经存在的cstGUID，不走跟进和明源的后续流程，当返回客户已经存在时，必须使用接口返回的 cstGUID再次上报才会走写跟进和明源的正常流程
  - 2.如果客户编号不存在并且认知途径不为空，修改用户的认知途径字段
  - 3.新增客户来访跟进信息
  - 4.如果客户类型为：1预约或者 2推荐且接待来源为1到访的,需要产生一条客户状态通知消息
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_reception_create"
    },
    "data": {
        "projCode": "1000000",
        "cstGUID": "12110000",
        "consultantId": 121,
        "cstName": "客户A",
        "gender": 1,
        "cogniChannel": "认知途径",
        "cstType": 1,
        "receptionSource": 1,
        "visitTime": 1406851200,
        "mobile": "15800000000",
        "tel": "0755-81001234",
        "cardType": 1,
        "cardId": "证件号码",
        "contactAddress": "通信地址"
    }
}
```

+ **请求参数说明**

| 参数            | 必须                                              | 类型   | 长度 | 说明                                    |
|-----------------|-------------------------------------------------------|--------|------|-----------------------------------------|
| projCode        | 是                                                    | string | 64   | 项目code                                |
| consultantId    | 必须                                                  | string | 64   | 置业顾问ID                              |
| cstGUID         | 否，当用户信息（cstName、gender、mobile）不存在时必须 | string | 20   | 客户ID                                  |
| cstName         | 否，cstGUID不存在时是必须                             | string | 48   | 客户姓名                                |
| gender          | 否，cstGUID不存在时是必须                             | int    | 4     | 性别，1男，2女，3未知                   |
| cogniChannel    | 否                                                    | string | 64   | 认知途径                                |
| cstType         | 是                                                    | int    | 4     | 客户类型:1推荐2预约3自然到访                      |
| receptionSource | 是                                                    | int    | 4     | 接待来源1到访，2来电                    |
| visitTime       | 是                                                    | int    | 4     | 到访时间                                |
| mobile          | 否，cstGUID不存在时是必须                             | string | 16   | 手机                                    |
| tel             | 否                                                    | string | 16   | 家庭座机（已经过时，已经由homeTel替代） |
| officeTel       | 否                                                    | string | 32   | 办公电话                                |
| homeTel         | 否                                                    | string | 32   | 家庭电话                                |
| nationality     | 否                                                    | string | 32   | 国籍                                    |
| cardType        | 否                                                    | int    | 4     | 证件类型 1身份证                        |
| cardId          | 否                                                    | string | 18   | 证件号码                                |
| contactAddress  | 否                                                    | string | 100  | 通讯地址                                |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {
        "cstGUID": 1000
    }
}
```
+ **响应参数说明**

| 参数    | 必须 | 类型   | 长度 | 说明     |
|---------|----------|--------|------|----------|
| errcode | 是       | int    |   10   | 错误码   |
| errmsg  | 是       | string |   64   | 错误描述 |
| cstGUID | 是       | String | 20   | 客户ID   |

###4.1.4	P-CU-03-v2来访客户新增V2版
+ **接口说明**
客户第一次来电或者到访案场时案场登记的客户资料信息上报到数据中心。
  - 1.如果客户编号不存在，并且手机号码不被占用，新增客户；否则返回手机号码已经存在、并返回已经存在的cstGUID，不走跟进和明源的后续流程，当返回客户已经存在时，必须使用接口返回的 cstGUID再次上报才会走写跟进和明源的正常流程
  - 2.如果客户编号不存在并且认知途径不为空，修改用户的认知途径字段
  - 3.新增客户来访跟进信息
  - 4.如果客户类型为：1预约或者 2推荐且接待来源为1到访的,需要产生一条客户状态通知消息
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_reception_create"
    },
    "data": {
        "projCode": "1000000",
        "cstGUID": "12110000",
        "consultantId": 121,
        "cstName": "客户A",
        "gender": 1,
        "cogniChannel": "认知途径",
        "sourceType": 1,
        "cstType": 1,
        "receptionSource": 1,
        "visitTime": 1406851200,
        "mobile": "15800000000",
        "tel": "0755-81001234",
        "cardType": 1,
        "cardId": "证件号码",
        "contactAddress": "通信地址"
    }
}
```

+ **请求参数说明**

| 参数            | 是否必须                                              | 类型   | 长度 | 说明                                    |
|-----------------|-------------------------------------------------------|--------|------|-----------------------------------------|
| projCode        | 是                                                    | string | 64   | 项目code                                |
| consultantId    | 必须                                                  | string | 64   | 置业顾问ID                              |
| cstGUID         | 否，当用户信息（cstName、gender、mobile）不存在时必须 | String | 20   | 客户ID                                  |
| cstName         | 否，cstGUID不存在时是必须                             | string | 48   | 客户姓名                                |
| gender          | 否，cstGUID不存在时是必须                             | int    | 4     | 性别，1男，2女，3未知                   |
| cogniChannel    | 否                                                    | string | 64   | 认知途径                                |
| sourceType      | 是                                                    | Int    | 4     | 客户来源类型：1推荐2预约3自然到访                      |
| cstType         | 是                                                    | int    | 4     | 客户类型 ：1 个人，2公司                            |
| receptionSource | 是                                                    | int    | 4     | 接待来源1到访，2来电                    |
| visitTime       | 是                                                    | int    | 10     | 到访时间                                |
| mobile          | 否，cstGUID不存在时是必须                             | string | 16   | 手机                                    |
| tel             | 否                                                    | string | 16   | 家庭座机（已经过时，已经由homeTel替代） |
| officeTel       | 否                                                    | string | 32   | 办公电话                                |
| homeTel         | 否                                                    | string | 32   | 家庭电话                                |
| nationality     | 否                                                    | string | 32   | 国籍                                    |
| cardType        | 否                                                    | int    | 4     | 证件类型：1身份证 <br>2 军官证<br>3 护照 <br> 4 港澳通行证 <br> 5 台湾通行证 <br>6 台湾身份证 <br>7 港澳身份证 <br>8 营业热照  <br>9 组织机构代码<br>10 税务登记证号<br>99 其它 |
| cardId          | 否                                                    | string | 18   | 证件号码                                |
| contactAddress  | 否                                                    | string | 100  | 通讯地址                                |

+ **响应格式说明**
``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {
        "cstGUID": 1000
    }
}
```
+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 长度 | 说明     |
|---------|----------|--------|------|----------|
| errcode | 是       | int    |  10    | 错误码   |
| errmsg  | 是       | string |  64    | 错误描述 |
| cstGUID | 是       | String | 20   | 客户ID   |

###4.1.5	P-CU-04 客户基础特征信息上报（cst_attribute_update）
+ **接口说明**
案场将客户基础特征数据上报到数据中心cst_Attribute
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_attribute_update"
    },
    "data": {}
}
```
+ **请求参数说明**

| 参数                                  | 是否必须 | 类型     | 长度 | 说明           |
|---------------------------------------|----------|----------|------|----------------|
| cstGUID                               | 是       | string   | 20   | 客户ID         |
| email                                 | 否       | string   | 16   | 邮箱           |
| birthday                              | 否       | datetime |  32    | 生日，格式如’1985-12-12’  |
| Family                                | 否       | string   | 500  | 家庭结构       |
| workArea                              | 否       | string   | 500  | 工作区域       |
| homeArea                              | 否       | string   | 500  | 居住区域       |
| marriage                              | 否       | string   | 500  | 婚姻状况       |
| spouseName                            | 否       | string   | 500  | 配偶姓名       |
| eduLevel                              | 否       | string   | 500  | 教育程度       |
| earning                               | 否       | string   | 500  | 收入层次       |
| Work                                  | 否       | string   | 500  | 职业           |
| hobbies                               | 否       | string   | 500  | 兴趣爱好       |
| corpSort                              | 否       | string   | 500  | 公司性质       |
| principal                             | 否       | string   | 500  | 注册资本       |
| createDate                            | 否       | datetime | 32     | 成立日期       |
| numberOfEmployees                     | 否       | string   | 500  | 员工数量       |
| industry                              | 否       | string   | 500  | 所属行业       |
|  [business](javascript:void(0);)Scope | 否       | string   | 500  | 经营范围       |
| minAge                                | 否       | int      | 10     | 客户最小年龄   |
| maxAge                                | 否       | int      | 10     | 客户最大年龄   |
| buyersUse                             | 否       | string   | 500  | 购房用途       |
| trafficMode                           | 否       | string   | 500  | 常用交通方式   |
| childAgeGroup                         | 否       | string   | 500  | 子女所属年龄段 |
| yxMinArea                             | 否       | double      |  32    | 意向最小面积   |
| yxMaxArea                             | 否       | double      |   32   | 意向最大面积   |
| yxHouseType                           | 否       | string   | 500  | 意向房型       |
| yxMinPrice                            | 否       | double     |  32    | 意向最低价格   |
| yxMaxPrice                            | 否       | double     |  32   | 意向最高价格   |
| yxYeTai                               | 否       | string   | 500  | 意向业态       |
| remarks                               | 否       | text     | 2000 | 备注           |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.1.6	P-CU-05 客户项目信息上报（cst_projectAttach_update）
+ **接口说明**
案场将客户项目特征信息数据上报到数据中心cst_projectAttach
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_projectAttach_update"
    },
    "data": {}
}
```

+ **请求参数说明**

| 参数      | 是否必须 | 类型   | 长度 | 说明             |
|-----------|----------|--------|------|------------------|
| cstGUID   | 是       | string | 20   | 客户编号         |
| projCode  | 是       | string | 64   | 项目编号         |
| tableUUID | 是       | string | 64   | 特征名           |
| tableName | 是       | string | 50   | 特征名中文描述   |
| values    | 是       | jsonArray  | N/A  | 特征值(json数组) |
| remarks   | 否       | text   | 2000 | 备注             |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.1.7	N-CU-06客户资料修改通知（cst_changeInfo_notify）
+ **接口说明**
客户资料在明源系统更改后，同步到数据中心时需要通知案场做相应更改，但是前提是案场上报的客户才能通知，目前更新姓名、电话、家庭地址、证件号
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_changeInfo_notify"
    },
    "data": {}
}
```

+ **请求参数说明**

| 参数        | 是否必须 | 类型   | 长度 | 说明                 |
|-------------|----------|--------|------|----------------------|
| cstGUID     | 是       | string | 20   | 客户ID               |
| projCode    | 是       | string | 32   | 转换后的项目code     |
| oriProjCode | 是       | string | 32   | 原始项目code         |
| cstName     | 否       | string | 16   | 客户姓名             |
| mobile      | 否       | jsonArray  |  N/A    | 数组，手机号码列表   |
| address     | 否       | string | 64   | 家庭地址             |
| cardType    | 否       | int    |      | 证件类型：<br>1身份证,<br>2 军官证 ,<br>3 护照,<br>4 港澳通行证,<br>5 台湾通行证,<br>6 台湾身份证,<br>7 港澳身份证,<br>8 营业热照,<br>9 组织机构代码,<br>10 税务登记证号,<br>99 其它               |
| cardId      | 否       | string | 18   | 证件号码             |
| cstType     | 是       | int    |      | 0其它 1 个人，2公司, |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.1.8	N-CU-07客户资料新增结果通知（cst_reception_create_notify）
+ **接口说明**
客户资料在明源新增后，无论结果成功或失败，均产生通知。通知包含新增时的所有字段，加上在明源新增的结果。
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_reception_create_notify"
    },
    "data": {}
}
```

+ **请求参数说明**

| 参数            | 是否必须                                              | 类型   | 长度 | 说明                                                 |
|-----------------|-------------------------------------------------------|--------|------|------------------------------------------------------|
| result          | 是                                                    | int    |      | 0表示成功，其它表示失败                              |
| oppID           | 否                                                    | string | 40   | 如果对应新增机会成功的话，新增机会的GUID(数据中心ID) |
| consultantId    | 必须                                                  | string | 64   | 置业顾问ID                                           |
| cstGUID         | 否，当用户信息（cstName、gender、mobile）不存在时必须 | String | 20   | 客户ID                                               |
| cstName         | 否，cstGUID不存在时是必须                             | string | 48   | 客户姓名                                             |
| gender          | 否，cstGUID不存在时是必须                             | int    |  4    | 性别，1男，2女，3未知                                |
| cogniChannel    | 否                                                    | string | 64   | 认知途径                                             |
| cstType         | 是                                                    | Int    |  4    | 客户类型：1推荐2预约3自然到访                                   |
| receptionSource | 是                                                    | int    |  4    | 接待来源1到访，2来电                                 |
| visitTime       | 是                                                    | int    |  10    | 到访时间                                             |
| mobile          | 否，cstGUID不存在时是必须                             | string | 16   | 手机                                                 |
| officeTel       | 否                                                    | string | 32   | 办公电话                                             |
| homeTel         | 否                                                    | string | 32   | 家庭电话                                             |
| nationality     | 否                                                    | string | 32   | 国籍                                                 |
| cardType        | 否                                                    | int    |  4    | 证件类型 1身份证                                     |
| cardId          | 否                                                    | string | 18   | 证件号码                                             |
| contactAddress  | 否                                                    | string | 100  | 通讯地址                                             |
| projCode        | 是                                                    | string | 64   | 转换后的项目code                                     |
| oriProjCode     | 是                                                    | string | 32   | 原始项目code                                         |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.1.9	N-CU-08客户资料合并通知（cst_merge_notify）
+ **接口说明**
客户资料在数据中心合并后，将合并的两个客户ID通知经纪人平台。
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_merge_notify"
    },
    "data": {}
}
```

+ **请求参数说明**

| 参数    | 是否必须 | 类型   | 长度   | 说明     |
|------------|------|------|------|----------------------------|
| cstRetain  | 是   | int  |   20   | 合并时保留继续使用的客户ID |
| cstDropped | 是   | int  |   20   | 合并时丢弃不再使用的客户ID |
| mergeTime  | 是   | int  |   10   | 合并时间                   |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.1.10	N-CU-09客户机会资料查询接口（cst_cstOpp_list）
+ **接口说明**
  - 输入条件：
	客户号码（可选项）、身份证（可选项）、客户ID（可选项）、项目code(一级项目code或分期项目code)（必选项）；
	PS: 当客户ID有值时，其他参数选项忽略。
  - 返回值
   客户ID、客户姓名、身份证号码、list{项目code、置业顾问账号、机会ID、创建时间}
   PS: a) 由于客户在数据中心进行了合并，可能存在两个机会信息； 当输入条件是一级项目时，可能存在多个分期项目都有机会信息，因此会返回多个机会信息， 案场可以根据置业顾问账号信息、创建时间等进行处理。
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_cstOpp_list"
    },
    "data": {}
}
```

+ **请求参数说明**

| 参数     | 必须                          | 类型   | 长度 | 说明                       |
|----------|-------------------------------|--------|------|----------------------------|
| cstGUID  | 否,身份证和手机都不存在时必须 | string | 32   | 客户编号                   |
| cardId   | 否，优先级比电话高            | string | 32   | 身份证                     |
| mobile   | 否                            | string | 32   | 电话                       |
| projCode | 是                            | string | 32   | 一级项目code或分期项目code |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {}
}
```

+ **响应参数说明**

| 参数                 | 是否必须       | 类型   | 长度 | 说明         |
|----------------------|----------------|--------|------|--------------|
| errcode              | 是             | int    |  10    | 错误码       |
| errmsg               | 是             | string |  64    | 错误描述     |
| data/cstGUID         | 客户存在时必须 | string | 32   | 客户编号     |
| data/cstName         | 客户存在时必须 | string | 32   | 客户姓名     |
| data/cardId          | 客户存在时必须 | string | 32   | 客户身份证   |
| data/cstMobile       | 客户存在时必须 | string | 32   | 客户手机     |
| data/list            | 机会存在时必须 | jsonArray  |  N/A    | 机会数组     |
| data/list/projCode   | 机会存在时必须 | string | 64   | 项目code     |
| data/list/userId     | 机会存在时必须 | string | 64   | 置业顾问账号 |
| data/list/oppGUID    | 机会存在时必须 | string | 64   | 机会ID       |
| data/list/createTime | 机会存在时必须 | long   |      | UTC时间戳    |

##4.2 经纪人接口
###4.2.1	G-AG-01经纪人鉴定请求（agent_identify）
+ **接口说明**
同享会中经纪人注册时向数据中心获取信息经纪人的身份信息，鉴定经纪人是否为业主、员工、会员。
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "agent_identify"
    },
    "data": {
        "mobile": "13811112222",
        "name": "姓名",
        "cardId": "420581198707014095"
    }
}
```

+ **请求参数说明**

| 参数   | 是否必须 | 类型   | 长度 | 说明          |
|--------|----------|--------|------|---------------|
| mobile | 是       | string | 16   | 手机号码      |
| name   | 否       | string | 15   | 姓名,暂不使用 |
| cardId | 否       | string | 18   | 身份证号码    |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {
        "isOwner": 0,
        "isStaff": 1,
        "isMember": 0
    }
}
```

+ **响应参数说明**

| 参数     | 是否必须 | 类型   | 说明                   |
|----------|----------|--------|------------------------|
| errcode  | 是       | int    | 错误码                 |
| errmsg   | 是       | string | 错误描述               |
| isOwner  | 是       | int    | 是否业主(1：是；0：否) |
| isStaff  | 是       | int    | 是否员工(1：是；0：否) |
| isMember | 是       | int    | 是否会员(1：是；0：否) |

###4.2.2	P-AG-02经纪人新增（agent_create）
+ **接口说明**
同享会中经纪人注册成功时将经纪人信息上报到数据中心。
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "agent_create"
    },
    "data": {
        "name": "经纪人A",
        "mobile": "15811112222",
        "areaCode": 1234,
        "agentClasses": 1,
        "proxyCompanyId": "1234",
        "comment": "所在门店"
    }
}
```

+ **请求参数说明**

| 参数            | 是否必须                | 类型       | 长度 | 说明                      |
|-----------------|-------------------------|------------|------|---------------------------|
| name            | 是                      | String     | 15   | 经纪人姓名                |
| Mobile          | 是                      | String     | 16   | 手机号码                  |
| areaCode        | 是                      | int        | 10     | 所在城市ID                |
| agentClasses    | 是                      | int        | 4     | 经纪人类别（代理公司 = 1,<br>中介公司 = 2,<br>万科业主 = 3,<br>万科员工 = 4,<br>万科合作方 = 5,<br>独立经纪人 = 6）|
| proxyCompanyId  | 否，经纪人类型为1时必须 | string     | 64   | 所在代理公司              |
| agencyCompanyId | 否，经纪人为2时必须     | string     | 64   | 所在中介公司              |
| comment         | 否                      | String(50) | 50   | 中介公司经纪人：所在门店,万科员工：所在部门,万科业主：所在物业         |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {
        "agentGUID": "123"
    }
}
```

+ **响应参数说明**

| 参数      | 是否必须 | 类型   | 长度 | 说明                               |
|-----------|----------|--------|------|------------------------------------|
| errcode   | 是       | int    |  10    | 错误码                             |
| errmsg    | 是       | string |  64    | 错误描述                           |
| agentGUID | 是       | string | 20   | 成功后返回该经纪人在数据中心的GUID |

###4.2.3	P-AG-03经纪人更新（agent_update）
+ **接口说明**
同享会将经纪人的更新信息（包括个人资料和积分信息）上报到数据中心
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "agent_update"
    },
    "data": {
        "agentGUID": "1000000",
        "name": "经纪人A",
        "mobile": "15811112222",
        "agentClasses": 1,
        "areaCode": 1122,
        "proxyCompanyId": "12",
        "totalPoint": 321,
        "point": 23,
        "level": 1,
        "comment": "所在门店",
        "status": 1
    }
}
```

+ **请求参数说明**

| 参数            | 是否必须                | 类型       | 长度 | 说明                        |
|-----------------|-------------------------|------------|------|-----------------------------|
| agentGUID       | 是                      | string     | 20   | 经纪人ID                    |
| name            | 是                      | string     | 15   | 姓名                        |
| mobile          | 否                      | string     | 16   | 手机号码                    |
| agentClasses    | 否                      | Int        |  4    | 经纪人类别（代理公司= 1,<br>中介公司 = 2,<br>万科业主 = 3,<br>万科员工 = 4,<br>万科合作方 = 5,<br>独立经纪人 = 6）|
| areaCode        | 否                      | int        |  10    | 所在城市ID                  |
| proxyCompanyId  | 否，经纪人类型是1时必须 | string     | 64   | 代理公司ID                  |
| agencyCompanyId | 否，经纪人类型是2时必须 | string     | 64   | 中介公司ID                  |
| totalPoint      | 否                      | int        |  10    | 累计积分                    |
| point           | 否                      | int        |  10    | 可用积分                    |
| level           | 否                      | int        |  10    | 经纪人等级（普通经纪人 = 1,<br>铜牌经纪人 = 2,<br>银牌经纪人 = 3,<br>金牌经纪人 = 4,<br>钻石经纪人 = 5）             |
| comment         | 否                      | String(50) | 100  | 中介公司经纪人：所在门店 ,万科员工：所在部门,万科业主：所在物业           |
| status          | 是                      | Int        |  4    | 1有效/0无效                 |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.2.4	P-AG-04客户推荐上报（agent_recommend）
+ **接口说明**
同享会中经纪人成功推荐客户的推荐信息（经纪人、客户、项目）上报到数据中心，有可能指定代理公司、置业顾问、预约时间。
  - 1.如果手机号码没有关联客户，则新增客户和客户手机映射关系；否则使用已经存在的客户编号
  - 2.新增一条经纪人推荐客户关系记录
  - 3.返回同享会客户编号
  - 4.产生一条客户推荐通知消息
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "agent_recommend"
    },
    "data": {
        "agentGUID": "1000000",
        "cstName": "客户A",
        "cstMobile": "13912345678",
        "projCode": "12300000",
        "productType": "p101",
        "proxyCompanyId": 123,
        "consultantId": 120,
        "comment": "在深圳市南山区有购买三房需求",
        "appointTime": 1404691200,
        "gender": 1,
        "prizeRule": "结佣规则",
        "isAccompany": 0,
        "reportTime": 1407492000
    }
}
```

+ **请求参数说明**

| 参数           | 是否必须 | 类型   | 长度 | 说明                     |
|----------------|----------|--------|------|--------------------------|
| agentGUID      | 是       | string | 20   | 经纪人ID                 |
| cstName        | 是       | string | 15   | 客户姓名                 |
| cstMobile      | 是       | string | 16   | 客户手机号码             |
| projCode       | 是       | string | 64   | 项目code                 |
| productType    | 是       | string | 64   | 产品品类                 |
| proxyCompanyId | 否       | string | 64   | 代理公司ID               |
| consultantId   | 否       | string | 64   | 置业顾问ID               |
| comment        | 否       | string | 100  | 备注                     |
| appointTime    | 否       | int    | 10     | 预约上门日期             |
| gender         | 否       | int    | 4     | 1男 2 女                 |
| prizeRule      | 否       | string | 500  | 对结佣规则的描述         |
| isAccompany    | 是       | int    | 4     | 是否陪同上门（1是0否）   |
| reportTime     | 是       | int    | 10     | 推荐时间                 |
| expireTime     | 否       | int    | 10     | 过期时间，即何时过保护期 |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {
        "cstGUID": "12000000"
    }
}
```

+ **响应参数说明**

| 参数    | 必须 | 类型   | 长度 | 说明                             |
|---------|------|--------|------|----------------------------------|
| errcode | 是   | int    |  10    | 错误码                           |
| errmsg  | 是   | string |  64    | 错误描述                         |
| cstGUID | 否   | string | 20   | 成功后返回客户在数据中心的唯一ID |

##4.3基础数据服务接口

###4.3.1	G-BA-01城市列表获取（base_city_list）
+ **接口说明**
同享会定时向数据中心发送城市列表同步请求
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "base_city_list"
    },
    "data": {
        "page": 1,
        "pageSize": 100
    }
}
```

+ **请求参数说明**

| 参数     | 是否必须 | 类型 | 说明                             |
|----------|----------|------|----------------------------------|
| page     | 是       | int  | 页码                             |
| pageSize | 是       | int  | 分页大小，取值范围是［10，1000］ |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {
        "totalPage": 12,
        "page": 1,
        "list": [
            {
                "cityCode": 101,
                "cityName": "深圳市",
                "status": 1
            },
            {
                "cityCode": 201,
                "cityName": "广州市",
                "status": 0
            }
        ]
    }
}
```

+ **响应参数说明**

| 参数           | 是否必须 | 类型   | 长度 | 说明             |
|----------------|----------|--------|------|------------------|
| errcode        | 是       | int    |  10    | 错误码           |
| errmsg         | 是       | string |  64    | 错误描述         |
| data/totalPage | 是       | int    |  10    | 记录总页数       |
| data/page      | 是       | int    |  10    | 本次查询页码     |
| data/list      | 否       | jsonArray  | N/A     | 记录列表         |
| cityCode       | 是       | int    |  10    | 城市ID           |
| cityName       | 是       | string | 64   | 城市名称         |
| status         | 是       | int    |  4    | 状态，1有效0无效 |

###4.3.2	G-BA-02项目信息获取（base_project_list）
+ **接口说明**
同享会或者案场定时向数据中心发送项目信息同步请求
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "base_project_list"
    },
    "data": {
        "page": 1,
        "pageSize": 100,
        "lastSyncTime": 1405555200
    }
}
```

+ **请求参数说明**

| 参数         | 是否必须 | 类型 | 说明                             |
|--------------|----------|------|----------------------------------|
| lastSyncTime | 是       | int  | 上一次同步时间                   |
| page         | 是       | int  | 页码                             |
| pageSize     | 是       | int  | 分页大小，取值范围是［10，1000］ |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {
        "totalPage": 1,
        "page": 1,
        "list": [
            {
                "projCode": "100",
                "projName": "项目1",
                "cityCode": 1,
                "companyCode": "101",
                "status": 1,
                "level": 1
            },
            {
                "projCode": "200",
                "projName": "项目2",
                "cityCode": 1,
                "companyCode": "102",
                "status": 1,
                "level": 1
            }
        ]
    }
}
```

+ **响应参数说明**

| 参数                  | 是否必须 | 类型       | 长度   | 说明                                    |
|-----------------------|----------|------------|--------|-----------------------------------------|
| errcode               | 是       | int        |   10     | 错误码                                  |
| errmsg                | 是       | string     |   64     | 错误描述                                |
| data/totalPage        | 是       | int        |   10     | 记录总页数                              |
| data/page             | 是       | int        |   10     | 本次查询页码                            |
| data/list             | 否       | jsonArray      |  N/A      | 记录列表                                |
| data/list/projCode    | 是       | string     | 64     | 项目code                                |
| data/list/projName    | 是       | string     | 256    | 项目名称                                |
| data/list/cityCode    | 是       | int        | 10       | 所在城市ID                              |
| data/list/companyCode | 是       | string     | 64     | 所属公司                                |
| data/list/status      | 是       | int        | 4       | 1有效/0无效(无效代表禁用或已删除的数据) |
| data/list/level       | 是   | int    | 4       | 项目级别                            |
| data/list/projStatus  | 是       | string     | 32     | 在售项目标志                            |
| data/list/parentCode  | 是   | string | 64 | 父级项目编号                        |
| data/list/isOpen      | 是       | int        |     4   | 是否开通移动案场                        |
| data/list/openTime    | 是   | int    |    10    | 移动案场开通时间                    |

###4.3.3	G-BA-03置业顾问获取（base_proxyCompanysales_list）
+ **接口说明**
同享会定时向数据中心发送案场的置业顾问信息同步请求
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "base_proxyCompanysales_list"
    },
    "data": {
        "page": 1,
        "pageSize": 100,
        "lastSyncTime": 1405555200
    }
}
```

+ **请求参数说明**

| 参数         | 是否必须 | 类型 | 说明                             |
|--------------|----------|------|----------------------------------|
| page         | 是       | int  | 页码                             |
| pageSize     | 是       | int  | 分页大小，取值范围是［10，1000］ |
| lastSyncTime | 是       | int  | 上次同步时间                     |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {
        "totalPage": 12,
        "page": 1,
        "list": [
            {
                "consultantId": "s100",
                "consultantName": "销售A",
                "proxyCompanyId": 100,
                "enable": 1,
                "projCode": "121212",
                "mobile": "13711112222"
            },
            {
                "consultantId": "s101",
                "consultantName": "销售B",
                "proxyCompanyId": 100,
                "enable": 1,
                "projCode": "121212",
                "mobile": "13711110000"
            }
        ]
    }
}
```

+ **响应参数说明**

| 参数           | 是否必须 | 类型   | 长度 | 说明         |
|----------------|----------|--------|------|--------------|
| errcode        | 是       | int    |  10    | 错误码       |
| errmsg         | 是       | string |  64    | 错误描述     |
| data/totalPage | 是       | int    |  10    | 记录总页数   |
| data/page      | 是       | int    |  10    | 本次查询页码 |
| data/list      | 否       | jsonArray  | N/A     | 记录列表     |
| consultantId   | 是       | string | 64   | 销售人员ID   |
| consultantName | 是       | string | 15   | 销售人员姓名 |
| proxyCompanyId | 是       | int    | 64   | 代理公司GUID |
| enable         | 是       | int    | 4     | 1有效/0无效  |
| projCode       | 是       | string | 64   | 所在项目code |
| mobile         | 是       | string | 16   | 手机号码     |

###4.3.4	G-BA-04案场代理获取（base_proxyCompany_list）
+ **接口说明**
同享会定时向数据中心发送案场的代理公司信息同步请求
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "base_proxyCompany_list"
    },
    "data": {
        "page": 1,
        "pageSize": 100,
        "lastSyncTime": 1405555200
    }
}
```

+ **请求参数说明**

| 参数         | 是否必须 | 类型 | 说明                             |
|--------------|----------|------|----------------------------------|
| page         | 是       | int  | 页码                             |
| pageSize     | 是       | int  | 分页大小，取值范围是［10，1000］ |
| lastSyncTime | 是       | int  | 上一次同步时间                   |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {
        "totalPage": 12,
        "page": 1,
        "list": [
            {
                "companyId": 11,
                "companyName": "代理公司A",
                "projCode": "31233"
            },
            {
                "companyId": 22,
                "companyName": "代理公司B",
                "projCode": "324324"
            }
        ]
    }
}
```

+ **响应参数说明**

| 参数           | 是否必须 | 类型   | 长度 | 说明         |
|----------------|----------|--------|------|--------------|
| errcode        | 是       | int    |  10    | 错误码       |
| errmsg         | 是       | string |  64    | 错误描述     |
| data/totalPage | 是       | int    |  10    | 记录总页数   |
| data/page      | 是       | int    |  10    | 本次查询页码 |
| data/list      | 否       | jsonArray  | N/A     | 记录列表     |
| companyId      | 是       | string    |  64    | 公司ID       |
| companyName    | 是       | string | 128  | 公司名称     |
| projCode       | 是       | string | 64   | 所在项目GUID |
| enable         | 是       | int    |  4    | 1有效/0无效  |

###4.3.5	P-BA-05案场代理上报（proxyCompany_create）
+ **接口说明**
> 案场将代理公司的更新信息（包括新增和修改）实时上报给数据中心

1.  新增代理公司时，代理公司ID由案场产生上报
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "proxyCompany_create "
    },
    "data": {
        "projCode": "1000000",
        "proxyCompanyId": 121,
        "proxyCompanyName": "代理公司A",
        "opType": 1,
        "enable": 1
    }
}
```

+ **请求参数说明**

| 参数             | 是否必须 | 类型   | 长度 | 说明                                                                                   |
|------------------|----------|--------|------|----------------------------------------------------------------------------------------|
| projCode         | 是       | string | 64   | 项目Code                                                                               |
| proxyCompanyId   | 是       | string | 64   | 代理公司ID                                                                             |
| proxyCompanyName | 是       | string | 128  | 代理公司名称                                                                           |
| opType           | 是       | int    |  4    | 操作类型（1新增 2修改）                                                                |
| enable           | 是       | int    |  4    | 有效标志，如果是新增就传1，修改分两种：第一种是改名字，第二种是逻辑删除，把enable置为0 |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {
        "proxyCompanyId": 1000
    }
}
```

+ **响应参数说明**

| 参数           | 是否必须 | 类型   | 说明       |
|----------------|----------|--------|------------|
| errcode        | 是       | int    | 错误码     |
| errmsg         | 是       | string | 错误描述   |
| proxyCompanyId | 是       | int    | 代理公司ID |


###4.3.6	P-BA-06置业顾问上报(proxyCompany_consultant_create)
+ **接口说明**
> 案场将置业顾问的更新信息（包括新增和修改）实时上报给数据中心
>
> 1.置业顾问编号由案场产生上报
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "proxyCompany_consultant_create"
    },
    "data": {
        "projCode": "1000000",
        "proxyCompanyId": 121,
        "consultantId": 12,
        "consultantName": "置业顾问A",
        "gender": 1,
        "consultantMobile": "15800000000",
        "consultantAccount": "453543443",
        "opType": 1,
        "enable": 1
    }
}
```

+ **请求参数说明**

| 参数              | 是否必须 | 类型   | 长度 | 说明                                                                                   |
|-------------------|----------|--------|------|----------------------------------------------------------------------------------------|
| projCode          | 是       | string | 64   | 项目code                                                                               |
| proxyCompanyId    | 是       | string | 64   | 代理公司ID                                                                             |
| consultantId      | 是       | string | 64   | 置业顾问ID                                                                             |
| consultantName    | 是       | string | 15   | 置业顾问姓名                                                                           |
| gender            | 是       | int    | 4     | 性别：1男，2女，0未知                                                                  |
| consultantMobile  | 是       | string | 16   | 手机                                                                                   |
| consultantAccount | 是       | string | 64   | 置业顾问账号                                                                           |
| opType            | 是       | int    | 4     | 操作类型（1新增 2修改）                                                                |
| enable            | 是       | int    | 4    | 有效标志，如果是新增就传1，修改分两种：第一种是改名字，第二种是逻辑删除，把enable置为0 |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {
        "consultantId": 1000
    }
}
```

+ **响应参数说明**

| 参数         | 是否必须 | 类型   | 长度 | 说明       |
|--------------|----------|--------|------|------------|
| errcode      | 是       | int    |  10    | 错误码     |
| errmsg       | 是       | string |  64    | 错误描述   |
| consultantId | 是       | String | 64   | 置业顾问ID |


###4.3.7	G-BA-08获取区域和公司列表（新增）（base_areacompany_list）
+ **接口说明**
> 案场定时向数据中心发送公司列表同步请求。

1.数据由明源数据库表myBusinessUnit同步过来
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "base_areacompany_list"
    },
    "data": {
        "page": 1,
        "pageSize": 100
    }
}
```

+ **请求参数说明**

| 参数     | 是否必须 | 类型 | 说明                             |
|----------|----------|------|----------------------------------|
| page     | 是       | int  | 页码                             |
| pageSize | 是       | int  | 分页大小，取值范围是［10，1000］ |

+ **响应格式说明**

``` json
{
    "errcode": 255,
    "errmsg": "",
    "data": {
        "totalPage": 1,
        "page": 1,
        "list": [
            {
                "areaCode": "001",
                "areaName": "广深区域",
                "comanyList": [
                    {
                        "comanyCode": "0023",
                        "comanyName": "公司名字",
                        "enable": 1
                    }
                ]
            }
        ]
    }
}
```

+ **响应参数说明**

| 参数                            | 是否必须 | 类型   | 长度 | 说明                     |
|---------------------------------|----------|--------|------|--------------------------|
| errcode                         | 是       | int    |   10   | 错误码                   |
| errmsg                          | 是       | string |   64   | 错误描述                 |
| data/totalPage                  | 是       | int    |   10   | 记录总页数               |
| data/page                       | 是       | int    |   10   | 本次查询页码             |
| data/list                       | 否       | jsonArray  |   N/A    | 记录列表                 |
| data/list/areaCode              | 是       | string | 64   | 区域code                 |
| data/list/areaName              | 是       | string | 64   | 区域名称                 |
| data/list/comanyList            | 否       | jsonArray  |   N/A    | 数组                     |
| data/list/comanyList/comanyCode | 是       | string | 64   | 公司代码                 |
| data/list/comanyList/comanyName | 是       | string | 64   | 公司名称                 |
| data/list/comanyList/enable     | 是       | Int    |  4    | 公司有效标志 1有效 0无效 |

###4.3.8	G-BA-09置业顾问鉴定请求（consultant_identify）
+ **接口说明**
从明源中同步置业顾问信息，并开放接口给案场调用。 由案场发起请求，返回置业顾问是否存在.
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "consultant_identify"
    },
    "data": {
        "consultantId": "",
        "projCode": ""
    }
}
```

+ **请求参数说明**

| 参数         | 是否必须 | 类型   | 长度 | 说明       |
|--------------|----------|--------|------|------------|
| consultantId | 是       | String | 64   | 置业顾问ID |
| projCode     | 是       | String | 64   | 项目code   |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "成功",
    "data": {
        "exist": 1
    }
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 长度 | 说明                             |
|---------|----------|--------|------|----------------------------------|
| errcode | 是       | int    |  10    | 错误码                           |
| errmsg  | 是       | string |  64    | 错误描述                         |
| exist   | 是       | int    |  4    | 置业顾问是否存在（1：是；0：否） |

###4.3.9	P-BA-10项目上线信息上报接口（base_project_online）
+ **接口说明**
应用上报项目上线信息接口.
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "base_project_online"
    },
    "data": {}
}
```

+ **请求参数说明**

| 参数       | 是否必须 | 类型   | 长度 | 说明                 |
|------------|----------|--------|------|----------------------|
| projCode   | 是       | String | 64   | 一级项目code         |
| onlineTime | 是       | long   | 10   | 上下线时间:UTC时间戳 |
| status     | 是       | int    | 4    | 状态，1上线0下线     |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "成功"
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 长度 | 说明     |
|---------|----------|--------|------|----------|
| errcode | 是       | int    |   10   | 错误码   |
| errmsg  | 是       | string |   64   | 错误描述 |

###4.3.10	G-BA-11推广分期项目信息获取（base_projectTree_list）
+ **接口说明**
同享会或者案场定时向数据中心发送分期项目同步请求，结构是一级项目或推广项目，包含所有的分期项目或推广项目
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "base_projectTree_list"
    },
    "data": {
        "page": 1,
        "pageSize": 100,
        "lastSyncTime": 1405555200
    }
}
```

+ **请求参数说明**

| 参数         | 是否必须 | 类型 | 说明                                 |
|--------------|----------|------|--------------------------------------|
| lastSyncTime | 是       | int  | 上一次同步时间，utc时间戳秒值        |
| page         | 是       | int  | 当前请求页码                         |
| pageSize     | 是       | int  | 每页记录大小，取值范围是［10，1000］ |

+ **响应格式说明**

``` json
{
    "errmsg": "成功",
    "errcode": 0,
    "data": {
        "projlist": [
            {
                "relatedSpreadPrjName": "深圳万景花园",
                "relatedSpreadPrjCode": "SZAREA_SZGS.SZWJHY",
                "openTime": 1444867200,
                "isOpen": "1",
                "fenqilist": [
                    {
                        "yt": "1;4",
                        "status": "1",
                        "projName": "深圳万景花园-万景花园",
                        "projCode": "SZAREA_SZGS.SZWJHY.SZWJ1",
                        "parentName": "宁波万科城-一期",
                        "parentCode": "SZAREA_SZGS.SZWJHY",
                        "level": 3,
                        "companyCode": "ZJGS",
                        "cityCode": ""
                    }
                ]
            }
        ]
    }
}
```

+ **响应参数说明**

| 参数                                | 是否必须       | 类型    | 长度   | 说明                             |
|-------------------------------------|----------------|---------|--------|----------------------------------|
| errcode                             | 是             | int     | 4      | 错误码                           |
| errmsg                              | 是             | string  | 100    | 错误描述                         |
| data/totalPage                      | 是             | int     | 10     | 记录总页数                       |
| data/page                           | 是             | int     | 10     | 本次查询页码                     |
| data/projList                       | 否，存在时必须 | jsonArray   |    N/A     | 记录列表，json数组               |
| data/projList/relatedSpreadPrjName  | 是             | String  | 64     | 一级项目名称                     |
| data/projList/relatedSpreadPrjCode  | 是             | string  | 256    | 一级项目编号                     |
| data/projList/openTime              | 是             | Int | 10     | 移动案场开通时间，utc时间戳秒值                 |
| data/projList/isOpen                | 是             | int     | 2      | 是否开通移动案场1:开通 0：未开通 |
| data/projList/fenqilist             | 否，存在时必须 | jsonArray   |    N/A     | 分期项目列表，json数组       |
| data/projList/fenqilist/yt          | 否         | string  | 32 | 项目业态                     |
| data/projList/fenqilist/status      | 是             | string  | 32     | 项目状态                         |
| data/projList/fenqilist/projName    | 是         | string  | 64 | 项目名称                     |
| data/projList/fenqilist/projCode    | 是             | string  | 64     | 项目编号                         |
| data/projList/fenqilist/parentName  | 是         | string  | 64 | 父级项目名称                 |
| data/projList/fenqilist/parentCode  | 是         | string  | 64 | 父级项目编号                 |
| data/projList/fenqilist/level       | 是         | int     | 4  | 项目级别                     |
| data/projList/fenqilist/companyCode | 否         | string  | 64 | 公司编号                     |
| data/projList/fenqilist/cityCode    | 否         | string  | 64 | 城市编号                     |

##4.4 客户行为服务接口

###4.4.1	G-BS-01跟进信息查询（cst_follow_list）
+ **接口说明**
案场根据客户手机号和项目编号向数据中心提交客户主档信息和跟进信息查询请求
  - 1）projcode非空，查询该客户在本项目的所有跟进记录，和本项目之外的最近一条跟进记录

  - 2）projcode 是空，则查询所有项目的最新跟进信息（一条）
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_follow_list"
    },
    "data": {
        "phone": "13556534343",
        "projCode": "12323"
    }
}
```

+ **请求参数说明**

| 参数     | 是否必须 | 类型   | 长度 | 说明     |
|----------|----------|--------|------|----------|
| phone    | 是       | string | 16   | 手机号   |
| ProjCode | 否       | String | 64   | 项目Code |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {
        "gender": 1,
        "cstName": "客户A",
        "mobile": "13800000000",
        "list": [
            {
                "followTime": 1404691200,
                "followType": 1,
                "followContent": "看样板间",
                "projCode": "15323"
            },
            {
                "followTime": 1404691200,
                "followType": 1,
                "followContent": "看样板间",
                "projCode": "15325"
            }
        ]
    }
}
```

+ **响应参数说明**

| 参数          | 是否必须 | 类型   | 长度       | 说明                      |
|---------------|----------|--------|------------|---------------------------|
| errcode       | 是       | int    |     10       | 错误码                    |
| errmsg        | 是       | string |     64       | 错误描述                  |
| data/gender   | 是       | int    |     4      | 1男2女3未知               |
| data/cstName  | 是       | string | 15         | 姓名                      |
| data/mobile   | 是       | string | 16         | 手机号                    |
| data/cstGUID  | 是       | string | 20         | 客户GUID                  |
| data/list     | 否       | jsonArray  |     N/A        | 跟进记录                  |
| followTime    | 是       | int    |     10       | 跟进时间                  |
| followType    | 是       | int    |     4       | 跟进类别（1.来电、2来访） |
| followContent | 是       | string | 200 | 跟进内容                  |
| porjCode      | 是       | String | 64         | 项目Code                  |

###4.4.2	P-BS-02中介代理上报（base_agencyCompany_list）
+ **接口说明**
经纪人平台将中介公司信息（包括新增和修改）实时上报给数据中心
  - 1.新增中介代理公司时，中介代理公司ID（uuid）由数据中心产生
  - 2.已经存在的判断依据：中介公司名称相同即表示已经存在
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "base_agencyCompany_list"
    },
    "data": {
        "name": "中介公司A",
        "cityCode": "100230",
        "type": 1,
        "opType": 1,
        "companyId": "2000001"
    }
}
```

+ **请求参数说明**

| 参数      | 是否必须 | 类型       | 长度 | 说明                            |
|-----------|----------|------------|------|---------------------------------|
| name      | 是       | string | 128  | 中介公司名称                    |
| cityCode  | 是       | string | 10   | 中介公司所在城市ID              |
| opType    | 是       | int        |  4    | 操作类型:1 Add、2 Modi 3 delete |
| type      | 是       | int        |  4    | 1中介、2代理 、<font color="red">3 企业用户（入库记为4） </font>|
| companyId | 否       | string     | 64   | 修改、删除时必须提供            |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {
        "staus": 2,
        "message": "已经存在"
    }
}
```

+ **响应参数说明**

| 参数         | 是否必须 | 类型   | 说明                |
|--------------|----------|--------|---------------------|
| errcode      | 是       | int    | 错误码              |
| errmsg       | 是       | string | 错误描述            |
| data/status  | 是       | int    | 状态码:<br>成功：1,<br>失败：2              |
| data/message | 是       | string | 附加信息:<br> 状态1时：公司ID,<br>状态2时：已存在      |

###4.4.3	P-BS-03同享会预约上报（agent_appoint）
+ **接口说明**
同享会将客户预约看房的信息实时上报给数据中心
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "agent_appoint"
    },
    "data": {
        "projCode": "1000000",
        "cstMobile": "13812345678",
        "cstName": "客户A",
        "comment": "备注说明",
        "appointTime": 1404691200,
        "reportTime": 1404691200
    }
}
```

+ **请求参数说明**

| 参数        | 是否必须 | 类型   | 长度       | 说明                    |
|-------------|----------|--------|------------|-------------------------|
| projCode    | 是       | string | 64         | 项目code                |
| cstMobile   | 是       | string | 16         | 客户手机                |
| cstName     | 否       | string | 15         | 客户姓名                |
| comment     | 否       | string | mediumtext | 备注说明，中文100字以内 |
| appointTime | 是       | int    | 10           | 预约看房时间            |
| reportTime  | 是       | Int    | 10           | 预约时间                |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.4.4	P-BS-04无效推荐上报（agent_recommend_cancel）
+ **接口说明**
同享会将推荐客户失败的信息上报给数据中心。
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "agent_recommend_cancel"
    },
    "data": {
        "mobile": "13812345678",
        "name": "客户A",
        "projCode": "1000000",
        "cancelCause": "客户主动退出",
        "agentClasses": 1,
        "agentName": "经纪人A",
        "agentMobile": "13811112222",
        "reportTime": 1404691200
    }
}
```

+ **请求参数说明**

| 参数         | 是否必须 | 类型   | 长度 | 说明                      |
|--------------|----------|--------|------|---------------------------|
| mobile       | 是       | string | 16   | 客户手机                  |
| name         | 是       | String | 15   | 客户姓名                  |
| projCode     | 是       | string | 64   | 项目code                  |
| cancelCause  | 是       | string | 500  | 无效原因                  |
| agentClasses | 是       | Int    |  4    | 经纪人类型（代理公司 = 1,<br>中介公司 = 2,<br>万科业主 = 3,<br>万科员工 = 4,<br>万科合作方 = 5,<br>独立经纪人 = 6）           |
| agentName    | 是       | string | 15   | 经纪人姓名                |
| agentMobile  | 是       | string | 16   | 经纪人电话                |
| reportTime   | 是       | Int    |  10    | 推荐时间                  |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.4.5	P-BS-05案场预约上报（cst_appoint_update）
+ **接口说明**
案场将与客户预约的状态和时间上报给数据中心
如果是客户类型是推荐，新增预约记录；否则修改上次预约记录的的状态
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_appoint_update"
    },
    "data": {
        "projCode": "p00001",
        "cstGUID": "1000000",
        "cstType": 2,
        "appointType": 1,
        "reportTime": 1404691200
    }
}
```

+ **请求参数说明**

| 参数        | 是否必须 | 类型   | 长度 | 说明                                        |
|-------------|----------|--------|------|---------------------------------------------|
| projCode    | 是       | string | 64   | 项目code                                    |
| cstGUID     | 是       | string   | 20   | 客户ID                                      |
| cstType     | 是       | int    |  4    | 客户类型，1推荐，2预约                      |
| appointType | 是       | int    | 4     | 预约状态 1预约未上门（预约成功） 2 预约失败 |
| reportTime  | 是       | int    | 10     | 预约时间                                    |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.4.6	P-BS-06跟进信息上报（cst_follow_update）
+ **接口说明**
案场将客户的来电、来访行为信息上报给数据中心
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_follow_update"
    },
    "data": {
        "cstGUID": "1000000",
        "cstType": 1,
        "projCode": "5000000",
        "followTime": 1406851200,
        "followContent": "看房",
        "followType": 1,
        "followPersonId": "2000000"
    }
}
```

+ **请求参数说明**

| 参数           | 是否必须 | 类型   | 长度       | 说明                             |
|----------------|----------|--------|------------|----------------------------------|
| cstGUID        | 是       | string | 20         | 客户ID                           |
| cstType        | 是       | int    | 4           | 客户类型，1推荐，2预约 3自然到访 |
| projCode       | 是       | string | 64         | 项目code                         |
| followTime     | 是       | int    | 10           | 跟进日期                         |
| followContent  | 是       | string | mediumtext | 跟进内容                         |
| followType     | 是       | int    | 4           | 跟进类别，2 来电，3来访          |
| followPersonId | 是       | string | 64         | 跟进人的ID（置业顾问）           |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.4.7	G-BA-03置业顾问获取
+ **接口说明**
获取项目的认知途径
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_cognitivec_channel"
    },
    "data": {
        "projCode": "1000000"
    }
}
```

+ **请求参数说明**

| 参数     | 是否必须 | 类型   | 说明     |
|----------|----------|--------|----------|
| projCode | 是       | string | 项目code |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": "",
    "data": {
        "totalPage": 10,
        "page": 1,
        "list": [
            {
                "cognitivecId": 1,
                "cognitivecName": "认知途径A"
            },
            {
                "cognitivecId": 2,
                "cognitivecName": "认知途径B"
            }
        ]
    }
}
```

+ **响应参数说明**

| 参数           | 是否必须 | 类型   | 说明         |
|----------------|----------|--------|--------------|
| errcode        | 是       | int    | 错误码       |
| errmsg         | 是       | string | 错误描述     |
| data/totalPage | 是       | int    | 记录总页数   |
| data/page      | 是       | int    | 本次查询页码 |
| data/list      | 否       | jsonArray  | 记录列表     |
| cognitivecId   | 是       | int    | 认知途径ID   |
| cognitivecName | 是       | string | 认知途径名称 |

###4.4.8	N-BS-08分配置业顾问通知（consultant_assign_create）
+ **接口说明**
数据中心将来自案场的为客户分配的分配置业顾问信息通知给同享会
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "consultant_assign_create"
    },
    "data": {
        "projCode": "1000000",
        "consultantId": 121,
        "cstGUID": "14000000"
    }
}
```

+ **请求参数说明**
| 参数         | 是否必须 | 类型   | 长度 | 说明             |
|--------------|----------|--------|------|------------------|
| projCode     | 是       | string | 64   | 转换后的项目code |
| oriProjCode  | 是       | string | 32   | 原始项目code     |
| consultantId | 是       | String | 64   | 置业顾问ID       |
| cstGUID      | 是       | String | 20   | 客户ID           |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.4.9	N-BS-09客户状态通知（cst_status）
+ **接口说明**
数据中心将客户的状态更新信息通知同享会，状态包括（预约、到访、认筹、认购、签约、回款）。 当认购、签约时，将明源的客户（包括联名客户）信息一并推送。
之前是：room=bldName+"-"+room.getRoom()
改为：room=bldName+"-" + room.getUnit()+"-"+room.getRoom()
 > 注意：房产数据没有单元数据时忽略处理
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_status"
    },
    "data": {
        "cstGUID": "14000000",
        "projCode": "143546",
        "followTime": "1404691200",
        "followType": 1,
        "followContent": "看房",
        "mny": 1265767,
        "state": "",
        "roomGUID": "",
        "room": "",
        "houseType": "",
        "cstInfos": [
            {
                "cstname": "李四",
                "tel": "13412345678,13212345678"
            }
        ]
    }
}
```

+ **请求参数说明**

| 参数             | 是否必须   | 类型   | 长度       | 说明                                        |
|------------------|------------|--------|------------|---------------------------------------------|
| cstGUID          | 是         | String | 20         | 客户ID                                      |
| projCode         | 是         | string | 64         | 转换后的项目code                            |
| oriProjCode      | 是         | string | 32         | 原始项目code                                |
| followTime       | 是         | int    | 10           | 跟进时间                                    |
| followType       | 是         | int    | 4           | 跟进类别:<br>1=预约,<br>2=来电,<br>3=到访,<br> 4=认筹,<br>5=认购,<br>6=签约,<br>7=回款,<br>8=其他,<br>23=认购变更,<br>24=签约变更|
| mny              | 否         | float  |            | 认购金额、认筹金额、签约金额                |
| state            | 否         | int    |            | 状态：0:新增，1:退房，2:换房，3:作废，4:取消/撤消  |
| roomGUID         | 否         | string | 64         | 房间GUID                                    |
| room             | 否         | string | 128        | 楼栋号+”-”+房间号(车位号)                   |
| houseType        | 否         | string | 64         | 房型(店铺、车位、户型)                      |
| followGUID       | 否         | string | 64         | 跟进记录唯一标识，类型是 uuid               |
| cstInfos         | 存在时必需 | jsonArray  | N/A          | 客户列表                                    |
| cstInfos/cstname | 否         | string | 30         | 客户姓名                                    |
| cstInfos/tel     | 否         | string | 60         | 电话号码，多个以逗号分隔.                   |

+ **响应格式说明**

``` json
{

"errcode":0,

"errmsg":""

}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.4.10	N-BS-10无效推荐通知（cst_cancel_notify）
+ **接口说明**
数据中心将同享会新提交的无效推荐信息通知给案场
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "cst_cancel_notify"
    },
    "data": {
        "projCode": "1000000",
        "recommandTime": 1406851200,
        "agentClasses": 1,
        "agentName": "经纪人A",
        "agentMobile": "15800000000",
        "cstMobile": "13611111111",
        "cstName": "客户A",
        "cancelCause": "无效原因"
    }
}
```

+ **请求参数说明**

| 参数          | 是否必须 | 类型   | 长度 | 说明                      |
|---------------|----------|--------|------|---------------------------|
| projCode      | 是       | string | 64   | 转换后的项目code          |
| oriProjCode   | 是       | string | 32   | 原始项目code              |
| recommandTime | 是       | int    |      | 推荐时间                  |
| agentClasses  | 是       | Int    |      | 经纪人类型（代理公司 = 1,<br> 中介公司 = 2,<br>万科业主 = 3,<br>万科员工 = 4,<br>万科合作方 = 5,<br>独立经纪人 = 6）           |
| agentName     | 是       | string | 15   | 经纪人姓名                |
| agentMobile   | 是       | string | 16   | 经纪人电话                |
| cstMobile     | 是       | string | 16   | 客户电话                  |
| cstName       | 否       | string | 15   | 客户姓名                  |
| cancelCause   | 是       | string | 500  | 无效原因                  |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.4.11	N-BS-11客户推荐通知（recommend_notify）
+ **接口说明**
数据中心将同享会新提交的推荐客户信息、客户预约信息通知给案场。
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "recommend_notify"
    },
    "data": {
        "projCode": "5000000",
        "cstGUID": "1000000",
        "cstName": "客户A",
        "cstMobile": "15800000000",
        "recommendTime": "1404691200",
        "appointTime": "1404643532",
        "isAccompany": 1,
        "comment": "推荐备注",
        "productType": "产品类型名称",
        "proxyCompanyId": 1,
        "consultantId": 12,
        "agentId": 2,
        "agentName": "经纪人A",
        "agentMobile": "13600000000",
        "agentClasses": "经纪人类别名称",
        "prizeRule": "结佣规则",
        "sources": 1,
        "recommandType": 1
    }
}
```

+ **请求参数说明**

| 参数           | 是否必须   | 类型   | 长度 | 说明                        |
|----------------|------------|--------|------|-----------------------------|
| projCode       | 是         | string | 64   | 转换后的项目code            |
| oriProjCode    | 是         | string | 32   | 原始项目code                |
| cstGUID        | 是         | string | 20   | 客户ID                      |
| cstName        | 是         | string | 15   | 客户名字                    |
| cstMobile      | 是         | string | 16   | 客户电话                    |
| recommendTime  | 是         | int    | 10     | 推荐时间                    |
| appointTime    | 否         | int    | 10     | 预约上门时间                |
| isAccompany    | 否         | int    | 4     | 是否陪同上门（1是0否）      |
| comment        | 否         | string | 100  | 推荐备注                    |
| productType    | 推荐时必须 | string | 64   | 指定产品类型，自定义字符串  |
| proxyCompanyId | 否         | string | 64   | 指定代理公司ID              |
| consultantId   | 否         | string | 64   | 指定置业顾问ID              |
| agentId        | 推荐时必须 | int    |  10    | 经纪人ID                    |
| agentName      | 推荐时必须 | string | 15   | 经纪人名称                  |
| agentMobile    | 推荐时必须 | string | 16   | 经纪人电话                  |
| agentClasses   | 否         | int    | 4     | 经纪人类型（代理公司 = 1,<br>中介公司 = 2,<br>万科业主 = 3,<br>万科员工 = 4,<br>万科合作方 = 5,<br>独立经纪人 = 6）             |
| prizeRule      | 否         | string | 500  | 结佣规则                    |
| sources        | 否         | int    |  4    | 客户来源渠道（1同享会）     |
| recommandType  | 是         | int    |  4    | 推荐客户类型（1推荐 2预约） |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.4.12	P-BS-12干预状态上报（intervene_create）
+ **接口说明**
同享会将认为干预的推荐信息状态（有效、无效）上报到数据中心。
  - 1.修改客户推荐关系状态enable字段
  - 2.记录干预状态记录
  - 3.产生干预状态通知消息
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "intervene_create "
    },
    "data": {
        "projCode": "5000000",
        "cstGUID": "1000000",
        "agentGUID": "1000000",
        "status": 0,
        "comment": "备注",
        "reportTime": 1404691200
    }
}
```

+ **请求参数说明**

| 参数       | 是否必须 | 类型   | 长度 | 说明                                   |
|------------|----------|--------|------|----------------------------------------|
| projCode   | 是       | string | 64   | 项目code                               |
| cstGUID    | 是       | string | 20   | 客户ID                                 |
| agentGUID  | 是       | String | 20   | 推荐经纪人GUID                         |
| status     | 是       | int    |  4    | 状态，0为无效，1 为有效。与成功和失败状态不同，需要两个字段区别  |
| comment    | 否       | string | 500  | 备注                                   |
| reportTime | 是       | int    |  10    | 干预上报时间                           |
| expireTime | 否       | int    |  10    | 过期时间（保护期）                     |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.4.13	P-BS-13分配置业顾问上报（assign_create）
+ **接口说明**
案场将为来自同享会推荐的客户分配的置业顾问信息上报到数据中心。
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "assign_create"
    },
    "data": {
        "projCode": "5000000",
        "cstGUID": "1000000",
        "consultantId": 158000
    }
}
```

+ **请求参数说明**

| 参数         | 是否必须 | 类型   | 长度 | 说明       |
|--------------|----------|--------|------|------------|
| projCode     | 是       | string | 64   | 项目code   |
| cstGUID      | 是       | string | 20   | 客户ID     |
| consultantId | 是       | string | 64   | 置业顾问id |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

###4.4.4.14	N-BS-14干预状态通知（intervene_notify）
+ **接口说明**
数据中心将来自案场的干预状态信息通知给案场
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "intervene_notify"
    },
    "data": {
        "cstGUID": "1000000",
        "projCode": "1454354",
        "updatetime": 14542323,
        "status": 1,
        "comment": "备注"
    }
}
```

+ **请求参数说明**

| **参数**    | **是否必须** | **类型** | **长度** | **说明**                               |
|-------------|--------------|----------|----------|----------------------------------------|
| cstGUID     | 是           | string   | 20       | 客户ID                                 |
| projCode    | 是           | string   | 64       | 转换后的项目code                       |
| oriProjCode | 是           | string   | 32       | 原始项目code                           |
| updatetime  | 是           | int      | 10         | 时间                                   |
| Status      | 是           | int      | 4         | 状态，0为无效，1为有效。与成功和失败状态不同，需要两个字段区别  |
| Comment     | 否           | string   | 500      | 备注                                   |
| expireTime  | 否           | int      | 10         | 过期时间（保护期）                     |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| **参数** | **是否必须** | **类型** | **说明** |
|----------|--------------|----------|----------|
| errcode  | 是           | int      | 错误码   |
| errmsg   | 是           | string   | 错误描述 |

###4.4.15	P-BS-15销售机会新增(sales_leads_create)
+ **接口说明**
数据中心开放销售机会新增功能，接口由数据中心开放，数据中心同步往明源新增或修改
+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "sales_leads_create"
    },
    "data": {}
}
```

+ **请求参数说明**

| 参数         | 是否必须 | 类型   | 字段长度 | 说明                                         |
|--------------|----------|--------|----------|----------------------------------------------|
| cstGUID      | 是       | String | 40       | 明源客户ID                                   |
| projCode     | 是       | string | 40       | 项目code                                     |
| consultantId | 是       | string | 40       | 业务员ID，由数据中心负责进行与账号之间的转换 |
| oppSource    | 是       | string | 40       | 机会来源：来电/来访/其它                     |
| process      | 是       | String | 64       | 跟进过程：初次来电/初次来访                  |
| description  | 否       | String | 64       | 描述                                         |
| receiveDate  | 否         | string | 20       | 接待时间：格式2008-06-24 17:07:00            |
| flag         | 是         | int    |  4        | 数据标识：默认1                              |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明                           |
|---------|----------|--------|--------------------------------|
| errcode | 是       | int    | 错误码                         |
| errmsg  | 是       | string | 错误描述                       |
| oppID   | 否       | string | 新增成功后的机会ID(数据中心ID) |

###4.4.16	P-BS-16销售机会更新上报(sales_leads_update_report)
+ **接口说明**

+ **请求格式说明**

``` json
{
    "cmd": {
        "name": "sales_leads_update"
    },
    "data": {}
}
```

+ **请求参数说明**

| 参数         | 是否必须 | 类型   | 字段长度 | 说明                  |
|--------------|----------|--------|----------|-----------------------|
| oppID        | 是       | string | 64       | 数据中心机会ID        |
| projCode     | 是       | string | 64       | 项目编号              |
| consultantId | 是       | string | 40       | 置业顾问ID            |
| process      | 是       | String | 64       | 跟进过程，同上        |
| description  | 否       | String | 64       | 描述                  |
| status       | 是       | string | 20       | 状态:丢失、赢得、激活 |
| statusReason | 否       | string | 64         | 状态原因              |

+ **响应格式说明**

``` json
{
    "errcode": 0,
    "errmsg": ""
}
```

+ **响应参数说明**

| 参数    | 是否必须 | 类型   | 说明     |
|---------|----------|--------|----------|
| errcode | 是       | int    | 错误码   |
| errmsg  | 是       | string | 错误描述 |

#5.	错误码定义

##5.1系统错误码

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
| 1010   | 没有该接口的权限     |
| 1011   | 未知业务应用         |
| 1012   | 查询的记录不存在     |
| 1013   | 消息序列号重复       |
| 1014   | 响应返回数据格式错误 |
| 1015   | 消息序列号格式错误   |
| 1016   | 没有操作该项目的权限 |

##5.2业务错误码
业务错误码包含系统外的所有错误码，其中客户信息相关的错误码为2xxx段，经纪人相关错误码为3xxx段，基础数据错误码为4xxx段，客户行为服务类为5xx段。各业务可通用错误码为9xx段。

+ 5.2.1业务通用错误码

| 错误码 | 描述           |
|--------|----------------|
| 9001   | 非法身份证号码 |
| 9002   | 非法手机号码   |

+ 5.2.2客户类错误码

| 错误码 | 描述               |
|--------|--------------------|
| 2001   | 客户不存在         |
| 2002   | 客户已存在         |
| 2003   | 手机号码已被占用   |
| 2004   | 身份证号码已被占用 |

+ 5.2.3经纪人类错误码


+ 5.2.4基础数据类错误码

| 错误码 | 描述             |
|--------|------------------|
| 4001   | 项目不存在       |
| 4002   | 置业顾问不存在   |
| 4003   | 置业顾问已经存在 |
| 4004   | 代理公司已经存在 |
| 4005   | 代理公司不存在   |
| 4006   | 指定项目没有开通 |

+ 5.2.5客户行为服务类错误码


+ 5.2.6通知消息类错误码

| 错误码 | 描述         |
|--------|--------------|
| 6001   | 消息推送失败 |
