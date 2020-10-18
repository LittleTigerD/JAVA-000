package com.geekjava0study.demo.week1;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URLClassLoader;

/**
 * 功能描述:
 *
 * @Author: 窦虎
 * @Date: 2020/10/18 22:28
 */
public class DouhuClassLoader extends ClassLoader{

    /**
     * 加载的类路径，只需要.class或者.xclass当前目录即可
     */
    private String path;

    /**
     * 功能描述: 空参构造
     * @Param: []
     * @Return:
     * @Author: 窦虎
     * @Date: 2020/10/18 23:51
     */
    public DouhuClassLoader() {
    }

    /**
     * 功能描述: 带参数构造
     * @Param: [path]
     * @Return:
     * @Author: 窦虎
     * @Date: 2020/10/18 23:51
     */
    public DouhuClassLoader(String path) {
        this.path = path;
    }

    // get/set
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    // main方法
    public static void main(String[] args) throws Exception {

        Class<?> aClass = new DouhuClassLoader("C:/Users/63272/Downloads/Hello/").findClass("Hello");
        Object instance = aClass.newInstance();
        Method hello = aClass.getMethod("hello");
        hello.invoke(instance);
    }



    /**
     * 功能描述: 重写类加载器的findClass
     * @Param: [name]
     * @Return: java.lang.Class<?>
     * @Author: 窦虎
     * @Date: 2020/10/18 23:07
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取该class文件字节码数组
        byte[] classData = getData(name);

        if (classData != null) {

            //
            for (int i = 0; i < classData.length; ++i) {
                classData[i] = (byte) (255 - classData[i]);
            }
            // 将class的字节码数组转换成Class类的实例
            return defineClass(name, classData, 0, classData.length);
        }
        return null;
    }

    /**
     * 功能描述: 
     * @Param: [name]
     * @Return: byte[]
     * @Author: 窦虎
     * @Date: 2020/10/18 23:07
     */
    private byte[] getData(String name) {

        // path是任意路径 name为类型名 后缀是作业的.xclass，后缀可以改为指定
        File file = new File(path + name + ".xlass");
        if (file.exists()){
            FileInputStream in = null;
            ByteArrayOutputStream out = null;
            try {
                in = new FileInputStream(file);
                out = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];
                int size = 0;
                while ((size = in.read(buffer)) != -1) {
                    out.write(buffer, 0, size);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
            return out.toByteArray();
        }else{
            return null;
        }


    }

}
