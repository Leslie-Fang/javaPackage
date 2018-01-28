## 目的：
将project1中的代码编译成package放到lib目录中
project2中使用project1中编写的类

## 编译project1
创建src以及class两个目录
### src目录
编写源代码
如果需要将对应的类打包，在文件的第一行指定要打包的包的名字:package intel.dcg.leslie;
编译：
```
javac -d ../class ./intel/dcg/leslie/main.java ./intel/dcg/leslie/animal.java 

```
测试主类是否可以运行
```
cd ../class
java intel.dcg.leslie.main
```

### class目录
在class目录中创建MANIFEST.MF文件，指定主入口类
MANIFEST.MF文件在Main-Class:后一定是空格，然后在这一行的结束一定要换行，再保存
打包
```
jar -cvmf MANIFEST.MF ../../lib/animal.jar ./intel/dcg/leslie/*
```
测试这个包是否可以运行：
```
cd ../../lib/
java -jar animal.jar 
```

## 编译project2
创建src以及class两个目录
### src目录
编写dog类
引入这个animal的包
```
import intel.dcg.leslie.animal;
```
直接编译会报错找不到这个intel.dcg.leslie.animal的包
有两种解决办法：
1. 直接将project1对应的包的源代码的文件夹copy到project2的src目录下面
2. 设置sourcepath到project1对应的包的源代码的文件夹
```
javac -sourcepath /Users/leslie/testcode/java/rawTestcode/project1/src/ dog.java 
```
3. 设置classpath到project1对应的包的类代码的文件夹
```
javac -classpath /Users/leslie/testcode/java/rawTestcode/project1/class/ dog.java 
```
4. 设置classpath环境变量到这个包的路径

```
export CLASSPATH=$CLASSPATH:/Users/leslie/testcode/java/rawTestcode/lib/animal.jar
javac -d ../class main.java dog.java 
```
编译这个文件到class路径:
5. 带上jar编译
```
javac -classpath /Users/leslie/testcode/java/rawTestcode/lib/animal.jar dog.java
```

运行注意导入过的包的源代码之前也需要设置环境变量CLASSPATH到导入的包
