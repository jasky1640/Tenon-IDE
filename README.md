# IDE

IDE for quantum program development and compilation.

## 基础版本

### Eclipse 2019.03
[Linux](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2019-03/R/eclipse-committers-2019-03-R-linux-gtk-x86_64.tar.gz&amp;mirror_id=1142)

[Mac](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2019-03/R/eclipse-committers-2019-03-R-macosx-cocoa-x86_64.dmg&mirror_id=1142)

[Windows](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2019-03/R/eclipse-committers-2019-03-R-win32-x86_64.zip&mirror_id=1142)

## 文件

### tenon 

tenon编译器及其文档

### plugins

生成好的插件jar包

### tenon_IDE

tenon Eclipse插件的源代码

### EditorAction

Eclipse插件的依赖文件

## 插件安装

 1. 复制 *./plugins/TenonEditor_XXX.jar* 到 *Eclipse安装目录/pulgins/* 目录下
 2. 启动/重启Eclipse

## 插件使用

### V1.0
实现了Tenon编辑器代码高亮和编译器调用功能

#### 编译.t文件并查看执行结果：

两种方式
 - 在.t文件页面单击右键，单击“Tenon编译”按钮
 - 直接单击工具栏中 “T” 图标

下方Console窗口中显示运行的编译指令及执行结果

![安装插件后的Eclipse](pic/V1.0.png)

### V1.1
实现了部分Debug视图和Tvm模式调试功能

#### 打开Debug视图，查看断点的变量：

两种方法
 - 在.t文件页面单击右键，单击“Tenon调试”按钮
 - 直接单击工具栏中 “爬虫” 图标
 
右侧窗口中显示变量视图和断点视图（断点视图暂时为占位符）
![安装插件后的Eclipse](pic/V1.1_Debug_View.png)

#### 进入Tvm模式调试程序

打开方式: 在.t文件页面单击右键，单击“Tvm模式开启”按钮

进入Tvm模式后，支持
 - 在Tvm模式下运行程序
 - 设置断点
 - 下一步（跳过断点）
 - 退出Tvm模式

不支持自定义断点功能，目前断点设置硬编码为第五行。自定义断点功能将于下个版本实现。

![安装插件后的Eclipse](pic/V1.1_Tvm.png)