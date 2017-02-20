package pojo;

/**
 * Created by 宝超 on 2017/2/19.
 */
public class ExcelInfo {

    private String row1;
    private String row2;
    private String row3;
    private String row4;


    public String getRow1() {
        return row1;
    }

    public void setRow1(String row1) {
        this.row1 = row1;
    }

    public String getRow2() {
        return row2;
    }

    public void setRow2(String row2) {
        this.row2 = row2;
    }

    public String getRow3() {
        return row3;
    }

    public void setRow3(String row3) {
        this.row3 = row3;
    }

    public String getRow4() {
        return row4;
    }

    public void setRow4(String row4) {
        this.row4 = row4;
    }

    @Override
    public String toString() {
        return "ExcelInfo{" +
                "row1='" + row1 + '\'' +
                ", row2='" + row2 + '\'' +
                ", row3='" + row3 + '\'' +
                ", row4='" + row4 + '\'' +
                '}';
    }
}
