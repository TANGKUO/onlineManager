--201907

--deepin深度liunx操作系统开发,搭建java开发环境


--安装edplus编辑器
sudo apt-get install wine

wine epp231_en.exe










--Linux搭建安装JDK


这里介绍两种linux环境下jdk的安装以及环境配置方法
在windows系统安装jdk以及环境配置，相信大家都会，这里就不做赘述了，这里主要讲讲linux下的jdk安装以及环境配置。

第一种属于傻瓜式安装，一键安装即可（yum安装）；
第二种手动安装，需要自己去Oracle官网下载需要的jdk版本，然后解压并配置环境，整个过程其实很简单。
一、yum一键安装
这种办法简单粗暴，就像盖伦丢技能一样。废话不多说，直接开始操作。

1.首先执行以下命令查看可安装的jdk版本：

yum -y list java*
1
执行成功后可看到如下界面：


2.选择自己需要的jdk版本进行安装，比如这里安装1.8，执行以下命令：

yum install -y java-1.8.0-openjdk-devel.x86_64
1
等待安装完成即可。

3.安装完成之后，查看安装的jdk版本，输入以下指令：

java -version
1
此处便可以看到自己安装的jdk版本信息。
你如果好奇这个自动安装把jdk安装到哪里去了，其实你可以在usr/lib/jvm下找到它们。
ok，完成！

二、手动安装

如果觉得yum一键安装不大好，其实可以手动安装的，个人建议还是手动安装更好，可以安装到想要安装的目录下，更能加深自己的体会。ok，接下里开始手动安装！

1.去Oracle官网下载需要安装的jdk版本，我这里用的是jdk-8u181-linux-x64.tar.gz
2.将该压缩包放到/usr/local/jdk目录下，jdk目录需要自己手动创建，也可以叫java，名字自己随意取（见名知意），然后解压该压缩包，输入如下指令：

tar zxvf jdk-8u181-linux-x64.tar.gz
1
解压成功后如下图所示：

3.接下来就该配置环境变量了，输入以下指令进行配置：

vim /etc/profile
1
输入完毕并回车，在文件尾部添加如下信息：

export JAVA_HOME=/usr/local/jdk/jdk1.8.0_181
export CLASSPATH=$:CLASSPATH:$JAVA_HOME/lib/ 
export PATH=$PATH:$JAVA_HOME/bin

注意：第一行的JAVA_HOME=/usr/local/jdk/jdk1.8.0_181 此处等号右边的是自己的jdk实际解压目录。如果不是该目录则需要改成自己的实际目录，其他不变。
实际情况如下图所示：

4.编辑完之后，保存并退出，然后输入以下指令，刷新环境配置使其生效：

source /etc/profile
1
5.查看jdk是否安装成功，输入指令java -version即可。

6.至此，手动安装完成~
--------------------- 

----------------------------
1、首先建立一个 jdk文件夹

root:/home# mkdir jdk
2、使用cd命令跳转到jdk目录下 ，然后进行把我们下载的jdk进行解压，使用的命令如下

 
root:/home/jdk# tar -zxvf jdk-8u131-linux-x64.tar.gz


3、 进入etc配置profile文件，并且使用vi打开配置文件。
      root:/home/jdk# cd /etc
      root:/etc# vi profile


/在上面打开的文件夹里面配置内容如下（注意路径）
export JAVA_HOME=/home/jdk/jdk1.8.0_131
export JAVA_BIN=/home/jdk/jdk1.8.0_131/bin
export PATH=$PATH:$JAVA_HOME/bin
export CLASSPATH=:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export JAVA_HOME JAVA_BIN PATH CLASSPATHSPH


4、执行一下，下面这条命令，使得我们的更改得以保存。
root:/etc# source profile
--------------------- 




--Linux搭建安装MAVEN





Linux 搭建安装Maven环境
1.前提条件：
1）下载并安装好JDK 。在终端输入命令“java -version”，如果出现类似如下信息说明JDK安装成功。

$ java -version

java version "1.7.0_45"
OpenJDK Runtime Environment (rhel-2.4.3.3.el6-x86_64 u45-b15)
OpenJDK 64-Bit Server VM (build 24.45-b08, mixed mode)
2）下载Eclipse。建议下载最新的JAVA开发版（我的是LUNA）。这样自动集成Maven插件。

2. 开始配置maven:
1）下载Maven，解压，移动文件目录

wget http://mirror.bit.edu.cn/apache/maven/maven-3/3.2.3/binaries/apache-maven-3.2.3-bin.tar.gz
tar vxf apache-maven-3.2.3-bin.tar.gz
mv apache-maven-3.2.3 /usr/local/maven3
2） 设置环境变量 ：

vim /etc/profile
在/etc/profile中添加以下几行

MAVEN_HOME=/usr/local/maven3

export MAVEN_HOME

export PATH=${PATH}:${MAVEN_HOME}/bin
执行source /etc/profile使环境变量生效

source /etc/profile
最后运行mvn -v验证maven是否安装成功，如果安装成功会打印如下内容

mvn -v
Apache Maven 3.2.3 (33f8c3e1027c3ddde99d3cdebad2656a31e8fdf4; 2014-08-12T04:58:10+08:00)

Maven home: /usr/local/maven3

Java version: 1.7.0_65, vendor: Oracle Corporation

Java home: /usr/lib/jvm/java-7-openjdk-amd64/jre

Default locale: en_US, platform encoding: UTF-8

OS name: "linux", version: "3.13.0-35-generic", arch: "amd64", family: "unix"

3. 建立maven仓库：
1） 建立一个文件夹，假设路径为： /usr/local/maven_repository。

2） 打开 /usr/local/maven3/conf/setting.xml 文件，设置我们的仓库路径：

复制代码
<!-- localRepository  
  | The path to the local repository maven will use to store artifacts.  
  |  
  | Default: ${user.home}/.m2/repository  
 <localRepository>/path/to/local/repo</localRepository>  
 -->  
 <localRepository>/usr/local/maven_repository</localRepository> 
复制代码
3）在终端运行命令将常用的包从maven中央仓库下载文件到本地：

  mvn help:system
4) 没有错误的话，打开 /usr/local/maven_repository 会发现多了很多文件。

 

 

 创建maven项目

mvn archetype:create -DgroupId=helloworld -DartifactId=helloworld
maven项目更新pom.xml后，需要执行mvn update ，本地更新maven项目会自动更新jar包

mvn update


--安装SVN,GIT



在Ubuntu / Ubuntu Kylin下安装和卸载 Nodepadqq
        对于Ubuntu发行版本可以通过PPA安装，命令如下：
sudo add-apt-repository ppa:notepadqq-team/notepadqq
sudo apt-get update
sudo apt-get install notepadqq
           类似的，卸载命令如下：

sudo apt-get remove notepadqq
sudo add-apt-repository --remove ppa:notepadqq-team/notepadqq




