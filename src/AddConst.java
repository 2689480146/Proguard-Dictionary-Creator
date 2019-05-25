public class AddConst{
    private int sum;

    private int valueA;
    private int valueB;

    private int limitA;
    private int limitLength;

    public AddConst(int sum){
        this.sum=sum;
        limitA=sum>>2;
        limitLength=sum>>1;
        refresh();
    }

    public int getValueA() {
        return valueA;
    }

    public int getValueB() {
        return valueB;
    }

    private void refresh(){
        valueA=(int)(Math.random()*limitLength)+limitA;
        valueB=sum-valueA;
    }
}
