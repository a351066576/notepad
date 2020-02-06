一．	运行
1.	执行notepad.sql文件导入表结构和数据
2.	导入notepad项目。
3.	修改src\main\resources\application.properties文件中的mysql配置  
   修改src\main\resources\application.properties文件中的redis配置
4.	启动redis
5.	启动src\main\java\com\m\notepad下的NotepadApplication.java类
6.	访问localhost:8080/druid可进行数据监控，用户名druid，密码druid123
7.	访问http://localhost:8080/main 可进入日记本系统。  
   普通用户名：mzq   密码：123  
   管理员用户名：admin   密码：123  
   管理员进入首页可以查看系统日志，普通用户没有权限查看。

二．	项目介绍
1.	项目模块  
 annotation：注解模块，存放@Log注解  
 aspect：切面模块，存放日志切面  
 congif：配置模块，用于存放redis的配置类  
 controller：控制层  
 dao：持久化层  
 domain：用于存放实体类  
 security：存放spring security的管理类  
 service：业务接口  
 serviceImpl：业务实现类  
 sql：存放sql类  
 utils：公共工具类  



