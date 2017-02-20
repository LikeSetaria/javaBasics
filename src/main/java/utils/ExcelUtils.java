package utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pojo.ExcelInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by 宝超 on 2017/2/19.
 */
public class ExcelUtils {

    /**
     * 对外提供读取excel 的方法
     * */
    public static List<List<Object>> readExcel(File file) throws IOException {
        String fileName = file.getName();
        String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName
                .substring(fileName.lastIndexOf(".") + 1);
        if ("xls".equals(extension)) {
            return read2003Excel(file);
        } else if ("xlsx".equals(extension)) {
            return read2007Excel(file);
        } else {
            throw new IOException("不支持的文件类型");
        }
    }
    /**
     * 读取 office 2003 excel
     * @throws IOException
     * @throws java.io.FileNotFoundException
     */
    private static List<List<Object>> read2003Excel(File file)
            throws IOException {
        List<List<Object>> list = new LinkedList<List<Object>>();
        HSSFWorkbook hwb = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet sheet = hwb.getSheetAt(0);
        Object value = null;
        HSSFRow row = null;
        HSSFCell cell = null;
        int counter = 0;
        for (int i = sheet.getFirstRowNum(); counter < sheet
                .getPhysicalNumberOfRows(); i++) {
            row = sheet.getRow(i);
            if (row == null) {
                continue;
            } else {
                counter++;
            }
            List<Object> linked = new LinkedList<Object>();
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                if (cell == null) {
                    continue;
                }
                DecimalFormat df = new DecimalFormat("0");// 格式化 number String 字符
                SimpleDateFormat sdf = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
                DecimalFormat nf = new DecimalFormat("0.00");// 格式化数字
                switch (cell.getCellType()) {
                    case XSSFCell.CELL_TYPE_STRING:
                        System.out.println(i + "行" + j + " 列 is String type");
                        value = cell.getStringCellValue();
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        System.out.println(i + "行" + j
                                + " 列 is Number type ; DateFormt:"
                                + cell.getCellStyle().getDataFormatString());
                        if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                            value = df.format(cell.getNumericCellValue());
                        } else if ("General".equals(cell.getCellStyle()
                                .getDataFormatString())) {
                            value = nf.format(cell.getNumericCellValue());
                        } else {
                            value = sdf.format(HSSFDateUtil.getJavaDate(cell
                                    .getNumericCellValue()));
                        }
                        break;
                    case XSSFCell.CELL_TYPE_BOOLEAN:
                        System.out.println(i + "行" + j + " 列 is Boolean type");
                        value = cell.getBooleanCellValue();
                        break;
                    case XSSFCell.CELL_TYPE_BLANK:
                        System.out.println(i + "行" + j + " 列 is Blank type");
                        value = "";
                        break;
                    default:
                        System.out.println(i + "行" + j + " 列 is default type");
                        value = cell.toString();
                }
                if (value == null || "".equals(value)) {
                    continue;
                }
                linked.add(value);
            }
            list.add(linked);
        }
        return list;
    }
    /**
     * 读取Office 2007 excel
     * */
    private static List<List<Object>> read2007Excel(File file)
            throws IOException {
        List<List<Object>> list = new LinkedList<List<Object>>();
        // 构造 XSSFWorkbook 对象，strPath 传入文件路径
        XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
        // 读取第一章表格内容
        XSSFSheet sheet = xwb.getSheetAt(0);
        Object value = null;
        XSSFRow row = null;
        XSSFCell cell = null;
        int counter = 0;
        for (int i = sheet.getFirstRowNum(); counter < sheet
                .getPhysicalNumberOfRows(); i++) {
            row = sheet.getRow(i);
            if (row == null) {
                continue;
            } else {
                counter++;
            }
            List<Object> linked = new LinkedList<Object>();
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                if (cell == null) {
                    continue;
                }
                DecimalFormat df = new DecimalFormat("0");// 格式化 number String 字符
                SimpleDateFormat sdf = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
                DecimalFormat nf = new DecimalFormat("0.00");// 格式化数字
                switch (cell.getCellType()) {
                    case XSSFCell.CELL_TYPE_STRING:
                        System.out.println(i + "行" + j + " 列 is String type");
                        value = cell.getStringCellValue();
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        System.out.println(i + "行" + j
                                + " 列 is Number type ; DateFormt:"
                                + cell.getCellStyle().getDataFormatString());
                        if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                            value = df.format(cell.getNumericCellValue());
                        } else if ("General".equals(cell.getCellStyle()
                                .getDataFormatString())) {
                            value = nf.format(cell.getNumericCellValue());
                        } else {
                            value = sdf.format(HSSFDateUtil.getJavaDate(cell
                                    .getNumericCellValue()));
                        }
                        break;
                    case XSSFCell.CELL_TYPE_BOOLEAN:
                        System.out.println(i + "行" + j + " 列 is Boolean type");
                        value = cell.getBooleanCellValue();
                        break;
                    case XSSFCell.CELL_TYPE_BLANK:
                        System.out.println(i + "行" + j + " 列 is Blank type");
                        value = "";
                        break;
                    default:
                        System.out.println(i + "行" + j + " 列 is default type");
                        value = cell.toString();
                }
                if (value == null || "".equals(value)) {
                    continue;
                }
                linked.add(value);
            }
            list.add(linked);
        }
        return list;
    }
    public static void main(String[] args) throws Exception{
        List<List<Object>> excel1=null;
        List<List<Object>> excel2=null;
        List<List<Object>> excel3=null;
        List<List<Object>> excel4=null;

        try {
            excel1 = readExcel(new File("E:\\Desktop\\2017毕设\\豆瓣电影-784-1175行-陈思仪.xlsx"));
            excel2 = readExcel(new File("E:\\Desktop\\2017毕设\\豆瓣电影-2013301500044-席颖.xlsx"));
            excel3 = readExcel(new File("E:\\Desktop\\2017毕设\\豆瓣电影-2013301500063-刘思璇.xlsx"));
            excel4 = readExcel(new File("E:\\Desktop\\2017毕设\\豆瓣电影-2013301500070-汤桂烽.xlsx"));

            // readExcel(new File("D:\\test.xls"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(excel1.size()+"  "+excel2.size()+"  "+excel3.size()+" "+excel4.size());
        excel1.addAll(excel2);
        excel1.addAll(excel3);
        excel1.addAll(excel4);
        System.out.println(excel1.size());
        StringBuilder stab=new StringBuilder();
        StringBuilder sta=new StringBuilder();
        for(List<Object> list:excel1) {
            if (list.size() > 1) {
                if (!list.get(1).equals("是")) {
                    sta.append(list.get(0).toString().replace(".00",""));
                    sta.append("\n");
                     //System.out.println(list.toString().replace(".00", "").replace("[", "").replace("]", ""));
//                    stab.append(list.get(0).toString().replace(".00", "") + "\t");
//                    stab.append(list.get(1).toString() + "\t");
//                    stab.append(list.get(2).toString() + "\t");
//                    stab.append(list.get(3).toString());
                    if(excel2.contains(list)) {
                        stab.append(list.toString().replace(".00", "").replace("[", "").replace("]", ""));
                        stab.append("     ,2013301500044-席颖");
                    }else if(excel3.contains(list)){
                        stab.append(list.toString().replace(".00", "").replace("[", "").replace("]", ""));
                        stab.append("      ,2013301500063-刘思璇");
                    }
                    else if(excel4.contains(list)){
                        stab.append(list.toString().replace(".00", "").replace("[", "").replace("]", ""));
                        stab.append("      ,2013301500070-汤桂烽");
                    }
                    else{
                        stab.append(list.toString().replace(".00", "").replace("[", "").replace("]", ""));
                        stab.append("      ,陈思仪");
                    }
                    stab.append("\n");
                }
            }
            else {
                stab.append(list.toString().replace(".00","").replace("[","").replace("]",""));
                stab.append("\n");
                System.out.println(list);
            }
        }
        FileUtils.write(new File("E:\\Desktop\\2017毕设\\豆瓣电影_非垃圾用户.txt"),stab);
        FileUtils.write(new File("E:\\Desktop\\2017毕设\\豆瓣电影_非垃圾用户_uid.txt"),sta);

    }

}
