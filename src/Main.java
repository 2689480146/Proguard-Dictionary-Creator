import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    private static final String ROOT_PATH = "H:/";
    private static final String DictionaryName = "dic.txt";

    private static final int miniComplexity=10;
    private static final int maxComplexity=100;

    private static final int sumLength=300;

    private static final int maxNum=20000;

    public static void main(String[] args) throws Exception {
        List<String> result = getStrings(miniComplexity,maxComplexity,maxNum,sumLength);
        File file = new File(ROOT_PATH,DictionaryName);
        FileOutputStream fos = new FileOutputStream(file);
        for (String str : result) {
            fos.write(str.getBytes(StandardCharsets.UTF_8));
            fos.write('\n');
        }
        fos.flush();
        fos.close();
    }

    @SuppressWarnings("SameParameterValue")
    private static List<String> getStrings(int miniComplexity,int maxComplexity,int maxNum,int sumLength){ //最大复杂度
        int num=0;
        if(miniComplexity<0)
            throw new RuntimeException("混淆字典的最小复杂度应大于0");
        if(miniComplexity>sumLength)
            throw new RuntimeException("混淆字典的最小复杂度应小于混淆字典值的总长度");
        if(maxComplexity<miniComplexity)
            throw new RuntimeException("混淆字典的最大复杂度应大于或等于最小复杂度");
        if(maxComplexity>sumLength)
            throw new RuntimeException("混淆字典的最大复杂度应小于或等于混淆字典值得总长度");
        List<String> result=new ArrayList<>();
        for(int i=miniComplexity;i<=maxComplexity;i++){
            AddConst addConst=new AddConst(sumLength-i);
            String atFirst=MyList.getRandom(addConst.getValueA());
            String InTheEnd=MyList.getRandom(addConst.getValueB());
            MyList indexs=new MyList(i,atFirst,InTheEnd);
            if(maxNum>0 && ++num>maxNum)
                return result;
            result.add(indexs.toString());
            while(indexs.toNext()){
                if(maxNum>0 && ++num>maxNum)
                    return result;
                result.add(indexs.toString());
            }
        }
        return result;
    }
}

