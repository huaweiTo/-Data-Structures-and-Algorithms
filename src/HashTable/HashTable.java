package HashTable;

import java.io.InputStream;
import java.util.Arrays;

public class HashTable {
    private StuInfo[] data=new StuInfo[100];//随便设置数字大小,不能太大会溢出

    /**
     * 向散列表中添加元素
     * @param stuInfo
     */
    public void put(StuInfo stuInfo){
        //调取散列函数获取存储位置
        int index=stuInfo.hashcode();
        data[index]=stuInfo;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

    public StuInfo get(StuInfo stuInfo){
       return data[stuInfo.hashcode()];
    }
}
