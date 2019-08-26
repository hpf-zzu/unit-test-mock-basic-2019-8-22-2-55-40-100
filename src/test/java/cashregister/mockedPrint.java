package cashregister;

public class mockedPrint extends Printer {
    public String tempText;
    public void print(String tempText1){
      //  super.print(tempText);
        tempText = tempText1;
    }
    public String getTempTest() {
        return tempText;

    }
}
