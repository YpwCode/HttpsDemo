# HttpsDemo
 
基于 SpringBoot, 支持 https 和 http

## 1/证书
```shell script
keytool -genkeypair -keystore "./myKeystore.keystore" -keypass "123456" -storepass "123456" -alias "tomcat" -keyalg "RSA" -validity 180 -dname "CN=localhost, OU=localhost, O=localhost, L=SH, ST=SH, C=CN" 
```

### 1.1/参数说明：
```
-genkeypair: 表示要创建一个新的密钥
-dname: 表示密钥的Distinguished Names, 表明了密钥的发行者身份
　　CN=commonName 注: 生成证书时, CN要和服务器的域名相同，如果在本地测试, 则使用localhost
　　OU=organizationUnit
　　O=organizationName
　　L=localityName
　　S=stateName
　　C=country
-keyalg:使用加密的算法, 这里是RSA
-alias: 和 keystore 关联的别名, 这个alias通常不区分大小写
-keypass: 私有密钥的密码, 这里设置为 123456
-keystore: 密钥保存在当前目录下的 myKeystore 文件中
-storepass: 存取密码，这里设置为 123456, 这个密码提供系统从 myKeystore 文件中将信息取出
-validity: 该密钥的有效期为 180天 (默认为90天)
```

下面是各选项的缺省值:
```
-alias: "mykey"
-keyalg: "DSA"
-keysize: 1024
-validity: 90
-keystore: 用户宿主目录中名为 .keystore 的文件
-file: 读时为标准输入, 写时为标准输出 
```
 
## 2/项目配置

- 创建证书并复制到 resources/static 目录下
- 修改 application.yml 配置

