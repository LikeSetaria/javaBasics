package algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zzz on 2017/3/11.
 */
public class UpdateFileMD5 {
    static String[] suffix={"avi","rmvb","rm","asf","divx","mpg","mpeg","mpe","wmv","mp4","mkv","vob"};
    static List<String> filesName=new ArrayList<String>();
    public static void main(String[] args) {
       List<File> file=getFileList("K:\\download\\");
        Set<String> suffixSet=new HashSet<String>();
        List<String> fileName=dir(new File("K:\\download\\"));
        for(String s:suffix)
            suffixSet.add(s.trim());
        for(String s:fileName){
            File f=new File(s);
            for(String ss:suffixSet){
                if(f.getName().contains(ss)){
                    method2(f.getAbsolutePath(), "                                ");
                    System.out.println(f);
                }
            }
        }


		/*F4D9D6CD648EA181825E21A22F3EB98A
		 * 2EC9E30BA256925C7BF446B97EE0BD20
		   System.out.println("start");
	        method1("F:\\迅雷下载\\BEB-078.mp4", "                              ");
	        System.out.println("end"); */
    }
/*
 * 方法一打开
 */

    public static void method1(String file, String conent) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            out.write(conent);
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void method2(String fileName, String content) {
        try {
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method3(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    filterSuffix
     */
    public static List<File> filterSuffix(List<File> list){
        List<File> result=new ArrayList<File>();
        Set<String> suffixSet=new HashSet<String>();
        for(String s:suffix)
        suffixSet.add(s.trim());
        for(File f:list){
            String fileName=f.getName();
            for(String s:suffixSet){
                //System.out.println(fileName);
                if(fileName.contains(s)){
                    result.add(f);

                }
            }

        }
        return result;
    }

    /**
     * 遍历文件夹
     * @param strPath
     * @return
     */

    public static List<File> getFileList(String strPath) {
        File dir = new File(strPath);
        List<File> fileList=new ArrayList<File>();
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
                } else if (true) { // 判断文件名是否以.avi结尾
                    String strFileName = files[i].getAbsolutePath();
                    //System.out.println( strFileName);
                    fileList.add(files[i]);
                } else {
                    continue;
                }
            }
        }
        return fileList;
    }


    public static List<String> dir(File f){
        //获得当前路径下的所有文件和文件夹

        File[] allFiles = f.listFiles();
        //循环所有路径
        for(int i = 0;i < allFiles.length;i++){
            //如果是文件夹
            if(allFiles[i].isDirectory()){
                //递归调用
                dir(allFiles[i]);
            }else{ //文件
                //执行操作，例如输出文件名
               // System.out.println(allFiles[i].getAbsoluteFile());
                filesName.add(allFiles[i].getAbsolutePath());
            }
        }
        return filesName;
    }

}
