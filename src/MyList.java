import java.util.ArrayList;

public class MyList extends ArrayList<Integer> {
    private static final String[] chars={"O","0"};

    private int maxComplexity;
    private String atFirst;
    private String inTheFirst;

    public MyList(int maxComplexity,String appendAtFirst,String appendInTheEnd){
        if(maxComplexity<=0)
            throw new RuntimeException("混淆字典的最小复杂度应大于0");
        this.maxComplexity=maxComplexity;
        this.atFirst=appendAtFirst;
        this.inTheFirst=appendInTheEnd;
        for(int i=0;i<maxComplexity;i++){
            add(0);
        }
    }

    public boolean toNext(){
        for(int i=maxComplexity-1;i>0;i--){ //首位不改变，全部使用O，能增大阅读难度
            if(get(i)!=chars.length-1){
                set(i,get(i)+1);
                for(int m=i+1;m<maxComplexity;m++)
                    set(m,0);
                return true;
            }
        }
        return false;
    }

    public static String getRandom(int num){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<num;i++){
            stringBuilder.append(chars[(int)(Math.random()*chars.length)]);
        }
        return stringBuilder.toString();
    }

    public String toString() {
        StringBuilder ret= new StringBuilder();
        ret.append(atFirst);
        for (Integer integer : this) {
            ret.append(chars[integer]);
        }
        ret.append(inTheFirst);
        return ret.toString();
    }
}
