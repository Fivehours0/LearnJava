package ioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * File类 File能新建，删除，重命名文件和目录，但File不能访问文件内容本身。如果需要访问文件内容本身，则需要使用输入/输出流
 * Flie对象可以作为参数传递给流的构造函数 File类常见的构造方法 public File(String pathname)
 */
public class ioStream {
    public static void main(String[] args){
        // 使用双斜杠或者反斜杠
        String pathname = "D:\\java\\content.txt";
        File f = new File(pathname);
        /**
         * 访问文件名 */
        // System.out.println(f.getName()); // 文件名
        // System.out.println(f.getPath()); // 获取new file时写的路径
        // System.out.println(f.getAbsolutePath()); // 获取绝对路径  
        // System.out.println(f.getParent()); // 获取父路径
        // f.renameTo(new File("D:\\java\\New.txt")); // 重命名
        /**
         * 文件检测
         */
        // System.out.println(f.exists()); // 检测文件或者文件夹是否存在
        // System.out.println(f.canRead()); // 检测文件是否可读
        // System.out.println(f.canWrite()); // 检测文件是否可写
        // System.out.println(f.isFile()); // 检测是否为文件
        // System.out.println(f.isDirectory()); // 检测是否为文件夹
        // System.out.println(f.lastModified()); // 最后的修改时间
        // System.out.println(f.length()); // 返回文件的字节数
        /**
         * 文件操作相关
         */
        // File f1 = new File(f.getParent() + File.separator + "new.txt");
        // System.out.println(f1.getPath());
        // System.out.println(f1.exists());
        // if(!f1.exists()) {
        //     try{
        //         f1.createNewFile(); // 创建新文件
        //     } catch(IOException e) {
        //         e.printStackTrace();
        //     }
        // }
        // f1.delete(); // 删除文件
        // File f2 = new File("D:\\java\\aa"); // 当前并没有aa目录
        // // f2.mkdir(); // 创建单层目录
        // // f2.mkdirs(); // 创建多层目录
        // File f3 = new File(f2.getParent());
        // String[] string = f3.list(); // 返回当前文件夹中的目录和文件
        // for(String s: string){
        //     System.out.println(s);
        // }
        // File[] string1 = f3.listFiles(); // 返回当前文件夹中目录和文件的file
        ioStream recurrenceTest = new ioStream();
        File recuFile = new File("D:\\java");
        recurrenceTest.test(recuFile);
    }   

    /**
     * 递归遍历文件
     * 遍历d盘下的java文件，把java文件下的所有的目录与文件全部遍历出来，不论层级有多深，都全部遍历出来
     */
    public void test(File f){
        if(f.isFile()) {
            System.out.println(f.getAbsolutePath() + "  " + "是文件");
        } else {
            System.out.println(f.getAbsolutePath() + "  " + "是文件夹");
            File[] files = f.listFiles();
            if(files != null && files.length > 0) {
                for(File fi: files) {
                    test(fi);
                }
            }
        }
    }
}

/**
 * 文件流
 */
class FileInput{
    public static void main(String[] arg){
        FileInputStream in = new FileInputStream(file)
    }
}
